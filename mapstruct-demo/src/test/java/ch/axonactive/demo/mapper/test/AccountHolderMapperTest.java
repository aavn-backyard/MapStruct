package ch.axonactive.demo.mapper.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ch.axonactive.demo.bean.AccountHolder;
import ch.axonactive.demo.bean.AccountHolderDTO;
import ch.axonactive.demo.bean.PersonDTO;
import ch.axonactive.demo.mapper.CallbackActionMapper;
import ch.axonactive.demo.mapper.InvokingOtherMapper;
public class AccountHolderMapperTest {
	@Test
	public void invokeOtherMapper_givenDTO_to_Entity() {

		PersonDTO dto = new PersonDTO();
		dto.setFirstName("Trung");
		dto.setLastName("Do");
		dto.setStreetName("Truong Son");
		dto.setHouseNumber(39);
		
		AccountHolderDTO ah = new AccountHolderDTO();
		ah.setId("COB-001");
		ah.setPersonDto(dto);

		AccountHolder entity = InvokingOtherMapper.INSTANCE.toEntity(ah);

		assertEquals(entity.getId(),"COB-001");
		assertEquals(entity.getPerson().getFirstName(),"Trung");
		assertEquals(entity.getPerson().getLastName(), "Do");
		assertNotNull(entity.getPerson().getAddress());
		assertEquals(entity.getPerson().getAddress().getHouseNo(), 39);
		assertEquals(entity.getPerson().getAddress().getStreet(), "Truong Son");

	}
	
	@Test
	public void callback_givenDTO_to_Entity() {

		PersonDTO dto = new PersonDTO();
		dto.setFirstName("Trung");
		dto.setLastName("Do");
		dto.setStreetName("Truong Son");
		dto.setHouseNumber(39);
		
		AccountHolderDTO ah = new AccountHolderDTO();
		ah.setId("COB-001");
		ah.setPersonDto(dto);

		AccountHolder entity = CallbackActionMapper.INSTANCE.toEntity(ah);

		assertEquals(entity.getId(),"AH-001");
		assertEquals(entity.getPerson().getFirstName(),"Trung");
		assertEquals(entity.getPerson().getLastName(), "Do");
		assertNotNull(entity.getPerson().getAddress());
		assertEquals(entity.getPerson().getAddress().getHouseNo(), 39);
		assertEquals(entity.getPerson().getAddress().getStreet(), "Truong Son");

	}
	
	
}
