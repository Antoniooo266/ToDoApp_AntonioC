package com.company;

import com.company.clases.BD;
import com.company.clases.Tarea;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            Scanner sc = new Scanner(System.in);
            boolean salir = false;
            Tarea tarea = new Tarea(null,null,false);
            File Reader = new File("src\\com\\company\\agenda");
            BD.CreacionTabla();
            while (!salir) {
                FileWriter file = new FileWriter("src\\com\\company\\agenda",true);
                PrintWriter pw = new PrintWriter(file);
                System.out.println("AGENDA 2021");
                System.out.println("1-Introducir nueva Tarea");
                System.out.println("2-Revisar Tareas");
                System.out.println("3-Completar Tarea");
                System.out.println("4-Salir");
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        Tarea.CrearTarea(tarea);
                        System.out.println(tarea);
                       break;
                    case 2:
                        break;
                    case 3:
                        Tarea.CompletarTarea(tarea);
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
            System.out.println("Error con el codigo. Revisa el codigo");
            e.printStackTrace();
        }

    }

}
