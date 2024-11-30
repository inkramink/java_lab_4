package org.coll2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVReaderС csvReaderExample = new CSVReaderС();
        List<Person> people = csvReaderExample.readCSV();

        for (Person person : people) {
            System.out.println(person);
        }
    }
}