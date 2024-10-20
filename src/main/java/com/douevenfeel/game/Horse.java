package com.douevenfeel.game;

public class Horse extends ChessPiece {

    public Horse(Color color) {
        super(color);
    }

    @Override
    public boolean moveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) return false;
        if (!isInBoard(toLine, toColumn)) return false;
        int deltaLine = toLine - line;
        int deltaColumn = toColumn - column;
        if ((Math.abs(deltaLine) == 2 && Math.abs(deltaColumn) == 1) || (Math.abs(deltaLine) == 1 && Math.abs(deltaColumn) == 2))
            return isPathClear(chessBoard, line, column, toLine, toColumn);
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
