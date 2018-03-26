package dungeon.domain;

import dungeon.Dungeon;

import java.util.ArrayList;
import java.util.List;

public class DungeonDisplay {
    private Dungeon dungeon;

    public DungeonDisplay(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public void displayFrame() {
        printMoves();
        printCoordinates();
        printMap();
    }

    private void printMoves() {
        System.out.println(dungeon.getMoves());
        System.out.println();
    }

    private void printCoordinates() {
        Player player = dungeon.getPlayer();
        List<Movable> vampires = dungeon.getVampires();
        StringBuilder sb = new StringBuilder();

        System.out.println("@ " + player.getX() + " " + player.getY());
        for (Movable vampire : vampires) {
            System.out.println("v " + vampire.getX() + " " + vampire.getY());
        }
        System.out.println();
    }

    private void printMap() {
        List<List<Character>> dungeonMap = initialiseMap();
        populateMap(dungeonMap);
        displayMap(dungeonMap);
    }

    private List<List<Character>> initialiseMap() {
        List<List<Character>> dungeonMap = new ArrayList<List<Character>>();
        for (int i=0; i<dungeon.getLength(); i++) {
            List<Character> column = new ArrayList<Character>();
            for (int j=0; j<dungeon.getHeight(); j++) {
                column.add('.');
            }
            dungeonMap.add(column);
        }
        return dungeonMap;
    }

    private void populateMap(List<List<Character>> dungeonMap) {
        Player player = dungeon.getPlayer();
        List<Movable> vampires = dungeon.getVampires();
        dungeonMap.get(player.getX()).set(player.getY(), '@');
        for (Movable vampire : vampires) {
            dungeonMap.get(vampire.getX()).set(vampire.getY(), 'v');
        }
    }

    private void displayMap(List<List<Character>> dungeonMap) {
        for (int i=0; i<dungeon.getHeight(); i++) {
            for (int j=0; j<dungeon.getLength(); j++) {
                System.out.print(dungeonMap.get(j).get(i));
            }
            System.out.println();
        }
    }
}
