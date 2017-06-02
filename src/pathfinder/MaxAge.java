package pathfinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MaxAge {
    private enum Race {
        DWARF(2, 100, 250),
        ELF(4, 100, 350),
        GNOME(3, 100, 200),
        HALFLING(5, 20, 100),
        HUMAN(2, 20, 70),
        ORC(2, 10, 60),
        NULL(0, 0, 0);

        private static final Map<String, Race> stringToEnum = Collections.<String, Race> unmodifiableMap(buildMap());
        private static final Random roll = new Random();

        private int dice;
        private int die;
        private int modifier;

        private Race(int dice, int die, int modifier) {
            this.dice = dice;
            this.die = die;
            this.modifier = modifier;
        }

        private static Map<String, Race> buildMap() {
            Map<String, Race> map = new HashMap<String, Race>();
            for (Race race : values()) {
                map.put(race.name().toLowerCase(), race);
            }
            map.remove(Race.NULL);
            return map;
        }

        public static Race fromString(String string) {
            if (!stringToEnum.containsKey(string)) {
                return Race.NULL;
            }
            return stringToEnum.get(string);
        }

        public int roll() {
            int age = modifier;
            for (int i = 0; i < dice; ++i) {
                age += roll.nextInt(die) + 1;
            }
            return age;
        }
    }

    private static final class Input {
        private Race race = Race.NULL;
        private int amount;

        public Input(String arg) {
            String[] parts = arg.split(":");
            try {
                this.race = Race.fromString(parts[0].toLowerCase());
                this.amount = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Expected <RACE>:<INTEGER>, got " + arg + ".");
            }
        }

        public Race race() {
            return race;
        }

        public int amount() {
            return amount;
        }

        public boolean isNull() {
            return race == Race.NULL;
        }

        public void add(Input other) {
            this.amount += other.amount();
        }

        private final class InvalidInputException extends RuntimeException {

            /**
             * Serial ID.
             */
            private static final long serialVersionUID = 5734040854438935870L;

            public InvalidInputException(String message) {
                super(message);
            }

        }
    }

    public static void main(String[] args) {
        List<Input> argList = new ArrayList<Input>();
        for (String arg : args) {
            Input in = new Input(arg);
            if (!in.isNull()) {
                argList.add(in);
            }
        }

        Map<Race, Input> inputs = new LinkedHashMap<Race, Input>();
        for (Input in : argList) {
            Race race = in.race();
            if (inputs.containsKey(race)) {
                inputs.get(race).add(in);
            } else {
                inputs.put(race, in);
            }
        }

        // TODO: Sort keys.
        for (Race race : inputs.keySet()) {
            StringBuilder rolls = new StringBuilder("[");
            String prefix = "";
            for (int i = 0; i < inputs.get(race).amount(); ++i) {
                rolls.append(prefix + race.roll());
                prefix = ", ";
            }

            System.out.println(race + "\t" + rolls.append("]").toString());
        }
    }
}
