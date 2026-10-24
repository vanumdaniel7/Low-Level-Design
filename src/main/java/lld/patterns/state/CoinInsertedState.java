package lld.patterns.state;

public class CoinInsertedState implements MachineState {
    @Override
    public void onItemSelect(VendingMachine vendingMachine, String itemCode) {
        System.out.println("Item already selected");
    }

    @Override
    public void onCoinInsert(VendingMachine vendingMachine, int coin) {
        System.out.println("Coin already inserted");
    }

    @Override
    public void onItemDispense(VendingMachine vendingMachine) {
        System.out.println("Dispensing item...");
        vendingMachine.setState(new DispensingState());
    }
}
