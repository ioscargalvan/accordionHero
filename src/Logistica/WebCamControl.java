/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logistica;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author Oscar
 */
public class WebCamControl {
   Webcam webcam = Webcam.getDefault();
     JFrame window = new JFrame("Test webcam panel");
     public void letMeSee() {
       
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.setViewSize(new Dimension(176, 144));
        
        //  webcam.setViewSize(new Dimension(40, 50));

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(false);
        panel.setDisplayDebugInfo(false);
        panel.setImageSizeDisplayed(false);
        panel.setMirrored(true);
        panel.setLocation(683, 384);

    //    JFrame window = new JFrame("Test webcam panel");
        window.add(panel);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLocation(0, 0);
        window.pack();
        window.setVisible(true);
        

    }
     
      public boolean tomaFoto() throws IOException { 
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        
        // get image
		BufferedImage image = webcam.getImage();
                

		// save image to PNG file
		ImageIO.write(image, "PNG", new File("test.png"));
                
                return true;
    }
      
     public boolean cierrome() { 
         window.dispose();
         webcam.close();
         return true;
     }
}
