import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    public static void main(String[] args){

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/databasejdbc?user=root")){
            System.out.println("Connection maded");

            System.out.println("Write DB entry:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();

            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO product VALUES ('"+input+"')") ;
            ResultSet result = statement.executeQuery("SELECT * FROM product");

            while(result.next())
            {
                System.out.println(result.getString("productNaam"));
            }

            statement.close();
            result.close();

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
