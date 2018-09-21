package org.leanpoker.player;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Rank {

    private int rank;

    private int value;

    @SerializedName("second_value")
    private int secondValue;

    private List<Integer> kickers;

    @SerializedName("cards_used")
    private List<Card> cards_used;

    private List<Card> cards;


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }

    public List<Integer> getKickers() {
        return kickers;
    }

    public void setKickers(List<Integer> kickers) {
        this.kickers = kickers;
    }

    public List<Card> getCards_used() {
        return cards_used;
    }

    public void setCards_used(List<Card> cards_used) {
        this.cards_used = cards_used;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
