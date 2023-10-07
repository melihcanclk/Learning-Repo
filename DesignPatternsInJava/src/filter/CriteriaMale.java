package filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> malePersons = new ArrayList<>();
        for(Person person: personList) {
            if(person.getGender().equalsIgnoreCase("male")){
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
