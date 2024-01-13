public class Tiger extends AbstractAnimal {

    public Tiger(String name, int strength) {
        super(name, strength);
    }

    @Override
    public void getBusy() {
        showInfo(name + " is basking in the sunlight...");
    }

    @Override
    public void move() {
        showInfo(name + " is walking...");
    }

    @Override
    public void findFood() {
        showInfo(name + " is hunting and killing a roe...");
    }

    @Override
    public void eat() {
        showInfo(name + " is devouring the roe...");
    }
}
