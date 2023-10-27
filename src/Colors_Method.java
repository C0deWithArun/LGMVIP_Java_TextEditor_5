import java.awt.Color;

public class Colors_Method {

	TextEditor txt;
	
	public Colors_Method(TextEditor txt){
		this.txt = txt;
	}
	
	public void changeColor(String color) {
		switch (color) {
		case "White": 
			txt.frame.getContentPane().setBackground(Color.white);
			txt.textArea.setBackground(Color.white);
			txt.textArea.setForeground(Color.black);
			break;
		case "Red": 
			txt.frame.getContentPane().setBackground(Color.red);
			txt.textArea.setBackground(Color.red);
			txt.textArea.setForeground(Color.white);
			break;
		case "Black": 
			txt.frame.getContentPane().setBackground(Color.black);
			txt.textArea.setBackground(Color.black);
			txt.textArea.setForeground(Color.white);
			break;
		case "Blue": 
			txt.frame.getContentPane().setBackground(Color.blue);
			txt.textArea.setBackground(Color.blue);
			txt.textArea.setForeground(Color.white);
			break;
		}
	}
}






