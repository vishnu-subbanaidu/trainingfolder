package jdbc.learning;

import employee.management.Employee;
import employee.management.ManagementMain;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class JdbcMain {

    private static final JdbcMain run = new JdbcMain();
    private static PropertiesFileLoader loadData;

    private static Connection connection;

    private static void getDbConnection() throws SQLException {

        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        //com.microsoft.sqlserver.jdbc.SQLServerDriver
         connection = DriverManager.getConnection(loadData.getDbUrl(), loadData.getConfig("userName"),
                loadData.getConfig("password"));

    }
    public void updateDataOnDB(String query) {

            try {

                Statement statement = connection.createStatement();

                statement.executeUpdate(query);

                System.out.println("Query executed successfully");
            }
            catch (SQLException e){
                System.out.println("Error in DB connection"+ e);
            }

    }
    public ResultSet getDataFromDB(String query){

        System.out.println("Executing Query");

        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            System.out.println("Query executed successfully");

            return rs;
        }
        catch (SQLException e){
            System.out.println("Error in DB connection : "+ e);
        }
        return null;
    }
    private static String generateQueryToAddEmployee(List<Employee> employees){

        //String insertQuery = "INSERT INTO employee (Name, Age, Salary, City, Gender, Doj) VALUES('John',24 ,15670 , 'kanchi', 'M', '12-03-1973');";

        StringBuilder queryString = new StringBuilder("INSERT INTO employee (Name, Age, Salary, City, Gender, Doj) VALUES ");

        int count=0;

        for(Employee employee : employees){

            queryString.append(employee.toStringDb());

            if(!(count==employees.size()-1))
                queryString.append(',');

            count++;
        }

        queryString.append(";");

        return queryString.toString();
    }
    private void insertEmployeeDetails() {

        ManagementMain getValue = new ManagementMain();

        List<Employee> employee= getValue.employeeData();

        run.updateDataOnDB(generateQueryToAddEmployee(employee));

        System.out.println(generateQueryToAddEmployee(employee));

    }
    private void sortedDataBy(String value, String sortBy) throws SQLException {

        String query = "SELECT Name,"+value+" from employee order by " + value + " "+ sortBy + ";";

        ResultSet result = getDataFromDB(query);

        while(result.next()){

            System.out.println(result.getString("Name")+ " "+ result.getString(value));

        }

    }
    private void maxMinData(String value, String order) throws SQLException {

        String query = "SELECT Name,"+value+" from employee WHERE "+value+" = (SELECT "+order+"("+value+") from employee)";

        ResultSet result = getDataFromDB(query);

        while(result.next()){

            System.out.println(result.getString("Name")+" "+result.getString(value));

        }


    }
    private void listByGender(String gender) throws SQLException {

        String query = "SELECT Name, Gender from employee WHERE Gender = '"+gender+"'";

        ResultSet result = getDataFromDB(query);

        while(result.next()){

            System.out.println(result.getString("Name")+" "+result.getString("Gender"));

        }
    }
    private void updateFieldDb(String id, String field, String value) {

        String query;

        if(field.equalsIgnoreCase("salary")||field.equalsIgnoreCase("age")) {
            query = "Update employee SET " + field + " = " + value + " WHERE id = '" + id + "';";
        }
        else{
            query = "Update employee SET " + field + " = '" + value + "' WHERE id = '" + id + "';";
        }

        updateDataOnDB(query);

    }

    public static void main(String[] arg) throws IOException, SQLException {

       loadData = new PropertiesFileLoader();


       String query="CREATE TABLE employee ("+
               "Name VARCHAR(25)," +
               "Age INT," +
               "Salary INT," +
               "City VARCHAR(15)," +
               "Gender CHAR," +
               "Doj Date" +
               ");";


        Scanner scanInput = new Scanner(System.in);
        System.out.println("1. Enter the student table");
        System.out.println("2. Insert the Employee details");
        System.out.println("3. Get Sorted details");
        System.out.println("4. Get max or Min Values of employee by age");
        System.out.println("5. Get the recently join employee id");
        System.out.println("6. Filter the data by gender");
        System.out.println("7. Update the details of employee");


       int option = scanInput.nextInt();
       try{
       getDbConnection();
       switch (option) {

           case 1 -> {
               System.out.println("Create tables");
               run.updateDataOnDB(query);
           }

           case 2 -> run.insertEmployeeDetails();

           case 3 -> {
               System.out.println("Enter the parameter to sort:(Name/salary/doj) ");

               String value = scanInput.next();

               System.out.println("Enter the sorting method:(ASC, DESC) ");
               String sortBy = scanInput.next();

               run.sortedDataBy(value, sortBy);
           }

           case 4 -> {
               System.out.println("Max or Min:  ");

               String value = scanInput.next();

               run.maxMinData("Age", value);
           }

           case 5 -> {
               System.out.println("Recently join employee id and Date Of Joining");

               run.maxMinData("Doj", "Max");

           }

           case 6 -> {

               System.out.println("Male / Female (M, F):  ");

               String value = scanInput.next();

               System.out.println("Employee id and gender");

               run.listByGender(value);

           }

           case 7 -> {

               System.out.println("Enter the Employee id to update the details");

               String id = scanInput.next();

               System.out.println("Enter the Field name:");

               String field = scanInput.next();

               System.out.println("Enter the new value");

               String value = scanInput.next();

               run.updateFieldDb(id, field, value);

           }
       }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       finally {
           connection.close();
       }
    }
}
