package codePackage;

import java.util.LinkedList;
import java.util.Random;

public class SimulationDriver extends VotingService
{
	public static void main(String[] args)
	{
												// Question Creation
		Question no1 = new Question();
		String text1 = "What is the best letter? A, B, C, or D?";
		int type1 = 2;
		LinkedList<String> answers1 = new LinkedList<>();
		answers1.add("A"); answers1.add("B"); answers1.add("C"); answers1.add("D");
		
		no1.SetQandA(text1, type1, answers1);
		
		Question no2 = new Question();
		String text2 = "What animals make good pets? 1: Tigers, 2: Horses, 3: Cats";
		int type2 = 1;
		LinkedList<String> answers2 = new LinkedList<>();
		answers2.add("1"); answers2.add("2"); answers2.add("3");
		
		no2.SetQandA(text2, type2, answers2);
		
												// Loading Q1 into voting service
		VotingService currentQ = new VotingService();
		currentQ.configureQ(no1);
		
		System.out.println();
		currentQ.printQandA();
		System.out.println();
		
												// Creating random students id's + answers
		Random ran = new Random();
		
		int[] stuIDs = new int[5];
		
		LinkedList<String> Q1S0 = new LinkedList<>();
		LinkedList<String> Q1S1 = new LinkedList<>();
		LinkedList<String> Q1S2 = new LinkedList<>();
		LinkedList<String> Q1S3 = new LinkedList<>();
		LinkedList<String> Q1S4 = new LinkedList<>();
		
		LinkedList<String> Q2S0 = new LinkedList<>();
		LinkedList<String> Q2S1 = new LinkedList<>();
		LinkedList<String> Q2S2 = new LinkedList<>();
		LinkedList<String> Q2S3 = new LinkedList<>();
		LinkedList<String> Q2S4 = new LinkedList<>();
		
		for(int i = 0; i < 5; i++)
		{
			stuIDs[i] = ran.nextInt(10000000);
		}
			
		String Q1A = "" + String.valueOf((char)ran.nextInt(65, 69));
		Q1S0.add(Q1A);
		String Q1B = "" +String.valueOf((char)ran.nextInt(65, 69));
		Q1S1.add(Q1B);
		String Q1C = "" +String.valueOf((char)ran.nextInt(65, 69));
		Q1S2.add(Q1C);
		String Q1D = String.valueOf((char)ran.nextInt(65, 69));
		Q1S3.add(Q1D);
		String Q1E = String.valueOf((char)ran.nextInt(65, 69));
		Q1S4.add(Q1E);
		
		String Q2A = String.valueOf(ran.nextInt(1, 4));		// input validation disabled so duplicate random variables don't cause problems
		Q2S0.add(Q2A);										// duplicate variables ignored
		String Q2A2 = String.valueOf(ran.nextInt(1, 4));		
		Q2S0.add(Q2A2);
		String Q2B = String.valueOf(ran.nextInt(1, 4));
		Q2S1.add(Q2B);
		String Q2C = String.valueOf(ran.nextInt(1, 4));
		Q2S2.add(Q2C);
		String Q2C2 = String.valueOf(ran.nextInt(1, 4));
		Q2S2.add(Q2C2);
		String Q2C3 = String.valueOf(ran.nextInt(1, 4));
		Q2S2.add(Q2C3);
		String Q2D = String.valueOf(ran.nextInt(1, 4));
		Q2S3.add(Q2D);
		String Q2D2 = String.valueOf(ran.nextInt(1, 4));
		Q2S3.add(Q2D2);
		String Q2E = String.valueOf(ran.nextInt(1, 4));
		Q2S4.add(Q2E);
		String Q2E2 = String.valueOf(ran.nextInt(1, 4));
		Q2S4.add(Q2E2);
		String Q2E3 = String.valueOf(ran.nextInt(1, 4));
		Q2S4.add(Q2E3);

		
												// Submitting ID's and answers to voting service Q1
		
		VotingService n0 = new VotingService(stuIDs[0]);
		n0.setAnswers(Q1S0);

		VotingService n1 = new VotingService(stuIDs[1]);	
		n1.setAnswers(Q1S1);

		VotingService n2 = new VotingService(stuIDs[2]);		
		n2.setAnswers(Q1S2);
	
		VotingService n3 = new VotingService(stuIDs[3]);		
		n3.setAnswers(Q1S3);

		VotingService n4 = new VotingService(stuIDs[4]);		
		n4.setAnswers(Q1S4);

		System.out.println("Results: " + currentQ.toString());
		
		
											// Loading Q2 into Voting Service
		VotingService currentQ2 = new VotingService();
		currentQ2.configureQ(no2);
		
		System.out.println();
		currentQ2.printQandA();
		System.out.println();

											// Submitting ID's and answers to voting service Q2		
		
		VotingService n20 = new VotingService(stuIDs[0]);
		n20.setAnswers(Q2S0);

		VotingService n21 = new VotingService(stuIDs[1]);
		n21.setAnswers(Q2S1);

		VotingService n22 = new VotingService(stuIDs[2]);
		n22.setAnswers(Q2S2);

		VotingService n23 = new VotingService(stuIDs[3]);
		n23.setAnswers(Q2S3);
		
		VotingService n24 = new VotingService(stuIDs[4]);
		n24.setAnswers(Q2S4);
		
		System.out.println("Results: " + currentQ.toString());
		
	}
}