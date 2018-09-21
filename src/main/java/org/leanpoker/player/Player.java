package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.util.List;

public class Player {

    static final String VERSION = "BESTWINNERS";

    public static int betRequest(final JsonElement request) {
        GameState gameState = new Gson().fromJson(request, GameState.class);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(request));

        Players ourPlayer = gameState.getPlayers().stream()
                .filter(player -> player.getName().equals("InV1"))
                .findFirst()
                .get();

        Card leftCard = ourPlayer.getHoleCards().get(0);
        Card rightCard = ourPlayer.getHoleCards().get(1);
        log("our cards: left: " + leftCard + ", right: " + rightCard);

        int call = gameState.getCurrentBuyIn() - ourPlayer.getBet();
        int minRaise = call + gameState.getMinimumRaise();
        int allIn = gameState.getPlayers().size() * 1001;

        List<Card> hand = gameState.getCommunityCards();
        hand.addAll(ourPlayer.getHoleCards());

        if (Hand.isHighPair(leftCard, rightCard) || leftCard.getValue() > 12 || rightCard.getValue() > 12
                || Hand.isPair(ourPlayer.getHoleCards(), gameState.getCommunityCards())) {
            log("call with: " + call);
            return call;
        }

        if (gameState.getCurrentBuyIn() == 0 || gameState.getBigBlind() == gameState.getCurrentBuyIn()) {
            log("no bet");
            return minRaise;
        }

        return 0;
    }

    public static void showdown(final JsonElement game) {
        // System.out.println(game);
    }

    private static void log(String message) {
        System.out.println(message);
    }

}
