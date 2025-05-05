/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Erika
 */

public class Credencial implements Cloneable {
    
    private String nombre;
    private String cargo;
    private String rut;

    public Credencial(String nombre, String cargo, String rut) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void mostrar() {
        System.out.println("Credencial");
        System.out.println("Nombre: " + nombre);
        System.out.println("Cargo: " + cargo);
        System.out.println("RUT: " + rut);
        System.out.println("----------------------");
    }

    @Override
    public Credencial clone() {
        try {
            return (Credencial) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clonación no soportada");
        }
    }
}

