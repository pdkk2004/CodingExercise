package test.miscQuestions;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import MiscQuestions.GroupContacts;
import MiscQuestions.GroupContacts.Contact;

public class GroupContactsTest {
	
	@Test
	public void TestGroupContacts() {
//	    { "John", {"john@gmail.com"} },
//	    { "Mary", {"mary@gmail.com"} },
//	    { "John", {"john@yahoo.com"} },
//	    { "John", {"john@gmail.com", "john@yahoo.com", "john@hotmail.com"} },
//	    { "Bob",  {"bob@gmail.com"} }
		Contact c1 = new Contact("John");
		c1.addEmail("john@gmail.com");
		
		Contact c2 = new Contact("Mary");
		c2.addEmail("mary@gmail.com");
		
		Contact c3 = new Contact("John");
		c3.addEmail("john@yahoo.com");
		
		Contact c4 = new Contact("John");
		c4.addEmails("john@gmail.com", "john@yahoo.com", "john@hotmail.com");
		
		Contact c5 = new Contact("Bob");
		c5.addEmail("bob@gmail.com");
		
		List<Contact> contacts = new LinkedList<>();
		contacts.add(c1);
		contacts.add(c2);
		contacts.add(c3);
		contacts.add(c4);
		contacts.add(c5);
		
		List<List<Contact>> grouped = GroupContacts.groupContacts(contacts);
		Assert.assertEquals(3, grouped.size());
		System.out.println(grouped);
		
		grouped = GroupContacts.groupContactsDFS(contacts);
		Assert.assertEquals(3, grouped.size());
		System.out.println(grouped);
	}
}
