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

        var insert = new EmployeeEntity();
        insert.setName("Miguel");
        insert.setSalary(new BigDecimal("2800"));
        insert.setBirthday(OffsetDateTime.now().minusYears(18));
        System.out.println(insert);
        employeeDao.insert(insert);
        System.out.println(insert);

        //employeeDao.findAll().forEach(System.out::println);

        //System.out.println(employeeDao.findById(1));

        var update = new EmployeeEntity();
        update.setId(insert.getId());
        update.setName("Gabriel");
        update.setSalary(new BigDecimal("5500"));
        update.setBirthday(OffsetDateTime.now().minusYears(18).minusDays(3));
        employeeDao.update(update);

        employeeDao.delete(1);

    }

}
