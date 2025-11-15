import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Book {

    private String book = "";

    public Book(String url){
        readBook(url);
        System.out.println(translateBook());
    }

    private void readBook(String link){
        try {
            URL url = new URL(link);
            Scanner s = new Scanner(url.openStream());

            while (s.hasNextLine()) {
                String line = s.nextLine();
                book += line + "\n";  
            }

            s.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String translateBook() {
        Scanner s = new Scanner(book);
        StringBuilder result = new StringBuilder();

        while (s.hasNextLine()) {
            String line = s.nextLine();
            result.append(translateSentence(line));
            result.append("\n");
        }

        s.close();
        return result.toString();
    }

    public String translateSentence(String sentence)
    {
        String finSentence = "";
        String retSentence = sentence.trim();

        while (retSentence.contains(" ")) {
            int sent = retSentence.indexOf(" ");
            String word = retSentence.substring(0, sent);
            if (!finSentence.isEmpty()) finSentence += " ";
            finSentence += pigLatin(word);
            retSentence = retSentence.substring(sent + 1);
        }

        if (!retSentence.isEmpty()) {
            if (!finSentence.isEmpty()) finSentence += " ";
            finSentence += pigLatin(retSentence);
        }

        return finSentence;
    }


    public String pigLatin(String word)
    {
        if (word.length() == 0) return "";

        int hyphenIndex = word.indexOf('-');
        if (hyphenIndex != -1) {
            String left = pigLatin(word.substring(0, hyphenIndex));
            String right = pigLatin(word.substring(hyphenIndex + 1));
            return left + "-" + right;
        }

        String puncStore = "";
        while (!word.isEmpty() && !Character.isLetterOrDigit(word.charAt(word.length() - 1))) {
            puncStore = word.charAt(word.length() - 1) + puncStore;
            word = word.substring(0, word.length() - 1);
        }

        if (word.isEmpty()) return puncStore;

        boolean isCapitalized = Character.isUpperCase(word.charAt(0));

        String lower = word.toLowerCase();

        int firstVowel = -1;
        for (int i = 0; i < lower.length(); i++) {
            if ("aeiou".indexOf(lower.charAt(i)) != -1) {
                firstVowel = i;
                break;
            }
        }

        String newWord;
        if (firstVowel == 0) {
            newWord = lower + "yay";
        } else if (firstVowel > 0) {
            newWord = lower.substring(firstVowel) +
                      lower.substring(0, firstVowel) +
                      "ay";
        } else {
            newWord = lower + "ay";
        }

        if (isCapitalized) {
            newWord = Character.toUpperCase(newWord.charAt(0)) + newWord.substring(1);
        }

        return newWord + puncStore;
    }

    public int countWords() {
      Scanner s = new Scanner(book);
      int count = 0;
      while (s.hasNext()) {
        s.next();
        count++;
      }
      s.close();
      return count;
    
    }
       
}