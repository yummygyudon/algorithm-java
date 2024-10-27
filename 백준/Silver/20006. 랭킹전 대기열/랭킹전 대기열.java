import java.io.*;
import java.util.*;

public class Main {
    static class Room {
        int createdAt;
        int criteriaLevel;
        List<Player> players = new ArrayList<>();
        boolean started = false;

        public Room(int createdAt, int criteriaLevel) {
            this.createdAt = createdAt;
            this.criteriaLevel = criteriaLevel;
        }

        public void addPlayer(Player player) {
            players.add(player);
            if (players.size() == LIMIT) {
                started = true;
            }
        }

        public boolean canAddPlayer(int level) {
            return players.size() < LIMIT && Math.abs(criteriaLevel - level) <= 10;
        }
    }

    static class Player {
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static int PLAYER_COUNT;
    static int LIMIT;
    static List<Room> ROOMS = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        PLAYER_COUNT = Integer.parseInt(tokenizer.nextToken());
        LIMIT = Integer.parseInt(tokenizer.nextToken());

        for (int i = 1; i <= PLAYER_COUNT; i++) {
            String[] input = reader.readLine().split(" ");
            int level = Integer.parseInt(input[0]);
            String name = input[1];
            Player player = new Player(level, name);

            Room room = ROOMS.stream()
                    .filter(r -> r.canAddPlayer(level))
                    .min(Comparator.comparingInt(r -> r.createdAt))
                    .orElse(null);

            if (room == null) {
                room = new Room(i, level);
                ROOMS.add(room);
            }
            room.addPlayer(player);
        }

        StringBuilder output = new StringBuilder();
        for (Room room : ROOMS) {
            output.append(room.started ? "Started!\n" : "Waiting!\n");
            room.players.sort(Comparator.comparing(p -> p.name));
            for (Player p : room.players) {
                output.append(p.level).append(" ").append(p.name).append("\n");
            }
        }

        System.out.print(output);
    }
}
