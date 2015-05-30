/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazUsuario;

import Logistica.Control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import musica.CancionCuatro;
import musica.CancionDos;
import musica.CancionTres;
import musica.CancionUno;

/**
 *
 * @author Oscar
 */
public class DlgJuegoHilo extends javax.swing.JDialog {

    Control control = new Control();
    int puntuacion = 0;
    int cerveza = 100;
    int duracion = 0;

    String nombre;
    int cancionSeleccionada;
    CancionUno cancionUno = new CancionUno();
    CancionDos cancionDos = new CancionDos();
    CancionTres cancionTres = new CancionTres();
    CancionCuatro cancionCuatro = new CancionCuatro();
    int contadorAzul, contadorVerde, contadorRojo, contadorAmarillo;
    dlgCerveza dlCerveza;
    dlgPuntuacion dlPuntuacion;

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Creates new form dlgJuego
     */
    public DlgJuegoHilo(java.awt.Frame parent, boolean modal, String nombre, int cancionSeleccionada) {
        super(parent, modal);
        initComponents();
        this.nombre = nombre;
        this.cancionSeleccionada = cancionSeleccionada;
        dlCerveza = new dlgCerveza(null, false);
        dlCerveza.setVisible(true);
        dlPuntuacion = new dlgPuntuacion(null, false, nombre);
        dlPuntuacion.setVisible(true);
        calculameLasNotas();
        control.estableceCerveza(100);
        cronometrameLaRola();
        songKiller.start();
        songKiller.setPriority(Thread.MAX_PRIORITY);
        muevomeRapidoYFurioso();
        preparaLaRola();
        setLocation(0, 0);
        hiloAzul.start();
        hiloVerde.start();
        hiloAmarillo.start();
        hiloRojo.start();
        validaCerveza.start();
    

    }

    public void calculameLasNotas() {
        switch (cancionSeleccionada) {
            case 1:
                contadorAzul = 8056;
                contadorVerde = 6042;
                contadorAmarillo = 4143;
                contadorRojo = 3453;
                break;
            case 2:
                contadorAzul = 12500;
                contadorVerde = 9375;
                contadorAmarillo = 6429;
                contadorRojo = 5358;
                break;
            case 3:
                contadorAzul = 10112;
                contadorVerde = 7584;
                contadorAmarillo = 5200;
                contadorRojo = 4334;
                break;
            case 4:
                contadorAzul = 11223;
                contadorVerde = 8417;
                contadorAmarillo = 5772;
                contadorRojo = 4810;
                break;
        }
    }

    Thread validaCerveza = new Thread() {
        @Override
        public void run() {
            while (true) {
                int nivelCerveza = dlCerveza.cantidadCerveza;
                
                System.out.println(nivelCerveza);
                if (nivelCerveza == 0 || nivelCerveza < 0) {
                    System.out.println("Se me acabo la cerveza pariente :s");
                    terminaRola();
                    // Aqui esta un error del ciclo.
                    break;
                    
                }
            }
        }
    };

    Thread hiloAzul = new Thread() {

        @Override
        public void run() {
            int delay = 18; //milliseconds

            ActionListener taskPerformer2 = new ActionListener() {
                int count = 0;

                @Override
                public void actionPerformed(ActionEvent evt) {
//                    if (count == contadorAzul) {
//
//                        ((Timer) evt.getSource()).stop();
//                    }

                    lblNotaAzul.setLocation((lblNotaAzul.getX()), lblNotaAzul.getY() + 5);

                    count++;

                    if (lblNotaAzul.getY() > 250) {
                        lblNotaAzul.setLocation(lblNotaAzul.getX(), -100);

                    }

                }

            };

            Timer timer = new Timer(delay, taskPerformer2);
            timer.start();
        }
    };

    Thread hiloVerde = new Thread() {

        @Override
        public void run() {
            int delay = 24; //milliseconds

            ActionListener taskPerformer2 = new ActionListener() {
                int count = 0;

                @Override
                public void actionPerformed(ActionEvent evt) {
//                    if (count == contadorVerde) {
//                        ((Timer) evt.getSource()).stop();
//                    }

                    lblNotaVerde.setLocation((lblNotaVerde.getX()), lblNotaVerde.getY() + 5);

                    count++;

                    if (lblNotaVerde.getY() > 250) {
                        lblNotaVerde.setLocation(lblNotaVerde.getX(), -100);

                    }

                }

            };

            Timer timer = new Timer(delay, taskPerformer2);
            timer.start();
        }
    };

