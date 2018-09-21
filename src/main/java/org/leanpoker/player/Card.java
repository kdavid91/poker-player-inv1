package org.leanpoker.player;

public class Card {

    private String rank;
    private String suit;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "suit: " + suit + ", rank: " + rank;
    }
}
