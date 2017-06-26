package core;

import figure.Figure;

import java.awt.*;

import static core.Core.*;

/**
 * Created by DNS on 23.06.2017.
 */
public class Well {
    public static int[][] mapSquare;

    public Well() {
        if (mapSquare == null)
            mapSquare = new int[WIDTH][HEIGHT];

    }

    public static void getFigure(Figure figure) {
        figure.writeToWell(mapSquare);
        while (isFullRow());

    }

    private static boolean isFullRow(){
        int sum = 0;
        for (int y = 0; y < HEIGHT ; y++) {
            for (int x = 0; x < WIDTH; x++) {
                sum = sum + mapSquare[x][y];
                if (sum == WIDTH) {
                    int numberLineIsFull = y;
                    mapSquare = rebuildMapSquare(numberLineIsFull);
                    return true;
                }

            }
            sum = 0;
        }
        return false;
    }

    private static int[][] rebuildMapSquare(int numberLineIsFull) {
        int[][] clone = new int[WIDTH][HEIGHT];
        int lineShift = 1;

        for (int y = 0; y < HEIGHT ; y++) {
            if (y != numberLineIsFull) {
                for (int x = 0; x < WIDTH; x++) {
                    clone[x][y + lineShift] = mapSquare[x][y];

                }

            } else lineShift = 0;
        }
        return clone;
    }

    public static void draw(Graphics2D graf) {

        for (int y = 0; y < HEIGHT ; y++)
            for (int x = 0; x < WIDTH ; x++)
                if (mapSquare[x][y] == WALL) {

                    graf.setColor(Color.LIGHT_GRAY);
                    graf.fillRect(x * LENGTH, y * LENGTH, LENGTH, LENGTH);
                    graf.setColor(Color.blue);
                    graf.drawRect(x * LENGTH, y * LENGTH, LENGTH, LENGTH);
                }
    }
}
