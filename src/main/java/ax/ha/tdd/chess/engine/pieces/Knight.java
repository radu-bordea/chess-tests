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
        return false;
    }
}
