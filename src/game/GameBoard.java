package game;

import fields.*;
import game.Player;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class GameBoard {

    public GameBoard() {

        Field fields[] = new Field[40];
        fields[0] = new Field_Start();
        fields[1] = new Field_Ownable(100);
        fields[2] = new Field_Chance();
        fields[3] = new Field_Ownable(100);
        fields[4] = new Field_Tax();
        fields[5] = new Field_Ownable(100);
        fields[6] = new Field_Ownable(100);
        fields[7] = new Field_Chance();
        fields[8] = new Field_Ownable(100);
        fields[9] = new Field_Ownable(100);
        fields[10] = new Field_Jail();
        fields[11] = new Field_Ownable(100);
        fields[12] = new Field_Ownable(100);
        fields[13] = new Field_Ownable(100);
        fields[14] = new Field_Ownable(100);
        fields[15] = new Field_Ownable(100);
        fields[16] = new Field_Ownable(100);
        fields[17] = new Field_Chance();
        fields[18] = new Field_Ownable(100);
        fields[19] = new Field_Ownable(100);
        fields[20] = new Field_Parking();
        fields[21] = new Field_Ownable(100);
        fields[22] = new Field_Chance();
        fields[23] = new Field_Ownable(100);
        fields[24] = new Field_Ownable(100);
        fields[25] = new Field_Ownable(100);
        fields[26] = new Field_Ownable(100);
        fields[27] = new Field_Ownable(100);
        fields[28] = new Field_Ownable(100);
        fields[29] = new Field_Ownable(100);
        fields[30] = new Field_GoToJail();
        fields[31] = new Field_Ownable(100);
        fields[32] = new Field_Ownable(100);
        fields[33] = new Field_Chance();
        fields[34] = new Field_Ownable(100);
        fields[35] = new Field_Ownable(100);
        fields[36] = new Field_Chance();
        fields[37] = new Field_Ownable(100);
        fields[38] = new Field_ExtraTax();
        fields[39] = new Field_Ownable(100);

    }
}