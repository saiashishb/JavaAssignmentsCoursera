package SolvingProblemsInJava;

public class Week2SecondAssignmentPart2
{
    public int howMany(String stringA, String stringB)
    {
        int totalOccurrences = 0;
        int startIndex = 0;
        while(true)
        {
            int index = stringB.indexOf(stringA, startIndex);
            if (index == -1)
            {
                break;
            }
            totalOccurrences++;
            startIndex = index + stringA.length();
        }
        return totalOccurrences;
    }

    public void testHowMany() {
        String stringA = "AAT";
        String stringB = "GAACGAATTGAATC";
        System.out.println("Total occurences of " + stringA + " in " + stringB + " = " + howMany(stringA, stringB));
        stringA = "AAA";
        stringB = "ATAAAA";
        System.out.println("Total occurences of " + stringA + " in " + stringB + " = " + howMany(stringA, stringB));
    }
}