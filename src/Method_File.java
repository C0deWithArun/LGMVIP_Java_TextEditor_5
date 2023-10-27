import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Method_File {
	TextEditor txt;
	String fileName;
	String fileAddress;
	public Method_File(TextEditor txt) {
		this.txt = txt;
	}
	
	public void newFile() {
		txt.textArea.setText("");
		txt.frame.setTitle("New Window");
// this value will getting null if We create new File 
		fileName = null;
		fileAddress = null;
	}
	
	public void open() {
		FileDialog fd = new FileDialog(txt.frame, "Open", FileDialog.LOAD);
		fd.setVisible(true);
		
		if(fd.getFile() != null) {
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			txt.frame.setTitle(fileName);
		}
// why the Requirement of FileAddress and FileName Print in Console
	/*	if(fileAddress + fileName) {
	 * Try catch block 
			if we can't use any of this name 
			it will Directly Goes to Catch Block and Shows Error.
		}
	*/
		System.out.println("File Address & File Name : - "+ fileAddress + fileName);
		try {
// we need Address to read a file 
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
			txt.textArea.setText("");
			String line = null;
			
			while((line = br.readLine()) != null ){
				txt.textArea.append(line + "\n");
			}
			br.close();
		}
		catch (Exception e) {
			System.out.println("File not Found");
		}
	}
	
	public void save() {
//  override SaveAs Method
		if(fileName == null) {
			
			saveAs();
			
		}
		else {
			
			try {
				FileWriter fw = new FileWriter(fileAddress + fileName);
				fw.write(txt.textArea.getText());
				txt.frame.setTitle(fileName);
				fw.close();	
			}
			
			catch (Exception e) {
				System.out.println("Something went wrong");
			}
		}
	}
	
	public void saveAs() {
		FileDialog fd = new FileDialog(txt.frame, "Save", FileDialog.SAVE);
		fd.setVisible(true);
		
		if(fd.getFile() != null) {
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();
			txt.frame.setTitle(fileName);
		}
		
		try {
			FileWriter fw = new FileWriter(fileAddress + fileName);
			fw.write(txt.textArea.getText());
			fw.close();
			
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
	}
	
	public void exit() {
		System.exit(0);
	}

}































