package de.codecentric.microplode.domain;

import de.codecentric.microplode.messaging.api.PlayerType;

public class Player {

    private String name;
    private String id;
    private PlayerType type;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public PlayerType getType() {
        return type;
    }
    public void setType(PlayerType type) {
        this.type = type;
    }
}
