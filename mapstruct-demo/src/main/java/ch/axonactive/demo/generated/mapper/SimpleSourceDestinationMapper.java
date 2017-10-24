package ch.axonactive.demo.generated.mapper;

import org.mapstruct.Mapper;

import ch.axonactive.demo.generated.bean.SimpleDestination;
import ch.axonactive.demo.generated.bean.SimpleSource;

/**
 * Run <code> mvn clean install</code> then check <code> /target/generated-sources/annotations/. </code>
 *
 */
@Mapper
public interface SimpleSourceDestinationMapper {
	SimpleDestination toDes(SimpleSource source);
    SimpleSource toSource(SimpleDestination destination);
}
