package common;

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
	private Image image;
	private String name;
	private String tweet;
}
