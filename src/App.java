class App {
  public static void main(String[] args) {
    Book aBook = new Book("https://www.gutenberg.org/cache/epub/30368/pg30368.txt");
    System.out.println("Word count = " + aBook.countWords());
    
  
  }
}
