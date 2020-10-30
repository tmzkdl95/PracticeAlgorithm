package level2;

import java.util.HashMap;
import java.util.Scanner;

public class nhn01 {

	public void solution(int numOfAllPlayers,int numOfQuickPlayers, String[] namesOfQuickPlayers, int numOfGames,int[] numOfMovesPerGame){
		//이름 부여
		char[] playerName = new char[numOfAllPlayers];
		char name = 'A';
		boolean answer = false;
		int tower = 0; // 수건위치
		char no_sul = 'A';
		
		HashMap<String,Integer> hs = new HashMap<String,Integer>();
		
		for(int k=0; k<numOfAllPlayers; k++) {
			playerName[k] = (char)(name+(k+1));
			hs.put(String.valueOf(playerName[k]), 0);
		}		
		hs.put(String.valueOf(name), 1);
		//1. 게임횟수만큼 반복
		for(int i=0; i<numOfGames; i++) {
			 //1.최초 술래 출발
			 //수건 두기
			 if(numOfMovesPerGame[i]>0) {
				 tower = (tower+numOfMovesPerGame[i])%playerName.length;
				 no_sul = playerName[tower]; // 예비술래
				 
			 }else {
				 tower = (tower-Math.abs(numOfMovesPerGame[i]))%playerName.length;
				 no_sul = playerName[tower]; // 예비술래
			 }
			 //2.달리기 비교 
			 for(int j=0; j<namesOfQuickPlayers.length; j++) {
				 if(namesOfQuickPlayers[j].equals(String.valueOf(name))) {
					 answer = true;
					 break;
				 }
			 }
			 //잡힌경우 기존 술래 
			 if(answer) {
				 hs.put(String.valueOf(name), hs.get(String.valueOf(name))+1);
				 //playerName[tower] = no_sul;
			 }else {
		     // 안잡히면 신규 술래
				 playerName[tower] = name;
				 name = no_sul;
				 hs.put(String.valueOf(name), hs.get(String.valueOf(name))+1);
			 }
			 
			 answer = false;
		}
		
		System.out.println(hs);
		for(int i=0; i<playerName.length; i++) {
			System.out.println(playerName[i]+" "+hs.get(String.valueOf(playerName[i])));
		}
		
	}
	
	public static void main(String[] args) {
		nhn01 t = new nhn01();
		int numOfAllPlayers;
		int numOfQuickPlayers;
		int numOfGames;
		
		
		
		Scanner sc = new Scanner(System.in);
		
		//1. 입력
		numOfAllPlayers =  sc.nextInt();  //참여자수
		numOfQuickPlayers = sc.nextInt(); //빠른사람
		String[] namesOfQuickPlayers = new String[numOfQuickPlayers];
		//빠른사람 이름		
		for(int i=0; i<numOfQuickPlayers; i++) {
			namesOfQuickPlayers[i]=sc.next();
		}
		numOfGames = sc.nextInt(); //게임수
		int[] numOfMovesPerGame = new int[numOfGames];
		for(int j=0; j<numOfGames; j++) {
			numOfMovesPerGame[j] = sc.nextInt(); 
		}
		/*
		System.out.println("numOfAllPlayers :"+numOfAllPlayers);
		System.out.println("numOfQuickPlayers :"+numOfQuickPlayers);
		for(int i=0; i<namesOfQuickPlayers.length; i++) {
			System.out.println(namesOfQuickPlayers[i]);
		}
		System.out.println("numOfGames :"+numOfGames);
		for(int i=0; i<numOfMovesPerGame.length; i++) {
			System.out.println(numOfMovesPerGame[i]);
		}*/
		t.solution(numOfAllPlayers,numOfQuickPlayers,namesOfQuickPlayers,numOfGames,numOfMovesPerGame);
	}

}
