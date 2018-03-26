import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private List<Participant> participants = new ArrayList<Participant>();
    private List<JumpRound> jumpRounds = new ArrayList<JumpRound>();

    public void addParticipant(String name) {
        Participant participant = new Participant(name);
        this.participants.add(participant);
    }

    public JumpRound round() {
        System.out.println(this.participants);
        List<Participant> participantsCopy = new ArrayList<Participant>(this.participants);
        JumpRound jumpRound = new JumpRound(participantsCopy, jumpRounds.size()+1);
        this.jumpRounds.add(jumpRound);
        return jumpRound;
    }

    public List<JumpRound> getJumpRounds() {
        return this.jumpRounds;
    }
}
