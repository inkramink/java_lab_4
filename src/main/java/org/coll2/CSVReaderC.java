package org.coll2;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The CSVReaderC class is responsible for reading a CSV file and converting its contents into a list of Person objects.
 * It handles the parsing of the CSV file, mapping of departments, and creation of Person objects.
 */
public class CSVReaderC {
    private static final char SEPARATOR = ';';

    /**
     * Reads a CSV file and returns a list of Person objects.
     *
     * @param filePath the path to the CSV file
     * @return a list of Person objects parsed from the CSV file
     */
    public List<Person> readCSV(String filePath) {
        List<Person> people = new ArrayList<>();
        Map<String, Department> departmentMap = new HashMap<>();
        AtomicInteger departmentIdCounter = new AtomicInteger(1);

        try (InputStream in = CSVReaderC.class.getClassLoader().getResourceAsStream(filePath);
             InputStreamReader reader = in == null ? null : new InputStreamReader(in)) {
            if (reader == null) {
                throw new FileNotFoundException(filePath);
            }

            CSVParser parser = new CSVParserBuilder().withSeparator(SEPARATOR).build();
            CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();

            String[] nextLine;
            boolean isFirstLine = true;
            while ((nextLine = csvReader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                String gender = nextLine[2];
                String birthDate = nextLine[3];
                String departmentName = nextLine[4];
                double salary = Double.parseDouble(nextLine[5]);

                Department department = departmentMap.computeIfAbsent(departmentName, k -> {
                    int departmentId = departmentIdCounter.getAndIncrement();
                    return new Department(departmentId, departmentName);
                });

                Person person = new Person(id, name, gender, department, salary, birthDate);
                people.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return people;
    }
}
