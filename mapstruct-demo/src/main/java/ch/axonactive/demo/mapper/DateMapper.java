package ch.axonactive.demo.mapper;

import java.util.Date;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DateMapper {
	DateMapper INSTANCE = Mappers.getMapper( DateMapper.class );
	
	 @IterableMapping(dateFormat = "dd.MM.yyyy")
	 List<String> datesToStrings(List<Date> dates);
}
