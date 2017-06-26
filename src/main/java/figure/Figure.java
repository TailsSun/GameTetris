package figure;

import java.awt.*;

import static core.Core.*;
import static core.Core.RIGHT;
import static core.Core.WIDTH;
import static core.Well.mapSquare;

/**
 * Created by DNS on 23.06.2017.
 */
public abstract class Figure  {

    private int [][] square;


    public int[][] getSquare() {
        return square;
    }

    public void move(int direction) {
        square = getSquare();
        if ( direction == LEFT){
            if(!isTouchWall(direction)){
                for (int[] result: square) {
                    result[0] = result[0] - 1;
                }
            }
        }
        if ( direction == RIGHT){
            if(!isTouchWall(direction)){
                for (int[] result: square) {
                    result[0] = result[0] + 1;
                }
            }
        }
    }

    boolean isTouchWall(int direction) {
        square = getSquare();
        if ( direction == LEFT){
            for (int[] result: square) {
                if (result[0] == 0 || mapSquare[result[0] - 1][result[1]] == WALL){
                    return true;
                }
            }
        }else {
            for (int[] result: square) {
                if (result[0] == WIDTH - 1 || mapSquare[result[0] + 1][result[1]] == WALL){
                    return true;
                }
            }
        }
        return false;
    }

    public  boolean isTouchGround(int[][] mapSquare){
        square = getSquare();
        for (int[] result: square) {
            if (result[1] == HEIGHT - 1 || mapSquare[result[0]][result[1]] == WALL)
                return true;
        }
        return false;
    }

    public abstract void rotate();

    public  void moveDown(){
        square = getSquare();
        for (int[] result: square) {
            result[1] = result[1] + 1;
        }
    }

    public void draw(Graphics2D graphics){
        square = getSquare();
        for (int[] result: square) {
            int tmpX = result[0];
            int tmpY = result[1];
            graphics.setColor(Color.WHITE);
            graphics.drawRect(tmpX * LENGTH, tmpY * LENGTH ,LENGTH,LENGTH);
        }
    }


    public void writeToWell(int[][] mapSquare) {
        square = getSquare();
        for (int[] result: square) {
            mapSquare[result[0]][result[1]] = WALL;

        }
    }
}
