/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logistica;

import java.util.Comparator;

/**
 *
 * @author Oscar
 */
public class ComparaJugadorPuntuacion implements Comparator<Jugador>{
    
    
    public int compare(Jugador jugador1, Jugador jugador2) { 
        return jugador1.getPuntuacionCadena().compareTo(jugador2.getPuntuacionCadena());
    }
}
