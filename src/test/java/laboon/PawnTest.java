package laboon;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import static org.junit.Assert.*;	


public class PawnTest{
	private static Pawn pawn;
	private static Board board;
	
	@BeforeClass
	public static void createBoard(){
		board = new Board();
	}
	// Add a Pawn to E4
	@Before
	public void addPawn(){
		pawn = new Pawn(true,4,4);
		board.addToSpace(4,4, pawn);
	}
	
	// Remove the queen from the board
	@After
	public void removePawn(){
		board.removeFromSpace(pawn.getRow(),pawn.getCol(),false);
	}
	
	// Test white pawn moving 2
	@Test
	public void testWhitePawnMove2() {
			assertTrue(pawn.move(board,2,4));
	}
	
	// Test black pawn moving 2
	@Test
	public void testBlackPawnMove2(){
		pawn = new Pawn(false,3,2);
		board.addToSpace(3,2,pawn);
		assertTrue(pawn.move(board,5,2));
	}
	
	// Test white pawn move 1
	@Test
	public void testWhitePawnMove1(){
		assertTrue(pawn.move(board,3,4));
	}
	
	// Test black pawn move 1
	@Test
	public void testBlackPawnMove1(){
		pawn = new Pawn(false,4,4);
		assertTrue(pawn.move(board,5,4));
	}
	
	// Test en passant
	@Test
	public void testEnPassant(){
		pawn = new Pawn(true,3,1);
		board.addToSpace(3,1,pawn);
		Piece blackPawn = board.removeFromSpace(1,0,false);
		board.addToSpace(3,0, blackPawn);
		assertTrue(pawn.move(board,2,0));
	}
}