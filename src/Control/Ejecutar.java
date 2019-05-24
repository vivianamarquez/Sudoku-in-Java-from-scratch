/*
 ESTRUCTURA DE DATOS
 PROYECTO FINAL - ESTRUCTURA DE DATOS - SODOKU
 * Nombre: Viviana Marcela Peña Márquez. 
 * Fecha: Miércoles, 20 de mayo de 2015.
 * Institución: Konrad Lorenz Fundación Universitaria.
 * Profesora: Mireya Gómez Bernal.
 * Link video YouTube para ver cómo se ve la aplicación: http://youtu.be/s5ztfaul2Rg 
 */

package Control;

import Vista.VentanaBienvenido;
import javax.swing.SwingUtilities;

/**
 *
 * @author vivianamarquez
 *
 */

public class Ejecutar {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                VentanaBienvenido ejecutable = new VentanaBienvenido();
                ejecutable.setVisible(true);
                
            }
        });

    }

}
