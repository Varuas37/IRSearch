/******************************************************************
 
   Name: Saurav Panthee
   Course/Section:       COSC 4315.001
   Instructor:           Dr. Brown
   Program Description: 
    The following program takes a question and a filename as a user input and returns the
    answer to the question asked by the user. 
    PROCESS
    SearchEngine class is responsible for all the implementation. 
    We were told that the question will always be looking the identity of a person. 
    As a name will contain two or more consecutive terms with each term having the first
    letter capitalized, as we are reading the words from the file we keep track of words that are 
    capitalized and if they are, we check if the word before that was also capitalized.
    If we find that two consequetive words are capitalized, we store them in a hashmap with the words as the key
    and the frequency with which they repeat as the values. 
    We keep on increasing the count of the words if they repeat. And finally return the word with the most count. 
  OTHER NOTES: 
    The program works on my end. I am using MacOS but I have no ways of testing it on windows laptop.
    I used replit to write code and you can find the working demo here: https://replit.com/@Varuas19/IRSearch#Main.java 
    (It contains all the same files)
 ******************************************************************/
class Main {
  public static void main(String[] args) {
    SearchEngine searchEngine = new SearchEngine();
    searchEngine.start();
  }
}