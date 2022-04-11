package com.tplink.libtpstreamconnectionsocket;

import android.text.TextUtils;
import android.util.Pair;
import b.d.d.k.f.b;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  private String a;
  private int b;
  private int c;
  private int d;
  private String e;
  private Socket f = new Socket();
  private BufferedOutputStream g;
  private InputStream h;
  public int i;
  private StringBuilder j;
  private Queue<Pair<String, Map<String, String>>> k;
  private byte[] l;
  private byte[] m;
  private int n;
  private Map<String, String> o;
  private long p;
  private AtomicBoolean q;
  private AtomicBoolean r;
  private int s = 0;
  private AtomicBoolean t;
  private io.reactivex.e0.c u;
  
  public a(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
    this.e = "GET";
    this.j = new StringBuilder();
    this.l = new byte['Ѐ'];
    this.m = new byte[524288];
    this.n = 0;
    this.o = new HashMap();
    this.k = new LinkedBlockingQueue();
    this.i = -1;
    this.q = new AtomicBoolean(false);
    this.r = new AtomicBoolean(false);
    this.t = new AtomicBoolean(false);
    this.p = 0L;
  }
  
  private String A()
    throws IOException
  {
    if ((!this.f.isClosed()) && (!this.f.isInputShutdown())) {
      return new DataInputStream(this.h).readLine();
    }
    return "";
  }
  
  private void B(String paramString)
    throws IOException
  {
    if ((this.g != null) && (!this.f.isInputShutdown()) && (!this.f.isClosed()))
    {
      this.g.write(paramString.getBytes());
      this.g.flush();
    }
  }
  
  private void C(boolean paramBoolean)
    throws Exception
  {
    Object localObject = n();
    c();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      B((String)localObject);
      if (paramBoolean)
      {
        this.i = 204;
        this.o.clear();
        return;
      }
      if (this.r.get())
      {
        this.r.set(false);
        this.i = 204;
        this.o.clear();
      }
    }
    else
    {
      localObject = (Pair)this.k.poll();
      if (localObject != null)
      {
        B(u((Pair)localObject));
        if (this.r.get())
        {
          this.r.set(false);
          this.i = 204;
          this.o.clear();
          return;
        }
      }
    }
    if (this.q.get())
    {
      this.i = 204;
      this.o.clear();
      return;
    }
    if (!this.t.get())
    {
      this.i = v();
      this.o.clear();
      if (this.i != -1)
      {
        localObject = i();
        this.o = ((Map)localObject);
        if ((((Map)localObject).containsKey("Transfer-Encoding")) && ("chunked".equals(this.o.get("Transfer-Encoding")))) {
          return;
        }
        if (this.o.containsKey("Content-Length"))
        {
          int i1 = k((String)this.o.get("Content-Length"));
          this.p += i1;
          if (i1 > 0) {
            z(i1);
          }
        }
        return;
      }
      throw new Exception("unknown respond code");
    }
    this.t.set(false);
    this.s = 0;
    throw new MediaStreamNullException("unexpected end of stream");
  }
  
  private void J()
  {
    b.d.p.d.a("HttpMediaClient", "stopRelayTimer");
    io.reactivex.e0.c localc = this.u;
    if ((localc != null) && (!localc.isDisposed())) {
      this.u.dispose();
    }
    this.t.set(false);
    this.s = 0;
  }
  
  private void K(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    if ((this.g != null) && (!this.f.isInputShutdown()) && (!this.f.isClosed()))
    {
      this.g.write(paramString.getBytes());
      this.g.write(paramArrayOfByte);
      this.g.write("\r\n".getBytes());
      this.g.flush();
    }
  }
  
  private a a(Map<String, String> paramMap)
  {
    this.j.append(l(paramMap));
    return this;
  }
  
  private a b(String paramString)
  {
    this.j.append(paramString);
    return this;
  }
  
  private void c()
  {
    StringBuilder localStringBuilder = this.j;
    localStringBuilder.delete(0, localStringBuilder.length());
  }
  
  private long h(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.getBytes().length;
    }
    return 0L;
  }
  
  private Map<String, String> i()
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    if ((!this.f.isClosed()) && (!this.f.isInputShutdown()))
    {
      DataInputStream localDataInputStream = new DataInputStream(this.h);
      for (;;)
      {
        String str = localDataInputStream.readLine();
        if ("".equals(str))
        {
          this.s = 0;
          break;
        }
        if (str == null)
        {
          int i1 = this.s + 1;
          this.s = i1;
          if (i1 >= 20)
          {
            J();
            throw new MediaStreamNullException("unexpected end of stream");
          }
        }
        else
        {
          this.s = 0;
          String[] arrayOfString = str.split(":", 2);
          if (arrayOfString.length >= 2) {
            localHashMap.put(arrayOfString[0].trim(), arrayOfString[1].trim());
          }
        }
        this.p += h(str);
      }
    }
    return localHashMap;
  }
  
  private int k(String paramString)
  {
    int i1;
    try
    {
      i1 = Integer.parseInt(paramString.trim());
    }
    catch (Exception paramString)
    {
      i1 = 0;
    }
    return i1;
  }
  
  private String l(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = (String)paramMap.get(str1);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
        {
          localStringBuilder.append(str1);
          localStringBuilder.append(":");
          localStringBuilder.append(" ");
          localStringBuilder.append(str2);
          localStringBuilder.append("\r\n");
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private String n()
  {
    this.j.append("\r\n\r\n");
    String str1 = this.j.toString();
    String str2 = str1;
    if ("\r\n\r\n".equals(str1)) {
      str2 = "";
    }
    return str2;
  }
  
  public static String o(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://");
    localStringBuilder.append(paramString);
    localStringBuilder.append(":");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("/stream");
    return localStringBuilder.toString();
  }
  
  private int r(String paramString)
  {
    paramString = paramString.split(" ", 3);
    if ((paramString != null) && (paramString.length >= 2)) {
      return k(paramString[1]);
    }
    return -1;
  }
  
  private String u(Pair<String, Map<String, String>> paramPair)
  {
    String str = (String)paramPair.first;
    paramPair = (Map)paramPair.second;
    if ((paramPair != null) && (!paramPair.isEmpty())) {
      paramPair = l(paramPair);
    } else {
      paramPair = "";
    }
    return "----client-stream-boundary--\r\n".concat(paramPair).concat("Content-Type: application/json\r\n").concat("Content-Length: ").concat(String.valueOf(str.getBytes().length)).concat("\r\n\r\n").concat(str).concat("\r\n");
  }
  
  private int v()
    throws IOException
  {
    String str = A();
    this.p += h(str);
    return w(str);
  }
  
  private int w(String paramString)
    throws IOException
  {
    if (paramString == null)
    {
      int i1 = this.s + 1;
      this.s = i1;
      if (i1 < 20) {
        return 0;
      }
      J();
      throw new MediaStreamNullException("unexpected end of stream");
    }
    if (paramString.equals("")) {
      return 0;
    }
    if (paramString.contains("--device-stream-boundary--"))
    {
      this.s = 0;
      return 1;
    }
    this.s = 0;
    return r(paramString);
  }
  
  private String x(String paramString, int paramInt)
  {
    return this.e.concat(" /stream HTTP/1.1\r\n").concat("Host: ").concat(paramString).concat(":").concat(String.valueOf(paramInt)).concat("\r\n");
  }
  
  private void y(String paramString)
  {
    String str = "multipart/mixed".concat("; ").concat("boundary=").concat("--client-stream-boundary--");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("Content-Type", str);
    if (!TextUtils.isEmpty(paramString)) {
      localLinkedHashMap.put("Authorization", paramString);
    }
    localLinkedHashMap.put("User-Agent", System.getProperty("http.agent"));
    localLinkedHashMap.put("Connection", "keep-alive");
    localLinkedHashMap.put("Content-Length", "0");
    b(x(this.a, this.b));
    a(localLinkedHashMap);
  }
  
  private void z(int paramInt)
    throws IOException
  {
    if (paramInt <= 524288)
    {
      if ((!this.f.isClosed()) && (!this.f.isInputShutdown()))
      {
        localObject = new DataInputStream(this.h);
        this.n = 0;
        int i1 = paramInt;
        if (paramInt <= 1024) {}
        for (;;)
        {
          i1 = paramInt;
          do
          {
            int i2 = 1024;
            paramInt = i1;
            i1 = i2;
            if (paramInt <= 0) {
              break;
            }
            i1 = ((DataInputStream)localObject).read(this.l, 0, i1);
            if (i1 < 0) {
              break;
            }
            System.arraycopy(this.l, 0, this.m, this.n, i1);
            this.n += i1;
            paramInt -= i1;
            i1 = paramInt;
          } while (paramInt > 1024);
        }
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("respondRawBuffer length is not enough, contentLength: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IOException(((StringBuilder)localObject).toString());
  }
  
  public void D(Map<String, String> paramMap, String paramString)
    throws IOException
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((paramMap != null) && (!paramMap.isEmpty())) {
      paramMap = l(paramMap);
    } else {
      paramMap = "";
    }
    B("----client-stream-boundary--\r\n".concat(paramMap).concat("Content-Length: ").concat(String.valueOf(paramString.getBytes().length)).concat("\r\n\r\n").concat(paramString).concat("\r\n"));
  }
  
  public void E(Map<String, String> paramMap, byte[] paramArrayOfByte)
    throws Exception
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      if ((paramMap != null) && (!paramMap.isEmpty())) {
        paramMap = l(paramMap);
      } else {
        paramMap = "";
      }
      K("----client-stream-boundary--\r\n".concat(paramMap).concat("Content-Length: ").concat(String.valueOf(paramArrayOfByte.length)).concat("\r\n\r\n"), paramArrayOfByte);
    }
  }
  
  public a F(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public a G(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public a H(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public a I(boolean paramBoolean)
  {
    this.q.set(paramBoolean);
    return this;
  }
  
  public a d()
    throws IOException
  {
    if (this.c <= 0) {
      this.c = 30000;
    }
    if (this.d <= 0) {
      this.d = 15000;
    }
    this.f.connect(new InetSocketAddress(this.a, this.b), this.c);
    this.f.setSoTimeout(this.d);
    this.g = new BufferedOutputStream(this.f.getOutputStream());
    this.h = this.f.getInputStream();
    this.p = 0L;
    return this;
  }
  
  public a e(String paramString)
    throws IOException
  {
    b localb = new b();
    localb.c(b.d.d.d.c.d(paramString));
    localb.d(b.d.d.d.c.e(paramString));
    paramString = new StringBuilder();
    paramString.append("upnp psk  ");
    paramString.append(localb.a());
    paramString.append("  ");
    paramString.append(localb.b());
    b.d.p.d.a("HttpMediaClient", paramString.toString());
    paramString = new b.d.d.k.d(b.d.d.k.f.a.a, b.d.d.k.f.a.b, localb);
    if (this.c <= 0) {
      this.c = 30000;
    }
    if (this.d <= 0) {
      this.d = 15000;
    }
    paramString.b(this.c);
    paramString.c(this.d);
    paramString = paramString.createSocket(this.a, this.b);
    this.f = paramString;
    ((b.d.d.k.c)paramString).connect();
    this.g = new BufferedOutputStream(this.f.getOutputStream());
    this.h = this.f.getInputStream();
    this.p = 0L;
    return this;
  }
  
  public void f()
  {
    J();
    BufferedOutputStream localBufferedOutputStream = this.g;
    if (localBufferedOutputStream != null) {
      try
      {
        localBufferedOutputStream.close();
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
      }
    }
    InputStream localInputStream = this.h;
    if (localInputStream != null) {
      try
      {
        localInputStream.close();
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
      }
    }
    Socket localSocket = this.f;
    if (localSocket != null) {
      try
      {
        localSocket.close();
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
      }
    }
  }
  
  public void g()
    throws Exception
  {
    C(false);
  }
  
  public long j()
  {
    return this.p;
  }
  
  public byte[] m()
  {
    int i1 = this.n;
    byte[] arrayOfByte = new byte[i1];
    System.arraycopy(this.m, 0, arrayOfByte, 0, i1);
    this.n = 0;
    return arrayOfByte;
  }
  
  public Map<String, String> p()
  {
    return this.o;
  }
  
  public int q(String paramString, boolean paramBoolean)
    throws Exception
  {
    y(paramString);
    C(paramBoolean);
    return this.i;
  }
  
  public boolean s()
  {
    return this.q.get();
  }
  
  public void t(String paramString, Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = paramMap;
      if (paramMap == null) {
        localObject = new HashMap();
      }
      this.k.offer(new Pair(paramString, localObject));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreamconnectionsocket\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */