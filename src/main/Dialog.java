package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialog extends JFrame {
	private static final long serialVersionUID = 1L;

	public String input(String message) {
		String value = JOptionPane.showInputDialog(this, message);
		if (value == null) {
			return "e";
		} else {
			return value;
		}
	}
	
	public void message(String content,String type) {
		int message_type;
		String s="特になし";
		switch(type) {
		case "error":
			s = "エラー";
			message_type = JOptionPane.ERROR_MESSAGE;
			break;
		case "info":
			s = "インフォメーション";
			message_type = JOptionPane.INFORMATION_MESSAGE;
			break;
		case "waring":
			s = "警告";
			message_type = JOptionPane.INFORMATION_MESSAGE;
			break;
		case "question":
			s = "質問";
			message_type = JOptionPane.WARNING_MESSAGE;
			break;
		case "none":
			s = "特になし";
			message_type = JOptionPane.PLAIN_MESSAGE;
			break;
		default:
			s = "エラー";
			message_type = JOptionPane.ERROR_MESSAGE;
			break;
		}
		JOptionPane.showMessageDialog(this, content, type, message_type);
	}
}
