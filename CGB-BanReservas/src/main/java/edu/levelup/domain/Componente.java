/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.levelup.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author jhony
 */
public class Componente implements Serializable{
    private int idComp;
    private String nombreComp;
    private String descripcionComp;
    private BigDecimal precioComp;
    private int stockComp;
    
    public Componente() {
    }

    public Componente(int idComp, String nombreComp, String descripcionComp, BigDecimal precioComp, int stockComp) {
        this.idComp = idComp;
        this.nombreComp = nombreComp;
        this.descripcionComp = descripcionComp;
        this.precioComp = precioComp;
        this.stockComp = stockComp;
    }
    
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Componente that = (Componente) o;
        return getIdComp() == that.getIdComp() &&
                getStockComp() == that.getStockComp() &&
                Objects.equals(getNombreComp(), that.getNombreComp()) &&
                Objects.equals(getDescripcionComp(), that.getDescripcionComp()) &&
                Objects.equals(getPrecioComp(), that.getPrecioComp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdComp(), getNombreComp(), getDescripcionComp(), getPrecioComp(), getStockComp());
    }

    @Override
    public String toString() {
        return "Componente{" + "idComp=" + idComp + ", nombreComp='" + nombreComp + '\'' + ", descripcionComp='" + descripcionComp + '\'' + ", precioComp=" + precioComp + ", stockComp=" + stockComp + '}';
    }
}