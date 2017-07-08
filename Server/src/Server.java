import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Neel Patel on 7/8/2017.
 */
public class Server {
    //my current port for my ip address
    public static final int listen = 27019;
    public static void main(String[] args){
        Socket server;
        ServerSocket serverSocket;
        try{
            serverSocket = new ServerSocket(listen);
            System.out.println("Listening for clients");
            while(true){
                server = serverSocket.accept();
                sendInfo(server);
            }
        }catch(Exception e){
            System.out.print("Error sorry! :(");
        }
    }
    private static void sendInfo(Socket socket) {
        try {
            Date date = new Date();
            PrintWriter printWriter;
            printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.println(date.toString());
            printWriter.flush();
            socket.close();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
