package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class skillTree {
	public int solution(String skill, String[] skill_trees) {
		int answer =0;
		ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
		String temp;
		//System.out.println(skillTrees.get(0));
		Iterator<String> it = skillTrees.iterator();
		temp = it.next().replaceAll("[^"+skill+"]","");
		System.out.println("it.next : "+temp);
		System.out.println("skill : "+skill.indexOf(temp));
		System.out.println("skill.indexOf(~) : "+skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")));
		System.out.println(skillTrees);
		//System.out.println(skill.indexOf("AE"));
		//  System.out.println(it.next().replaceAll("["+skill+"]",""));
		//System.out.println(skill.indexOf(it.next().replaceAll("["+skill+"]","")));
		/*while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }*/
		answer = skillTrees.size();
		System.out.println(answer);
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		skillTree s = new skillTree();
		String skill = "CBD";
		//BACDE, CBADF, AECB, BDA
		String[] skill_trees = {"AECB","AECB"};
		
		s.solution(skill, skill_trees);

	}

}
