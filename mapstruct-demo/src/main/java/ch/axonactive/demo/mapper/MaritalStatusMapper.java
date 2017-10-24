package ch.axonactive.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ch.axonactive.demo.enums.AvalogMaritalStatus;
import ch.axonactive.demo.enums.MaritalStatus;

@Mapper
public interface MaritalStatusMapper {
	MaritalStatusMapper INSTANCE = Mappers.getMapper( MaritalStatusMapper.class );
	

	@Mappings({
		@Mapping(source = "_SINGLE", target = "SINGLE"),
		@Mapping(source = "_DIVORCE", target = "DIVORCE"),
		@Mapping(source = "_GET_MARRIED", target = "MARRIED"),
	})
    MaritalStatus toMaritalStatus(AvalogMaritalStatus avalog);
}
