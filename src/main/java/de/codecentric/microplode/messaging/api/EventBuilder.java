package de.codecentric.microplode.messaging.api;

public class EventBuilder {

    public static Event newGameEvent() {
        Event newGameEvent = new Event();
        newGameEvent.setType(EventType.NEW_GAME_EVENT);
        PlayerDef playerOne = new PlayerDef();
        playerOne.setId("Kurt");
        playerOne.setType(PlayerType.HUMAN);
        newGameEvent.addPlayers(playerOne);
        
        PlayerDef playerTwo = new PlayerDef();
        playerTwo.setId("HighEndMac");
        playerTwo.setType(PlayerType.COMPUTER);
        newGameEvent.addPlayers(playerTwo);
        return newGameEvent;
    }
}
