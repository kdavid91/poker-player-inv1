package org.leanpoker.player;

public enum CurrentPlayEnum {
    PRE_FLOP(0), FLOP(3), TURN(4), RIVER(5);

    private final int cardCount;

    CurrentPlayEnum(final int cardCount) {
        this.cardCount = cardCount;
    }

    public int getCardCount() {
        return cardCount;
    }

}
