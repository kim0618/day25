package ex03.commonService;

import ex03.Controller;
import ex03.MainClass;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CommonServiceImpl implements CommonService {
	Parent root;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}

	@Override
	public void WindowClose()  {
		
		Stage primaryStage = (Stage)root.getScene().getWindow();
		primaryStage.close();		
	}
	
}
