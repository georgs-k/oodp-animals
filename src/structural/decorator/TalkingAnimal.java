package structural.decorator;

import domain.Animal;
import domain.AnimalSpecies;
import domain.AnimalState;
import behavioral.memento.AnimalMemento;

public class TalkingAnimal implements Animal {

    private final Animal animal;

    public TalkingAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void getBusy() {
        animal.getBusy();
    }

    @Override
    public void move() {
        animal.move();
    }

    @Override
    public void findFood() {
        animal.findFood();
    }

    @Override
    public void eat() {
        animal.eat();
    }

    @Override
    public void sleep() {
        animal.sleep();
    }

    @Override
    public void removeObstacle(int weight) {
        animal.removeObstacle(weight);
    }

    @Override
    public void die() {
        animal.die();
    }

    @Override
    public void act() {
        showInfo(getName() + ": \"Hi! Amazing, I can talk now!\"");
        animal.act();
        showInfo(getName() + ": \"I am " + getState() + " now, but I like talking. Bye!\"");
    }

    @Override
    public AnimalMemento saveState() {
        return animal.saveState();
    }

    @Override
    public void restoreState(AnimalMemento memento) {
        animal.restoreState(memento);
    }

    @Override
    public void showInfo(String info) {
        animal.showInfo(info);
    }

    @Override
    public AnimalSpecies getSpecies() {
        return animal.getSpecies();
    }

    @Override
    public String getName() {
        return animal.getName();
    }

    @Override
    public int getStrength() {
        return animal.getStrength();
    }

    @Override
    public AnimalState getState() {
        return animal.getState();
    }

    @Override
    public void setState(AnimalState state) {
        animal.setState(state);
    }

    @Override
    public void setHelpingFriend(Animal helpingFriend) {
        animal.setHelpingFriend(helpingFriend);
    }
}
