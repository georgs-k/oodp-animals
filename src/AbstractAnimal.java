public abstract class AbstractAnimal implements Animal {

    protected final AnimalSpecies species;

    protected final String name;

    protected final int strength;

    protected AnimalState state;

    protected Animal helpingFriend;

    public AbstractAnimal(AnimalSpecies species, String name, int strength) {
        this.species = species;
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
    public void removeObstacle(int weight) {
        showInfo("A " + species + " named " + name + " is trying to remove an obstacle...");
        if (weight <= strength) {
            showInfo(name + " has managed to remove the obstacle!");
            return;
        }
        showInfo("The obstacle is too heavy for " + name + ".");
        if (helpingFriend != null) {
            showInfo("A helping friend is being called...");
            helpingFriend.removeObstacle(weight);
            return;
        }
        showInfo("There's no friend to call. The obstacle hasn't been removed.");
    }

    @Override
    public void die() {
        showInfo(name + " is dying...");
        state = AnimalState.DEAD;
    }

    @Override
    public void act() {
        showInfo("A " + species + " named " + name + " is " + state + ".");
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

    @Override
    public void showInfo(String info) {
        System.out.println(info);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignoreException) { }
    }

    @Override
    public AnimalSpecies getSpecies() {return species;}

    @Override
    public String getName() {return name;}

    @Override
    public int getStrength() {return strength;}

    @Override
    public AnimalState getState() {return state;}

    @Override
    public void setState(AnimalState state) {
        this.state = state;
    }

    @Override
    public void setHelpingFriend(Animal helpingFriend) {
        this.helpingFriend = helpingFriend;
    }
}
