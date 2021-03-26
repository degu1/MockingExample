package employeeRepository;

import com.example.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

class EmployeeRepositoryTest {

    List<Employee> employeeList = List.of(new Employee("1", 100), new Employee("2", 100));

    @Test
    @DisplayName("Test if findAll method returns all emplyee in memory.")
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

        var actual = employeeRepository.getEmployees();

        assertThat(actual).contains(employee);
    }

    @Test
    void saveDuplicate() {

        EmployeeRepository employeeRepository = new EmployeeRepository(employeeList);
        Employee employee = new Employee("1", 200);
        employeeRepository.save(employee);

        int index = employeeRepository.getEmployees().indexOf(employee);

        long actualCount = employeeRepository.getEmployees().stream()
                .filter(t -> t.getId().equals("1"))
                .count();
        long expectedCount = 1;

        var actualSalary = employeeRepository.getEmployees().get(index).getSalary();
        var expectedSalary = 200;

        assertThat(actualCount).isEqualTo(expectedCount);
        assertThat(actualSalary).isEqualTo(expectedSalary);

    }

}