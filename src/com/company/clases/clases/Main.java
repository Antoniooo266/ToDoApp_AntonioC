package com.company;

import com.company.clases.clases.clases.BD;
import com.company.clases.clases.clases.Tarea;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Connection conn = BD.ConexionBD();

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            boolean salir = false;
            Tarea tarea = new Tarea(0,null,null, null);

            while (!salir) {
                System.out.println("AGENDA 2021");
                System.out.println("1-Introducir nueva Tarea");
                System.out.println("2-Revisar Tareas");
                System.out.println("3-Completar Tarea");
                System.out.println("4-Salir");
                int opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        Tarea.CrearTarea(tarea);
                        Tarea.AñadirTareaBD(tarea);
                       break;
                    case 2:
                        Tarea.VisualizarTareas(tarea);
                        break;
                    case 3:
                        Tarea.CompletarTarea();
                        break;
                    case 4:
                        salir = true;
                        sc.close();
                    default:
                        break;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error con el codigo. Revisa el codigo");
            e.printStackTrace();
        }

    }

}
