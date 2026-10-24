package lld.patterns.observer;

import org.jetbrains.annotations.NotNull;

public record FitnessData(int steps, int calories, int activeMinutes) {

    @NotNull
    @Override
    public String toString() {
        return "steps: " + steps + ", calories: " + calories + ", activeMinutes: " + activeMinutes;
    }
}
