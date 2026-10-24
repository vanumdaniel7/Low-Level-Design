package lld.patterns.state;

public class DispensingState implements MachineState {

    @Override
    public void onItemSelect(VendingMachine vendingMachine, String itemCode) {
        System.out.println("Cannot select items while dispensing");
    }

    @Override
    public void onCoinInsert(VendingMachine vendingMachine, int coin) {
        System.out.println("Cannot insert coin while dispensing");
    }

    @Override
    public void onItemDispense(VendingMachine vendingMachine) {
        System.out.println("Dispensing the item already. Please wait");
    }
}
