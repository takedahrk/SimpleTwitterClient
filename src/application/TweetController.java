package application;

import common.TweetCell;
import common.TweetModel;
import common.Utility;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.util.Duration;

/**
 * ツイート表示画面のコントローラ
 * 
 * @author Haruki Takeda
 *
 */
public class TweetController {
	@FXML
	private ListView<TweetModel> listView;

	@FXML
	public void initialize() {
		this.listView.setCellFactory(param -> new TweetCell());
		this.getTimeLine();

		Timeline timer = new Timeline(new KeyFrame(Duration.millis(90000), event -> {
			this.getTimeLine();
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}

	private void getTimeLine() {
		ObservableList<TweetModel> listRecords = FXCollections.observableArrayList(Utility.getTweet());
		listView.setItems(listRecords);
	}
}
