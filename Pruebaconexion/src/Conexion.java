import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://127.0.0.1:3306/cafe_nueva_prueba?sslMode=disable";
        String usuario = "root";
        String password = "";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("¡Conexión exitosa a cafe_nueva_prueba!");

            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_producto, nombre_cafe, precio FROM productos");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id_producto") + " - " +
                    rs.getString("nombre_cafe") + " ($" +
                    rs.getDouble("precio") + ")"
                );
            }

            conexion.close();
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
