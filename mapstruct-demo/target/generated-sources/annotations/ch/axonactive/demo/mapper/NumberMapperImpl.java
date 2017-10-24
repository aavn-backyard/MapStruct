package ch.axonactive.demo.mapper;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-10-23T20:11:59+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_112 (Oracle Corporation)"
)
public class NumberMapperImpl implements NumberMapper {

    @Override
    public List<String> bigDecimalToString(List<BigDecimal> numbers) {
        if ( numbers == null ) {
            return null;
        }

        List<String> list = new ArrayList<String>();
        for ( BigDecimal bigDecimal : numbers ) {
            list.add( createDecimalFormat( "#.##E0" ).format( bigDecimal ) );
        }

        return list;
    }

    private DecimalFormat createDecimalFormat( String numberFormat ) {

        DecimalFormat df = new DecimalFormat( numberFormat );
        df.setParseBigDecimal( true );
        return df;
    }
}
