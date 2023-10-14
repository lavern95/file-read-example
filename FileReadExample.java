import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}

public class FileReadExample {
    public static void main(String[] args) {
        String fileName = "example.txt";

        try {
            checkIfFileIsEmpty(fileName);
            System.out.println("File is not empty.");
        } catch (EmptyFileException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static void checkIfFileIsEmpty(String fileName) throws EmptyFileException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        if (reader.readLine() == null) {
            reader.close();
            throw new EmptyFileException("File is empty.");
        }
        reader.close();
    }
}
