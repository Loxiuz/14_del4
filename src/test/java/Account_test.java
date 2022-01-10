import game.*;
import gui_fields.GUI_Player;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Account_test {
	GUI_Player test = new GUI_Player("test");
	game.Account myAcc = new game.Account(test);
	game.Player player1 = new game.Player("tester",30);

	@Test
	// Test the deposit method
	public void depositTest() {
		myAcc.deposit(10);
		myAcc.deposit(5);
		assertEquals(15,myAcc.getBal()); // Balance is 0+10+5
	}
	@Test
	// Test the withdraw method
	public void withdrawTest() {
		myAcc.setBal(10);
		myAcc.withdraw(3);
		assertEquals(7, myAcc.getBal()); // Balance is 10-3
	}
	@Test
	// Test the payTo method
	public void payToTest() {
		myAcc.setBal(50);
		myAcc.payTo(player1,14);
		assertEquals(36,myAcc.getBal()); // Balance is 50-14
		assertEquals(44,player1.getAccount().getBal()); // Balance is 30+14
	}
	@Test
	// Pay more than owned with payTo
	public void payToTest2() {
		myAcc.setBal(10);
		myAcc.payTo(player1,14);
		assertEquals(0,myAcc.getBal()); // Balance can't go below 0
		assertEquals(44,player1.getAccount().getBal()); // Balance is 30+14
	}
	@Test
	// Pay yourself with payTo
	public void payToTest3() {
		player1.getAccount().payTo(player1,10);
	assertEquals(30,player1.getAccount().getBal()); // Balance is unchanged
	}
	@Test
	// Deposit a negative amount, check if bal can go < 0
	public void addToBalance() {
		myAcc.setBal(1);
		myAcc.deposit(-5);
		assertEquals(0, myAcc.getBal()); // Balance can't go below 0
	}
	@Test
	// Deposit a large amount, check if bal can go < 0 via integer overflow
	public void addToBalance2() {
		myAcc.setBal(2000000000);
		myAcc.deposit(1000000000);
		assertEquals(0, myAcc.getBal()); // Balance can't go below 0
	}
	@Test
	// Withdraw to a negative amount, check if bal can go < 0
	public void addToBalance3() {
		myAcc.setBal(1);
		myAcc.withdraw(5);
		assertEquals(0, myAcc.getBal()); // Balance can't go below 0
	}
	@Test
	// Set balance to < 0, check if bal can go < 0
	public void setBalance() {
		myAcc.setBal(-5);
		assertEquals(0, myAcc.getBal()); // Balance can't go below 0
	}
}
