package codeChallenge;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Immutable Person class with Builder
 */
public final class ImmutablePerson {

    private final String name;
    private final int age;
    private final List<String> hobbies;

    private ImmutablePerson(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        // Defensive copy + unmodifiable wrapper
        this.hobbies = Collections.unmodifiableList(new ArrayList<>(builder.hobbies));
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    @Override
    public String toString() {
        return "Person{name='%s', age=%d, hobbies=%s}".formatted(name, age, hobbies);
    }

    public static class Builder {
        private String name;
        private int age;
        private List<String> hobbies = new ArrayList<>();

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder hobbies(List<String> hobbies) {
            this.hobbies = new ArrayList<>(hobbies); // defensive copy
            return this;
        }

        public ImmutablePerson build() {
            return new ImmutablePerson(this);
        }
    }
}
