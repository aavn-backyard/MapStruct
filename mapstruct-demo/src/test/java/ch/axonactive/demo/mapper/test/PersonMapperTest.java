package ch.axonactive.demo.mapper.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import ch.axonactive.demo.bean.Address;
import ch.axonactive.demo.bean.Person;
import ch.axonactive.demo.bean.PersonDTO;
import ch.axonactive.demo.enums.AvalogMaritalStatus;
import ch.axonactive.demo.enums.MaritalStatus;
import ch.axonactive.demo.mapper.InheritInverseConfigurationPersonMapper;
import ch.axonactive.demo.mapper.MaritalStatusMapper;
import ch.axonactive.demo.mapper.NumberMapper;
import ch.axonactive.demo.mapper.PersonMapper;
import ch.axonactive.demo.mapper.PersonsMapper;
import ch.axonactive.demo.mapper.SeveralSourcePersonMapper;
import ch.axonactive.demo.mapper.UpdateExistingPersonMapper;
import ch.axonactive.demo.mapper.DateMapper;
public class PersonMapperTest {
	@Test
	public void basicMapping_givenDTO_to_Entity() {

		PersonDTO dto = new PersonDTO();
		dto.setFirstName("Trung");
		dto.setLastName("Do");
		dto.setStreetName("Truong Son");
		dto.setHouseNumber(39);

		Person entity = PersonMapper.INSTANCE.toEntity(dto);

		assertEquals(entity.getFirstName(),"Trung");
		assertEquals(entity.getLastName(), "Do");
		assertNotNull(entity.getAddress());
		assertEquals(entity.getAddress().getHouseNo(), 39);
		assertEquals(entity.getAddress().getStreet(), "Truong Son");

	}
	
	@Test
	public void basicMapping_givenEntity_to_DTO() {

		Person person = new Person();
		Address address = new Address();
		address.setHouseNo(39);
		address.setStreet("Truong Son");
		person.setAddress(address);
		person.setFirstName("Trung");
		person.setLastName("Do");

		PersonDTO entityDTO = PersonMapper.INSTANCE.toDTO(person);

		assertEquals(entityDTO.getFirstName(),"Trung");
		assertEquals(entityDTO.getLastName(), "Do");
		assertEquals(entityDTO.getHouseNumber(), 39);
		assertEquals(entityDTO.getStreetName(), "Truong Son");

	}
	
	@Test
	public void severalSource_givenDTO_to_Entity() {

		PersonDTO dto = new PersonDTO();
		dto.setFirstName("Trung");
		dto.setLastName("Do");
		dto.setStreetName("Truong Son");
		dto.setHouseNumber(39);

		Person entity = SeveralSourcePersonMapper.INSTANCE.toEntity(dto, 40);

		assertEquals(entity.getFirstName(),"Trung");
		assertEquals(entity.getLastName(), "Do");
		assertNotNull(entity.getAddress());
		assertEquals(entity.getAddress().getHouseNo(), 40);
		assertEquals(entity.getAddress().getStreet(), "Truong Son");

	}
	
	@Test
	public void updateExistingBean_givenDTO_to_Entity() {

		PersonDTO dto = new PersonDTO();
		dto.setFirstName("Trung");
		dto.setLastName("Do");
		dto.setStreetName("Truong Son");
		dto.setHouseNumber(39);
		
		Person entity = new Person();
		UpdateExistingPersonMapper.INSTANCE.updateEntity(entity, dto);

		assertEquals(entity.getFirstName(),"Trung");
		assertEquals(entity.getLastName(), "Do");
		assertNotNull(entity.getAddress());
		assertEquals(entity.getAddress().getHouseNo(), 39);
		assertEquals(entity.getAddress().getStreet(), "Truong Son");

	}
	
	@Test
	public void inheritInverseConfig_givenEntity_to_DTO() {

		Person person = new Person();
		Address address = new Address();
		address.setHouseNo(39);
		address.setStreet("Truong Son");
		person.setAddress(address);
		person.setFirstName("Trung");
		person.setLastName("Do");

		PersonDTO entityDTO = InheritInverseConfigurationPersonMapper.INSTANCE.toDTO(person);

		assertEquals(entityDTO.getFirstName(),"Trung");
		assertEquals(entityDTO.getLastName(), "Do");
		assertEquals(entityDTO.getHouseNumber(), 39);
		assertEquals(entityDTO.getStreetName(), "Truong Son");

	}
	
	@Test
	public void collections_givenDTOs_to_Entitys() {
		List<PersonDTO> dtos = new ArrayList<>();
		PersonDTO dto = new PersonDTO();
		dto.setFirstName("Trung");
		dto.setLastName("Do");
		dto.setStreetName("Truong Son");
		dto.setHouseNumber(39);
		dtos.add(dto);
		PersonDTO dto2 = new PersonDTO();
		dto2.setFirstName("Cuong");
		dto2.setLastName("Le");
		dto2.setStreetName("Lac Long Quan");
		dto2.setHouseNumber(854);
		dtos.add(dto2);
		
		List<Person> entities = PersonsMapper.INSTANCE.toEntities(dtos);
		
		assertEquals(entities.size(),2);
		assertEquals(entities.get(0).getFirstName(),"Trung");
		assertEquals(entities.get(0).getLastName(), "Do");
		assertNotNull(entities.get(0).getAddress());
		assertEquals(entities.get(0).getAddress().getHouseNo(), 39);
		assertEquals(entities.get(0).getAddress().getStreet(), "Truong Son");
		
		assertEquals(entities.get(1).getFirstName(),"Cuong");
		assertEquals(entities.get(1).getLastName(), "Le");

	}
	
	@Test
	public void enum_givenAvalogMaritalStatus_toMaritalStatus() {
		
		MaritalStatus status = MaritalStatusMapper.INSTANCE.toMaritalStatus(AvalogMaritalStatus._SINGLE);
		assertEquals(status, MaritalStatus.SINGLE);
		
		status = MaritalStatusMapper.INSTANCE.toMaritalStatus(AvalogMaritalStatus._DIVORCE);
		assertEquals(status, MaritalStatus.DIVORCE);
		
		status = MaritalStatusMapper.INSTANCE.toMaritalStatus(AvalogMaritalStatus._GET_MARRIED);
		assertEquals(status, MaritalStatus.MARRIED);
	}
	
	@Test
	public void format_DateToString() throws ParseException {
		
		List<Date> dates = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse("21/12/2018");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd-yyyy");
		Date date2 = sdf2.parse("12-21-2019");
		dates.add(date);
		dates.add(date2);
		
		List<String> dateStrings = DateMapper.INSTANCE.datesToStrings(dates);
		assertEquals(dateStrings.get(0), "21.12.2018");
		assertEquals(dateStrings.get(1), "21.12.2019");
	}
	
	@Test
	public void format_NumberToString() throws ParseException {
		
		List<BigDecimal> numbers = new ArrayList<>();
		BigDecimal bigDec = new BigDecimal("1000000000000"); //1000.000.000.000
		BigDecimal bigDec2 = new BigDecimal("900000000000000"); //900.000.000.000.000
		numbers.add(bigDec);
		numbers.add(bigDec2);
		
		List<String> numberAsStrings = NumberMapper.INSTANCE.bigDecimalToString(numbers);
		assertEquals(numberAsStrings.get(0), "1E12");
		assertEquals(numberAsStrings.get(1), "9E14");
	}
}
