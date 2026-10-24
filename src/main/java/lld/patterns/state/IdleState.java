package lld.patterns.state;

public class IdleState implements MachineState {
    @Override
    public void onItemSelect(VendingMachine vendingMachine, String itemCode) {
        System.out.println("ItemCode: " + itemCode + " is selected...");
        vendingMachine.setState(new ItemSelectedState());
    }

    @Override
    public void onCoinInsert(VendingMachine vendingMachine, int coin) {
        System.out.println("Select item before inserting coin");
    }

    @Override
    public void onItemDispense(VendingMachine vendingMachine) {
        System.out.println("Select item before dispensing");
    }
}
