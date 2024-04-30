package org.example;
import java.util.*;
public class Player {
    private Color color;
    private List<Piece> pieces;

    public Player(Color color) {
        this.color = color;
        pieces = new ArrayList<>();
        // Initialize the player's pieces
    }

    // Methods for making moves, capturing pieces, etc.
}