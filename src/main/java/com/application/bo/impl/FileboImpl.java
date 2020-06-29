package com.application.bo.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.application.bo.Filesbo;

public class FileboImpl implements Filesbo
{

	private String directory;

	public void setDirecotry(String dir)
	{
		this.directory = dir;
	}

	@Override
	public File createFile() throws Exception
	{
		Scanner s = new Scanner(System.in);
		String name;
		System.out.println("enter file name");
		name = s.nextLine();
		if(!name.isEmpty()) {
		String fname = directory + "\\" + name;
		File f = new File(fname);
		
		if(!f.exists())
		{
			f.createNewFile();
			System.out.println("Enter the contents in the file");
			FileWriter fw = new FileWriter(fname);
			fw.write(s.nextLine());
			fw.close();
			return f;

		}
		
		else {
		 
			System.out.println("File name already exists please enter other name");
		}
		}else {
			System.out.println("Invalid filename... Enter a valid filename...");
		}

		return null;
	}

	@Override
	public File getFilesByName(String fname) throws Exception
	{
		File file = new File(directory + "\\" + fname);

		if(fname.equals(file.getCanonicalFile().getName()) && file.exists())
		{

			return file;
		}
		

		return null;
	}

	@Override
	public void removeFile(String fname) throws Exception
	{

		File file = new File(directory + "\\" + fname);

		if(fname.equals(file.getCanonicalFile().getName()))
		{
			
			if(file.delete())
			{
				System.out.println("file deletion success");
				System.out.println("Deleted file: " + fname);
			}else {
				System.out.println("No such file Exists");
			}
			
		}else {
			System.out.println("No such file Exists");
		}

	}

	@Override
	public List<File> getAllFiles()
	{
		File filesInDirectory = new File(directory);
		List<File> allFiles = Arrays.asList(filesInDirectory.listFiles());
		if(filesInDirectory.list().length != 0)
		{
			Collections.sort(allFiles);
			return allFiles;
		}
		else 
		{
			return null;		
		}
	}
}