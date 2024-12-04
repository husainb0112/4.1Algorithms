public class Main {
    public static void main(String[] args) {
        int count = 0;
        for (Integer number : listOfIntegers) {
            if (number < 100) {
                count++;
            }
        }
        
        // print the count
        System.out.println("Number of items in the list less than 100: " + count);
    }
}