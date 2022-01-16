package game;

import fieldpack.*;

public class GameBoard {
    private Field[] fields;
    private int size;
    int field;

    public int Stack(int size) {
        this.size = size;
        return size;
    }

    public Field getField(int field) {
        this.field = field;
        return fields[field];
    }

    public GameBoard() {
        Stack(40);
        fields = new Field[40];
        fields[0] = new Field_Start();
        fields[1] = new Field_Ownable(1200, 50);
        fields[2] = new Field_Chance();
        fields[3] = new Field_Ownable(1200, 50);
        fields[4] = new Field_Tax();
        fields[5] = new Field_Ownable(4000, 500);
        fields[6] = new Field_Ownable(2000, 100);
        fields[7] = new Field_Chance();
        fields[8] = new Field_Ownable(2000, 100);
        fields[9] = new Field_Ownable(2400, 150);
        fields[10] = new Field_Jail();
        fields[11] = new Field_Ownable(2800, 200);
        fields[12] = new Field_Ownable(3000, 225);
        fields[13] = new Field_Ownable(2800, 200);
        fields[14] = new Field_Ownable(3200, 250);
        fields[15] = new Field_Ownable(4000, 500);
        fields[16] = new Field_Ownable(3600, 300);
        fields[17] = new Field_Chance();
        fields[18] = new Field_Ownable(3600, 300);
        fields[19] = new Field_Ownable(4000, 350);
        fields[20] = new Field_Parking();
        fields[21] = new Field_Ownable(4400, 350);
        fields[22] = new Field_Chance();
        fields[23] = new Field_Ownable(4400, 350);
        fields[24] = new Field_Ownable(4800, 400);
        fields[25] = new Field_Ownable(4000, 500);
        fields[26] = new Field_Ownable(5200, 450);
        fields[27] = new Field_Ownable(5200, 450);
        fields[28] = new Field_Ownable(3000, 225);
        fields[29] = new Field_Ownable(5600, 500);
        fields[30] = new Field_GoToJail();
        fields[31] = new Field_Ownable(6000, 550);
        fields[32] = new Field_Ownable(6000, 550);
        fields[33] = new Field_Chance();
        fields[34] = new Field_Ownable(6400, 600);
        fields[35] = new Field_Ownable(4000, 500);
        fields[36] = new Field_Chance();
        fields[37] = new Field_Ownable(7000, 700);
        fields[38] = new Field_ExtraTax();
        fields[39] = new Field_Ownable(8000, 1000);
    }

}