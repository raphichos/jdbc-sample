DROP TRIGGER IF EXISTS tgr_employee_audit_insert;
CREATE TRIGGER tgr_employee_audit_insert
AFTER INSERT ON employees
FOR EACH ROW
  INSERT INTO employees_audit (
    employee_id, name, salary, birthday, operation
  ) VALUES (
    NEW.id, NEW.name, NEW.salary, NEW.birthday, 'I'
  );