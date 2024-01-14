import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        System.out.println("FACTORY METHOD DEMO\n");
        final AnimalFactory animalFactory = new AnimalFactory();
        final Animal spider = animalFactory.createAnimal(AnimalSpecies.SPIDER, "Archy", 1);
        final Animal sparrow = animalFactory.createAnimal(AnimalSpecies.SPARROW, "Chip", 2);
        final Animal roe = animalFactory.createAnimal(AnimalSpecies.ROE, "Lily", 3);
        final Animal tiger = animalFactory.createAnimal(AnimalSpecies.TIGER, "Fluffy", 4);
        List<Animal> animals = Arrays.asList(spider, sparrow, roe, tiger);
        System.out.println("Four different animals have been created using a single factory method and added to a list.");
        System.out.println("Now a random animal will get a random state and act accordingly:\n");
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
        System.out.println("Sparrow gets hungry and flies to the nearer, but smaller, grain storage - the nest.");
        System.out.println("The nest is a proxy, which redirects to the barn - a larger storage - if the grain has not been gathered yet.");
        System.out.println("So, first time - to the barn, next times - to the nest:");
        for (int i = 0; i < 3; i++) {
            System.out.println();
            anotherSparrow.setState(AnimalState.HUNGRY);
            anotherSparrow.act();
        }

    }
}