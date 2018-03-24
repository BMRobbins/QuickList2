package QuickList2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

public class FileWriter {
	private File outputFile;
	private PrintWriter out;
	
	public FileWriter() throws FileNotFoundException
	{
		JFileChooser chooser = new JFileChooser();
		if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			outputFile =chooser.getSelectedFile();
		}
		try{
			out = new PrintWriter(outputFile);
		}
		catch(IOException exception)
		{
			System.out.println("could not open file outputFile");
		}
	}
	
	public void write(String line)
	{
		out.printf("%s\r\n", line);
	}
	
	public void close()
	{
		out.close();
	}
}
