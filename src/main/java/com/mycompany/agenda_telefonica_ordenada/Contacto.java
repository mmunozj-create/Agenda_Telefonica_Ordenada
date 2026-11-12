/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agenda_telefonica_ordenada;

import java.util.Arrays;
import java.util.Comparator;

class Contacto {
    private String nombre;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }

    @Override
    public String toString() {
        return "Contacto{" + "nombre='" + nombre + '\'' + ", telefono='" + telefono + '\'' + ", correo='" + correo + "'}";
    }
}