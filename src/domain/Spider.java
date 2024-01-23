package domain;

public class Spider extends AbstractAnimal {

    public Spider(AnimalSpecies species, String name, int strength) {
        super(species, name, strength);
    }

    @Override
    public void getBusy() {
        showInfo(name + " is weaving a web...");
    }

    @Override
    public void move() {
        showInfo(name + " is wading through the web...");
    }

    @Override
    public void findFood() {
        showInfo(name + " is getting to an entangled fly...");
    }

    @Override
    public void eat() {
        showInfo(name + " is eating the fly...");
    }
}
