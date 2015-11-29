package de.codecentric.microplode.messaging.api;


public class PlayerDef {

    private String id;
    private PlayerType type;
    
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
