import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.net.URL;

public class readBook {
  public void read(){
    try{
        Scanner in = new Scanner(new File("https://www.gutenberg.org/cache/epub/6130/pg6130.txt"));
    }
    catch(IOException e){
        System.out.println("Error in Opening Scanner");
    }

    }
}

