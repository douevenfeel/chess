package com.douevenfeel.game;

abstract public class ChessPiece {
    private final Color color;
    private boolean check;

    public ChessPiece(Color color) {
        this.color = color;
        check = true;
    }

    public Color getColor() {
        return color;
    }

    public boolean isInBoard(int line, int column) {
        return line >= 0 && line < 8 && column >= 0 && column < 8;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck() {
        this.check = true;
    }

    abstract public boolean moveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public boolean isPathClear(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int stepLine = Integer.compare(toLine, line);
        int stepColumn = Integer.compare(toColumn, column);

        for (int i = line + stepLine, j = column + stepColumn; i != toLine || j != toColumn; i += stepLine, j += stepColumn) {
            if (chessBoard.board[i][j] != null) {
                return false;
            }
        }

        ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
        return targetPiece == null || !targetPiece.getColor().equals(this.getColor());
    }

    abstract public String getSymbol();
}
