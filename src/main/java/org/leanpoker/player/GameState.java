package org.leanpoker.player;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameState {

    private List<Players> players;

    @SerializedName("tournament_id")
    private String tournamentId;

    @SerializedName("game_id")
    private String gameId;

    private int round;

    @SerializedName("bet_index")
    private int betIndex;

    @SerializedName("small_blind")
    private int smallBlind;

    private int orbits;

    private int dealer;

    @SerializedName("community_cards")
    private List<Card> communityCards;

    @SerializedName("current_buy_in")
    private int currentBuyIn;

    private int pot;

    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getBetIndex() {
        return betIndex;
    }

    public void setBetIndex(int betIndex) {
        this.betIndex = betIndex;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(int smallBlind) {
        this.smallBlind = smallBlind;
    }

    public int getOrbits() {
        return orbits;
    }

    public void setOrbits(int orbits) {
        this.orbits = orbits;
    }

    public int getDealer() {
        return dealer;
    }

    public void setDealer(int dealer) {
        this.dealer = dealer;
    }

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(List<Card> communityCards) {
        this.communityCards = communityCards;
    }

    public int getCurrentBuyIn() {
        return currentBuyIn;
    }

    public void setCurrentBuyIn(int currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    public int getPot() {
        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

}
