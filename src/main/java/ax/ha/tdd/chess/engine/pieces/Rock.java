package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.Square;

public class Rock extends ChessPieceBase implements ChessPiece{
    public Rock(Player player, Square location) {
        super(PieceType.ROOK, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {

        if(player.equals(Player.WHITE)){
            if(chessboard.getPieceAt(destination) == null){
                if(location.getX()==destination.getX()){
                    return true;
                }
                if(location.getY()== destination.getY()){
                    return true;
                }
            }
        }

        return false;
    }
}
