package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ProxyHTTP
  implements Proxy
{
  private static int DEFAULTPORT = 80;
  private InputStream in;
  private OutputStream out;
  private String passwd;
  private String proxy_host;
  private int proxy_port;
  private Socket socket;
  private String user;
  
  public ProxyHTTP(String paramString)
  {
    i = DEFAULTPORT;
    j = i;
    String str1 = paramString;
    if (paramString.indexOf(':') != -1) {}
    try
    {
      str1 = paramString.substring(0, paramString.indexOf(':'));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label54:
        j = i;
        String str2 = paramString;
      }
    }
    try
    {
      j = Integer.parseInt(paramString.substring(paramString.indexOf(':') + 1));
      i = j;
    }
    catch (Exception paramString)
    {
      break label54;
    }
    j = i;
    this.proxy_host = str1;
    this.proxy_port = j;
  }
  
  public ProxyHTTP(String paramString, int paramInt)
  {
    this.proxy_host = paramString;
    this.proxy_port = paramInt;
  }
  
  public static int getDefaultPort()
  {
    return DEFAULTPORT;
  }
  
  public void close()
  {
    try
    {
      Object localObject = this.in;
      if (localObject != null) {
        ((InputStream)localObject).close();
      }
      localObject = this.out;
      if (localObject != null) {
        ((OutputStream)localObject).close();
      }
      localObject = this.socket;
      if (localObject != null) {
        ((Socket)localObject).close();
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    this.in = null;
    this.out = null;
    this.socket = null;
  }
  
  public void connect(SocketFactory paramSocketFactory, String paramString, int paramInt1, int paramInt2)
    throws JSchException
  {
    if (paramSocketFactory == null) {}
    try
    {
      paramSocketFactory = Util.createSocket(this.proxy_host, this.proxy_port, paramInt2);
      this.socket = paramSocketFactory;
      this.in = paramSocketFactory.getInputStream();
      this.out = this.socket.getOutputStream();
      break label93;
      Object localObject = paramSocketFactory.createSocket(this.proxy_host, this.proxy_port);
      this.socket = ((Socket)localObject);
      this.in = paramSocketFactory.getInputStream((Socket)localObject);
      this.out = paramSocketFactory.getOutputStream(this.socket);
      label93:
      if (paramInt2 > 0) {
        this.socket.setSoTimeout(paramInt2);
      }
      this.socket.setTcpNoDelay(true);
      localObject = this.out;
      paramSocketFactory = new java/lang/StringBuilder;
      paramSocketFactory.<init>();
      paramSocketFactory.append("CONNECT ");
      paramSocketFactory.append(paramString);
      paramSocketFactory.append(":");
      paramSocketFactory.append(paramInt1);
      paramSocketFactory.append(" HTTP/1.0\r\n");
      ((OutputStream)localObject).write(Util.str2byte(paramSocketFactory.toString()));
      paramSocketFactory = this.user;
      if ((paramSocketFactory != null) && (this.passwd != null))
      {
        paramSocketFactory = new java/lang/StringBuilder;
        paramSocketFactory.<init>();
        paramSocketFactory.append(this.user);
        paramSocketFactory.append(":");
        paramSocketFactory.append(this.passwd);
        paramSocketFactory = Util.str2byte(paramSocketFactory.toString());
        paramSocketFactory = Util.toBase64(paramSocketFactory, 0, paramSocketFactory.length);
        this.out.write(Util.str2byte("Proxy-Authorization: Basic "));
        this.out.write(paramSocketFactory);
        this.out.write(Util.str2byte("\r\n"));
      }
      this.out.write(Util.str2byte("\r\n"));
      this.out.flush();
      paramSocketFactory = new java/lang/StringBuffer;
      paramSocketFactory.<init>();
      paramInt1 = 0;
      do
      {
        for (;;)
        {
          paramInt2 = paramInt1;
          if (paramInt1 < 0) {
            break label351;
          }
          paramInt1 = this.in.read();
          if (paramInt1 == 13) {
            break;
          }
          paramSocketFactory.append((char)paramInt1);
        }
        paramInt1 = this.in.read();
        paramInt2 = paramInt1;
      } while (paramInt1 != 10);
      label351:
      if (paramInt2 >= 0)
      {
        paramString = paramSocketFactory.toString();
        paramSocketFactory = "Unknow reason";
        int i = -1;
        paramInt1 = i;
        int j;
        try
        {
          j = paramString.indexOf(' ');
          int k = j + 1;
          paramInt1 = i;
          paramInt2 = j;
          int m = paramString.indexOf(' ', k);
          paramInt1 = i;
          paramInt2 = j;
          i = Integer.parseInt(paramString.substring(k, m));
          paramInt1 = i;
          paramInt2 = j;
          paramString = paramString.substring(m + 1);
          paramSocketFactory = paramString;
          paramInt1 = i;
          paramInt2 = j;
        }
        catch (Exception paramString) {}
        if (paramInt1 == 200)
        {
          paramInt1 = paramInt2;
          label510:
          do
          {
            j = 0;
            do
            {
              for (;;)
              {
                paramInt2 = paramInt1;
                if (paramInt1 < 0) {
                  break label510;
                }
                paramInt1 = this.in.read();
                if (paramInt1 == 13) {
                  break;
                }
                j++;
              }
              paramInt1 = this.in.read();
              paramInt2 = paramInt1;
            } while (paramInt1 != 10);
            if (paramInt2 < 0) {
              break;
            }
            paramInt1 = paramInt2;
          } while (j != 0);
          return;
          paramSocketFactory = new java/io/IOException;
          paramSocketFactory.<init>();
          throw paramSocketFactory;
        }
        paramString = new java/io/IOException;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        ((StringBuilder)localObject).append("proxy error: ");
        ((StringBuilder)localObject).append(paramSocketFactory);
        paramString.<init>(((StringBuilder)localObject).toString());
        throw paramString;
      }
      paramSocketFactory = new java/io/IOException;
      paramSocketFactory.<init>();
      throw paramSocketFactory;
    }
    catch (Exception paramSocketFactory)
    {
      try
      {
        paramString = this.socket;
        if (paramString != null) {
          paramString.close();
        }
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
      paramString = new StringBuilder();
      paramString.append("ProxyHTTP: ");
      paramString.append(paramSocketFactory.toString());
      throw new JSchException(paramString.toString(), paramSocketFactory);
    }
    catch (RuntimeException paramSocketFactory)
    {
      throw paramSocketFactory;
    }
  }
  
  public InputStream getInputStream()
  {
    return this.in;
  }
  
  public OutputStream getOutputStream()
  {
    return this.out;
  }
  
  public Socket getSocket()
  {
    return this.socket;
  }
  
  public void setUserPasswd(String paramString1, String paramString2)
  {
    this.user = paramString1;
    this.passwd = paramString2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ProxyHTTP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */