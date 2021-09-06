package ex03;

import java.net.URL;
import java.util.ResourceBundle;

import ex03.commonService.CommonServiceImpl;
import ex03.commonService.membership.MemberProc;
import ex03.loginService.LoginService;
import ex03.loginService.LoginServiceImpl;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller implements Initializable{
	Parent root;
	LoginService ls;
	MemberProc mp;
	public void setRoot(Parent root) {
		this.root = root;
	}
	public void LoginProc() {
		ls.LoginProc(root);
	}
	public void CancelProc() {
		ls.CancelProc(root);
	}
	public void MemberShipProc() {
		mp.memberShip();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginServiceImpl();
		mp = new MemberProc();
	}
}
