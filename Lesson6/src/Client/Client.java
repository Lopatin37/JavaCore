package Client;

import java.io.*;
import java.net.Socket;

public class Client
{
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8089;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client()
    {
        try
        {
            openConnection();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private void openConnection() throws IOException
    {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    while (!socket.isClosed())
                    {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) break;
                        System.out.println("Server: " + strFromServer);
                    }
                } catch (Exception e)
                {
                    //e.printStackTrace();
                }finally
                {
                    closeConnection();
                }
            }
        }).start();


        while (!socket.isClosed())
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            try
            {
                str = br.readLine();
                out.writeUTF(str);
                if(str.equals("/end"))
                {
                    closeConnection();
                    break;
                }
            } catch (IOException e)
            {
               // e.printStackTrace();
            }
        }

    }

    public void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


