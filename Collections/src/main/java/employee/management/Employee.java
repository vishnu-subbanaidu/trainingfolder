package employee.management;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.beans.ConstructorProperties;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@Getter
@ToString
public class Employee {

    private String empName;
    private int age;
    private int salary;
    private String city;
    private char gender;
    private Date doj;

    public String toStringDb() {


        SimpleDateFormat fomatter = new SimpleDateFormat("MM-dd-YYYY");

        return "('" + empName +
                "'," + age +
                "," + salary +
                ",'" + city +
                "','" + gender +
                "','" + fomatter.format(doj) +
                "')";
    }
}
