package sayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by 71903 on 2016/10/14.
 */
public class clientSay {
    //out
    private PrintWriter out;
    public PrintWriter getOut() {
        return out;
    }

    public void setOut(PrintWriter out) {
        this.out = out;
    }

    //socket
    private Socket socket;
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    //sayInfo
    private String sayInfo;
    public String getSayInfo() {
        return sayInfo;
    }

    public void setSayInfo(String sayInfo) {
        this.sayInfo = sayInfo;
    }

    public clientSay(){};

    public void run() {
        try{
            out=new PrintWriter(socket.getOutputStream());
            out.println(sayInfo);
            out.flush();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
