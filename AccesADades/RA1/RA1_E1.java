import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalisiText {

    public static void main(String[] args) {
        String filename = "text.txt";

        int charCount = 0;
        int lineCount = 0;
        int wordCount = 0;
        boolean isInWord = false;

        // Hashmap to store char-frecuency value pairs
        Map<Character, Integer> frecuency = new HashMap<>();

        boolean hasContent = false;
        char lastChar = ' ';

        try (FileReader fr = new FileReader(filename)) {
            int c;

            while ((c = fr.read()) != -1) {
                hasContent = true;
                char character = (char) c;
                lastChar = character;

                // Char counting
                if (character != '\n' && character != '\r') {
                    charCount++;
                }

                // Line counting
                if (character == '\n') {
                    lineCount++;
                }

                // Detect if it is a separator
                boolean isSeparator = (character == ' ' || character == '\t' || character == '\n' || character == '\r');

                // Word counting
                if (isSeparator) {
                    isInWord = false;
                } else {
                    if (!isInWord) {
                        wordCount++;
                        isInWord = true;
                    }

                    // Frecuency counting with Hashmap
                    // getOrDefault obtains current value or 0 if it has not appeared yet
                    int comptadorActual = frecuency.getOrDefault(character, 0);
                    frecuency.put(character, comptadorActual + 1);
                }
            }

            // If file does not end with a line jump, last line is counted
            if (hasContent && lastChar != '\n' && lastChar != '\r') {
                lineCount++;
            }

            // Find the most repeated character in Hashmap
            char characterMesRepetit = ' ';
            int maxfrecuency = 0;

            for (Map.Entry<Character, Integer> entrada : frecuency.entrySet()) {
                if (entrada.getValue() > maxfrecuency) {
                    maxfrecuency = entrada.getValue();
                    characterMesRepetit = entrada.getKey();
                }
            }

            // Show results
            System.out.println("Character count: " + charCount);
            System.out.println("Line count: " + lineCount);
            System.out.println("Word count: " + wordCount);

            if (maxfrecuency > 0) {
                System.out.println("Most repeated character: " + characterMesRepetit);
            } else {
                System.out.println("Most repeated character (no valid characters found)");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (SecurityException e) {
            System.out.println("Missing file access permissions.");
        } catch (IOException e) {
            System.out.println("A reading error has ocurred: " + e.getMessage());
        }
    }
}