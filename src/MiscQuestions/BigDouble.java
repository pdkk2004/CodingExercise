package MiscQuestions;

public class BigDouble {

	private String digits;

	private boolean isNegative;

	private String intPart;

	private String decimalPart;

	public String strSubstract(String d1, String d2) {
		int dotPos1 = d1.indexOf('.');
		int dotPos2 = d2.indexOf('.');
		dotPos1 = dotPos1 >= 0 ? dotPos1 : d1.length();
		dotPos2 = dotPos2 >= 0 ? dotPos2 : d2.length();
		int borrow = 0;
		int p1 = d1.length() - 1;
		int p2 = d2.length() - 1;
		StringBuilder sb = new StringBuilder();
		while (p1 > dotPos1 || p2 > dotPos2) {
			int v1 = 0, v2 = 0;
			if (p1 - dotPos1 == p2 - dotPos2) {
				v1 = d1.charAt(p1--) - '0';
				v2 = d2.charAt(p2--) - '0';
			} else if (p1 - dotPos1 > p2 - dotPos2) {
				v1 = d1.charAt(p1--) - '0';
			} else {
				v2 = d2.charAt(p2--) - '0';
			}
			v1 += borrow;
			if (v1 < v2) {
				borrow = -1;
				v1 = 10 + v1;
			} else {
				borrow = 0;
			}
			int r = v1 - v2;
			if (r != 0 || sb.length() != 0) {
				sb.insert(0, r);
			}
		}
		if (sb.length() == 0) {
			sb.insert(0, 0);
		}
		sb.insert(0, '.');
		p1 = dotPos1 - 1;
		p2 = dotPos2 - 1;
		while (p1 >= 0 || p2 >= 0) {
			int v1 = (p1 >= 0 ? d1.charAt(p1--) - '0' : 0) + borrow;
			int v2 = (p2 >= 0 ? d2.charAt(p2--) - '0': 0);
			if (v1 < v2) {
				borrow = -1;
				v1 = 10 + v1;
			} else {
				borrow = 0;
			}
			int r = v1 - v2;
			sb.insert(0, r);
		}
		if (borrow < 0) {
			return '-' + strSubstract(d2, d1);
		}
		return sb.toString();
	}
	
	public String strAdd(String d1, String d2) {
		int dotPos1 = d1.indexOf(".");
		int dotPos2 = d2.indexOf(".");
		dotPos1 = dotPos1 > 0 ? dotPos1 : d1.length();
		dotPos2 = dotPos2 > 0 ? dotPos2 : d2.length();
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		int p1 = d1.length() - 1;
		int p2 = d2.length() - 1;
		while (p1 > dotPos1 || p2 > dotPos2) {
			int s = carry;
			if (p1 - dotPos1 == p2 - dotPos2) {
				s = d1.charAt(p1) - '0' + d2.charAt(p2) - '0' + carry;
				p1--;
				p2--;
			} else if (p1 - dotPos1 > p2 - dotPos2) {
				s = carry + d1.charAt(p1) - '0';
				p1--;
			} else {
				s = carry + d2.charAt(p2) - '0';
				p2--;
			}
			carry = s / 10;
			if (sb.length() != 0 || s % 10 != 0) {
				sb.insert(0, s % 10);
			}
		}
		if (sb.length() == 0) {
			sb.insert(0, '0');
		}
		sb.insert(0, '.');
		p1 = dotPos1 - 1;
		p2 = dotPos2 - 1;
		while (p1 >= 0 || p2 >= 0) {
			int s = carry;
			if (p1 >= 0) {
				s += d1.charAt(p1) - '0';
				p1--;
			}
			if (p2 >= 0) {
				s += d2.charAt(p2) - '0';
				p2--;
			}
			carry = s / 10;
			sb.insert(0, s % 10);
		}
		if (carry > 0) {
			sb.insert(0, carry);
		}
		return sb.toString();
	}

	private void init() {
		int i = 0;
		int l = this.digits.length();
		while (i < l) {
			while (i < l && digits.charAt(i) == ' ') {
				i++;
			}
			if (digits.charAt(i) == '-') {
				this.isNegative = true;
				i++;
			} else if (digits.charAt(i) == '+') {
				i++;
			}
			int intStart = i;
			while (i < l && digits.charAt(i) != '.') {
				i++;
			}
			this.intPart = digits.substring(intStart, i);
			int decStart = ++i;
			while (i < l) {
				i++;
			}
			if (i == l) {
				this.decimalPart = digits.substring(decStart, i);
			} else {
				this.decimalPart = "";
			}
		}
	}
}
