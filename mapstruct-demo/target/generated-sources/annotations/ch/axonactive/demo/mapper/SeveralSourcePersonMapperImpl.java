package ch.axonactive.demo.mapper;

import ch.axonactive.demo.bean.Address;
import ch.axonactive.demo.bean.Person;
import ch.axonactive.demo.bean.PersonDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-10-23T20:11:59+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_112 (Oracle Corporation)"
)
public class SeveralSourcePersonMapperImpl implements SeveralSourcePersonMapper {

    @Override
    public Person toEntity(PersonDTO personDto, int hn) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        Address address = new Address();
        person.setAddress( address );
        if ( personDto != null ) {
            person.setFirstName( personDto.getFirstName() );
            person.setLastName( personDto.getLastName() );
            address.setStreet( personDto.getStreetName() );
        }
        address.setHouseNo( hn );

        return person;
    }
}
