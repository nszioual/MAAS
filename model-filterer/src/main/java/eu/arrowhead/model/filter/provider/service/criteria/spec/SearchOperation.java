package eu.arrowhead.model.filter.provider.service.criteria.spec;

public enum SearchOperation {
    GREATER_THAN, LESS_THAN, GREATER_THAN_EQUAL, LESS_THAN_EQUAL, NOT_EQUAL, EQUAL, BETWEEN, LIKE;

    public static final String[] OPERATION_SET = {">", "<", "!", "=", "~"};

    public static SearchOperation getSearchOperation(final String input) {
        if (input.equals(OPERATION_SET[0])) {
            return GREATER_THAN;
        } else if (input.equals(OPERATION_SET[1])){
            return LESS_THAN;
        } else if (input.equals(OPERATION_SET[2])) {
            return NOT_EQUAL;
        } else if (input.equals(OPERATION_SET[3])) {
            return EQUAL;
        } else if (input.equals(OPERATION_SET[4])) {
            return LIKE;
        }
        return null;
    }
}

