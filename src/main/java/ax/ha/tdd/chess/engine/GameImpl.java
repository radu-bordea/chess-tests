package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceBase;

public class GameImpl implements Game{

    Player currentPlayer;
    int countMoves = 0;
    boolean isNewGame = true;
    String lastMove = null;

    public GameImpl(Player currentPlayer, int countMoves){
        this.currentPlayer = currentPlayer;
        this.countMoves = countMoves;
    }

    public GameImpl(int countMoves, boolean isNewGame){
        this.countMoves = countMoves;
        this.isNewGame = isNewGame;
    }

    public GameImpl(String move, boolean isNewGame) {
        this.lastMove = move;
        this.isNewGame = isNewGame;
    }

    public GameImpl(){}
    final ChessboardImpl board = ChessboardImpl.startingBoard();



    //Feel free to delete this stuff. Just for initial testing.


    @Override
    public Player getPlayerToMove() {
        //TODO this should reflect the current state.

        if(isNewGame){
            currentPlayer = Player.WHITE;
        }else{
            if(countMoves%2 == 0){
                currentPlayer = Player.WHITE;
            }else{
                currentPlayer = Player.BLACK;
            }
        }
        return currentPlayer;
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
        return String.format("Last move was successful (%s)", lastMove);
    }

    @Override
    public void move(String move) {
        countMoves++;
        //TODO this should trigger your move logic.
        String[] position = move.split("-");
        ChessPieceBase chess;
        //chess.canMove()
        isNewGame = false;
        lastMove = move;

        System.out.println("Player tried to perform move: " + move);
    }
}
