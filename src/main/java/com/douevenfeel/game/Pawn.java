package com.douevenfeel.game;

public class Pawn extends ChessPiece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean moveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) return false;
        if (!isInBoard(toLine, toColumn) || column != toColumn) return false;
        int direction = getColor() == Color.WHITE ? 1 : -1;
        if (toLine == line + direction)
            return isPathClear(chessBoard, line, column, toLine, toColumn);
        return line == 1 && toLine == line + 2 * direction;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
