package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

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

        int amountToCall = gameState.getCurrentBuyIn() - ourPlayer.getBet();

        if (Hand.isHighPair(leftCard, rightCard) || leftCard.getValue() > 12 || rightCard.getValue() > 12) {
            log("call with: " + amountToCall);
            return amountToCall;
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
