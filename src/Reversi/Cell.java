package Reversi;

public class Cell {

    private Value value;

    public enum Value {X, O, Empty};

    //static enum Value {X = "X", O = "O", Empty = " "};
    public Cell (Value value) {
        this.value = value;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value newValue) {
        this.value = newValue;
    }


}
