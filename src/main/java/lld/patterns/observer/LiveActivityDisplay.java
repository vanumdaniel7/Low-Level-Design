package lld.patterns.observer;

public class LiveActivityDisplay implements Observer<FitnessData> {

    @Override
    public void onValueUpdated(FitnessData fitnessData) {
        System.out.println("LiveActivityDisplay: " + fitnessData.toString());
    }
}
