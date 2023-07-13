package petHotel;

public class Main {
    public static void main(String[] args) {
        PetHotel petHotel = new PetHotel();
        petHotel.checkIn("Bella");
        petHotel.checkIn("Minnie");
        petHotel.checkIn("Napi");
        petHotel.checkIn("Lessy");
        petHotel.checkIn("Miu");
        petHotel.checkOut("Miu");
        petHotel.afisareRegistru();

    }
}
