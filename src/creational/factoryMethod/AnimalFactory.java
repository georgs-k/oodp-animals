package creational.factoryMethod;

import domain.Animal;
import domain.AnimalSpecies;
import domain.Roe;
import domain.Sparrow;
import domain.Spider;
import domain.Tiger;

public class AnimalFactory {

    public Animal createAnimal(final AnimalSpecies species, final String name, final int strength) {
        switch (species) {
            case SPIDER:
                return createSpider(species, name, strength);
            case SPARROW:
                return createSparrow(species, name, strength);
            case ROE:
                return createRoe(species, name, strength);
            case TIGER:
                return createTiger(species, name, strength);
        }
        throw new RuntimeException("Unknown animal");
    }

    private Animal createSpider(final AnimalSpecies species, final String name, final int strength) {
        return new Spider(species, name, strength);
    }

    private Animal createSparrow(final AnimalSpecies species, final String name, final int strength) {
        return new Sparrow(species, name, strength);
    }

    private Animal createRoe(final AnimalSpecies species, final String name, final int strength) {
        return new Roe(species, name, strength);
    }

    private Animal createTiger(final AnimalSpecies species, final String name, final int strength) {
        return new Tiger(species, name, strength);
    }
}
