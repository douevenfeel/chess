package com.douevenfeel.game;

public class Bishop extends ChessPiece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean moveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isInBoard(toLine, toColumn)) return false;
        if (line == toLine && column == toColumn) return false;
        int deltaLine = Math.abs(toLine - line);
        int deltaColumn = Math.abs(toColumn - column);
        if (deltaLine == deltaColumn)
            return isPathClear(chessBoard, line, column, toLine, toColumn);
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
