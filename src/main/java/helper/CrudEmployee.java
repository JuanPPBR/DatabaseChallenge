package helper;


import entities.Employee;
import database.EmployeeQuery;

import java.util.List;


public class CrudEmployee {
    protected Employee employee = new Employee();
    protected EmployeeQuery employeeQuery = new EmployeeQuery();
    protected List<Employee> resultsEmployee;

    public CrudEmployee() {

    }

    public void insertEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber,
                               String address, String Salary, String birthDate, int idCompany) {
        Boolean result = employeeQuery.addEmployee(idEmployee, firstName, lastName, email, phoneNumber, address,
                Salary, birthDate, idCompany);

        if ( result == true )
            System.out.println(" employee Added ");
        else
            System.out.println(" employee NOT Added ");
    }

    public void getAllEmployees() {
        resultsEmployee = employeeQuery.getAllEmployee();
        for (Employee employee : resultsEmployee) {
            System.out.print(employee.getIdEmployee()+"  -  ");
            System.out.print(employee.getFirstName()+"  -  ");
            System.out.print(employee.getLastName()+"  -  ");
            System.out.print(employee.getEmail()+"  -  ");
            System.out.print(employee.getPhoneNumber()+"  -  ");
            System.out.print(employee.getAddress()+"  -  ");
            System.out.print(employee.getSalary()+"  -  ");
            System.out.print(employee.getBirthDate()+"  -  ");
            System.out.println(employee.getIdCompany());
        }
    }

    public void findEmployeeId(int idEmployee) {
        employee = employeeQuery.getEmployeeById(idEmployee);
        System.out.print(employee.getIdEmployee()+"  -  ");
        System.out.print(employee.getFirstName()+"  -  ");
        System.out.print(employee.getLastName()+"  -  ");
        System.out.print(employee.getEmail()+"  -  ");
        System.out.print(employee.getPhoneNumber()+"  -  ");
        System.out.print(employee.getAddress()+"  -  ");
        System.out.print(employee.getSalary()+"  -  ");
        System.out.print(employee.getBirthDate()+"  -  ");
        System.out.println(employee.getIdCompany());
    }

    public void findEmployeeName(String firstName) {
        resultsEmployee = employeeQuery.getEmployeeByName(firstName);
        for (Employee employee : resultsEmployee) {
            System.out.print(employee.getIdEmployee()+"  -  ");
            System.out.print(employee.getFirstName()+"  -  ");
            System.out.print(employee.getLastName()+"  -  ");
            System.out.print(employee.getEmail()+"  -  ");
            System.out.print(employee.getPhoneNumber()+"  -  ");
            System.out.print(employee.getAddress()+"  -  ");
            System.out.print(employee.getSalary()+"  -  ");
            System.out.print(employee.getBirthDate()+"  -  ");
            System.out.println(employee.getIdCompany());
        }
    }

    public void updateEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber,
                               String address, String Salary, String birthDate, int idCompany) {
        Boolean result = employeeQuery.updateEmployee(idEmployee, firstName, lastName, email, phoneNumber, address,
                Salary, birthDate, idCompany);
        if ( result == true )
            System.out.println(" employee Updated ");
        else
            System.out.println(" employee NOT Updated ");
    }

    public void deleteEmployee(int idEmployee) {
        int result = employeeQuery.deleteEmployee(idEmployee);

        if ( result == 1 )
            System.out.println(" employee Deleted ");
        else
            System.out.println(" employee NOT Deleted ");
    }
}
