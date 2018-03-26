package reader.criteria;

import java.util.ArrayList;
import java.util.List;

public class Both implements Criterion {
    private List<Criterion> criteria = new ArrayList<Criterion>();

    public Both(Criterion c1, Criterion c2) {
        criteria.add(c1);
        criteria.add(c2);
    }

    @Override
    public boolean complies(String line) {
        for (Criterion c: criteria) {
            if (!c.complies(line)) {
                return false;
            }
        }
        return true;
    }
}
