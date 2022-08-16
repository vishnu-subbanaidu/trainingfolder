package exception.handling;

class MyExceptionClass extends Exception{

    public MyExceptionClass(String value){
        System.out.println("My Exception class is working -> "+ value);
    }

}
