package temaColectii;

import java.util.*;

public class Catalog {

    Map<String, Double> students = new HashMap<>();

    public void addStudent(String nume, double medie) {
        students.put(nume, medie);
    }

    public void afisareStudenti() {
        for (Map.Entry<String, Double> entry : students.entrySet()) {
            String studentName = entry.getKey();
            double studentAverage = entry.getValue();
            System.out.println("Studentul " + studentName + " are media " + studentAverage);
        }
    }

    public double cautaStudent(String numeStudent) {
        if (students.containsKey(numeStudent)) {
            return students.get(numeStudent);
        }
        return -1; // Returnează -1 dacă studentul nu este găsit
    }

    public void stergereStudent() {
        String numeStudent = "Ana";
        if (students.containsKey(numeStudent)) {
            students.remove(numeStudent);
            System.out.println("Studentul a fost sters");
        }
    }

    private static List<String> NAMES_Students = Arrays.asList("Alice", "Ana", "Robert", "Ken", "Harry");

    public List<String> alphabeticallyOrder() {
        Collections.sort(NAMES_Students);
        return NAMES_Students;
    }


}