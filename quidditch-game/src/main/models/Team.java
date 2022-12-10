package src.main.models;

import java.util.Arrays;
import java.util.Objects;

public class Team {

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    public Team(String house, String keeper, String seeker, String[] chasers) {

        if (house == null || keeper == null || seeker == null || chasers == null) {
            throw new IllegalArgumentException("Fields cannot be null");
        }
        if (house.isBlank() || keeper.isBlank() || seeker.isBlank()) {
            throw new IllegalArgumentException("Fields cannot be blank");
        }
        if (chasers.length != 3) {
            throw new IllegalStateException("Chasers cannot be less than 3");
        }
        if (Team.hasBlank(chasers)) {
            throw new IllegalArgumentException("");
        }
        if (Team.hasNull(chasers)) {
            throw new IllegalArgumentException();
        }

        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team(Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.keeper;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
    }

    public String getHouse() {
        return this.house;
    }

    public String getKeeper() {
        return this.keeper;
    }

    public String getSeeker() {
        return this.seeker;
    }

    public String[] getChasers() {
        return Arrays.copyOf(this.chasers, chasers.length);
    }

    public void setHouse(String house) {
        this.checkParam(house);
        this.house = house;
    }

    public void setKeeper(String keeper) {
        this.checkParam(keeper);
        this.keeper = keeper;
    }

    public void setSeeker(String seeker) {
        this.checkParam(seeker);
        this.seeker = seeker;
    }

    public void setChasers(String[] chasers) {
        if (Team.hasNull(chasers) || Team.hasBlank(chasers)) {
            throw new IllegalArgumentException(chasers + " cannot be null");
        }
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public void checkParam(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException(param + " cannot be null or blank");
        }
    }

    /*
     * FREQUENTLY ASKED QUESTIONS:
     * 
     * Question: the constants are final, so why can't we make them public? It's not
     * possible for the caller to update them.
     * Answer: Even if the constant is final, I prefer to expose a method instead of
     * the variable. But if you want to expose the variable, that's also correct.
     * 
     */

    public static String getPositionChaser() {
        return POSITION_CHASER;
    }

    public static String getPositionSeeker() {
        return POSITION_SEEKER;
    }

    public static String getPositionKeeper() {
        return POSITION_KEEPER;
    }

    public static boolean hasNull(String[] array) {
        return Arrays.stream(array)
                .anyMatch((element) -> element == null);

    }

    public static boolean hasBlank(String[] array) {
        return Arrays.stream(array)
                .anyMatch((element) -> element.isBlank());

        // for (int i = 0; i < array.length; i++) {
        // if (array[i].isBlank()) {
        // return true;
        // }
        // }
        // return false;
    }

    public String toString() {
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: " + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Team)) {
            return false;
        }
        Team team = (Team) obj;
        return this.house.equals(team.house) &&
                this.keeper.equals(team.keeper) && 
                this.keeper.equals(team.keeper) && 
                this.seeker.equals(team.seeker) &&
                Arrays.toString(this.chasers).equals(Arrays.toString(team.chasers));
    }

    public int hashCode() {
        return Objects.hash(house, keeper, seeker, Arrays.toString(this.chasers));
    }

}
