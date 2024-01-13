public class Roe extends AbstractAnimal {

    public Roe(String name, int strength) {
        super(name, strength);
    }

    @Override
    public void getBusy() {
        showInfo(name + " is prancing and playing...");
    }

    @Override
    public void move() {
        showInfo(name + " is walking...");
    }

    @Override
    public void findFood() {
        showInfo(name + " is getting to a meadow with green grass...");
    }

    @Override
    public void eat() {
        showInfo(name + " is grazing...");
    }
}
