package trello.entities;

public class Member {

    private String fullName;
    private String initials;

    /**
     * Gets the full name of member.
     *
     * @return full name of member.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name of member.
     *
     * @param fullName sets the full name of member.
     */
    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the initials of member.
     *
     * @return the initials.
     */
    public String getInitials() {
        return initials;
    }

    /**
     * Sets the initials.
     *
     * @param initials sets the initials of a member.
     */
    public void setInitials(final String initials) {
        this.initials = initials;
    }
}
