package test;

import fields.Field_Jail;
import fields.Field_Ownable;
import fields.Field_Parking;
import game.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class Field_test {
    Field_Ownable field1 = new Field_Ownable(1);
    Field_Ownable field2 = new Field_Ownable(1);
    Field_Ownable field3 = new Field_Ownable(4);
    Field_Ownable field4 = new Field_Ownable(25);
    Field_Ownable empty = new Field_Ownable(0);
    Field_Jail jail = new Field_Jail();
    Field_Parking parking = new Field_Parking();
    Player player1 = new Player("Test1",20);
    Player player2 = new Player("Test2",20);
    Player player3 = new Player("Test3",20);

    @Test
    // When a player lands on an unowned field
    public void buyAmusement() {
        field1.landedOn(player1,field2);
        assertEquals(19,player1.getAccount().getBal()); // Player1 has spent 1$ on field1
        assertEquals(player1,field1.getOwner()); // Player1 bought field1
    }
    @Test
    // When a player lands on an unowned field that is more expensive
    public void buyAmusement2() {
        field3.landedOn(player1,empty);
        assertEquals(16,player1.getAccount().getBal()); // Player1 has spent 4$ on field3
        assertEquals(player1,field3.getOwner()); // Player1 bought field3
    }
    @Test
    // When a player lands on an unowned field that is too expensive
    public void buyAmusement3() {
        field4.landedOn(player1,empty);
        assertEquals(0,player1.getAccount().getBal()); // Player1 has spent more than they owned
        assertNull(field4.getOwner()); // Player1 couldn't afford field4
    }
    @Test
    // When a player lands on a field owned by them
    public void landOnOwn() {
        field1.landedOn(player1,field2);
        field1.landedOn(player1,field2);
        assertEquals(19,player1.getAccount().getBal()); // Player1 has spent 1$ on field1 and landed there again
        assertEquals(player1,field1.getOwner()); // Player1 bought field1
    }
    @Test
    // When a player lands on a field owned by another player
    public void landOnOthers() {
        field1.landedOn(player1,field2);
        field1.landedOn(player2,field2);
        assertEquals(20,player1.getAccount().getBal()); // Player1 has spent 1$ and earned 1$
        assertEquals(19,player2.getAccount().getBal()); // Player2 has paid player1 1$
        assertEquals(player1,field1.getOwner()); // Player1 bought field1 first
    }
    @Test
    // When a player lands on a field owned by another player, if said player also owns the adjacent field
    public void landOnOthers2() {
        field1.landedOn(player1,field2);
        field2.landedOn(player1,field1);
        field1.landedOn(player2,field2);
        assertEquals(20,player1.getAccount().getBal()); // Player1 bought 2 fields and earned double rent
        assertEquals(18,player2.getAccount().getBal()); // Player2 paid double rent
        assertEquals(player1,field2.getOwner()); // Player1 bought field1 first
    }
    @Test
    // When a player lands on a field owned by another player, if the adjacent field is owned by a third player
    public void landOnOthers3() {
        field1.landedOn(player1,field2);
        field2.landedOn(player2,field1);
        field1.landedOn(player3,field2);
        assertEquals(20,player1.getAccount().getBal()); // Player1 bought field1 and earned rent once
        assertEquals(19,player2.getAccount().getBal()); // Player2 bought field2
        assertEquals(19,player3.getAccount().getBal()); // Player3 paid rent to player1
        assertEquals(player1,field1.getOwner()); // Player1 bought field1 first
    }
    @Test
    // When a player lands on 'go to jail'
    public void landOnJail() {
        jail.landedOn(player1);
        assertEquals(19,player1.getAccount().getBal()); // Player1 paid a 1$ fine. Didn't pass start
        assertEquals(6,player1.getPosition()); // Player1 was moved to the jail (field 6 counting from 0)
    }
    @Test
    // When a player lands on parking
    public void landOnParking() {
        parking.landedOn(player1);
        assertEquals(20,player1.getAccount().getBal()); // Nothing happened
    }



}
