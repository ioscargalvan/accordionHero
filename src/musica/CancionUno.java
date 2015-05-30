/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musica;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Oscar
 */
public class CancionUno {

    AudioStream audio;

    public CancionUno() {
        try {
            String sonido = "src\\musica\\tololocheChicoteado.wav";
            InputStream in = new FileInputStream(sonido);
            audio = new AudioStream(in);
        } catch (Exception e) {
            System.out.println("Hubo un error pariente.");
        }
    }

    public void queSuenaPariente() {
        try {

            AudioPlayer.player.start(audio);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void silencioPariente() {
        try {

            AudioPlayer.player.stop(audio);
           

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
