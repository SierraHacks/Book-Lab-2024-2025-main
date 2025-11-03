//A few assumptions.......

//Words will be separated by spaces. 
//There can be punctuation in a word, we will only add/keep punctuation at the end of a string if it is at the end of a string.
//    for examples: Hello.==> Ellohay.    Good-bye! ==> Ood-byegay!    so... ==> osay...

import java.util.Arrays;

public class Book
{
  public String pigLatin(String word)
  {
    String[] vowStrings = {"a","e","i","o","u"};
    String[] puncStrings = {"!",".",";",":","?", "\""};
    String[] digStrings = {"0","1","2","3","4","5","6","7","8","9"};
    
    if(word.length()==0){
      return word;
    }
    
    if(Arrays.asList(vowStrings).contains(word.substring(0,1))){
      return word+"ay";
    }
    else {
      for (int i=0; i<vowStrings.length; i++){
        if(word.contains(vowStrings[i])){
          return word.substring(word.indexOf(vowStrings[i]))+word.substring(0,word.indexOf(vowStrings[i]))+"ay";
        }
      }
    }
    
    return word + "ay";
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
    String retSentence = "";


    return retSentence;
  }
}  
