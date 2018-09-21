package org.leanpoker.player;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.testng.annotations.Test;

public class GameStateTest {

    private String player = "{\"name\":\"qwerty\",\"stack\":0,\"status\":\"out\",\"bet\":0,\"time_used\":59642,\"version\":\"ERROR: Unreachable\",\"id\":0}";
    private String gameState = "{\"tournament_id\":\"5ba48cf1b277ce0004000002\",\"game_id\":\"5ba4a6a6ac4f290004000017\",\"round\":21,\"players\":[{\"name\":\"qwerty\",\"stack\":0,\"status\":\"out\",\"bet\":0,\"time_used\":59642,\"version\":\"ERROR: Unreachable\",\"id\":0},{\"name\":\"szurikatak\",\"stack\":942,\"status\":\"folded\",\"bet\":0,\"time_used\":894496,\"version\":\"Default Java folding player\",\"id\":1},{\"name\":\"InV1\",\"stack\":869,\"status\":\"folded\",\"bet\":0,\"hole_cards\":[{\"rank\":\"6\",\"suit\":\"clubs\"},{\"rank\":\"8\",\"suit\":\"hearts\"}],\"time_used\":1973502,\"version\":\"Default Java folding player\",\"id\":2},{\"name\":\"TurboBot\",\"stack\":0,\"status\":\"out\",\"bet\":0,\"time_used\":118763,\"version\":\"TurboBot 1\",\"id\":3},{\"name\":\"Team name\",\"stack\":0,\"status\":\"out\",\"bet\":0,\"time_used\":1151796,\"version\":\"Best Python player\",\"id\":4},{\"name\":\"allin\",\"stack\":3189,\"status\":\"active\",\"bet\":0,\"time_used\":1124893,\"version\":\"Default Java folding player\",\"amount_won\":3189,\"id\":5}],\"small_blind\":5,\"big_blind\":10,\"orbits\":3,\"dealer\":5,\"community_cards\":[{\"rank\":\"10\",\"suit\":\"diamonds\"},{\"rank\":\"Q\",\"suit\":\"hearts\"},{\"rank\":\"K\",\"suit\":\"diamonds\"},{\"rank\":\"8\",\"suit\":\"clubs\"},{\"rank\":\"J\",\"suit\":\"hearts\"}],\"current_buy_in\":0,\"pot\":0}";

    @Test
    public void test() {

        GameState state = new Gson().fromJson(gameState, GameState.class);

        System.out.println(state.getPlayers().get(0).getBet());
    }

}