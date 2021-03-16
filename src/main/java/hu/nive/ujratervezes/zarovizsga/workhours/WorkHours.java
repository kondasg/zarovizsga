package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            List<Work> works = new ArrayList<>();
            readLines(reader, works);
            sortWorks(works);
            return works.get(0).print();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }

    private void readLines(BufferedReader reader, List<Work> works) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] splittedLine = line.split(",");
            works.add(new Work(
                    splittedLine[0], Integer.parseInt(splittedLine[1]), LocalDate.parse(splittedLine[2])));
        }
    }

    private void sortWorks(List<Work> works) {
        works.sort(new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o1.getWorkingHours() - o2.getWorkingHours();
            }
        });
    }

}
