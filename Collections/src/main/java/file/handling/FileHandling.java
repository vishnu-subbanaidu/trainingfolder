package file.handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {

    private static File file;
    private static void createFile(String fileName) throws IOException{

       file = new File(fileName+".txt");

        file.createNewFile();

    }
    private static void write(String sentence) throws IOException {

        FileWriter Writer = new FileWriter(file);
        Writer.write(sentence);
        Writer.close();

    }
    private static void readFile() throws FileNotFoundException {

        Scanner fileReader = new Scanner(file);

        while(fileReader.hasNext()){
            String data = fileReader.nextLine();
            System.out.println(data);
        }

        fileReader.close();

    }
    private static void deleteFile(File file) {

        if(file.delete()){
            System.out.println("File are deleted successfully");
        }
        else{
            System.out.println("Error occurred: File is not deleted");
        }

    }
    private static void getFileDetails(File file) {

        System.out.println("File name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Writeable: " + file.canWrite());
        System.out.println("Readable " + file.canRead());
        System.out.println("File size in bytes :" + file.length());
    }

    private void fileHandlingSampleMethods() throws IOException{

        createFile("NewFile");

        write("The quick brown fox jumps over the lazy dog");

        readFile();

        File deleteFile = new File("deleting file");
        deleteFile(deleteFile);

        getFileDetails(file);

    }

    public static void main(String[] args) throws IOException {

        //---------------Task 1------------------------------//
        new FileHandling().fileHandlingSampleMethods();


        //---------------Task 2-----------------------------//
        CSVFileHandling CSVFile = new CSVFileHandling();

        CSVFile.CSVFileHandlingMethods(new File("csvFile2.csv"));

        }

}

