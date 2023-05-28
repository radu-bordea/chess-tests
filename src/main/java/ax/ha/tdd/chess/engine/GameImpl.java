package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceBase;

public class GameImpl implements Game{

    final ChessboardImpl board = ChessboardImpl.startingBoard();

    //Feel free to delete this stuff. Just for initial testing.
    boolean isNewGame = true;

    @Override
    public Player getPlayerToMove() {
        //TODO this should reflect the current state.

        return Player.WHITE;
    }

    @Override
    public Chessboard getBoard() {
        return board;
    }

    @Override
    public String getLastMoveResult() {
        //TODO this should be used to show the player what happened
        //Illegal move, correct move, e2 moved to e4 etc. up to you!
        if (isNewGame) {
            return "Game hasn't begun";
        }
        return "Last move was successful (default reply, change this)";
    }

    @Override
    public void move(String move) {
        //TODO this should trigger your move logic.
        String[] position = move.split("-");
        ChessPieceBase chess;
        //chess.canMove()
        isNewGame = false;
        System.out.println("Player tried to perform move: " + move);
    }
}
