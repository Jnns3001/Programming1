public class debug {
    public static void main(String[] args) {
        String[] days = {"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};
        for (int year = 2000; year < 2023; year++) {
            for (int month = 1; month <= 12; month++) {
                int day = ExerciseSet03.getDayOfTheWeek(1,month,year);
                System.out.print("1." + month + "." + year + ": " + day + " ");
                System.out.println(days[day - 1]);
                ExerciseSet03.printCalendar(month, year);
                System.out.println();
            }
        }
    }
}
