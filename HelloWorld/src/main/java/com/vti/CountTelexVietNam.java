package com.vti;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountTelexVietNam {

	private static final Map<String, Character> telexVietNam = new HashMap<>();

	static {
		telexVietNam.put("aw", 'ă');
		telexVietNam.put("aa", 'â');
		telexVietNam.put("dd", 'đ');
		telexVietNam.put("ee", 'ê');
		telexVietNam.put("oo", 'ô');
		telexVietNam.put("ow", 'ơ');
		telexVietNam.put("w", 'ư');
	}

	public static int countTelexVietNam(String telexVN) {

		int count = 0;
		int i = 0;
		while (i < telexVN.length()) {
			boolean matched = false;
			for (Map.Entry<String, Character> entry : telexVietNam.entrySet()) {
				String telex = entry.getKey();
				if (i + telex.length() <= telexVN.length() && telexVN.substring(i, i + telex.length()).equals(telex)) {
					count++;
					i += telex.length();
					matched = true;
					break;
				}
			}
			if (!matched) {
				i++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập 1 chuỗi bất kì");
		String input = sc.nextLine();
		int result = countTelexVietNam(input);
		System.out.println("Số lượng các ký tự có dấu: " + result);
	}
}