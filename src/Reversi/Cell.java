package Reversi;

public class Cell {

    private Value value;

    public enum Value {Player1Val, Player2Val, Empty};

    /**
     * constructor
     * @param value - the value of the current cell.
     */
    public Cell (Value value) {
        this.value = value;
    }

    /**
     * getter
     * @return - the value of the cell.
     */
    public Value getValue() {
        return this.value;
    }

    /**
     * setter.
     * @param newValue - the value to set in cell.
     */
    public void setValue(Value newValue) {
        this.value = newValue;
    }



}
