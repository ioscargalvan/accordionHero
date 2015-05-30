/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Oscar
 */
public class dlgPuntuacion extends javax.swing.JDialog {
    
    String puntuacion;
    String nombre;

    /**
     * Creates new form dlgPuntuacion
     */
    public dlgPuntuacion(java.awt.Frame parent, boolean modal, String nombre) {
        super(parent, modal);
        initComponents();
        this.nombre = nombre;
        leePuntuacion();
        temporizador();
        
        
         ImageIcon ic = new ImageIcon("test.png");
        lblIcon.setIcon(ic);
        lblIcon.setSize(4, 40);
        lblSombrero.setLocation(lblSombrero.getX(), (lblSombrero.getY() - 80));
        lblIcon.setLocation(lblIcon.getX(), lblIcon.getY() + 10);

        
        lblSombrero.setLocation(47, -60);
        
        setLocation(683, 0);
        
      

            
    }
    
    public dlgPuntuacion() { 
        
    }
    
    public String getPuntuacion() { 
        return puntuacion;
    }
    
     public void temporizador() { 
        int delay = 800; //milliseconds
       
        ActionListener taskPerformer2 = new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (count == 800) {//we did the task 10 times
                    ((Timer) evt.getSource()).stop();
                }

                leePuntuacion();
                
                count++;
             //   System.out.println("He llegado, bitch.");
             
                     
                }
               
            
            
        };
         
        Timer timerLol = new Timer(delay, taskPerformer2);
        timerLol.start();
    }
    
  

    public void leePuntuacion() { 
        File file;
        FileReader fr;

        try {
            file = new File("src\\Puntuaciones\\PuntuacionTemporal.txt");
            // Crea una nueva instancia con el archivo.
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            // Lee la primera linea.
            String linea = br.readLine();
            // La almacena en el atributo texto.
            puntuacion = linea;

            // Mientras haya líneas.
            while (linea != null) {
                // Lee la siguiente línea.
                linea = br.readLine();
                // Si la línea no es null, la agrega al atributo texto.
                if (linea != null) {
                    puntuacion = linea;
                }
            }
            // Cierra el lector de archivos.
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        lblPuntuacion.setText(puntuacion);
    
    }
    
    public int getPuntuacionFinal() { 
         File file;
        FileReader fr;

        try {
            file = new File("src\\Puntuaciones\\PuntuacionTemporal.txt");
            // Crea una nueva instancia con el archivo.
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            // Lee la primera linea.
            String linea = br.readLine();
            // La almacena en el atributo texto.
            puntuacion = linea;

            // Mientras haya líneas.
            while (linea != null) {
                // Lee la siguiente línea.
                linea = br.readLine();
                // Si la línea no es null, la agrega al atributo texto.
                if (linea != null) {
                    puntuacion = linea;
                }
            }
            // Cierra el lector de archivos.
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        int puntuacionFinal;
        puntuacionFinal = Integer.parseInt(puntuacion);
        return puntuacionFinal;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPuntuacion = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        lblSombrero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Puntuacion.png"))); // NOI18N

        lblPuntuacion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPuntuacion.setText("000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(lblPuntuacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblPuntuacion)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSombrero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/sombrero3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSombrero)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblIcon)
                        .addGap(84, 84, 84)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSombrero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIcon)
                .addGap(0, 86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        muevete();
    }//GEN-LAST:event_formWindowOpened

      public void muevete() { 
         lblIcon.setLocation(50, 60); 
         jPanel2.setSize(269, 200);
    }
      


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JLabel lblSombrero;
    // End of variables declaration//GEN-END:variables
}
