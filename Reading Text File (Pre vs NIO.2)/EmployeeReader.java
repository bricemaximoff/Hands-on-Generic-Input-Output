package handson6.src.file_io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReader {
    public static void main(String[] args) {
        Path path = Paths.get("employees.txt");
        Path outPath = Paths.get("copy_employees.txt");
        List<String> employeeList = new ArrayList<>();

        if (Files.notExists(path)) {
            System.out.println("File employees.txt tidak ditemukan!");
            return;
        }

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                employeeList.add(line);
                System.out.println(line);
            }
            
            Files.write(outPath, employeeList, StandardCharsets.UTF_8);
            System.out.println("\nBerhasil menyalin data ke " + outPath.getFileName());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
