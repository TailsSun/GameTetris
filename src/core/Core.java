package core; /**
 * Created by DNS on 27.05.2017.
 */
import utils.Displey;
import figure.Figure;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static utils.Displey.getContent;

public class Core {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;
    public static final int LENGTH = 30;
    public  static final int RIGHT = 39;
    public static final int LEFT = 37;
    public static final int WALL = 1;



    Well well;
    private static boolean title;
    private static boolean isFigure;
    final int UP = 38;
    final int DOWN = 40;
    private Figure figureMy;
    private Graphics2D graphics;
    Canvas content;

public void go(){
    setTitle(WIDTH, HEIGHT, LENGTH);
    graphics = Displey.getGraphics();
    content = getContent();
    well = new Well();
    content.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            if(isFigure) {
//                    if (e.getKeyCode() == DOWN) figure.drop();
                if (e.getKeyCode() == UP) figureMy.rotate();
                if (e.getKeyCode() == LEFT || e.getKeyCode() == RIGHT) figureMy.move(e.getKeyCode());
                draw();
            }
        }
    });

    while (true){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(!isFigure){
            figureMy = GenerateFigure.generate();
            isFigure = true;
        }
        figureMy.moveDown();
        draw();
        if(figureMy.isTouchGround(well.mapSquare)) {
            well.getFigure(figureMy);
            isFigure = false;
            figureMy = null;
        }
    }



    }

    private void draw(){

        Displey.clear();
        if (figureMy != null)
            figureMy.draw(graphics);
        well.draw(graphics);






        Displey.swapBuffers();
    }
    private static void setTitle(int width, int high, int lenght){
        Displey.create(width * lenght,high * lenght,"myTestGame",0xff000000,3);
    }


}
