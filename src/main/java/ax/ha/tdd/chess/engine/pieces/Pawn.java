package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.ChessboardImpl;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Player;

public class Pawn extends ChessPieceBase implements ChessPiece{

    public Pawn(Player player, Square location) {
        super(PieceType.PAWN, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {

        if(player.equals(Player.WHITE)){
            if(destination.getX() == location.getX() && location.getY() == 6){
                if(destination.getY() == location.getY() - 1 || destination.getY() == location.getY() - 2){
                    return true;
                }
            }
        }else if(player.equals(Player.BLACK)){
            if(destination.getX() == location.getX() && location.getY() == 1){
                if(destination.getY() == location.getY() + 1 || destination.getY() == location.getY() + 2){
                    return true;
                }
            }
        }
        return false;
    }
}
