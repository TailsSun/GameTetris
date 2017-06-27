package figure;


import static core.Core.*;
import static core.Well.mapSquare;

/**
 * Created by DNS on 23.06.2017.
 */
public class FigureL extends FigureJ{

    private int [][] square = {{4, 0}, {4, 1}, {4, 2}, {5, 2}};// моя фигура;
    private int slopeAngle = 0; // 0,  90 180 270

    public int getSlopeAngle() {
        return slopeAngle;
    }
    public void rotate() {
        if (slopeAngle == 0) {
            if (square[0][0] > 0 && square[0][0] < WIDTH) {

                int tmpX = square[1][0]; // 4
                int tmpY = square[1][1]; // 2
                if (tmpX != WIDTH - 1 &&
                        mapSquare[tmpX + 1][tmpY] != WALL &&
                        mapSquare[tmpX - 1][tmpY] != WALL &&
                        mapSquare[tmpX - 1][tmpY + 1] != WALL) {
                    square[0][0] = tmpX + 1;
                    square[0][1] = tmpY;

                    square[2][0] = tmpX - 1;
                    square[2][1] = tmpY;

                    square[3][0] = tmpX - 1;
                    square[3][1] = tmpY + 1;

                    slopeAngle = 90;
                    return;
                }
            }
        }if (slopeAngle == 90) {
            int tmpX = square[1][0];
            int tpmY = square[1][1];
            if (tpmY != HEIGHT - 1) {
                if (mapSquare[tmpX][tpmY - 1] != WALL &&
                        mapSquare[tmpX][tpmY + 1] != WALL &&
                        mapSquare[tmpX - 1][tpmY - 1] != WALL) {
                    square[0][0] = tmpX;
                    square[0][1] = tpmY - 1;

                    square[2][0] = tmpX;
                    square[2][1] = tpmY + 1;

                    square[3][0] = tmpX - 1;
                    square[3][1] = tpmY - 1;

                    slopeAngle = 180;
                    return;
                }
            }
        }
        if (slopeAngle == 180) {
            int tmpX = square[1][0];
            int tpmY = square[1][1];
            if (tmpX != 0 && tmpX != WIDTH - 1 &&
                    mapSquare[tmpX - 1][tpmY] != WALL &&
                    mapSquare[tmpX + 1][tpmY] != WALL &&
                    mapSquare[tmpX + 1][tpmY - 1] != WALL) {
                square[0][0] = tmpX - 1;
                square[0][1] = tpmY;

                square[2][0] = tmpX + 1;
                square[2][1] = tpmY;

                square[3][0] = tmpX + 1;
                square[3][1] = tpmY - 1;

                slopeAngle = 270;
                return;
            }
        }
        if (slopeAngle == 270) {
            int tmpX = square[1][0];
            int tpmY = square[1][1];

            if (mapSquare[tmpX][tpmY - 1] != WALL &&
                    mapSquare[tmpX][tpmY + 1] != WALL &&
                    mapSquare[tmpX + 1][tpmY + 1] != WALL) {
                square[0][0] = tmpX;
                square[0][1] = tpmY - 1;

                square[2][0] = tmpX;
                square[2][1] = tpmY + 1;

                square[3][0] = tmpX + 1;
                square[3][1] = tpmY + 1;

                slopeAngle = 0;
            }
        }
    }
    @Override
    public int[][] getSquare() {
        return square;
    }

}
