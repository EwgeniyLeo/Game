package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Gamer;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    Gamer player = new Gamer(11,"Vasya", 15);
    Gamer player1 = new Gamer(22,"Petya", 10);
    Gamer player2 = new Gamer(33,"Asay", 25);
    Gamer player3 = new Gamer(44,"Olya", 25);

    @Test
    public void Player1StrongerPlayer2(){
        Game game = new Game();
        game.registration(player);
        game.registration(player1);
        game.registration(player2);
        game.registration(player3);

        int actual = game.round(player.getName(),player1.getName());
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void Player1LessStrongerPlayer2(){
        Game game = new Game();
        game.registration(player);
        game.registration(player1);
        game.registration(player2);
        game.registration(player3);

        int actual = game.round(player1.getName(),player2.getName());
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void Player2EqualsPlayer3(){
        Game game = new Game();
        game.registration(player);
        game.registration(player1);
        game.registration(player2);
        game.registration(player3);

        int actual = game.round(player2.getName(),player3.getName());
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void Player1IsNotRegistred(){
        Game game = new Game();
        game.registration(player);
        game.registration(player1);
        game.registration(player2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round(player3.getName(), player1.getName());});
    }

    @Test
    public void Player2IsNotRegistred(){
        Game game = new Game();
        game.registration(player);
        game.registration(player1);
        game.registration(player2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            game.round(player1.getName(), player3.getName());});
    }
}
