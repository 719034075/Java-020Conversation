package connect;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by 71903 on 2016/10/14.
 */
public class clientConnect{
    //ip
    private String ip;
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    //port
    private String port;
    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    //socket
    private Socket socket;
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public clientConnect(){};

    public void run() {

            try {
                socket=new Socket(ip,Integer.parseInt(port));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
