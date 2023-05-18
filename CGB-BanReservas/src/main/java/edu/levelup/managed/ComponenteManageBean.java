/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.levelup.managed;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author jhony
 */
@Named(value = "componenteManagedBean")
@ViewScoped
public class ComponenteManageBean implements Serializable{
    
    private int idComp;
    private String nombreComp;
    private String descripcionComp;
    private BigDecimal precioComp;
    private int stockComp;

    public int getIdComp() {
        return idComp;
    }

    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }

    public String getNombreComp() {
        return nombreComp;
    }

    public void setNombreComp(String nombreComp) {
        this.nombreComp = nombreComp;
    }

    public String getDescripcionComp() {
        return descripcionComp;
    }

    public void setDescripcionComp(String descripcionComp) {
        this.descripcionComp = descripcionComp;
    }

    public BigDecimal getPrecioComp() {
        return precioComp;
    }

    public void setPrecioComp(BigDecimal precioComp) {
        this.precioComp = precioComp;
    }

    public int getStockComp() {
        return stockComp;
    }

    public void setStockComp(int stockComp) {
        this.stockComp = stockComp;
    }
    
}