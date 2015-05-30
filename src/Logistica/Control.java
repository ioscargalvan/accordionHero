/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logistica;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oscar
 */
public class Control {

    String nomArchivo = "src\\Puntuaciones\\Puntuaciones.txt";
    Object[][] puntuaciones = new Object[5][2];
    java.util.List<Jugador> listaJugadores = new ArrayList<>();

    int puntuacion = 0;

    public DefaultTableModel leePuntuaciones() {
        File file = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            file = new File(nomArchivo);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se encontro el archivo de puntuaciones.");
        }

        try {
            for (int i = 0; i < puntuaciones.length; i++) {
                String lineaNombre = br.readLine();
                if (lineaNombre == null) {
                    break;
                }

                puntuaciones[i][0] = lineaNombre;

                String lineaPuntuacion = br.readLine();
                if (lineaPuntuacion == null) {
                    break;
                }

                puntuaciones[i][1] = lineaPuntuacion;

            }
            br.close();

        } catch (IOException e) {
            System.out.println("Hubo un error de entrada y salida.");
        }

        String nombresColumnas[] = {"Pariente:", "Puntuación:"};
        DefaultTableModel modelo = new DefaultTableModel(puntuaciones, nombresColumnas);

        if (puntuaciones[0][0] == null) {
            return null;
        }

