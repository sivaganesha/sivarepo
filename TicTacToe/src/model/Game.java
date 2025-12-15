package model;

import Strategy.ColumnStrategy;
import Strategy.DiagnolStrategy;
import Strategy.RowStrategy;
import Strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

List<Player> players;
Board board;
ArrayList<Move> moves;
Player winner;
GameState gameState;
int nextMovePlayerIndex;
List<WinningStrategy> winningStrategies;

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Game(int dimension, List<Player> players){
    this.board=new Board(dimension);
    this.players=players;
    this.winningStrategies= Arrays.asList(new ColumnStrategy(),new RowStrategy(),new DiagnolStrategy());
    this.moves=new ArrayList<>();
    this.winner=null;
    this.nextMovePlayerIndex=0;
    this.gameState=GameState.INPROGRESS;
}
    public void makeMove()
    {
        // S1: Get the player using nextPlayerIndex
        Player currentPlayer=players.get(nextMovePlayerIndex);
        System.out.println("Player "+nextMovePlayerIndex+" is now playing");
        // S2: Take Input from the player using Scanner
        // ToDo: If it is a BOT then automatically decide the Input using Strategy here.


        Move currentMove = currentPlayer.getInputAndMakeMove(board);

        // S3: Validate and Update the Cell
        if(invalidMove(currentMove)) {
            System.out.println("Invalid move by the player!");
            return;
        }

        int currentRow = currentMove.getCell().getRow();
        int currCol = currentMove.getCell().getCol();
        System.out.println("move is made in --> Row: " + currentRow + " col: " + currCol);

        Cell currCell =  board.getGrid().get(currentRow).get(currCol);
        currCell.setState(CellState.FILLED);
        currCell.setPlayer(currentPlayer);

        // S4: Store the move in List<Move>
        Move newMove = new Move(currCell, currentPlayer);
        moves.add(newMove); //  ONLY HERE...

        // S5: Calculate next player Index:
        nextMovePlayerIndex +=1;
        nextMovePlayerIndex %= players.size(); // (5/4=1)

        // S6: Check winner.
        if(checkWinner(board, newMove)){
            gameState = GameState.WIN;
            winner = currentPlayer;
        }else if(moves.size() == this.getBoard().getSize()* this.getBoard().getSize()){
            gameState = GameState.DRAW;
        }
        }

    private boolean checkWinner(Board board, Move newMove) {
        for(WinningStrategy winningStrategy:winningStrategies){
            if(winningStrategy.checkWinner(board,newMove))
            {
                return true;
            }
        }
        return false;
    }

    // toDo: to implement by own.
    private boolean invalidMove(Move currentMove) {
        /*
         * ToDO: Check for validations...
         *  But you guys will have to handle the validation cases.
         * 1. Row>=0 , Col>=0 && row<n && col <n
         * 2. If the current cell state is NOT EMPTY -- then return true.
         */
        if(currentMove.getCell().getCol()<0 ||
                currentMove.getCell().getRow()<0 ||
                currentMove.getCell().getCol()> board.getSize()-1 ||
                currentMove.getCell().getRow()> board.getSize()-1 ||
                currentMove.getCell().getState()!=CellState.EMPTY)
        {
            return true;
        }
        return false;
    }
    public void undo() {
        /*
         * Steps for UNDO:
         *
         * 1. Get the last move from the moves list
         * 2. Remove the last move from the list.
         * 3. Update the cell status to EMPTY and player to null in CELL.
         * 4. Decreament the lastPlayerIndex
         * 5. handle undo in winning strategy.
         */

        Move lastMove;
        if(moves.size()>0){
            lastMove = moves.get(moves.size()-1);
        }
        else
        {
            System.out.println("No moves made yet.");
            return;
        }

        if(!gameState.equals(GameState.INPROGRESS)){
            System.out.println("Game is not in Progress.");
            return;
        }
        moves.remove(lastMove);
        lastMove.getCell().setState(CellState.EMPTY);
        lastMove.getCell().setPlayer(null);

        // Last part to reduce the count as well.
        for(WinningStrategy winningStrategy : winningStrategies){
            winningStrategy.handleUndo(board, lastMove);
        }

    }

    public void printBoard(){
        board.printBoard();
    }

}
