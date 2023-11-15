public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String player) {
        super("Player " + player + " not found");
    }
}