package ch.axonactive.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ch.axonactive.demo.bean.AccountHolder;
import ch.axonactive.demo.bean.AccountHolderDTO;

@Mapper(uses= PersonMapper.class)
public interface InvokingOtherMapper {
	InvokingOtherMapper INSTANCE = Mappers.getMapper( InvokingOtherMapper.class );
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "personDto", target = "person"),
	})
    AccountHolder toEntity(AccountHolderDTO accountDto);
}
