package petHotel;

import java.util.HashSet;
import java.util.Set;

public class PetHotel {
    Set<String> registruAnimale;

    public PetHotel() {
        registruAnimale = new HashSet<>();
    }

    public void checkIn(String numeAnimal) {
        registruAnimale.add(numeAnimal);
        System.out.println(numeAnimal + " a fost înregistrat în hotel.");
    }

    public void checkOut(String numeAnimal) {
        boolean removed = registruAnimale.remove(numeAnimal);
        if (removed) {
            System.out.println(numeAnimal + " a fost eliberat din hotel.");
        } else {
            System.out.println(numeAnimal + " nu a fost găsit în hotel.");
        }
    }

    public void afisareRegistru() {
        System.out.println("Lista câinilor cazați în hotel:");
        for (String animal : registruAnimale) {
            System.out.println(animal);
        }
    }
}
