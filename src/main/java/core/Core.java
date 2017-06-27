package core; /**
 * Created by DNS on 25.06.2017.
 */

import figure.Figure;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import utils.Display;
import utils.GenerateFigure;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static utils.Display.getContent;

public class Core {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;
    public static final int LENGTH = 30;
    public static final int RIGHT = 39;
    public static final int LEFT = 37;
    public static final int WALL = 1;
    public static final int UP = 38;

    private static boolean isFigure;
    private static final String fileMusic = "music/old.mp3";
    private static boolean gameOver;
    private Well well;
    private Figure figureMy;
    private Graphics2D graphics;
    private Canvas content;


    private static void setTitle(int width, int high, int lenght) {
        Display.create(width * lenght, high * lenght, "Tetris", 0xff000000, 3);
    }

    public void go() {
        Thread tread = new Thread((new Runnable() {

            @Override
            public void run() {
                try {
                    FileInputStream file = new FileInputStream(fileMusic);
                    Player player = new Player(file);
                    player.play();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        }));
        tread.setDaemon(true);
        tread.start();


        setTitle(WIDTH, HEIGHT, LENGTH);
        graphics = Display.getGraphics();
        content = getContent();
        well = new Well();
        content.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (isFigure) {
                    if (e.getKeyCode() == UP) figureMy.rotate();
                    if (e.getKeyCode() == LEFT || e.getKeyCode() == RIGHT) figureMy.move(e.getKeyCode());
                    draw();
                }
            }
        });

        while (!gameOver) { // todo реализовать конец игры
            if (!isFigure) {
                figureMy = GenerateFigure.generate();
                gameOver = figureMy.checkTouchSquare(Well.mapSquare);
                isFigure = true;
            }
            draw();

            if (isFigure) {
                int q = 1;
                if (figureMy.isTouchGround(Well.mapSquare)) {

                    Well.getFigure(figureMy);
                    isFigure = false;
                    figureMy = null;

                }
                if (isFigure) {
                   figureMy.moveDown();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("конееец");
        Display.destroy();

    }

    private void draw() {

        Display.clear();
        if (figureMy != null)
            figureMy.draw(graphics);
        Well.draw(graphics);

        Display.swapBuffers();
    }


}
