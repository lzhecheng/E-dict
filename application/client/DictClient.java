
package application.client;

import application.share.Connect;
import application.share.Convert;
import debug.Debug;
import java.io.*;
import java.net.Socket;
import javafx.stage.Stage;
import net.SocketStream;

public class DictClient extends DictUI implements AutoCloseable {
	private static SocketStream server = null;
	
	public static void main(String[] args) {
//		try {
//			SocketStream server =
//				new SocketStream(new Socket("127.0.0.1", Connect.SERVER_PORT));
//			DictClient.server = server;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if (server == null) System.exit(Debug.ERROR_IO);
//		
//		String[] msgSend = new String[] { "apple" };
//		server.println(Convert.getSend(msgSend));
//		if (Debug.DEBUG) System.out.println("Hello server.");
//		
//		String[] msgRecv = Convert.getRecv(server.readLine());
//		System.out.println(msgRecv[0]);
//		System.out.println(msgRecv[1]);
//		System.out.println(msgRecv[2]);
//		
//		System.exit(Debug.ERROR_SUCCESS);
//		
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initializeComponent(primaryStage);
	}
	
	@Override
	public void close() {
		server.close();
	}
}
