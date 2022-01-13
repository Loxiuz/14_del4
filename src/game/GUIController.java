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
        GUI_Field[] fields = new GUI_Field[40];

        // Creates the fields
        fields[0] = new GUI_Start(Language.getLine("fStart_title"),Language.getLine("fStart_subtext"),Language.getLine("fStart_desc"), Color.RED, Color.BLACK);
        fields[1] = new GUI_Street(Language.getLine("fB1_title"),Language.getLine("fB1_subtext"),Language.getLine("fB1_desc"),"", Color.BLUE, Color.BLACK);
        fields[2] = new GUI_Chance(Language.getLine("fC_title"),Language.getLine("fC_subtext"),Language.getLine("fC_desc"),Color.BLACK,Color.WHITE);
        fields[3] = new GUI_Street(Language.getLine("fB2_title"),Language.getLine("fB2_subtext"),Language.getLine("fB2_desc"),"", Color.BLUE, Color.BLACK);
        fields[4] = new GUI_Tax(Language.getLine("fT1_title"),Language.getLine("fT1_subtext"),Language.getLine("fT1_desc"),Color.GREEN,Color.BLACK);
        fields[5] = new GUI_Shipping("default", Language.getLine("fS1_title"), Language.getLine("fS1_subtext"), Language.getLine("fS1_desc"), "", new Color(135,206,250), Color.BLACK);
        fields[6] = new GUI_Street(Language.getLine("fP1_title"),Language.getLine("fP1_subtext"),Language.getLine("fP1_desc"),"", Color.PINK, Color.BLACK);
        fields[7] = new GUI_Chance(Language.getLine("fC_title"),Language.getLine("fC_subtext"),Language.getLine("fC_desc"),Color.BLACK,Color.WHITE);
        fields[8] = new GUI_Street(Language.getLine("fP2_title"),Language.getLine("fP2_subtext"),Language.getLine("fP2_desc"),"", Color.PINK,Color.BLACK);
        fields[9] = new GUI_Street(Language.getLine("fP3_title"),Language.getLine("fP3_subtext"),Language.getLine("fP3_desc"),"", Color.PINK,Color.BLACK);
        fields[10] = new GUI_Jail("default",Language.getLine("fJ1_title"),Language.getLine("fJ1_subtext"),Language.getLine("fJ1_desc"),Color.DARK_GRAY,Color.BLACK);
        fields[11] = new GUI_Street(Language.getLine("fO1_title"),Language.getLine("fO1_subtext"),Language.getLine("fO1_desc"),"", Color.ORANGE, Color.BLACK);
        fields[12] = new GUI_Brewery("default", Language.getLine("fBryg1_title"), Language.getLine("fBryg1_subtext"), Language.getLine("fBryg1_desc"), "",Color.CYAN, Color.BLACK);
        fields[13] = new GUI_Street(Language.getLine("fO2_title"),Language.getLine("fO2_subtext"),Language.getLine("fO2_desc"),"", Color.ORANGE, Color.BLACK);
        fields[14] = new GUI_Street(Language.getLine("fO3_title"),Language.getLine("fO3_subtext"),Language.getLine("fO3_desc"),"", Color.ORANGE, Color.BLACK);
        fields[15] = new GUI_Shipping("default", Language.getLine("fS2_title"), Language.getLine("fS2_subtext"), Language.getLine("fS2_desc"), "", new Color(135,206,250), Color.BLACK);
        fields[16] = new GUI_Street(Language.getLine("fG1_title"),Language.getLine("fG1_subtext"),Language.getLine("fG1_desc"),"", Color.LIGHT_GRAY, Color.BLACK);
        fields[17] = new GUI_Chance(Language.getLine("fC_title"),Language.getLine("fC_subtext"),Language.getLine("fC_desc"),Color.BLACK,Color.WHITE);
        fields[18] = new GUI_Street(Language.getLine("fG2_title"),Language.getLine("fG2_subtext"),Language.getLine("fG2_desc"),"", Color.LIGHT_GRAY, Color.BLACK);
        fields[19] = new GUI_Street(Language.getLine("fG3_title"),Language.getLine("fG3_subtext"),Language.getLine("fG3_desc"),"", Color.LIGHT_GRAY, Color.BLACK);
        fields[20] = new GUI_Refuge("default",Language.getLine("fPark_title"),Language.getLine("fPark_subtext"),Language.getLine("fPark_desc"),Color.GREEN,Color.BLACK);
        fields[21] = new GUI_Street(Language.getLine("fR1_title"),Language.getLine("fR1_subtext"),Language.getLine("fR1_desc"),"", Color.RED, Color.BLACK);
        fields[22] = new GUI_Chance(Language.getLine("fC_title"),Language.getLine("fC_subtext"),Language.getLine("fC_desc"),Color.BLACK,Color.WHITE);
        fields[23] = new GUI_Street(Language.getLine("fR2_title"),Language.getLine("fR2_subtext"),Language.getLine("fR2_desc"),"", Color.RED, Color.BLACK);
        fields[24] = new GUI_Street(Language.getLine("fR3_title"),Language.getLine("fR3_subtext"),Language.getLine("fR3_desc"),"", Color.RED, Color.BLACK);
        fields[25] = new GUI_Shipping("default", Language.getLine("fS3_title"), Language.getLine("fS3_subtext"), Language.getLine("fS3_desc"), "", new Color(135,206,250), Color.BLACK);
        fields[26] = new GUI_Street(Language.getLine("fW1_title"),Language.getLine("fW1_subtext"),Language.getLine("fW1_desc"),"", Color.WHITE, Color.BLACK);
        fields[27] = new GUI_Street(Language.getLine("fW2_title"),Language.getLine("fW2_subtext"),Language.getLine("fW2_desc"),"", Color.WHITE, Color.BLACK);
        fields[28] = new GUI_Brewery("default", Language.getLine("fBryg2_title"), Language.getLine("fBryg2_subtext"), Language.getLine("fBryg2_desc"), "",Color.CYAN, Color.BLACK);
        fields[29] = new GUI_Street(Language.getLine("fW3_title"),Language.getLine("fW3_subtext"),Language.getLine("fW3_desc"),"", Color.WHITE, Color.BLACK);
        fields[30] = new GUI_Jail(Language.getLine("fJ2_title"),Language.getLine("fJ2_subtext"),Language.getLine("fJ2_desc"),"", Color.DARK_GRAY,Color.BLACK);
        fields[31] = new GUI_Street(Language.getLine("fY1_title"),Language.getLine("fY1_subtext"),Language.getLine("fY1_desc"),"", Color.YELLOW, Color.BLACK);
        fields[32] = new GUI_Street(Language.getLine("fY2_title"),Language.getLine("fY2_subtext"),Language.getLine("fY2_desc"),"", Color.YELLOW, Color.BLACK);
        fields[33] = new GUI_Chance(Language.getLine("fC_title"),Language.getLine("fC_subtext"),Language.getLine("fC_desc"),Color.BLACK,Color.WHITE);
        fields[34] = new GUI_Street(Language.getLine("fY3_title"),Language.getLine("fY3_subtext"),Language.getLine("fY3_desc"),"", Color.YELLOW, Color.BLACK);
        fields[35] = new GUI_Shipping("default", Language.getLine("fS4_title"), Language.getLine("fS4_subtext"), Language.getLine("fS4_desc"), "", new Color(135,206,250), Color.BLACK);
        fields[36] = new GUI_Chance(Language.getLine("fC_title"),Language.getLine("fC_subtext"),Language.getLine("fC_desc"),Color.BLACK,Color.WHITE);
        fields[37] = new GUI_Street(Language.getLine("fPur1_title"),Language.getLine("fPur1_subtext"),Language.getLine("fPur1_desc"),"", Color.MAGENTA, Color.BLACK);
        fields[38] = new GUI_Tax(Language.getLine("fT2_title"),Language.getLine("fT2_subtext"),Language.getLine("fT2_desc"),Color.GREEN,Color.BLACK);
        fields[39] = new GUI_Street(Language.getLine("fPur2_title"),Language.getLine("fPur2_subtext"),Language.getLine("fPur2_desc"),"", Color.MAGENTA, Color.BLACK);

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