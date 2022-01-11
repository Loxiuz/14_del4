package game;

import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;

public class Main
{

    public static void main(String[] args)
    {
        setLanguage();
        new game.GameController();
    }

    private static void setLanguage()
    {
        GUI chooseLanguage = new GUI(new GUI_Field[0],new Color(51, 204, 0));
        String[] languages = game.Language.getLanguages();
        game.Language.setLanguage(chooseLanguage.getUserSelection(game.Language.getLine("choose_lang"), languages));
        chooseLanguage.close();
    }
}
