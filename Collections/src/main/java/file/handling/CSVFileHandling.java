package file.handling;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVFileHandling {

 public static File file;
    public void CSVFileHandlingMethods(File file) throws IOException {

        this.file = file;
        createCSVFile(this.file);
        writeCSVFile(this.file);
        readCSVFile(this.file);

    }

    private void readCSVFile(File file) throws IOException {

        CSVReader readerFile = new CSVReader(new FileReader(file));

        List list = readerFile.readAll();

        list.forEach(values ->{
            System.out.println(Arrays.toString((String[])values));
        });


        System.out.println(this.file.getName());

        readerFile.close();
    }

    private File createCSVFile(File file) {

        try {
            file.createNewFile();
            System.out.println("File is created Successfully");
        }
        catch(IOException e){
            System.out.println("File is not created: "+e);
        }

        return file;
    }

    private void writeCSVFile(File file) throws IOException {

        List<String[]> studentDetails = new ArrayList<>();
        String[] header = new String[]{"Name","Student ID", "Address", "Marks obtained"};
        studentDetails.add(header);
        studentDetails.add(new String[]{"Name 1", "001", "Address 1", "432"});
        studentDetails.add(new String[]{"Name 2", "002", "Address 2", "423"});
        studentDetails.add(new String[]{"Name 3", "003", "Address 3", "432"});
        studentDetails.add(new String[]{"Name 4", "004", "Address 4", "446"});
        studentDetails.add(new String[]{"Name 5", "005", "Address 5", "478"});
        studentDetails.add(new String[]{"Name 6", "006", "Address 6", "445"});

        FileWriter fileWrite = new FileWriter(file);

        CSVWriter writer = new CSVWriter(fileWrite);

        writer.writeAll(studentDetails);

        fileWrite.append("End Of the file");

        writer.close();

    }

}
