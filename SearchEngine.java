import java.io.*;
import java.util.*;

class SearchEngine {
   private File searchFile;
  private String userQuestion;
   HashMap<String, Integer> wordTracker = new HashMap<String, Integer>();

  public SearchEngine()
  {
    searchFile = getFileContents();
    userQuestion = "";
  }

  // Gets the contents of the file and returns a file object.  
  File getFileContents()
  {
    File file = null;
    try
    {
      Scanner question = new Scanner(System.in);  // Create a Scanner object
      System.out.println("Enter your question: ");
      userQuestion = question.nextLine();
      System.out.println();
      System.out.print("Enter name of the file> ");
      Scanner scan = new Scanner(System.in);
      file = new File(scan.nextLine());
      System.out.println();
    }
    catch (Exception e)
    {
      System.out.println("Caught error in getFiles: " + e.toString());
    }
    return file;
  }

  // Updates the wordCount for each words. 
  void updateWordCount (String word){
    if (wordTracker.containsKey(word)){
      int currentCount = wordTracker.get(word);
      wordTracker.put(word, currentCount+1);  
    }
    else{
      wordTracker.put(word,1);
    }
  }
// Loops through map to find the key value for max word count. 
  String returnKeyWithMaxValueInWordTracker(){
     int maxValueInMap=(Collections.max(wordTracker.values())); 
    for (Map.Entry<String, Integer> entry: wordTracker.entrySet()) {  
            if (entry.getValue()==maxValueInMap) {
                return entry.getKey(); 
            }
        }
  return "No results found";
  }

  // The function goes through the file and returns the highest number of repeated   words. 
  // We are going to assume that we only have one correct Answer. 
  String returnAnswer(){
    String answer = "";
    try 
    {
      Scanner searchFileScanner = new Scanner (searchFile);
      String prevWord = "a";
      String inputWord = "a";
    
      while (searchFileScanner.hasNextLine())
        {    
        StringTokenizer searchFileStringtokens = new StringTokenizer(searchFileScanner.nextLine());
          while (searchFileStringtokens.hasMoreTokens()){
            prevWord = inputWord;
            inputWord = searchFileStringtokens.nextToken();
           // Check if the first letter of the input word is uppercase. 
            if (Character.isUpperCase(inputWord.charAt(0))){
                // Check if the first letter of the previous word was uppercase. 
              if (Character.isUpperCase(prevWord.charAt(0))){
                String combinedWord  = prevWord + " " + inputWord;
                  updateWordCount(combinedWord); 
              }
            }
          }
        }
      searchFileScanner.close();
    }
    // Catch errros if any.
    catch(Exception e)
    {
      System.out.println("Error while getting answers:  " + e.toString());
    }
  return returnKeyWithMaxValueInWordTracker();
  }

  
// Responsible for starting the program. 
  void start(){
   String output  = returnAnswer();
    System.out.println("Answer: "+output);
  }
  
  
}