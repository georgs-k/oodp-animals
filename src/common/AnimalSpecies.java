package common;

public enum AnimalSpecies {

    SPIDER, SPARROW, ROE, TIGER;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
