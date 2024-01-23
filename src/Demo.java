import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import structural.decorator.TalkingAnimal;
import domain.Animal;
import domain.AnimalSpecies;
import domain.AnimalState;
import creational.factoryMethod.AnimalFactory;
import behavioral.memento.FairyQueen;

public class Demo {

    private static Animal animal;
    private static Animal spider;
    private static Animal sparrow;
    private static Animal roe;
    private static Animal tiger;

    private static final AnimalFactory animalFactory = new AnimalFactory();

    public static void main(String[] args) {
        System.out.println("\nFIVE GoF OBJECT ORIENTED DESIGN PATTERNS");

        showFactoryMethod();
        showDecorator();
        showProxy();
        showChainOfResponsibility();
        showMemento();
    }

    private static void showFactoryMethod() {
        System.out.println("\nFACTORY METHOD DEMO\n");
        spider = animalFactory.createAnimal(AnimalSpecies.SPIDER, "Archy", 1);
        sparrow = animalFactory.createAnimal(AnimalSpecies.SPARROW, "Chip", 2);
        roe = animalFactory.createAnimal(AnimalSpecies.ROE, "Lily", 3);
        tiger = animalFactory.createAnimal(AnimalSpecies.TIGER, "Fluffy", 4);
        List<Animal> animals = Arrays.asList(spider, sparrow, roe, tiger);
        System.out.println("Four different animals have been created using a single factory method and added to a list.");
        System.out.println("Now a random animal will get a random state and act accordingly:\n");
        SecureRandom random = new SecureRandom();
        animal = animals.get(random.nextInt(3));
        animal.setState(AnimalState.values()[random.nextInt(3)]);
        animal.act();
    }

    private static void showDecorator() {
        System.out.println("\nDECORATOR DEMO\n");
        animal = new TalkingAnimal(animal);
        System.out.println("Our random animal has been wrapped in a decorator class.");
        System.out.println("Now it will be talking before and after acting:\n");
        animal.act();
    }

    private static void showProxy() {
        System.out.println("\nPROXY DEMO\n");
        Animal sparrow = animalFactory.createAnimal(AnimalSpecies.SPARROW, "Birdie", 2);
        System.out.println("A sparrow gets hungry and flies to a nearer, but smaller, grain storage - the nest.");
        System.out.println("The nest is a proxy, which redirects to the barn - a larger storage - if the grain has not been gathered yet.");
        System.out.println("So, first time - to the barn, next times - to the nest:");
        for (int i = 0; i < 3; i++) {
            System.out.println();
            sparrow.setState(AnimalState.HUNGRY);
            sparrow.act();
        }
    }

    private static void showChainOfResponsibility() {
        System.out.println("\nCHAIN OF RESPONSIBILITY DEMO\n");
        spider.setHelpingFriend(sparrow);
        sparrow.setHelpingFriend(roe);
        roe.setHelpingFriend(tiger);
        System.out.println("Three animals have obtained helping friends.");
        System.out.println("Now, if the obstacle is too heavy for one of them, a friend comes to help.\n");
        spider.removeObstacle(4);
    }

    private static void showMemento() {
        System.out.println("\nMEMENTO DEMO\n");
        System.out.println("Now, let's add some drama. Our tiger is getting hungry:\n");
        tiger.act();
        System.out.println("\nBut, before something really bad happens, "
                + "a Fairy Queen (a.k.a. caretaker) appears and saves the state of our roe in a memento.\n");
        FairyQueen fairyQueen = new FairyQueen();
        fairyQueen.saveAnimalState(roe);
        System.out.println("Now, our tiger is acting:\n");
        tiger.act();
        System.out.println("\nOh, no! Our roe is dead now:\n");
        roe.setState(AnimalState.DEAD);
        roe.act();
        System.out.println("\nBut wait! The Fairy Queen comes and restores the state of our roe from the memento.\n");
        fairyQueen.restoreAnimalState(roe);
        roe.act();
        System.out.println("\nHappy end! Thanks for your attention!");
    }
}