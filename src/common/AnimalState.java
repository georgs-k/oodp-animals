package common;

public enum AnimalState {

    ACTIVE, HUNGRY, SLEEPY, DEAD;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
