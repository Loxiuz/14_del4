package game;

import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public final class GUIController {
    // Static variable reference of single_instance
    // of type Singleton
    private static GUI single_instance = null;


    // Constructor
    private GUIController() {}

    private static GUI createGUI() {

        // Creates an array for the fields
        GUI_Field[] fields = new GUI_Field[24];

        // Creates the fields
        fields[0] = new GUI_Start(Language.getLine("f1_title"),Language.getLine("f1_subtext"),Language.getLine("f1_desc"), Color.ORANGE, Color.BLACK);
        fields[1] = new GUI_Street(Language.getLine("f2_title"),Language.getLine("f2_subtext"),Language.getLine("f2_desc"),"", new Color(205,133,63), Color.BLACK);
        fields[2] = new GUI_Street(Language.getLine("f3_title"),Language.getLine("f3_subtext"),Language.getLine("f3_desc"),"", new Color(205,133,63), Color.BLACK);
        fields[3] = new GUI_Chance(Language.getLine("fC_title"),Language.getLine("fC_subtext"),Language.getLine("fC_desc"),Color.YELLOW,Color.BLACK);
        fields[4] = new GUI_Street(Language.getLine("f5_title"),Language.getLine("f5_subtext"),Language.getLine("f5_desc"),"", new Color(135,206,250), Color.BLACK);
        fields[5] = new GUI_Street(Language.getLine("f6_title"),Language.getLine("f6_subtext"),Language.getLine("f6_desc"),"", new Color(135,206,250), Color.BLACK);
        fields[6] = new GUI_Jail("default",Language.getLine("f7_title"),Language.getLine("f7_subtext"),Language.getLine("f7_desc"),Color.GRAY,Color.BLACK);
        fields[7] = new GUI_Street(Language.getLine("f8_title"),Language.getLine("f8_subtext"),Language.getLine("f8_desc"),"", new Color(205,92,92), Color.BLACK);
        fields[8] = new GUI_Street(Language.getLine("f9_title"),Language.getLine("f9_subtext"),Language.getLine("f9_desc"),"", new Color(205,92,92), Color.BLACK);
        fields[9] = new GUI_Chance(Language.getLine("fC_title"),Language.getLine("fC_subtext"),Language.getLine("fC_desc"),Color.YELLOW,Color.BLACK);
        fields[10] = new GUI_Street(Language.getLine("f11_title"),Language.getLine("f11_subtext"),Language.getLine("f11_desc"),"", new Color(240,230,140), Color.BLACK);
        fields[11] = new GUI_Street(Language.getLine("f12_title"),Language.getLine("f12_subtext"),Language.getLine("f12_desc"),"", new Color(240,230,140), Color.BLACK);
        fields[12] = new GUI_Refuge("default",Language.getLine("f13_title"),Language.getLine("f13_subtext"),Language.getLine("f13_desc"),Color.PINK,Color.BLACK);
        fields[13] = new GUI_Street(Language.getLine("f14_title"),Language.getLine("f14_subtext"),Language.getLine("f14_desc"),"", Color.RED, Color.BLACK);
        fields[14] = new GUI_Street(Language.getLine("f15_title"),Language.getLine("f15_subtext"),Language.getLine("f15_desc"),"", Color.RED, Color.BLACK);
        fields[15] = new GUI_Chance(Language.getLine("fC_title"),Language.getLine("fC_subtext"),Language.getLine("fC_desc"),Color.YELLOW,Color.BLACK);
        fields[16] = new GUI_Street(Language.getLine("f17_title"),Language.getLine("f17_subtext"),Language.getLine("f17_desc"),"", new Color(255,215,0), Color.BLACK);
        fields[17] = new GUI_Street(Language.getLine("f18_title"),Language.getLine("f18_subtext"),Language.getLine("f18_desc"),"", new Color(255,215,0), Color.BLACK);
        fields[18] = new GUI_Jail("default",Language.getLine("f19_title"),Language.getLine("f19_subtext"),Language.getLine("f19_desc"),Color.GRAY,Color.BLACK);
        fields[19] = new GUI_Street(Language.getLine("f20_title"),Language.getLine("f20_subtext"),Language.getLine("f20_desc"),"", Color.GREEN, Color.BLACK);
        fields[20] = new GUI_Street(Language.getLine("f21_title"),Language.getLine("f21_subtext"),Language.getLine("f21_desc"),"", Color.GREEN, Color.BLACK);
        fields[21] = new GUI_Chance(Language.getLine("fC_title"),Language.getLine("fC_subtext"),Language.getLine("fC_desc"),Color.YELLOW,Color.BLACK);
        fields[22] = new GUI_Street(Language.getLine("f23_title"),Language.getLine("f23_subtext"),Language.getLine("f23_desc"),"", new Color(65,105,225), Color.BLACK);
        fields[23] = new GUI_Street(Language.getLine("f24_title"),Language.getLine("f24_subtext"),Language.getLine("f24_desc"),"", new Color(65,105,225), Color.BLACK);

        //Creates the board based on the specified array
        GUI GUI = new GUI(fields);
        GUI.setChanceCard(Language.getLine("card_none"));
        return GUI;

    }

    // Static method to create instance of GUI
    public static GUI getInstance()
    {
        if (single_instance == null)
            single_instance = createGUI();

        return single_instance;
    }
}