package de.codecentric.microplode.messaging.api;

public enum EventType {

    NEW_GAME("new-game");
    
    private String text;

    private EventType(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
}
