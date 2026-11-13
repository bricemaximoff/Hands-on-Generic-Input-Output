package handson9;

import java.io.*;

class Employee implements Serializable {
    String name;
    int age;
    Employee(String n, int a) {
        name = n;
        age = a;
    }
}

public class SerializeDemo {
    
    public static void deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Employee restored = (Employee) ois.readObject();
            System.out.println("Deserialized dari " + filename + ": " + restored.name + ", " + restored.age);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error deserializing: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("John", 30);
        Employee e2 = new Employee("Zaidun", 19);

        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("emp1.ser"));
             ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("emp2.ser"))) {
            oos1.writeObject(e1);
            oos2.writeObject(e2);
            System.out.println("Semua objek berhasil di-serialize ke dalam file.\n");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        deserialize("emp1.ser");
        deserialize("emp2.ser");
    }
}