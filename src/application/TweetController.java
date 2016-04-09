package application;

import common.TweetCell;
import common.TweetModel;
import common.Utility;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TweetController {
	@FXML
	private ListView<TweetModel> listView;

	@FXML
	public void initialize() {
		listView.setCellFactory(param -> new TweetCell());
		Utility utility = new Utility();
		ObservableList<TweetModel> listRecords = FXCollections.observableArrayList(utility.getTweet());
		listView.setItems(listRecords);
	}

}
