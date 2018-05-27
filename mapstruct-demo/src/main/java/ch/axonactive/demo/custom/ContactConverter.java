package ch.axonactive.demo.custom;

import ch.axonactive.demo.bean.Contact;
import ch.axonactive.demo.dto.ContactDTO;

public class ContactConverter {
	public Contact contactDtoToContact(ContactDTO contactDto) {
		Contact contact = new Contact();
		contact.setEmail(contactDto.getEmail());
		contact.setPhone(contactDto.getLandlinephone());
		return contact;
	}
}
