/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.agenda_telefonica_ordenada;

import java.util.Arrays;
import java.util.Comparator;

public class AgendaTelefonicaDemo {

    // 1. IMPLEMENTACIÓN MANUAL (Bubble Sort aplicado a múltiples criterios)
    public static void ordenarManual(Contacto[] agenda) {
        if (agenda == null || agenda.length < 2) return;
        
        boolean swapped;
        for (int n = agenda.length; n > 1; n--) {
            swapped = false;
            for (int i = 1; i < n; i++) {
                // Comparamos nombres alfabéticamente
                int comparacionNombres = agenda[i - 1].getNombre().compareToIgnoreCase(agenda[i].getNombre());
                
                // Si el anterior es mayor al actual, o si tienen el mismo nombre pero el teléfono del anterior es mayor
                if (comparacionNombres > 0 || (comparacionNombres == 0 && agenda[i - 1].getTelefono().compareTo(agenda[i].getTelefono()) > 0)) {
                    // Intercambio
                    Contacto temp = agenda[i - 1];
                    agenda[i - 1] = agenda[i];
                    agenda[i] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // 2. IMPLEMENTACIÓN NATIVA (Usando Comparator con múltiples criterios)
    public static void ordenarNativo(Contacto[] agenda) {
        Arrays.sort(agenda, Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                                    .thenComparing(Contacto::getTelefono));
    }

    public static void main(String[] args) {
        Contacto[] agendaOriginal = {
            new Contacto("Carlos Pérez", "3001234567", "carlos@mail.com"),
            new Contacto("Ana Gómez", "3109876543", "ana@mail.com"),
            new Contacto("Carlos Pérez", "3011111111", "carlos.p@mail.com"), // Mismo nombre, diferente teléfono
            new Contacto("Beatriz Ruiz", "3205554433", "beatriz@mail.com")
        };

        // Copia para la prueba manual
        Contacto[] agendaManual = Arrays.copyOf(agendaOriginal, agendaOriginal.length);
        System.out.println("=== AGENDA ORIGINAL ===");
        System.out.println(Arrays.toString(agendaManual));

        ordenarManual(agendaManual);
        System.out.println("\n=== ORDENADO MANUALMENTE (Nombre y Teléfono) ===");
        System.out.println(Arrays.toString(agendaManual));

        // Copia para la prueba nativa
        Contacto[] agendaNativa = Arrays.copyOf(agendaOriginal, agendaOriginal.length);
        
        ordenarNativo(agendaNativa);
        System.out.println("\n=== ORDENADO NATIVAMENTE (Comparator) ===");
        System.out.println(Arrays.toString(agendaNativa));
    }
}