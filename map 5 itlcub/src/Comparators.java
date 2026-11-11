import java.util.Comparator;

public class Comparators {                                    // Block C: 3 custom Comparators
    public static final Comparator<ITClub> BY_NAME = Comparator.comparing(ITClub::getName);
    public static final Comparator<ITClub> BY_COURSE_THEN_NAME =
            Comparator.comparingInt(ITClub::getCourse).thenComparing(ITClub::getName);
    public static final Comparator<ITClub> BY_DEPT_THEN_COURSE_DESC =
            Comparator.comparing(ITClub::getDepartment)
                    .thenComparing(Comparator.comparingInt(ITClub::getCourse).reversed());
}

