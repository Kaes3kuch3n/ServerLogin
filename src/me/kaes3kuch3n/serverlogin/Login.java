package me.kaes3kuch3n.serverlogin;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Login {

    private Login() {

    }

    public static String login(String name, String pass) {
        String result = "";
        try {
            //Open connection
            URL url = new URL("http://kaes3kuch3n.ddns.net/java/login.php");
            URLConnection connection = url.openConnection();

            //Send entered username and password to server
            connection.setDoOutput(true);
            PrintStream out = new PrintStream(connection.getOutputStream());
            out.print("name=" + name);
            out.print("&pass=" + pass);

            //Read answer from server
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String nextLine;
            while ((nextLine = in.readLine()) != null)
                result = result.concat(nextLine + "\n");

            //Close streams
            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.equals("") ? "There was an error :(" : result;
    }

}
