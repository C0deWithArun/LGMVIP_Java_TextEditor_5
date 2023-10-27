
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditor implements ActionListener{
	TextEditor txt;
    JFrame frame; //window
	JTextArea textArea;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	
	boolean wordWrapOn = false;
Method_File file = new Method_File(this);
	JMenu menuFile, menuEdit, menuFormat, menuColors;
	JMenuItem Inew, Iopen, Isave, IsaveAs, Iexit;
	
// -----------------------------------------------------
Format_Method format = new Format_Method(this);
	JMenuItem Iwrap, IfontArial, IfontCSMS, IFontTNR, IfontSize8, IfontSize12, IfontSize14, IfontSize16, IfontSize18, IfontSize20;
	JMenu menuFont, menuFontSize;;

// -----------------------------------------------------
Colors_Method color = new Colors_Method(this);
	JMenuItem Icolor1, Icolor2, Icolor3, Icolor4;
	
// -----------------------------------------------------	
Edit_Method edit = new Edit_Method(this);
	JMenuItem Iundo, Iredo;
	
// Main method 
	public static void main(String[] args) {
		 new TextEditor();
		
	}
	
// Default Constructor of TextEditor class 
	public TextEditor() {
		
		createFrame();
		createTextArea();
		createScrollBar();
		createMenuBar();
		createNewFile();
		
		createFormatMenu();
		format.selectedFont = "Arial";
		format.createFont(18);
		format.wordWrap();
		
		createColorMenu();
		color.changeColor("white");
		
		createEdit();
		
	frame.setVisible(true);
	}

//------------------------------------------------
	public void createFrame(){
		
		frame = new JFrame("Notepad");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
	}
	
// -----------------------------------------------
	public void createTextArea(){
		textArea = new JTextArea();
		frame.add(textArea);
		
	}

// ------------------------------------------------
	public void createScrollBar(){
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		frame.add(scrollPane);
	}
	
//-------------------------------------------------
	public void createMenuBar() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
			menuFile = new JMenu("File");
			menuBar.add(menuFile);
			
			menuEdit = new JMenu("Edit");
			menuBar.add(menuEdit);
			
			menuFormat = new JMenu("Format");
			menuBar.add(menuFormat);
			
			menuColors = new JMenu("Color");
			menuBar.add(menuColors);
	}
	
// --------------------------------------------
	public void createNewFile() {
		Inew = new JMenuItem("New");
		Inew.addActionListener(this);
		Inew.setActionCommand("New");
		menuFile.add(Inew);
		
		Iopen = new JMenuItem("Open");
		Iopen.addActionListener(this);
		Iopen.setActionCommand("Open");
		menuFile.add(Iopen);
		
		Isave = new JMenuItem("Save");
		Isave.addActionListener(this);
		Isave.setActionCommand("Save");
		menuFile.add(Isave);
		
		IsaveAs = new JMenuItem("Save As");
		IsaveAs.addActionListener(this);
		IsaveAs.setActionCommand("SaveAs");
		menuFile.add(IsaveAs);
		
		Iexit = new JMenuItem("Exit");
		Iexit.addActionListener(this);
		Iexit.setActionCommand("Exit");
		menuFile.add(Iexit);
		
	}
	
// ---------------------------------------------------	
		public void createEdit() {
			
			Iundo =  new JMenuItem("Undo");
			Iundo.addActionListener(this);
			Iundo.setActionCommand("Undo");
			menuEdit.add(Iundo);
			
			Iredo =  new JMenuItem("Redo");
			Iredo.addActionListener(this);
			Iredo.setActionCommand("Redo");
			menuEdit.add(Iredo);
		}
		
// --------------------------------------------
	public void createFormatMenu() {
		Iwrap = new JMenuItem("Word Wrap: OFF");
		Iwrap.addActionListener(this);
		Iwrap.setActionCommand("Word Wrap");
		menuFormat.add(Iwrap);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		IfontArial = new JMenuItem("Arial");
		IfontArial.addActionListener(this);
		IfontArial.setActionCommand("Arial");
		menuFont.add(IfontArial);
		
		IfontCSMS = new JMenuItem("Comic Sans MS");
		IfontCSMS.addActionListener(this);
		IfontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(IfontCSMS);
		
		IFontTNR = new JMenuItem("Times New Roman");
		IFontTNR.addActionListener(this);
		IFontTNR.setActionCommand("Times New Roman");
		menuFont.add(IFontTNR);
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		IfontSize8 = new JMenuItem("8");
		IfontSize8.addActionListener(this);
		IfontSize8.setActionCommand("size8");
		menuFontSize.add(IfontSize8);
		
		IfontSize12 = new JMenuItem("12");
		IfontSize12.addActionListener(this);
		IfontSize12.setActionCommand("size12");
		menuFontSize.add(IfontSize12);
		
		IfontSize14 = new JMenuItem("14");
		IfontSize14.addActionListener(this);
		IfontSize14.setActionCommand("size14");
		menuFontSize.add(IfontSize14);
		
		IfontSize16 = new JMenuItem("16");
		IfontSize16.addActionListener(this);
		IfontSize16.setActionCommand("size16");
		menuFontSize.add(IfontSize16);
		
		IfontSize18 = new JMenuItem("18");
		IfontSize18.addActionListener(this);
		IfontSize18.setActionCommand("size18");
		menuFontSize.add(IfontSize18);
		
		IfontSize20 = new JMenuItem("20");
		IfontSize20.addActionListener(this);
		IfontSize20.setActionCommand("size20");
		menuFontSize.add(IfontSize20);
		
	}
	
// ---------------------------------------------
	public void createColorMenu() {
		Icolor1 = new JMenuItem("White");
		Icolor1.addActionListener(this);
		Icolor1.setActionCommand("White");
		menuColors.add(Icolor1);
		
		Icolor2 = new JMenuItem("Red");
		Icolor2.addActionListener(this);
		Icolor2.setActionCommand("Red");
		menuColors.add(Icolor2);
		
		Icolor3 = new JMenuItem("Black");
		Icolor3.addActionListener(this);
		Icolor3.setActionCommand("Black");
		menuColors.add(Icolor3);
		
		Icolor4 = new JMenuItem("Blue");
		Icolor4.addActionListener(this);
		Icolor4.setActionCommand("Blue");
		menuColors.add(Icolor4);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch(command) {
// Method_File file = new Method_File(this);
			case "New":
				file.newFile();
				break;
			
			case "Open":
				file.open();
				break;
				
			case "Save":
				file.save();
				break;
					
			case "SaveAs":
				file.saveAs();
				break;
				
			case "Exit":
				file.exit();
				break;
				
// Format_Method format = new Format_Method(this);
			case "Word Wrap":
				format.wordWrap();
				break;
			
			case "Arial":
				format.setFont(command);
				break;
			case "Comic Sans MS":
				format.setFont(command);
				break;
			case "Times New Roman":
				format.setFont(command);
				break;
					
			case "size8":
				format.createFont(8);
				break;
			case "size12":
				format.createFont(12);
				break;
			case "size14":
				format.createFont(14);
				break;
			case "size16":
				format.createFont(16);
				break;
			case "size18":
				format.createFont(18);
				break;
			case "size20":
				format.createFont(20);
				break;

// Colors_Method color = new Colors_Method(this);
			case "White":
				color.changeColor(command);
				break;
			case "Red":
				color.changeColor(command);
				break;
			case "Black":
				color.changeColor(command);
				break;
			case "Blue":
				color.changeColor(command);
				break;

// Edit_Method edit = new Edit_Method(this);
				
			
				
		}
	}
}







