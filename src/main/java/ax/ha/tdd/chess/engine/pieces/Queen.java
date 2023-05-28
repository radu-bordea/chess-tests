package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Player;
import ax.ha.tdd.chess.engine.Square;

public class Queen extends ChessPieceBase implements ChessPiece{
    public Queen(Player player, Square location) {
        super(PieceType.QUEEN, player, location);
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
