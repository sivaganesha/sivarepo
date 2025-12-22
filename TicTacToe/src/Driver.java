import Controller.GameController;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    try{
        int dimension = 3; // HARD CODE IT FOR NOW.
        List<Player> players = new ArrayList<>();
        players.add(new Human("Siva", "*"));
        players.add(new Human("Ganesh", "&"));

        GameController gameController = new GameController();
        Game game =  gameController.startGame(dimension, (ArrayList<Player>) players);
        while(gameController.checkGameState(game).equals(GameState.INPROGRESS)){
            gameController.displayBoard(game);

            System.out.println("Do you want to do UNDO? (y/n) ");
            String undoInput = scanner.next();

            if(undoInput.equals("y")){
                gameController.undo(game);
                continue;
            }

            System.out.println("Please make a move....");
            gameController.makeMove(game);
        }

        System.out.println("Game is FINISHED. ");
        if(gameController.checkGameState(game).equals(GameState.WIN)){
            System.out.println("Game is WON by Player:  " + gameController.getWinner(game).getName() );
        }else{
            System.out.println("Game has been DRAWN.");
        }
        System.out.println("Final condition of the board ----> ");
        gameController.displayBoard(game);
    }catch(Exception e){
        System.out.println("Exception happened: " + e);
    } finally{
        scanner.close();
    }
}
}
