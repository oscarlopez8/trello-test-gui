package trello.navigatePages;

public class NavigatePages {


    private static final String BASE_URL = "https://trello.com";

    /**
     * Gets home page URL.
     *
     * @param username is the username of the user.
     * @return the home page URL.
     */
    public static String getHomePageUrl(final String username) {
        return BASE_URL + "/" + username + "/boards";
    }

    /**
     * Gets the uri of login page.
     *
     * @return as string the uri of login page.
     */
    public static String getLoginPageUrl() {
        return BASE_URL + "/login";
    }
}
