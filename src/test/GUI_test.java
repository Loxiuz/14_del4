package test;

import game.GUIController;
import gui_main.GUI;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class GUI_test {

    @Test
    // Laver flere GUI'er, tester om den er singleton
    public void singleton() {
        GUI GUIa = GUIController.getInstance();
        GUI GUIb = GUIController.getInstance();
        assertEquals(GUIa.hashCode(),GUIb.hashCode()); // If the objects are the same instance, the hashcode will be the same
    }
}
