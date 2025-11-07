//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...

import java.util.Arrays;

public class Book
{
  public String pigLatin(String word)
  {
    String[] vowStrings = {"a","e","i","o","u","A","E","I","O","U"};
    String[] puncStrings = {"?","!",".",";",":"};
    String[] digStrings = {"0","1","2","3","4","5","6","7","8","9"};
    String newWord = "";
    String puncStore = "";
    
    

    if(word.length()==0){
      newWord= word;
      return newWord;
    }
  
    for (int i=0; i<puncStrings.length;i++){
      if(word.contains(puncStrings[i])){
        puncStore += word.substring(word.indexOf(puncStrings[i]));
        word = word.substring(0,word.indexOf(puncStrings[i]));
        break;
      }
      
    }
    

    for (int i=0; i<vowStrings.length; i++){
      if(word.contains(vowStrings[i])){
        newWord= word.substring(word.indexOf(vowStrings[i]))+word.substring(0,word.indexOf(vowStrings[i]))+"ay";
        break;
      }
      else if(!word.contains(vowStrings[i])){
        if(i==vowStrings.length-1){
          newWord = word + "ay";
          }
      }
    }
    if(Arrays.asList(vowStrings).contains(word.substring(0,1))){
      newWord = word+"yay";
    }
    
    
    
    
    for (int i=0; i<newWord.length(); i++){
      char c = newWord.charAt(i);
      if(Character.isUpperCase(c)){
        newWord = newWord.toLowerCase();
        newWord = newWord.substring(0,1).toUpperCase() + newWord.substring(1);
        }
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
    String retSentence = sentence;
    String finSentence = "";

    int sent = sentence.indexOf(" ");

    while(sent>=0){
      String word = retSentence.substring(0,sent);
      finSentence = pigLatin(word) + " ";
      
      retSentence = sentence.substring(sent+1);
      sent = sentence.indexOf(" ");
      
    }
    if(sent==-1){
      String word = sentence;
      pigLatin(word);
      retSentence = 
    }

    


    return retSentence;
  }
}  
