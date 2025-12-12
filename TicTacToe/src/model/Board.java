package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    ArrayList<ArrayList<Cell>> grid;
    int size;

    public Board(int size) {
        this.size = size;
        grid = new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            ArrayList<Cell> row = new ArrayList<>();
            for(int j=0;j<size;j++)
            {
                row.add(new Cell(i,j));
            }
            grid.add(row);
        }
    }

    void printBoard()
    {
        for(int i=0;i<size;i++)
        {
            System.out.print('|');
            for(int j=0;j<size;j++)
            {
                System.out.print(grid.get(i).get(j).player.symbol+'|');
            }
            System.out.println();
        }
    }
}
