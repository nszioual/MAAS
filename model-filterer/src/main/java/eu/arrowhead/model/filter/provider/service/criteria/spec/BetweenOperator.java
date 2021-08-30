package eu.arrowhead.model.filter.provider.service.criteria.spec;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BetweenOperator extends Object {
    private int lower;
    private int upper;
}
