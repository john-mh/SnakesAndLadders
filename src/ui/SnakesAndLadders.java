package ui;
import java.time.Instant;
import java.time.Duration;
import java.util.Scanner;
import model.Game;

public class SnakesAndLadders {

    public static Instant i;
    public static Duration d;
    public static Scanner sc = new Scanner(System.in);
    public static Game game;

    public static void main(String[] args) {
        boolean out=false;
        do{
            System.out.println("-----Snakes & Ladders-----");
            System.out.println("1. Play");
            System.out.println("2. out");
            int sel = sc.nextInt();
            switch (sel){
                case 1 -> startGame();
                case 2 -> out=true;
                default -> throw new IllegalArgumentException("Invalid option");
            }
        } while(true);

    }

    public static void startGame(){
        System.out.println("Enter the number of columns");
        int columns = sc.nextInt();
        System.out.println("Enter the number of rows");
        int rows = sc.nextInt();
        game.initializeLadders(columns*rows, rows, 0);
        game(columns);
    }

    public static void game(int columns){
        displayBoard(columns);
        System.out.println("Player "+""+"turn");
        System.out.println("1. Throw dice");
        System.out.println("2. See ladders and snakes");
        int sel= sc.nextInt();
        switch (sel){
            case 1:
                int dice=game.throwDice();
                System.out.println("Dice: "+dice);
                game.movePlayer(dice);
                break;
            case 2:
                break;
        }
    }

    public static void endGame(){}

    public static void displayBoard(int columns){
        System.out.println(game.printBoard(columns));
    }

    public static void setScore(){}

    public static void displayScore(){}

    public static void addPlayer(){}

    public static void resetGame(){}
}