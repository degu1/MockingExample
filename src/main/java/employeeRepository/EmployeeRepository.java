package employeeRepository;

import com.example.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements com.example.EmployeeRepository {

    public List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
    }

    public EmployeeRepository(List<Employee> employees) {

        this.employees.addAll(employees);
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        if(employees.contains(e)){
            employees.remove(e);
        }
        employees.add(e);

        return e;
    }


}
