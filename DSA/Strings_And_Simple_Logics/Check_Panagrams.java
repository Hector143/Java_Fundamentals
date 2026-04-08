package Strings_And_Simple_Logics;

import java.util.HashSet;
import java.util.Set;

public class Check_Panagrams {
	
	public static void main(String[] args) {
		String s = "The quick brown fox jumps over the lazy dogs";
		System.out.println(isPanagram(s));
		System.out.println(checkPanagram(s));
	}
	
	public static boolean isPanagram(String s) {
        boolean[] seen = new boolean[26];

        for (char ch : s.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                seen[ch - 'a'] = true;
            }
        }

        for (boolean b : seen) {
            if (!b) return false;
        }

        return true;
    }
	
	public static boolean checkPanagram(String s) {
		Set<Character> set = new HashSet<>();

		for (char ch : s.toLowerCase().toCharArray()) {
			if (ch >= 'a' && ch <= 'z') {
				set.add(ch);
			}
		}

		return set.size() == 26;

	}

}
