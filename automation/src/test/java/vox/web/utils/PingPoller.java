package vox.web.utils;

import java.io.IOException;
import java.net.Socket;

public class PingPoller {
	public static void getServerStatus() throws IOException {
		System.out.println("Ping Poller Starts...");

		// String ipAddress = "paytm.com";
		// String ip = "216.58.196.110";
		// String pingResult = "";
		//
		// String pingCmd = "ping -c 5 " + ipAddress;
		// try {
		// Runtime r = Runtime.getRuntime();
		// Process p = r.exec(pingCmd);
		//
		// BufferedReader in = new BufferedReader(new InputStreamReader(
		// p.getInputStream()));
		// String inputLine;
		// while ((inputLine = in.readLine()) != null) {
		// System.out.println(inputLine);
		// pingResult += inputLine;
		// }
		// in.close();
		//
		// } catch (IOException e) {
		// System.out.println(e);
		// }

		try {
			Socket socket = new Socket("staging.voxweb.in", 443);
			socket.close();
			System.out.println("Server is up");

		} catch (IOException e) {
			System.out.println("Server is down");
		}

	}

}
