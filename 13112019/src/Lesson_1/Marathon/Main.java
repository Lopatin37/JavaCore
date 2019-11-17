package Lesson_1.Marathon;

public class Main {
    public static void main(String[] args) {
        Team team = new Team("The best team");
        Course course = new Course();
        //Можно использовать два вида конструкторов Course
        //Course course = new Course(new Cross(80), new Water(2));
        course.doIt(team);
        //team.fullInfo();
        team.winnersInfo();
    }
}