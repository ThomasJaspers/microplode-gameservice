package de.codecentric.microplode.configuration;

public class Queues {
    private Queues() {};
    public static final String GENERAL_TOPIC_NAME = "microplode-topic-gameservice-exchange";
    public static final String QUEUE_NAME_GAMESERVICE = "microplode-newgame-event-gameservice";
    public static final String QUEUE_NAME_PLAYING_FIELD = "microplode-newgame-event-playingfield";
    public static final String QUEUE_NAME_COMPUTER_PLAYER = "microplode-newgame-event-computerplayer";
    public static final String QUEUE_NAME_PRESENTATION_SERVICE = "microplode-newgame-event-presentationservice";
}
