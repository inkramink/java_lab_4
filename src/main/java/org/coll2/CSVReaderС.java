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

public class CSVReaderС {
    private static final String CSV_FILE_PATH = "foreign_names.csv";
    private static final char SEPARATOR = ';';

    public List<Person> readCSV() {
        List<Person> people = new ArrayList<>();
        Map<String, Department> departmentMap = new HashMap<>();
        AtomicInteger departmentIdCounter = new AtomicInteger(1);

        try (InputStream in = CSVReaderС.class.getClassLoader().getResourceAsStream(CSV_FILE_PATH);
             InputStreamReader reader = in == null ? null : new InputStreamReader(in)) {
            if (reader == null) {
                throw new FileNotFoundException(CSV_FILE_PATH);
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
