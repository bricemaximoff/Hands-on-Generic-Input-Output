package handson10;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

class DataRecord<T, U, V> {
    private T field1;
    private U field2;
    private V field3;

    public DataRecord(T field1, U field2, V field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    @Override
    public String toString() {
        return field1 + ", " + field2 + ", " + field3;
    }
}

public class ProdukWriterNew {
    public static void main(String[] args) {
        List<DataRecord<String, Double, Integer>> produkList = new ArrayList<>();
        produkList.add(new DataRecord<>("Laptop", 15000000.0, 10));
        produkList.add(new DataRecord<>("Mouse", 150000.0, 50));
        produkList.add(new DataRecord<>("Keyboard", 350000.0, 25));
        
        List<DataRecord<Integer, String, Boolean>> pelangganList = new ArrayList<>();
        pelangganList.add(new DataRecord<>(101, "Zaidun", true));
        pelangganList.add(new DataRecord<>(102, "Fathan", false));

        Path fileProduk = Paths.get("produk_output.txt");
        Path filePelanggan = Paths.get("pelanggan_output.txt");

        try {
            // --- PROSES MENULIS KE FILE ---
            List<String> barisProduk = new ArrayList<>();
            for (DataRecord<String, Double, Integer> p : produkList) {
                barisProduk.add(p.toString());
            }
            Files.write(fileProduk, barisProduk);
            
            List<String> barisPelanggan = new ArrayList<>();
            for (DataRecord<Integer, String, Boolean> p : pelangganList) {
                barisPelanggan.add(p.toString());
            }
            Files.write(filePelanggan, barisPelanggan);
            
            System.out.println("Data berhasil disimpan ke file.\n");

            // --- PROSES MEMBACA DARI FILE ---
            System.out.println("Membaca isi produk_output.txt:");
            List<String> readProduk = Files.readAllLines(fileProduk);
            for (String line : readProduk) {
                System.out.println(line);
            }
            
            System.out.println("\nMembaca isi pelanggan_output.txt:");
            List<String> readPelanggan = Files.readAllLines(filePelanggan);
            for (String line : readPelanggan) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Gagal memproses file: " + e.getMessage());
        }
    }
}