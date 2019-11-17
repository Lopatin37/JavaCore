package Lesson_1.Marathon;

public class Course
{
    private Obstacle[] obstacle;

    public Course()
    {
        obstacle = new Obstacle[]{new Cross(80), new Water(2), new Wall(1), new Cross(120)};
    }

    public Course(Obstacle...obstacle)
    {
        this.obstacle = obstacle;
    }
    public void doIt(Team team)
    {
        for(Obstacle obs : obstacle)
            for (Competitor comp : team.getCompetitor())
                if (comp.isOnDistance()) obs.doIt(comp);
    }
}
