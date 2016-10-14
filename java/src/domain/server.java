package domain;

import connect.serverConnect;
import reciever.serverReceiver;
import sayer.serverSay;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class server extends JFrame {
	private JPanel firPanel;
	private JPanel secPanel;
	private JPanel triPanel;
	private JPanel fourPanel;
	private JScrollPane scrollPane;
 	private JButton startButton;
 	private JButton sayButton;
 	private JTextField firTxtField;
 	public static JTextArea TxtArea;
 	public static JTextField secTxtField;
 	private JLabel nameLabel;
 	private JLabel portLabel;
 	private JLabel sayLabel;
	private String port;
	private String sayInfo=null;
	private String recInfo=null;

	private serverConnect serverCon;
	private serverReceiver serverRec;
	private serverSay serverSay;


	/*初始化变量*/
	public void initVariable(){
		 firPanel=new JPanel();
		 secPanel=new JPanel();
		 triPanel=new JPanel();
		 fourPanel=new JPanel();
		 startButton=new JButton("start");
		 sayButton=new JButton("sayer");
		 firTxtField=new JTextField(15);
		 TxtArea=new JTextArea(5,25);
		 scrollPane=new JScrollPane(TxtArea);
		 secTxtField=new JTextField(15);
		 nameLabel=new JLabel("服务器设置:");
		 portLabel=new JLabel("port:");
		 sayLabel=new JLabel("sayer:");

		serverCon=new serverConnect();
		serverRec=new serverReceiver();
		serverSay=new serverSay();

	}



	/*组件拼接*/
	public void addDetails(){
		firPanel.add(nameLabel);
		secPanel.add(portLabel);
		secPanel.add(firTxtField);
		secPanel.add(startButton);
		triPanel.add(scrollPane);
		fourPanel.add(sayLabel);
		fourPanel.add(secTxtField);
		fourPanel.add(sayButton);
	}

	/*初始化窗体*/
	public void initFrame(){
		this.setSize(600,400);
		this.setLayout(new GridLayout(4,1));
		this.add(firPanel);
		this.add(secPanel);
		this.add(triPanel);
		this.add(fourPanel);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*添加监听器*/
	public void addListener(){
		 /*port监听器  把文本框中的内容存入port*/
		firTxtField.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				userReaction();
			}

			public void removeUpdate(DocumentEvent e) {
				userReaction();
			}

			public void changedUpdate(DocumentEvent e) {
				userReaction();
			}

			private void userReaction() {
				port=firTxtField.getText();
			}
		});

		/*info监听器  把文本框中的内容存入info*/
		secTxtField.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				userReaction();
			}

			public void removeUpdate(DocumentEvent e) {
				userReaction();
			}

			public void changedUpdate(DocumentEvent e) {
				userReaction();
			}

			private void userReaction() {
				sayInfo=secTxtField.getText();
			}
		});

		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					TxtArea.append("Server starting…\n");
					TxtArea.append("Client connected…\n");
					serverCon.setPort(port);
					serverCon.run();
					getInfo();
			}
		});

		sayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				serverSay.setSocket(serverCon.getSocket());
				serverSay.setSayInfo(sayInfo);
				serverSay.run();
				TxtArea.append(sayInfo+"\n");

			}
		});
	}

	public void getInfo(){
		serverRec.setSocket(serverCon.getSocket());
		serverRec.start();
	}

	/*构造*/
 	public server()
 	{
		super("服务器");
		initVariable();
		addDetails();
		addListener();
		initFrame();
 	}
 		
	public static void main(String[] args) {

		new server();
	}
}
	 	
	 		
 	
 	
		
	
 	
