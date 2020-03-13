package trello.entities;

public class List {

    private String id;
    private String title;

    /**
     * Public constructor of the class.
     */
    public List() {

    }

    /**
     * Sets the list title.
     *
     * @param listTitle is the name of a list to be set.
     */
    public void setTitle(final String listTitle) {
        this.title = listTitle;
    }

    /**
     * Gets the list's title.
     *
     * @return the title of the list.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the id of a list.
     *
     * @return the id of a list.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id to the user.
     *
     * @param id of the username.
     */
    public void setId(final String id) {
        this.id = id;
    }
}
