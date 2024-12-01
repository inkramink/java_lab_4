package org.coll2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVReaderC csvReaderExample = new CSVReaderC();
        List<Person> people = csvReaderExample.readCSV("testfile.csv");

        for (Person person : people) {
            System.out.println(person);
        }
    }
}