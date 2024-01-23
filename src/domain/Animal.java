package domain;

import behavioral.memento.AnimalMemento;

public interface Animal {

    void getBusy(); // Behavior when an animal is active

    void move(); // Way of movement

    void findFood(); // Way of finding food

    void eat(); // Way of eating

    void sleep(); // Behavior when an animal is sleepy

    void removeObstacle(int weight); // Action to demonstrate Chain of Responsibility design pattern, takes weight of an obstacle

    void die(); // Dying

    void act(); // Action that depends on an animal's current state

    AnimalMemento saveState(); // Saving state to demonstrate Memento design pattern

    void restoreState(AnimalMemento memento); // Restoring state to demonstrate Memento design pattern

    void showInfo(String info); // Displaying information

    // Getters:
    AnimalSpecies getSpecies();

    String getName();

    int getStrength();

    AnimalState getState();

    // Setters:
    void setState(AnimalState state);

    void setHelpingFriend(Animal helpingFriend);
}
