/**
 * Created by abdll on 12/21/2017.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TweetoAHT {
    TweetoSLL[] HT;
    int size;
    public TweetoAHT() {
        HT = new TweetoSLL[1369];
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
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    @Override
    public String toString() {
        String HTText = "";
        for (TweetoSLL t : HT) {
            HTText = HTText + t.toString();
        }
        return HTText;
    }
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
                getHT()[pos].insert(new Tweeto(id, content));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Tweets file not found");
        }
    }
    public int hash(String ID) {
        int inidex, cht;
        int fndex = 0;
        if (ID.length() <= 2) {
            int ch = ID.toLowerCase().charAt(1);
// first index hash
            if (ch > 96) {
                inidex = ch % 37;
            } else {
                inidex = (ch % 37) + 1;
            }
            inidex = inidex * 37;
            fndex = inidex;
        } else {
            int ch = ID.toLowerCase().charAt(1);
// first index hash
            if (ch > 96) {
                inidex = ch % 37;
            } else {
                inidex = (ch % 37) + 1;
            }
            inidex = inidex * 37;
//second hash
            int ch2 = ID.toLowerCase().charAt(2);
            if (ch > 96) {
                cht = ch2 % 37;
            } else {
                cht = (ch2 % 37) + 1;
            }
            fndex = inidex + cht;
        }
        return fndex;
    }
    public void insert(Tweeto T, int P) {
        getHT()[P].insert(T);
    }
    public Tweeto search(String U, String K) {
        U = "@" + U;
        int p = hash(U);
        return getHT()[p].Search(U, K);
    }
}
