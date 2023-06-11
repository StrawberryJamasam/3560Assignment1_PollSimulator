package codePackage;

import java.util.LinkedList;

public class VotingService extends Question implements ResultCounters, Student 
{
	private int studentID;
	private boolean hasVoted;
	private boolean isConfigured;
	private static boolean resetVals;
	
	private static Question thisQ;
	private int[] changed = new int[10];
	private LinkedList<String> answers = new LinkedList<>();
	private static LinkedList<Integer> results = new LinkedList<>();
	
	/* Constructors for configuring questions*/
	public VotingService()
	{
		isConfigured = false;
	}
	
	/* Constructor for individual student objects*/
	public VotingService(int ID)
	{
		studentID = ID;
		hasVoted = false;
	}
	
	public void configureQ(Question toBeAsked)
	{
		if(toBeAsked.isConfigured())
		{
			thisQ = toBeAsked;
			options(thisQ.getAnswers().size());
		}			
		else
			throw new IllegalArgumentException("Question not Configured");
		
		isConfigured = true;
	}
	
	public void printQandA()
	{	
		if(isConfigured)
		{
			if(thisQ.getType() == 1)
				System.out.println("Multiple choice");
			else
				System.out.println("Single Choice");
		
			System.out.println();
			System.out.println(thisQ.getQuestionContents());
			System.out.println(thisQ.getAnswers().toString());
		}
		else
			System.out.println("Question not Configured");
	}
	
	public void setAnswers(LinkedList<String> enteredAnswers)
	{
		if(hasVoted)	
		{
			System.out.println("Student has already voted. Previous entries will be overwritten");
			SubUpdate(changed);
			
			for(int i = 0; i < changed.length; i++)
			{
				changed[i] = 0;
			}
			
			for(int i = 0; i < changed.length; i++)
			{
				System.out.print(changed[i]);
				System.out.println();
			}
		}
			
		thisQ.getAnswers().sort(null);	// sorts lists for ease of comparisons
		enteredAnswers.sort(null);
		
		//inputCheck(enteredAnswers);
		
		for(int i = 0; i < thisQ.getAnswers().size(); i++)			// saves answers and records statistics
		{
			for(int j = 0; j < enteredAnswers.size(); j++)
			{
				if(thisQ.getAnswers().get(i).equals(enteredAnswers.get(j)))
				{
					changed[i]++;
				}		
			}
		}
		
		AddUpdate(changed);	
		answers = enteredAnswers;
		hasVoted = true;
	}
	
	public LinkedList<String> getAnswers()
	{
		return answers;
	}
	
	/* Holds spaces for answer options and initializes them to a count of 0*/
	public void options(int possibleAnswersCount)
	{
		if(resetVals)
		{
			results.clear();
		}
		
		for(int i = 0; i < thisQ.getAnswers().size(); i++)
		{
			results.add(0);
		}
		
		resetVals = true;
	}
	
	/* increments corresponding answer(s)*/
	public void AddUpdate(int[] answers)
	{
		for(int i = 0; i < thisQ.getAnswers().size(); i++)
		{
			if(answers[i] != 0)
			{
				int temp = results.get(i);
				results.set(i, temp+1);
			}
		}
	}
	
	/* decrements old answer(s) when they are overwritten*/
	public void SubUpdate(int[] OldAnswers)
	{
		for(int i = 0; i < thisQ.getAnswers().size(); i++)
		{
			if(OldAnswers[i] != 0)
			{
				int temp = results.get(i);
				results.set(i, temp-1);
			}
		}
	}
	
	/* Returns string with count of each answer*/
	@Override
	public String toString()
	{
		String result = "";
		for(int i = 0; i < thisQ.getAnswers().size(); i++)
		{
			result = result + " " + thisQ.getAnswers().get(i) + ":" + (results.get(i)) + " ";
		}
		
		return result;
	}
	
	/* returns students id, no setter as id cannot be changed*/
	public int getID()
	{
		return studentID;
	}
	
	/* returns whether a student has voted or not*/
	public boolean getHasVoted()
	{
		return hasVoted;
	}
	
	/* Input check*/
	/*private void inputCheck(LinkedList<String> enteredAnswers)
	{
		for(int i = 1; i < enteredAnswers.size(); i++)
		{
			if(enteredAnswers.get(i).equals(enteredAnswers.get(i-1)))
			{
				throw new IllegalArgumentException("Invalid Input");
			}
		}
		
		if(thisQ.getAnswers().get(0).compareTo(enteredAnswers.get(0)) < 0)
		{
			throw new IllegalArgumentException("Invalid Input");
		}
		else if(thisQ.getAnswers().get(thisQ.GetNumberOfAnswers()-1).compareToIgnoreCase(enteredAnswers.get(enteredAnswers.size()-1)) < 0)
		{
			throw new IllegalArgumentException("Invalid Input");
		}
		
		if(thisQ.getType() == 2 && enteredAnswers.size() > 1)
		{
			throw new IllegalArgumentException("Invalid Input");
		}
		else if(thisQ.getType() == 1 && enteredAnswers.size() > thisQ.GetNumberOfAnswers())
		{
			throw new IllegalArgumentException("Invalid Input");
		}
		
	}*/
}