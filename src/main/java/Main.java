import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "";
        String sqlQuery = "SELECT pl.`course_name`, " +
                          "(COUNT(*) / ((MONTH(MAX(pl.`subscription_date`)) - MONTH(MIN(pl.`subscription_date`))) + 1)) `middle` " +
                "FROM `PurchaseList` pl " +
                "WHERE YEAR(pl.`subscription_date`) = 2018 " +
                "GROUP BY pl.`course_name`;";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                String name = resultSet.getString("course_name");
                String middle = resultSet.getString("middle");
                System.out.println(name + " - " + middle);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
