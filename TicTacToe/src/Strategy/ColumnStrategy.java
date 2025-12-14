package Strategy;

import model.Board;
import model.Move;
import java.util.HashMap;

public class ColumnStrategy implements WinningStrategy{
    HashMap<Integer, HashMap<String,Integer>> hashwin =new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int colno=move.getCell().getCol();
        String symbol=move.getCell().getPlayer().getSymbol();

        if(!hashwin.get(colno).containsKey(symbol)){
            hashwin.put(colno,new HashMap<>());
        }

        HashMap<String,Integer> internalmap=hashwin.get(colno);

        if(!internalmap.containsKey(symbol))
        {
            internalmap.put(symbol,0);
        }
        internalmap.put(symbol,internalmap.get(symbol)+1);

        if(internalmap.get(symbol)==board.getSize()){
            return true;
        }

        return false;
    }

    @Override
    public void handleUndo(Board board, Move move) {

    }
}
