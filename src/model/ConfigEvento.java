/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Erika
 */

public class ConfigEvento {
    
    private static ConfigEvento instancia;
    private String nombreEvento;

    private ConfigEvento() {
        nombreEvento = "Conferencia Nacional de Tecnología 2025";
    }

    public static ConfigEvento getInstancia() {
        if (instancia == null) {
            instancia = new ConfigEvento();
        }
        return instancia;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
}


