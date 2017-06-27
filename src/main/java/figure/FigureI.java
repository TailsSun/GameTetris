package figure;


import static core.Core.*;
import static core.Well.*;
/**
 * Created by DNS on 23.06.2017.
 */
public class FigureI extends Figure{

    private int [][] square = {{4, 0}, {4, 1}, {4, 2}, {4, 3}};// моя фигура;
    private boolean vertical = true;


    @Override
    public int[][] getSquare() {
        return square;
    }


    @Override
    public boolean isTouchGround(int[][] mapSquare) {
        if(vertical){
            if (square[3][1] == HEIGHT - 1 || mapSquare[square[3][0]][square[3][1] + 1] == WALL)
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
        if (vertical){
            if (square[0][0] > 1 && square[0][0] < WIDTH){
                int tmpX = square[2][0]; // 4
                int tmpY = square[2][1]; // 2
                if (tmpX != WIDTH - 1 &&
                        mapSquare [tmpX - 2][tmpY] != WALL &&
                        mapSquare [tmpX - 1][tmpY] != WALL &&
                        mapSquare [tmpX +1][tmpY] != WALL){
                    square[0][0] = tmpX - 2;
                    square[0][1] = tmpY;

                    square[1][0] = tmpX - 1;
                    square[1][1] = tmpY;

                    square[3][0] = tmpX + 1;
                    square[3][1] = tmpY;

                    vertical = false;
                }
            }
        }else {
            int tmpX = square[2][0];
            int tpmY = square[2][1];
            if (tpmY != HEIGHT - 1){
                if (mapSquare [tmpX ][tpmY - 2] != WALL &&
                        mapSquare [tmpX][tpmY - 1] != WALL &&
                        mapSquare [tmpX][tpmY + 1] != WALL){
                    square[0][0] = tmpX;
                    square[0][1] = tpmY - 2;

                    square[1][0] = tmpX;
                    square[1][1] = tpmY - 1;

                    square[3][0] = tmpX;
                    square[3][1] = tpmY + 1;

                    vertical = true;
                }
            }
        }

    }
}
