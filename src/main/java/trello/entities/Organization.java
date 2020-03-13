package trello.entities;

import java.util.ArrayList;
import java.util.List;

public class Organization {

    private String id;
    private String name;
    private java.util.List<String> userNameOfMembers;

    /**
     * Constructor of object of it's class.
     */
    public Organization() {
        userNameOfMembers = new ArrayList<String>();
    }

    /**
     * Gets the id attribute.
     *
     * @return id attribute.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id attribute.
     *
     * @param id to set the id attribute.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the name of team.
     *
     * @return name of team.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of team.
     *
     * @param name to set the name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the userNameOfMembers list.
     *
     * @return a List of Teams members.
     */
    public java.util.List<String> getUserNameOfMembers() {
        userNameOfMembers.sort(String::compareTo);
        return userNameOfMembers;
    }

    /**
     * Sets the usernameOfMembers list attribute of this class.
     *
     * @param usernameMembers is to set new value in usernameOfMembers attribute.
     */
    public void setUsernameOfMember(final List<String> usernameMembers) {
        for (String usernameMember : usernameMembers) {
            userNameOfMembers.add(usernameMember);
        }
    }

    /**
     * Add member to the member list.
     *
     * @param usernameMember is member to add member list.
     */
    public void addMember(final String usernameMember) {
        userNameOfMembers.add(usernameMember);
    }
}
