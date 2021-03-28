package com.company.clases.clases.clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class BD {

    static final String JDBC_DRIVER="org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/todoapp2";
    static final String User = "root";
    static final String Pass = "";

    public static void main(String[] args) {
        CreacionTabla();
    }

    public static void CreacionTabla(){
        Connection conn=null;
        Statement stmt=null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("connecting to a selected database....");
            conn= DriverManager.getConnection(DB_URL,User,Pass);
            System.out.println("Connected database successfully....");

            System.out.println("creating table in given database....");
            stmt=conn.createStatement();
            String sql="CREATE TABLE TAREA "
                    +"(ID INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    +"Titulo VARCHAR(255), "
                    +"Fecha VARCHAR (255), "
                    +"Estado VARCHAR (255)) ";
            stmt.executeUpdate(sql);
            System.out.println("created table in given database...");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    if (stmt!=null){
                        conn.close();
                    }
                } catch (SQLException se) {
                }try {
                    if (conn!=null){
                        conn.close();
                    }
                }catch (SQLException se) {
                }
        }
        System.out.println("Tabla creada");
    }
    public static Connection ConexionBD(){
        Connection conn=null;
        try {
            Class.forName(BD.JDBC_DRIVER);
            conn = DriverManager.getConnection(BD.DB_URL, BD.User, BD.Pass);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

}
