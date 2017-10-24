package ch.axonactive.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ch.axonactive.demo.bean.Person;
import ch.axonactive.demo.bean.PersonDTO;

@Mapper
public interface PersonsMapper {
	PersonsMapper INSTANCE = Mappers.getMapper( PersonsMapper.class );
	
	List<Person> toEntities(List<PersonDTO> cars);

	@Mappings({
		@Mapping(source = "firstName", target = "firstName"),
		@Mapping(source = "lastName", target = "lastName"),
		@Mapping(source = "streetName", target = "address.street"),
		@Mapping(source = "houseNumber", target = "address.houseNo")
	})
    Person toEntity(PersonDTO personDto);
}
