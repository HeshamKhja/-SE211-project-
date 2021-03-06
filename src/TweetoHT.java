/**
 * Created by abdll on 12/21/2017.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TweetoHT {
    private TweetoSLL[] HT; //An array holding the hash table
    private int sizeOfTheHashTable; //stores the current number of Tweeto objects

    public TweetoHT() {
        HT = new TweetoSLL[37];
        for (int i = 0; i < HT.length; i++) {
            HT[i] = new TweetoSLL();
        }
    }

    public TweetoSLL[] getHT() {
        return HT;
    }

    public void setHT(TweetoSLL[] HT) {
        this.HT = HT;
    }

    public int getSize() {
        return sizeOfTheHashTable;
    }

    public void setSize(int size) {
        this.sizeOfTheHashTable = size;
    }

    /**
     * Appropriate information to be returned
     */
    public String toString() {
        String HTText = "";
        for (TweetoSLL t : HT) {
            HTText = HTText + t.toString();
        }
        return HTText;
    }

    /**
     * this method is responsible of reading the content of the tweets file
     * then split the id and the text of the tweet and put them in the created array list
     */
    public void readSLL(String filename) {
        try {
            Scanner reader = new Scanner(new File(filename));
            while (reader.hasNext()) {
                String x = reader.next();
                String content = "";
                String id = reader.next();
                String temp = reader.next();
                while (true) {
                    if (temp.contains("@") || temp.contains("RT")) {
                        temp = reader.next();
                    } else {
                        break;
                    }
                }
                content = temp;
                String last = reader.nextLine();
                while (!last.contains("2016")) {
                    last = last + reader.nextLine();
                }
                content = content + last.substring(0, last.indexOf("Wed Dec") - 1);
                int pos = hash(id);
                insert(new Tweeto(id, content), pos);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Tweets file not found");
        }
    }


    /**
     * This hash method provided to hash the input value to the appropriate position in the hash table
     * The function is f(x) = x mod 37 for the letters and numbers, but we had a problem that there is a
     * conflict between numbers and letters, so we added one in case we have numbers f(x) = x mod 37+1.
     */
    public static int hash(String ID) {
        int PositionInTable;
        int FirstLetterOrNumber = ID.toLowerCase().charAt(1);
        if (FirstLetterOrNumber > 96)
            PositionInTable = FirstLetterOrNumber % 37;
        else
            PositionInTable = (FirstLetterOrNumber % 37) + 1;

        return PositionInTable;
    }

    /**
     * This method Insert, it inserts Tweeto T in appropriate position
     */
    public void insert(Tweeto T, int P) {
        this.sizeOfTheHashTable++;
        getHT()[P].insert(T);
    }

    /**
     * Searches for keyword K in a Tweet for any user U.
     * The user starts with @
     */
    public Tweeto search(String U, String K) {
        U = "@" + U;
        int p = hash(U);
        return getHT()[p].Search(U, K);
    }
}