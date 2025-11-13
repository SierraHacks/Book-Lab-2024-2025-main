//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;




public class Book
{
  private String book;

  public Book(String url){
    readBook(url);
  }

  public String pigLatin(String word)
  {
    if (word.length() == 0) return "";

    // Handle hyphenated words
    if (word.contains("-")) {
        String[] parts = word.split("-");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = pigLatin(parts[i]);
        }
        return String.join("-", parts);
    }

    String puncStore = "";

    // store trailing punctuation
    while (!word.isEmpty() && !Character.isLetterOrDigit(word.charAt(word.length() - 1))) {
        puncStore = word.charAt(word.length() - 1) + puncStore;
        word = word.substring(0, word.length() - 1);
    }

    if (word.isEmpty()) return puncStore; // just punctuation, e.g. "..."

    boolean isCapitalized = Character.isUpperCase(word.charAt(0));

    int firstVowel = -1;
    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if ("aeiouAEIOU".indexOf(c) != -1) {
            firstVowel = i;
            break;
        }
    }

    String newWord;
    if (firstVowel == 0) {
        newWord = word + "yay";
    } else if (firstVowel > 0) {
        newWord = word.substring(firstVowel) + word.substring(0, firstVowel) + "ay";
    } else {
        newWord = word + "ay"; // no vowels
    }

    if (isCapitalized) {
        newWord = newWord.substring(0, 1).toUpperCase() + newWord.substring(1).toLowerCase();
    }

    return newWord + puncStore;
  }
      
    
    
  
  
  public int endPunctuation(String word)  //return the index of where the punctuation is at the end of a String. If it is all punctuation return 0, if there is no punctuation return -1
  {

    return -1;
  }

  public String translateWord(String word)    //to share with class
  {
    String convertedWord = "";

    return convertedWord;
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

    // Handle last word
    if (!retSentence.isEmpty()) {
        if (!finSentence.isEmpty()) finSentence += " ";
        finSentence += pigLatin(retSentence);
    }

    return finSentence;
  }
}  
