package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {

    public Beagle(String name) {
        super(name);
    }

    @Override
    protected void feed() {
        happiness += 2;
    }

    @Override
    protected void play(int hours) {
        happiness = hours * 2;
    }
}
