package com.mycompany.prolo;

import java.util.Scanner;

/**
 *
 * @author mssyo
 */
class separar {

    public separar() {
        Scanner leer = new Scanner(System.in);
        //System.out.println("ingrese cadena: ");

        //ingresar cadena
        String cadena = "(9 5 + 19 )*.2 / 6.6 ^ 4 -7 .46";
        String[] parts = cadena.split(" ");

        //partes de la cadena
        System.out.println("cadena divida en: " + parts.length + " partes");

        String numeros = "";
        int conN = 0;

        String palabras = "";
        int conP = 0;

        String opeadores = "";
        int conOp = 0;
        
        //clasificar partes
        for (int i = 0; i < parts.length; i++) {

            if (isNumeric(parts[i])) {
                //numeros
                if (conN == 0) {
                    numeros += parts[i];
                } else {
                    numeros += ", " + parts[i];
                }

                conN++;
            } else {

                if (parts[i].length() == 1) {
                    //operadores
                    if (conOp == 0) {
                        opeadores += parts[i];
                    } else {
                        opeadores += ", " + parts[i];
                    }
                    conOp++;
                } else {
                    //cadenas
                    if (conP == 0) {
                        palabras += parts[i];
                    } else {
                        palabras += ", " + parts[i];
                    }
                    conP++;
                }
            }
        }
        
        //imprimir
        System.out.println("\nCantidad de numeros: " + conN);
        System.out.println("Lista de numeros: " + numeros);

        System.out.println("\nCantidad de palabras: " + conP);
        System.out.println("Lista de palabras: " + palabras);

        System.out.println("\nCantidad de Operadores: " + conOp);
        System.out.println("Lista de operadores: " + opeadores);

        System.out.println("\n");
    }

    //saber si es un numero
    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

}
