package Lesson_1.Marathon;

public interface Competitor {
    String getName();
    void run(int dist);
    void swim(int dist);
    void jump(int height);
    boolean isOnDistance();
    void info();
}