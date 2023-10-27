import java.awt.Font;

public class Format_Method {

	TextEditor txt;
	Font  arial, comicSansMS, timesNewRoman;
	String selectedFont;
	
	public Format_Method(TextEditor txt) {
		this.txt = txt;
	}
	
	public void wordWrap() {
		
		if(txt.wordWrapOn == false) {
			txt.wordWrapOn = true;
			txt.textArea.setLineWrap(true);
			txt.textArea.setWrapStyleWord(true);
			txt.Iwrap.setText("Word Wrap: ON");
			
		}
		else if(txt.wordWrapOn==true) {
			txt.wordWrapOn = false;
			txt.textArea.setLineWrap(false);
			txt.textArea.setWrapStyleWord(false);
			txt.Iwrap.setText("Word Wrap: OFF");
			
		}
	}
	
	public void createFont(int fontSize) {
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
		
		setFont(selectedFont);
	}
	
	public void setFont(String font) {
		selectedFont = font;
		
		switch(selectedFont) {
			case "Arial":
				txt.textArea.setFont(arial);
				break;
			case "Comic Sans MS":
				txt.textArea.setFont(comicSansMS);
				break;
			case "Times New Roman":
				txt.textArea.setFont(timesNewRoman);
				break;
		}
	}
}




















