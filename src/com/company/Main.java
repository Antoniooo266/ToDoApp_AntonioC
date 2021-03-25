package com.company;

import java.io.*;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) throws IOException {
        Hashtable<Tarea, Boolean> TareaP = new Hashtable<Tarea, Boolean>();
        Hashtable<Tarea, Boolean> TareaC = new Hashtable<Tarea, Boolean>();

        try {
            Scanner sc = new Scanner(System.in);
            boolean salir = false;
            while (!salir) {
                FileWriter file = new FileWriter("src\\Tareas\\agendas",true);
                PrintWriter pw = new PrintWriter(file);

                System.out.println("AGENDA 2021");
                System.out.println("1-Introducir nueva Tarea");
                System.out.println("2-Revisar Tareas");
                System.out.println("3-Completar Tarea");
                System.out.println("4-Salir");
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca nueva tarea: ");
                        String titulo = sc.next();
                        Date fecha = new Date();
                        Tarea tarea = new Tarea(null, fecha, false);
                        tarea.setNombreTarea(titulo);
                        pw.println("TAREA PENDIENTE\n###############");
                        pw.println(tarea);
                        TareaP.put(tarea, false);
                        break;
                    case 2:
                        File Reader = new File("src\\Tareas\\agenda");
                        Scanner MyReader = new Scanner(Reader);
                        while (MyReader.hasNextLine()) {
                            String contain = MyReader.nextLine();
                            System.out.println(contain);
                        }
                        break;
                    case 3:
                        System.out.println("Escriba la tarea que desea completar: ");
                        String tituloN = sc.next();
                        Date fechaN = new Date();
                        Tarea TareaN = new Tarea(tituloN, fechaN, true);
                        TareaP.get(TareaN);
                        TareaP.remove(TareaN);
                        pw.println("\n");
                        pw.println("TAREA COMPLETA\n##############");
                        pw.println(TareaN);
                        TareaC.put(TareaN, true);
                        break;
                    case 4:
                        salir = true;
                        sc.close();
                    default:
                        break;
                }
                pw.close();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Problemas");
        }

    }

}
