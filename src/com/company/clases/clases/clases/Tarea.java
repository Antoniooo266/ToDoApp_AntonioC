package com.company.clases.clases.clases;

import com.company.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Tarea {
    private String NombreTarea;
    private Date FechaTarea;
    @SuppressWarnings("unused")
    private String Estado ;


    public Tarea(Integer ID, String NombreTarea, Date FechaTarea, String Estado) {
        this.NombreTarea = NombreTarea;
        this.FechaTarea = FechaTarea;
        this.Estado = Estado;
    }

    public void setFechaTarea(Date fechaTarea) {
        FechaTarea = fechaTarea;
    }

    public void setNombreTarea(String NombreTarea) {
        this.NombreTarea = NombreTarea;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String toString() {
        return NombreTarea + "\n" + FechaTarea;
    }

    public static Tarea CrearTarea(Tarea tarea) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca nueva tarea: ");
        String titulo = sc.next();
        Date fecha = new Date();
        tarea.setNombreTarea(titulo);
        tarea.setFechaTarea(fecha);
        tarea.setEstado("Pendiente");
        return tarea;
    }

    public static Tarea AñadirTareaBD(Tarea tarea) throws SQLException {
        Statement stmt = null;
        stmt = Main.conn.createStatement();

        String consulta = "INSERT INTO tarea( Titulo, Fecha, Estado) VALUES(?, ?, ?)";
        PreparedStatement prpStateent = Main.conn.prepareStatement(consulta);
        try {
            prpStateent.setString(1, tarea.NombreTarea);
            prpStateent.setString(2, String.valueOf(tarea.FechaTarea));
            prpStateent.setString(3, tarea.Estado);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet rs = prpStateent.executeQuery();
        return tarea;
    }

    public static void TareasPendientes() throws SQLException {
        Statement stmt = Main.conn.createStatement();
        String sql = "SELECT * FROM tarea WHERE Estado = 'Pendiente'";
        PreparedStatement prpStatement = Main.conn.prepareStatement(sql);
        ResultSet Reader = prpStatement.executeQuery();
        if (!Reader.next()) {
            System.out.println("No tienes tareas pendientes ;)");
        } else {
            Reader.beforeFirst();
            while (Reader.next()) {
                System.out.println(Reader.getInt(1) + " " + Reader.getString(2) + "\n" + Reader.getString(3));
            }
        }
    }

    public static void CompletarTarea() throws SQLException {
        Scanner sc = new Scanner(System.in);
        TareasPendientes();
        System.out.println("¿Que tarea deseas completar? Indique el numero");
        int id = sc.nextInt();
        Statement stmt = Main.conn.createStatement();
        String sql = "UPDATE tarea SET Estado = 'Completada' WHERE ID=" + id;
        PreparedStatement prpStatement = Main.conn.prepareStatement(sql);
        ResultSet Reader = prpStatement.executeQuery();
        System.out.println("¡Tarea Completada!");
    }

    public static Tarea VisualizarTareas(Tarea tarea) throws SQLException {
        Statement stmt = Main.conn.createStatement();
        String sql = "SELECT * FROM tarea";
        PreparedStatement prpStatement = Main.conn.prepareStatement(sql);
        ResultSet Reader = prpStatement.executeQuery();
        if (!Reader.next()) {
            System.out.println("No has añadido ninguna tarea :(");
        } else {
            Reader.beforeFirst();
            while (Reader.next()) {
                System.out.println(Reader.getInt(1) + " " + Reader.getString(2) + " " + Reader.getString(3) + " " + Reader.getString(4));
            }
        }
        return tarea;
    }
}
