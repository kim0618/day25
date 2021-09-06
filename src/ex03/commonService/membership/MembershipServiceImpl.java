package ex03.commonService.membership;

import ex03.MemberDTO;
import ex03.commonService.CommonService;
import ex03.commonService.CommonServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MembershipServiceImpl implements MembershipService {
	Parent root;
	
	public void addComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		if(cmbAge != null) {
			cmbAge.getItems().addAll("20대 미만", "20대", "30대","40대 이상");
		}
	}
	public void memberCancle() {
		CommonService cs = new CommonServiceImpl();
		cs.setRoot(root);
		cs.WindowClose();
	}
	
	public void check() {
		TextField tx = (TextField)root.lookup("#fxName");
		TextField pf = (TextField)root.lookup("#fxPw");
		
		if(tx.getText().isEmpty()) {
			alertMethod("이름은 필수 항목입니다");
			tx.requestFocus();
		}
		else if(pf.getText().isEmpty()) {
			alertMethod("비밀번호 필수 항목입니다");
		}else if(getId().isEmpty()) {
			alertMethod("아이디를 입력하세요");
		}
	}
	
	public void alertMethod(String msg) {
		Alert alert =new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
	public String getComboBox() {
		ComboBox<String> cmbAge = (ComboBox<String>)root.lookup("#cmbAge");
		String age = null;
		if(cmbAge.getValue() == null) {
			System.out.println("콤보박스를 선택해 주세요");
		}else {
			age = cmbAge.getValue().toString();
		}
		return age;
	}
	public boolean getGender() {
		RadioButton rdoMan = (RadioButton)root.lookup("#rdoMan");
		if( rdoMan.isSelected() ) return true;
		else return false;
	}
	
	private String getId() {
		TextField tx = (TextField)root.lookup("#fxId");
		return tx.getText();
	}
	
	private String getPwd() {
		TextField pw = (TextField)root.lookup("#fxPw");
		return pw.getText();
	}
	
	public int getHobby() {
		int hobby = 0;
		CheckBox music = (CheckBox)root.lookup("#chkMusic");
		CheckBox sport = (CheckBox)root.lookup("#chkSport");
		CheckBox movie = (CheckBox)root.lookup("#chkMovie");
		if(music.isSelected()) { hobby+=1; }
		if(sport.isSelected()) { hobby+=2; }
		if(movie.isSelected()) { hobby+=4; }
		return hobby;
	}
	
	public void membershipProc() {
		MemberDTO dto = new MemberDTO();
		check();
		dto.setName( ((TextField)root.lookup("#fxName")).getText());
		System.out.println("name : "+dto.getName());
		dto.setId(getId());
		System.out.println("id : "+dto.getId());
		dto.setAge( getComboBox() );
		dto.setPw(getPwd());
		System.out.println("pw : "+ dto.getPw());
		System.out.println("pwOk : "+ dto.getPw());
		System.out.println("age : " +dto.getAge());
		dto.setGender( getGender() );
		System.out.println("gendr : "+ dto.isGender());
		dto.setHobby(getHobby());
		String sw;
		switch(dto.getHobby()) {
		case 0:
			sw="";
			break;
		case 1:
			sw = "Music"; break;
		case 2:
			sw = "Sport"; break;
		case 3:
			sw = "Music, Sport"; break;
		case 4:
			sw = "Movie"; break;
		case 5:
			sw = "Music, Movie"; break;
		case 6:
			sw = "Sport, Movie"; break;
		case 7:
			sw = "Music, Sport, Movie"; break;
			default: sw="";
		}
		System.out.println("취미 : "+ sw);
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
		addComboBox();
	}
}
