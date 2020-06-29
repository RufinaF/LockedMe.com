package com.application.bo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import com.application.bo.impl.FileboImpl;

public class WelcomePage
{
	static String directory="E:\\testing";

	public static void main(String args[]) 
	{
		 File dir=new File(directory);
		
		Scanner scanner = new Scanner(System.in);
		FileboImpl imp = new FileboImpl();
		System.out.println("LOCKERS Pvt. Ltd");
		System.out.println("\nLocked.com Application");
		System.out.println("\nDear user, select any one of the option from the menu below");
		
		if(!dir.exists()) {
		    dir.mkdir();
		    }
		imp.setDirecotry(directory);
		int ch = 0;
		do
		{
			try
			{
			System.out.println("\nMenu");
			System.out.println("----------------");
			System.out.println("1)List all files");
			System.out.println("2)File operations");
			System.out.println("3)Exit Application");

			System.out.println("\nPlease enter the option number");
			ch = Integer.parseInt(scanner.nextLine());
			switch(ch)
			{

				case 1:
					List<File> allFilesSorted = imp.getAllFiles();
					if(allFilesSorted == null)
					{
						System.out.println("No files in the direcotry");
					}
					else
					{
						System.out.println("Listing files from the directory in sorted order");
						Iterator<File> fileIterator = allFilesSorted.iterator();
						while(fileIterator.hasNext())
						{
							System.out.println(fileIterator.next().getName());
						}
					}
					break;
				case 2:
					int ch1 = 0;
					do
					{
						try
						{
							System.out.println("\n\nFile operations Menu");
							System.out.println("--------------------");
							System.out.println("1)Create file");
							System.out.println("2)Delete file");
							System.out.println("3)Search file");
							System.out.println("4)Return to main option");

							System.out.println("\nPlease enter your choice");
							ch1 = Integer.parseInt(scanner.nextLine());

							switch(ch1)
							{
								case 1:
									if(imp.createFile() != null)
									{
										System.out.println("File creation successfull");
									}
									
									break;

								case 2:
									
									System.out.println("Enter file name to be deleted");
									String fileName = scanner.nextLine();
									
									imp.removeFile(fileName);
									
									
									break;
								case 3:
									System.out.println("Enter file name to search");
									String fileName1 = scanner.nextLine();
									if(!fileName1.isEmpty()) {
									File searchedFile = imp.getFilesByName(fileName1);
									if(searchedFile != null)
									{
										System.out.println("\nSearch Success \n");
										System.out.println("File name: " + searchedFile.getName());
										System.out.println("File contents:");
										try
										{
											FileReader fr = new FileReader(searchedFile.getAbsolutePath());

											int i;
											while((i = fr.read()) != -1)
											{
												System.out.print((char) i);
											}
										}
										catch(Exception e)
										{
											System.out.println("Unexpected error " + e);
										}
									}
									else
									{
										System.out.println("No such file exists");
									}
									}else {
										System.out.println("Invalid file name...Enter valid file name...");
									}

									break;
									
								case 4:
									System.out.println("Returing to main menu");
									break;
								default:
									System.out.println("Invalid option... Please enter a valid option from the menu...");
							}
						}
						catch(Exception e)
						{
							System.out.println("Invalid input...Please select any option...");
						}
					} while(ch1 != 4);
					break;
					
				case 3:
					System.out.println("Thank You!!!");
					System.exit(0);
					
				default:
					System.out.println("Invalid option... Please enter a valid option from the menu...");

			}
		}
		catch(Exception e)
		{
			System.out.println("Invalid input...Please select any option...");
		}

		} while(ch != 3);
		
		scanner.close();

	}
}
