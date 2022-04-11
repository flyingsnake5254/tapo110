package com.jcraft.jsch;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public abstract interface Proxy
{
  public abstract void close();
  
  public abstract void connect(SocketFactory paramSocketFactory, String paramString, int paramInt1, int paramInt2)
    throws Exception;
  
  public abstract InputStream getInputStream();
  
  public abstract OutputStream getOutputStream();
  
  public abstract Socket getSocket();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Proxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */