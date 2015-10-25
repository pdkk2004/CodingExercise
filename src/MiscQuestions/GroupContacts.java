package MiscQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Common.UnionFindSet;

public class GroupContacts {

	public static class Contact {
		private String name;
		private List<String> emails;

		public Contact(String name) {
			this.name = name;
			this.emails = new LinkedList<String>();
		}

		public void addEmail(String email) {
			this.emails.add(email);
		}
		
		public void addEmails(String... es) {
			for (String email : es) {
				emails.add(email);
			}
		}
		
		@Override
		public String toString()
		{
			return this.name + ":" + emails.toString();
		}
	}

	/**
	 * Using UnionFindSet solution.
	 * 
	 * @param contacts
	 * @return
	 */
	public static List<List<Contact>> groupContacts(List<Contact> contacts) {
		Map<String, List<Contact>> email2Contacts = new HashMap<>();
		for (Contact c : contacts) {
			for (String email : c.emails) {
				List<Contact> l = email2Contacts.get(email);
				if (l == null) {
					l = new ArrayList<Contact>();
					email2Contacts.put(email, l);
				}
				l.add(c);
			}
		}

		UnionFindSet<Contact> uf = new UnionFindSet<>(contacts);
		for (List<Contact> cs : email2Contacts.values()) {
			for (int i = 0; i < cs.size() - 1; i++) {
				uf.union(cs.get(i), cs.get(i + 1));
			}
		}

		Map<Contact, List<Contact>> groups = new HashMap<>();
		for (Contact c : contacts) {
			Contact rep = uf.findSet(c);
			List<Contact> l = groups.get(rep);
			if (l == null) {
				l = new LinkedList<Contact>();
				groups.put(rep, l);
			}
			l.add(c);
		}

		return new LinkedList<List<Contact>>(groups.values());
	}

	/**
	 * DSF solution to group contacts
	 * @param contacts
	 * @return
	 */
	public static List<List<Contact>> groupContactsDFS(List<Contact> contacts) {
		Map<String, List<Contact>> email2Contacts = new HashMap<>();
		for (Contact c : contacts) {
			for (String email : c.emails) {
				List<Contact> l = email2Contacts.get(email);
				if (l == null) {
					l = new ArrayList<Contact>();
					email2Contacts.put(email, l);
				}
				l.add(c);
			}
		}

		Set<String> visited = new HashSet<String>();
		List<List<Contact>> ret = new LinkedList<>();
		for (String email : email2Contacts.keySet()) {
			if (!visited.contains(email)) {
				Set<Contact> group = new HashSet<>();
				dfs(email, email2Contacts, visited, group);
				ret.add(new LinkedList<Contact>(group));
			}
		}
		return ret;
	}

	private static void dfs(String email, Map<String, List<Contact>> map, Set<String> visited, Set<Contact> r) {
		if (visited.contains(email) || !map.containsKey(email)) {
			return;
		}
		
		List<Contact> contacts = map.get(email);
		visited.add(email);
		for (Contact c : contacts) {
			if (!r.contains(c)) {
				r.add(c);
				for (String e : c.emails) {
					if (!visited.contains(e)) {
						dfs(e, map, visited, r);
					}
				}
			}
		}
	}
}
