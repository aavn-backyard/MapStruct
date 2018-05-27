package ch.axonactive.demo.dto;

public class AccountHolderDTO {
	private String id;
	private PersonDTO personDto;
	private ContactDTO contactDto;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PersonDTO getPersonDto() {
		return personDto;
	}
	public void setPersonDto(PersonDTO personDto) {
		this.personDto = personDto;
	}
	public ContactDTO getContactDto() {
		return contactDto;
	}
	public void setContactDto(ContactDTO contactDto) {
		this.contactDto = contactDto;
	}
	
}
