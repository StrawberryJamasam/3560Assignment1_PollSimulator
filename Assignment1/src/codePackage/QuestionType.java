package codePackage;

public interface QuestionType 
{
	/* sets question type*/
	public void setType(int selection);
	
	/* gets question type*/
	public int getType();
	
	/* returns the number of answers allowed for the question type*/
	public int GetNumberOfAnswers();
	
}
