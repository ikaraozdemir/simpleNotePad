import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scanner = new Scanner (System.in);
        System.out.print("Notunuz: ");
        String myNote = scanner.nextLine();

        //Girilen metni dosyaya yazdırır. Yeni not girilirse dosya içinde bulunan önceki notların altına ekmeme yapar.
       try (BufferedWriter myBfWriter = new BufferedWriter(new FileWriter("myNotes.txt",true)))
       {
           myBfWriter.write(myNote);
           myBfWriter.newLine();

       } catch (IOException e){
           e.printStackTrace();
       }
        // Girilen notları dosya içinden okur ve yazdırır.
       try (BufferedReader myBfReader = new BufferedReader(new FileReader("myNotes.txt")))
       {
            String line;
            while ((line = myBfReader.readLine()) != null){
                System.out.println(line);
            }
       }catch (IOException e){
           e.printStackTrace();
       }
    }
}