    Thread hiloAmarillo = new Thread() {
        @Override
        public void run() {
            int delay = 35; //milliseconds

            ActionListener taskPerformer2 = new ActionListener() {
                int count = 0;

                @Override
                public void actionPerformed(ActionEvent evt) {
//                    if (count == contadorAmarillo) {
//                        ((Timer) evt.getSource()).stop();
//                    }

                    lblNotaAmarilla.setLocation((lblNotaAmarilla.getX()), lblNotaAmarilla.getY() + 5);

                    count++;

                    if (lblNotaAmarilla.getY() > 250) {
                        lblNotaAmarilla.setLocation(lblNotaAmarilla.getX(), -100);

                    }

                }

            };

            Timer timer = new Timer(delay, taskPerformer2);
            timer.start();
        }
    };

    Thread hiloRojo = new Thread() {
        @Override
        public void run() {
            int delay = 42; //milliseconds

            ActionListener taskPerformer2 = new ActionListener() {
                int count = 0;

                @Override
                public void actionPerformed(ActionEvent evt) {
//                    if (count == contadorRojo) {
//                        ((Timer) evt.getSource()).stop();
//                    }

                    lblNotaRoja.setLocation((lblNotaRoja.getX()), lblNotaRoja.getY() + 5);

                    count++;

                    if (lblNotaRoja.getY() > 250) {
                        lblNotaRoja.setLocation(lblNotaRoja.getX(), -100);

                    }

                }

            };

            Timer timer = new Timer(delay, taskPerformer2);
            timer.start();
        }
    };

    public void muevomeRapidoYFurioso() {
        int delay = 30; //milliseconds

        ActionListener taskPerformer2 = new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (count == 800) {//we did the task 10 times
                    ((Timer) evt.getSource()).stop();
                }

                lblNotaAzul.setLocation((lblNotaAzul.getX()), lblNotaAzul.getY() + 5);
              //  lblBotonAzul.setIcon(botonAzulSinPresionar);

                //    System.out.println(SwingUtilities.isEventDispatchThread());
                count++;
                //   System.out.println("He llegado, bitch.");
                if (lblNotaAzul.getY() > 250) {
                    // System.out.println("Si entre, lol.");
                    lblNotaAzul.setLocation(lblNotaAzul.getX(), -100);

                }

            }

        };

        Timer timerLol = new Timer(delay, taskPerformer2);
        timerLol.start();

        // new Timer(delay, taskPerformer).start();
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
        lblNotaAzul = new javax.swing.JLabel();
        lblBotonAzul = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNotaVerde = new javax.swing.JLabel();
        lblBotonVerde = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblNotaAmarilla = new javax.swing.JLabel();
        lblBotonAmarillo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblNotaRoja = new javax.swing.JLabel();
        lblBotonRojo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lblNotaAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/notaAzulSinPresionar.png"))); // NOI18N

        lblBotonAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/botonAzulSinPresionar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBotonAzul)
                    .addComponent(lblNotaAzul))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNotaAzul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(lblBotonAzul)
                .addContainerGap())
        );

        lblNotaVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/notaVerdeSinPresionar.png"))); // NOI18N

        lblBotonVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/botonVerdeSinPresionar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotaVerde)
                    .addComponent(lblBotonVerde))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNotaVerde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBotonVerde)
                .addContainerGap())
        );

        lblNotaAmarilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/notaAmarillaSinPresionar.png"))); // NOI18N

        lblBotonAmarillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/botonAmarilloSinPresionar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblBotonAmarillo)
                    .addComponent(lblNotaAmarilla))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNotaAmarilla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBotonAmarillo)
                .addContainerGap())
        );

        lblNotaRoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/notaRojaSinPresionar.png"))); // NOI18N

        lblBotonRojo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/botonRojoSinPresionar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblBotonRojo)
                    .addComponent(lblNotaRoja))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNotaRoja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBotonRojo)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
