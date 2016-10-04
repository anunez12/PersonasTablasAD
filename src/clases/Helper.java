/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anunez12
 */
public class Helper {

    public static void mensaje(Component ventana, String mensaje, int tipo) {
        switch (tipo) {
            case 1:
                JOptionPane.showMessageDialog(ventana, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(ventana, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(ventana, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

    public static void limpiadoTabla(JTable tabla1) {
        int numfilas, numcolumnas;
        numcolumnas = tabla1.getColumnCount();
        numfilas = tabla1.getRowCount();
        for (int i = 0; i < numfilas; i++) {
            for (int j = 0; j < numcolumnas; j++) {
                tabla1.setValueAt("", i, j);
            }
        }
    }

    public static void porDefectoTabla(JTable tabla1) {
        DefaultTableModel tm;
        tm = (DefaultTableModel) tabla1.getModel();
        tm.setColumnCount(0);
        tm.setRowCount(0);
    }

    public static void habilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(true);

        }
    }

    public static void deshabilitarBotones(JButton[] botones) {
        for (int i = 0; i < botones.length; i++) {
            botones[i].setEnabled(false);
        }
    }

    public static int cantidadNumerosPares(JTable tabla1) {
        int numfilas, numcolumnas, aux, cont = 0;
        numcolumnas = tabla1.getColumnCount();
        numfilas = tabla1.getRowCount();

        for (int i = 0; i < numfilas; i++) {
            for (int j = 0; j < numcolumnas; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (aux % 2 == 0) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static void numerospares(JTable tabla1, JTable tabla2) {
        int numfilas, numcolumnas, aux;
        numcolumnas = tabla1.getColumnCount();
        numfilas = tabla1.getRowCount();

        for (int i = 0; i < numfilas; i++) {
            for (int j = 0; j < numcolumnas; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (aux % 2 == 0) {
                    tabla2.setValueAt(aux, i, j);
                }
            }

        }
    }

    public static void letraC(JTable tabla1, JTable tabla2) {
        int numfilas, numcolumnas, aux;
        numcolumnas = tabla1.getColumnCount();
        numfilas = tabla1.getRowCount();

        for (int i = 0; i < numfilas; i++) {
            for (int j = 0; j < numcolumnas; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (i == 0 || i == numfilas - 1 || j == 0) {
                    tabla2.setValueAt(aux, i, j);
                }
            }

        }
    }

    public static void diagonalPrincipal(JTable tabla1, JTable tabla2) {
        int numfilas, numcolumnas, aux;
        numcolumnas = tabla1.getColumnCount();
        numfilas = tabla1.getRowCount();

        for (int i = 0; i < numfilas; i++) {
            for (int j = 0; j < numcolumnas; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (i == j) {
                    tabla2.setValueAt(aux, i, j);
                }
            }

        }
    }

    public static void letraH(JTable tabla1, JTable tabla2) {
        int numfilas, numcolumnas, aux;
        numcolumnas = tabla1.getColumnCount();
        numfilas = tabla1.getRowCount();

        for (int i = 0; i < numfilas; i++) {
            for (int j = 0; j < numcolumnas; j++) {
                aux = (int) tabla1.getValueAt(i, j);
                if (j == 0 || j == numcolumnas - 1 || i == (numfilas - 1) / 2) {
                    tabla2.setValueAt(aux, i, j);
                }
            }

        }
    }

    public static int[][] exportarDatos(JTable tabla1) {
        int numfilas, numcolumnas;
        numcolumnas = tabla1.getColumnCount();
        numfilas = tabla1.getRowCount();

        int m[][] = new int[numfilas][numcolumnas];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                m[i][j] = (int) tabla1.getValueAt(i, j);
            }

        }
        return m;

    }

    public static String recorridoHaciaArriba(int[][] m, int j) {
        int numfilas = m.length;
        String aux = "";

        for (int i = numfilas - 1; i >= 0; i--) {
            aux = aux + m[i][j] + ",";

        }
        return aux;

    }

    public static String recorridoHaciaAbajo(int[][] m, int j) {
        int numfilas = m.length;
        String aux = "";

        for (int i = 0; i < numfilas; i++) {
            aux = aux + m[i][j] + ",";

        }
        return aux;
    }

    public static String recorridoUno(JTable tabla1) {

        int[][] m = exportarDatos(tabla1);
        int numcolumnas = m[0].length;
        String aux = "";

        for (int j = 0; j < numcolumnas; j++) {
            if (j % 2 == 0) {
                aux = aux + Helper.recorridoHaciaArriba(m, j);
            } else {
                aux = aux + Helper.recorridoHaciaAbajo(m, j);
            }

        }
        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;
    }

    public static String recorrridoHaciaIzquierda(int[][] m, int i) {
        int numcolumnas = m[0].length;
        String aux = "";

        for (int j = numcolumnas - 1; j >= 0; j--) {
            aux = aux + m[i][j] + ",";

        }
        return aux;
    }

    public static String recorrridoHaciaDerecha(int[][] m, int i) {
        int numcolumnas = m[0].length;
        String aux = "";

        for (int j = 0; j < numcolumnas; j++) {
            aux = aux + m[i][j] + ",";

        }
        return aux;
    }

    public static String recorridoDos(JTable tabla1) {
        int[][] m = exportarDatos(tabla1);
        int numfilas = m[0].length;
        String aux = "";

        for (int i = 0; i < numfilas; i++) {
            if (i % 2 == 0) {
                aux = aux + Helper.recorrridoHaciaIzquierda(m, i);
            } else {
                aux = aux + Helper.recorrridoHaciaDerecha(m, i);
            }

        }
        aux = aux.substring(0, aux.length() - 2) + ".";
        return aux;

    }
}
