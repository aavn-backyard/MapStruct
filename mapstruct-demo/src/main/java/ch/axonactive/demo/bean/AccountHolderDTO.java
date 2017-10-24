package ch.axonactive.demo.bean;

public class AccountHolderDTO {
	private String id;
	private PersonDTO personDto;
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
	
}
