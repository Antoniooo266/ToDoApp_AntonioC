package com.company;

import java.util.*;

public class Tarea {

    private String NombreTarea;
    private Date FechaTarea;
    @SuppressWarnings("unused")
    private boolean Completada;

    public Tarea(String NombreTarea, Date FechaTarea, boolean Completada) {
        this.NombreTarea = NombreTarea;
        this.FechaTarea = FechaTarea;
        this.Completada = Completada;
    }
    public String getNombreTarea() {
        return NombreTarea;
    }
    public Date FechaTarea() {
        return FechaTarea;
    }
    public void setNombreTarea(String NombreTarea) {
        this.NombreTarea = NombreTarea;
    }
    public void setFechaTarea(Date FechaTarea) {
        this.FechaTarea = FechaTarea;
    }
    public void setCompletada(boolean Completada) {
        this.Completada = Completada;
    }
    public String toString() {
        return "\n" + NombreTarea + "\n" + FechaTarea;
    }
}
