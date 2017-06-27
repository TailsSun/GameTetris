package utils;

import figure.*;

import java.util.Random;

/**
 * Created by DNS on 25.06.2017.
 *   I, J, L, O, S, T, Z
 */
public class GenerateFigure {
    public static Figure generate(){
        Random rnd = new Random();
        int tmp = rnd.nextInt(5);
        if (tmp == 0) return new FigureI();
        if (tmp == 1) return new FigureJ();
        if (tmp == 2) return new FigureL();
        if (tmp == 3) return new FigureO();
//        if (tmp == 4) return new FigureS();
        return  new FigureL();//todo
    }
}
