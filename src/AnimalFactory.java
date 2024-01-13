public class AnimalFactory {

    public Animal createAnimal(final AnimalSpecies species, final String name, final int strength) {
        switch (species) {
            case SPIDER:
                return createSpider(name, strength);
            case SPARROW:
                return createSparrow(name, strength);
            case ROE:
                return createRoe(name, strength);
            case TIGER:
                return createTiger(name, strength);
        }
        throw new RuntimeException("Unknown animal");
    }

    private Animal createSpider(final String name, final int strength) {
        return new Spider(name, strength);
    }

    private Animal createSparrow(final String name, final int strength) {
        return new Sparrow(name, strength);
    }

    private Animal createRoe(final String name, final int strength) {
        return new Roe(name, strength);
    }

    private Animal createTiger(final String name, final int strength) {
        return new Tiger(name, strength);
    }
}
