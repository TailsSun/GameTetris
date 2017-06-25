package figure;


import static core.Core.HEIGHT;
import static core.Core.WALL;

/**
 * Created by DNS on 23.06.2017.
 */
public class FigureO extends Figure {

    private int[][] square = {{4, 0}, {5, 0}, {4, 1}, {5, 1}};// моя фигура;


    @Override
    public int[][] getSquare() {
        return square;
    }


    @Override
    public boolean isTouchGround(int[][] mapSquare) {
        if (square[3][1] == HEIGHT - 1
                || mapSquare[square[3][0]][square[3][1] + 1] == WALL
                || mapSquare[square[2][0]][square[2][1] + 1] == WALL)
            return true;
        return false;
    }

    @Override
    public void rotate() {
    }
}
