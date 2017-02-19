package spamfilter;
import java.io.*;

public class Bayesian 
{
	public static void main (String args[]) 
	{
		try 
		{		
			Spamfilter filter = new Spamfilter();	
			filter.trainSpam("D:\\spam.txt");
			filter.trainGood("D:\\good.txt");
			filter.finalizeTraining();
			for (int i = 1; i < 5; i++) 
			{	
				FileReader fr = new FileReader("D:\\mail" + i + ".txt");
				String stuff = fr.getContent();	
				boolean spam = filter.analyze(stuff);
				if (spam) System.out.println("It is a spam mail!");
				else System.out.println("It is not a spam mail!");
			}
                        System.out.println("The Spam probablities for the all the words:");
                        filter.displayStats();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}