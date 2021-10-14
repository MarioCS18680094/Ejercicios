package com.mycompany.prolo;

import java.util.Scanner;

/**
 *
 * @author mssyo
 */
public class ExpLogica {

    public ExpLogica() {
        Scanner leer = new Scanner(System.in);

        System.out.println("La expresion a realizar es [(p->q)^p]->q");
        String expresion = leer.nextLine();
        String a[] = {"v", "v", "f", "f"};
        String b[] = {"v", "f", "v", "f"};
        String[] R1 = new String[4];
        String[] R2 = new String[4];
        String[] R3 = new String[4];

        //operacion cuando se niega la operacion    
        if (expresion.charAt(0) == '0') {

            for (int i = 0; i < a.length; i++) {
                if (a[i].equals("v") && b[i].equals("f")) {
                    R1[i] = "f";
                } else {
                    R1[i] = "v";
                }
            }

            for (int i = 0; i < a.length; i++) {
                if (a[i].equals("v") && R1[i].equals("v")) {
                    R2[i] = "v";
                } else {
                    R2[i] = "f";
                }
            }

            for (int i = 0; i < b.length; i++) {
                if (b[i].equals("f") && R2[i].equals("v")) {
                    R3[i] = "v";
                } else {
                    R3[i] = "f";
                }
            }

        }

        //operaciones cuando no se niega la expresion 
        if (expresion.charAt(0) == '1') {

            for (int i = 0; i < a.length; i++) {
                if (a[i].equals("v") && b[i].equals("f")) {
                    R1[i] = "f";
                } else {
                    R1[i] = "v";
                }
            }

            for (int i = 0; i < a.length; i++) {
                if (a[i].equals("v") && R1[i].equals("v")) {
                    R2[i] = "v";
                } else {
                    R2[i] = "f";
                }
            }

            for (int i = 0; i < b.length; i++) {
                if (b[i].equals("f") && R2[i].equals("v")) {
                    R3[i] = "f";
                } else {
                    R3[i] = "v";
                }
            }
        }
        System.out.println("| (p->q) |" + "| [(p->q)^p]  |" + "| [(p->q)^p]->q|");
        for (int i = 0; i < R3.length; i++) {
            System.out.println("|   "+R1[i] + "\t ||\t" + R2[i] + "\t||\t" + R3[i]+"\t|");
        }
        
        System.out.println(
                (R3[0].equals("f"))&&
                (R3[1].equals("f"))&&
                (R3[2].equals("f"))&&
                (R3[3].equals("f"))?"Es una Contradiccion":"Es una Tautologia");
    }

}
