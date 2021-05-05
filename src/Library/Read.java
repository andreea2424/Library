package Library;

import java.io.*;
import java.util.Scanner;

public class Read {
    private Scanner in;
    private PrintStream out;

    public Read(Scanner in, PrintStream out){
        this.in = in;
        this.out = out;
    }

    public void display(String file ){
        String path = "C:/Users/Andreea Stanciu/Desktop/"+file+".csv";
        String line =" ";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine())!=null){
                System.out.println(line);
            }

        }catch (
                FileNotFoundException e){
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }}


    public int getIntLn(){
        int nr = in.nextInt();
        String emp = in.nextLine();
        return nr;
    }

    public int getPositiveIntLn(){
        int nr = -1;
        try {
            nr = in.nextInt();
            String emp = in.nextLine();
            return nr;
        }
        catch (Exception e){
            String emp = in.nextLine();
            return -1;
        }
    }

    public int getInt(){
        return in.nextInt();
    }

    public String getLine(){
        return in.nextLine();
    }

    public String displayText (String text){
        out.println(text);
        String input = in.nextLine();

        while (input.length() == 0){
            out.println(text );
            input = in.nextLine();
        }

        return input;
    }
    public int displayTextforInt (String text){
        out.println(text);
        int input = in.nextInt();

        return input;
    }
}
