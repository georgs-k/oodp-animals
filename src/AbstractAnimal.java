public abstract class AbstractAnimal implements Animal {

    protected final String name;

    protected final int strength;

    protected AnimalState state;

    public AbstractAnimal(final String name, final int strength) {
        this.name = name;
        this.strength = strength;
        this.state = AnimalState.ACTIVE;
    }

    @Override
    public abstract void getBusy();

    @Override
    public abstract void move();

    @Override
    public abstract void findFood();

    @Override
    public abstract void eat();

    @Override
    public void sleep() {
        showInfo(name + " is sleeping...");
    }

    @Override
    public void removeObstacle() {
        showInfo(name + " is trying to remove an obstacle...");
    }

    @Override
    public void die() {
        showInfo(name + " is dying...");
        state = AnimalState.DEAD;
    }

    @Override
    public void showInfo(String info) {
        System.out.println(info);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignoreException) { }
    }

    @Override
    public void setState(AnimalState state) {
        this.state = state;
    }

    @Override
    public void processState() {
        showInfo(name + " is " + state + ".");
        switch (state) {
            case ACTIVE:
                getBusy();
                state = AnimalState.HUNGRY;
                break;
            case HUNGRY:
                move();
                findFood();
                eat();
                state = AnimalState.SLEEPY;
                break;
            case SLEEPY:
                sleep();
                state = AnimalState.ACTIVE;
                break;
            default:
                showInfo("Nothing to do...");
                return;
        }
        showInfo("Now " + name + " is " + state + ".");
    }
}
