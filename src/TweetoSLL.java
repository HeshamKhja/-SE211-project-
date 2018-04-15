/**
 * Created by abdll on 12/21/2017.
 */
public class TweetoSLL {
    public Tweeto head;
    public int size;
    private int count;
    public TweetoSLL() {}
    public Tweeto getHead() {
        return head;
    }
    public void setHead(Tweeto head) {
        this.head = head;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public Tweeto Search(String U, String K) {
        Tweeto temp = head;
        while (temp != null) {
            if (temp.getTweet().toLowerCase().contains(K.toLowerCase()) && temp.getID().toLowerCase().startsWith(U.toLowerCase()))
                count++;
            temp = temp.getNext();
        }
        return temp;
    }
    public void insert(Tweeto t) {
        if (head == null) {
            head = t;
            t.setNext(null);
            size++;
            return;
        }
//add the new node N to the head of the list
        t.setNext(head);
        head = t;
        size++;
        return;
    }
    @Override
    public String toString() {
        String out = "";
        Tweeto temp = head;
        while (temp != null) {
            out = out + temp;
            temp = temp.getNext();
        }
        if (head != null)
            out += "\n";
        return out;
    }
}