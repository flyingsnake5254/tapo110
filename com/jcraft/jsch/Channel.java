package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Vector;

public abstract class Channel
  implements Runnable
{
  static final int SSH_MSG_CHANNEL_OPEN_CONFIRMATION = 91;
  static final int SSH_MSG_CHANNEL_OPEN_FAILURE = 92;
  static final int SSH_MSG_CHANNEL_WINDOW_ADJUST = 93;
  static final int SSH_OPEN_ADMINISTRATIVELY_PROHIBITED = 1;
  static final int SSH_OPEN_CONNECT_FAILED = 2;
  static final int SSH_OPEN_RESOURCE_SHORTAGE = 4;
  static final int SSH_OPEN_UNKNOWN_CHANNEL_TYPE = 3;
  static int index;
  private static Vector pool = new Vector();
  volatile boolean close = false;
  volatile int connectTimeout = 0;
  volatile boolean connected = false;
  volatile boolean eof_local = false;
  volatile boolean eof_remote = false;
  volatile int exitstatus = -1;
  int id;
  IO io = null;
  volatile int lmpsize = 16384;
  volatile int lwsize = this.lwsize_max;
  volatile int lwsize_max = 1048576;
  int notifyme = 0;
  volatile boolean open_confirmation = false;
  volatile int recipient = -1;
  volatile int reply = 0;
  volatile int rmpsize = 0;
  volatile long rwsize = 0L;
  private Session session;
  Thread thread = null;
  protected byte[] type = Util.str2byte("foo");
  
  Channel()
  {
    synchronized (pool)
    {
      int i = index;
      index = i + 1;
      this.id = i;
      pool.addElement(this);
      return;
    }
  }
  
  static void del(Channel paramChannel)
  {
    synchronized (pool)
    {
      pool.removeElement(paramChannel);
      return;
    }
  }
  
  static void disconnect(Session paramSession)
  {
    synchronized (pool)
    {
      Channel[] arrayOfChannel = new Channel[pool.size()];
      int i = 0;
      int j = 0;
      for (k = 0;; k = m)
      {
        int m = pool.size();
        if (j >= m) {
          break;
        }
        try
        {
          Channel localChannel = (Channel)pool.elementAt(j);
          Session localSession = localChannel.session;
          m = k;
          if (localSession == paramSession)
          {
            arrayOfChannel[k] = localChannel;
            m = k + 1;
          }
          j++;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            m = k;
          }
        }
      }
      for (j = i; j < k; j++) {
        arrayOfChannel[j].disconnect();
      }
      return;
    }
  }
  
  static Channel getChannel(int paramInt, Session paramSession)
  {
    Vector localVector = pool;
    int i = 0;
    try
    {
      while (i < pool.size())
      {
        Channel localChannel = (Channel)pool.elementAt(i);
        if ((localChannel.id == paramInt) && (localChannel.session == paramSession)) {
          return localChannel;
        }
        i++;
      }
      return null;
    }
    finally {}
  }
  
  static Channel getChannel(String paramString)
  {
    if (paramString.equals("session")) {
      return new ChannelSession();
    }
    if (paramString.equals("shell")) {
      return new ChannelShell();
    }
    if (paramString.equals("exec")) {
      return new ChannelExec();
    }
    if (paramString.equals("x11")) {
      return new ChannelX11();
    }
    if (paramString.equals("auth-agent@openssh.com")) {
      return new ChannelAgentForwarding();
    }
    if (paramString.equals("direct-tcpip")) {
      return new ChannelDirectTCPIP();
    }
    if (paramString.equals("forwarded-tcpip")) {
      return new ChannelForwardedTCPIP();
    }
    if (paramString.equals("sftp")) {
      return new ChannelSftp();
    }
    if (paramString.equals("subsystem")) {
      return new ChannelSubsystem();
    }
    return null;
  }
  
  void addRemoteWindowSize(long paramLong)
  {
    try
    {
      this.rwsize += paramLong;
      if (this.notifyme > 0) {
        notifyAll();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void close()
  {
    if (this.close) {
      return;
    }
    this.close = true;
    this.eof_remote = true;
    this.eof_local = true;
    int i = getRecipient();
    if (i == -1) {
      return;
    }
    try
    {
      Buffer localBuffer = new com/jcraft/jsch/Buffer;
      localBuffer.<init>(100);
      Packet localPacket = new com/jcraft/jsch/Packet;
      localPacket.<init>(localBuffer);
      localPacket.reset();
      localBuffer.putByte((byte)97);
      localBuffer.putInt(i);
      try
      {
        getSession().write(localPacket);
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void connect()
    throws JSchException
  {
    connect(0);
  }
  
  public void connect(int paramInt)
    throws JSchException
  {
    this.connectTimeout = paramInt;
    try
    {
      sendChannelOpen();
      start();
      return;
    }
    catch (Exception localException)
    {
      this.connected = false;
      disconnect();
      if ((localException instanceof JSchException)) {
        throw ((JSchException)localException);
      }
      throw new JSchException(localException.toString(), localException);
    }
  }
  
  public void disconnect()
  {
    for (;;)
    {
      try
      {
        IO localIO;
        try
        {
          if (!this.connected) {
            return;
          }
          this.connected = false;
          close();
          this.eof_local = true;
          this.eof_remote = true;
          this.thread = null;
        }
        finally {}
      }
      finally
      {
        del(this);
      }
      try
      {
        localIO = this.io;
        if (localIO != null) {
          localIO.close();
        }
      }
      catch (Exception localException) {}
    }
    del(this);
  }
  
  void eof()
  {
    if (this.eof_local) {
      return;
    }
    this.eof_local = true;
    int i = getRecipient();
    if (i == -1) {
      return;
    }
    try
    {
      Buffer localBuffer = new com/jcraft/jsch/Buffer;
      localBuffer.<init>(100);
      Packet localPacket = new com/jcraft/jsch/Packet;
      localPacket.<init>(localBuffer);
      localPacket.reset();
      localBuffer.putByte((byte)96);
      localBuffer.putInt(i);
      try
      {
        if (!this.close) {
          getSession().write(localPacket);
        }
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  void eof_remote()
  {
    this.eof_remote = true;
    try
    {
      this.io.out_close();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
  }
  
  protected Packet genChannelOpenPacket()
  {
    Buffer localBuffer = new Buffer(100);
    Packet localPacket = new Packet(localBuffer);
    localPacket.reset();
    localBuffer.putByte((byte)90);
    localBuffer.putString(this.type);
    localBuffer.putInt(this.id);
    localBuffer.putInt(this.lwsize);
    localBuffer.putInt(this.lmpsize);
    return localPacket;
  }
  
  void getData(Buffer paramBuffer)
  {
    setRecipient(paramBuffer.getInt());
    setRemoteWindowSize(paramBuffer.getUInt());
    setRemotePacketSize(paramBuffer.getInt());
  }
  
  public int getExitStatus()
  {
    return this.exitstatus;
  }
  
  public InputStream getExtInputStream()
    throws IOException
  {
    int i;
    try
    {
      i = Integer.parseInt(getSession().getConfig("max_input_buffer_size"));
    }
    catch (Exception localException)
    {
      i = 32768;
    }
    MyPipedInputStream localMyPipedInputStream = new MyPipedInputStream(32768, i);
    boolean bool;
    if (32768 < i) {
      bool = true;
    } else {
      bool = false;
    }
    this.io.setExtOutputStream(new PassiveOutputStream(localMyPipedInputStream, bool), false);
    return localMyPipedInputStream;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    int i;
    try
    {
      i = Integer.parseInt(getSession().getConfig("max_input_buffer_size"));
    }
    catch (Exception localException)
    {
      i = 32768;
    }
    MyPipedInputStream localMyPipedInputStream = new MyPipedInputStream(32768, i);
    boolean bool;
    if (32768 < i) {
      bool = true;
    } else {
      bool = false;
    }
    this.io.setOutputStream(new PassiveOutputStream(localMyPipedInputStream, bool), false);
    return localMyPipedInputStream;
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    new OutputStream()
    {
      byte[] b = new byte[1];
      private Buffer buffer = null;
      private boolean closed = false;
      private int dataLen = 0;
      private Packet packet = null;
      
      private void init()
        throws IOException
      {
        try
        {
          Object localObject1 = new com/jcraft/jsch/Buffer;
          ((Buffer)localObject1).<init>(Channel.this.rmpsize);
          this.buffer = ((Buffer)localObject1);
          localObject1 = new com/jcraft/jsch/Packet;
          ((Packet)localObject1).<init>(this.buffer);
          this.packet = ((Packet)localObject1);
          int i = this.buffer.buffer.length;
          if (i - 14 - 128 > 0) {
            return;
          }
          this.buffer = null;
          this.packet = null;
          localObject1 = new java/io/IOException;
          ((IOException)localObject1).<init>("failed to initialize the channel.");
          throw ((Throwable)localObject1);
        }
        finally {}
      }
      
      public void close()
        throws IOException
      {
        if (this.packet == null) {
          try
          {
            init();
          }
          catch (IOException localIOException)
          {
            return;
          }
        }
        if (this.closed) {
          return;
        }
        if (this.dataLen > 0) {
          flush();
        }
        jdField_this.eof();
        this.closed = true;
      }
      
      public void flush()
        throws IOException
      {
        if (!this.closed)
        {
          if (this.dataLen == 0) {
            return;
          }
          this.packet.reset();
          this.buffer.putByte((byte)94);
          this.buffer.putInt(Channel.this.recipient);
          this.buffer.putInt(this.dataLen);
          this.buffer.skip(this.dataLen);
          try
          {
            int i = this.dataLen;
            this.dataLen = 0;
            synchronized (jdField_this)
            {
              if (!jdField_this.close) {
                Channel.this.getSession().write(this.packet, jdField_this, i);
              }
              return;
            }
            throw new IOException("Already closed");
          }
          catch (Exception localException)
          {
            close();
            throw new IOException(localException.toString());
          }
        }
      }
      
      public void write(int paramAnonymousInt)
        throws IOException
      {
        byte[] arrayOfByte = this.b;
        arrayOfByte[0] = ((byte)(byte)paramAnonymousInt);
        write(arrayOfByte, 0, 1);
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        if (this.packet == null) {
          init();
        }
        if (!this.closed)
        {
          byte[] arrayOfByte = this.buffer.buffer;
          int i = arrayOfByte.length;
          while (paramAnonymousInt2 > 0)
          {
            int j = this.dataLen;
            int k;
            if (paramAnonymousInt2 > i - (j + 14) - 128) {
              k = i - (j + 14) - 128;
            } else {
              k = paramAnonymousInt2;
            }
            if (k <= 0)
            {
              flush();
            }
            else
            {
              System.arraycopy(paramAnonymousArrayOfByte, paramAnonymousInt1, arrayOfByte, j + 14, k);
              this.dataLen += k;
              paramAnonymousInt1 += k;
              paramAnonymousInt2 -= k;
            }
          }
          return;
        }
        throw new IOException("Already closed");
      }
    };
  }
  
  int getRecipient()
  {
    return this.recipient;
  }
  
  public Session getSession()
    throws JSchException
  {
    Session localSession = this.session;
    if (localSession != null) {
      return localSession;
    }
    throw new JSchException("session is not available");
  }
  
  void init()
    throws JSchException
  {}
  
  public boolean isClosed()
  {
    return this.close;
  }
  
  public boolean isConnected()
  {
    Session localSession = this.session;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (localSession != null)
    {
      bool2 = bool1;
      if (localSession.isConnected())
      {
        bool2 = bool1;
        if (this.connected) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public boolean isEOF()
  {
    return this.eof_remote;
  }
  
  public void run() {}
  
  /* Error */
  protected void sendChannelOpen()
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 231	com/jcraft/jsch/Channel:getSession	()Lcom/jcraft/jsch/Session;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual 341	com/jcraft/jsch/Session:isConnected	()Z
    //   9: ifeq +203 -> 212
    //   12: aload_1
    //   13: aload_0
    //   14: invokevirtual 347	com/jcraft/jsch/Channel:genChannelOpenPacket	()Lcom/jcraft/jsch/Packet;
    //   17: invokevirtual 237	com/jcraft/jsch/Session:write	(Lcom/jcraft/jsch/Packet;)V
    //   20: sipush 2000
    //   23: istore_2
    //   24: invokestatic 352	java/lang/System:currentTimeMillis	()J
    //   27: lstore_3
    //   28: aload_0
    //   29: getfield 115	com/jcraft/jsch/Channel:connectTimeout	I
    //   32: i2l
    //   33: lstore 5
    //   35: lload 5
    //   37: lconst_0
    //   38: lcmp
    //   39: istore 7
    //   41: iload 7
    //   43: ifeq +5 -> 48
    //   46: iconst_1
    //   47: istore_2
    //   48: aload_0
    //   49: monitorenter
    //   50: aload_0
    //   51: invokevirtual 207	com/jcraft/jsch/Channel:getRecipient	()I
    //   54: iconst_m1
    //   55: if_icmpne +89 -> 144
    //   58: aload_1
    //   59: invokevirtual 341	com/jcraft/jsch/Session:isConnected	()Z
    //   62: ifeq +82 -> 144
    //   65: iload_2
    //   66: ifle +78 -> 144
    //   69: iload 7
    //   71: ifle +23 -> 94
    //   74: invokestatic 352	java/lang/System:currentTimeMillis	()J
    //   77: lstore 8
    //   79: lload 8
    //   81: lload_3
    //   82: lsub
    //   83: lload 5
    //   85: lcmp
    //   86: ifle +8 -> 94
    //   89: iconst_0
    //   90: istore_2
    //   91: goto -41 -> 50
    //   94: iload 7
    //   96: ifne +11 -> 107
    //   99: ldc2_w 353
    //   102: lstore 8
    //   104: goto +7 -> 111
    //   107: lload 5
    //   109: lstore 8
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 117	com/jcraft/jsch/Channel:notifyme	I
    //   116: aload_0
    //   117: lload 8
    //   119: invokevirtual 357	java/lang/Object:wait	(J)V
    //   122: aload_0
    //   123: iconst_0
    //   124: putfield 117	com/jcraft/jsch/Channel:notifyme	I
    //   127: goto +11 -> 138
    //   130: astore_1
    //   131: aload_0
    //   132: iconst_0
    //   133: putfield 117	com/jcraft/jsch/Channel:notifyme	I
    //   136: aload_1
    //   137: athrow
    //   138: iinc 2 -1
    //   141: goto -91 -> 50
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_1
    //   147: invokevirtual 341	com/jcraft/jsch/Session:isConnected	()Z
    //   150: ifeq +46 -> 196
    //   153: aload_0
    //   154: invokevirtual 207	com/jcraft/jsch/Channel:getRecipient	()I
    //   157: iconst_m1
    //   158: if_icmpeq +27 -> 185
    //   161: aload_0
    //   162: getfield 109	com/jcraft/jsch/Channel:open_confirmation	Z
    //   165: ifeq +9 -> 174
    //   168: aload_0
    //   169: iconst_1
    //   170: putfield 107	com/jcraft/jsch/Channel:connected	Z
    //   173: return
    //   174: new 240	com/jcraft/jsch/JSchException
    //   177: dup
    //   178: ldc_w 359
    //   181: invokespecial 335	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   184: athrow
    //   185: new 240	com/jcraft/jsch/JSchException
    //   188: dup
    //   189: ldc_w 359
    //   192: invokespecial 335	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   195: athrow
    //   196: new 240	com/jcraft/jsch/JSchException
    //   199: dup
    //   200: ldc_w 361
    //   203: invokespecial 335	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   206: athrow
    //   207: astore_1
    //   208: aload_0
    //   209: monitorexit
    //   210: aload_1
    //   211: athrow
    //   212: new 240	com/jcraft/jsch/JSchException
    //   215: dup
    //   216: ldc_w 361
    //   219: invokespecial 335	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   222: athrow
    //   223: astore 10
    //   225: goto -103 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	Channel
    //   4	55	1	localSession	Session
    //   130	17	1	localObject1	Object
    //   207	4	1	localObject2	Object
    //   23	116	2	i	int
    //   27	55	3	l1	long
    //   33	75	5	l2	long
    //   39	56	7	bool	boolean
    //   77	41	8	l3	long
    //   223	1	10	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   111	122	130	finally
    //   50	65	207	finally
    //   74	79	207	finally
    //   122	127	207	finally
    //   131	138	207	finally
    //   144	146	207	finally
    //   208	210	207	finally
    //   111	122	223	java/lang/InterruptedException
  }
  
  protected void sendOpenConfirmation()
    throws Exception
  {
    Buffer localBuffer = new Buffer(100);
    Packet localPacket = new Packet(localBuffer);
    localPacket.reset();
    localBuffer.putByte((byte)91);
    localBuffer.putInt(getRecipient());
    localBuffer.putInt(this.id);
    localBuffer.putInt(this.lwsize);
    localBuffer.putInt(this.lmpsize);
    getSession().write(localPacket);
  }
  
  protected void sendOpenFailure(int paramInt)
  {
    try
    {
      Buffer localBuffer = new com/jcraft/jsch/Buffer;
      localBuffer.<init>(100);
      Packet localPacket = new com/jcraft/jsch/Packet;
      localPacket.<init>(localBuffer);
      localPacket.reset();
      localBuffer.putByte((byte)92);
      localBuffer.putInt(getRecipient());
      localBuffer.putInt(paramInt);
      localBuffer.putString(Util.str2byte("open failed"));
      localBuffer.putString(Util.empty);
      getSession().write(localPacket);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void sendSignal(String paramString)
    throws Exception
  {
    RequestSignal localRequestSignal = new RequestSignal();
    localRequestSignal.setSignal(paramString);
    localRequestSignal.request(getSession(), this);
  }
  
  void setExitStatus(int paramInt)
  {
    this.exitstatus = paramInt;
  }
  
  public void setExtOutputStream(OutputStream paramOutputStream)
  {
    this.io.setExtOutputStream(paramOutputStream, false);
  }
  
  public void setExtOutputStream(OutputStream paramOutputStream, boolean paramBoolean)
  {
    this.io.setExtOutputStream(paramOutputStream, paramBoolean);
  }
  
  public void setInputStream(InputStream paramInputStream)
  {
    this.io.setInputStream(paramInputStream, false);
  }
  
  public void setInputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    this.io.setInputStream(paramInputStream, paramBoolean);
  }
  
  void setLocalPacketSize(int paramInt)
  {
    this.lmpsize = paramInt;
  }
  
  void setLocalWindowSize(int paramInt)
  {
    this.lwsize = paramInt;
  }
  
  void setLocalWindowSizeMax(int paramInt)
  {
    this.lwsize_max = paramInt;
  }
  
  public void setOutputStream(OutputStream paramOutputStream)
  {
    this.io.setOutputStream(paramOutputStream, false);
  }
  
  public void setOutputStream(OutputStream paramOutputStream, boolean paramBoolean)
  {
    this.io.setOutputStream(paramOutputStream, paramBoolean);
  }
  
  void setRecipient(int paramInt)
  {
    try
    {
      this.recipient = paramInt;
      if (this.notifyme > 0) {
        notifyAll();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void setRemotePacketSize(int paramInt)
  {
    this.rmpsize = paramInt;
  }
  
  void setRemoteWindowSize(long paramLong)
  {
    try
    {
      this.rwsize = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void setSession(Session paramSession)
  {
    this.session = paramSession;
  }
  
  public void setXForwarding(boolean paramBoolean) {}
  
  public void start()
    throws JSchException
  {}
  
  void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      this.io.put(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (NullPointerException paramArrayOfByte)
    {
      for (;;) {}
    }
  }
  
  void write_ext(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      this.io.put_ext(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (NullPointerException paramArrayOfByte)
    {
      for (;;) {}
    }
  }
  
  class MyPipedInputStream
    extends PipedInputStream
  {
    private int BUFFER_SIZE = 1024;
    private int max_buffer_size = 1024;
    
    MyPipedInputStream()
      throws IOException
    {}
    
    MyPipedInputStream(int paramInt)
      throws IOException
    {
      this.buffer = new byte[paramInt];
      this.BUFFER_SIZE = paramInt;
      this.max_buffer_size = paramInt;
    }
    
    MyPipedInputStream(int paramInt1, int paramInt2)
      throws IOException
    {
      this(paramInt1);
      this.max_buffer_size = paramInt2;
    }
    
    MyPipedInputStream(PipedOutputStream paramPipedOutputStream)
      throws IOException
    {
      super();
    }
    
    MyPipedInputStream(PipedOutputStream paramPipedOutputStream, int paramInt)
      throws IOException
    {
      super();
      this.buffer = new byte[paramInt];
      this.BUFFER_SIZE = paramInt;
    }
    
    private int freeSpace()
    {
      int i = this.out;
      int j = this.in;
      if (i < j) {
        i = this.buffer.length;
      }
      do
      {
        i -= j;
        return i;
        if (j >= i) {
          break;
        }
      } while (j != -1);
      return this.buffer.length;
      i = 0;
      return i;
    }
    
    void checkSpace(int paramInt)
      throws IOException
    {
      try
      {
        int i = freeSpace();
        if (i < paramInt)
        {
          byte[] arrayOfByte1 = this.buffer;
          int j = arrayOfByte1.length - i;
          i = arrayOfByte1.length;
          while (i - j < paramInt) {
            i *= 2;
          }
          int k = this.max_buffer_size;
          int m = i;
          if (i > k) {
            m = k;
          }
          if (m - j < paramInt) {
            return;
          }
          arrayOfByte1 = new byte[m];
          paramInt = this.out;
          i = this.in;
          byte[] arrayOfByte2;
          if (paramInt < i)
          {
            arrayOfByte2 = this.buffer;
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
          }
          else if (i < paramInt)
          {
            if (i != -1)
            {
              System.arraycopy(this.buffer, 0, arrayOfByte1, 0, i);
              arrayOfByte2 = this.buffer;
              paramInt = this.out;
              System.arraycopy(arrayOfByte2, paramInt, arrayOfByte1, m - (arrayOfByte2.length - paramInt), arrayOfByte2.length - paramInt);
              this.out = (m - (this.buffer.length - this.out));
            }
          }
          else if (i == paramInt)
          {
            arrayOfByte2 = this.buffer;
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
            this.in = this.buffer.length;
          }
          this.buffer = arrayOfByte1;
        }
        else if (this.buffer.length == i)
        {
          paramInt = this.BUFFER_SIZE;
          if (i > paramInt)
          {
            i /= 2;
            if (i >= paramInt) {
              paramInt = i;
            }
            this.buffer = new byte[paramInt];
          }
        }
        return;
      }
      finally {}
    }
    
    public void updateReadSide()
      throws IOException
    {
      try
      {
        int i = available();
        if (i != 0) {
          return;
        }
        this.in = 0;
        this.out = 0;
        byte[] arrayOfByte = this.buffer;
        this.in = (0 + 1);
        arrayOfByte[0] = ((byte)0);
        read();
        return;
      }
      finally {}
    }
  }
  
  class PassiveInputStream
    extends Channel.MyPipedInputStream
  {
    PipedOutputStream out;
    
    PassiveInputStream(PipedOutputStream paramPipedOutputStream)
      throws IOException
    {
      super(paramPipedOutputStream);
      this.out = paramPipedOutputStream;
    }
    
    PassiveInputStream(PipedOutputStream paramPipedOutputStream, int paramInt)
      throws IOException
    {
      super(paramPipedOutputStream, paramInt);
      this.out = paramPipedOutputStream;
    }
    
    public void close()
      throws IOException
    {
      PipedOutputStream localPipedOutputStream = this.out;
      if (localPipedOutputStream != null) {
        localPipedOutputStream.close();
      }
      this.out = null;
    }
  }
  
  class PassiveOutputStream
    extends PipedOutputStream
  {
    private Channel.MyPipedInputStream _sink = null;
    
    PassiveOutputStream(PipedInputStream paramPipedInputStream, boolean paramBoolean)
      throws IOException
    {
      super();
      if ((paramBoolean) && ((paramPipedInputStream instanceof Channel.MyPipedInputStream))) {
        this._sink = ((Channel.MyPipedInputStream)paramPipedInputStream);
      }
    }
    
    public void write(int paramInt)
      throws IOException
    {
      Channel.MyPipedInputStream localMyPipedInputStream = this._sink;
      if (localMyPipedInputStream != null) {
        localMyPipedInputStream.checkSpace(1);
      }
      super.write(paramInt);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      Channel.MyPipedInputStream localMyPipedInputStream = this._sink;
      if (localMyPipedInputStream != null) {
        localMyPipedInputStream.checkSpace(paramInt2);
      }
      super.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Channel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */