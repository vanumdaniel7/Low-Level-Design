package lld.patterns.state;

public class VendingMachine {
    private MachineState machineState;

    public VendingMachine() {
        machineState = new IdleState();
    }

    public void setState(MachineState machineState) {
        this.machineState = machineState;
    }

    public void onItemSelect(String itemCode) {
        machineState.onItemSelect(this, itemCode);
    }

    public void onCoinInserted(int coin) {
        machineState.onCoinInsert(this, coin);
    }

    public void onItemDispense() {
        machineState.onItemDispense(this);
        machineState = new IdleState();
    }
}
