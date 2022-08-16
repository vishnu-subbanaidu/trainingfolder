package employee.management;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.max;
import static java.util.Collections.min;

public class ManagementMain {

    private void sortListByName(List<Employee> employeeLists){

       // employeeLists.sort(Comparator.comparing(employee -> employee.getEmpName().toUpperCase()));

        System.out.println("-------------------Sort by Name Ascending order:-----------------------");
        employeeLists.sort(Comparator.comparing(Employee::getEmpName));
       // employeeLists.forEach(employee -> System.out.println(employee.getEmpName() +" " + employee.toString()));

        //List<String> empName = employeeLists.stream().collect(employeeLists.g)

        List<String> employeeNameAsc = employeeLists.stream().map(Employee::getEmpName).collect(Collectors.toList());
        System.out.println(employeeNameAsc);

        System.out.println("--------------------Sort by Name Descending order:-------------------------");
        employeeLists.sort((Employee emp1, Employee emp2)-> emp2.getEmpName().compareTo(emp1.getEmpName()));

        List<String> employeeNameDescList = employeeLists.stream().map(Employee::getEmpName).collect(Collectors.toList());
        String employeeNameDesc = String.join(",", employeeNameDescList);

        System.out.println(employeeNameDesc);

        //employeeLists.forEach(employee1 -> System.out.println(employee1.getEmpName() +" " + employee1.toString()));
    }

    private void maxMinAge(List<Employee> employeeLists){

        System.out.println("--------------------------Maximum age and minimum age of any employee-----------------------------");

        Employee maxAgeData=max(employeeLists, Comparator.comparing(Employee::getAge));

        Employee minAgeData=min(employeeLists, Comparator.comparing(Employee::getAge));

        System.out.println("Max Age: "+maxAgeData.getAge()+" "+"Employee Name: "+maxAgeData.getEmpName());

        System.out.println("min Age: "+minAgeData.getAge()+" "+"Employee Name: "+minAgeData.getEmpName());

    }

    private void filterBasedOnGender(List<Employee> employeeLists){

        List<Employee> maleList = employeeLists.stream().filter(employee -> employee.getGender()=='M').toList();
        List<Employee> femaleList = employeeLists.stream().filter(employee -> employee.getGender()=='F').toList();

        System.out.println("-------------------Filter By Gender - Male-----------------------");
        maleList.forEach(employee -> System.out.println("Employee Name: "+employee.getEmpName() +" Employee Gender: " + employee.getGender()));

        System.out.println("-------------------Filter By Gender - Female-----------------------");
        femaleList.forEach(employee -> System.out.println("Employee Name: "+employee.getEmpName() +" Employee Gender: " + employee.getGender()));


    }

    private void recentlyJoinedEmployee(List<Employee> employeeList){

        Employee emp = max(employeeList, Comparator.comparing(Employee::getDoj));

        System.out.println(emp);

    }
    private void sortListBySalary(List<Employee> employeeLists){

        //employeeLists.sort(Comparator.comparingInt(Employee::getSalary));
        System.out.println("-----------------------Sort By Salary in ASC-----------------------------");
        employeeLists.sort(Comparator.comparingInt(Employee::getSalary));
        employeeLists.forEach(employee -> System.out.println(employee.getEmpName() +" " + employee.getSalary()));

        System.out.println("-----------------------Sort By Salary in DESC-----------------------------");
        employeeLists.sort((employee1, employee2)-> Integer.compare(employee2.getSalary(), employee1.getSalary()));
        employeeLists.forEach(employee -> System.out.println(employee.getEmpName() +" " + employee.getSalary()));

    }

    private void sortByJoiningDate(List<Employee> employeeLists){

        SimpleDateFormat spFormatter = new SimpleDateFormat("dd-MM-YYYY");


        System.out.println("-----------------------Sort By DOJ ASC-----------------------------");
        employeeLists.sort(Comparator.comparing(Employee::getDoj));

        employeeLists.forEach(employee -> System.out.println(employee.getEmpName() +" " + spFormatter.format(employee.getDoj())));


        System.out.println("-----------------------Sort By DOJ DESC-----------------------------");
        employeeLists.sort((Employee emp1, Employee emp2)-> emp2.getDoj().compareTo(emp1.getDoj()));

        employeeLists.forEach(employee -> System.out.println(employee.getEmpName() +" " + spFormatter.format(employee.getDoj())));

    }


    public List<Employee> employeeData(){

        Employee employee1= new Employee("Naveen", 22, 30000, "Chennai", 'M', new Date(1999, Calendar.SEPTEMBER,21));
        Employee employee2= new Employee("Parveen", 25, 15000, "Coimbatore", 'M', new Date(2021-1900, Calendar.MARCH,15));

        Employee employee3= new Employee("Ravi", 27, 45000, "Madurai", 'M', new Date(2015-1900, Calendar.JULY,13));
        Employee employee4= new Employee("Lakshmi", 35, 15000, "trichy", 'F', new Date(1990-1900, Calendar.APRIL,9));

        Employee employee5= new Employee("Jeyashree", 43, 20000, "theni", 'F', new Date(2009-1900, Calendar.AUGUST,5));
        Employee employee6= new Employee("Asra", 19, 50000, "vellore", 'F', new Date(1995-1900, Calendar.OCTOBER,19));

        Employee employee7= new Employee("Ruban", 29, 42000, "karur", 'M', new Date(2003-1900, Calendar.DECEMBER,12));
        Employee employee8= new Employee("Ezhil", 37, 27000, "tanjore", 'F', new Date(2017-1900, Calendar.SEPTEMBER,27));

        List<Employee> employee= new ArrayList<>();

        employee.add(employee1);
        employee.add(employee2);
        employee.add(employee3);
        employee.add(employee4);
        employee.add(employee5);
        employee.add(employee6);
        employee.add(employee7);
        employee.add(employee8);

        return  employee;
    }

@Deprecated
    public static void main(String[] args){

        ManagementMain select = new ManagementMain();

        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        switch(n){

            case 1 -> select.sortListByName(select.employeeData());
            case 2 -> select.maxMinAge(select.employeeData());
            case 3 -> select.filterBasedOnGender(select.employeeData());
            case 4 -> select.sortListBySalary(select.employeeData());
            case 5 -> select.recentlyJoinedEmployee(select.employeeData());
            case 6 -> select.sortByJoiningDate(select.employeeData());

        }

        sc.close();

    }

}
