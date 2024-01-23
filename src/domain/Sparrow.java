package domain;

import structural.proxy.Barn;
import structural.proxy.GrainStorage;
import structural.proxy.Nest;

public class Sparrow extends AbstractAnimal {

    private final GrainStorage storage = new Nest(new Barn());

    public Sparrow(AnimalSpecies species, String name, int strength) {
        super(species, name, strength);
    }

    @Override
    public void getBusy() {
        showInfo(name + " is chirping and hopping around...");
    }

    @Override
    public void move() {
        showInfo(name + " is flying...");
    }

    @Override
    public void findFood() {
        showInfo(name + " is getting to the " + storage.getGrainSource() + " full of grain...");
    }

    @Override
    public void eat() {
        showInfo(name + " is pecking the grain...");
    }
}
