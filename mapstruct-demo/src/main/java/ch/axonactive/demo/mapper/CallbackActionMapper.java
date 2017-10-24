package ch.axonactive.demo.mapper;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ch.axonactive.demo.bean.AccountHolder;
import ch.axonactive.demo.bean.AccountHolderDTO;

@Mapper(uses= PersonMapper.class)
public abstract class CallbackActionMapper {
	public static CallbackActionMapper INSTANCE = Mappers.getMapper( CallbackActionMapper.class );
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "personDto", target = "person"),
	})
    public abstract AccountHolder toEntity(AccountHolderDTO accountDto);
	
	@BeforeMapping 
	protected void updateId(AccountHolderDTO accountDto){
		String id = accountDto.getId();
		accountDto.setId(id.replace("COB", "AH"));
	}
}
