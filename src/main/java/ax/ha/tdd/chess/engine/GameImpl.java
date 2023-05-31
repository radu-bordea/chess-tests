package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.ChessPieceBase;

public class GameImpl implements Game{

    Player currentPlayer;
    int countMoves = 0;
    String lastMove = null;

    final ChessboardImpl board = ChessboardImpl.startingBoard();


    boolean isNewGame() {
        if(countMoves == 0){
            return true;
        }
        return false;
    }

    //Feel free to delete this stuff. Just for initial testing.


    @Override
    public Player getPlayerToMove() {
        //TODO this should reflect the current state.

        if(isNewGame()){
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
        if (isNewGame()) {
            return "Game hasn't begun";
        }
        return String.format("Last move was successful (%s)", lastMove);
    }

    @Override
    public void move(String move) {
        //TODO this should trigger your move logic.
        String[] position = move.split("-");
        //chess.canMove()
        lastMove = move;
        ChessPiece temp = board.getPieceAt(new Square(position[0]));
        if(temp.getPlayer().equals(getPlayerToMove())){
            if(temp.canMove(board, new Square(position[1]))){
                temp.move(new Square(position[1]));
                board.addPiece(temp);
                board.removePieceAt(new Square(position[0]));
                countMoves++;
            }

        }

        System.out.println("Player tried to perform move: " + move);
    }
}
