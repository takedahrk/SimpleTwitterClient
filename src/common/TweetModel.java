package common;

import java.util.List;

import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * ツイート情報を格納するモデル
 * 
 * @author Haruki Takeda
 *
 */
@Value
@AllArgsConstructor
public class TweetModel {
	// アカウントアイコン画像
	private Image iconImage;
	// アカウント名
	private String name;
	// ツイート本文
	private String tweet;
	// ツイート本文画像
	private List<Image> tweetImages;
}
