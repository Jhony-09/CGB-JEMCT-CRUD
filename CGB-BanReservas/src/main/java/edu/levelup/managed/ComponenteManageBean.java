/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.levelup.managed;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author jhony
 */
@Getter
@Setter
public class ComponenteManageBean{
    
    private int idComp;
    private String nombreComp;
    private String descripcionComp;
    private BigDecimal precioComp;
    private int stockComp;

    
}