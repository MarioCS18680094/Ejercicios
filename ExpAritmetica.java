package com.mycompany.prolo;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author mssyo
 */

public class ExpAritmetica {
    Scanner leer = new Scanner(System.in);

    //Entrada de datos
    public ExpAritmetica(){
    System.out.println("Escribe una expresión algebraica: ");
    
    //espacios entre cada expresion 
    String espre = leer.nextLine();
    
    String separa = div(espre);
    
    System.out.printf("Postfija: %s\n", infixToPostfix(separa)); 
    

    //btener el resultado de la operacion 
    String[] post = infixToPostfix(separa).split(" ");   
    
    //Declaración de las pilas
    Stack < String > Ent = new Stack < String > ();
    Stack < String > Ope = new Stack < String > ();

    //Añadir a la Pila de entrada 
    for (int i = post.length - 1; i >= 0; i--) {
      Ent.push(post[i]);
    }

    
    String operadores = "+-*/%^";
    while (!Ent.isEmpty()) { //mientras la cadena no esta vacia
      if (operadores.contains("" + Ent.peek())) {
        Ope.push(evaluar(Ent.pop(), Ope.pop(), Ope.pop()) + "");
      }else {
        Ope.push(Ent.pop());
      }
    }

    //Mostrar resultados:
    System.out.println("Resultado: " + Ope.peek());
    }
    
    static String infixToPostfix(String infix) {
        
        final String ops = "-+/*^";

        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        //cadena dividida por espacio
        for (String token : infix.split("\\s")) { 
            if (token.isEmpty()){
                continue;
            }
            
            char c = token.charAt(0);
            int idx = ops.indexOf(c);
            
            // comprobar si hay operador
            if (idx != -1) {
                if (s.isEmpty()) {
                    s.push(idx);
                } else {
                    while (!s.isEmpty()) {
                        int p2 = s.peek() / 2;
                        int p1 = idx / 2;
                        if (p2 > p1 || (p2 == p1 && c != '^')) {
                            sb.append(ops.charAt(s.pop())).append(' ');
                        } else {
                            break;
                        }
                    }
                    s.push(idx);
                }
            } else if (c == '(') {
                s.push(-2); 
            } else if (c == ')') {
                while (s.peek() != -2) {
                    sb.append(ops.charAt(s.pop())).append(' ');
                }
                s.pop();
            } else {
                sb.append(token).append(' ');
            }
        }
        while (!s.isEmpty()) {
            sb.append(ops.charAt(s.pop())).append(' ');
        }
        return sb.toString();
    }

    //resultado de la operacion 
    private static double evaluar(String op, String n2, String n1) {
        double num1 = Double.parseDouble(n1);
        double num2 = Double.parseDouble(n2);
        if (op.equals("+")) {
            return (num1 + num2);
        }
        if (op.equals("-")) {
            return (num1 - num2);
        }
        if (op.equals("*")) {
            return (num1 * num2);
        }
        if (op.equals("/")) {
            return (num1 / num2);
        }
        if (op.equals("%")) {
            return (num1 % num2);
        }
        if (op.equals("^")) {
            return (Math.pow(num1, num2));
        }

        return 0;
    }

    //espacios entre expresión algebraica
    private static String div(String exp) {

        String operadores = "+-*/()^";
        String expresion = "";

    //Deja espacios entre operadores
    for (int i = 0; i < exp.length(); i++) {
      if (operadores.contains("" + exp.charAt(i))) {
        expresion += " " + exp.charAt(i) + " "; 
      }else expresion += exp.charAt(i);
    }
    return expresion.replaceAll("\\s+", " ").trim();
  }
    
}