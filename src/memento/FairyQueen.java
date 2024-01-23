package memento;

import common.Animal;

public class FairyQueen {

    private AnimalMemento memento;

    public void saveAnimalState(Animal animal) {
        memento = animal.saveState();
    }

    public void restoreAnimalState(Animal animal) {
        animal.restoreState(memento);
    }
}
