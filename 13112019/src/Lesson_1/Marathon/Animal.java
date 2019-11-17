package Lesson_1.Marathon;

public class Animal implements Competitor {
    private String type;
    private String name;

    private int maxRunDistance;
    private int maxJumpHeight;
    private int maxSwimDistance;

    private boolean onDistance;

    @Override
    public String getName()
    {
        String n = name;
        return n;
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        if(maxRunDistance >= 0) this.maxRunDistance = maxRunDistance;
        else this.maxRunDistance = 0;

        if(maxJumpHeight >= 0) this.maxJumpHeight = maxJumpHeight;
        else this.maxJumpHeight = 0;

        if(maxSwimDistance >= 0) this.maxSwimDistance = maxSwimDistance;
        else this.maxSwimDistance = 0;

        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(type + " " + name + " хорошо справился с кроссом");
        } else {
            System.out.println(type + " " + name + " не справился с кроссом");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.println(type + " " + name + " удачно перепрыгнул через стену");
        } else {
            System.out.println(type + " " + name + " не смог перепрыгнуть стену");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (maxSwimDistance == 0) {
            System.out.println(type + " " + name + " не умеет плавать");
            onDistance = false;
            return;
        }
        if (dist <= maxSwimDistance) {
            System.out.println(type + " " + name + " отлично проплыл");
        } else {
            System.out.println(type + " " + name + " не смог проплыть");
            onDistance = false;
        }
    }

    @Override
    public void info()
    {
        System.out.print(type + " " + name + " - ");
        if(isOnDistance()) {System.out.println("is on distance.");}
        else {System.out.println("is out of distance.");}
    }
}
