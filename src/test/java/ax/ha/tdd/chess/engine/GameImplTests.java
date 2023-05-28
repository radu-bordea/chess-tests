package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameImplTests {



    @Test
    public void playerWhiteToMoveFirstTime(){

        boolean isNewGame = true;
        int countMoves = 0;
        GameImpl game = new GameImpl(countMoves, isNewGame);
        assertEquals(Player.WHITE, game.getPlayerToMove());

    }


    @Test
    public void playerWhiteToMove(){

        int countMoves = 6;
        boolean isNewGame = true;
        GameImpl game = new GameImpl(countMoves, isNewGame);
        assertEquals(Player.WHITE, game.getPlayerToMove());
    }

    @Test
    public void playerBlackToMove(){

        int countMoves = 5;
        boolean isNewGame = false;
        GameImpl game = new GameImpl(countMoves, isNewGame);
        assertEquals(Player.BLACK, game.getPlayerToMove());
    }

    @Test
    public void getLastMove(){

        String move = "a1-a2";
        String lastMove = "Last move was successful (a1-a2)";
        boolean isNewGame = false;
        GameImpl game = new GameImpl(move, isNewGame);
        assertEquals(lastMove, game.getLastMoveResult());

    }
}
