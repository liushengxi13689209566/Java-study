package statepattern.end;

import statepattern.State;

public class ApplicationDemo {
    public static void main(String[] args) {
        MarioStateMachineEnd mario = new MarioStateMachineEnd();
        mario.obtainMushRoom();
        int score = mario.getScore();
        State state = mario.getCurrentState();
        System.out.println("mario score: " + score + "; state: " + state);
    }
}
