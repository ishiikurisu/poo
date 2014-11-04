import java.io.*;

class Exemplo {
  public static final void main (String[] args) {
    try {
      FileOutputStream file = new FileOutputStream("hello.txt");
      DataOutputStream dos = new DataOutputStream(file);
      dos.writeBytes("hello joe");
      dos.writeByte('\n');
      dos.close();
      file.close();
    }
    catch (FileNotFoundException nft) {
      System.out.println("file not found");
    }
    catch (IOException ioe) {
      System.out.println("io error");
    }
  }
}
