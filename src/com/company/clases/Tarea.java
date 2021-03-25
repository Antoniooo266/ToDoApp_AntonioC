package com.company.clases;

import java.io.*;
import java.util.*;

public class Tarea {

    private String NombreTarea;
    private Date FechaTarea;
    @SuppressWarnings("unused")
    private boolean Completada;
    public static Hashtable TareaP;
    public static Hashtable TareaC;
    public FileWriter file;
    public static PrintWriter pw;

    public Tarea(String NombreTarea, Date FechaTarea, boolean Completada) throws IOException {
        this.NombreTarea = NombreTarea;
        this.FechaTarea = FechaTarea;
        this.Completada = Completada;
        TareaP = new Hashtable<Tarea, Boolean>();
        TareaC = new Hashtable<Tarea, Boolean>();
        file = new FileWriter("src\\com\\company\\agenda",true);
        pw = new PrintWriter(file);
    }

    public void setFechaTarea(Date fechaTarea) {
        FechaTarea = fechaTarea;
    }

    public void setNombreTarea(String NombreTarea) {
        this.NombreTarea = NombreTarea;
    }

    public String toString() {
        return NombreTarea + "\n" + FechaTarea;
    }

    public static Tarea CrearTarea(Tarea tarea){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca nueva tarea: ");
        String titulo = sc.next();
        Date fecha = new Date();
        tarea.setNombreTarea(titulo);
        tarea.setFechaTarea(fecha);
        return tarea;
    }

    public static Tarea CompletarTarea(Tarea tarea){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la tarea que quiere completar: ");

        return tarea;
    }

}
