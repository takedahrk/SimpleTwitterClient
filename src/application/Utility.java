package application;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Utility {
	public Twitter getAuthInfo() {
		Twitter auth = new TwitterFactory().getInstance();
		return auth;
	}

	public ArrayList<String> getTweet() {
		Twitter twitter = getAuthInfo();
		List<Status> statuses;
		ArrayList<String> list = new ArrayList<>();
		try {
			statuses = twitter.getHomeTimeline();
			for (Status status : statuses) {
				System.out.println(status.getUser().getName() + ":" + status.getText());
				list.add(status.getText());
			}
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return list;
	}
}
