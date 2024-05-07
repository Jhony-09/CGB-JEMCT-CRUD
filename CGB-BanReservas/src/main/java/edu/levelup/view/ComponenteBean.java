package edu.levelup.view;

import edu.levelup.domain.Componente;
import edu.levelup.service.ComponenteService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.core.Response;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

@Named
@ViewScoped
public class ComponenteBean implements Serializable {

    @Getter
    @Setter
    private Componente componente;

    @Getter
    @Setter
    private List<Componente> componentes;

    @Getter
    @Setter
    private List<Componente> componentesFiltro;

    @Getter
    @Setter
    private char[] acc;

    @Getter
    @Setter
    private String view;

    @Getter
    @Setter
    private int rating;

    @Getter
    @Setter
    private boolean flagEli;

    @Inject
    private ComponenteService componenteService;


    @PostConstruct
    public void init(){
        filtrar();
        back();
    }

    private void filtrar(){

        if (componenteService != null){
            componentes = componenteService.getComponentes();
        }else {
            System.out.println("Es nulo componente Service");
        }

    }

    public void mostrar(Componente com, String op){
        agregar();
        componente = com;
        view= op;
        if ("L".equals(op)){
        }else if("E".equals(op)){

        }
    }


    public void agregar(){
        componente = new Componente();
        flagEli = false;
        view = "A";
    }


    public void insertar(){
        ComponenteService com = new ComponenteService();
        int res =  com.crearComponente(componente);
        if (res > 0){
            FacesContext context = FacesContext.getCurrentInstance();
            String mensaje = "¡El registro se ha insertado correctamente!";
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", mensaje));
            filtrar();
            back();
        }


    }


    public void modificar(){
        ComponenteService com = new ComponenteService();
        int res = com.actualizarComponente(componente);
        if (res > 0){
            FacesContext context = FacesContext.getCurrentInstance();
            String mensaje = "¡El registro se ha modificado correctamente!";
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", mensaje));
            filtrar();
            back();
        }
    }

    public void eliminar(){
        ComponenteService com = new ComponenteService();
        int res = com.borrarComponentes(componente);
        if (res > 0){
            FacesContext context = FacesContext.getCurrentInstance();
            String mensaje = "¡El registro se ha eliminado correctamente!";
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", mensaje));
            filtrar();
            back();
        }

    }

    public void back(){
        view = "C";
    }
}
