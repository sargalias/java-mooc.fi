package reader.criteria;

import java.util.ArrayList;
import java.util.List;

public class AtLeastOne implements Criterion {
    private List<Criterion> criteria = new ArrayList<Criterion>();

    public AtLeastOne(Criterion... criteria) {
        for (Criterion c : criteria) {
            this.criteria.add(c);
        }
    }

    @Override
    public boolean complies(String line) {
        for (Criterion c : criteria) {
            if (c.complies(line)) {
                return true;
            }
        }
        return false;
    }
}
