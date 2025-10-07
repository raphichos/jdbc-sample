import persistence.EmployeeDAO;
import org.flywaydb.core.Flyway;

public class Main {

    private final static EmployeeDAO employeeDao = new EmployeeDAO();

    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/jdbc-sample", "root", "rapha56391")
                .load();
        flyway.migrate();
    }

}
