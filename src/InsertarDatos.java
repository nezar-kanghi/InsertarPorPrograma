import java.sql.*;
import java.util.Scanner;

public class InsertarDatos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String usuario = "RIBERA";
        String password = "ribera";

        try(Connection conexion = DriverManager.getConnection(url,usuario,password)){

            //PEDIMOS LOS DATOS

            System.out.println("Ingresa el id que quieres insertar: ");
            int idS = sc.nextInt();
            sc.nextLine();
            System.out.println("Ingresa el nombre que quieres insertar: ");
            String nombreS = sc.nextLine();
            System.out.println("Ingresa el salario que quieres insertar: ");
            double salarioS = sc.nextDouble();

            String sql ="INSERT INTO empleadoEjemplo (id, nombre, salario) VALUES (?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, idS); //AÑADIMOS LOS DATOS
            ps.setString(2, nombreS);
            ps.setDouble(3, salarioS);
            int n = ps.executeUpdate(); //devuelve el numero de registros que a añadido
            System.out.println("Empleado insertado exitosamente" + n);
        }catch (SQLException e){
            System.out.println("Error al añadir a la tabla" + e.getMessage());
        }
    }
}
