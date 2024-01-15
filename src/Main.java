import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("\nFIVE OF GoF OBJECT ORIENTED DESIGN PATTERNS");

        System.out.println("\nFACTORY METHOD DEMO\n");
        final AnimalFactory animalFactory = new AnimalFactory();
        final Animal spider = animalFactory.createAnimal(AnimalSpecies.SPIDER, "Archy", 1);
        final Animal sparrow = animalFactory.createAnimal(AnimalSpecies.SPARROW, "Chip", 2);
        final Animal roe = animalFactory.createAnimal(AnimalSpecies.ROE, "Lily", 3);
        final Animal tiger = animalFactory.createAnimal(AnimalSpecies.TIGER, "Fluffy", 4);
        List<Animal> animals = Arrays.asList(spider, sparrow, roe, tiger);
        System.out.println("Four different animals have been created using a single factory method and added to a list.");
        System.out.println("Now a random animal will get a random state and act accordingly:\n");
        SecureRandom random = new SecureRandom();
        Animal animal = animals.get(random.nextInt(3));
        animal.setState(AnimalState.values()[random.nextInt(3)]);
        animal.act();

        System.out.println("\nDECORATOR DEMO\n");
        animal = new TalkingAnimal(animal);
        System.out.println("Our random animal has been wrapped in a decorator class.");
        System.out.println("Now it will be talking before and after acting:\n");
        animal.act();

        System.out.println("\nPROXY DEMO\n");
        Animal anotherSparrow = animalFactory.createAnimal(AnimalSpecies.SPARROW, "Birdie", 2);
        System.out.println("A sparrow gets hungry and flies to a nearer, but smaller, grain storage - the nest.");
        System.out.println("The nest is a proxy, which redirects to the barn - a larger storage - if the grain has not been gathered yet.");
        System.out.println("So, first time - to the barn, next times - to the nest:");
        for (int i = 0; i < 3; i++) {
            System.out.println();
            anotherSparrow.setState(AnimalState.HUNGRY);
            anotherSparrow.act();
        }

        System.out.println("\nCHAIN OF RESPONSIBILITY DEMO\n");
        spider.setHelpingFriend(sparrow);
        sparrow.setHelpingFriend(roe);
        roe.setHelpingFriend(tiger);
        System.out.println("Three animals have obtained helping friends.");
        System.out.println("Now, if the obstacle is too heavy for one of them, a friend comes to help.\n");
        spider.removeObstacle(4);

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