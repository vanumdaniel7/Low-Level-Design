package lld.patterns.state;

public interface MachineState {
    void onItemSelect(VendingMachine vendingMachine, String itemCode);
    void onCoinInsert(VendingMachine vendingMachine, int coin);
    void onItemDispense(VendingMachine vendingMachine);
}
