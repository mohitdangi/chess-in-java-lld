package org.example;

import java.util.List;

public class ChessGame {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Player currentPlayer;

    public ChessGame() {
        board = new Board();
        whitePlayer = new Player(Color.WHITE);
        blackPlayer = new Player(Color.BLACK);
        currentPlayer = whitePlayer; // White player starts first
        // Initialize the board with pieces placed in their starting positions
        board.initialize();
    }

    // Start the game
    public void startGame() {
        System.out.println("Starting Chess Game!");
        printBoard(); // Display initial board state
    }

    // Method to make a move
    public boolean makeMove(Player player, Move move) {
        // Check if it's the player's turn
        if (player != currentPlayer) {
            System.out.println("It's not your turn!");
            return false;
        }

        // Validate the move (e.g., check if the move is legal)
        if (!isValidMove(move)) {
            System.out.println("Invalid move!");
            return false;
        }

        // Make the move on the board
        if (!board.makeMove(move)) {
            System.out.println("Failed to make move!");
            return false;
        }

        // Switch player turn
        currentPlayer = (currentPlayer == whitePlayer) ? blackPlayer : whitePlayer;
        printBoard(); // Display updated board state
        return true;
    }

    // Method to check if a move is valid
    private boolean isValidMove(Move move) {
        // Get source and destination squares from the move
        Square sourceSquare = move.getSourceSquare();
        Square destinationSquare = move.getDestinationSquare();

        // Check if source and destination squares are within the board bounds
        if (!board.isValidSquare(sourceSquare) || !board.isValidSquare(destinationSquare)) {
            return false;
        }

        // Check if the source square contains a piece and it belongs to the player making the move
        Piece piece = sourceSquare.getPiece();
        if (piece == null || piece.getColor() != currentPlayer.getColor()) {
            return false;
        }

        // Check if the destination square is either empty or occupied by an opponent's piece (if capturing)
        Piece destinationPiece = destinationSquare.getPiece();
        if (destinationPiece != null && destinationPiece.getColor() == currentPlayer.getColor()) {
            return false; // Can't capture own piece
        }

        // Add additional validation logic based on piece movement rules (e.g., for specific pieces)

        return true; // Move is valid by default
    }
    // Method to print the current state of the board
    private void printBoard() {
        System.out.println("Current Board State:");
        System.out.println(board); // Assuming Board class has overridden toString() method
    }
}
