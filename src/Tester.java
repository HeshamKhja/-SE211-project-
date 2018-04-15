/**
 * Created by abdll on 12/21/2017.
 */
import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String filename = s.next();
        int dataStructureType = s.nextInt();
        String user = s.next();
        String key = s.next();
        double timeI = System.currentTimeMillis();
        switch (dataStructureType) {
            case 1:
                TweetoAL tAL = new TweetoAL();
                tAL.readTweetsFile(filename);
                tAL.search(user, key);
                System.out.println("Total Tweets: " + tAL.getNumberOfMatchedtweets());
                break;
            case 2:
                TweetoHT tHT = new TweetoHT();
                tHT.readSLL(filename);
                tHT.search(user, key);
                int pos = tHT.hash("@" + user);
                System.out.println("Total Tweets: " + tHT.getHT()[pos].getCount());
                break;
            case 3:
                TweetoBHHT tBHHT;
                if (filename.equals("1million.txt")) {
                    tBHHT = new TweetoBHHT(1000000);
                } else {
                    tBHHT = new TweetoBHHT(Integer.parseInt(filename.substring(0, filename.indexOf("."))));
                }
                tBHHT.readBHHT(filename);
                tBHHT.search(user, key);
                System.out.println("Total Tweets: " + tBHHT.getCount());
                break;
            case 4:
                TweetoAHT tAHT = new TweetoAHT();
                tAHT.readSLL(filename);
                tAHT.search(user, key);
                int pos1 = tAHT.hash("@" + user);
                System.out.println("Total Tweets: " + tAHT.getHT()[pos1].getCount());
                break;
        }
        double time = System.currentTimeMillis() - timeI;
        System.out.println("Total Time: " + time/1000.0 + " seconds");


}


}