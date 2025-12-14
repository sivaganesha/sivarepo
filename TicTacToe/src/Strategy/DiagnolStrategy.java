package Strategy;

import model.Board;
import model.Move;

public class DiagnolStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {

    }
}
