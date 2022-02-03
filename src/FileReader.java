import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    public String[] readFileLinesOrNull(String path) {
        try {
            String fileContent = Files.readString(Path.of(path)); //read the file
            String[] reportLines = fileContent.split("\\n"); //split each string and put them into array
            return reportLines;
        } catch (IOException e) {
            //System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}
