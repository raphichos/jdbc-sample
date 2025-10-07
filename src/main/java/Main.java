import persistence.EmployeeDAO;
import org.flywaydb.core.Flyway;
import persistence.entity.EmployeeEntity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {

    private final static EmployeeDAO employeeDao = new EmployeeDAO();

    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/jdbc-sample", "root", "rapha56391")
                .load();
        flyway.migrate();

        /*var employee = new EmployeeEntity();
        employee.setName("Miguel");
        employee.setSalary(new BigDecimal("2800"));
        employee.setBirthday(OffsetDateTime.now().minusYears(18));
        System.out.println(employee);
        employeeDao.insert(employee);
        System.out.println(employee);*/
    }

}
