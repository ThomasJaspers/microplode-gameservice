package de.codecentric.microplode.messaging.api;

public enum EventType {

    NEW_GAME_EVENT("new-game-event"),
    MOVE_EVENT("move-event"),
    INITIALIZE_EVENT("initialize-event"),
    NEXT_TURN_EVENT("next-turn-event");
    
    private String text;

    private EventType(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
}
