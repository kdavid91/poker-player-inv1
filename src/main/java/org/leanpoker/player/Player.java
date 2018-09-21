package org.leanpoker.player;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "BESTWINNERS";

    public static int betRequest(final JsonElement request) {
        final GameState gameState = new Gson().fromJson(request, GameState.class);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(request));

        final Players ourPlayer = gameState.getPlayers().stream()
                .filter(player -> player.getName().equals("InV1"))
                .findFirst()
                .get();

        final Card leftCard = ourPlayer.getHoleCards().get(0);
        final Card rightCard = ourPlayer.getHoleCards().get(1);
        log("our cards: left: " + leftCard + ", right: " + rightCard);

        final int call = gameState.getCurrentBuyIn() - ourPlayer.getBet();
        final int minRaise = call + gameState.getMinimumRaise();
        final int allIn = gameState.getPlayers().size() * 1001;

        final List<Card> hand = gameState.getCommunityCards();
        hand.addAll(ourPlayer.getHoleCards());

        if (gameState.getCommunityCards().isEmpty() && Hand.isHighPair(leftCard, rightCard)) {
            return minRaise;
        }

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

    private static void log(final String message) {
        System.out.println(message);
    }

}
