package other.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class CheckedExceptions {
    public static void main(String[] args) {
        writeToFile();
    }

    private static void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter("/path....");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readFromFile(){
        try {
            FileReader fileReader = new FileReader("/path...");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Class<?> loadClassInformation() {
        //loads information of a given class
        //forName requires exception check for "ClassNotFound"
        try {
            return Class.forName("gr.codelearn.core.showcase.exception.domain.ClassA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void connectToDatabase() {
        //tries to connect to a MySQL database
        //multiple methods such as getConnection require an exception check for "SQLException"
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/codehub", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from students");
            while (rs.next()) {
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void customMethod(){
        try {
            throwCheckedException();
        } catch (CustomCheckedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void throwCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException();
    }
}