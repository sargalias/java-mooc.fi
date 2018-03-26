import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    private Tournament tournament = new Tournament();

    public UserInterface(Scanner reader) {
        this.reader = reader;
    }

    public void start() {
        // Set up
        System.out.println("Kumpula ski jumping week");
        collectParticipants();
        // Tournament intro
        System.out.println("The tournament begins!");
        runRounds();
    }

    private void collectParticipants() {
        // Collect participants phase
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.println("  Participant name: ");
            String command = reader.nextLine();
            if (command.equals("")) {
                break;
            }
            this.tournament.addParticipant(command);
        }
    }

    private void runRounds() {
        // Tournament running
        while (true) {
            System.out.println("Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();
            if (!command.equals("jump")) {
                break;
            }
            JumpRound jumpRound = this.tournament.round();
            System.out.println("Round " + jumpRound.getRoundNumber());
            System.out.println("Jumping order:");
            List<Participant> participants = jumpRound.getParticipantOrder();
            for (int i=0; i<participants.size(); i++) {
                System.out.println("  " + (i+1) + ". " + participants.get(i).toString());
            }
            // print results of round
            jumpRound.performRound();
            System.out.println("Results of round " + jumpRound.getRoundNumber());
            for (int i=0; i<participants.size(); i++) {
                System.out.println("  " + participants.get(i).getName());
                System.out.println(participants.get(i).getLastJump().toString());
            }
        }
    }

    public void printJumpOrder(JumpRound jumpRound) {
        List<Participant> participants = jumpRound.getParticipantOrder();
        for (int i=0; i<participants.size(); i++) {
            System.out.println("  " + (i+1) + ". " + participants.get(i).toString());
        }
    }

    private void results() {
        System.out.println("Thanks!");

        // print tournament results
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
    }
}
