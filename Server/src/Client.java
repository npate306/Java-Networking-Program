import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Neel Patel on 7/8/2017.
 */
public class Client {
    public static final int listen = 27019;
    public static void main(String[] args){
        Socket socket;
        BufferedReader bufferedReader;
        String ip;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ip address");
        ip = scanner.nextLine();
        //make the connection
        try{
            socket = new Socket(ip,listen);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = bufferedReader.readLine();
            if(line == null){
                throw new IOException("Did not work" );
            }
            System.out.println();
            System.out.println(line);
            System.out.println();
            bufferedReader.close();
        }catch(Exception e){
            System.out.println("There was a error");
        }
    }
}
