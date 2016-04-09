package application;

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

	public void getTweet() {
		Twitter twitter = getAuthInfo();
		List<Status> statuses;
		try {
			statuses = twitter.getHomeTimeline();
			System.out.println("Showing home timeline.");
			for (Status status : statuses) {
				System.out.println(status.getUser().getName() + ":" + status.getText());
			}
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
