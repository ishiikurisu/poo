import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Exemplo2 {
  public static final void main(String[] args) {
    try {
      FileInputStream file = new FileInputStream("hello.txt");
      DataInputStream dis = new DataInputStream(file);
      // BufferedReader br = new BufferedReader(file);
      String line;

      line = dis.readLine();
      // line = br.readLine();
      while (line != null) {
        System.out.println(line);
        line = dis.readLine();
      }
      dis.close();
      file.close();
    }
    catch (FileNotFoundException e1) {
      System.out.println("file not found");
    }
    catch (IOException e2) {
      System.out.println("io error");
    }
  }
}
