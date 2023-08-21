package org.example.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pojo.Employee;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeServer {
    private ArrayList<Employee> all;

    public void add(Employee employee) {
        all.add(employee);
    }

    public ArrayList<Employee> get(Predicate<Employee> predicate) {
        ArrayList<Employee> arrayList = new ArrayList<>();
        for (Employee employee : all) {
            if (predicate.test(employee)) {
                arrayList.add(employee);
            }
        }
        return arrayList;
    }

}
