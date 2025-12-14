package Strategy;

import model.Board;
import model.Move;

import java.util.HashMap;

public class RowStrategy implements WinningStrategy{
    private HashMap<Integer, HashMap<String,Integer>> hashwin=new HashMap<>();

    public HashMap<Integer, HashMap<String, Integer>> getHashwin() {
        return hashwin;
    }

    public RowStrategy() {
    }

    public void setHashwin(HashMap<Integer, HashMap<String, Integer>> hashwin) {
        this.hashwin = hashwin;
    }

    @Override
    public boolean checkWinner(Board board, Move move){
        int rowNo=move.getCell().getRow();
        String symbol=move.getCell().getPlayer().getSymbol();

        if(!hashwin.containsKey(rowNo)){hashwin.put(rowNo,new HashMap<>());}

         HashMap<String, Integer> internalmap=hashwin.get(rowNo);

        if(!internalmap.containsKey(symbol)){internalmap.put(symbol,0);}
        else {
            internalmap.put(symbol, internalmap.get(symbol) + 1);
        }
        if(hashwin.get(rowNo).get(symbol)==board.getSize()){return true;}
        return false;

    }
    @Override
    public void handleUndo(Board board, Move move)
    {

    }
}
