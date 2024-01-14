public interface Animal {

    void getBusy();

    void move();

    void findFood();

    void eat();

    void sleep();

    void removeObstacle();

    void die();

    void act();

    void showInfo(String info);

    AnimalSpecies getSpecies();

    String getName();

    int getStrength();

    AnimalState getState();

    void setState(AnimalState state);
}
