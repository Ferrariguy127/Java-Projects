public class Player {
    private String name;
    private Player next;
    private Player previous;

    public Player getPrevious() {
        return previous;
    }
    public void setPrevious(Player previous){
        this.previous = previous;
    }

    public Player(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getNext() {
        return next;
    }

    public void setNext(Player next) {
        this.next = next;
    }
}
