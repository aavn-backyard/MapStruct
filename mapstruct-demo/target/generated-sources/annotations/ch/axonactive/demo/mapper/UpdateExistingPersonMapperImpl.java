package ch.axonactive.demo.mapper;

import ch.axonactive.demo.bean.Address;
import ch.axonactive.demo.bean.Person;
import ch.axonactive.demo.bean.PersonDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-10-23T20:11:58+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_112 (Oracle Corporation)"
)
public class UpdateExistingPersonMapperImpl implements UpdateExistingPersonMapper {

    @Override
    public void updateEntity(Person person, PersonDTO personDto) {
        if ( personDto == null ) {
            return;
        }

        Address address = new Address();
        person.setAddress( address );

        person.setFirstName( personDto.getFirstName() );
        address.setStreet( personDto.getStreetName() );
        address.setHouseNo( personDto.getHouseNumber() );
        person.setLastName( personDto.getLastName() );
    }
}
