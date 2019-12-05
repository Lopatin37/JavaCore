package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public Server()
    {
        try
        {
            openServer();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void openServer()
    {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8089))
        {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    while (!serverSocket.isClosed())
                    {
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        String str;
                        try
                        {
                            str = br.readLine();
                            out.writeUTF(str);
                            if(str.equals("/end")) break;
                        } catch (IOException e)
                        {
                           // e.printStackTrace();
                        }
                    }
                }
            }).start();

            try
            {
                while (!serverSocket.isClosed())
                {
                    String str = in.readUTF();
                    if (str.equals("/end"))
                    {
                        try
                        {
                            in.close();
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        try
                        {
                            out.close();
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        try
                        {
                            socket.close();
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        break;
                    }
                    System.out.println("Client: " + str);
                }
            } catch (IOException e)
            {
                //e.printStackTrace();
            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
