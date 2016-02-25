package Leetcode;

/**
 * Leetcode: Integer to English word.
 * @author kkdpan
 *
 */
public class IntegerToEnglishWord {

	private static String[] thousands = { "", "Thousand", "Million", "Billion", "Trillion" };

	private static String[] ones = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten" };

	private static String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	private static String[] ten = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Nineteen" };

	public String numberToWords(int num) {
		StringBuilder sb = new StringBuilder();
		if (num == 0) {
			return "Zero";
		}

		int i = 0;
		int base = 1;
		while (num / base >= 1000) {
			base *= 1000;
			i++;
		}

		while (num > 0) {
			int segment = num / base;
			String str = compose(segment, thousands[i]);
			if (sb.length() != 0 && str.length() != 0) {
				sb.append(" ");
			}
			sb.append(str);
			num = num % base;
			base /= 1000;
			i--;
		}
		return sb.toString();
	}

	private String compose(int num, String unit) {
		StringBuilder sb = new StringBuilder();
		if (num >= 100) {
			int h = num / 100;
			num = num % 100;
			sb.append(ones[h]).append(" Hundred");
		}

		if (num >= 20) {
			int t = num / 10;
			num = num % 10;
			if (sb.length() != 0) {
				sb.append(" ");
			}
			sb.append(tens[t]);
		} else if (num >= 10) {
			if (sb.length() != 0) {
				sb.append(" ");
			}
			sb.append(ten[num - 10]);
			num = 0;
		}

		if (num > 0) {
			if (sb.length() != 0) {
				sb.append(" ");
			}
			sb.append(ones[num]);
		}

		if (sb.length() != 0 && unit.length() != 0) {
			sb.append(" ").append(unit);
		}
		return sb.toString();
	}
}
