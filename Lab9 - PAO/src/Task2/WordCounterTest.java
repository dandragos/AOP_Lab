package Task2;

public class WordCounterTest {

    public static void main(String[] args) {

        WordCounter wordCounter = new WordCounterImpl();


        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";


        wordCounter.parse(text);


        System.out.println("Numarul de apariții pentru cuvinte:");
        System.out.println("Lorem: " + wordCounter.getCount("Lorem"));
        System.out.println("dolor: " + wordCounter.getCount("dolor"));
        System.out.println("sit: " + wordCounter.getCount("sit"));


        System.out.println("\nCuvinte unice:");
        wordCounter.getUniqueWords().forEach(System.out::println);


        System.out.println("\nNumărul de apariții pentru toate cuvintele:");
        wordCounter.printWordCounts();


        wordCounter.reset();
    }
}
