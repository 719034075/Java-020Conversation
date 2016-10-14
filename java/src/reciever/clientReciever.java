package reciever;

import domain.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by 71903 on 2016/10/14.
 */
public class clientReciever extends Thread{
    //in
    private BufferedReader in;
    public BufferedReader getIn() {
        return in;
    }

    public void setIn(BufferedReader in) {
        this.in = in;
    }

    //socket
    private Socket socket;
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    //recInfo
    private String recInfo;
    public String getRecInfo() {
        return recInfo;
    }

    public void setRecInfo(String recInfo) {
        this.recInfo = recInfo;
    }

    public clientReciever(){};

    public void run(){

        try {
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));//得到服务器端信息
            while ((recInfo=in.readLine())!=null){
            client.TxtArea.append(recInfo+"\n");
            }
            System.out.println(recInfo);
//            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}