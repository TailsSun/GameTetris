package figure;


import static core.Core.*;
import static core.Well.mapSquare;

/**
 * Created by DNS on 23.06.2017.
 */
public class FigureJ extends Figure{

    private int [][] square = {{4, 0}, {4, 1}, {4, 2}, {3, 2}};// моя фигура;
    private boolean vertikal = true;

    public boolean getVertikal() {
        return vertikal;
    }

    @Override
    public int[][] getSquare() {
        return square;
    }


    @Override
    public boolean isTouchGround(int[][] mapSquare) {
        square = getSquare();
        vertikal = getVertikal();
        if(vertikal){
            if (square[3][1] == HEIGHT - 1
                    || mapSquare[square[3][0]][square[3][1] + 1] == WALL
                    || mapSquare[square[2][0]][square[2][1] + 1] == WALL)
                return true;
            return false;
        }
        for (int[] result: square) {
            if (result[1] == HEIGHT - 1 || mapSquare[result[0]][result[1] + 1] == WALL)
                return true;
        }
        return false;
    }

    @Override
    public void rotate() {
        if (vertikal){
            if (square[0][0] > 0 && square[0][0] < WIDTH){
                int tmpX = square[1][0]; // 4
                int tmpY = square[1][1]; // 2
                if (mapSquare [tmpX - 1][tmpY] != WALL &&
                        mapSquare [tmpX + 1][tmpY] != WALL &&
                        mapSquare [tmpX + 1][tmpY + 1] != WALL){
                    square[0][0] = tmpX - 1;
                    square[0][1] = tmpY;

                    square[2][0] = tmpX + 1;
                    square[2][1] = tmpY;

                    square[3][0] = tmpX + 1;
                    square[3][1] = tmpY + 1;

                    vertikal = false;
                }
            }
        }else {
            int tmpX = square[1][0];
            int tpmY = square[1][1];
            if (tpmY != HEIGHT - 1){
                if (mapSquare [tmpX ][tpmY - 1] != WALL &&
                        mapSquare [tmpX][tpmY + 1] != WALL &&
                        mapSquare [tmpX - 1][tpmY + 1] != WALL){
                    square[0][0] = tmpX;
                    square[0][1] = tpmY - 1;

                    square[2][0] = tmpX;
                    square[2][1] = tpmY + 1;

                    square[3][0] = tmpX - 1;
                    square[3][1] = tpmY + 1;

                    vertikal = true;
                }
            }
        }

    }
}
