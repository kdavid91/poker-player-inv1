package org.leanpoker.player;

import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "WINNERS";

    public static int betRequest(final JsonElement request) {
        System.out.println(request);
        return 8;
    }

    public static void showdown(final JsonElement game) {
        System.out.println(game);
    }

}
