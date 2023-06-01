package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.Square;

public class King extends ChessPieceBase implements ChessPiece{
    public King(Player player, Square location) {
        super(PieceType.KING, player, location);
    }

    @Override
    public String getSymbol() {
        return null;
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {

        if (chessboard.getPieceAt(destination) == null) {
            if ((destination.getX() == location.getX()) && (location.getY() == destination.getY() - 1) || (location.getY() == destination.getY() + 1)) {
                return true;
            }else if((destination.getY() == location.getY()) && (location.getX() == destination.getX() - 1) || (location.getX() == destination.getX() + 1)){
                return true;
            }else if((destination.getX() == location.getX()-1) && (destination.getY() == location.getY()+1)){
                return true;
            }else if((destination.getX() == location.getX()-1) && (destination.getY() == location.getY()-1)){
                return true;
            }else if((destination.getX() == location.getX()+1) && (destination.getY() == location.getY()+1)){
                return true;
            }else if((destination.getX() == location.getX()+1) && (destination.getY() == location.getY()-1)){
                return true;
            }

        }
        else{
            if (!chessboard.getPieceAt(destination).getPlayer().equals(getPlayer())) {
                if(chessboard.getPieceAt(destination).getPieceType().equals(PieceType.PAWN)){
                    if(player.equals(Player.WHITE)){
                        if(destination.getY() == location.getY()+1 || destination.getY() == location.getY()-1){
                            if(destination.getX() == location.getX()+1 || destination.getX() == location.getX()-1){
                                return false;
                            }

                        }
                    }
                    if(player.equals(Player.BLACK)){
                        if(destination.getY() == location.getY()+1 || destination.getY() == location.getY()-1){
                            if(destination.getX() == location.getX()+1 || destination.getX() == location.getX()-1){
                                return false;
                            }
                        }
                    }

                }
                if(chessboard.getPieceAt(destination).getPieceType().equals(PieceType.ROOK)){
                    if(destination.getY() == location.getY() || destination.getX() == location.getX()){
                        return false;
                    }

                }

            }
        }
        return false;

    }
}
