package org.leanpoker.player;

import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(final JsonElement request) {
        return 4;
    }

    public static void showdown(final JsonElement game) {
    }
}
