package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTests {
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
    public void testWhiteKnightMoveAtStartUnblocked(){
        //Here's a lower level test, we just check that the internal logic of the pawn is correct.
        //We should be allowed to move one step forward to an empty square
        Chessboard chessboard = new ChessboardImpl();
        Knight b2 = new Knight(Player.WHITE, new Square("b2"));
        assertTrue(b2.canMove(chessboard, new Square("a3")));
    }

    @Test
    public void testBlackKnightMoveAtStartUnblocked(){
        //Here's a lower level test, we just check that the internal logic of the pawn is correct.
        //We should be allowed to move one step forward to an empty square
        Chessboard chessboard = new ChessboardImpl();
        Knight b8 = new Knight(Player.WHITE, new Square("b8"));
        assertTrue(b8.canMove(chessboard, new Square("a6")));
    }


    @Test
    public void testWhiteKnightMoveAnytimeUnblocked(){
        //Here's a lower level test, we just check that the internal logic of the pawn is correct.
        //We should be allowed to move one step forward to an empty square
        Chessboard chessboard = new ChessboardImpl();
        Knight d4 = new Knight(Player.WHITE, new Square("d4"));
        assertTrue(d4.canMove(chessboard, new Square("b5")));
    }

    @Test
    public void testBlackKnightMoveAnytimeUnblocked(){
        //Here's a lower level test, we just check that the internal logic of the pawn is correct.
        //We should be allowed to move one step forward to an empty square
        Chessboard chessboard = new ChessboardImpl();
        Knight d4 = new Knight(Player.WHITE, new Square("d4"));
        assertTrue(d4.canMove(chessboard, new Square("b5")));
    }
    @Test
    public void testKnightWhiteTakePiece(){
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Knight b1 = new Knight(Player.WHITE, new Square("b1"));
        chessboard.addPiece(new Pawn(Player.BLACK, new Square("a3")));
        assertTrue(b1.canMove(chessboard, new Square("a3")));
    }

    @Test
    public void testKnightBlackTakePiece(){
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Knight b1 = new Knight(Player.WHITE, new Square("b1"));
        chessboard.addPiece(new Pawn(Player.BLACK, new Square("a3")));
        assertTrue(b1.canMove(chessboard, new Square("a3")));
    }

}
