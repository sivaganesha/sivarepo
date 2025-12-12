package model;

public class Bot extends Player{
    private DifficultyLevel botDifficulyLevel;

    public Bot(String name, String symbol, PlayerType type, DifficultyLevel botDifficulyLevel) {
        super(name, symbol, type);
        this.botDifficulyLevel = botDifficulyLevel;
    }

    public DifficultyLevel getBotDifficulyLevel() {
        return botDifficulyLevel;
    }

    public void setBotDifficulyLevel(DifficultyLevel botDifficulyLevel) {
        this.botDifficulyLevel = botDifficulyLevel;
    }
}
