package trello.entities;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private String id;
    private String name;
    private String type;
    private String publicButton;

    private final static String BOARD_NAME = "name";
    private final static String TYPE = "type";
    private final static String PUBLIC_BUTTON = "buttonPublic";

    /**
     * Gets the attribute id.
     *
     * @return attribute id.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the attribute name.
     *
     * @return the attribute name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets id.
     *
     * @param id to be set.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Sets name.
     *
     * @param name to be set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the attribute Public Button.
     *
     * @return the attribute Public Button.
     */
    public String getPublicButton() {
        return this.publicButton;
    }

    /**
     * Sets publicButton.
     *
     * @param publicButton to be set.
     */
    public void setPublicButton(final String publicButton) {
        this.publicButton = publicButton;
    }

    /**
     * Gets the attribute Type.
     *
     * @return the attribute type.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets type.
     *
     * @param type to be set.
     */
    public void setType(final String type) {
        this.type = type;
    }

    public void setBoardInformation(final Map<String, String> boardInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(boardInformation);
        boardInformation.keySet().forEach(key -> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeStrategyMap(Map<String, String> boardInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();

        strategyMap.put("name", () -> setName(boardInformation.get(BOARD_NAME)));
        strategyMap.put("type", () ->  setType(boardInformation.get(TYPE)));
        return strategyMap;
    }


}
