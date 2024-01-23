package memento;

import common.AnimalState;

public class AnimalMemento {

    private final AnimalState state;

    public AnimalMemento(AnimalState state) {
        this.state = state;
    }

    public AnimalState getState() {
        return state;
    }
}
