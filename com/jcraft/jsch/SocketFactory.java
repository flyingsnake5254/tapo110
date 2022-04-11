package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract interface SocketFactory
{
  public abstract Socket createSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException;
  
  public abstract InputStream getInputStream(Socket paramSocket)
    throws IOException;
  
  public abstract OutputStream getOutputStream(Socket paramSocket)
    throws IOException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\SocketFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */