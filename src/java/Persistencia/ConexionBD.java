package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level; // Importar Logger y Level
import java.util.logging.Logger; // Importar Logger

public class ConexionBD {

    private Connection conexion; // Mantén esta como la instancia de conexión

    private final String URL = "jdbc:mysql://localhost:3306/gestion_red";
    private final String USER = "root";
    private final String PASSWORD = "root"; // Considera mover esto a un archivo de configuración seguro

    // Un logger para esta clase
    private static final Logger LOGGER = Logger.getLogger(ConexionBD.class.getName());

    // El constructor ya no establecerá la conexión directamente.
    // getConexion() se encargará de eso.
    public ConexionBD() {
        // Puedes cargar el driver aquí una vez si quieres, aunque con JDBC 4.0+
        // a menudo no es estrictamente necesario si el JAR está en el classpath.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Error: Driver MySQL CJ no encontrado.", e);
        }
    }

    public Connection getConnection() {
        try {
            // Si la conexión es nula O está cerrada, intentar (re)establecerla.
            if (this.conexion == null || this.conexion.isClosed()) {
                this.conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                LOGGER.info("Conexión establecida/reestablecida."); // Cambiado el mensaje
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener/reestablecer la conexión SQL.", e);
            // Si falla, asegurar que la conexión sea null para que el siguiente intento la cree.
            this.conexion = null;
        }
        return this.conexion;
    }

    public void cerrarConexion() {
        try {
            if (this.conexion != null && !this.conexion.isClosed()) {
                this.conexion.close();
                LOGGER.info("Conexión cerrada."); // Cambiado el mensaje
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al cerrar la conexión SQL.", e);
        }
    }
}