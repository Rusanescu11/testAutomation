package temaColectii;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.addStudent("Alice Diaconescu", 8.5);
        catalog.addStudent("Ana", 9.2);
        catalog.addStudent("Robert Nistorescu", 7.8);
        catalog.addStudent("Alex Nistorescu", 10);
      //  catalog.stergereStudent();
      //  catalog.afisareStudenti();
     //   catalog.alphabeticallyOrder();
       // System.out.println(catalog.alphabeticallyOrder());

//        String numeStudentCautat = "Ana";
//        double medieStudentCautat = catalog.cautaStudent(numeStudentCautat);
//
//        if (medieStudentCautat != -1) {
//            System.out.println("Studentul " + numeStudentCautat + " are media " + medieStudentCautat);
//        } else {
//            System.out.println("Studentul " + numeStudentCautat + " nu a fost găsit");
//        }
        catalog.afisareStudentiDupaMedie();
    }
}

