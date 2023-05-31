package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceStub;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTests {

    //If you use exceptions for your illegal moves, change this test to expect an exception instead.
    //@Test
    public void testMoveMoreThanTwoSquaresAtStartShouldBeIllegal(){
        //Arrange
        Game game = new GameImpl();

        //Act
        game.move("e2-e5"); //if you use real chess notation in your implementation, use simply "e5"

        //Assert
        assertEquals(Player.WHITE, game.getPlayerToMove());
        ChessPiece piece = game.getBoard().getPieceAt(new Square("e2"));
        assertEquals(Player.WHITE, piece.getPlayer());
        assertEquals(PieceType.PAWN, piece.getPieceType());


        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(game.getBoard()));

    }

    @Test
    public void testWhitePawnForwardOneStepUnblocked(){
        //Here's a lower level test, we just check that the internal logic of the pawn is correct.
        //We should be allowed to move one step forward to an empty square
        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Player.WHITE, new Square("e2"));
        assertTrue(e2.canMove(chessboard, new Square("e3")));
    }

    @Test
    public void testWhitePawnForwardTwoStepsUnblocked(){
        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Player.WHITE, new Square("e2"));
        assertTrue(e2.canMove(chessboard, new Square("e4")));
    }

    @Test
    public void testBlackPawnForwardOneStepUnblocked(){
        //Here's a lower level test, we just check that the internal logic of the pawn is correct.
        //We should be allowed to move one step forward to an empty square
        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Player.BLACK, new Square("e7"));
        assertTrue(e2.canMove(chessboard, new Square("e6")));
    }

    @Test
    public void testBlackPawnForwardTwoStepsUnblocked(){
        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Player.BLACK, new Square("e7"));
        assertTrue(e2.canMove(chessboard, new Square("e5")));
    }

    @Test
    public void testWhitePawnForwardOneStepBlocked(){
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Player.WHITE, new Square("e2"));
        chessboard.addPiece(new Pawn(Player.BLACK, new Square("e3")));
        //Assert
        assertFalse(e2.canMove(chessboard, new Square("e3")));
    }

    @Test
    public void testWhitePawnTakePiece(){
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Player.WHITE, new Square("e2"));
        chessboard.addPiece(new Pawn(Player.BLACK, new Square("f3")));
        assertTrue(e2.canMove(chessboard, new Square("f3")));
    }

    @Test
    public void testBlACKPawnTakePiece(){
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Player.BLACK, new Square("e7"));
        chessboard.addPiece(new Pawn(Player.WHITE, new Square("f6")));
        assertTrue(e2.canMove(chessboard, new Square("f6")));
    }

    @Test
    public void testWhiteCanNotTakeBackwards(){
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn e2 = new Pawn(Player.WHITE, new Square("e3"));
        chessboard.addPiece(new Pawn(Player.BLACK, new Square("f2")));
        assertFalse(e2.canMove(chessboard, new Square("f2")));
    }





}

