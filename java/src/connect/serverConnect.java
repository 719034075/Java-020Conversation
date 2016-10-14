package connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 71903 on 2016/10/14.
 */
public class serverConnect{

    //port
    private String port;
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    //serverSocket
    private ServerSocket serverSocket;
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    //socket
    private Socket socket;
    public Socket getSocket(){
        return socket;
    }

    public void setSocket(Socket socket){
        this.socket=socket;
    }

    public serverConnect(){};

    public void run() {
        try {
            serverSocket= new ServerSocket(Integer.parseInt(port));//绑定port
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket=serverSocket.accept();//监听
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}