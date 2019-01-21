/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 203p21
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String dato;
        Fecha fecha = new Fecha();
        System.out.println("Introduce una fecha <dd/mm/aaaa>: ");
        dato = teclado.readLine();
        while (!fecha.comprobar(dato)) {
            System.out.println("FECHA INCORRECTA");
            System.out.println("Introduce una fecha <dd/mm/aaaa>: ");
            dato = teclado.readLine();

        }
        System.out.println(" Orden es: "+fecha.calculoOrden());
        System.out.println ("Fecha Vencimiento "+
                fecha.calcularVencimiento(200));
    }

}
