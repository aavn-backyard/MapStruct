package ch.axonactive.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ch.axonactive.demo.bean.AccountHolder;
import ch.axonactive.demo.bean.Career;
import ch.axonactive.demo.custom.ContactConverter;
import ch.axonactive.demo.dto.AccountHolderDTO;
import ch.axonactive.demo.dto.CareerDTO;

@Mapper(uses= {PersonMapper.class, ContactConverter.class})
public interface InvokingOtherMapper {
	InvokingOtherMapper INSTANCE = Mappers.getMapper( InvokingOtherMapper.class );
	@Mappings({
		@Mapping(source = "id", target = "id"),
		@Mapping(source = "personDto", target = "person"),
		@Mapping(source = "contactDto", target = "contact"),
		@Mapping(source = "careerDto", target = "career"),
	})
    AccountHolder toEntity(AccountHolderDTO accountDto);
	
	default Career convertCareer(CareerDTO careerDto) {
		Career career = new Career();
		career.setCompanyName(careerDto.getNameOfCompany());
		career.setOccupation(careerDto.getOccupation());
		return career;
	}
	
}
