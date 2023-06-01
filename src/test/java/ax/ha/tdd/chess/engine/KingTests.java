package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTests {
    @Test
    public void testMoveMoreThanTwoSquaresAtStartShouldBeIllegal() {
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
    public void testWhiteKnightMoveRight(){

        Chessboard chessboard = new ChessboardImpl();
        King d4 = new King(Player.WHITE, new Square("d4"));
        assertTrue(d4.canMove(chessboard, new Square("e4")));
    }

    @Test
    public void testBlackKnightMoveRight(){

        Chessboard chessboard = new ChessboardImpl();
        King d6 = new King(Player.BLACK, new Square("d6"));
        assertTrue(d6.canMove(chessboard, new Square("e6")));
    }

    @Test
    public void testWhiteKnightMoveForward(){

        Chessboard chessboard = new ChessboardImpl();
        King d4 = new King(Player.WHITE, new Square("d4"));
        assertTrue(d4.canMove(chessboard, new Square("d5")));
    }

    @Test
    public void testBlackKnightMoveForward(){

        Chessboard chessboard = new ChessboardImpl();
        King d6 = new King(Player.BLACK, new Square("d6"));
        assertTrue(d6.canMove(chessboard, new Square("d5")));
    }

    @Test
    public void testWhiteKnightMoveLeft(){

        Chessboard chessboard = new ChessboardImpl();
        King d4 = new King(Player.WHITE, new Square("d4"));
        assertTrue(d4.canMove(chessboard, new Square("c4")));
    }

    @Test
    public void testBlackKnightMoveLeft(){

        Chessboard chessboard = new ChessboardImpl();
        King d6 = new King(Player.BLACK, new Square("d6"));
        assertTrue(d6.canMove(chessboard, new Square("c6")));
    }

    @Test
    public void testWhiteKnightMoveBackwards(){

        Chessboard chessboard = new ChessboardImpl();
        King d4 = new King(Player.WHITE, new Square("d4"));
        assertTrue(d4.canMove(chessboard, new Square("d3")));
    }

    @Test
    public void testBlackKnightMoveBackwards(){

        Chessboard chessboard = new ChessboardImpl();
        King d6 = new King(Player.BLACK, new Square("d6"));
        assertTrue(d6.canMove(chessboard, new Square("d7")));
    }

    @Test
    public void testWhiteKnightMoveDiagonal(){

        Chessboard chessboard = new ChessboardImpl();
        King d4 = new King(Player.WHITE, new Square("d4"));
        assertTrue(d4.canMove(chessboard, new Square("e5")));
    }

    @Test
    public void testBlackKnightMoveDiagonal(){

        Chessboard chessboard = new ChessboardImpl();
        King d4 = new King(Player.WHITE, new Square("g6"));
        assertTrue(d4.canMove(chessboard, new Square("f5")));
    }

    @Test
    public void testWhiteKnightBlockedByPawn(){

        Chessboard chessboard = new ChessboardImpl();
        King d4 = new King(Player.WHITE, new Square("d4"));
        chessboard.addPiece(new Pawn(Player.BLACK, new Square("c5")));
        assertFalse(d4.canMove(chessboard, new Square("c5")));
    }

    @Test
    public void testBlackKnightBlockedByPawn(){

        Chessboard chessboard = new ChessboardImpl();
        King d5 = new King(Player.BLACK, new Square("d5"));
        chessboard.addPiece(new Pawn(Player.WHITE, new Square("e4")));
        assertFalse(d5.canMove(chessboard, new Square("e4")));
    }

    @Test
    public void testWhiteKnightBlockedByRookDirectionY(){

        Chessboard chessboard = new ChessboardImpl();
        King d4 = new King(Player.WHITE, new Square("d4"));
        chessboard.addPiece(new Rock(Player.BLACK, new Square("d3")));
        assertFalse(d4.canMove(chessboard, new Square("d3")));
    }

    @Test
    public void testBlackKnightBlockedByRookDirectionY(){

        Chessboard chessboard = new ChessboardImpl();
        King g5 = new King(Player.BLACK, new Square("g5"));
        chessboard.addPiece(new Rock(Player.WHITE, new Square("g1")));
        assertFalse(g5.canMove(chessboard, new Square("g1")));
    }

    @Test
    public void testWhiteKnightBlockedByRookDirectionX(){

        Chessboard chessboard = new ChessboardImpl();
        King d4 = new King(Player.WHITE, new Square("d4"));
        chessboard.addPiece(new Rock(Player.BLACK, new Square("a4")));
        assertFalse(d4.canMove(chessboard, new Square("a4")));
    }

    @Test
    public void testBlackKnightBlockedByRookDirectionX(){

        Chessboard chessboard = new ChessboardImpl();
        King g5 = new King(Player.BLACK, new Square("g5"));
        chessboard.addPiece(new Rock(Player.WHITE, new Square("b5")));
        assertFalse(g5.canMove(chessboard, new Square("b5")));
    }

}
