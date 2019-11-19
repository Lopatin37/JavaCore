package Enum;

enum DayOfWeek
{
    MONDAY(8), TUESDAY(8), WEDNSDAY(8), THURSDAY(8), FRIDAY(8), SATURDAY, SUNDAY;

    private int hoursPerDay;

    DayOfWeek()
    {
        hoursPerDay = 0;
    }

    DayOfWeek(int hours)
    {
        if (hours >= 0) hoursPerDay = hours;
        else hoursPerDay = 0;
    }

    static int getWorkingHours(DayOfWeek day)
    {
        int hours;
        switch (day)
        {
            case MONDAY:
                hours = 40;
                break;
            case TUESDAY:
                hours = 32;
                break;
            case WEDNSDAY:
                hours = 24;
                break;
            case THURSDAY:
                hours = 16;
                break;
            case FRIDAY:
                hours = 8;
                break;
            default:
                hours = 0;
        }
        return hours;
    }
}
