package ch.axonactive.demo.mapper;

import ch.axonactive.demo.enums.AvalogMaritalStatus;
import ch.axonactive.demo.enums.MaritalStatus;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-10-23T20:11:58+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_112 (Oracle Corporation)"
)
public class MaritalStatusMapperImpl implements MaritalStatusMapper {

    @Override
    public MaritalStatus toMaritalStatus(AvalogMaritalStatus avalog) {
        if ( avalog == null ) {
            return  null;
        }

        MaritalStatus maritalStatus;

        switch ( avalog ) {
            case _SINGLE: maritalStatus = MaritalStatus.SINGLE;
            break;
            case _DIVORCE: maritalStatus = MaritalStatus.DIVORCE;
            break;
            case _GET_MARRIED: maritalStatus = MaritalStatus.MARRIED;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + avalog );
        }

        return maritalStatus;
    }
}
