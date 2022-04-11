package com.tplink.ssh2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class e0
  implements com.jcraft.jsch.SocketFactory
{
  private final javax.net.SocketFactory a;
  
  public e0(javax.net.SocketFactory paramSocketFactory)
  {
    this.a = paramSocketFactory;
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    return this.a.createSocket(paramString, paramInt);
  }
  
  public InputStream getInputStream(Socket paramSocket)
    throws IOException
  {
    return paramSocket.getInputStream();
  }
  
  public OutputStream getOutputStream(Socket paramSocket)
    throws IOException
  {
    return paramSocket.getOutputStream();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ssh2\e0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */