
package edu.levelup.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author jhony
 */
@Getter
@Setter
@JsonSerialize
public class Componente {
    private int idComp;
    private String nombreComp;
    private String descripcionComp;
    private BigDecimal precioComp;
    private int stockComp;

    public int getStockComp() {
        return stockComp;
    }

    public void setStockComp(int stockComp) {
        this.stockComp = stockComp;
    }

    public BigDecimal getPrecioComp() {
        return precioComp;
    }

    public void setPrecioComp(BigDecimal precioComp) {
        this.precioComp = precioComp;
    }

    public String getDescripcionComp() {
        return descripcionComp;
    }

    public void setDescripcionComp(String descripcionComp) {
        this.descripcionComp = descripcionComp;
    }

    public String getNombreComp() {
        return nombreComp;
    }

    public void setNombreComp(String nombreComp) {
        this.nombreComp = nombreComp;
    }

    public int getIdComp() {
        return idComp;
    }

    public void setIdComp(int idComp) {
        this.idComp = idComp;
    }
}