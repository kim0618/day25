package ex03.commonService.membership;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;

public class MemberController implements Initializable{

	static Parent root;
	MembershipService ms;
	public void setRoot(Parent root) {
		this.root = root;
		ms.setRoot(root);
	}

	public void membershipProc() {
		ms.membershipProc();
	}
	
	
	public void memberCancle() {
		ms.memberCancle();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MembershipServiceImpl();
	}

}
