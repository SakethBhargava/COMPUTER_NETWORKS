import java.io.*;
import java.net.Socket;
public class ClientFile
{
static public void main(String... args){
try(Socket socket = new Socket("127.0.0.1", 900)){
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    System.out.println("Sending the File to the Server");
    String path = "D://CERTIFICATES//resume.docx";
    int bytes = 0;
    File file = new File(path);
    FileInputStream fin = new FileInputStream(path);
    out.writeLong(file.length());
    byte[] buffer = new byte[4 * 1024];
    while ((bytes = fin.read(buffer))!= -1)
    {
    out.write(buffer, 0, bytes);
    }
  }
catch (Exception e){
e.printStackTrace();
}
System.out.println("Succesfully Sent the file");
}
}