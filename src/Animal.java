public interface Animal {

    void getBusy();

    void move();

    void findFood();

    void eat();

    void sleep();

    void removeObstacle();

    void die();

    void showInfo(String info);

    void setState(AnimalState state);

    void processState();
}
