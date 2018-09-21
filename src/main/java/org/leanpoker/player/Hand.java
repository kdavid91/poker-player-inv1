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

    public boolean isHighCard(final Card card) {
        return "10".equals(card.getRank()) || "J".equals(card.getRank()) ||
                "Q".equals(card.getRank()) || "K".equals(card.getRank()) ||
                "A".equals(card.getRank());
    }

    public boolean isHighHandPair() {
        return isPair() && isHighCard(left) && isHighCard(right);
    }
}
