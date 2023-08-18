import org.example.pojo.Employee;
import org.example.server.EmployeeServer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class TestEmployee {
    @Test
    public void test() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("123", "aaa", '男', 20, 4000.0));
        employees.add(new Employee("1234", "bbb", '男', 36, 4000.0));
        employees.add(new Employee("12345", "ccc", '男', 20, 4000.0));
        employees.add(new Employee("12345", "ccc", '女', 20, 16000.0));
        employees.add(new Employee("12345", "ccc", '男', 35, 4000.0));
        EmployeeServer employeeServer = new EmployeeServer(employees);
        Predicate<Employee> predicat1 = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return true;
            }
        };
        Predicate<Employee> predicat2 = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                if (employee.getAge() > 35) {
                    return true;
                }
                return false;
            }
        };
        Predicate<Employee> predicat3 = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                if (employee.getSalary() > 15000 && employee.getGender() == '女') {
                    return true;
                }
                return false;
            }
        };
        Predicate<Employee> predicat4 = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                if (employee.getName() == "张三") {
                    return true;
                }
                return false;
            }
        };
        Predicate<Employee> predicat5 = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                if (employee.getAge() > 25 && employee.getSalary() < 10000 && employee.getGender() == '男') {
                    return true;
                }
                return false;
            }
        };
        System.out.println(employeeServer.get(predicat1).toString());
        System.out.println(employeeServer.get(predicat2).toString());
        System.out.println(employeeServer.get(predicat3).toString());
        System.out.println(employeeServer.get(predicat4).toString());
        System.out.println(employeeServer.get(predicat5).toString());
    }
}
