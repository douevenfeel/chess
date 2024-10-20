package com.douevenfeel.game;

public class Rook extends ChessPiece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean moveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) return false;
        if (!isInBoard(toLine, toColumn)) return false;
        if (line == toLine || column == toColumn)
            if (isPathClear(chessBoard, line, column, toLine, toColumn)) {
                setCheck();
                return true;
            }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
