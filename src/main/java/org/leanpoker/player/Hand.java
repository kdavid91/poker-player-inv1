package org.leanpoker.player;

public class Hand {
    private Card left;
    private Card right;

    Hand(final Card left, final Card right) {
        this.left = left;
        this.right = right;
    }

    public Card getLeft() {
        return left;
    }

    public void setLeft(final Card left) {
        this.left = left;
    }

    public Card getRight() {
        return right;
    }

    public void setRight(final Card right) {
        this.right = right;
    }

    public boolean isPair() {
        return left.getRank().equals(right.getRank());
    }
}
