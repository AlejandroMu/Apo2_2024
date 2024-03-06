package co.icesi.edu.model;

public class TurnController {

    private Turn head;

    private Turn currentTurn;

    public int showCurrentTurn(){
        if(head == null){
            return 0;
        }
        if(currentTurn == null){
            currentTurn = head;
        }
        return currentTurn.getValue();
    }

    public int giveTurn(){
        if(head == null){
            head = new Turn(1);
            return 1;
        }else if(head.getBefore() ==null){
            Turn n = new Turn(head.getValue()+1);
            head.setNext(n);
            head.setBefore(n);
            n.setNext(head);
            n.setBefore(head);
            return n.getValue();
        }else{
            Turn n = new Turn(head.getBefore().getValue()+1);
            Turn last = head.getBefore();
            last.setNext(n);
            head.setBefore(n);
            n.setBefore(last);
            n.setNext(head);
            return n.getValue();
        }
    }

    public void skipTurn(){
        currentTurn.skiptTurn();
        if(currentTurn.getSkipTimes()<3){
            currentTurn = currentTurn.getNext();
        }else{
            deleteAndContinue();
        }

    }

    public void deleteAndContinue(){
        Turn b = currentTurn.getBefore();
        Turn n =currentTurn.getNext();
        b.setNext(n);
        n.setBefore(b);
        if(currentTurn.getValue() == head.getValue()){
            head = n;
        }
        currentTurn = n;

    }

    public String printTurnList(){
        String ret ="";
        Turn current = head;
        while (current.getValue() != head.getBefore().getValue()){
            ret += current.getValue()+" ";
            current = current.getNext();
        }
        ret += current.getValue();
        return ret;
    }
}
