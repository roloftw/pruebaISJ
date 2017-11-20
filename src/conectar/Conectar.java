package conectar;
import java.sql.*;

/**
 *
 * @author Rolando Escobar
 */
public class Conectar {

    //se agrega al Project>Libraries>Add JAR (archivo conectar descargado del drive del profe
    //se agrega al Project>Libraries>Add Library>MySQL JDBC Driver
    
    //definición de variables
    private static Connection conn;
    
    //ruta del driver
    private static final String driver = "com.mysql.jdbc.Driver";
    
    //nombre de usuario definido en phpMyAdmin
    private static final String user = "root";
    private static final String password = "rolando";
    
    //url = conectarse al JDBC, localhost, puerto (ver en xampp control center), nombre de la tabla creada
    private static final String url = "jdbc:mysql://127.0.0.1:3306/ventas";
    
    //método constructor

    public Conectar() {
        conn = null;
        //try-catch para llamar al driver
        try {
            Class.forName(driver);
            //castear a variable Connection
            conn = (Connection) DriverManager.getConnection(url, user, password);
            if(conn != null) {
                System.out.println("Se ha establecido la conexión");
            }
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar (" + e + ")");
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    public void desconectar() {
        conn = null;
        if(conn == null) {
            System.out.println("Se ha finalizado la conexión");
        }
    }
}
