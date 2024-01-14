public class Nest implements GrainStorage {

    private boolean haveBeenToBarn = false;

    private final GrainStorage barn;

    public Nest(GrainStorage barn) {
        this.barn = barn;
    }

    @Override
    public String getGrainSource() {
        if (haveBeenToBarn) {
            return "nest";
        }
        haveBeenToBarn = true;
        return barn.getGrainSource();
    }
}
