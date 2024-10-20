package com.douevenfeel.game;

public class King extends ChessPiece {
    public King(Color color) {
        super(color);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int lineIndex = 0; lineIndex < board.board.length; lineIndex++) {
            for (int columnIndex = 0; columnIndex < board.board[lineIndex].length; columnIndex++) {
                if (board.board[lineIndex][columnIndex] != null && board.board[lineIndex][columnIndex].getColor() != getColor()) {
                    if (board.board[lineIndex][columnIndex].moveToPosition(board, lineIndex, columnIndex, line, column))
                        return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean moveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) return false;
        if (!isInBoard(toLine, toColumn)) return false;
        int deltaLine = Math.abs(line - toLine);
        int deltaColumn = Math.abs(column - toColumn);

        if (deltaLine <= 1 && deltaColumn <= 1)
            if (isPathClear(chessBoard, line, column, toLine, toColumn)) {
                setCheck();
                return true;
            }
        return false;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
