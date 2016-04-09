package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TweetController {
	@FXML
	private ListView<String> listView;

	@FXML
	public void initialize() {
		Utility utility = new Utility();
		ObservableList<String> listRecords = FXCollections.observableArrayList(utility.getTweet());
		listView.setItems(listRecords);
	}

}
