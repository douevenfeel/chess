package com.douevenfeel.game;

public class Queen extends ChessPiece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean moveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) return false;
        if (!isInBoard(toLine, toColumn)) return false;
        int deltaLine = Math.abs(line - toLine);
        int deltaColumn = Math.abs(column - toColumn);
        if (deltaLine == deltaColumn || deltaLine == 0 || deltaColumn == 0)
            return isPathClear(chessBoard, line, column, toLine, toColumn);
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
