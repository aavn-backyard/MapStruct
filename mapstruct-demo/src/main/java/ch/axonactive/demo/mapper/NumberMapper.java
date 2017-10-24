package ch.axonactive.demo.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NumberMapper {
	NumberMapper INSTANCE = Mappers.getMapper( NumberMapper.class );
	
	 @IterableMapping(numberFormat = "#.##E0") //1.000.000.000 -> 1E9
	 List<String> bigDecimalToString(List<BigDecimal> numbers);
}
