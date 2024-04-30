package org.example;

public class Move {
    private Piece piece;
    private Square sourceSquare;
    private Square destinationSquare;
    private boolean isCapture;

    public Move(Piece piece, Square sourceSquare, Square destinationSquare, boolean isCapture) {
        this.piece = piece;
        this.sourceSquare = sourceSquare;
        this.destinationSquare = destinationSquare;
        this.isCapture = isCapture;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Square getSourceSquare() {
        return sourceSquare;
    }

    public void setSourceSquare(Square sourceSquare) {
        this.sourceSquare = sourceSquare;
    }

    public Square getDestinationSquare() {
        return destinationSquare;
    }

    public void setDestinationSquare(Square destinationSquare) {
        this.destinationSquare = destinationSquare;
    }

    public boolean isCapture() {
        return isCapture;
    }

    public void setCapture(boolean capture) {
        isCapture = capture;
    }
}
