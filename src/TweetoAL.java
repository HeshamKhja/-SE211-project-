import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by abdll on 12/21/2017.
 */
public class TweetoAL {
    ArrayList<Tweeto> TweetsArrayList;// the tweets from the read file will be  stored in this array list
    private int numberOfMatchedtweets;//the number of matched tweets that have the same tweet id and the same tweet text (substring)

    /*
       the default constructor of the class
    */
    public TweetoAL() {
        TweetsArrayList = new ArrayList<>();
    }
    //setters and getters
    public ArrayList<Tweeto> getTweetsArrayList() {
        return TweetsArrayList;
    }
    public void setTweetsArrayList(ArrayList<Tweeto> tweetsArrayList) {
        this.TweetsArrayList = tweetsArrayList;
    }


    public int getNumberOfMatchedtweets() {
        return numberOfMatchedtweets;
    }
    public void setNumberOfMatchedtweets(int numberOfMatchedtweets) {
        this.numberOfMatchedtweets = numberOfMatchedtweets;
    }

    /*
    this method is responsible of  reading the content of the tweets file
    then split the id and the text of the tweet and put them in the created array list
    */
    public void readTweetsFile(String filename) {
        try {
            Scanner fileReader = new Scanner(new File(filename));
            while (fileReader.hasNext()) {
                fileReader.next();
                String content = "";
                String id = fileReader.next();
                String temp = fileReader.next();
                while (true) {
                    if (temp.contains("@") || temp.contains("RT")) {
                        temp = fileReader.next();
                    } else {
                        break;
                    }
                }
                content = temp;
                String last = fileReader.nextLine();
                while (!last.contains("2016")) {
                    last = last + fileReader.nextLine();
                }
                content = content + last.substring(0, last.indexOf("Wed Dec") - 1);
                getTweetsArrayList().add(new Tweeto(id, content));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Tweets file not found");
        }
    }

    /* this method is responsible to search and give the number of the the matched tweets
      */
    public Tweeto search(String U, String K) {
        U = "@" + U;
        Iterator<Tweeto> ALI = getTweetsArrayList().iterator();
        while (ALI.hasNext()) {
            Tweeto t = ALI.next();
            if (t.getTweet().toLowerCase().contains(K.toLowerCase()) && t.getID().toLowerCase().startsWith(U.toLowerCase()))
                numberOfMatchedtweets++;
        }
        return null;
    }
}
