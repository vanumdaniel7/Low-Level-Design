package lld.patterns.observer;

public class LiveProgressUpdater implements Observer<FitnessData> {

    @Override
    public void onValueUpdated(FitnessData fitnessData) {
        System.out.println("LiveProgressUpdater: " + fitnessData.toString());
    }
}
