package Reversi;

public class Cell {

    private Value value;

    public enum Value {Player1Val, Player2Val, Empty};

    //static enum Value {Player1Val = "Player1Val", Player2Val = "Player2Val", Empty = " "};
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
