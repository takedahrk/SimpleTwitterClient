package common;

import javafx.scene.image.Image;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class TweetModel {
	private Image image;
	private String name;
	private String tweet;
}
