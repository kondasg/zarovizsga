package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog : dogs) {
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog dog : dogs) {
            if (name.equals(dog.getName())) {
                return dog;
            }
        }
        throw new IllegalArgumentException(name);
    }

    public void playWith(String name, int hours) {
        Dog dog = findByName(name);
        dog.play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> resultDogs = new ArrayList<>();
        for (Dog dog : dogs) {
            if (minHappiness < dog.getHappiness()) {
                resultDogs.add(dog.getName());
            }
        }
        return resultDogs;
    }
}
