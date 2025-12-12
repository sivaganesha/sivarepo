package model;

public abstract class Player {
    String Name;
    String Symbol;
    PlayerType type;

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

}
