package exception.handling;

import java.io.*;

public class ExceptionHandling {

    private static int divide(int a, int b) {

        if(b>a)
            throw new ArithmeticException();

        return a;
    }

    private static void index(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException{

        int[] arr = new int[4];

        arr[a] = 4;
        arr[b] = 5;

    }
    private static void readFile() throws FileNotFoundException{

        File file = new File("src/main/resources/testFile.text");

        System.out.println("text file fetched successfully !!!");

    }

    // Try, Catch and finally are used in the method
    private static void tryCatch(){

        try{
            int b=1/0;
        }
        catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
        finally {
            System.out.println("Finally block");
        }
        System.out.println("Program Executed");

    }

    //Throw concept
    private static void throwMethod(){

        try {
            divide(0, 2);
        }
        catch(ArithmeticException e){
            System.out.println("Arithmetic Exception is handled");
        } catch (Exception e) {
            System.out.println("Exception is handled");
        }
        System.out.println("End of the program");

    }

    //Throws concept
    private static void throwsMethod(){

        try {
            index(2, 7);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

    //Handling fileNotFoundException
    private static void fileNotFoundException(){

        try {
            readFile();
        }
        catch(FileNotFoundException e){
            System.out.println("File is not found");
        }

    }

    //User defined exception handling
    private static void createExceptionClass(){

        try{
            throw new MyExceptionClass("File is not found");
        }
        catch(Exception e){
            System.out.println("End of the program");
        }
    }

    //Multiply catch block
    private static void multiplyCatchMethod(){

        try{

            int c= 9/0;

            String str=null;

            str.equalsIgnoreCase("and");

            int arr[] = new int[5];

            System.out.println(arr[7]);


        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {

        //tryCatch();

        //throwMethod();

        //throwsMethod();

        //fileNotFoundException();

        createExceptionClass();

        //multiplyCatchMethod();

    }

}



