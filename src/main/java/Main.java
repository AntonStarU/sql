import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Main {
    static int saleMonth;
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "";
        String nameCourse = "";
        String sqlQuery = "(SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Веб-разработчик c 0 до PRO' ORDER BY `subscription_date` DESC LIMIT 1)" +
                          "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Веб-разработчик c 0 до PRO' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Мобильный разработчик с нуля' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Мобильный разработчик с нуля' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Java-разработчик' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Java-разработчик' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'PHP-разработчик с 0 до PRO' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'PHP-разработчик с 0 до PRO' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Python-разработчик с нуля' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Python-разработчик с нуля' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Frontend-разработчик' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Frontend-разработчик' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Мобильный разработчик PRO' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Мобильный разработчик PRO' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Программист 1С-Битрикс' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Программист 1С-Битрикс' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'С#-разработчик с нуля' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'С#-разработчик с нуля' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Data Scientist с 0 до PRO' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Data Scientist с 0 до PRO' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Аналитик данных на Python' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Аналитик данных на Python' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Веб-дизайн с нуля до PRO' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Веб-дизайн с нуля до PRO' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Рекламная графика' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Рекламная графика' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'UX-дизайн' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'UX-дизайн' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Анимация интерфейсов' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Анимация интерфейсов' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Дизайн интерьеров с нуля' ORDER BY `subscription_date` DESC LIMIT 1) " +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Дизайн интерьеров с нуля' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Графический дизайнер с нуля до PRO' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Графический дизайнер с нуля до PRO' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Дизайн мобильных приложений' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Дизайн мобильных приложений' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Промо-сайты от Red Collar' ORDER BY `subscription_date` DESC LIMIT 1) " +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Промо-сайты от Red Collar' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Скетчинг для дизайнеров' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Скетчинг для дизайнеров' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Photoshop c 0 до PRO' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Photoshop c 0 до PRO' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Sound-design' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Sound-design' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Cinema4D' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Cinema4D' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Sketch' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Sketch' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Figma' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Figma' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Интернет-маркетолог от Ingate' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Интернет-маркетолог от Ingate' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'SMM-маркетолог от А до Я' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'SMM-маркетолог от А до Я' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Performance-маркетинг' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Performance-маркетинг' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Интернет-маркетолог от А до Я' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Интернет-маркетолог от А до Я' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Продвижение в Instagram' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Продвижение в Instagram' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Сквозная аналитика' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Сквозная аналитика' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Таргетолог от А до Я' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Таргетолог от А до Я' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'UX-аналитик' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'UX-аналитик' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Управление репутацией' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Управление репутацией' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Как делать контент для YouTube' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Как делать контент для YouTube' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'SEO-специалист' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'SEO-специалист' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Вирусный маркетинг' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Вирусный маркетинг' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'CRM-маркетолог' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'CRM-маркетолог' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Как открыть веб-студию' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Как открыть веб-студию' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Как открыть салон красоты' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Как открыть салон красоты' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Управление командами' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Управление командами' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Управление Digital-проектами' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Управление Digital-проектами' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Excel' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Excel' GROUP BY `course_name`)" +
                "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Продюсер онлайн-курсов' ORDER BY `subscription_date` DESC LIMIT 1)" +
                "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Продюсер онлайн-курсов' GROUP BY `course_name`)" +
                        "UNION (SELECT `course_name`, MONTH (`subscription_date`) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Управление продуктом' ORDER BY `subscription_date` DESC LIMIT 1)" +
                        "UNION (SELECT `course_name`, COUNT(*) number FROM `PurchaseList` WHERE (`subscription_date` BETWEEN '2018-01-01' AND '2018-12-31') AND `course_name` = 'Управление продуктом' GROUP BY `course_name`)";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                String currentCourseName = resultSet.getString("course_name");
                if (nameCourse.equals(currentCourseName)) {
                    int saleCourse = Integer.parseInt(resultSet.getString("number"));
                    System.out.println(nameCourse + " -> " + ((float)saleCourse / saleMonth));
                    continue;
                }
                nameCourse = currentCourseName;
                saleMonth = Integer.parseInt(resultSet.getString("number"));

            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
