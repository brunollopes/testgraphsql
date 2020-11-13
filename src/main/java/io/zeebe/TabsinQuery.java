package io.zeebe;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import graphql.schema.DataFetcher;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TabsinQuery {

	private Set<Tabsin> mockTabsinStorage;

    public TabsinQuery() {
    	mockTabsinStorage = new LinkedHashSet<>();
    }
    
	public static Map<String,String> staticValues;
	
	static {
		staticValues = new ConcurrentHashMap<String,String>();
		for(int i=0; i<10; i++) {
			staticValues.put("btn"+i, "value"+1);
		}
	};
	
	/**
     * Retrieves all statics in a json format string.
     *
     * Invoke with:
     * {statics(){id, name}}
     *
     * @param name
     * @return
     */
    @GraphQLQuery(name = "statics")
    public String getStatics(){
    	try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(TabsinQuery.staticValues);
        } catch (JsonProcessingException e) {
            log.error("There was a problem fetching the Tabsin!");
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Retrieves a set of Tabsins with a same name.
     *
     * Invoke with:
     * {staticsByName(name:"vendor0"){id, name}}
     *
     * @param name
     * @return
     */
    @GraphQLQuery(name = "staticsByName")
    public Set<Tabsin> getVendors(@GraphQLArgument(name = "name") String name){
        return this.mockTabsinStorage.stream()
                .filter(tabsin -> tabsin.getName().equals(name))
                .collect(Collectors.toSet());
    }
    
    public DataFetcher<String> fetchCustomers() {
        return environment -> {
        	try {
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.writeValueAsString(staticValues);
            } catch (JsonProcessingException e) {
                log.error("There was a problem fetching the Tabsin!");
                throw new RuntimeException(e);
            }
        };
    }
}
