package io.zeebe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class TabsinNotFoundException extends RuntimeException implements GraphQLError {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4476214263898260620L;
	private Map<String, Object> extensions = new HashMap<>();

    public TabsinNotFoundException(String message, Long invalidBookId) {
        super(message);
        extensions.put("invalidBookId", invalidBookId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}

