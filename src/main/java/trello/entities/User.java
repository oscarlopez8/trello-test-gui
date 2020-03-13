package trello.entities;

public class User {
    private String email;
    private String fullName;
    private String username;
    private String password;

    public String getFullName() {
        return fullName;
    }

    /**
     * Sets full name to the user.
     *
     * @param fullName is the full name to be set.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Sets email to the user.
     *
     * @param email is the email to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    /**
     * Sets username to the user.
     *
     * @param username is the username to be set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    /**
     * Sets password to the user.
     *
     * @param password is the password to be used.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
