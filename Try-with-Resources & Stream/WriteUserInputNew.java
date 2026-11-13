package handson8;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class WriteUserInputNew {
    public static void main(String[] args) {
        // Menggunakan Try-with-Resources agar Scanner dan BufferedWriter otomatis ditutup
        try (Scanner sc = new Scanner(System.in);
             BufferedWriter bw = Files.newBufferedWriter(Paths.get("user_input.txt"), 
                                                         StandardOpenOption.CREATE, 
                                                         StandardOpenOption.APPEND)) {
            
            System.out.println("Masukkan teks (ketik 'exit' untuk berhenti): ");
            
            while (true) {
                System.out.print("> ");
                String text = sc.nextLine();
                
                // Berhenti jika pengguna mengetik 'exit' (tidak sensitif huruf besar/kecil)
                if (text.equalsIgnoreCase("exit")) {
                    break;
                }
                
                // Menambahkan timestamp (waktu saat ini) pada setiap baris input
                String lineWithTimestamp = "[" + LocalDateTime.now() + "] " + text;
                
                // Menulis ke dalam file
                bw.write(lineWithTimestamp);
                bw.newLine(); // Pindah ke baris baru di dalam file teks
            }
            
            System.out.println("Data berhasil disimpan ke user_input.txt!");
            
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
