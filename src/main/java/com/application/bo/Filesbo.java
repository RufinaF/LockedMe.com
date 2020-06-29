package com.application.bo;

import java.io.File;
import java.util.List;

public interface Filesbo {
	
	public File createFile() throws Exception;
	public File getFilesByName(String fname) throws Exception;
	public void removeFile(String fname)throws Exception; 
	public List<File> getAllFiles()throws Exception;

}
