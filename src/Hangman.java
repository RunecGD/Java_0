import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    private static final String[] WORDS = {
            "работа", "программирование", "сенла", "курсы", "математика", "виселица", "софт", "обучение"
    };

    private static final String[] HANGMAN_STAGES = {
            "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n  |   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
            "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
    };

    public static void main(String[] args) {
        Random random = new Random();
        String word = WORDS[random.nextInt(WORDS.length)];
        int lives = 6;
        List<Character> guessedLetters = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(HANGMAN_STAGES[6 - lives]);
            System.out.print("Текущее слово: ");
            displayWord(word, guessedLetters);
            System.out.println("\nЖизней: " + lives);

            if (isWordGuessed(word, guessedLetters)) {
                System.out.println("Поздравляем! Вы угадали слово: " + word);
                break;
            }

            System.out.print("Введите букву: ");
            char guess = scanner.next().charAt(0);
            guessedLetters.add(guess);

            if (!word.contains(String.valueOf(guess))) {
                lives--;
                System.out.println("Неверно. Вы теряете жизнь...");
                if (lives == 0) {
                    System.out.println(HANGMAN_STAGES[6 - lives]);
                    System.out.println("Вы проигрываете. Слово было: " + word);
                    break;
                }
            }
        }

        scanner.close();
    }

    private static void displayWord(String word, List<Character> guessedLetters) {
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                System.out.print(letter + " ");
            } else {
                System.out.print("_ ");
            }
        }
    }

    private static boolean isWordGuessed(String word, List<Character> guessedLetters) {
        for (char letter : word.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }
}
