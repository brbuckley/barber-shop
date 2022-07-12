package Infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class barberContext {
    private static Connection context = null;
    private static String stringConexao = "jdbc:Mysql://127.0.0.1:3307/financeiro";
    private static String nome = "com.mysql.jdbc.Driver";
    

    public static Connection getConnection() {
        if (context != null) 
            return context;        
        try {
            Properties prop = new Properties();
            
            String usuario = "root";
            String senha = "13676616766";
            
            Class.forName(nome);
            context = DriverManager.getConnection(stringConexao, usuario, senha);
            
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }        
        return context;
    }
}
