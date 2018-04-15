/**
 * Created by abdll on 12/21/2017.
 */
public class Tweeto {
    private String ID; // stores the users twitter id starts with @ example @moh124
    private String tweet; //stores the tweet content
    private Tweeto next;//Links to the next Tweet from the file
    /*
    the main constructor of the tweet class
    */
    public Tweeto(String ID, String Tweet, Tweeto next) {
        this.ID = ID;
        this.tweet = Tweet;
        this.next = next;
    }


    public Tweeto(String ID, String Tweet) {
        this.ID = ID;
        this.tweet = Tweet;
    }
    // the default constructor
    public Tweeto(){}
    public String getID() {
        return ID;
    }

    //setter and getters
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getTweet() {
        return tweet;
    }
    public void setTweet(String Tweet) {
        this.tweet = Tweet;
    }
    public Tweeto getNext() {
        return next;
    }
    public void setNext(Tweeto next) {
        this.next = next;
    }

    // return the id and the content of the tweet
    @Override
    public String toString() {
        return "[" + getID() + "] [" + getTweet() + "]\n";
    }
}