        return modelo;
    }

    public DefaultTableModel leePuntuacionesOrdenadas() {
        leeJugadoresArchivo();
        List<Jugador> listaOrdenados = ordenaJugadoresManual();

        Jugador jugador1 = listaOrdenados.get(0);
        Jugador jugador2 = listaOrdenados.get(1);
        Jugador jugador3 = listaOrdenados.get(2);
        Jugador jugador4 = listaOrdenados.get(3);
        Jugador jugador5 = listaOrdenados.get(4);

        puntuaciones[0][0] = jugador1.getNombre();
        puntuaciones[0][1] = jugador1.getPuntuacion();
        puntuaciones[1][0] = jugador2.getNombre();
        puntuaciones[1][1] = jugador2.getPuntuacion();
        puntuaciones[2][0] = jugador3.getNombre();
        puntuaciones[2][1] = jugador3.getPuntuacion();
        puntuaciones[3][0] = jugador4.getNombre();
        puntuaciones[3][1] = jugador4.getPuntuacion();
        puntuaciones[4][0] = jugador5.getNombre();
        puntuaciones[4][1] = jugador5.getPuntuacion();

        String nombresColumnas[] = {"Pariente:", "Puntuación:"};
        DefaultTableModel modelo = new DefaultTableModel(puntuaciones, nombresColumnas);

        return modelo;
    }

    public void establecePuntuacion(int puntuacion) {

        File file;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter;

        try {
            file = new File("src\\Puntuaciones\\PuntuacionTemporal.txt");
            fileWriter = new FileWriter(file);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        bufferedWriter = new BufferedWriter((OutputStreamWriter) (fileWriter));

        try {
            // Escribe el texto.
            bufferedWriter.write(Integer.toString(puntuacion));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            // Cierra las herramientas.
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void estableceCerveza(int cerveza) {
        File file;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter;

        try {
            file = new File("src\\Puntuaciones\\PuntuacionCerveza.txt");
            fileWriter = new FileWriter(file);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        bufferedWriter = new BufferedWriter((OutputStreamWriter) (fileWriter));

        try {
            // Escribe el texto.
            bufferedWriter.write(Integer.toString(cerveza));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            // Cierra las herramientas.
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public void leeJugadoresArchivo() {
        File file;
        FileReader fr;
        Jugador jugador1 = new Jugador(null, 0);
        Jugador jugador2 = new Jugador(null, 0);
        Jugador jugador3 = new Jugador(null, 0);
        Jugador jugador4 = new Jugador(null, 0);
        Jugador jugador5 = new Jugador(null, 0);

        try {
            file = new File("src\\Puntuaciones\\Puntuaciones.txt");
            // Crea una nueva instancia con el archivo.
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            // Lee la primera linea.
            String linea = br.readLine();
            // La almacena en el atributo texto.
            jugador1.setNombre(linea);

            linea = br.readLine();
            jugador1.setPuntuacion(Integer.parseInt(linea));

            linea = br.readLine();
            jugador2.setNombre(linea);
            linea = br.readLine();
            jugador2.setPuntuacion(Integer.parseInt(linea));

            linea = br.readLine();
            jugador3.setNombre(linea);
            linea = br.readLine();
            jugador3.setPuntuacion(Integer.parseInt(linea));

            linea = br.readLine();
            jugador4.setNombre(linea);
            linea = br.readLine();
            jugador4.setPuntuacion(Integer.parseInt(linea));

            linea = br.readLine();
            jugador5.setNombre(linea);
            linea = br.readLine();
            jugador5.setPuntuacion(Integer.parseInt(linea));

            listaJugadores.add(jugador1);
            listaJugadores.add(jugador2);
            listaJugadores.add(jugador3);
            listaJugadores.add(jugador4);
            listaJugadores.add(jugador5);

            // Cierra el lector de archivos.
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregaJugador(Jugador jugador) {
        listaJugadores.add(jugador);

    }

    public void escribeJugadoresPerrones(List<Jugador> lista) {
        File file;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter;

        try {
            file = new File("src\\Puntuaciones\\Puntuaciones.txt");
            fileWriter = new FileWriter(file);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        bufferedWriter = new BufferedWriter((OutputStreamWriter) (fileWriter));

        try {
            // Escribe el texto.
            bufferedWriter.write(lista.get(0).getNombre());
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(lista.get(0).getPuntuacion()));
            bufferedWriter.newLine();
            bufferedWriter.write(lista.get(1).getNombre());
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(lista.get(1).getPuntuacion()));
            bufferedWriter.newLine();
            bufferedWriter.write(lista.get(2).getNombre());
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(lista.get(2).getPuntuacion()));
            bufferedWriter.newLine();
            bufferedWriter.write(lista.get(3).getNombre());
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(lista.get(3).getPuntuacion()));
            bufferedWriter.newLine();
            bufferedWriter.write(lista.get(4).getNombre());
            bufferedWriter.newLine();
            bufferedWriter.write(Integer.toString(lista.get(4).getPuntuacion()));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            // Cierra las herramientas.
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Jugador> ordenaJugadoresManual() {
        List<Jugador> listaJugadoresOrdenados = new ArrayList<>();
        listaJugadoresOrdenados = listaJugadores;

//        Jugador puntuacionMasAlta = null;
//        for (int i = 0; i < listaJugadores.size(); i++) {
//            puntuacionMasAlta = listaJugadores.get(i);
//
//            if (i == listaJugadores.size()) {
//                break;
//            }
//            if (puntuacionMasAlta.getPuntuacion() < listaJugadores.get(i + 1).getPuntuacion()) {
//                puntuacionMasAlta = listaJugadores.get(i + 1);
//            }
//
//        }
//        int indiceMasAlto = listaJugadores.indexOf(puntuacionMasAlta);
//
//        Jugador puntuacionMasBajo;
//        int indiceMasBajo = 0;
//        for (int i = 0; i < listaJugadores.size(); i++) {
//            puntuacionMasBajo = listaJugadores.get(i);
//            if (i == listaJugadores.size()) {
//                break;
//            }
//
//            if (puntuacionMasBajo.getPuntuacion() > listaJugadores.get(i + 1).getPuntuacion()) {
//                puntuacionMasBajo = listaJugadores.get(i + 1);
//            }
//            indiceMasBajo = listaJugadores.indexOf(puntuacionMasBajo);
//        }

        // Ya me voy a dormir. Checa el indice de la puntuacion mas alta. La idea es que cambies
        // de posicion. El mas bajo a lo ultimo de la lista, el mas alto a lo primero, el resto
        // se cambia solito.
        for (int p = 0; p < listaJugadoresOrdenados.size(); p++) {
            for (int i = 0; i < listaJugadores.size(); i++) {
                int k = i + 1;

                int ultimo = listaJugadores.size();

                if (k == listaJugadores.size()) {
                    break;
                }

                if (listaJugadoresOrdenados.get(i).getPuntuacion() < listaJugadoresOrdenados.get(k).getPuntuacion()) {

                    Jugador auxiliar = listaJugadoresOrdenados.get(i);
                    listaJugadoresOrdenados.set(i, listaJugadoresOrdenados.get(k));
                    //    listaJugadoresOrdenados.set(i, listaJugadoresOrdenados.get(k));
                    listaJugadoresOrdenados.set(k, auxiliar);
                }

            }

        }

        return listaJugadoresOrdenados;
    }

    public List<Jugador> ordenaJugadores() {

        List<Jugador> listaJugadoresOrdenados = new ArrayList<>();
        listaJugadoresOrdenados = listaJugadores;
        Collections.sort(listaJugadoresOrdenados, new ComparaJugadorPuntuacion());

        return listaJugadoresOrdenados;

    }
}
