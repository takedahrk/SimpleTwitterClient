package common;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import twitter4j.MediaEntity;
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
	static public Twitter getAuthInfo() {
		Twitter auth = new TwitterFactory().getInstance();
		return auth;
	}

	static public List<TweetModel> getTweet() {
		// 認証情報
		Twitter twitter = getAuthInfo();
		// ステータス格納
		List<Status> statuses = new ArrayList<>();
		// ツイート表示用リスト
		List<TweetModel> tweetModels = new ArrayList<>();

		try {
			statuses = twitter.getHomeTimeline();
			for (Status status : statuses) {
				// アイコンイメージの取得
				InputStream iconImageUrl = new URL(status.getUser().getBiggerProfileImageURL()).openStream();
				Image iconImage = new Image(iconImageUrl);

				// ツイート本文イメージの取得
				List<Image> images = new ArrayList<>();
				MediaEntity[] medias = status.getMediaEntities();
				for (MediaEntity media : medias) {
					// JPG形式のメディアのみ取得
					if (media.getMediaURL().endsWith(".jpg")) {
						InputStream imageUrl = new URL(media.getMediaURL()).openStream();
						images.add(new Image(imageUrl));
					}
				}

				TweetModel tweetModel = new TweetModel(iconImage, status.getUser().getName(), status.getText(), images);
				tweetModels.add(tweetModel);
			}
		} catch (TwitterException | IOException e) {
			e.printStackTrace();
		}

		return tweetModels;
	}
}
