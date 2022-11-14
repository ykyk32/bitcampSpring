package sample04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//파일로 출력
public class FileOutputter implements Outputter {
	private String filePath, fileName;
	
	
	public void setFilePath(String filePath) {
		System.out.println("setFilePath(String filePath)");
		this.filePath = filePath;
	}


	public void setFileName(String fileName) {
		System.out.println("setFileName(String fileName)");
		this.fileName = fileName;
	}


	@Override
	public void output(String message) {
		System.out.println("output(String message)");
		
		try {
			FileWriter fileWriter = new FileWriter(new File(filePath, fileName));
			fileWriter.write(message);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Writer추상클래스라 new모새
	}

}
