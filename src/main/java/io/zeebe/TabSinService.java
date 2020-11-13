package io.zeebe;

import java.io.IOException;

import org.springframework.stereotype.Service;

import graphql.GraphQL;

/**
 * 
 * @author brunolopes
 *  data access do operate for the tabsin object
 */
@Service	
public class TabSinService {

    private GraphQL graphQL;

    
    public GraphQL graphQL() { 
        return graphQL;
    }

    
    public void init() throws IOException {
//    	 to load graphQL schema
//        URL url = Resources.getResource("schema.graphqls");
//        String sdl = Resources.toString(url, Charsets.UTF_8);
//        GraphQLSchema graphQLSchema = buildSchema(sdl);
//        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

//    @Autowired
//    Tabsin graphQLDataFetchers;
//
//    private GraphQLSchema buildSchema(String sdl) {
//        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
//        RuntimeWiring runtimeWiring = buildWiring();
//        SchemaGenerator schemaGenerator = new SchemaGenerator();
//        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
//    }
//
//    private RuntimeWiring buildWiring() {
//        return RuntimeWiring.newRuntimeWiring()
//                .type(newTypeWiring("Tabsin")
//                        .dataFetcher("statics", graphQLDataFetchers.getStaticValues()))
//                .build();
//    }
}