package it;

import com.example.BankService;
import com.example.Employee;
import com.example.EmployeeManager;
import employeeRepository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import java.util.List;

public class EmployeeManagerAndEmplyeeRepositoryIT {

    @Test
    void IntegrationEmplyeeRepositoryAndEmployeeManager() {
        List<Employee> employeeList = List.of(new Employee("1", 100), new Employee("2", 100));
        EmployeeRepository employeeRepository =new EmployeeRepository(employeeList);
        BankService bankService = mock(BankService.class);
        EmployeeManager employeeManager =new EmployeeManager(employeeRepository, bankService);

        var actual = employeeManager.payEmployees();
        int expected = 2;

        assertThat(actual).isEqualTo(expected);
    }
}
