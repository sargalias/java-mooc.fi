import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingingCentre {
    private Map<Bird, List<String>> observations = new HashMap<Bird, List<String>>();

    public void observe(Bird bird, String place) {
        this.observations.putIfAbsent(bird, new ArrayList<String>());
        this.observations.get(bird).add(place);
    }

    public void observations(Bird bird) {
        List<String> obs = this.observations.get(bird);
        if (obs == null) {
            System.out.println(bird + " observations: " + 0);
        } else {
            System.out.println(bird + " observations: " + obs.size());
            for (String observation : obs) {
                System.out.println(observation);
            }
        }
    }
}
