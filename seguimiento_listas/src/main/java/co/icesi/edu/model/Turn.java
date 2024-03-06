package co.icesi.edu.model;

public class Turn {

    private Turn next;
    private Turn before;
    private int value;

    private int skipTimes;

    public Turn(int value) {
        this.value = value;
    }

    public Turn getNext() {
        return next;
    }

    public void setNext(Turn next) {
        this.next = next;
    }

    public Turn getBefore() {
        return before;
    }

    public void setBefore(Turn before) {
        this.before = before;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public void skiptTurn(){
        skipTimes++;
    }
    public int getSkipTimes(){
        return skipTimes;
    }
}
