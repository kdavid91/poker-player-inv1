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

        if (Hand.isHighPair(leftCard, rightCard)) {
            return minRaise;
        }
        log("" + gameState.getCommunityCards().size());
        if (gameState.getCommunityCards().size() == 0) {
            log("pre-flop");
            if (leftCard.getValue() > 12 || rightCard.getValue() > 12) {
                return call;
            }
        } else if (gameState.getCommunityCards().size() == 3) {
            log("flop");
        } else if (gameState.getCommunityCards().size() == 4) {
            log("turn");
        } else if (gameState.getCommunityCards().size() == 5) {
            log("river");
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
