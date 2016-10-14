package domain;

import connect.clientConnect;
import reciever.clientReciever;
import sayer.clientSay;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class client extends JFrame {
	
	private JPanel firPanel;
	private JPanel secPanel;
	private JPanel triPanel;
	private JPanel fourPanel;
	private JScrollPane scrollPane;
	private JButton connectButton;
 	private JButton sayButton;
 	private JTextField firTxtField;
 	private JTextField secTxtField;
 	public static JTextArea TxtArea;
 	public static JTextField triTxtField;
 	private JLabel nameLabel;
 	private JLabel ipLabel;
 	private JLabel portLabel;
 	private JLabel sayLabel;
	private String port;
	private String ip;
	private String sayInfo=null;
	private String recInfo=null;

	private clientConnect clientCon;
	private clientReciever clientRec;
	private clientSay clientSay;


	/*初始化变量*/
	public void initVariable(){
		firPanel=new JPanel();
		secPanel=new JPanel();
		triPanel=new JPanel();
		fourPanel=new JPanel();
		connectButton=new JButton("connect");
		sayButton=new JButton("sayer");
		firTxtField=new JTextField(15);
		secTxtField=new JTextField(15);
		TxtArea=new JTextArea(5,25);
		scrollPane=new JScrollPane(TxtArea);
		triTxtField=new JTextField(15);
		nameLabel=new JLabel("客户端设置:");
		ipLabel=new JLabel("client IP:");
		portLabel=new JLabel("client Port:");
		sayLabel=new JLabel("sayer:");

		clientCon=new clientConnect();
		clientRec=new clientReciever();
		clientSay=new clientSay();
	}

	/*组件拼接*/
	public void addDetails(){
		firPanel.add(nameLabel);
		secPanel.add(ipLabel);
		secPanel.add(firTxtField);
		secPanel.add(portLabel);
		secPanel.add(secTxtField);
		secPanel.add(connectButton);
		triPanel.add(scrollPane);
		fourPanel.add(sayLabel);
		fourPanel.add(triTxtField);
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
		 /*ip监听器  把文本框中的内容存入ip*/
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
				ip=firTxtField.getText();
			}
		});

		/*port监听器  把文本框中的内容存入port*/
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
				port=secTxtField.getText();
			}
		});

		/*info监听器  把文本框中的内容存入info*/
		triTxtField.getDocument().addDocumentListener(new DocumentListener() {
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
				sayInfo=triTxtField.getText();
			}
		});

		connectButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				TxtArea.append("Connect to server…\n");
				clientCon.setIp(ip);
				clientCon.setPort(port);
				clientCon.run();
				getInfo();
			}
		});
		sayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clientSay.setSocket(clientCon.getSocket());
				clientSay.setSayInfo(sayInfo);
				clientSay.run();
				TxtArea.append(sayInfo+"\n");
//				clientSay.getOut().close();
			}
		});
	}
	public void getInfo(){
		clientRec.setSocket(clientCon.getSocket());
		clientRec.start();
	}

	/*构造*/
 	public client() {
		super("客户端");
 		initVariable();
		addDetails();
		addListener();
		initFrame();
 	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	new client();
	}
}
