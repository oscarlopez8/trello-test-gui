package trello.entities;

public class Context {
    private User user;
    private Board board;
    private List list;

    public Context() {
        this.user = new User();
        this.board = new Board();
        this.list = new List();
    }

    /**
     * Gets User attribute.
     *
     * @return the User attribute.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets context's user.
     *
     * @param user is the user to be shared in context.
     */
    public void setUser(final User user) {
        this.user = user;
    }

    /**
     * Gets Board.
     *
     * @return the Board.
     */
    public List getList() {
        return list;
    }

    /**
     * Sets List.
     *
     * @param list variable of the List.
     */
    public void setList(final List list) {
        this.list = list;
    }

    /**
     * Gets Board.
     *
     * @return the Board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Sets board.
     *
     * @param board is the board.
     */
    public void setBoard(final Board board) {
        this.board = board;
    }
}
