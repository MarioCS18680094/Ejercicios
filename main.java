/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.prolo;

import java.util.Scanner;

/**
 *
 * @author mssyo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc;
        Scanner leer = new Scanner(System.in);
        
        do{
        
        System.out.println("1. separar letras y numeros ");
        System.out.println("2. Expresion Aritmetica");
        System.out.println("3. Expresion logica");
        System.out.println("0. Salir ");
        System.out.println("ingresa una opcion: ");
        opc= leer.nextInt();
            System.out.println("");
        switch(opc){
            case 1:
                separar sepa = new separar ();
                break;
            
            case 2:
                ExpAritmetica ari=new ExpAritmetica();
                break;
                
            case 3:
                ExpLogica logi=new ExpLogica();
                break;
                
            case 0:
                System.out.println("-saliendo-");
                break;
            default: 
                System.out.println("--no valido--");
                break;
        }
        
        }while (opc!=0);
        
    }
    
}
