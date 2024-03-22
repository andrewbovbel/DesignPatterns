package Decorator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Decorator {
    public static void main(String[] args) {
        System.out.println("hi");
        DataSource source = new FileDataSource("hi.txt");
        source.writeData("hi");
        if (true)
            source = new EncryptionDecorator(source);
            source.writeData("hi");
        if (true)
            source = new CompressionDecorator(source);
            source.writeData("hi");

    
    }

    
}


class FileDataSource implements DataSource {
    File file;
    public FileDataSource(String fileName) {
        file = new File(fileName);
        file.canRead();
        file.canWrite();
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("an erorr occured: " + e.getMessage());
        }
        
    }

    public void writeData(String data) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Writing text to the file
            bufferedWriter.write(data);

            // Close the BufferedWriter
            bufferedWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

       
    }

    public String readData(File file) {
        try {
        // FileReader with BufferedReader
        FileReader fileReader = new FileReader(file.getAbsolutePath());
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Read the file line by line
        String line;
        String data = "";

        while ((line = bufferedReader.readLine()) != null) {
            data+=line;
        }

        // Close the BufferedReader
        bufferedReader.close();
        return data;
    } catch (IOException e) {
        // Handle exceptions
        System.out.println("An error occurred: " + e.getMessage());
        e.printStackTrace();
        return "error";
    }
    }
}

class DataSourceDecorator implements DataSource {
    protected DataSource wrappee;

    public DataSourceDecorator(DataSource s) {
        wrappee = s;
    }

    public void writeData(String data) {
        wrappee.writeData(data);
    }

    public String readData(File file) {
        return wrappee.readData(file);
    }
}

class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource s) {
        super(s);
        //TODO Auto-generated constructor stub
    }

    public void writeData(String data) {
        data = data + "0000";
        wrappee.writeData(data);
    }

    public String readData(File file) {
        String data = wrappee.readData(file);
        data = "1111";
        return data;
    }
}

class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource s) {
        super(s);
        //TODO Auto-generated constructor stub
    }

    public void writeData(String data) {
        data = data + "x";
        wrappee.writeData(data);
    }

    public String readData(File file) {
        String data = wrappee.readData(file);
        data = "y";
        return data;
    }
}

