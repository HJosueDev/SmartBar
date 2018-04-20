package com.hjdeveloper.smartbar.ClassUtilitary;

/**
 * Created by Developer on 04/04/2017.
 */

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Mezcla implements Serializable {
    private static final long serialVersionUID = 4368087493393562851L;
    private String nombre;
    private int[] porcentajes;
    private int[] cantidades;
    private int capacidad;

    public Mezcla(String nombre, int[] porcentajes, int cantidad_total) {
        this.nombre = nombre;
        this.porcentajes = porcentajes;
        this.cantidades = calcularCantidades(cantidad_total, porcentajes);
        this.capacidad = cantidad_total;
    }

    public Mezcla(String nombre, int[] porcentajes, int[] cantidades, int cantidad_total) {
        this.nombre = nombre;
        this.porcentajes = porcentajes;
        this.cantidades = cantidades;
        this.capacidad = cantidad_total;
    }

    public Mezcla(String nombre, int cantidad0, int cantidad1, int cantidad2, int cantidad3, int cantidad_total) {
        this.nombre = nombre;
        this.cantidades = new int[]{cantidad0, cantidad1, cantidad2, cantidad3};
        this.capacidad = cantidad_total;
    }

    public static boolean cabeEnRecipienteCantidades(int[] cantidades, int cantidad_total) {
        return cantidades[0] + cantidades[1] + cantidades[2] + cantidades[3] <= cantidad_total;
    }

    public static boolean cabeEnRecipientePorcentajes(int[] porcentajes, int cantidad_total) {
        return porcentajes[0] + porcentajes[1] + porcentajes[2] + porcentajes[3] <= 100;
    }

    public static boolean puedeServirse(int[] cantidades, int[] niveles) {
        boolean puede = true;

        for(int i = 0; i < cantidades.length && puede; ++i) {
            puede = puede && niveles[i] >= cantidades[i];
        }

        return puede;
    }

    public static int[] actualizarNiveles(int[] cantidades, int[] niveles) {
        int[] nuevosNiveles = new int[cantidades.length];

        for(int i = 0; i < cantidades.length; ++i) {
            nuevosNiveles[i] = niveles[i] - cantidades[i];
        }

        return nuevosNiveles;
    }

    public boolean esCantidadCorrecta() {
        int suma = 0;

        for(int i = 0; i < this.cantidades.length; ++i) {
            suma += this.cantidades[i];
        }

        return suma <= this.capacidad;
    }

    public static int calcularCantidad(int capacidad, int porcentaje) {
        double cantidad_d = (double)porcentaje * (double)capacidad / 100.0D;
        return (int)Math.round(cantidad_d);
    }

    public static int calcularPorcentaje(int capacidad, int cantidad) {
        double porcentaje_d = (double)cantidad / (double)capacidad * 100.0D;
        return (int)Math.round(porcentaje_d);
    }

    public static int[] calcularCantidades(int capacidad, int[] porcentajes) {
        int[] cantidades_aux = new int[porcentajes.length];

        for(int i = 0; i < porcentajes.length; ++i) {
            double cantidad_d = (double)porcentajes[i] * (double)capacidad / 100.0D;
            cantidades_aux[i] = (int)Math.round(cantidad_d);
        }

        return cantidades_aux;
    }

    public static List<String> devolverListaMezclas(List<Mezcla> lista_mezclas) {
        ArrayList lista_cadenas = new ArrayList();
        Iterator var3 = lista_mezclas.iterator();

        while(var3.hasNext()) {
            Mezcla m = (Mezcla)var3.next();
            lista_cadenas.add(m.toString());
        }

        return lista_cadenas;
    }

    public String toString() {
        return this.nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getCantidades() {
        return this.cantidades;
    }

    public void setCantidades(int[] cantidades) {
        this.cantidades = cantidades;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int cantidad_total) {
        this.capacidad = cantidad_total;
    }

    public int[] getPorcentajes() {
        return this.porcentajes;
    }

    public void setPorcentajes(int[] porcentajes) {
        this.porcentajes = porcentajes;
    }
}
