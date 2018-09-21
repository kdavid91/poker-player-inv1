package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "BESTWINNERS";

    public static int betRequest(final JsonElement request) {
        GameState gameState = new Gson().fromJson(request, GameState.class);

        Players ourPlayer = gameState.getPlayers().stream()
                .filter(player -> player.getName().equals("InV1"))
                .findFirst()
                .get();
        
        return 100;

    }

    public static void showdown(final JsonElement game) {
        System.out.println(game);
    }

}
