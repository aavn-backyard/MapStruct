package ch.axonactive.demo.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ch.axonactive.demo.bean.Person;
import ch.axonactive.demo.bean.PersonDTO;

@Mapper
public interface InheritInverseConfigurationPersonMapper {
	InheritInverseConfigurationPersonMapper INSTANCE = Mappers.getMapper( InheritInverseConfigurationPersonMapper.class );
	@Mappings({
		@Mapping(source = "firstName", target = "firstName"),
		@Mapping(source = "lastName", target = "lastName"),
		@Mapping(source = "streetName", target = "address.street"),
		@Mapping(source = "houseNumber", target = "address.houseNo")
	})
    Person toEntity(PersonDTO personDto);
	
	@InheritInverseConfiguration
    PersonDTO toDTO(Person person);
}
