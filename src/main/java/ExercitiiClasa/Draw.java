package ExercitiiClasa;

public class Draw {
    public static void printeazaDreptunghi(int latime, int inaltime) {
        for (int i = 0; i < inaltime; i++) {
            for (int j = 0; j < latime; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
    public static void deseneazaConturForma(int latime, int inaltime) {
        for (int i = 0; i < inaltime; i++) {//4
            for (int j = 0; j < latime; j++) {//10
                if (i == 0 || i == inaltime - 1 || j == 0 || j == latime - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void deseneazaForma2(int latime, int inaltime) {
        for (int i = 0; i < inaltime; i++) {
            for (int j = 0; j < latime; j++) {
                if ((i == 0 || i == inaltime - 1) && (j == 0 || j == latime - 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
