package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Hashtable;

class ChannelX11
  extends Channel
{
  private static final int LOCAL_MAXIMUM_PACKET_SIZE = 16384;
  private static final int LOCAL_WINDOW_SIZE_MAX = 131072;
  private static final int TIMEOUT = 10000;
  static byte[] cookie;
  private static byte[] cookie_hex;
  private static Hashtable faked_cookie_hex_pool = new Hashtable();
  private static Hashtable faked_cookie_pool = new Hashtable();
  private static String host = "127.0.0.1";
  private static int port = 6000;
  private static byte[] table = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private byte[] cache = new byte[0];
  private boolean init = true;
  private Socket socket = null;
  
  ChannelX11()
  {
    setLocalWindowSizeMax(131072);
    setLocalWindowSize(131072);
    setLocalPacketSize(16384);
    this.type = Util.str2byte("x11");
    this.connected = true;
  }
  
  private byte[] addCache(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte1 = this.cache;
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte2, arrayOfByte1.length, paramInt2);
    paramArrayOfByte = this.cache;
    if (paramArrayOfByte.length > 0) {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, 0, paramArrayOfByte.length);
    }
    this.cache = arrayOfByte2;
    return arrayOfByte2;
  }
  
  private static boolean equals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
      return false;
    }
    for (int i = 0; i < paramArrayOfByte1.length; i++) {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        return false;
      }
    }
    return true;
  }
  
  static byte[] getFakedCookie(Session paramSession)
  {
    synchronized (faked_cookie_hex_pool)
    {
      byte[] arrayOfByte1 = (byte[])faked_cookie_hex_pool.get(paramSession);
      Object localObject = arrayOfByte1;
      if (arrayOfByte1 == null)
      {
        localObject = Session.random;
        arrayOfByte1 = new byte[16];
        int i = 0;
        try
        {
          ((Random)localObject).fill(arrayOfByte1, 0, 16);
          faked_cookie_pool.put(paramSession, arrayOfByte1);
          localObject = new byte[32];
          while (i < 16)
          {
            int j = i * 2;
            byte[] arrayOfByte2 = table;
            localObject[j] = ((byte)arrayOfByte2[(arrayOfByte1[i] >>> 4 & 0xF)]);
            localObject[(j + 1)] = ((byte)arrayOfByte2[(arrayOfByte1[i] & 0xF)]);
            i++;
          }
          faked_cookie_hex_pool.put(paramSession, localObject);
        }
        finally {}
      }
      return (byte[])localObject;
    }
  }
  
  static void removeFakedCookie(Session paramSession)
  {
    synchronized (faked_cookie_hex_pool)
    {
      faked_cookie_hex_pool.remove(paramSession);
      faked_cookie_pool.remove(paramSession);
      return;
    }
  }
  
  static int revtable(byte paramByte)
  {
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = table;
      if (i >= arrayOfByte.length) {
        break;
      }
      if (arrayOfByte[i] == paramByte) {
        return i;
      }
    }
    return 0;
  }
  
  static void setCookie(String paramString)
  {
    cookie_hex = Util.str2byte(paramString);
    cookie = new byte[16];
    for (int i = 0; i < 16; i++)
    {
      paramString = cookie;
      byte[] arrayOfByte = cookie_hex;
      int j = i * 2;
      paramString[i] = ((byte)(byte)(revtable(arrayOfByte[j]) << 4 & 0xF0 | revtable(cookie_hex[(j + 1)]) & 0xF));
    }
  }
  
  static void setHost(String paramString)
  {
    host = paramString;
  }
  
  static void setPort(int paramInt)
  {
    port = paramInt;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        localObject1 = Util.createSocket(host, port, 10000);
        this.socket = ((Socket)localObject1);
        ((Socket)localObject1).setTcpNoDelay(true);
        localObject1 = new com/jcraft/jsch/IO;
        ((IO)localObject1).<init>();
        this.io = ((IO)localObject1);
        ((IO)localObject1).setInputStream(this.socket.getInputStream());
        this.io.setOutputStream(this.socket.getOutputStream());
        sendOpenConfirmation();
        this.thread = Thread.currentThread();
        localBuffer = new Buffer(this.rmpsize);
        localObject1 = new Packet(localBuffer);
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Buffer localBuffer;
        sendOpenFailure(1);
        this.close = true;
        disconnect();
        return;
      }
      try
      {
        if (this.thread != null)
        {
          Object localObject2 = this.io;
          if (localObject2 != null)
          {
            InputStream localInputStream = ((IO)localObject2).in;
            if (localInputStream != null)
            {
              localObject2 = localBuffer.buffer;
              int i = localInputStream.read((byte[])localObject2, 14, localObject2.length - 14 - 128);
              if (i <= 0)
              {
                eof();
              }
              else if (!this.close)
              {
                ((Packet)localObject1).reset();
                localBuffer.putByte((byte)94);
                localBuffer.putInt(this.recipient);
                localBuffer.putInt(i);
                localBuffer.skip(i);
                getSession().write((Packet)localObject1, this, i);
                continue;
              }
            }
          }
        }
      }
      catch (Exception localException2) {}
    }
    disconnect();
  }
  
  void write(byte[] arg1, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.init) {
      try
      {
        Object localObject1 = getSession();
        byte[] arrayOfByte1 = addCache(???, paramInt1, paramInt2);
        int i = arrayOfByte1.length;
        if (i < 9) {
          return;
        }
        int j = (arrayOfByte1[6] & 0xFF) * 256 + (arrayOfByte1[7] & 0xFF);
        int k = (arrayOfByte1[8] & 0xFF) * 256 + (arrayOfByte1[9] & 0xFF);
        if ((arrayOfByte1[0] & 0xFF) == 66)
        {
          paramInt2 = j;
          paramInt1 = k;
        }
        else
        {
          paramInt2 = j;
          paramInt1 = k;
          if ((arrayOfByte1[0] & 0xFF) == 108)
          {
            paramInt2 = j << 8 & 0xFF00 | j >>> 8 & 0xFF;
            paramInt1 = k << 8 & 0xFF00 | k >>> 8 & 0xFF;
          }
        }
        k = -paramInt2 & 0x3;
        if (i < paramInt2 + 12 + k + paramInt1) {
          return;
        }
        byte[] arrayOfByte2 = new byte[paramInt1];
        paramInt2 = 12 + paramInt2 + k;
        System.arraycopy(arrayOfByte1, paramInt2, arrayOfByte2, 0, paramInt1);
        synchronized (faked_cookie_pool)
        {
          localObject1 = (byte[])faked_cookie_pool.get(localObject1);
          if (equals(arrayOfByte2, (byte[])localObject1))
          {
            ??? = cookie;
            if (??? != null) {
              System.arraycopy(???, 0, arrayOfByte1, paramInt2, paramInt1);
            }
          }
          else
          {
            this.thread = null;
            eof();
            this.io.close();
            disconnect();
          }
          this.init = false;
          this.io.put(arrayOfByte1, 0, i);
          this.cache = null;
          return;
        }
        this.io.put(???, paramInt1, paramInt2);
      }
      catch (JSchException ???)
      {
        throw new IOException(???.toString());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\ChannelX11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */