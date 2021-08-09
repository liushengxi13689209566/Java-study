package statepattern;

public class MarioStateMachine {
    private int score;
    private State currentState;

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        //TODO
        this.score += 100;
        if (State.SMALL.equals(this.currentState)) {
            this.currentState = State.SUPER;
        }
    }

    public void obtainCape() {
        //TODO
        this.score += 200;
        if (State.SMALL.equals(this.currentState) || State.SUPER.equals(this.currentState)) {
            this.currentState = State.CAPE;
        } else {
            System.out.println("此时状态不可改变！！！");
        }

    }

    public void obtainFireFlower() {
        //TODO
        this.score += 300;
        if (State.SMALL.equals(this.currentState) || State.SUPER.equals(this.currentState)) {
            this.currentState = State.FIRE;
        } else {
            System.out.println("此时状态不可改变！！！");
        }
    }

    public void meetMonster() {
        //TODO
        if (State.FIRE.equals(this.currentState)) {
            this.score -= 300;
            this.currentState = State.SMALL;
        } else if (State.SUPER.equals(this.currentState)) {
            this.score -= 100;
            this.currentState = State.SMALL;
        } else if (State.CAPE.equals(this.currentState)) {
            this.score -= 200;
            this.currentState = State.SMALL;
        } else {
            System.out.println("此时状态不可改变！！！");
        }
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}
