package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {

    @Test
    void payEmployeetestCallsBankServiceWithTestDouble() {
        EmployeeRepository testEmployeeRepository = new TestEmployeeRepository();
        TestBankService testBankService = new TestBankService();
        EmployeeManager employeeManager = new EmployeeManager(testEmployeeRepository, testBankService);
        employeeManager.payEmployees();

        var actual = testBankService.payCalled;

        assertThat(actual).isTrue();
    }

    @Test
    void payEmployeeReternsCorrectValueWithMockito() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);
        when(employeeRepository.findAll())
                .thenReturn(List.of(new Employee("1", 1)));
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        var actual = employeeManager.payEmployees();

        assertThat(actual).isEqualTo(1);
    }

    @Test
    void payEmplyeeHandelsRuntimeExeptionWithMockito() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);
        when(employeeRepository.findAll())
                .thenReturn(List.of(new Employee("1", 1)));
        doThrow(RuntimeException.class)
                .when(bankService)
                .pay("1", 1);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);

        var actual = employeeManager.payEmployees();

        assertThat(actual).isEqualTo(0);
    }
}