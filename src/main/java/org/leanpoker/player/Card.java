package org.leanpoker.player;

public class Card {

    enum CardValue {

        C2(2),
        C3(3),
        C4(4),
        C5(5),
        C6(6),
        C7(7),
        C8(8),
        C9(9),
        C10(10),
        CJ(11),
        CQ(12),
        CK(13),
        CA(14);

        private int value;

        CardValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private String rank;
    private String suit;

    public String getRank() {
        return rank;
    }

    public Card setRank(String rank) {
        this.rank = rank;
        return this;
    }

    public String getSuit() {
        return suit;
    }

    public Card setSuit(String suit) {
        this.suit = suit;
        return this;
    }

    public int getValue() {
        return CardValue.valueOf("C" + getRank()).getValue();
    }

    @Override
    public String toString() {
        return "suit: " + suit + ", rank: " + rank;
    }
}
