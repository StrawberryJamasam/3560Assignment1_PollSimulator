package codePackage;

import java.util.LinkedList;

public class Question implements QuestionType
{
	private int numberOfAnswers;
	private LinkedList<String> options = new LinkedList<>();
	private boolean configured;
	private int type;
	private String questionContents;
	
	/* default constructor*/
	public Question()
	{
		configured = false;
	}
	
	/* configures the question*/
	public void SetQandA(String Q, int Qtype, LinkedList<String> answers)
	{	
		setQuestionContents(Q);	
		setType(Qtype);
		setAnswerConfig(answers);
		
		if(type == 1)
			numberOfAnswers = options.size();
		else if(type == 2)
			numberOfAnswers = 1;
		configured = true;
	}
	
	public void setType(int Qtype)
	{
		if(Qtype < 1 || Qtype > 2)
			throw new IllegalArgumentException("The input for the question type must be either 1 or 2");
		else
			type = Qtype;
	}
	
	public int getType()
	{
		return type;
	}

	private void setQuestionContents(String contents)
	{
		questionContents = contents;
	}
	
	public String getQuestionContents()
	{
		return questionContents;
	}
	
	/* Configure the answers depending on type*/
	private void setAnswerConfig(LinkedList<String> answers)
	{
		options = answers;
	}
	
	public LinkedList<String> getAnswers()
	{
		return options;
	}
	
	/* returns the number of answers allowed for the question type*/
	public int GetNumberOfAnswers()
	{
		return numberOfAnswers;
	}
	
	/* Ensures that answers are configured before you use them*/
	public boolean isConfigured()
	{
		return configured;
	}
}
