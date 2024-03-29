package pk.lums.edu.sma.dos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TweetDO {

    public static final String INSERT_QUERY = "INSERT INTO TWEETDATA.TWEETDTA (jsonTweet, textTweet, dateTextTweet, locationTweet, tweetIDTweet) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_TEXT_QUERY = "SELECT textTweet FROM TWEETDATA.TWEETDTA";

    private long id = 0;
    private String jsonTweet = "";
    private String textTweet = "";
    private String dateTextTweet = "";
    private String locTweet = "";
    private long tweetIDTweet = 0;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getJsonTweet() {
	return jsonTweet;
    }

    public void setJsonTweet(String jsonTweet) {
	this.jsonTweet = jsonTweet;
    }

    public String getTextTweet() {
	return textTweet;
    }

    public void setTextTweet(String textTweet) {
	this.textTweet = textTweet;
    }

    public String getDateTextTweet() {
	return dateTextTweet;
    }

    public void setDateTextTweet(String dateTextTweet) {
	this.dateTextTweet = dateTextTweet;
    }

    public String getLocTweet() {
	return locTweet;
    }

    public void setLocTweet(String locTweet) {
	this.locTweet = locTweet;
    }

    public long getTweetIDTweet() {
	return tweetIDTweet;
    }

    public void setTweetIDTweet(long tweetIDTweet) {
	this.tweetIDTweet = tweetIDTweet;
    }

    public static ArrayList<TweetDO> translateTweet(ResultSet res) {
	ArrayList<TweetDO> tweetArr = new ArrayList<TweetDO>();
	if (res != null) {
	    try {
		while (res.next()) {
		    TweetDO tdo = new TweetDO();
		    tdo.setId(res.getLong("idTWEETDTA"));
		    tdo.setJsonTweet(res.getString("jsonTweet"));
		    tdo.setTextTweet(res.getString("textTweet"));
		    tdo.setDateTextTweet(res.getString("dateTextTweet"));
		    tdo.setLocTweet(res.getString("locationTweet"));
		    tdo.setTweetIDTweet(res.getLong("tweetIDTweet"));
		    tweetArr.add(tdo);
		}
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	return tweetArr;
    }

    public static String getTextOfColumn(ResultSet res, String colomnName) {
	String text = "";
	try {
	    text = res.getString(colomnName);
	} catch (SQLException e) {
	    System.out.println(e.getMessage());
	}
	return text;
    }

}
