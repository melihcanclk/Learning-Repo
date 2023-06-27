import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Game {

    private static Scanner sc = new Scanner(System.in);
    private static void start(){
        System.out.println("Oyunumuza hos geldiniz.");
        System.out.print("Lutfen isminizi giriniz:");
        String name = sc.next();

        Player player = new Player(name);
        System.out.println(player.getName() + " hosgeldin!");

        player.selectCharacter();

    }

    public static void main(String[] args) {
        Game.start();
    }
}