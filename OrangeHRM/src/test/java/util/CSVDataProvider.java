package util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVDataProvider {
    

    @DataProvider(name = "employeeData")
    public static Iterator<Object[]> getEmployeeData() throws IOException, CsvException {
        return getDataFromCSV("employee_data.csv");
    }
    
    @DataProvider(name = "userData")
    public static Iterator<Object[]> getUserData() throws IOException, CsvException {
        return getDataFromCSV("user_data.csv");
    }
    
    private static Iterator<Object[]> getDataFromCSV(String fileName) throws IOException, CsvException {
        List<Object[]> data = new ArrayList<>();
        
        // Get the absolute path to the resources directory
        String resourcesDir = System.getProperty("user.dir") + 
                             "/src/test/java/resources/";
        File file = new File(resourcesDir + fileName);
        
        System.out.println("Looking for file at: " + file.getAbsolutePath());
        
        if (!file.exists()) {
            throw new IllegalArgumentException("File not found: " + file.getAbsolutePath());
        }
        
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            // Skip header row
            String[] headers = reader.readNext();
            
            String[] line;
            while ((line = reader.readNext()) != null) {
                data.add(line);
            }
        }
        return data.iterator();
    }
}