//        if (key == KeyEvent.VK_A) {
//
//            System.out.println("Entre");
//
//            if (lblNotaAzul.getY() > 200 && lblNotaAzul.getY() < 300) {
//                puntuacion = puntuacion + 50;
//                control.establecePuntuacion(puntuacion);
//                System.out.println("Entre al juego.");
//
//            
//            }
//
//        }

        switch (key) {
            case KeyEvent.VK_A:
                if (lblNotaAzul.getY() > 200 && lblNotaAzul.getY() < 300) {
                    puntuacion = puntuacion + 10;
                    cerveza = cerveza + 20;
                    if (cerveza > 100) {
                        cerveza = 100;
                    }
                    control.establecePuntuacion(puntuacion);
                    control.estableceCerveza(cerveza);
                } else {
                    cerveza = cerveza - 20;
                    control.estableceCerveza(cerveza);
                }
                break;
            case KeyEvent.VK_S:
                if (lblNotaVerde.getY() > 200 && lblNotaVerde.getY() < 300) {
                    puntuacion = puntuacion + 10;
                    cerveza = cerveza + 20;
                    if (cerveza > 100) {
                        cerveza = 100;
                    }
                    control.establecePuntuacion(puntuacion);
                    control.estableceCerveza(cerveza);
                } else {
                    cerveza = cerveza - 20;
                    control.estableceCerveza(cerveza);
                }
                break;

            case KeyEvent.VK_K:
                if (lblNotaAmarilla.getY() > 200 && lblNotaAmarilla.getY() < 300) {
                    puntuacion = puntuacion + 10;
                    cerveza = cerveza + 20;
                    if (cerveza > 100) {
                        cerveza = 100;
                    }
                    control.establecePuntuacion(puntuacion);
                    control.estableceCerveza(cerveza);
                } else {
                    cerveza = cerveza - 20;
                    control.estableceCerveza(cerveza);
                }
                break;

            case KeyEvent.VK_L:
                if (lblNotaRoja.getY() > 200 && lblNotaRoja.getY() < 300) {
                    puntuacion = puntuacion + 10;
                    cerveza = cerveza + 20;
                    if (cerveza > 100) {
                        cerveza = 100;
                    }
                    control.establecePuntuacion(puntuacion);
                    control.estableceCerveza(cerveza);
                } else {
                    cerveza = cerveza - 20;
                    control.estableceCerveza(cerveza);
                }
                break;
        }
    }//GEN-LAST:event_formKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        silencioQuePerdimos();
    }//GEN-LAST:event_formWindowClosing

    public void silencioQuePerdimos() {
        switch (cancionSeleccionada) {
            case 1:
                cancionUno.silencioPariente();
                break;

            case 2:
                cancionDos.silencioPariente();
                break;

            case 3:
                cancionTres.silencioPariente();
                break;

            case 4:
                cancionCuatro.silencioPariente();
                break;
        }

//        dispose();
//         dlgPuntuacion instanciaPuntuacion = new dlgPuntuacion();
//        int puntuacionFinal = instanciaPuntuacion.getPuntuacionFinal();
//        String puntuacionFinalCadena = Integer.toString(puntuacionFinal);
//        dlPuntuacion.dispose();
//        dlCerveza.dispose();
//        frmPantallaFinal pantallaFinal = new frmPantallaFinal(nombre, puntuacionFinalCadena);
//        pantallaFinal.setVisible(true);
    }

    public void preparaLaRola() {
        switch (cancionSeleccionada) {
            case 1:
                cancionUno.queSuenaPariente();
                break;

            case 2:
                cancionDos.queSuenaPariente();
                break;

            case 3:
                cancionTres.queSuenaPariente();
                break;

            case 4:
                cancionCuatro.queSuenaPariente();
                break;
        }
    }

    public void cronometrameLaRola() {

        switch (cancionSeleccionada) {
            case 1:
                duracion = 145000;
                break;
            case 2:
                duracion = 225000;
                break;
            case 3:
                duracion = 182000;
                break;
            case 4:
                duracion = 202000;
                break;
        }

    }

    public void terminaRola() {
        silencioQuePerdimos();
        dlCerveza.dispose();
        dlPuntuacion.dispose();
        dispose();
        dlgPuntuacion instanciaPuntuacion = new dlgPuntuacion();
        int puntuacionFinal = instanciaPuntuacion.getPuntuacionFinal();
        String puntuacionFinalCadena = Integer.toString(puntuacionFinal);

        frmPantallaFinal instancia = new frmPantallaFinal(nombre, puntuacionFinalCadena);

        instancia.setVisible(true);

    }

    Thread songKiller = new Thread() {
        @Override
        public void run() {
            int delay = duracion; //milliseconds

            ActionListener taskPerformer2 = new ActionListener() {
                int count = 0;

                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (count == 1) {
                        ((Timer) evt.getSource()).stop();
                    }

                    terminaRola();

                }

            };

            Timer timer = new Timer(delay, taskPerformer2);
            timer.start();
        }
    };



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblBotonAmarillo;
    private javax.swing.JLabel lblBotonAzul;
    private javax.swing.JLabel lblBotonRojo;
    private javax.swing.JLabel lblBotonVerde;
    private javax.swing.JLabel lblNotaAmarilla;
    private javax.swing.JLabel lblNotaAzul;
    private javax.swing.JLabel lblNotaRoja;
    private javax.swing.JLabel lblNotaVerde;
    // End of variables declaration//GEN-END:variables
}
