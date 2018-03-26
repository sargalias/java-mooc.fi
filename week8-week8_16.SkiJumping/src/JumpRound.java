import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JumpRound {
    private List<Participant> jumpOrder;
    private Map<Participant, Jump> roundJumps = new HashMap<Participant, Jump>();
    private int roundNumber;

    public JumpRound(List<Participant> participants, int roundNumber) {
        sortParticipants(participants);
        this.jumpOrder = participants;
        this.roundNumber = roundNumber;
    }

    public void performRound() {
        for (Participant participant : this.jumpOrder) {
            Jump jump = new Jump();
            participant.addJump(jump);
            this.roundJumps.put(participant, jump);
        }
    }

    public void sortParticipants(List<Participant> participants) {
        Collections.sort(participants);
        Collections.reverse(participants);
    }

    public List<Participant> getParticipantOrder() {
        return this.jumpOrder;
    }

    public int getRoundNumber() {
        return this.roundNumber;
    }

    public Map<Participant, Jump> getRoundJumps() {
        return this.roundJumps;
    }
}
