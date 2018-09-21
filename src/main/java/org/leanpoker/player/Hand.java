package org.leanpoker.player;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Hand {

    public static boolean isPair(final Card left, final Card right) {
        return left.getRank().equals(right.getRank());
    }

    public static boolean isPair(List<Card> ourCards, List<Card> communityCards) {
        for (Card ourCard : ourCards) {
            if (communityCards.stream().map(Card::getValue).collect(Collectors.toList()).contains(ourCard.getValue())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSameSuit(final Card left, final Card right) {
        return left.getSuit().equals(right.getSuit());
    }

    public static boolean isHighPair(final Card left, final Card right) {
        return isPair(left, right) && isHighCard(left) && isHighCard(right);
    }

    public static boolean isHighPair(List<Card> ourCards, List<Card> communityCards) {
        for (Card ourCard : ourCards) {
            if (isHighCard(ourCard) && communityCards.contains(ourCard)) {
                return true;
            }
        }
        return false;
    }


    private static boolean isHighCard(final Card card) {
        return card.getValue() >= 10;
    }

}
