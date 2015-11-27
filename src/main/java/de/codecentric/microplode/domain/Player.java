package de.codecentric.microplode.domain;

public class Player {

    private String name;
    private String id;
    private boolean human;
    
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
    public boolean isHuman() {
        return human;
    }
    public void setHuman(boolean human) {
        this.human = human;
    }
    
}
