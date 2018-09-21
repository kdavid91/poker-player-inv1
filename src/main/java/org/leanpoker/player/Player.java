package org.leanpoker.player;

import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(final JsonElement request) {
<<<<<<< HEAD
        System.out.println(request);
=======
>>>>>>> 8e143cb71e17c0c85eb51db2e93f90f4c1bea0d2
        return 8;
    }

    public static void showdown(final JsonElement game) {
        System.out.println(game);
    }

}
