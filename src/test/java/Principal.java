import helper.CrudEmployee;

public class Principal {

    protected static CrudEmployee crudEmployee = new CrudEmployee();

    public static void main(String[] args)
    {
         crudEmployee.getAllEmployees();
         crudEmployee.findEmployeeId(1);//check
         crudEmployee.findEmployeeName("Juan");//check
         crudEmployee.insertEmployee(8, "Pedro", "Rodriguez", "pr@gmail.com", "7555685", "Calle 75", "7500", "1995/12/12", 1);//check
         crudEmployee.updateEmployee(8, "Pedro", "Rodriguez", "pr@gmail.com", "3145559", "Calle 75", "7500", "95/12/12",1);
         crudEmployee.deleteEmployee(8);
    }
}
