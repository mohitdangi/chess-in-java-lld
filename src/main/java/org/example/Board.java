package org.example;

public class Board {
    private Square[][] squares;

    public Board() {
        squares = new Square[8][8];
        initializeEmptySquares();
        initialize(); // corrected method name
    }

    private void initializeEmptySquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Square(i, j);
            }
        }
    }

    private void initialize() { // corrected method name
        // Add white pieces
        squares[0][0].setPiece(new Rook(Color.WHITE));
        squares[0][1].setPiece(new Knight(Color.WHITE));
        squares[0][2].setPiece(new Bishop(Color.WHITE));
        squares[0][3].setPiece(new Queen(Color.WHITE));
        squares[0][4].setPiece(new King(Color.WHITE));
        squares[0][5].setPiece(new Bishop(Color.WHITE));
        squares[0][6].setPiece(new Knight(Color.WHITE));
        squares[0][7].setPiece(new Rook(Color.WHITE));
        for (int i = 0; i < 8; i++) {
            squares[1][i].setPiece(new Pawn(Color.WHITE));
        }

        // Add black pieces
        squares[7][0].setPiece(new Rook(Color.BLACK));
        squares[7][1].setPiece(new Knight(Color.BLACK));
        squares[7][2].setPiece(new Bishop(Color.BLACK));
        squares[7][3].setPiece(new Queen(Color.BLACK));
        squares[7][4].setPiece(new King(Color.BLACK));
        squares[7][5].setPiece(new Bishop(Color.BLACK));
        squares[7][6].setPiece(new Knight(Color.BLACK));
        squares[7][7].setPiece(new Rook(Color.BLACK));
        for (int i = 0; i < 8; i++) {
            squares[6][i].setPiece(new Pawn(Color.BLACK));
        }
    }

    // Additional methods for moving pieces, checking for checkmate, etc.

    // Move a piece from one square to another
    public boolean movePiece(Move move) {
        Square sourceSquare = move.getSourceSquare();
        Square destinationSquare = move.getDestinationSquare();
        Piece pieceToMove = sourceSquare.getPiece();

        // Check if the move is valid
        if (!isValidMove(move)) {
            return false;
        }

        // Move the piece
        destinationSquare.setPiece(pieceToMove);
        sourceSquare.setPiece(null);
        pieceToMove.setCurrentSquare(destinationSquare);

        return true;
    }

    // Check if the move is valid
    private boolean isValidMove(Move move) {
        // Implement move validation logic based on the rules of chess
        return true; // Placeholder, always return true for now
    }

    // Check if the given player is in check
    public boolean isInCheck(Player player) {
        // Implement logic to check if the player's king is under attack
        return false; // Placeholder, always return false for now
    }

    // Check if the given player is in checkmate
    public boolean isInCheckmate(Player player) {
        // Implement logic to check if the player is in checkmate
        return false; // Placeholder, always return false for now
    }

    // Check if the given player is in stalemate
    public boolean isInStalemate(Player player) {
        // Implement logic to check if the player is in stalemate
        return false; // Placeholder, always return false for now
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = squares[i][j].getPiece();
                if (piece != null) {
                    sb.append(piece).append(" ");
                } else {
                    sb.append("- ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
