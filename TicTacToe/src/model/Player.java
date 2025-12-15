package model;

import java.util.Scanner;

public abstract class Player {
    String Name;
    String Symbol;
    PlayerType type;
    private Scanner scanner;
    public Player(String name, String symbol, PlayerType type) {
        Name = name;
        Symbol = symbol;
        this.type = type;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public Move getInputAndMakeMove(Board board) {

        scanner=new Scanner(System.in);
        if(this.type.equals(PlayerType.BOT)){
            // On the basis of difficulty level, you call and return the
            // response from bot playing strategy.

        }
        System.out.println("Please tell row: ");
        int row = scanner.nextInt();

        System.out.println("Please tell col: ");
        int col = scanner.nextInt();
        // Validation here as well...
        return new Move(new Cell(row, col), this);
    }

}
