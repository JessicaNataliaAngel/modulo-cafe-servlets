import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    private final String URL = "jdbc:mariadb://127.0.0.1:3306/cafe_nueva_prueba?sslMode=disable";
    private final String USUARIO = "root";
    private final String PASSWORD = "";

    // Método GET: consulta los cafés en la base de datos y los envía a listar.jsp
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String[]> lista = new ArrayList<>();

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_producto, nombre_cafe, precio FROM productos");

                        while (rs.next()) {
                String[] fila = new String[3];
                fila[0] = String.valueOf(rs.getInt("id_producto"));
                fila[1] = rs.getString("nombre_cafe");
                fila[2] = String.valueOf(rs.getDouble("precio"));
                lista.add(fila);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("listaProductos", lista);
        request.getRequestDispatcher("listar.jsp").forward(request, response);
    }

    // Método POST: recibe los datos del formulario HTML y los guarda en MySQL
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("txtNombre");
        String precioStr = request.getParameter("txtPrecio");

        try {
            double precio = Double.parseDouble(precioStr);
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);

            String sql = "INSERT INTO productos (nombre_cafe, precio) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.executeUpdate();
            con.close();

            request.setAttribute("mensaje", "Café guardado correctamente: " + nombre);
        } catch (Exception e) {
            request.setAttribute("mensaje", "Error al guardar: " + e.getMessage());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
