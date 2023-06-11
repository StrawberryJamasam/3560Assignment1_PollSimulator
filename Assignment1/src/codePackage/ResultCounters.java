package codePackage;

public interface ResultCounters 
{
	/* Holds spaces for answer options and initializes them to 0*/
	public void options(int possibleAnswersCount);
	
	/* increments corresponding answer(s)*/
	public void AddUpdate(int[] answers);
	
	/* decrements old answer(s) when they are overwritten*/
	public void SubUpdate(int[] OldAnswers);
	
	/* Returns String with count of each answer*/
	public String toString();
	
}
