package ch.axonactive.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ch.axonactive.demo.bean.Person;
import ch.axonactive.demo.bean.PersonDTO;

@Mapper
public interface PersonMapper {
	PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );
	@Mappings({
		@Mapping(source = "firstName", target = "firstName"),
		@Mapping(source = "lastName", target = "lastName"),
		@Mapping(source = "streetName", target = "address.street"),
		@Mapping(source = "houseNumber", target = "address.houseNo")
	})
    Person toEntity(PersonDTO personDto);
	
	@Mappings({
		@Mapping(target = "firstName", source = "firstName"),
		@Mapping(target = "lastName", source = "lastName"),
		@Mapping(target = "streetName", source = "address.street"),
		@Mapping(target = "houseNumber", source = "address.houseNo")
	})
    PersonDTO toDTO(Person person);
}
