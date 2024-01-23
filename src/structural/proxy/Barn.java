package structural.proxy;

public class Barn implements GrainStorage {

    @Override
    public String getGrainSource() {
        return "barn";
    }
}
