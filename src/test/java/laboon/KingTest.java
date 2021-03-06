package laboon;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import static org.junit.Assert.*;	


public class KingTest{
	private static King king;
	private static Board board;
	
	@BeforeClass
	public static void createBoard(){
		board = new Board();
	}
	// Add a King to E4
	@Before
	public void addKing(){
		king = new King(true,4,4);
		board.addToSpace(4,4, king);
	}
	
	// Remove the piece we added
	@After
	public void removeKing(){
		board.removeFromSpace(king.getRow(),king.getCol(),false);
	}
	
	// Test king to E5
	@Test
	public void testKingMoveUp() {
		assertTrue(king.move(board, 3, 4));
	}
	
	// Test king to E3
	@Test
	public void testKingMoveDown() {
		assertTrue(king.move(board,5,4));
	}
	
	// Test king to F4
	@Test
	public void testKingMoveRight() {
		assertTrue(king.move(board,4,5));
	}
	
	// Test king to D4
	@Test
	public void testKingMoveLeft() {
		assertTrue(king.move(board,4,3));
	}
	
	// Test king to F5
	@Test
	public void testKingMoveUpAndRight() {
		assertTrue(king.move(board,3,5));
	}	
	
	// Test king to D5
	@Test
	public void testKingMoveUpAndLeft() {
		assertTrue(king.move(board,3,3));
	}		
	
	// Test king to F3
	@Test
	public void testKingMoveDownAndRight() {
		assertTrue(king.move(board,5,5));
	}	
	
	// Test king to D3
	@Test
	public void testKingMoveDownAndLeft() {
		assertTrue(king.move(board,5,3));
	}
	
	// Test king taking pawn at E7
	@Test
	public void testKingCapture(){
		king.move(board,3,4);
		king.move(board,2,4);
		assertTrue(king.move(board,1,4));
	}
	
	// Test king trying to share space with pawn at E2
	@Test
	public void testKingCollision(){
		king.move(board,5,4);
		assertFalse(king.move(board,6,4));
	}
	
	// Test check function
	@Test
	public void testCheck(){
		board.removeFromSpace(king.getRow(),king.getCol(),false);
		king = board.getWhiteKing();
		board.removeFromSpace(6,4,false);
		king.move(board,5,4);
		king.move(board,4,4);
		king.move(board,3,4);
		assertFalse(king.move(board,2,4));
		board.addToSpace(6,4, new Pawn(true,6,4));
	}	
}