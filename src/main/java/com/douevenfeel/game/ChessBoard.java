package com.douevenfeel.game;

public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    Color nowPlayer;

    public ChessBoard(Color nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public Color nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].moveToPosition(this, startLine, startColumn, endLine, endColumn)) {
                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = nowPlayer.opposite();

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");

        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().getSymbol() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }


    public boolean castling0() {
        int line = nowPlayer == Color.WHITE ? 0 : 7;
        if (board[line][0] == null || board[line][4] == null) return false;
        if (board[line][0].getClass() != Rook.class) return false;
        if (board[line][4].getClass() != King.class) return false;
        if (board[line][1] != null || board[line][2] != null || board[line][3] != null) return false;
        if (!board[line][0].isCheck() || !board[line][4].isCheck()) return false;
        if (board[line][0].getColor() != nowPlayer || board[line][4].getColor() != nowPlayer) return false;
        if (new King(nowPlayer).isUnderAttack(this, line, 2)) return false;
        board[line][4] = null;
        board[line][0] = null;
        board[line][2] = new King(nowPlayer);
        board[line][3] = new Rook(nowPlayer);
        board[line][2].setCheck();
        board[line][3].setCheck();
        nowPlayer = nowPlayer.opposite();
        return true;
    }

    public boolean castling7() {
        int line = nowPlayer == Color.WHITE ? 0 : 7;
        if (board[line][7] == null || board[line][4] == null) return false;
        if (board[line][7].getClass() != Rook.class) return false;
        if (board[line][4].getClass() != King.class) return false;
        if (board[line][6] != null || board[line][5] != null) return false;
        if (!board[line][7].isCheck() || !board[line][4].isCheck()) return false;
        if (board[line][7].getColor() != nowPlayer || board[line][4].getColor() != nowPlayer) return false;
        if (new King(nowPlayer).isUnderAttack(this, line, 6)) return false;
        board[line][4] = null;
        board[line][7] = null;
        board[line][6] = new King(nowPlayer);
        board[line][5] = new Rook(nowPlayer);
        board[line][6].setCheck();
        board[line][5].setCheck();
        nowPlayer = nowPlayer.opposite();
        return true;
    }
}