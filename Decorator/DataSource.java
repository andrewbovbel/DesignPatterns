import java.io.File;

public interface DataSource {
    void writeData(String data);
    String readData(File file);
}