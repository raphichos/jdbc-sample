import persistence.EmployeeDAO;
import org.flywaydb.core.Flyway;
import persistence.EmployeeParamDAO;
import persistence.entity.EmployeeAuditDAO;
import persistence.entity.EmployeeEntity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Main {

    private final static EmployeeParamDAO employeeDao = new EmployeeParamDAO();
    private final static EmployeeAuditDAO employeeAuditDao = new EmployeeAuditDAO();

    public static void main(String[] args) {
        var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost/jdbc-sample", "root", "rapha56391")
                .load();
        flyway.migrate();

        var insert = new EmployeeEntity();
        insert.setName("Miguel'");
        insert.setSalary(new BigDecimal("2800"));
        insert.setBirthday(OffsetDateTime.now().minusYears(18));
        System.out.println(insert);
        employeeDao.insertWithProcedure(insert);
        System.out.println(insert);

        //employeeDao.findAll().forEach(System.out::println);

        //System.out.println(employeeDao.findById(1));

        var update = new EmployeeEntity();
        update.setId(insert.getId());
        update.setName("Gabriel");
        update.setSalary(new BigDecimal("5500"));
        update.setBirthday(OffsetDateTime.now().minusYears(36).minusDays(10));
        employeeDao.update(update);

        employeeDao.delete(insert.getId());

        employeeAuditDao.findAll().forEach(System.out::println);

    }

}
