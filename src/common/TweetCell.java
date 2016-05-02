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
	private VBox vbox;
	// アカウントアイコン画像
	private ImageView imageView;
	// ツイート本文画像
	private ImageView tweetImageView;
	// アカウント名
	private Text name;
	// ツイート本文
	private Text tweet;

	public TweetCell() {
		hbox = new HBox(2);
		imageView = new ImageView();
		imageView.setFitWidth(64);
		imageView.setFitHeight(64);

		vbox = new VBox(3);
		name = new Text();
		name.setFont(new Font("System Bold", 18));
		tweet = new Text();
		this.tweetImageView = new ImageView();

		VBox.setVgrow(name, Priority.NEVER);
		VBox.setVgrow(tweet, Priority.ALWAYS);
		if (this.tweetImageView != null) {
			VBox.setVgrow(tweetImageView, Priority.NEVER);
		}
		HBox.setHgrow(imageView, Priority.NEVER);
		HBox.setHgrow(vbox, Priority.ALWAYS);
		vbox.getChildren().addAll(name, tweet, tweetImageView);
		hbox.getChildren().addAll(imageView, vbox);
	}

	@Override
	protected void updateItem(TweetModel tweetModel, boolean empty) {
		super.updateItem(tweetModel, empty);

		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			imageView.setImage(tweetModel.getIconImage());
			name.setText(tweetModel.getName());
			tweet.setText(tweetModel.getTweet());
			if (!tweetModel.getTweetImages().isEmpty()) {
				tweetModel.getTweetImages().stream().forEach(image -> tweetImageView.setImage(image));
			} else {
				tweetImageView.setImage(null);
			}

			setGraphic(hbox);
		}
	}

}
