package ex03.loginService;

import ex03.commonService.CommonService;
import ex03.commonService.CommonServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginServiceImpl implements LoginService{

	@Override
	public void LoginProc(Parent root) {
		TextField t = (TextField)root.lookup("#fxId");
		PasswordField p = (PasswordField)root.lookup("#fxPwd");
		System.out.println("ID : "+t.getText());
		System.out.println("Password : "+p.getText());
	}

	@Override
	public void CancelProc(Parent root) {
		CommonService cs = new CommonServiceImpl();
		cs.setRoot(root);
		cs.WindowClose();
	}

	@Override
	public void OpenMembershipForm() {
		System.out.println("회원가입 완료");
		
	}

}
/*TextField t = (TextField)root.lookup("#fxId"); // FXML을 못쓸때 사용
System.out.println(t.getText());		*/		//// FXML을 못쓸때 사용