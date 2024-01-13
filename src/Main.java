import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("FACTORY METHOD DEMO\n");
        final AnimalFactory animalFactory = new AnimalFactory();
        final Animal spider = animalFactory.createAnimal(AnimalSpecies.SPIDER, "Spider", 1);
        final Animal sparrow = animalFactory.createAnimal(AnimalSpecies.SPARROW, "Sparrow", 2);
        final Animal roe = animalFactory.createAnimal(AnimalSpecies.ROE, "Roe", 3);
        final Animal tiger = animalFactory.createAnimal(AnimalSpecies.TIGER, "Tiger", 4);
        List<Animal> animals = new ArrayList<>(Arrays.asList(spider, sparrow, roe, tiger));
        System.out.println("Four different animals have been created using a single factory method and added to a list.");
        System.out.println("Now a random animal will get a random state and act accordingly:\n");
        Animal animal = animals.get(random.nextInt(3));
        animal.setState(AnimalState.values()[random.nextInt(3)]);
        animal.processState();
    }
}