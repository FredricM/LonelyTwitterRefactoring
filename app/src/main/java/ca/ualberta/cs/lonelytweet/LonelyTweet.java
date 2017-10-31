package ca.ualberta.cs.lonelytweet;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Fredric on 2017-10-31.
 */

abstract class LonelyTweet implements Serializable {
    private static final long serialVersionUID = 1L;
    Date tweetDate; // can be package-private, made it package-private
    String tweetBody;  // can be package-private, made it package-private.

    private Date getTweetDate() {  //Could be a private function. Made it private.
        return tweetDate;
    }

    public void setTweetDate(Date tweetDate) {
        this.tweetDate = tweetDate;
    }

    protected abstract String getTweetBody(); // this method can be a protected method. Made it protected.

    public void setTweetBody(String tweetBody) {
        this.tweetBody = tweetBody;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.writeObject(tweetDate);
        out.writeObject(tweetBody);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        tweetDate = (Date) in.readObject();
        tweetBody = (String) in.readObject();
    }

    public abstract boolean isValid();

    @Override
    public String toString() {
        return getTweetDate() + " | " + getTweetBody() ;
    }
}
