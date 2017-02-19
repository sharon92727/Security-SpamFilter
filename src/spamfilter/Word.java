package spamfilter;
public class Word 
{
	private String word;    
	private int countBad;    
	private int countGood;  
	private float rBad;     
	private float rGood;    
	private float pSpam;    
	
	public Word(String s) 
	{
		word = s;
		countBad = 0;
		countGood = 0;
		rBad = 0.0f;
		rGood = 0.0f;
		pSpam = 0.0f;
	}

	public void countBad() 
	{
		countBad++;
	}
	
	public void countGood() 
	{
		countGood++;
	}
	
	public void calcBadProb(int total) 
	{
		if (total > 0) rBad = countBad / (float) total;
	}
	
	public void calcGoodProb(int total) 
	{
		if (total > 0) rGood = 2*countGood / (float) total; 
	}

	// Implementing bayes rules 
	public void finalizeProb() 
	{
		if (rGood + rBad > 0) 
                    pSpam = rBad / (rBad + rGood);
		if (pSpam < 0.01f) 
                    pSpam = 0.01f;
		else if (pSpam > 0.99f) 
                    pSpam = 0.99f;
	}
	
	public float interesting() 
	{
		return Math.abs(0.5f - pSpam);
	}
		
	public float getPGood() {
		return rGood;
	}

	public float getPBad() {
		return rBad;
	}
	
	public float getPSpam() {
		return pSpam;
	}

	public void setPSpam(float f) {
		pSpam = f;
	}

	public String getWord() {
		return word;
	}
	
}