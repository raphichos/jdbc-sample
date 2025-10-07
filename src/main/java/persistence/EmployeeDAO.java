package persistence;

import com.mysql.cj.jdbc.StatementImpl;
import persistence.entity.EmployeeEntity;

import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeDAO {

    public void insert(final EmployeeEntity entity){
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement();
        ){
            var sql = "INSERT INTO employees (name, salary, birthday) values ('" +
                    entity.getName() + "', " +
                    entity.getSalary().toString() + ", " +
                    "'" + formatOffsetDateTime(entity.getBirthday()) + "' )";
            statement.executeUpdate(sql);
            //System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());
            if (statement instanceof StatementImpl impl)
                entity.setId(impl.getLastInsertID());
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity){

    }

    public void delete(final long id){

    }

    public List<EmployeeEntity> findAll(){
        return null;
    }

    public EmployeeEntity findById(final long id){
        return null;
    }

    private String formatOffsetDateTime(final OffsetDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
