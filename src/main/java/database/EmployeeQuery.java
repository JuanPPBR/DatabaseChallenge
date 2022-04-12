package database;

import entities.Employee;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EmployeeQuery {

    EntityManager entityManager;
    Employee employee;
    List<Employee> listEmployee = null;

    public EmployeeQuery() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        listEmployee = new ArrayList<Employee>();
    }

    public Boolean addEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber,
                               String address, String Salary, String birthDate, int idCompany) {
        employee = new Employee(idEmployee, firstName, lastName, email, phoneNumber, address, Salary, birthDate, idCompany);

        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.getTransaction().commit();

        return entityManager.contains(employee);
    }

    public List<Employee> getAllEmployee() {
        Query query=entityManager.createQuery("From Employee");
        listEmployee = (List<Employee>) query.getResultList();
        return listEmployee;
    }

    public Employee getEmployeeById(int idEmployee) {
        employee = entityManager.find(Employee.class, idEmployee);
        return employee;
    }

    public List<Employee> getEmployeeByName(String lastName)
    {
        Query query=entityManager.createQuery("SELECT p FROM Employee p WHERE p.lastName = :lastName");
        query.setParameter("lastName", lastName);
        listEmployee = query.getResultList();
        return listEmployee;
    }

    public Boolean updateEmployee(int idEmployee, String firstName, String lastName, String email, String phoneNumber, String address, String Salary, String birthDate, int idCompany)
    {
        Boolean result = false;
        employee = new Employee();

        employee = entityManager.find(Employee.class, idEmployee);
        if(employee != null) {
            employee.setIdEmployee(idEmployee);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setPhoneNumber(phoneNumber);
            employee.setAddress(address);
            employee.setSalary(Salary);
            employee.setBirthDate(birthDate);
            employee.setIdCompany(idCompany);

            entityManager.getTransaction().begin();
            entityManager.merge(employee);
            entityManager.getTransaction().commit();
            result = entityManager.contains(employee);
        }
        else ;
        return result;
    }

    public int deleteEmployee(int idEmployee)
    {
        int result = 0;
        employee = new Employee();

        employee = entityManager.find(Employee.class, idEmployee);
        if(employee != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
            result=1;
        }
        else ;
        return result;
    }
}
