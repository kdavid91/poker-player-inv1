package org.leanpoker.player;

public class Hand {

    public static boolean isPair(final Card left, final Card right) {
        return left.getRank().equals(right.getRank());
    }

    public static boolean isSameSuit(final Card left, final Card right) {
        return left.getSuit().equals(right.getSuit());
    }

    public static boolean isHighPair(final Card left, final Card right) {
        return isPair(left, right) && isHighCard(left) && isHighCard(right);
    }

    private static boolean isHighCard(final Card card) {
        return "10".equals(card.getRank()) || "J".equals(card.getRank()) ||
                "Q".equals(card.getRank()) || "K".equals(card.getRank()) ||
                "A".equals(card.getRank());
    }

}
