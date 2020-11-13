package io.zeebe;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;


@Data
public class Tabsin {

	@GraphQLQuery(name = "id")
	Long id;
	@GraphQLQuery(name = "name")
	String name;
	
	
	
	
}
