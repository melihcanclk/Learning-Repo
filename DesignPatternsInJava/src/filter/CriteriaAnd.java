package filter;

import java.util.List;

public class CriteriaAnd implements Criteria{
    private final Criteria criteria;
    private final Criteria otherCriteria;

    public CriteriaAnd(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }
    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> firstCriteriaPersons = criteria.meetCriteria(personList);
        return otherCriteria.meetCriteria(firstCriteriaPersons);
    }
}
