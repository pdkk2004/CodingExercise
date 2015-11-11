package MiscQuestions;

import java.util.LinkedList;
import java.util.List;


/**
 * http://www.fgdsb.com/2015/01/06/encode-decode-strings/#more
 * @author dipa
 *
 */
public class EncodeDecodeString {
	
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s.length() + '#' + s);
		}
		return sb.toString();
	}
	
	public List<String> decode(String str) {
		int p = 0;
		List<String> ret = new LinkedList<String>();
		while(p < str.length()) {
			int pos = str.indexOf('#', p);
			if (pos < 0) {
				break;
			}
			int len = Integer.parseInt(str.substring(p, pos));
			String s = str.substring(pos + 1, pos + 1 + len);
			ret.add(s);
			p = pos + 1 + len;
		}
		return ret;
	}
}
