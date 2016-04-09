package common;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Utility {
	public Twitter getAuthInfo() {
		Twitter auth = new TwitterFactory().getInstance();
		return auth;
	}

	public ArrayList<TweetModel> getTweet() {
		Twitter twitter = getAuthInfo();
		List<Status> statuses;
		ArrayList<TweetModel> list = new ArrayList<>();
		try {
			statuses = twitter.getHomeTimeline();
			for (Status status : statuses) {
				System.out.println(status.getUser().getName() + ":" + status.getText());
				TweetModel tweetModel = new TweetModel(new Image(getClass().getResourceAsStream("sample.jpg")),
						status.getUser().getName(), status.getText());
				list.add(tweetModel);
			}
		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return list;
	}
}
