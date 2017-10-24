package ch.axonactive.demo.mapper;

import ch.axonactive.demo.bean.Address;
import ch.axonactive.demo.bean.Person;
import ch.axonactive.demo.bean.PersonDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-10-23T20:11:59+0700",
    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_112 (Oracle Corporation)"
)
public class PersonsMapperImpl implements PersonsMapper {

    @Override
    public List<Person> toEntities(List<PersonDTO> cars) {
        if ( cars == null ) {
            return null;
        }

        List<Person> list = new ArrayList<Person>();
        for ( PersonDTO personDTO : cars ) {
            list.add( toEntity( personDTO ) );
        }

        return list;
    }

    @Override
    public Person toEntity(PersonDTO personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person_ = new Person();

        Address address = new Address();
        person_.setAddress( address );

        person_.setFirstName( personDto.getFirstName() );
        person_.setLastName( personDto.getLastName() );
        address.setHouseNo( personDto.getHouseNumber() );
        address.setStreet( personDto.getStreetName() );

        return person_;
    }
}
