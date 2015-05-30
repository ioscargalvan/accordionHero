/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazUsuario;

import java.io.*;
import sun.audio.*;

/**
 *
 * @author Oscar
 */
public class CancionJugarThread extends Thread{
    
    @Override
    public void run () {
        try { 
        String sonido = "src/musicaInicio2.wav";
        InputStream in = new FileInputStream(sonido);
        AudioStream audio = new AudioStream(in);
        AudioPlayer.player.start(audio);
       
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
