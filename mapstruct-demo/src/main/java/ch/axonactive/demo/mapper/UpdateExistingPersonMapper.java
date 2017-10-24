package ch.axonactive.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ch.axonactive.demo.bean.Person;
import ch.axonactive.demo.bean.PersonDTO;

@Mapper
public interface UpdateExistingPersonMapper {
	UpdateExistingPersonMapper INSTANCE = Mappers.getMapper( UpdateExistingPersonMapper.class );
	@Mappings({
		@Mapping(source = "firstName", target = "personDto.firstName"),
		@Mapping(source = "lastName", target = "personDto.lastName"),
		@Mapping(source = "streetName", target = "personDto.address.street"),
		@Mapping(source = "houseNumber", target = "personDto.address.houseNo")
	})
    public void updateEntity(@MappingTarget Person person, PersonDTO personDto);
}
