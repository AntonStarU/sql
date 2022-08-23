import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "";
        String saleMonth = "";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet rs = statement
                    .executeQuery("SELECT MONTH(`subscription_date`) month FROM `PurchaseList` pl ORDER BY`subscription_date` DESC LIMIT 1;");
            while (rs.next()) {
                saleMonth = rs.getString("month");
            }

            ResultSet resultSet = statement
                    .executeQuery("SELECT pl.`course_name`, (COUNT(*)/" + saleMonth + ") `count` FROM `PurchaseList` pl GROUP BY pl.`course_name`;");
            while (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                String average = resultSet.getString("count");
                System.out.println(courseName + " -> " + average);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
