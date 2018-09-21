package org.leanpoker.player;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
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

        final List<Card> hand = new ArrayList<>(gameState.getCommunityCards());
        hand.addAll(ourPlayer.getHoleCards());

        if (Hand.isHighPair(leftCard, rightCard)) {
            return minRaise * 2;
        }
        log("community cards: " + gameState.getCommunityCards().size());
        if (gameState.getCommunityCards().size() == 0) {
            log("pre-flop");
            if (leftCard.getValue() > 12 || rightCard.getValue() > 12) {
                return call;
            }
        } else if (gameState.getCommunityCards().size() >= 3) {
            log("flop");
            final Rank rank = new Gson().fromJson(httpGet("http://rainman.leanpoker.org/rank",
                    "cards", new Gson().toJson(hand)), Rank.class);
            log("rank: " + new GsonBuilder().setPrettyPrinting().create().toJson(rank));
            if (rank.getRank() == 1) {
                if (rank.getValue() > 8) {
                    return call;
                } else if (rank.getValue() > 12) {
                    return minRaise;
                }
            } else if (rank.getRank() > 1) {
                return minRaise * 2;
            }

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

    private static String httpGet(final String url, final String property, final String value) {
        try {
            final HttpURLConnection http = (HttpURLConnection) new URL(url + "?cards=" + URLEncoder.encode(value, "UTF-8")).openConnection();
            http.setRequestMethod("GET");
            final String response = httpReadData(http);
            System.out.println(http.getResponseMessage());
            return response;
        } catch (final IOException e) {
            System.out.println("Http get failed!" + e);
            return "";
        }
    }

    private static String httpReadData(final HttpURLConnection http) throws IOException {
        final StringBuilder response = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new InputStreamReader(http.getInputStream(), UTF_8))) {
            String line;
            while ((line = input.readLine()) != null) {
                response.append(line);
            }
        }
        return response.toString();
    }

}
