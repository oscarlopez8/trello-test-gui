package trello.entities;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private String id;
    private String title;
    private List<Member> members;

    /**
     * Uses to get id.
     *
     * @return Id of card.
     */
    public String getId() {
        return id;
    }

    /**
     * Uses to set id.
     *
     * @param id is to input the id.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Uses to get a title.
     *
     * @return Title of card.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Uses to set title.
     *
     * @param title is to input the title.
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets a list of members.
     *
     * @return a list.
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * Sets a list the members.
     *
     * @param members is to input list with the members.
     */
    public void setMembers(final List<String> members) {
        this.members = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            this.members.add(new Member());
            this.members.get(i).setFullName(members.get(i));
            //this.members.get(i).setInitials(WebDriverActions.getFullNameInitials(members.get(i)));
        }
    }
}
