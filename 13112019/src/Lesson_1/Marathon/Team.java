package Lesson_1.Marathon;

public class Team
{
    private String name;
    private Competitor[] competitors;
    public Team(String name)
    {
        this.name = name;
        competitors = new Competitor[]{new Human("Dima"), new Cat("Chicha"), new Dog("Bobo"), new Human("Johny")};

    }

    public String getName()
    {
        String n = name;
        return n;
    }

    public Competitor[] getCompetitor()
    {
        Competitor[] comp;
        comp = competitors;
        return comp;
    }

    //Этот метод выводит инфо обо всех членах команды и смогли ли они пройти дистанцию
    void fullInfo()
    {
        System.out.println("This team includes " + competitors.length + " members:");
        for(Competitor comp : competitors)
            comp.info();
    }
    void  winnersInfo()
    {
        System.out.println("These members could finish the distance: ");
        for(Competitor comp : competitors)
            if (comp.isOnDistance())
                System.out.println(comp.getName());
    }
}
