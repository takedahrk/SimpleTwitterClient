package common;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * ツイート表示用カスタマイズセル
 * 
 * @author Haruki Takeda
 *
 */
public class TweetCell extends ListCell<TweetModel> {
	private HBox hbox;
	private ImageView imageView;
	private VBox vbox;
	private Text name;
	private Text tweet;

	public TweetCell() {
		hbox = new HBox(5);
		imageView = new ImageView();
		imageView.setFitWidth(64);
		imageView.setFitHeight(64);

		vbox = new VBox(5);
		name = new Text();
		name.setFont(new Font("System Bold", 18));
		tweet = new Text();
		VBox.setVgrow(name, Priority.NEVER);
		VBox.setVgrow(tweet, Priority.ALWAYS);
		HBox.setHgrow(imageView, Priority.NEVER);
		HBox.setHgrow(vbox, Priority.ALWAYS);
		vbox.getChildren().addAll(name, tweet);
		hbox.getChildren().addAll(imageView, vbox);
	}

	@Override
	protected void updateItem(TweetModel tweetModel, boolean empty) {
		super.updateItem(tweetModel, empty);

		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			imageView.setImage(tweetModel.getImage());
			name.setText(tweetModel.getName());
			tweet.setText(tweetModel.getTweet());
			setGraphic(hbox);
		}
	}

}
