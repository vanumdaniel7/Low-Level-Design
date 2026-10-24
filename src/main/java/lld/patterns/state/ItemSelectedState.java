package lld.patterns.state;

public class ItemSelectedState implements MachineState {
    @Override
    public void onItemSelect(VendingMachine vendingMachine, String itemCode) {
        System.out.println("Item already selected");
    }

    @Override
    public void onCoinInsert(VendingMachine vendingMachine, int coin) {
        System.out.println("Coin: " + coin + " is inserted");
        vendingMachine.setState(new CoinInsertedState());
    }

    @Override
    public void onItemDispense(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense items without adding a coin");
    }
}
