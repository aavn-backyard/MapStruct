package ch.axonactive.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ch.axonactive.demo.bean.Person;
import ch.axonactive.demo.bean.PersonDTO;
@Mapper
public interface SeveralSourcePersonMapper {
	SeveralSourcePersonMapper INSTANCE = Mappers.getMapper( SeveralSourcePersonMapper.class );
	@Mappings({
		@Mapping(source = "personDto.firstName", target = "firstName"),
		@Mapping(source = "personDto.lastName", target = "lastName"),
		@Mapping(source = "personDto.streetName", target = "address.street"),
		@Mapping(source = "hn", target = "address.houseNo")
	})
    Person toEntity(PersonDTO personDto, int hn);
}
