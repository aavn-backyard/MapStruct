package ch.axonactive.demo.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-10-23T20:11:59+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_112 (Oracle Corporation)"
)
public class DateMapperImpl implements DateMapper {

    @Override
    public List<String> datesToStrings(List<Date> dates) {
        if ( dates == null ) {
            return null;
        }

        List<String> list = new ArrayList<String>();
        for ( Date date : dates ) {
            list.add( new SimpleDateFormat( "dd.MM.yyyy" ).format( date ) );
        }

        return list;
    }
}
