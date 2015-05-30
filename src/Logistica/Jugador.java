/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logistica;

/**
 *
 * @author Oscar
 */
public class Jugador {
    
    String nombre;
    int puntuacion;
    String puntuacionCadena;
    
    public Jugador(String nombre, int puntuacion) { 
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }
    
    public Jugador(String nombre, String puntuacion) { 
        this.nombre = nombre;
        this.puntuacionCadena = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public String getPuntuacionCadena() { 
        return puntuacionCadena;
    }
    
    public void setPuntuacionCadena(String puntuacion) { 
        this.puntuacionCadena = puntuacion;
    }
    
    
}
