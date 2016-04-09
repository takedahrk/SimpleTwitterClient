package common;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * 共通ユーティリティ
 * 
 * @author Haruki Takeda
 *
 */
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
				InputStream imageUrl = new URL(status.getUser().getBiggerProfileImageURL()).openStream();
				TweetModel tweetModel = new TweetModel(new Image(imageUrl), status.getUser().getName(),
						status.getText());
				list.add(tweetModel);
			}
		} catch (TwitterException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return list;
	}
}
