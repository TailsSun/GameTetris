package figure;


import static core.Core.*;
import static core.Well.mapSquare;

/**
 * Created by DNS on 23.06.2017.
 */
public class FigureZ extends Figure{

    private int [][] square = {{4, 0}, {5, 0}, {5, 1}, {6, 1}};// моя фигура;
    private boolean vertical = true;


    @Override
    public int[][] getSquare() {
        return square;
    }

    @Override
    public void rotate() {
        if (vertical){
                int tmpX = square[2][0]; // 4
                int tmpY = square[2][1]; // 2
                if (tmpY != HEIGHT - 1 &&
                        mapSquare [tmpX + 1][tmpY - 1] != WALL &&
                        mapSquare [tmpX + 1][tmpY] != WALL &&
                        mapSquare [tmpX ][tmpY +1] != WALL){
                    square[0][0] = tmpX + 1;
                    square[0][1] = tmpY - 1;

                    square[1][0] = tmpX + 1;
                    square[1][1] = tmpY;

                    square[3][0] = tmpX;
                    square[3][1] = tmpY + 1;

                    vertical = false;
                }

        }else {
            int tmpX = square[2][0];
            int tpmY = square[2][1];
            if (tmpX != 0){
                if (mapSquare [tmpX - 1][tpmY - 1] != WALL &&
                        mapSquare [tmpX][tpmY - 1] != WALL &&
                        mapSquare [tmpX + 1][tpmY ] != WALL){
                    square[0][0] = tmpX - 1;
                    square[0][1] = tpmY - 1;

                    square[1][0] = tmpX;
                    square[1][1] = tpmY - 1;

                    square[3][0] = tmpX + 1;
                    square[3][1] = tpmY ;

                    vertical = true;
                }
            }
        }

    }
}
