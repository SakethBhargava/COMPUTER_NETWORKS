import java.io.*;
import java.net.*;
public class HTTP {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.geeksforgeeks.org");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("index.html"));
        String line;
        while ((line = reader.readLine())!=null)
        {
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
        System.out.println("Succesfully Downloaded.");
    }
}

