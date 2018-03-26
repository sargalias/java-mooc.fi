package reader.criteria;

public class Not implements Criterion {
    private Criterion c;

    public Not(Criterion c) {
        this.c = c;
    }

    @Override
    public boolean complies(String line) {
        return !c.complies(line);
    }
}
