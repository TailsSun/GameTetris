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
