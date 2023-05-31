package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameImplTests {



    @Test
    public void playerWhiteToMoveFirstTime(){

        //Arrange
        Game game = new GameImpl();

        //Act

        //Assert
        assertEquals(Player.WHITE, game.getPlayerToMove());

    }


    @Test
    public void playerWhiteToMoveAfterTwoTurns(){
        //Arrange
        Game game = new GameImpl();

        //Act
        game.move("a2-a3");
        game.move("g7-g6");

        //Assert
        assertEquals(Player.WHITE, game.getPlayerToMove());
    }

    @Test
    public void playerBlackToMoveAfterOneTurn(){

        GameImpl game = new GameImpl();
        game.move("a2-a3");

        assertEquals(Player.BLACK, game.getPlayerToMove());
    }

    @Test
    public void getLastMove(){
        //Arrange
        String move = "a2-a3";
        String lastMove = "Last move was successful (a2-a3)";
        GameImpl game = new GameImpl();
        //Act
        game.move(move);
        //Assert
        assertEquals(lastMove, game.getLastMoveResult());
    }

    @Test
    public void testWhiteMovePawnFirstTurn() {
        //Arrange
        Game game = new GameImpl();
        //Act
        game.move("a2-a3");
        //Assert
        assertTrue(game.getBoard().getPieceAt(new Square("a3")) != null);
        assertTrue(game.getBoard().getPieceAt(new Square("a2")) == null);
    }

    @Test
    public void testWhiteMovePawnFirstTurnNotWorking() {
        //Arrange
        Game game = new GameImpl();
        //Act
        game.move("a2-a5");
        //Assert
        assertNull(game.getBoard().getPieceAt(new Square("a5")));
        assertNotNull(game.getBoard().getPieceAt(new Square("a2")));
    }

    @Test
    public void testSwitchPlayerWorks(){
        //Arrange
        Game game = new GameImpl();
        //Act
        game.move("d2-d4");
        game.move("e2-e3");
        //Assert
        System.out.println(new ChessboardWriter().print(game.getBoard()));
        assertEquals(Player.BLACK, game.getPlayerToMove());
    }

    //@Test
    public void testWhitePwanMoveNotFirst(){
        //Arrange
        Game game = new GameImpl();
        //Act
        game.move("d2-d4");
        game.move("f7-f6");
        game.move("d4-d5");
        assertTrue(game.getBoard().getPieceAt(new Square("d5")) != null);
        assertTrue(game.getBoard().getPieceAt(new Square("d4")) == null);
    }
}
