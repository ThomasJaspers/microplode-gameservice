package de.codecentric.microplode.messaging.api;

public enum PlayerType {

    HUMAN("human"), COMPUTER("computer");
    
    private String name;

    private PlayerType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
