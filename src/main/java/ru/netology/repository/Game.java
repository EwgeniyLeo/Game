package ru.netology.repository;

import ru.netology.domain.Gamer;
import ru.netology.exception.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    protected ArrayList<Gamer> players = new ArrayList<>();

    public void registration(Gamer player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Gamer player1 = null;
        Gamer player2 = null;
        for (Gamer player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotFoundException("Element with name: " + playerName1 + " is not registered");
        }
        if (player2 == null) {
            throw new NotFoundException("Element with name: " + playerName2 + " is not registered");
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }

        return 0;
    }

}
