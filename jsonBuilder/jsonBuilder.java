import java.util.*;
import java.io.*;

public class jsonBuilder {
    
    public static void main(String[] args) throws FileNotFoundException,NoSuchElementException {
        Scanner console = new Scanner(System.in);
        
        System.out.print("Enter input filename: ");
        Scanner input = new Scanner(new File(console.next()));
        
        //input file
        //Scanner input = new Scanner(new File("F&R2011-2012.txt"));
        
        //create output file
        File fout = new File("output.txt");
        PrintStream output = new PrintStream(fout);
        
        input.useDelimiter("\t");
        
        output.print("[");
        while(input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter("\t");
            String name = lineScan.next();
            String type = lineScan.next();
            String pop2011 = lineScan.next();
            String fr2011 = lineScan.next();
            String minor2011 = lineScan.next();
            String pop2012 = lineScan.next();
            String fr2012 = lineScan.next();
            String minor2012 = lineScan.next();
            
            output.println("{\n\"name\":" + "\"" + name + "\",\n\"level\":\"" + type + "\",\n\"fr\":[\n[2011," + fr2011 + "],\n[2012," + fr2012 + "]\n],\n\"population\": [\n[2011," + pop2011 + "],\n[2012," + pop2012 + "]],\n \"minority\": [\n[2011," + minor2011 + "],\n[2012," + minor2012 + "]\n]\n},");
            lineScan.close();
        }
        
        output.println("]");
        input.close();
        output.close();
    }
    
}
