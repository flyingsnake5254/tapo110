package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

public final class UdpDataSource
  extends h
{
  private final int f;
  private final byte[] g;
  private final DatagramPacket h;
  @Nullable
  private Uri i;
  @Nullable
  private DatagramSocket j;
  @Nullable
  private MulticastSocket k;
  @Nullable
  private InetAddress l;
  @Nullable
  private InetSocketAddress m;
  private boolean n;
  private int o;
  
  public UdpDataSource()
  {
    this(2000);
  }
  
  public UdpDataSource(int paramInt)
  {
    this(paramInt, 8000);
  }
  
  public UdpDataSource(int paramInt1, int paramInt2)
  {
    super(true);
    this.f = paramInt2;
    byte[] arrayOfByte = new byte[paramInt1];
    this.g = arrayOfByte;
    this.h = new DatagramPacket(arrayOfByte, 0, paramInt1);
  }
  
  public void close()
  {
    this.i = null;
    Object localObject = this.k;
    if (localObject != null) {}
    try
    {
      ((MulticastSocket)localObject).leaveGroup(this.l);
      this.k = null;
      localObject = this.j;
      if (localObject != null)
      {
        ((DatagramSocket)localObject).close();
        this.j = null;
      }
      this.l = null;
      this.m = null;
      this.o = 0;
      if (this.n)
      {
        this.n = false;
        p();
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  @Nullable
  public Uri getUri()
  {
    return this.i;
  }
  
  public long j(n paramn)
    throws UdpDataSource.UdpDataSourceException
  {
    Object localObject = paramn.a;
    this.i = ((Uri)localObject);
    localObject = ((Uri)localObject).getHost();
    int i1 = this.i.getPort();
    q(paramn);
    try
    {
      this.l = InetAddress.getByName((String)localObject);
      localObject = new java/net/InetSocketAddress;
      ((InetSocketAddress)localObject).<init>(this.l, i1);
      this.m = ((InetSocketAddress)localObject);
      if (this.l.isMulticastAddress())
      {
        localObject = new java/net/MulticastSocket;
        ((MulticastSocket)localObject).<init>(this.m);
        this.k = ((MulticastSocket)localObject);
        ((MulticastSocket)localObject).joinGroup(this.l);
        this.j = this.k;
      }
      else
      {
        localObject = new java/net/DatagramSocket;
        ((DatagramSocket)localObject).<init>(this.m);
        this.j = ((DatagramSocket)localObject);
      }
      this.j.setSoTimeout(this.f);
      this.n = true;
      r(paramn);
      return -1L;
    }
    catch (IOException paramn)
    {
      throw new UdpDataSourceException(paramn, 2001);
    }
    catch (SecurityException paramn)
    {
      throw new UdpDataSourceException(paramn, 2006);
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws UdpDataSource.UdpDataSourceException
  {
    if (paramInt2 == 0) {
      return 0;
    }
    if (this.o == 0) {
      try
      {
        this.j.receive(this.h);
        i1 = this.h.getLength();
        this.o = i1;
        o(i1);
      }
      catch (IOException paramArrayOfByte)
      {
        throw new UdpDataSourceException(paramArrayOfByte, 2001);
      }
      catch (SocketTimeoutException paramArrayOfByte)
      {
        throw new UdpDataSourceException(paramArrayOfByte, 2002);
      }
    }
    int i2 = this.h.getLength();
    int i1 = this.o;
    paramInt2 = Math.min(i1, paramInt2);
    System.arraycopy(this.g, i2 - i1, paramArrayOfByte, paramInt1, paramInt2);
    this.o -= paramInt2;
    return paramInt2;
  }
  
  public static final class UdpDataSourceException
    extends DataSourceException
  {
    public UdpDataSourceException(Throwable paramThrowable, int paramInt)
    {
      super(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\upstream\UdpDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */