package edu.levelup.view;

import edu.levelup.domain.Componente;
import edu.levelup.service.ComponenteService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.PrimeFaces;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.Visibility;

@Named(value = "componenteView")
@ViewScoped
public class ComponenteView implements Serializable {

    private List<Componente> componentes;
    private List<Componente> selectedComponentes;
    private Componente selectedComponente;
    private ComponenteService componenteService;
    private String deleteButtonMessage;

    public ComponenteView() {
        selectedComponente = new Componente();
        selectedComponentes = new ArrayList<>();
        componenteService = new ComponenteService();
        deleteButtonMessage = "Delete";
    }

    @PostConstruct
    public void init() {
        this.componentes = componenteService.getComponentes();
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    public void updateComponentes() {
        this.componentes = componenteService.getComponentes();
    }

    public Componente getSelectedComponente() {
        return selectedComponente;
    }

    public void setSelectedComponente(Componente selectedComponente) {
        this.selectedComponente = selectedComponente;
    }

    public void saveComponente() {
        if (selectedComponente.getIdComp()== 0) {
            try {
                componenteService.crearComponente(selectedComponente);
                componentes.add(selectedComponente);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Componente agregado"));
            } catch (RuntimeException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
            }
        } else {
            try {
                componenteService.actualizarComponente(selectedComponente);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Componente actualizado"));
            } catch (RuntimeException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
            }
        }

        PrimeFaces.current().executeScript("PF('manageComponenteDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-componentes");
    }

    public List<Componente> getSelectedComponentes() {
        return selectedComponentes;
    }

    public void setSelectedComponentes(List<Componente> selectedComponentes) {
        this.selectedComponentes = selectedComponentes;
    }

    public ComponenteService getComponenteService() {
        return componenteService;
    }

    public void setComponenteService(ComponenteService componenteService) {
        this.componenteService = componenteService;
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedComponentes()) {
            int size = this.selectedComponentes.size();
            return size > 1 ? size + " componentes seleccionados" : "1 componente seleccionado";
        }

        return deleteButtonMessage;
    }

    public boolean hasSelectedComponentes() {
        return this.selectedComponentes != null && !this.selectedComponentes.isEmpty();
    }

    public void openNew() {
        selectedComponente = new Componente();
        selectedComponente.setNombreComp("");
        selectedComponente.setDescripcionComp("");
        selectedComponente.setPrecioComp(BigDecimal.ZERO);
        selectedComponente.setStockComp(0);
        PrimeFaces.current().executeScript("PF('manageComponenteDialog').show()");
    }

    public void onRowToggle(ToggleEvent event) {
        if (event.getVisibility() == Visibility.VISIBLE) {
            Componente ed = (Componente) event.getData();
        }
    }

    public void deleteSelected() {
        List<Integer> selectedIds = new ArrayList<>();

        if (hasSelectedComponentes()) {
            for (Componente componente : selectedComponentes) {
                selectedIds.add(componente.getIdComp());
                componentes.remove(componente);
            }
            componenteService.borrarComponentes(selectedIds);
            selectedComponentes.clear();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Componentes eliminados"));
        } else if (selectedComponente != null) {
            selectedIds.add(selectedComponente.getIdComp());
            componenteService.borrarComponentes(selectedIds);
            componentes.remove(selectedComponente);
            selectedComponente = null;
            PrimeFaces.current().ajax().update("dt-componentes");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Componente eliminado"));
        }

        PrimeFaces.current().ajax().update("dt-componentes");
        PrimeFaces.current().executeScript("PF('deleteProductDialog').hide()");
    }
    

  








    
    
   }