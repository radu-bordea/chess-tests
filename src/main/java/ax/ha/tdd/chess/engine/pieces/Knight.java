package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.Square;

public class Knight extends ChessPieceBase implements ChessPiece{
    public Knight(Player player, Square location) {
        super(PieceType.KNIGHT, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {

        if (chessboard.getPieceAt(destination) == null) {

            if (player.equals(Player.WHITE)) {
                if ((destination.getX() == location.getX()-1) || (destination.getX() == location.getX()+1) && location.getY() == destination.getY()-2) {
                    return true;
                }
            } else if (player.equals(Player.BLACK)) {
                if ((destination.getX() == location.getX()-1) || (destination.getX() == location.getX()+1) && location.getY() == destination.getY()+2) {
                    return true;
                }
            }
        } else {
            if (!chessboard.getPieceAt(destination).getPlayer().equals(getPlayer()) && (destination.getY() == location.getY() - 2 || destination.getY() == location.getY() + 2) && (destination.getX() == location.getX() + 1) || destination.getX() == location.getX() - 1) {
                return true;
            }
        }
        return false;

    }
}
