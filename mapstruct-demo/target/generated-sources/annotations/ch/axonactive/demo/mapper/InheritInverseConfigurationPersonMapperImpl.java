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
public class InheritInverseConfigurationPersonMapperImpl implements InheritInverseConfigurationPersonMapper {

    @Override
    public Person toEntity(PersonDTO personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        Address address = new Address();
        person.setAddress( address );

        person.setFirstName( personDto.getFirstName() );
        person.setLastName( personDto.getLastName() );
        address.setHouseNo( personDto.getHouseNumber() );
        address.setStreet( personDto.getStreetName() );

        return person;
    }

    @Override
    public PersonDTO toDTO(Person person) {
        if ( person == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setFirstName( person.getFirstName() );
        personDTO.setLastName( person.getLastName() );
        personDTO.setStreetName( personAddressStreet( person ) );
        personDTO.setHouseNumber( personAddressHouseNo( person ) );

        return personDTO;
    }

    private String personAddressStreet(Person person) {

        if ( person == null ) {
            return null;
        }
        Address address = person.getAddress();
        if ( address == null ) {
            return null;
        }
        String street = address.getStreet();
        if ( street == null ) {
            return null;
        }
        return street;
    }

    private int personAddressHouseNo(Person person) {

        if ( person == null ) {
            return 0;
        }
        Address address = person.getAddress();
        if ( address == null ) {
            return 0;
        }
        int houseNo = address.getHouseNo();
        return houseNo;
    }
}
