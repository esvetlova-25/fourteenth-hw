import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TournamentTest {
    @Test
    public void shouldFindSecondPlayer() {

        Player ira325 = new Player(1, "Ира", 50);
        Player masha = new Player(2, "Маша", 70);
        Game game = new Game();
        game.register(ira325);
        game.register(masha);
        int expected = 2;
        int actual = game.round("Ира", "Маша");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindFirstPlayer() {

        Player ira325 = new Player(1, "Ира", 70);
        Player masha = new Player(2, "Маша", 50);
        Game game = new Game();
        game.register(ira325);
        game.register(masha);
        int expected = 1;
        int actual = game.round("Ира", "Маша");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEqualsPlayer() {

        Player ira325 = new Player(1, "Ира", 50);
        Player masha = new Player(2, "Маша", 50);
        Game game = new Game();
        game.register(ira325);
        game.register(masha);
        int expected = 0;
        int actual = game.round("Ира", "Маша");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindFirstNotRegisteredPlayer() {

        Player ira325 = new Player(1, "Ира", 50);
        Player masha = new Player(2, "Маша", 50);
        Game game = new Game();
        game.register(ira325);
        game.register(masha);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Витя", "Маша"));
    }

    @Test
    public void shouldFindSecondNotRegisteredPlayer() {

        Player ira325 = new Player(1, "Ира", 50);
        Player masha = new Player(2, "Маша", 50);
        Game game = new Game();
        game.register(ira325);
        game.register(masha);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ира", "Петя"));
    }
}
