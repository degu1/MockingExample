package employeeRepository;

import com.example.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

class EmployeeRepositoryTest {

    List<Employee> employeeList;

    public EmployeeRepositoryTest() {
        this.employeeList = List.of(new Employee("1", 100), new Employee("2", 100));
    }

    @Test
    void findAll() {
        EmployeeRepository employeeRepository = new EmployeeRepository(employeeList);

        List<Employee> actual = employeeRepository.findAll();
        List<Employee> expected = employeeList;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findAllEmptyList() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        List<Employee> actual = employeeRepository.findAll();
        List<Employee> expected = new ArrayList<>();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void save() {

        EmployeeRepository employeeRepository = new EmployeeRepository(employeeList);
        Employee employee = new Employee("3", 200);

        var actual = employeeRepository.save(employee);
        var expected = employee;

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    void saveDuplicate() {

        EmployeeRepository employeeRepository = new EmployeeRepository(employeeList);
        Employee employee = new Employee("1", 200);
        employeeRepository.save(employee);

        int index = employeeRepository.employees.indexOf(employee);

        long actualCount = employeeRepository.employees.stream()
                .filter(t -> t.getId().equals("1"))
                .count();
        long expectedCount = 1;

        var actualSalary = employeeRepository.employees.get(index).getSalary();
        var expectedSalary = 200;

        assertThat(actualCount).isEqualTo(expectedCount);
        assertThat(actualSalary).isEqualTo(expectedSalary);

    }

}