package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

public class Session
  implements Runnable
{
  private static final int PACKET_MAX_SIZE = 262144;
  static final int SSH_MSG_CHANNEL_CLOSE = 97;
  static final int SSH_MSG_CHANNEL_DATA = 94;
  static final int SSH_MSG_CHANNEL_EOF = 96;
  static final int SSH_MSG_CHANNEL_EXTENDED_DATA = 95;
  static final int SSH_MSG_CHANNEL_FAILURE = 100;
  static final int SSH_MSG_CHANNEL_OPEN = 90;
  static final int SSH_MSG_CHANNEL_OPEN_CONFIRMATION = 91;
  static final int SSH_MSG_CHANNEL_OPEN_FAILURE = 92;
  static final int SSH_MSG_CHANNEL_REQUEST = 98;
  static final int SSH_MSG_CHANNEL_SUCCESS = 99;
  static final int SSH_MSG_CHANNEL_WINDOW_ADJUST = 93;
  static final int SSH_MSG_DEBUG = 4;
  static final int SSH_MSG_DISCONNECT = 1;
  static final int SSH_MSG_GLOBAL_REQUEST = 80;
  static final int SSH_MSG_IGNORE = 2;
  static final int SSH_MSG_KEXDH_INIT = 30;
  static final int SSH_MSG_KEXDH_REPLY = 31;
  static final int SSH_MSG_KEXINIT = 20;
  static final int SSH_MSG_KEX_DH_GEX_GROUP = 31;
  static final int SSH_MSG_KEX_DH_GEX_INIT = 32;
  static final int SSH_MSG_KEX_DH_GEX_REPLY = 33;
  static final int SSH_MSG_KEX_DH_GEX_REQUEST = 34;
  static final int SSH_MSG_NEWKEYS = 21;
  static final int SSH_MSG_REQUEST_FAILURE = 82;
  static final int SSH_MSG_REQUEST_SUCCESS = 81;
  static final int SSH_MSG_SERVICE_ACCEPT = 6;
  static final int SSH_MSG_SERVICE_REQUEST = 5;
  static final int SSH_MSG_UNIMPLEMENTED = 3;
  static final int buffer_margin = 128;
  private static final byte[] keepalivemsg = Util.str2byte("keepalive@jcraft.com");
  private static final byte[] nomoresessions = Util.str2byte("no-more-sessions@openssh.com");
  static Random random;
  private byte[] Ec2s;
  private byte[] Es2c;
  private byte[] IVc2s;
  private byte[] IVs2c;
  private byte[] I_C;
  private byte[] I_S;
  private byte[] K_S;
  private byte[] MACc2s;
  private byte[] MACs2c;
  private byte[] V_C = Util.str2byte("SSH-2.0-JSCH-0.1.54");
  private byte[] V_S;
  boolean agent_forwarding = false;
  int auth_failures = 0;
  Buffer buf;
  private Cipher c2scipher;
  private int c2scipher_size = 8;
  private MAC c2smac;
  int[] compress_len = new int[1];
  private Hashtable config = null;
  private Thread connectThread = null;
  protected boolean daemon_thread = false;
  private Compression deflater;
  private GlobalRequestReply grr = new GlobalRequestReply(null);
  String[] guess = null;
  String host = "127.0.0.1";
  private String hostKeyAlias = null;
  private HostKey hostkey = null;
  private HostKeyRepository hostkeyRepository = null;
  private IdentityRepository identityRepository = null;
  InputStream in = null;
  private volatile boolean in_kex = false;
  private volatile boolean in_prompt = false;
  private Compression inflater;
  private IO io;
  private boolean isAuthed = false;
  private volatile boolean isConnected = false;
  JSch jsch;
  private long kex_start_time = 0L;
  private Object lock = new Object();
  int max_auth_tries = 6;
  String org_host = "127.0.0.1";
  OutputStream out = null;
  Packet packet;
  byte[] password = null;
  int port = 22;
  private Proxy proxy = null;
  private Cipher s2ccipher;
  private int s2ccipher_size = 8;
  private MAC s2cmac;
  private byte[] s2cmac_result1;
  private byte[] s2cmac_result2;
  private int seqi = 0;
  private int seqo = 0;
  private int serverAliveCountMax = 1;
  private int serverAliveInterval = 0;
  private byte[] session_id;
  private Socket socket;
  SocketFactory socket_factory = null;
  Runnable thread;
  private int timeout = 0;
  int[] uncompress_len = new int[1];
  private UserInfo userinfo;
  String username = null;
  boolean x11_forwarding = false;
  
  Session(JSch paramJSch, String paramString1, String paramString2, int paramInt)
    throws JSchException
  {
    this.jsch = paramJSch;
    this.buf = new Buffer();
    this.packet = new Packet(this.buf);
    this.username = paramString1;
    this.host = paramString2;
    this.org_host = paramString2;
    this.port = paramInt;
    applyConfig();
    if (this.username == null) {
      try
      {
        this.username = ((String)System.getProperties().get("user.name"));
      }
      catch (SecurityException paramJSch) {}
    }
    if (this.username != null) {
      return;
    }
    throw new JSchException("username is not given.");
  }
  
  /* Error */
  private int _setPortForwardingR(String paramString, int paramInt)
    throws JSchException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: new 281	com/jcraft/jsch/Buffer
    //   10: astore 4
    //   12: aload 4
    //   14: bipush 100
    //   16: invokespecial 323	com/jcraft/jsch/Buffer:<init>	(I)V
    //   19: new 286	com/jcraft/jsch/Packet
    //   22: astore 5
    //   24: aload 5
    //   26: aload 4
    //   28: invokespecial 289	com/jcraft/jsch/Packet:<init>	(Lcom/jcraft/jsch/Buffer;)V
    //   31: aload_1
    //   32: invokestatic 329	com/jcraft/jsch/ChannelForwardedTCPIP:normalize	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_1
    //   36: aload_0
    //   37: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   40: invokestatic 335	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   43: invokevirtual 339	com/jcraft/jsch/Session$GlobalRequestReply:setThread	(Ljava/lang/Thread;)V
    //   46: aload_0
    //   47: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   50: iload_2
    //   51: invokevirtual 342	com/jcraft/jsch/Session$GlobalRequestReply:setPort	(I)V
    //   54: aload 5
    //   56: invokevirtual 345	com/jcraft/jsch/Packet:reset	()V
    //   59: aload 4
    //   61: bipush 80
    //   63: invokevirtual 349	com/jcraft/jsch/Buffer:putByte	(B)V
    //   66: aload 4
    //   68: ldc_w 351
    //   71: invokestatic 179	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;)[B
    //   74: invokevirtual 355	com/jcraft/jsch/Buffer:putString	([B)V
    //   77: aload 4
    //   79: iconst_1
    //   80: invokevirtual 349	com/jcraft/jsch/Buffer:putByte	(B)V
    //   83: aload 4
    //   85: aload_1
    //   86: invokestatic 179	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;)[B
    //   89: invokevirtual 355	com/jcraft/jsch/Buffer:putString	([B)V
    //   92: aload 4
    //   94: iload_2
    //   95: invokevirtual 358	com/jcraft/jsch/Buffer:putInt	(I)V
    //   98: aload_0
    //   99: aload 5
    //   101: invokevirtual 362	com/jcraft/jsch/Session:write	(Lcom/jcraft/jsch/Packet;)V
    //   104: iconst_0
    //   105: istore 6
    //   107: aload_0
    //   108: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   111: invokevirtual 366	com/jcraft/jsch/Session$GlobalRequestReply:getReply	()I
    //   114: istore 7
    //   116: iload 6
    //   118: bipush 10
    //   120: if_icmpge +30 -> 150
    //   123: iload 7
    //   125: iconst_m1
    //   126: if_icmpne +24 -> 150
    //   129: ldc2_w 367
    //   132: invokestatic 372	java/lang/Thread:sleep	(J)V
    //   135: iinc 6 1
    //   138: aload_0
    //   139: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   142: invokevirtual 366	com/jcraft/jsch/Session$GlobalRequestReply:getReply	()I
    //   145: istore 7
    //   147: goto -31 -> 116
    //   150: aload_0
    //   151: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   154: aconst_null
    //   155: invokevirtual 339	com/jcraft/jsch/Session$GlobalRequestReply:setThread	(Ljava/lang/Thread;)V
    //   158: iload 7
    //   160: iconst_1
    //   161: if_icmpne +15 -> 176
    //   164: aload_0
    //   165: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   168: invokevirtual 375	com/jcraft/jsch/Session$GlobalRequestReply:getPort	()I
    //   171: istore_2
    //   172: aload_3
    //   173: monitorexit
    //   174: iload_2
    //   175: ireturn
    //   176: new 190	com/jcraft/jsch/JSchException
    //   179: astore_1
    //   180: new 377	java/lang/StringBuilder
    //   183: astore 5
    //   185: aload 5
    //   187: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   190: aload 5
    //   192: ldc_w 380
    //   195: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: iload_2
    //   202: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: aload 5
    //   209: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   215: aload_1
    //   216: athrow
    //   217: astore_1
    //   218: aload_0
    //   219: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   222: aconst_null
    //   223: invokevirtual 339	com/jcraft/jsch/Session$GlobalRequestReply:setThread	(Ljava/lang/Thread;)V
    //   226: new 190	com/jcraft/jsch/JSchException
    //   229: astore 5
    //   231: aload 5
    //   233: aload_1
    //   234: invokevirtual 392	java/lang/Exception:toString	()Ljava/lang/String;
    //   237: aload_1
    //   238: invokespecial 395	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   241: aload 5
    //   243: athrow
    //   244: astore_1
    //   245: aload_3
    //   246: monitorexit
    //   247: aload_1
    //   248: athrow
    //   249: astore_1
    //   250: goto -115 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	Session
    //   0	253	1	paramString	String
    //   0	253	2	paramInt	int
    //   4	242	3	localGlobalRequestReply	GlobalRequestReply
    //   10	83	4	localBuffer	Buffer
    //   22	220	5	localObject	Object
    //   105	31	6	i	int
    //   114	48	7	j	int
    // Exception table:
    //   from	to	target	type
    //   54	104	217	java/lang/Exception
    //   7	54	244	finally
    //   54	104	244	finally
    //   107	116	244	finally
    //   129	135	244	finally
    //   138	147	244	finally
    //   150	158	244	finally
    //   164	174	244	finally
    //   176	217	244	finally
    //   218	244	244	finally
    //   245	247	244	finally
    //   129	135	249	java/lang/Exception
  }
  
  private void _write(Packet paramPacket)
    throws Exception
  {
    synchronized (this.lock)
    {
      encode(paramPacket);
      IO localIO = this.io;
      if (localIO != null)
      {
        localIO.put(paramPacket);
        this.seqo += 1;
      }
      return;
    }
  }
  
  private void applyConfig()
    throws JSchException
  {
    Object localObject1 = this.jsch.getConfigRepository();
    if (localObject1 == null) {
      return;
    }
    ConfigRepository.Config localConfig = ((ConfigRepository)localObject1).getConfig(this.org_host);
    if (this.username == null)
    {
      localObject2 = localConfig.getUser();
      if (localObject2 != null) {
        this.username = ((String)localObject2);
      }
    }
    Object localObject2 = localConfig.getHostname();
    if (localObject2 != null) {
      this.host = ((String)localObject2);
    }
    int i = localConfig.getPort();
    if (i != -1) {
      this.port = i;
    }
    checkConfig(localConfig, "kex");
    checkConfig(localConfig, "server_host_key");
    checkConfig(localConfig, "cipher.c2s");
    checkConfig(localConfig, "cipher.s2c");
    checkConfig(localConfig, "mac.c2s");
    checkConfig(localConfig, "mac.s2c");
    checkConfig(localConfig, "compression.c2s");
    checkConfig(localConfig, "compression.s2c");
    checkConfig(localConfig, "compression_level");
    checkConfig(localConfig, "StrictHostKeyChecking");
    checkConfig(localConfig, "HashKnownHosts");
    checkConfig(localConfig, "PreferredAuthentications");
    checkConfig(localConfig, "MaxAuthTries");
    checkConfig(localConfig, "ClearAllForwardings");
    localObject2 = localConfig.getValue("HostKeyAlias");
    if (localObject2 != null) {
      setHostKeyAlias((String)localObject2);
    }
    localObject2 = localConfig.getValue("UserKnownHostsFile");
    KnownHosts localKnownHosts;
    if (localObject2 != null)
    {
      localKnownHosts = new KnownHosts(this.jsch);
      localKnownHosts.setKnownHosts((String)localObject2);
      setHostKeyRepository(localKnownHosts);
    }
    String[] arrayOfString = localConfig.getValues("IdentityFile");
    if (arrayOfString != null)
    {
      localObject2 = ((ConfigRepository)localObject1).getConfig("").getValues("IdentityFile");
      if (localObject2 != null) {
        for (i = 0;; i++)
        {
          localObject1 = localObject2;
          if (i >= localObject2.length) {
            break;
          }
          this.jsch.addIdentity(localObject2[i]);
        }
      }
      localObject1 = new String[0];
      if (arrayOfString.length - localObject1.length > 0)
      {
        IdentityRepository.Wrapper localWrapper = new IdentityRepository.Wrapper(this.jsch.getIdentityRepository(), true);
        for (i = 0; i < arrayOfString.length; i++)
        {
          localKnownHosts = arrayOfString[i];
          for (int j = 0;; j++)
          {
            localObject2 = localKnownHosts;
            if (j >= localObject1.length) {
              break label402;
            }
            if (localKnownHosts.equals(localObject1[j])) {
              break;
            }
          }
          localObject2 = null;
          label402:
          if (localObject2 != null) {
            localWrapper.add(IdentityFile.newInstance((String)localObject2, null, this.jsch));
          }
        }
        setIdentityRepository(localWrapper);
      }
    }
    localObject1 = localConfig.getValue("ServerAliveInterval");
    if (localObject1 != null) {
      try
      {
        setServerAliveInterval(Integer.parseInt((String)localObject1));
      }
      catch (NumberFormatException localNumberFormatException1) {}
    }
    String str1 = localConfig.getValue("ConnectTimeout");
    if (str1 != null) {
      try
      {
        setTimeout(Integer.parseInt(str1));
      }
      catch (NumberFormatException localNumberFormatException2) {}
    }
    String str2 = localConfig.getValue("MaxAuthTries");
    if (str2 != null) {
      setConfig("MaxAuthTries", str2);
    }
    str2 = localConfig.getValue("ClearAllForwardings");
    if (str2 != null) {
      setConfig("ClearAllForwardings", str2);
    }
  }
  
  private void applyConfigChannel(ChannelSession paramChannelSession)
    throws JSchException
  {
    Object localObject = this.jsch.getConfigRepository();
    if (localObject == null) {
      return;
    }
    ConfigRepository.Config localConfig = ((ConfigRepository)localObject).getConfig(this.org_host);
    localObject = localConfig.getValue("ForwardAgent");
    if (localObject != null) {
      paramChannelSession.setAgentForwarding(((String)localObject).equals("yes"));
    }
    localObject = localConfig.getValue("RequestTTY");
    if (localObject != null) {
      paramChannelSession.setPty(((String)localObject).equals("yes"));
    }
  }
  
  static boolean checkCipher(String paramString)
  {
    try
    {
      paramString = (Cipher)Class.forName(paramString).newInstance();
      paramString.init(0, new byte[paramString.getBlockSize()], new byte[paramString.getIVSize()]);
      return true;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  private String[] checkCiphers(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (paramString != null) {
      if (paramString.length() == 0)
      {
        localObject2 = localObject1;
      }
      else
      {
        if (JSch.getLogger().isEnabled(1))
        {
          localObject1 = JSch.getLogger();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("CheckCiphers: ");
          ((StringBuilder)localObject2).append(paramString);
          ((Logger)localObject1).log(1, ((StringBuilder)localObject2).toString());
        }
        String str1 = getConfig("cipher.c2s");
        localObject1 = getConfig("cipher.s2c");
        localObject2 = new Vector();
        paramString = Util.split(paramString, ",");
        int i = 0;
        for (int j = 0; j < paramString.length; j++)
        {
          String str2 = paramString[j];
          if (((((String)localObject1).indexOf(str2) != -1) || (str1.indexOf(str2) != -1)) && (!checkCipher(getConfig(str2)))) {
            ((Vector)localObject2).addElement(str2);
          }
        }
        if (((Vector)localObject2).size() == 0) {
          return null;
        }
        int k = ((Vector)localObject2).size();
        paramString = new String[k];
        System.arraycopy(((Vector)localObject2).toArray(), 0, paramString, 0, ((Vector)localObject2).size());
        localObject2 = paramString;
        if (JSch.getLogger().isEnabled(1)) {
          for (j = i;; j++)
          {
            localObject2 = paramString;
            if (j >= k) {
              break;
            }
            localObject2 = JSch.getLogger();
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString[j]);
            ((StringBuilder)localObject1).append(" is not available.");
            ((Logger)localObject2).log(1, ((StringBuilder)localObject1).toString());
          }
        }
      }
    }
    return (String[])localObject2;
  }
  
  private void checkConfig(ConfigRepository.Config paramConfig, String paramString)
  {
    paramConfig = paramConfig.getValue(paramString);
    if (paramConfig != null) {
      setConfig(paramString, paramConfig);
    }
  }
  
  private void checkHost(String paramString, int paramInt, KeyExchange paramKeyExchange)
    throws JSchException
  {
    String str1 = getConfig("StrictHostKeyChecking");
    Object localObject1 = this.hostKeyAlias;
    if (localObject1 != null) {
      paramString = (String)localObject1;
    }
    byte[] arrayOfByte = paramKeyExchange.getHostKey();
    String str2 = paramKeyExchange.getKeyType();
    String str3 = paramKeyExchange.getFingerPrint();
    localObject1 = paramString;
    if (this.hostKeyAlias == null)
    {
      localObject1 = paramString;
      if (paramInt != 22)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("]:");
        ((StringBuilder)localObject1).append(paramInt);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    HostKeyRepository localHostKeyRepository = getHostKeyRepository();
    if ((getConfig("HashKnownHosts").equals("yes")) && ((localHostKeyRepository instanceof KnownHosts))) {
      this.hostkey = ((KnownHosts)localHostKeyRepository).createHashedHostKey((String)localObject1, arrayOfByte);
    } else {
      this.hostkey = new HostKey((String)localObject1, arrayOfByte);
    }
    try
    {
      int i = localHostKeyRepository.check((String)localObject1, arrayOfByte);
      boolean bool = str1.equals("ask");
      int j = 0;
      Object localObject2;
      if (((bool) || (str1.equals("yes"))) && (i == 2)) {
        try
        {
          localObject2 = localHostKeyRepository.getKnownHostsRepositoryID();
          paramString = (String)localObject2;
          if (localObject2 == null) {
            paramString = "known_hosts";
          }
          if (this.userinfo != null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("WARNING: REMOTE HOST IDENTIFICATION HAS CHANGED!\nIT IS POSSIBLE THAT SOMEONE IS DOING SOMETHING NASTY!\nSomeone could be eavesdropping on you right now (man-in-the-middle attack)!\nIt is also possible that the ");
            ((StringBuilder)localObject2).append(str2);
            ((StringBuilder)localObject2).append(" host key has just been changed.\n");
            ((StringBuilder)localObject2).append("The fingerprint for the ");
            ((StringBuilder)localObject2).append(str2);
            ((StringBuilder)localObject2).append(" key sent by the remote host ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" is\n");
            ((StringBuilder)localObject2).append(str3);
            ((StringBuilder)localObject2).append(".\n");
            ((StringBuilder)localObject2).append("Please contact your system administrator.\n");
            ((StringBuilder)localObject2).append("Add correct host key in ");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append(" to get rid of this message.");
            String str4 = ((StringBuilder)localObject2).toString();
            if (str1.equals("ask"))
            {
              localObject2 = this.userinfo;
              paramString = new StringBuilder();
              paramString.append(str4);
              paramString.append("\nDo you want to delete the old key and insert the new key?");
              bool = ((UserInfo)localObject2).promptYesNo(paramString.toString());
            }
            else
            {
              this.userinfo.showMessage(str4);
            }
          }
          else
          {
            bool = false;
          }
          if (bool) {
            try
            {
              localHostKeyRepository.remove((String)localObject1, paramKeyExchange.getKeyAlgorithName(), null);
              k = 1;
            }
            finally {}
          }
          paramString = new StringBuilder();
          paramString.append("HostKey has been changed: ");
          paramString.append((String)localObject1);
          throw new JSchException(paramString.toString());
        }
        finally {}
      }
      int k = 0;
      if (!str1.equals("ask"))
      {
        paramInt = k;
        if (!str1.equals("yes")) {}
      }
      else
      {
        paramInt = k;
        if (i != 0)
        {
          paramInt = k;
          if (k == 0) {
            if (!str1.equals("yes"))
            {
              paramString = this.userinfo;
              if (paramString != null)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("The authenticity of host '");
                ((StringBuilder)localObject2).append(this.host);
                ((StringBuilder)localObject2).append("' can't be established.\n");
                ((StringBuilder)localObject2).append(str2);
                ((StringBuilder)localObject2).append(" key fingerprint is ");
                ((StringBuilder)localObject2).append(str3);
                ((StringBuilder)localObject2).append(".\n");
                ((StringBuilder)localObject2).append("Are you sure you want to continue connecting?");
                if (paramString.promptYesNo(((StringBuilder)localObject2).toString()))
                {
                  paramInt = 1;
                }
                else
                {
                  paramString = new StringBuilder();
                  paramString.append("reject HostKey: ");
                  paramString.append(this.host);
                  throw new JSchException(paramString.toString());
                }
              }
              else
              {
                if (i == 1)
                {
                  paramString = new StringBuilder();
                  paramString.append("UnknownHostKey: ");
                  paramString.append(this.host);
                  paramString.append(". ");
                  paramString.append(str2);
                  paramString.append(" key fingerprint is ");
                  paramString.append(str3);
                  throw new JSchException(paramString.toString());
                }
                paramString = new StringBuilder();
                paramString.append("HostKey has been changed: ");
                paramString.append(this.host);
                throw new JSchException(paramString.toString());
              }
            }
            else
            {
              paramString = new StringBuilder();
              paramString.append("reject HostKey: ");
              paramString.append(this.host);
              throw new JSchException(paramString.toString());
            }
          }
        }
      }
      k = paramInt;
      if (str1.equals("no"))
      {
        k = paramInt;
        if (1 == i) {
          k = 1;
        }
      }
      if (i == 0)
      {
        paramString = localHostKeyRepository.getHostKey((String)localObject1, paramKeyExchange.getKeyAlgorithName());
        paramKeyExchange = Util.byte2str(Util.toBase64(arrayOfByte, 0, arrayOfByte.length));
        for (paramInt = j; paramInt < paramString.length; paramInt++) {
          if ((paramString[i].getKey().equals(paramKeyExchange)) && (paramString[paramInt].getMarker().equals("@revoked")))
          {
            paramString = this.userinfo;
            if (paramString != null)
            {
              paramKeyExchange = new StringBuilder();
              paramKeyExchange.append("The ");
              paramKeyExchange.append(str2);
              paramKeyExchange.append(" host key for ");
              paramKeyExchange.append(this.host);
              paramKeyExchange.append(" is marked as revoked.\n");
              paramKeyExchange.append("This could mean that a stolen key is being used to ");
              paramKeyExchange.append("impersonate this host.");
              paramString.showMessage(paramKeyExchange.toString());
            }
            if (JSch.getLogger().isEnabled(1))
            {
              paramString = JSch.getLogger();
              paramKeyExchange = new StringBuilder();
              paramKeyExchange.append("Host '");
              paramKeyExchange.append(this.host);
              paramKeyExchange.append("' has provided revoked key.");
              paramString.log(1, paramKeyExchange.toString());
            }
            paramString = new StringBuilder();
            paramString.append("revoked HostKey: ");
            paramString.append(this.host);
            throw new JSchException(paramString.toString());
          }
        }
      }
      if ((i == 0) && (JSch.getLogger().isEnabled(1)))
      {
        paramString = JSch.getLogger();
        paramKeyExchange = new StringBuilder();
        paramKeyExchange.append("Host '");
        paramKeyExchange.append(this.host);
        paramKeyExchange.append("' is known and matches the ");
        paramKeyExchange.append(str2);
        paramKeyExchange.append(" host key");
        paramString.log(1, paramKeyExchange.toString());
      }
      if ((k != 0) && (JSch.getLogger().isEnabled(2)))
      {
        paramKeyExchange = JSch.getLogger();
        paramString = new StringBuilder();
        paramString.append("Permanently added '");
        paramString.append(this.host);
        paramString.append("' (");
        paramString.append(str2);
        paramString.append(") to the list of known hosts.");
        paramKeyExchange.log(2, paramString.toString());
      }
      if (k != 0) {
        try
        {
          localHostKeyRepository.add(this.hostkey, this.userinfo);
        }
        finally {}
      }
      return;
    }
    finally {}
  }
  
  static boolean checkKex(Session paramSession, String paramString)
  {
    try
    {
      ((KeyExchange)Class.forName(paramString).newInstance()).init(paramSession, null, null, null, null);
      return true;
    }
    catch (Exception paramSession) {}
    return false;
  }
  
  private String[] checkKexes(String paramString)
  {
    Logger localLogger = null;
    Object localObject = localLogger;
    if (paramString != null) {
      if (paramString.length() == 0)
      {
        localObject = localLogger;
      }
      else
      {
        if (JSch.getLogger().isEnabled(1))
        {
          localLogger = JSch.getLogger();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("CheckKexes: ");
          ((StringBuilder)localObject).append(paramString);
          localLogger.log(1, ((StringBuilder)localObject).toString());
        }
        localObject = new Vector();
        paramString = Util.split(paramString, ",");
        int i = 0;
        for (int j = 0; j < paramString.length; j++) {
          if (!checkKex(this, getConfig(paramString[j]))) {
            ((Vector)localObject).addElement(paramString[j]);
          }
        }
        if (((Vector)localObject).size() == 0) {
          return null;
        }
        int k = ((Vector)localObject).size();
        paramString = new String[k];
        System.arraycopy(((Vector)localObject).toArray(), 0, paramString, 0, ((Vector)localObject).size());
        localObject = paramString;
        if (JSch.getLogger().isEnabled(1)) {
          for (j = i;; j++)
          {
            localObject = paramString;
            if (j >= k) {
              break;
            }
            localLogger = JSch.getLogger();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString[j]);
            ((StringBuilder)localObject).append(" is not available.");
            localLogger.log(1, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    return (String[])localObject;
  }
  
  private String[] checkSignatures(String paramString)
  {
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramString != null) {
      if (paramString.length() == 0)
      {
        localObject = localStringBuilder;
      }
      else
      {
        if (JSch.getLogger().isEnabled(1))
        {
          localObject = JSch.getLogger();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("CheckSignatures: ");
          localStringBuilder.append(paramString);
          ((Logger)localObject).log(1, localStringBuilder.toString());
        }
        localObject = new Vector();
        paramString = Util.split(paramString, ",");
        int i = 0;
        for (int j = 0; j < paramString.length; j++) {
          try
          {
            ((Signature)Class.forName(JSch.getConfig(paramString[j])).newInstance()).init();
          }
          catch (Exception localException)
          {
            ((Vector)localObject).addElement(paramString[j]);
          }
        }
        if (((Vector)localObject).size() == 0) {
          return null;
        }
        int k = ((Vector)localObject).size();
        paramString = new String[k];
        System.arraycopy(((Vector)localObject).toArray(), 0, paramString, 0, ((Vector)localObject).size());
        localObject = paramString;
        if (JSch.getLogger().isEnabled(1)) {
          for (j = i;; j++)
          {
            localObject = paramString;
            if (j >= k) {
              break;
            }
            Logger localLogger = JSch.getLogger();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString[j]);
            ((StringBuilder)localObject).append(" is not available.");
            localLogger.log(1, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    return (String[])localObject;
  }
  
  private byte[] expandKey(Buffer paramBuffer, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, HASH paramHASH, int paramInt)
    throws Exception
  {
    int i = paramHASH.getBlockSize();
    while (paramArrayOfByte3.length < paramInt)
    {
      paramBuffer.reset();
      paramBuffer.putMPInt(paramArrayOfByte1);
      paramBuffer.putByte(paramArrayOfByte2);
      paramBuffer.putByte(paramArrayOfByte3);
      paramHASH.update(paramBuffer.buffer, 0, paramBuffer.index);
      byte[] arrayOfByte = new byte[paramArrayOfByte3.length + i];
      System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, 0, paramArrayOfByte3.length);
      System.arraycopy(paramHASH.digest(), 0, arrayOfByte, paramArrayOfByte3.length, i);
      Util.bzero(paramArrayOfByte3);
      paramArrayOfByte3 = arrayOfByte;
    }
    return paramArrayOfByte3;
  }
  
  private void initDeflater(String paramString)
    throws JSchException
  {
    if (paramString.equals("none"))
    {
      this.deflater = null;
      return;
    }
    String str = getConfig(paramString);
    if ((str != null) && ((paramString.equals("zlib")) || ((this.isAuthed) && (paramString.equals("zlib@openssh.com"))))) {
      try
      {
        this.deflater = ((Compression)Class.forName(str).newInstance());
        i = 6;
      }
      catch (Exception paramString)
      {
        int i;
        int j;
        throw new JSchException(paramString.toString(), paramString);
      }
      catch (NoClassDefFoundError paramString)
      {
        label85:
        throw new JSchException(paramString.toString(), paramString);
      }
    }
    try
    {
      j = Integer.parseInt(getConfig("compression_level"));
      i = j;
    }
    catch (Exception paramString)
    {
      break label85;
    }
    this.deflater.init(1, i);
  }
  
  private void initInflater(String paramString)
    throws JSchException
  {
    if (paramString.equals("none"))
    {
      this.inflater = null;
      return;
    }
    String str = getConfig(paramString);
    if ((str != null) && ((paramString.equals("zlib")) || ((this.isAuthed) && (paramString.equals("zlib@openssh.com"))))) {
      try
      {
        paramString = (Compression)Class.forName(str).newInstance();
        this.inflater = paramString;
        paramString.init(0, 0);
      }
      catch (Exception paramString)
      {
        throw new JSchException(paramString.toString(), paramString);
      }
    }
  }
  
  private Forwarding parseForwarding(String paramString)
    throws JSchException
  {
    Object localObject1 = paramString.split(" ");
    int i;
    if (localObject1.length > 1)
    {
      paramString = new Vector();
      for (i = 0; i < localObject1.length; i++) {
        if (localObject1[i].length() != 0) {
          paramString.addElement(localObject1[i].trim());
        }
      }
      localObject1 = new StringBuffer();
      i = 0;
      while (i < paramString.size())
      {
        ((StringBuffer)localObject1).append((String)paramString.elementAt(i));
        int j = i + 1;
        i = j;
        if (j < paramString.size())
        {
          ((StringBuffer)localObject1).append(":");
          i = j;
        }
      }
      paramString = ((StringBuffer)localObject1).toString();
    }
    Forwarding localForwarding = new Forwarding(null);
    try
    {
      if (paramString.lastIndexOf(":") != -1)
      {
        localForwarding.hostport = Integer.parseInt(paramString.substring(paramString.lastIndexOf(":") + 1));
        localObject1 = paramString.substring(0, paramString.lastIndexOf(":"));
        if (((String)localObject1).lastIndexOf(":") != -1)
        {
          localForwarding.host = ((String)localObject1).substring(((String)localObject1).lastIndexOf(":") + 1);
          paramString = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf(":"));
          i = paramString.lastIndexOf(":");
          localObject1 = "127.0.0.1";
          if (i != -1)
          {
            localForwarding.port = Integer.parseInt(paramString.substring(paramString.lastIndexOf(":") + 1));
            localObject2 = paramString.substring(0, paramString.lastIndexOf(":"));
            if (((String)localObject2).length() != 0)
            {
              paramString = (String)localObject2;
              if (!((String)localObject2).equals("*")) {}
            }
            else
            {
              paramString = "0.0.0.0";
            }
            if (paramString.equals("localhost")) {
              paramString = (String)localObject1;
            }
            localForwarding.bind_address = paramString;
          }
          else
          {
            localForwarding.port = Integer.parseInt(paramString);
            localForwarding.bind_address = "127.0.0.1";
          }
          return localForwarding;
        }
        localObject1 = new com/jcraft/jsch/JSchException;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((StringBuilder)localObject2).append("parseForwarding: ");
        ((StringBuilder)localObject2).append(paramString);
        ((JSchException)localObject1).<init>(((StringBuilder)localObject2).toString());
        throw ((Throwable)localObject1);
      }
      Object localObject2 = new com/jcraft/jsch/JSchException;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("parseForwarding: ");
      ((StringBuilder)localObject1).append(paramString);
      ((JSchException)localObject2).<init>(((StringBuilder)localObject1).toString());
      throw ((Throwable)localObject2);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      paramString = new StringBuilder();
      paramString.append("parseForwarding: ");
      paramString.append(localNumberFormatException.toString());
      throw new JSchException(paramString.toString());
    }
  }
  
  private KeyExchange receive_kexinit(Buffer paramBuffer)
    throws Exception
  {
    int i = paramBuffer.getInt();
    if (i != paramBuffer.getLength())
    {
      paramBuffer.getByte();
      this.I_S = new byte[paramBuffer.index - 5];
    }
    else
    {
      this.I_S = new byte[i - 1 - paramBuffer.getByte()];
    }
    byte[] arrayOfByte = paramBuffer.buffer;
    i = paramBuffer.s;
    paramBuffer = this.I_S;
    System.arraycopy(arrayOfByte, i, paramBuffer, 0, paramBuffer.length);
    if (!this.in_kex) {
      send_kexinit();
    }
    paramBuffer = KeyExchange.guess(this.I_S, this.I_C);
    this.guess = paramBuffer;
    if (paramBuffer != null)
    {
      if ((!this.isAuthed) && ((paramBuffer[2].equals("none")) || (this.guess[3].equals("none")))) {
        throw new JSchException("NONE Cipher should not be chosen before authentification is successed.");
      }
      try
      {
        paramBuffer = (KeyExchange)Class.forName(getConfig(this.guess[0])).newInstance();
        paramBuffer.init(this, this.V_S, this.V_C, this.I_S, this.I_C);
        return paramBuffer;
      }
      catch (Exception paramBuffer)
      {
        throw new JSchException(paramBuffer.toString(), paramBuffer);
      }
    }
    throw new JSchException("Algorithm negotiation fail");
  }
  
  private void receive_newkeys(Buffer paramBuffer, KeyExchange paramKeyExchange)
    throws Exception
  {
    updateKeys(paramKeyExchange);
    this.in_kex = false;
  }
  
  private void requestPortForwarding()
    throws JSchException
  {
    if (getConfig("ClearAllForwardings").equals("yes")) {
      return;
    }
    Object localObject = this.jsch.getConfigRepository();
    if (localObject == null) {
      return;
    }
    ConfigRepository.Config localConfig = ((ConfigRepository)localObject).getConfig(this.org_host);
    localObject = localConfig.getValues("LocalForward");
    int i = 0;
    int j;
    if (localObject != null) {
      for (j = 0; j < localObject.length; j++) {
        setPortForwardingL(localObject[j]);
      }
    }
    localObject = localConfig.getValues("RemoteForward");
    if (localObject != null) {
      for (j = i; j < localObject.length; j++) {
        setPortForwardingR(localObject[j]);
      }
    }
  }
  
  private void send_kexinit()
    throws Exception
  {
    if (this.in_kex) {
      return;
    }
    Object localObject1 = getConfig("cipher.c2s");
    Object localObject2 = getConfig("cipher.s2c");
    Object localObject3 = checkCiphers(getConfig("CheckCiphers"));
    Object localObject4 = localObject1;
    Object localObject6 = localObject2;
    if (localObject3 != null)
    {
      localObject4 = localObject1;
      localObject6 = localObject2;
      if (localObject3.length > 0)
      {
        localObject4 = Util.diffString((String)localObject1, (String[])localObject3);
        localObject6 = Util.diffString((String)localObject2, (String[])localObject3);
        if ((localObject4 == null) || (localObject6 == null)) {
          throw new JSchException("There are not any available ciphers.");
        }
      }
    }
    localObject1 = getConfig("kex");
    localObject3 = checkKexes(getConfig("CheckKexes"));
    localObject2 = localObject1;
    if (localObject3 != null)
    {
      localObject2 = localObject1;
      if (localObject3.length > 0)
      {
        localObject2 = Util.diffString((String)localObject1, (String[])localObject3);
        if (localObject2 == null) {
          throw new JSchException("There are not any available kexes.");
        }
      }
    }
    localObject3 = getConfig("server_host_key");
    Object localObject7 = checkSignatures(getConfig("CheckSignatures"));
    localObject1 = localObject3;
    if (localObject7 != null)
    {
      localObject1 = localObject3;
      if (localObject7.length > 0)
      {
        localObject1 = Util.diffString((String)localObject3, (String[])localObject7);
        if (localObject1 == null) {
          throw new JSchException("There are not any available sig algorithm.");
        }
      }
    }
    this.in_kex = true;
    this.kex_start_time = System.currentTimeMillis();
    localObject3 = new Buffer();
    localObject7 = new Packet((Buffer)localObject3);
    ((Packet)localObject7).reset();
    ((Buffer)localObject3).putByte((byte)20);
    synchronized (random)
    {
      random.fill(((Buffer)localObject3).buffer, ((Buffer)localObject3).index, 16);
      ((Buffer)localObject3).skip(16);
      ((Buffer)localObject3).putString(Util.str2byte((String)localObject2));
      ((Buffer)localObject3).putString(Util.str2byte((String)localObject1));
      ((Buffer)localObject3).putString(Util.str2byte((String)localObject4));
      ((Buffer)localObject3).putString(Util.str2byte((String)localObject6));
      ((Buffer)localObject3).putString(Util.str2byte(getConfig("mac.c2s")));
      ((Buffer)localObject3).putString(Util.str2byte(getConfig("mac.s2c")));
      ((Buffer)localObject3).putString(Util.str2byte(getConfig("compression.c2s")));
      ((Buffer)localObject3).putString(Util.str2byte(getConfig("compression.s2c")));
      ((Buffer)localObject3).putString(Util.str2byte(getConfig("lang.c2s")));
      ((Buffer)localObject3).putString(Util.str2byte(getConfig("lang.s2c")));
      ((Buffer)localObject3).putByte((byte)0);
      ((Buffer)localObject3).putInt(0);
      ((Buffer)localObject3).setOffSet(5);
      localObject4 = new byte[((Buffer)localObject3).getLength()];
      this.I_C = ((byte[])localObject4);
      ((Buffer)localObject3).getByte((byte[])localObject4);
      write((Packet)localObject7);
      if (JSch.getLogger().isEnabled(1)) {
        JSch.getLogger().log(1, "SSH_MSG_KEXINIT sent");
      }
      return;
    }
  }
  
  private void send_newkeys()
    throws Exception
  {
    this.packet.reset();
    this.buf.putByte((byte)21);
    write(this.packet);
    if (JSch.getLogger().isEnabled(1)) {
      JSch.getLogger().log(1, "SSH_MSG_NEWKEYS sent");
    }
  }
  
  private void start_discard(Buffer paramBuffer, Cipher paramCipher, MAC paramMAC, int paramInt1, int paramInt2)
    throws JSchException, IOException
  {
    if (paramCipher.isCBC())
    {
      if ((paramInt1 == 262144) || (paramMAC == null)) {
        paramMAC = null;
      }
      paramInt1 = paramInt2 - paramBuffer.index;
      while (paramInt1 > 0)
      {
        paramBuffer.reset();
        paramCipher = paramBuffer.buffer;
        if (paramInt1 > paramCipher.length) {
          paramInt2 = paramCipher.length;
        } else {
          paramInt2 = paramInt1;
        }
        this.io.getByte(paramCipher, 0, paramInt2);
        if (paramMAC != null) {
          paramMAC.update(paramBuffer.buffer, 0, paramInt2);
        }
        paramInt1 -= paramInt2;
      }
      if (paramMAC != null) {
        paramMAC.doFinal(paramBuffer.buffer, 0);
      }
      throw new JSchException("Packet corrupt");
    }
    throw new JSchException("Packet corrupt");
  }
  
  private void updateKeys(KeyExchange paramKeyExchange)
    throws Exception
  {
    byte[] arrayOfByte1 = paramKeyExchange.getK();
    byte[] arrayOfByte2 = paramKeyExchange.getH();
    paramKeyExchange = paramKeyExchange.getHash();
    if (this.session_id == null)
    {
      localObject1 = new byte[arrayOfByte2.length];
      this.session_id = ((byte[])localObject1);
      System.arraycopy(arrayOfByte2, 0, localObject1, 0, arrayOfByte2.length);
    }
    this.buf.reset();
    this.buf.putMPInt(arrayOfByte1);
    this.buf.putByte(arrayOfByte2);
    this.buf.putByte((byte)65);
    this.buf.putByte(this.session_id);
    Object localObject1 = this.buf;
    paramKeyExchange.update(((Buffer)localObject1).buffer, 0, ((Buffer)localObject1).index);
    this.IVc2s = paramKeyExchange.digest();
    localObject1 = this.buf;
    int i = ((Buffer)localObject1).index;
    int j = i - this.session_id.length - 1;
    localObject1 = ((Buffer)localObject1).buffer;
    localObject1[j] = ((byte)(byte)(localObject1[j] + 1));
    paramKeyExchange.update((byte[])localObject1, 0, i);
    this.IVs2c = paramKeyExchange.digest();
    localObject1 = this.buf;
    Object localObject2 = ((Buffer)localObject1).buffer;
    localObject2[j] = ((byte)(byte)(localObject2[j] + 1));
    paramKeyExchange.update((byte[])localObject2, 0, ((Buffer)localObject1).index);
    this.Ec2s = paramKeyExchange.digest();
    localObject2 = this.buf;
    localObject1 = ((Buffer)localObject2).buffer;
    localObject1[j] = ((byte)(byte)(localObject1[j] + 1));
    paramKeyExchange.update((byte[])localObject1, 0, ((Buffer)localObject2).index);
    this.Es2c = paramKeyExchange.digest();
    localObject2 = this.buf;
    localObject1 = ((Buffer)localObject2).buffer;
    localObject1[j] = ((byte)(byte)(localObject1[j] + 1));
    paramKeyExchange.update((byte[])localObject1, 0, ((Buffer)localObject2).index);
    this.MACc2s = paramKeyExchange.digest();
    localObject1 = this.buf;
    localObject2 = ((Buffer)localObject1).buffer;
    localObject2[j] = ((byte)(byte)(localObject2[j] + 1));
    paramKeyExchange.update((byte[])localObject2, 0, ((Buffer)localObject1).index);
    this.MACs2c = paramKeyExchange.digest();
    try
    {
      this.s2ccipher = ((Cipher)Class.forName(getConfig(this.guess[3])).newInstance());
      byte[] arrayOfByte3;
      for (;;)
      {
        i = this.s2ccipher.getBlockSize();
        localObject1 = this.Es2c;
        if (i <= localObject1.length) {
          break;
        }
        this.buf.reset();
        this.buf.putMPInt(arrayOfByte1);
        this.buf.putByte(arrayOfByte2);
        this.buf.putByte(this.Es2c);
        localObject1 = this.buf;
        paramKeyExchange.update(((Buffer)localObject1).buffer, 0, ((Buffer)localObject1).index);
        arrayOfByte3 = paramKeyExchange.digest();
        localObject2 = this.Es2c;
        localObject1 = new byte[localObject2.length + arrayOfByte3.length];
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        System.arraycopy(arrayOfByte3, 0, localObject1, this.Es2c.length, arrayOfByte3.length);
        this.Es2c = ((byte[])localObject1);
      }
      this.s2ccipher.init(1, (byte[])localObject1, this.IVs2c);
      this.s2ccipher_size = this.s2ccipher.getIVSize();
      localObject1 = (MAC)Class.forName(getConfig(this.guess[5])).newInstance();
      this.s2cmac = ((MAC)localObject1);
      localObject1 = expandKey(this.buf, arrayOfByte1, arrayOfByte2, this.MACs2c, paramKeyExchange, ((MAC)localObject1).getBlockSize());
      this.MACs2c = ((byte[])localObject1);
      this.s2cmac.init((byte[])localObject1);
      this.s2cmac_result1 = new byte[this.s2cmac.getBlockSize()];
      this.s2cmac_result2 = new byte[this.s2cmac.getBlockSize()];
      this.c2scipher = ((Cipher)Class.forName(getConfig(this.guess[2])).newInstance());
      for (;;)
      {
        i = this.c2scipher.getBlockSize();
        localObject1 = this.Ec2s;
        if (i <= localObject1.length) {
          break;
        }
        this.buf.reset();
        this.buf.putMPInt(arrayOfByte1);
        this.buf.putByte(arrayOfByte2);
        this.buf.putByte(this.Ec2s);
        localObject1 = this.buf;
        paramKeyExchange.update(((Buffer)localObject1).buffer, 0, ((Buffer)localObject1).index);
        localObject2 = paramKeyExchange.digest();
        arrayOfByte3 = this.Ec2s;
        localObject1 = new byte[arrayOfByte3.length + localObject2.length];
        System.arraycopy(arrayOfByte3, 0, localObject1, 0, arrayOfByte3.length);
        System.arraycopy(localObject2, 0, localObject1, this.Ec2s.length, localObject2.length);
        this.Ec2s = ((byte[])localObject1);
      }
      this.c2scipher.init(0, (byte[])localObject1, this.IVc2s);
      this.c2scipher_size = this.c2scipher.getIVSize();
      localObject1 = (MAC)Class.forName(getConfig(this.guess[4])).newInstance();
      this.c2smac = ((MAC)localObject1);
      paramKeyExchange = expandKey(this.buf, arrayOfByte1, arrayOfByte2, this.MACc2s, paramKeyExchange, ((MAC)localObject1).getBlockSize());
      this.MACc2s = paramKeyExchange;
      this.c2smac.init(paramKeyExchange);
      initDeflater(this.guess[6]);
      initInflater(this.guess[7]);
      return;
    }
    catch (Exception paramKeyExchange)
    {
      if ((paramKeyExchange instanceof JSchException)) {
        throw paramKeyExchange;
      }
      throw new JSchException(paramKeyExchange.toString(), paramKeyExchange);
    }
  }
  
  void addChannel(Channel paramChannel)
  {
    paramChannel.setSession(this);
  }
  
  public void connect()
    throws JSchException
  {
    connect(this.timeout);
  }
  
  /* Error */
  public void connect(int paramInt)
    throws JSchException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 208	com/jcraft/jsch/Session:isConnected	Z
    //   4: ifne +2578 -> 2582
    //   7: aload_0
    //   8: new 403	com/jcraft/jsch/IO
    //   11: dup
    //   12: invokespecial 1075	com/jcraft/jsch/IO:<init>	()V
    //   15: putfield 401	com/jcraft/jsch/Session:io	Lcom/jcraft/jsch/IO;
    //   18: getstatic 971	com/jcraft/jsch/Session:random	Lcom/jcraft/jsch/Random;
    //   21: ifnonnull +39 -> 60
    //   24: aload_0
    //   25: ldc_w 1076
    //   28: invokevirtual 603	com/jcraft/jsch/Session:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokestatic 566	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   34: invokevirtual 569	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   37: checkcast 973	com/jcraft/jsch/Random
    //   40: putstatic 971	com/jcraft/jsch/Session:random	Lcom/jcraft/jsch/Random;
    //   43: goto +17 -> 60
    //   46: astore_2
    //   47: new 190	com/jcraft/jsch/JSchException
    //   50: dup
    //   51: aload_2
    //   52: invokevirtual 392	java/lang/Exception:toString	()Ljava/lang/String;
    //   55: aload_2
    //   56: invokespecial 395	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   59: athrow
    //   60: getstatic 971	com/jcraft/jsch/Session:random	Lcom/jcraft/jsch/Random;
    //   63: invokestatic 1080	com/jcraft/jsch/Packet:setRandom	(Lcom/jcraft/jsch/Random;)V
    //   66: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   69: iconst_1
    //   70: invokeinterface 595 2 0
    //   75: ifeq +60 -> 135
    //   78: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   81: astore_3
    //   82: new 377	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   89: astore_2
    //   90: aload_2
    //   91: ldc_w 1082
    //   94: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_2
    //   99: aload_0
    //   100: getfield 250	com/jcraft/jsch/Session:host	Ljava/lang/String;
    //   103: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_2
    //   108: ldc_w 1084
    //   111: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: aload_0
    //   117: getfield 254	com/jcraft/jsch/Session:port	I
    //   120: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_3
    //   125: iconst_1
    //   126: aload_2
    //   127: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokeinterface 601 3 0
    //   135: aload_0
    //   136: getfield 228	com/jcraft/jsch/Session:proxy	Lcom/jcraft/jsch/Proxy;
    //   139: astore_2
    //   140: aload_2
    //   141: ifnonnull +118 -> 259
    //   144: aload_0
    //   145: getfield 224	com/jcraft/jsch/Session:socket_factory	Lcom/jcraft/jsch/SocketFactory;
    //   148: astore_2
    //   149: aload_2
    //   150: ifnonnull +37 -> 187
    //   153: aload_0
    //   154: getfield 250	com/jcraft/jsch/Session:host	Ljava/lang/String;
    //   157: aload_0
    //   158: getfield 254	com/jcraft/jsch/Session:port	I
    //   161: iload_1
    //   162: invokestatic 1088	com/jcraft/jsch/Util:createSocket	(Ljava/lang/String;II)Ljava/net/Socket;
    //   165: astore_2
    //   166: aload_0
    //   167: aload_2
    //   168: putfield 1090	com/jcraft/jsch/Session:socket	Ljava/net/Socket;
    //   171: aload_2
    //   172: invokevirtual 1096	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   175: astore_2
    //   176: aload_0
    //   177: getfield 1090	com/jcraft/jsch/Session:socket	Ljava/net/Socket;
    //   180: invokevirtual 1100	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   183: astore_3
    //   184: goto +48 -> 232
    //   187: aload_2
    //   188: aload_0
    //   189: getfield 250	com/jcraft/jsch/Session:host	Ljava/lang/String;
    //   192: aload_0
    //   193: getfield 254	com/jcraft/jsch/Session:port	I
    //   196: invokeinterface 1105 3 0
    //   201: astore_2
    //   202: aload_0
    //   203: aload_2
    //   204: putfield 1090	com/jcraft/jsch/Session:socket	Ljava/net/Socket;
    //   207: aload_0
    //   208: getfield 224	com/jcraft/jsch/Session:socket_factory	Lcom/jcraft/jsch/SocketFactory;
    //   211: aload_2
    //   212: invokeinterface 1108 2 0
    //   217: astore_2
    //   218: aload_0
    //   219: getfield 224	com/jcraft/jsch/Session:socket_factory	Lcom/jcraft/jsch/SocketFactory;
    //   222: aload_0
    //   223: getfield 1090	com/jcraft/jsch/Session:socket	Ljava/net/Socket;
    //   226: invokeinterface 1111 2 0
    //   231: astore_3
    //   232: aload_0
    //   233: getfield 1090	com/jcraft/jsch/Session:socket	Ljava/net/Socket;
    //   236: iconst_1
    //   237: invokevirtual 1114	java/net/Socket:setTcpNoDelay	(Z)V
    //   240: aload_0
    //   241: getfield 401	com/jcraft/jsch/Session:io	Lcom/jcraft/jsch/IO;
    //   244: aload_2
    //   245: invokevirtual 1118	com/jcraft/jsch/IO:setInputStream	(Ljava/io/InputStream;)V
    //   248: aload_0
    //   249: getfield 401	com/jcraft/jsch/Session:io	Lcom/jcraft/jsch/IO;
    //   252: aload_3
    //   253: invokevirtual 1122	com/jcraft/jsch/IO:setOutputStream	(Ljava/io/OutputStream;)V
    //   256: goto +74 -> 330
    //   259: aload_2
    //   260: monitorenter
    //   261: aload_0
    //   262: getfield 228	com/jcraft/jsch/Session:proxy	Lcom/jcraft/jsch/Proxy;
    //   265: aload_0
    //   266: getfield 224	com/jcraft/jsch/Session:socket_factory	Lcom/jcraft/jsch/SocketFactory;
    //   269: aload_0
    //   270: getfield 250	com/jcraft/jsch/Session:host	Ljava/lang/String;
    //   273: aload_0
    //   274: getfield 254	com/jcraft/jsch/Session:port	I
    //   277: iload_1
    //   278: invokeinterface 1127 5 0
    //   283: aload_0
    //   284: getfield 401	com/jcraft/jsch/Session:io	Lcom/jcraft/jsch/IO;
    //   287: aload_0
    //   288: getfield 228	com/jcraft/jsch/Session:proxy	Lcom/jcraft/jsch/Proxy;
    //   291: invokeinterface 1128 1 0
    //   296: invokevirtual 1118	com/jcraft/jsch/IO:setInputStream	(Ljava/io/InputStream;)V
    //   299: aload_0
    //   300: getfield 401	com/jcraft/jsch/Session:io	Lcom/jcraft/jsch/IO;
    //   303: aload_0
    //   304: getfield 228	com/jcraft/jsch/Session:proxy	Lcom/jcraft/jsch/Proxy;
    //   307: invokeinterface 1129 1 0
    //   312: invokevirtual 1122	com/jcraft/jsch/IO:setOutputStream	(Ljava/io/OutputStream;)V
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 228	com/jcraft/jsch/Session:proxy	Lcom/jcraft/jsch/Proxy;
    //   320: invokeinterface 1133 1 0
    //   325: putfield 1090	com/jcraft/jsch/Session:socket	Ljava/net/Socket;
    //   328: aload_2
    //   329: monitorexit
    //   330: iload_1
    //   331: ifle +17 -> 348
    //   334: aload_0
    //   335: getfield 1090	com/jcraft/jsch/Session:socket	Ljava/net/Socket;
    //   338: astore_2
    //   339: aload_2
    //   340: ifnull +8 -> 348
    //   343: aload_2
    //   344: iload_1
    //   345: invokevirtual 1136	java/net/Socket:setSoTimeout	(I)V
    //   348: aload_0
    //   349: iconst_1
    //   350: putfield 208	com/jcraft/jsch/Session:isConnected	Z
    //   353: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   356: iconst_1
    //   357: invokeinterface 595 2 0
    //   362: ifeq +15 -> 377
    //   365: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   368: iconst_1
    //   369: ldc_w 1138
    //   372: invokeinterface 601 3 0
    //   377: aload_0
    //   378: getfield 279	com/jcraft/jsch/Session:jsch	Lcom/jcraft/jsch/JSch;
    //   381: aload_0
    //   382: invokevirtual 1141	com/jcraft/jsch/JSch:addSession	(Lcom/jcraft/jsch/Session;)V
    //   385: aload_0
    //   386: getfield 198	com/jcraft/jsch/Session:V_C	[B
    //   389: astore_2
    //   390: aload_2
    //   391: arraylength
    //   392: iconst_1
    //   393: iadd
    //   394: istore 4
    //   396: iload 4
    //   398: newarray <illegal type>
    //   400: astore_3
    //   401: aload_2
    //   402: iconst_0
    //   403: aload_3
    //   404: iconst_0
    //   405: aload_2
    //   406: arraylength
    //   407: invokestatic 632	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   410: aload_3
    //   411: iload 4
    //   413: iconst_1
    //   414: isub
    //   415: bipush 10
    //   417: i2b
    //   418: bastore
    //   419: aload_0
    //   420: getfield 401	com/jcraft/jsch/Session:io	Lcom/jcraft/jsch/IO;
    //   423: aload_3
    //   424: iconst_0
    //   425: iload 4
    //   427: invokevirtual 1143	com/jcraft/jsch/IO:put	([BII)V
    //   430: iconst_0
    //   431: istore 5
    //   433: iconst_0
    //   434: istore 6
    //   436: iload 5
    //   438: istore 4
    //   440: iload 5
    //   442: aload_0
    //   443: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   446: getfield 813	com/jcraft/jsch/Buffer:buffer	[B
    //   449: arraylength
    //   450: if_icmpge +67 -> 517
    //   453: aload_0
    //   454: getfield 401	com/jcraft/jsch/Session:io	Lcom/jcraft/jsch/IO;
    //   457: invokevirtual 1144	com/jcraft/jsch/IO:getByte	()I
    //   460: istore 7
    //   462: iload 7
    //   464: ifge +14 -> 478
    //   467: iload 5
    //   469: istore 4
    //   471: iload 7
    //   473: istore 6
    //   475: goto +42 -> 517
    //   478: aload_0
    //   479: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   482: getfield 813	com/jcraft/jsch/Buffer:buffer	[B
    //   485: iload 5
    //   487: iload 7
    //   489: i2b
    //   490: i2b
    //   491: bastore
    //   492: iload 5
    //   494: iconst_1
    //   495: iadd
    //   496: istore 4
    //   498: iload 4
    //   500: istore 5
    //   502: iload 7
    //   504: istore 6
    //   506: iload 7
    //   508: bipush 10
    //   510: if_icmpne -74 -> 436
    //   513: iload 7
    //   515: istore 6
    //   517: iload 6
    //   519: iflt +1862 -> 2381
    //   522: aload_0
    //   523: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   526: getfield 813	com/jcraft/jsch/Buffer:buffer	[B
    //   529: astore_2
    //   530: iload 4
    //   532: istore 5
    //   534: aload_2
    //   535: iload 4
    //   537: iconst_1
    //   538: isub
    //   539: baload
    //   540: bipush 10
    //   542: if_icmpne +36 -> 578
    //   545: iinc 4 -1
    //   548: iload 4
    //   550: istore 5
    //   552: iload 4
    //   554: ifle +24 -> 578
    //   557: iload 4
    //   559: istore 5
    //   561: aload_2
    //   562: iload 4
    //   564: iconst_1
    //   565: isub
    //   566: baload
    //   567: bipush 13
    //   569: if_icmpne +9 -> 578
    //   572: iload 4
    //   574: iconst_1
    //   575: isub
    //   576: istore 5
    //   578: iload 5
    //   580: iconst_3
    //   581: if_icmple -151 -> 430
    //   584: iload 5
    //   586: aload_2
    //   587: arraylength
    //   588: if_icmpeq +38 -> 626
    //   591: aload_2
    //   592: iconst_0
    //   593: baload
    //   594: bipush 83
    //   596: if_icmpne -166 -> 430
    //   599: aload_2
    //   600: iconst_1
    //   601: baload
    //   602: bipush 83
    //   604: if_icmpne -174 -> 430
    //   607: aload_2
    //   608: iconst_2
    //   609: baload
    //   610: bipush 72
    //   612: if_icmpne -182 -> 430
    //   615: aload_2
    //   616: iconst_3
    //   617: baload
    //   618: bipush 45
    //   620: if_icmpeq +6 -> 626
    //   623: goto -193 -> 430
    //   626: iload 5
    //   628: aload_2
    //   629: arraylength
    //   630: if_icmpeq +1738 -> 2368
    //   633: iload 5
    //   635: bipush 7
    //   637: if_icmplt +1731 -> 2368
    //   640: aload_2
    //   641: iconst_4
    //   642: baload
    //   643: bipush 49
    //   645: if_icmpne +12 -> 657
    //   648: aload_2
    //   649: bipush 6
    //   651: baload
    //   652: bipush 57
    //   654: if_icmpne +1714 -> 2368
    //   657: iload 5
    //   659: newarray <illegal type>
    //   661: astore_3
    //   662: aload_0
    //   663: aload_3
    //   664: putfield 924	com/jcraft/jsch/Session:V_S	[B
    //   667: aload_2
    //   668: iconst_0
    //   669: aload_3
    //   670: iconst_0
    //   671: iload 5
    //   673: invokestatic 632	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   676: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   679: iconst_1
    //   680: invokeinterface 595 2 0
    //   685: ifeq +89 -> 774
    //   688: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   691: astore_2
    //   692: new 377	java/lang/StringBuilder
    //   695: astore_3
    //   696: aload_3
    //   697: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   700: aload_3
    //   701: ldc_w 1146
    //   704: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload_3
    //   709: aload_0
    //   710: getfield 924	com/jcraft/jsch/Session:V_S	[B
    //   713: invokestatic 744	com/jcraft/jsch/Util:byte2str	([B)Ljava/lang/String;
    //   716: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload_2
    //   721: iconst_1
    //   722: aload_3
    //   723: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokeinterface 601 3 0
    //   731: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   734: astore_3
    //   735: new 377	java/lang/StringBuilder
    //   738: astore_2
    //   739: aload_2
    //   740: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   743: aload_2
    //   744: ldc_w 1148
    //   747: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: pop
    //   751: aload_2
    //   752: aload_0
    //   753: getfield 198	com/jcraft/jsch/Session:V_C	[B
    //   756: invokestatic 744	com/jcraft/jsch/Util:byte2str	([B)Ljava/lang/String;
    //   759: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload_3
    //   764: iconst_1
    //   765: aload_2
    //   766: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokeinterface 601 3 0
    //   774: aload_0
    //   775: invokespecial 915	com/jcraft/jsch/Session:send_kexinit	()V
    //   778: aload_0
    //   779: aload_0
    //   780: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   783: invokevirtual 1152	com/jcraft/jsch/Session:read	(Lcom/jcraft/jsch/Buffer;)Lcom/jcraft/jsch/Buffer;
    //   786: astore_2
    //   787: aload_0
    //   788: aload_2
    //   789: putfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   792: aload_2
    //   793: invokevirtual 1156	com/jcraft/jsch/Buffer:getCommand	()B
    //   796: bipush 20
    //   798: if_icmpne +1523 -> 2321
    //   801: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   804: iconst_1
    //   805: invokeinterface 595 2 0
    //   810: ifeq +15 -> 825
    //   813: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   816: iconst_1
    //   817: ldc_w 1158
    //   820: invokeinterface 601 3 0
    //   825: aload_0
    //   826: aload_0
    //   827: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   830: invokespecial 1160	com/jcraft/jsch/Session:receive_kexinit	(Lcom/jcraft/jsch/Buffer;)Lcom/jcraft/jsch/KeyExchange;
    //   833: astore_3
    //   834: aload_0
    //   835: aload_0
    //   836: aload_0
    //   837: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   840: invokevirtual 1152	com/jcraft/jsch/Session:read	(Lcom/jcraft/jsch/Buffer;)Lcom/jcraft/jsch/Buffer;
    //   843: putfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   846: aload_3
    //   847: invokevirtual 1163	com/jcraft/jsch/KeyExchange:getState	()I
    //   850: aload_0
    //   851: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   854: invokevirtual 1156	com/jcraft/jsch/Buffer:getCommand	()B
    //   857: if_icmpne +1417 -> 2274
    //   860: aload_0
    //   861: invokestatic 969	java/lang/System:currentTimeMillis	()J
    //   864: putfield 242	com/jcraft/jsch/Session:kex_start_time	J
    //   867: aload_3
    //   868: aload_0
    //   869: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   872: invokevirtual 1167	com/jcraft/jsch/KeyExchange:next	(Lcom/jcraft/jsch/Buffer;)Z
    //   875: istore 8
    //   877: iload 8
    //   879: ifeq +1353 -> 2232
    //   882: aload_3
    //   883: invokevirtual 1163	com/jcraft/jsch/KeyExchange:getState	()I
    //   886: istore 4
    //   888: iload 4
    //   890: ifne -56 -> 834
    //   893: invokestatic 969	java/lang/System:currentTimeMillis	()J
    //   896: lstore 9
    //   898: aload_0
    //   899: iconst_1
    //   900: putfield 262	com/jcraft/jsch/Session:in_prompt	Z
    //   903: aload_0
    //   904: aload_0
    //   905: getfield 250	com/jcraft/jsch/Session:host	Ljava/lang/String;
    //   908: aload_0
    //   909: getfield 254	com/jcraft/jsch/Session:port	I
    //   912: aload_3
    //   913: invokespecial 1169	com/jcraft/jsch/Session:checkHost	(Ljava/lang/String;ILcom/jcraft/jsch/KeyExchange;)V
    //   916: aload_0
    //   917: iconst_0
    //   918: putfield 262	com/jcraft/jsch/Session:in_prompt	Z
    //   921: aload_0
    //   922: aload_0
    //   923: getfield 242	com/jcraft/jsch/Session:kex_start_time	J
    //   926: invokestatic 969	java/lang/System:currentTimeMillis	()J
    //   929: lload 9
    //   931: lsub
    //   932: ladd
    //   933: putfield 242	com/jcraft/jsch/Session:kex_start_time	J
    //   936: aload_0
    //   937: invokespecial 1171	com/jcraft/jsch/Session:send_newkeys	()V
    //   940: aload_0
    //   941: aload_0
    //   942: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   945: invokevirtual 1152	com/jcraft/jsch/Session:read	(Lcom/jcraft/jsch/Buffer;)Lcom/jcraft/jsch/Buffer;
    //   948: astore_2
    //   949: aload_0
    //   950: aload_2
    //   951: putfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   954: aload_2
    //   955: invokevirtual 1156	com/jcraft/jsch/Buffer:getCommand	()B
    //   958: bipush 21
    //   960: if_icmpne +1208 -> 2168
    //   963: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   966: iconst_1
    //   967: invokeinterface 595 2 0
    //   972: ifeq +15 -> 987
    //   975: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   978: iconst_1
    //   979: ldc_w 1173
    //   982: invokeinterface 601 3 0
    //   987: aload_0
    //   988: aload_0
    //   989: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   992: aload_3
    //   993: invokespecial 1175	com/jcraft/jsch/Session:receive_newkeys	(Lcom/jcraft/jsch/Buffer;Lcom/jcraft/jsch/KeyExchange;)V
    //   996: aload_0
    //   997: ldc_w 459
    //   1000: invokevirtual 603	com/jcraft/jsch/Session:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   1003: astore_2
    //   1004: aload_2
    //   1005: ifnull +11 -> 1016
    //   1008: aload_0
    //   1009: aload_2
    //   1010: invokestatic 529	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1013: putfield 244	com/jcraft/jsch/Session:max_auth_tries	I
    //   1016: aload_0
    //   1017: ldc_w 1177
    //   1020: invokevirtual 603	com/jcraft/jsch/Session:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   1023: invokestatic 566	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1026: invokevirtual 569	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   1029: checkcast 1179	com/jcraft/jsch/UserAuth
    //   1032: astore_3
    //   1033: aload_3
    //   1034: aload_0
    //   1035: invokevirtual 1183	com/jcraft/jsch/UserAuth:start	(Lcom/jcraft/jsch/Session;)Z
    //   1038: istore 8
    //   1040: aload_0
    //   1041: ldc_w 457
    //   1044: invokevirtual 603	com/jcraft/jsch/Session:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   1047: astore_2
    //   1048: aload_2
    //   1049: ldc_w 608
    //   1052: invokestatic 612	com/jcraft/jsch/Util:split	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   1055: astore 11
    //   1057: iload 8
    //   1059: ifne +23 -> 1082
    //   1062: aload_3
    //   1063: checkcast 1185	com/jcraft/jsch/UserAuthNone
    //   1066: invokevirtual 1188	com/jcraft/jsch/UserAuthNone:getMethods	()Ljava/lang/String;
    //   1069: astore_3
    //   1070: aload_3
    //   1071: ifnull +13 -> 1084
    //   1074: aload_3
    //   1075: invokevirtual 1191	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1078: astore_2
    //   1079: goto +5 -> 1084
    //   1082: aconst_null
    //   1083: astore_2
    //   1084: aload_2
    //   1085: ldc_w 608
    //   1088: invokestatic 612	com/jcraft/jsch/Util:split	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   1091: astore 12
    //   1093: iconst_0
    //   1094: istore 6
    //   1096: aload_2
    //   1097: astore_3
    //   1098: iconst_0
    //   1099: istore 4
    //   1101: iload 8
    //   1103: istore 13
    //   1105: iload 4
    //   1107: istore 5
    //   1109: iload 8
    //   1111: ifne +737 -> 1848
    //   1114: iload 8
    //   1116: istore 13
    //   1118: iload 4
    //   1120: istore 5
    //   1122: aload 11
    //   1124: ifnull +724 -> 1848
    //   1127: iload 8
    //   1129: istore 13
    //   1131: iload 4
    //   1133: istore 5
    //   1135: iload 6
    //   1137: aload 11
    //   1139: arraylength
    //   1140: if_icmpge +708 -> 1848
    //   1143: iload 6
    //   1145: iconst_1
    //   1146: iadd
    //   1147: istore 5
    //   1149: aload 11
    //   1151: iload 6
    //   1153: aaload
    //   1154: astore 14
    //   1156: iconst_0
    //   1157: istore 6
    //   1159: iload 6
    //   1161: aload 12
    //   1163: arraylength
    //   1164: if_icmpge +28 -> 1192
    //   1167: aload 12
    //   1169: iload 6
    //   1171: aaload
    //   1172: aload 14
    //   1174: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1177: ifeq +9 -> 1186
    //   1180: iconst_1
    //   1181: istore 6
    //   1183: goto +12 -> 1195
    //   1186: iinc 6 1
    //   1189: goto -30 -> 1159
    //   1192: iconst_0
    //   1193: istore 6
    //   1195: iload 6
    //   1197: ifne +10 -> 1207
    //   1200: iload 5
    //   1202: istore 6
    //   1204: goto -103 -> 1101
    //   1207: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1210: iconst_1
    //   1211: invokeinterface 595 2 0
    //   1216: ifeq +162 -> 1378
    //   1219: ldc_w 1193
    //   1222: astore_2
    //   1223: iload 5
    //   1225: iconst_1
    //   1226: isub
    //   1227: istore 6
    //   1229: iload 6
    //   1231: aload 11
    //   1233: arraylength
    //   1234: if_icmpge +94 -> 1328
    //   1237: new 377	java/lang/StringBuilder
    //   1240: astore 15
    //   1242: aload 15
    //   1244: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1247: aload 15
    //   1249: aload_2
    //   1250: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: pop
    //   1254: aload 15
    //   1256: aload 11
    //   1258: iload 6
    //   1260: aaload
    //   1261: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: pop
    //   1265: aload 15
    //   1267: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: astore 15
    //   1272: iload 6
    //   1274: iconst_1
    //   1275: iadd
    //   1276: istore 7
    //   1278: aload 15
    //   1280: astore_2
    //   1281: iload 7
    //   1283: istore 6
    //   1285: iload 7
    //   1287: aload 11
    //   1289: arraylength
    //   1290: if_icmpge -61 -> 1229
    //   1293: new 377	java/lang/StringBuilder
    //   1296: astore_2
    //   1297: aload_2
    //   1298: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1301: aload_2
    //   1302: aload 15
    //   1304: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: pop
    //   1308: aload_2
    //   1309: ldc_w 608
    //   1312: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: pop
    //   1316: aload_2
    //   1317: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1320: astore_2
    //   1321: iload 7
    //   1323: istore 6
    //   1325: goto -96 -> 1229
    //   1328: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1331: iconst_1
    //   1332: aload_2
    //   1333: invokeinterface 601 3 0
    //   1338: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1341: astore 15
    //   1343: new 377	java/lang/StringBuilder
    //   1346: astore_2
    //   1347: aload_2
    //   1348: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1351: aload_2
    //   1352: ldc_w 1195
    //   1355: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: pop
    //   1359: aload_2
    //   1360: aload 14
    //   1362: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: pop
    //   1366: aload 15
    //   1368: iconst_1
    //   1369: aload_2
    //   1370: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1373: invokeinterface 601 3 0
    //   1378: new 377	java/lang/StringBuilder
    //   1381: astore_2
    //   1382: aload_2
    //   1383: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1386: aload_2
    //   1387: ldc_w 1197
    //   1390: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: pop
    //   1394: aload_2
    //   1395: aload 14
    //   1397: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: pop
    //   1401: aload_0
    //   1402: aload_2
    //   1403: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: invokevirtual 603	com/jcraft/jsch/Session:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   1409: ifnull +108 -> 1517
    //   1412: new 377	java/lang/StringBuilder
    //   1415: astore_2
    //   1416: aload_2
    //   1417: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1420: aload_2
    //   1421: ldc_w 1197
    //   1424: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: pop
    //   1428: aload_2
    //   1429: aload 14
    //   1431: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1434: pop
    //   1435: aload_0
    //   1436: aload_2
    //   1437: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1440: invokevirtual 603	com/jcraft/jsch/Session:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   1443: invokestatic 566	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1446: invokevirtual 569	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   1449: checkcast 1179	com/jcraft/jsch/UserAuth
    //   1452: astore_2
    //   1453: goto +66 -> 1519
    //   1456: astore_2
    //   1457: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1460: iconst_2
    //   1461: invokeinterface 595 2 0
    //   1466: ifeq +51 -> 1517
    //   1469: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1472: astore 15
    //   1474: new 377	java/lang/StringBuilder
    //   1477: astore_2
    //   1478: aload_2
    //   1479: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1482: aload_2
    //   1483: ldc_w 1199
    //   1486: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: pop
    //   1490: aload_2
    //   1491: aload 14
    //   1493: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: pop
    //   1497: aload_2
    //   1498: ldc_w 1201
    //   1501: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: pop
    //   1505: aload 15
    //   1507: iconst_2
    //   1508: aload_2
    //   1509: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1512: invokeinterface 601 3 0
    //   1517: aconst_null
    //   1518: astore_2
    //   1519: iload 8
    //   1521: istore 16
    //   1523: aload_2
    //   1524: ifnull +313 -> 1837
    //   1527: iload 8
    //   1529: istore 13
    //   1531: iload 8
    //   1533: istore 17
    //   1535: iload 8
    //   1537: istore 16
    //   1539: aload_2
    //   1540: aload_0
    //   1541: invokevirtual 1183	com/jcraft/jsch/UserAuth:start	(Lcom/jcraft/jsch/Session;)Z
    //   1544: istore 8
    //   1546: iload 8
    //   1548: ifeq +163 -> 1711
    //   1551: iload 8
    //   1553: istore 13
    //   1555: iload 8
    //   1557: istore 17
    //   1559: iload 8
    //   1561: istore 16
    //   1563: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1566: iconst_1
    //   1567: invokeinterface 595 2 0
    //   1572: ifeq +139 -> 1711
    //   1575: iload 8
    //   1577: istore 13
    //   1579: iload 8
    //   1581: istore 17
    //   1583: iload 8
    //   1585: istore 16
    //   1587: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1590: astore_2
    //   1591: iload 8
    //   1593: istore 13
    //   1595: iload 8
    //   1597: istore 17
    //   1599: iload 8
    //   1601: istore 16
    //   1603: new 377	java/lang/StringBuilder
    //   1606: astore 15
    //   1608: iload 8
    //   1610: istore 13
    //   1612: iload 8
    //   1614: istore 17
    //   1616: iload 8
    //   1618: istore 16
    //   1620: aload 15
    //   1622: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1625: iload 8
    //   1627: istore 13
    //   1629: iload 8
    //   1631: istore 17
    //   1633: iload 8
    //   1635: istore 16
    //   1637: aload 15
    //   1639: ldc_w 1203
    //   1642: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: pop
    //   1646: iload 8
    //   1648: istore 13
    //   1650: iload 8
    //   1652: istore 17
    //   1654: iload 8
    //   1656: istore 16
    //   1658: aload 15
    //   1660: aload 14
    //   1662: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1665: pop
    //   1666: iload 8
    //   1668: istore 13
    //   1670: iload 8
    //   1672: istore 17
    //   1674: iload 8
    //   1676: istore 16
    //   1678: aload 15
    //   1680: ldc_w 1205
    //   1683: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: pop
    //   1687: iload 8
    //   1689: istore 13
    //   1691: iload 8
    //   1693: istore 17
    //   1695: iload 8
    //   1697: istore 16
    //   1699: aload_2
    //   1700: iconst_1
    //   1701: aload 15
    //   1703: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1706: invokeinterface 601 3 0
    //   1711: iconst_0
    //   1712: istore 4
    //   1714: iload 8
    //   1716: istore 16
    //   1718: goto +119 -> 1837
    //   1721: astore_2
    //   1722: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1725: iconst_2
    //   1726: invokeinterface 595 2 0
    //   1731: ifeq +48 -> 1779
    //   1734: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1737: astore_3
    //   1738: new 377	java/lang/StringBuilder
    //   1741: astore 12
    //   1743: aload 12
    //   1745: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1748: aload 12
    //   1750: ldc_w 1207
    //   1753: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1756: pop
    //   1757: aload 12
    //   1759: aload_2
    //   1760: invokevirtual 392	java/lang/Exception:toString	()Ljava/lang/String;
    //   1763: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: pop
    //   1767: aload_3
    //   1768: iconst_2
    //   1769: aload 12
    //   1771: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1774: invokeinterface 601 3 0
    //   1779: iconst_0
    //   1780: istore 5
    //   1782: goto +66 -> 1848
    //   1785: astore_2
    //   1786: aload_2
    //   1787: athrow
    //   1788: astore_2
    //   1789: aload_2
    //   1790: athrow
    //   1791: astore_2
    //   1792: aload_2
    //   1793: invokevirtual 1208	com/jcraft/jsch/JSchPartialAuthException:getMethods	()Ljava/lang/String;
    //   1796: astore_2
    //   1797: aload_2
    //   1798: ldc_w 608
    //   1801: invokestatic 612	com/jcraft/jsch/Util:split	(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;
    //   1804: astore 12
    //   1806: aload_3
    //   1807: aload_2
    //   1808: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1811: ifne +9 -> 1820
    //   1814: iconst_0
    //   1815: istore 6
    //   1817: goto +7 -> 1824
    //   1820: iload 5
    //   1822: istore 6
    //   1824: aload_2
    //   1825: astore_3
    //   1826: iload 17
    //   1828: istore 8
    //   1830: goto -732 -> 1098
    //   1833: astore_2
    //   1834: iconst_1
    //   1835: istore 4
    //   1837: iload 16
    //   1839: istore 8
    //   1841: iload 5
    //   1843: istore 6
    //   1845: goto -744 -> 1101
    //   1848: iload 13
    //   1850: ifne +97 -> 1947
    //   1853: aload_0
    //   1854: getfield 246	com/jcraft/jsch/Session:auth_failures	I
    //   1857: aload_0
    //   1858: getfield 244	com/jcraft/jsch/Session:max_auth_tries	I
    //   1861: if_icmplt +55 -> 1916
    //   1864: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1867: iconst_1
    //   1868: invokeinterface 595 2 0
    //   1873: ifeq +43 -> 1916
    //   1876: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1879: astore_2
    //   1880: new 377	java/lang/StringBuilder
    //   1883: astore_3
    //   1884: aload_3
    //   1885: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1888: aload_3
    //   1889: ldc_w 1210
    //   1892: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: pop
    //   1896: aload_3
    //   1897: aload_0
    //   1898: getfield 244	com/jcraft/jsch/Session:max_auth_tries	I
    //   1901: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1904: pop
    //   1905: aload_2
    //   1906: iconst_1
    //   1907: aload_3
    //   1908: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1911: invokeinterface 601 3 0
    //   1916: iload 5
    //   1918: ifeq +16 -> 1934
    //   1921: new 190	com/jcraft/jsch/JSchException
    //   1924: astore_2
    //   1925: aload_2
    //   1926: ldc_w 1212
    //   1929: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   1932: aload_2
    //   1933: athrow
    //   1934: new 190	com/jcraft/jsch/JSchException
    //   1937: astore_2
    //   1938: aload_2
    //   1939: ldc_w 1214
    //   1942: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   1945: aload_2
    //   1946: athrow
    //   1947: aload_0
    //   1948: getfield 1090	com/jcraft/jsch/Session:socket	Ljava/net/Socket;
    //   1951: astore_2
    //   1952: aload_2
    //   1953: ifnull +22 -> 1975
    //   1956: iload_1
    //   1957: ifgt +10 -> 1967
    //   1960: aload_0
    //   1961: getfield 206	com/jcraft/jsch/Session:timeout	I
    //   1964: ifle +11 -> 1975
    //   1967: aload_2
    //   1968: aload_0
    //   1969: getfield 206	com/jcraft/jsch/Session:timeout	I
    //   1972: invokevirtual 1136	java/net/Socket:setSoTimeout	(I)V
    //   1975: aload_0
    //   1976: iconst_1
    //   1977: putfield 210	com/jcraft/jsch/Session:isAuthed	Z
    //   1980: aload_0
    //   1981: getfield 214	com/jcraft/jsch/Session:lock	Ljava/lang/Object;
    //   1984: astore_2
    //   1985: aload_2
    //   1986: monitorenter
    //   1987: aload_0
    //   1988: getfield 208	com/jcraft/jsch/Session:isConnected	Z
    //   1991: ifeq +95 -> 2086
    //   1994: new 331	java/lang/Thread
    //   1997: astore_3
    //   1998: aload_3
    //   1999: aload_0
    //   2000: invokespecial 1217	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   2003: aload_0
    //   2004: aload_3
    //   2005: putfield 212	com/jcraft/jsch/Session:connectThread	Ljava/lang/Thread;
    //   2008: new 377	java/lang/StringBuilder
    //   2011: astore 12
    //   2013: aload 12
    //   2015: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   2018: aload 12
    //   2020: ldc_w 1219
    //   2023: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2026: pop
    //   2027: aload 12
    //   2029: aload_0
    //   2030: getfield 250	com/jcraft/jsch/Session:host	Ljava/lang/String;
    //   2033: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2036: pop
    //   2037: aload 12
    //   2039: ldc_w 1221
    //   2042: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: pop
    //   2046: aload_3
    //   2047: aload 12
    //   2049: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2052: invokevirtual 1224	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   2055: aload_0
    //   2056: getfield 240	com/jcraft/jsch/Session:daemon_thread	Z
    //   2059: istore 8
    //   2061: iload 8
    //   2063: ifeq +12 -> 2075
    //   2066: aload_0
    //   2067: getfield 212	com/jcraft/jsch/Session:connectThread	Ljava/lang/Thread;
    //   2070: iload 8
    //   2072: invokevirtual 1227	java/lang/Thread:setDaemon	(Z)V
    //   2075: aload_0
    //   2076: getfield 212	com/jcraft/jsch/Session:connectThread	Ljava/lang/Thread;
    //   2079: invokevirtual 1229	java/lang/Thread:start	()V
    //   2082: aload_0
    //   2083: invokespecial 1231	com/jcraft/jsch/Session:requestPortForwarding	()V
    //   2086: aload_2
    //   2087: monitorexit
    //   2088: aload_0
    //   2089: getfield 258	com/jcraft/jsch/Session:password	[B
    //   2092: invokestatic 826	com/jcraft/jsch/Util:bzero	([B)V
    //   2095: aload_0
    //   2096: aconst_null
    //   2097: putfield 258	com/jcraft/jsch/Session:password	[B
    //   2100: return
    //   2101: astore_3
    //   2102: aload_2
    //   2103: monitorexit
    //   2104: aload_3
    //   2105: athrow
    //   2106: astore_2
    //   2107: new 190	com/jcraft/jsch/JSchException
    //   2110: astore_3
    //   2111: aload_3
    //   2112: aload_2
    //   2113: invokevirtual 392	java/lang/Exception:toString	()Ljava/lang/String;
    //   2116: aload_2
    //   2117: invokespecial 395	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2120: aload_3
    //   2121: athrow
    //   2122: astore 12
    //   2124: new 190	com/jcraft/jsch/JSchException
    //   2127: astore_2
    //   2128: new 377	java/lang/StringBuilder
    //   2131: astore_3
    //   2132: aload_3
    //   2133: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   2136: aload_3
    //   2137: ldc_w 1233
    //   2140: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: pop
    //   2144: aload_3
    //   2145: aload_0
    //   2146: ldc_w 459
    //   2149: invokevirtual 603	com/jcraft/jsch/Session:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   2152: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2155: pop
    //   2156: aload_2
    //   2157: aload_3
    //   2158: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2161: aload 12
    //   2163: invokespecial 395	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2166: aload_2
    //   2167: athrow
    //   2168: aload_0
    //   2169: iconst_0
    //   2170: putfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   2173: new 190	com/jcraft/jsch/JSchException
    //   2176: astore_2
    //   2177: new 377	java/lang/StringBuilder
    //   2180: astore_3
    //   2181: aload_3
    //   2182: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   2185: aload_3
    //   2186: ldc_w 1235
    //   2189: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2192: pop
    //   2193: aload_3
    //   2194: aload_0
    //   2195: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   2198: invokevirtual 1156	com/jcraft/jsch/Buffer:getCommand	()B
    //   2201: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2204: pop
    //   2205: aload_2
    //   2206: aload_3
    //   2207: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2210: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   2213: aload_2
    //   2214: athrow
    //   2215: astore_2
    //   2216: aload_0
    //   2217: iconst_0
    //   2218: putfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   2221: aload_0
    //   2222: iconst_0
    //   2223: putfield 262	com/jcraft/jsch/Session:in_prompt	Z
    //   2226: aload_2
    //   2227: athrow
    //   2228: astore_2
    //   2229: goto +175 -> 2404
    //   2232: aload_0
    //   2233: iconst_0
    //   2234: putfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   2237: new 190	com/jcraft/jsch/JSchException
    //   2240: astore_3
    //   2241: new 377	java/lang/StringBuilder
    //   2244: astore_2
    //   2245: aload_2
    //   2246: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   2249: aload_2
    //   2250: ldc_w 1237
    //   2253: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2256: pop
    //   2257: aload_2
    //   2258: iload 8
    //   2260: invokevirtual 1240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2263: pop
    //   2264: aload_3
    //   2265: aload_2
    //   2266: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2269: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   2272: aload_3
    //   2273: athrow
    //   2274: aload_0
    //   2275: iconst_0
    //   2276: putfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   2279: new 190	com/jcraft/jsch/JSchException
    //   2282: astore_3
    //   2283: new 377	java/lang/StringBuilder
    //   2286: astore_2
    //   2287: aload_2
    //   2288: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   2291: aload_2
    //   2292: ldc_w 1242
    //   2295: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2298: pop
    //   2299: aload_2
    //   2300: aload_0
    //   2301: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   2304: invokevirtual 1156	com/jcraft/jsch/Buffer:getCommand	()B
    //   2307: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2310: pop
    //   2311: aload_3
    //   2312: aload_2
    //   2313: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2316: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   2319: aload_3
    //   2320: athrow
    //   2321: aload_0
    //   2322: iconst_0
    //   2323: putfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   2326: new 190	com/jcraft/jsch/JSchException
    //   2329: astore_3
    //   2330: new 377	java/lang/StringBuilder
    //   2333: astore_2
    //   2334: aload_2
    //   2335: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   2338: aload_2
    //   2339: ldc_w 1244
    //   2342: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2345: pop
    //   2346: aload_2
    //   2347: aload_0
    //   2348: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   2351: invokevirtual 1156	com/jcraft/jsch/Buffer:getCommand	()B
    //   2354: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2357: pop
    //   2358: aload_3
    //   2359: aload_2
    //   2360: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2363: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   2366: aload_3
    //   2367: athrow
    //   2368: new 190	com/jcraft/jsch/JSchException
    //   2371: astore_2
    //   2372: aload_2
    //   2373: ldc_w 1246
    //   2376: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   2379: aload_2
    //   2380: athrow
    //   2381: new 190	com/jcraft/jsch/JSchException
    //   2384: astore_2
    //   2385: aload_2
    //   2386: ldc_w 1248
    //   2389: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   2392: aload_2
    //   2393: athrow
    //   2394: astore_3
    //   2395: aload_2
    //   2396: monitorexit
    //   2397: aload_3
    //   2398: athrow
    //   2399: astore_2
    //   2400: goto +168 -> 2568
    //   2403: astore_2
    //   2404: aload_0
    //   2405: iconst_0
    //   2406: putfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   2409: aload_0
    //   2410: getfield 208	com/jcraft/jsch/Session:isConnected	Z
    //   2413: ifeq +83 -> 2496
    //   2416: aload_2
    //   2417: invokevirtual 392	java/lang/Exception:toString	()Ljava/lang/String;
    //   2420: astore_3
    //   2421: aload_0
    //   2422: getfield 291	com/jcraft/jsch/Session:packet	Lcom/jcraft/jsch/Packet;
    //   2425: invokevirtual 345	com/jcraft/jsch/Packet:reset	()V
    //   2428: aload_0
    //   2429: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   2432: aload_3
    //   2433: invokevirtual 585	java/lang/String:length	()I
    //   2436: bipush 13
    //   2438: iadd
    //   2439: iconst_2
    //   2440: iadd
    //   2441: sipush 128
    //   2444: iadd
    //   2445: invokevirtual 1251	com/jcraft/jsch/Buffer:checkFreeSize	(I)V
    //   2448: aload_0
    //   2449: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   2452: iconst_1
    //   2453: invokevirtual 349	com/jcraft/jsch/Buffer:putByte	(B)V
    //   2456: aload_0
    //   2457: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   2460: iconst_3
    //   2461: invokevirtual 358	com/jcraft/jsch/Buffer:putInt	(I)V
    //   2464: aload_0
    //   2465: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   2468: aload_3
    //   2469: invokestatic 179	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;)[B
    //   2472: invokevirtual 355	com/jcraft/jsch/Buffer:putString	([B)V
    //   2475: aload_0
    //   2476: getfield 284	com/jcraft/jsch/Session:buf	Lcom/jcraft/jsch/Buffer;
    //   2479: ldc_w 1253
    //   2482: invokestatic 179	com/jcraft/jsch/Util:str2byte	(Ljava/lang/String;)[B
    //   2485: invokevirtual 355	com/jcraft/jsch/Buffer:putString	([B)V
    //   2488: aload_0
    //   2489: aload_0
    //   2490: getfield 291	com/jcraft/jsch/Session:packet	Lcom/jcraft/jsch/Packet;
    //   2493: invokevirtual 362	com/jcraft/jsch/Session:write	(Lcom/jcraft/jsch/Packet;)V
    //   2496: aload_0
    //   2497: invokevirtual 1256	com/jcraft/jsch/Session:disconnect	()V
    //   2500: aload_0
    //   2501: iconst_0
    //   2502: putfield 208	com/jcraft/jsch/Session:isConnected	Z
    //   2505: aload_2
    //   2506: instanceof 1074
    //   2509: ifne +54 -> 2563
    //   2512: aload_2
    //   2513: instanceof 190
    //   2516: ifeq +8 -> 2524
    //   2519: aload_2
    //   2520: checkcast 190	com/jcraft/jsch/JSchException
    //   2523: athrow
    //   2524: new 190	com/jcraft/jsch/JSchException
    //   2527: astore 12
    //   2529: new 377	java/lang/StringBuilder
    //   2532: astore_3
    //   2533: aload_3
    //   2534: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   2537: aload_3
    //   2538: ldc_w 1258
    //   2541: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: pop
    //   2545: aload_3
    //   2546: aload_2
    //   2547: invokevirtual 1261	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2550: pop
    //   2551: aload 12
    //   2553: aload_3
    //   2554: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2557: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   2560: aload 12
    //   2562: athrow
    //   2563: aload_2
    //   2564: checkcast 1074	java/lang/RuntimeException
    //   2567: athrow
    //   2568: aload_0
    //   2569: getfield 258	com/jcraft/jsch/Session:password	[B
    //   2572: invokestatic 826	com/jcraft/jsch/Util:bzero	([B)V
    //   2575: aload_0
    //   2576: aconst_null
    //   2577: putfield 258	com/jcraft/jsch/Session:password	[B
    //   2580: aload_2
    //   2581: athrow
    //   2582: new 190	com/jcraft/jsch/JSchException
    //   2585: dup
    //   2586: ldc_w 1263
    //   2589: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   2592: athrow
    //   2593: astore_3
    //   2594: goto -98 -> 2496
    //   2597: astore_3
    //   2598: goto -98 -> 2500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2601	0	this	Session
    //   0	2601	1	paramInt	int
    //   46	10	2	localException1	Exception
    //   89	1364	2	localObject1	Object
    //   1456	1	2	localException2	Exception
    //   1477	223	2	localObject2	Object
    //   1721	39	2	localException3	Exception
    //   1785	2	2	localJSchException1	JSchException
    //   1788	2	2	localRuntimeException	RuntimeException
    //   1791	2	2	localJSchPartialAuthException	JSchPartialAuthException
    //   1796	29	2	str1	String
    //   1833	1	2	localJSchAuthCancelException	JSchAuthCancelException
    //   2106	11	2	localException4	Exception
    //   2127	87	2	localJSchException2	JSchException
    //   2215	12	2	localJSchException3	JSchException
    //   2228	1	2	localException5	Exception
    //   2244	152	2	localObject4	Object
    //   2399	1	2	localObject5	Object
    //   2403	178	2	localException6	Exception
    //   81	1966	3	localObject6	Object
    //   2101	4	3	localObject7	Object
    //   2110	257	3	localObject8	Object
    //   2394	4	3	localObject9	Object
    //   2420	134	3	localObject10	Object
    //   2593	1	3	localException7	Exception
    //   2597	1	3	localException8	Exception
    //   394	1442	4	i	int
    //   431	1486	5	j	int
    //   434	1410	6	k	int
    //   460	862	7	m	int
    //   875	1384	8	bool1	boolean
    //   896	34	9	l	long
    //   1055	233	11	arrayOfString	String[]
    //   1091	957	12	localObject11	Object
    //   2122	40	12	localNumberFormatException	NumberFormatException
    //   2527	34	12	localJSchException4	JSchException
    //   1103	746	13	bool2	boolean
    //   1154	507	14	str2	String
    //   1240	462	15	localObject12	Object
    //   1521	317	16	bool3	boolean
    //   1533	294	17	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   24	43	46	java/lang/Exception
    //   1378	1453	1456	java/lang/Exception
    //   1539	1546	1721	java/lang/Exception
    //   1563	1575	1721	java/lang/Exception
    //   1587	1591	1721	java/lang/Exception
    //   1603	1608	1721	java/lang/Exception
    //   1620	1625	1721	java/lang/Exception
    //   1637	1646	1721	java/lang/Exception
    //   1658	1666	1721	java/lang/Exception
    //   1678	1687	1721	java/lang/Exception
    //   1699	1711	1721	java/lang/Exception
    //   1539	1546	1785	com/jcraft/jsch/JSchException
    //   1563	1575	1785	com/jcraft/jsch/JSchException
    //   1587	1591	1785	com/jcraft/jsch/JSchException
    //   1603	1608	1785	com/jcraft/jsch/JSchException
    //   1620	1625	1785	com/jcraft/jsch/JSchException
    //   1637	1646	1785	com/jcraft/jsch/JSchException
    //   1658	1666	1785	com/jcraft/jsch/JSchException
    //   1678	1687	1785	com/jcraft/jsch/JSchException
    //   1699	1711	1785	com/jcraft/jsch/JSchException
    //   1539	1546	1788	java/lang/RuntimeException
    //   1563	1575	1788	java/lang/RuntimeException
    //   1587	1591	1788	java/lang/RuntimeException
    //   1603	1608	1788	java/lang/RuntimeException
    //   1620	1625	1788	java/lang/RuntimeException
    //   1637	1646	1788	java/lang/RuntimeException
    //   1658	1666	1788	java/lang/RuntimeException
    //   1678	1687	1788	java/lang/RuntimeException
    //   1699	1711	1788	java/lang/RuntimeException
    //   1539	1546	1791	com/jcraft/jsch/JSchPartialAuthException
    //   1563	1575	1791	com/jcraft/jsch/JSchPartialAuthException
    //   1587	1591	1791	com/jcraft/jsch/JSchPartialAuthException
    //   1603	1608	1791	com/jcraft/jsch/JSchPartialAuthException
    //   1620	1625	1791	com/jcraft/jsch/JSchPartialAuthException
    //   1637	1646	1791	com/jcraft/jsch/JSchPartialAuthException
    //   1658	1666	1791	com/jcraft/jsch/JSchPartialAuthException
    //   1678	1687	1791	com/jcraft/jsch/JSchPartialAuthException
    //   1699	1711	1791	com/jcraft/jsch/JSchPartialAuthException
    //   1539	1546	1833	com/jcraft/jsch/JSchAuthCancelException
    //   1563	1575	1833	com/jcraft/jsch/JSchAuthCancelException
    //   1587	1591	1833	com/jcraft/jsch/JSchAuthCancelException
    //   1603	1608	1833	com/jcraft/jsch/JSchAuthCancelException
    //   1620	1625	1833	com/jcraft/jsch/JSchAuthCancelException
    //   1637	1646	1833	com/jcraft/jsch/JSchAuthCancelException
    //   1658	1666	1833	com/jcraft/jsch/JSchAuthCancelException
    //   1678	1687	1833	com/jcraft/jsch/JSchAuthCancelException
    //   1699	1711	1833	com/jcraft/jsch/JSchAuthCancelException
    //   1987	2061	2101	finally
    //   2066	2075	2101	finally
    //   2075	2086	2101	finally
    //   2086	2088	2101	finally
    //   2102	2104	2101	finally
    //   1016	1033	2106	java/lang/Exception
    //   996	1004	2122	java/lang/NumberFormatException
    //   1008	1016	2122	java/lang/NumberFormatException
    //   893	936	2215	com/jcraft/jsch/JSchException
    //   2216	2226	2228	java/lang/Exception
    //   261	330	2394	finally
    //   2395	2397	2394	finally
    //   135	140	2399	finally
    //   144	149	2399	finally
    //   153	184	2399	finally
    //   187	232	2399	finally
    //   232	256	2399	finally
    //   259	261	2399	finally
    //   334	339	2399	finally
    //   343	348	2399	finally
    //   348	377	2399	finally
    //   377	410	2399	finally
    //   419	430	2399	finally
    //   440	462	2399	finally
    //   478	492	2399	finally
    //   522	530	2399	finally
    //   584	591	2399	finally
    //   626	633	2399	finally
    //   657	774	2399	finally
    //   774	825	2399	finally
    //   825	834	2399	finally
    //   834	877	2399	finally
    //   882	888	2399	finally
    //   893	936	2399	finally
    //   936	987	2399	finally
    //   987	996	2399	finally
    //   996	1004	2399	finally
    //   1008	1016	2399	finally
    //   1016	1033	2399	finally
    //   1033	1057	2399	finally
    //   1062	1070	2399	finally
    //   1074	1079	2399	finally
    //   1084	1093	2399	finally
    //   1135	1143	2399	finally
    //   1159	1180	2399	finally
    //   1207	1219	2399	finally
    //   1229	1272	2399	finally
    //   1285	1321	2399	finally
    //   1328	1378	2399	finally
    //   1378	1453	2399	finally
    //   1457	1517	2399	finally
    //   1539	1546	2399	finally
    //   1563	1575	2399	finally
    //   1587	1591	2399	finally
    //   1603	1608	2399	finally
    //   1620	1625	2399	finally
    //   1637	1646	2399	finally
    //   1658	1666	2399	finally
    //   1678	1687	2399	finally
    //   1699	1711	2399	finally
    //   1722	1779	2399	finally
    //   1786	1788	2399	finally
    //   1789	1791	2399	finally
    //   1792	1814	2399	finally
    //   1853	1916	2399	finally
    //   1921	1934	2399	finally
    //   1934	1947	2399	finally
    //   1947	1952	2399	finally
    //   1960	1967	2399	finally
    //   1967	1975	2399	finally
    //   1975	1987	2399	finally
    //   2104	2106	2399	finally
    //   2107	2122	2399	finally
    //   2124	2168	2399	finally
    //   2168	2215	2399	finally
    //   2216	2226	2399	finally
    //   2226	2228	2399	finally
    //   2232	2274	2399	finally
    //   2274	2321	2399	finally
    //   2321	2368	2399	finally
    //   2368	2381	2399	finally
    //   2381	2394	2399	finally
    //   2397	2399	2399	finally
    //   2404	2409	2399	finally
    //   2409	2496	2399	finally
    //   2496	2500	2399	finally
    //   2500	2524	2399	finally
    //   2524	2563	2399	finally
    //   2563	2568	2399	finally
    //   135	140	2403	java/lang/Exception
    //   144	149	2403	java/lang/Exception
    //   153	184	2403	java/lang/Exception
    //   187	232	2403	java/lang/Exception
    //   232	256	2403	java/lang/Exception
    //   259	261	2403	java/lang/Exception
    //   334	339	2403	java/lang/Exception
    //   343	348	2403	java/lang/Exception
    //   348	377	2403	java/lang/Exception
    //   377	410	2403	java/lang/Exception
    //   419	430	2403	java/lang/Exception
    //   440	462	2403	java/lang/Exception
    //   478	492	2403	java/lang/Exception
    //   522	530	2403	java/lang/Exception
    //   584	591	2403	java/lang/Exception
    //   626	633	2403	java/lang/Exception
    //   657	774	2403	java/lang/Exception
    //   774	825	2403	java/lang/Exception
    //   825	834	2403	java/lang/Exception
    //   834	877	2403	java/lang/Exception
    //   882	888	2403	java/lang/Exception
    //   893	936	2403	java/lang/Exception
    //   936	987	2403	java/lang/Exception
    //   987	996	2403	java/lang/Exception
    //   996	1004	2403	java/lang/Exception
    //   1008	1016	2403	java/lang/Exception
    //   1033	1057	2403	java/lang/Exception
    //   1062	1070	2403	java/lang/Exception
    //   1074	1079	2403	java/lang/Exception
    //   1084	1093	2403	java/lang/Exception
    //   1135	1143	2403	java/lang/Exception
    //   1159	1180	2403	java/lang/Exception
    //   1207	1219	2403	java/lang/Exception
    //   1229	1272	2403	java/lang/Exception
    //   1285	1321	2403	java/lang/Exception
    //   1328	1378	2403	java/lang/Exception
    //   1457	1517	2403	java/lang/Exception
    //   1722	1779	2403	java/lang/Exception
    //   1786	1788	2403	java/lang/Exception
    //   1789	1791	2403	java/lang/Exception
    //   1792	1814	2403	java/lang/Exception
    //   1853	1916	2403	java/lang/Exception
    //   1921	1934	2403	java/lang/Exception
    //   1934	1947	2403	java/lang/Exception
    //   1947	1952	2403	java/lang/Exception
    //   1960	1967	2403	java/lang/Exception
    //   1967	1975	2403	java/lang/Exception
    //   1975	1987	2403	java/lang/Exception
    //   2104	2106	2403	java/lang/Exception
    //   2107	2122	2403	java/lang/Exception
    //   2124	2168	2403	java/lang/Exception
    //   2168	2215	2403	java/lang/Exception
    //   2226	2228	2403	java/lang/Exception
    //   2232	2274	2403	java/lang/Exception
    //   2274	2321	2403	java/lang/Exception
    //   2321	2368	2403	java/lang/Exception
    //   2368	2381	2403	java/lang/Exception
    //   2381	2394	2403	java/lang/Exception
    //   2397	2399	2403	java/lang/Exception
    //   2409	2496	2593	java/lang/Exception
    //   2496	2500	2597	java/lang/Exception
  }
  
  public void delPortForwardingL(int paramInt)
    throws JSchException
  {
    delPortForwardingL("127.0.0.1", paramInt);
  }
  
  public void delPortForwardingL(String paramString, int paramInt)
    throws JSchException
  {
    PortWatcher.delPort(this, paramString, paramInt);
  }
  
  public void delPortForwardingR(int paramInt)
    throws JSchException
  {
    delPortForwardingR(null, paramInt);
  }
  
  public void delPortForwardingR(String paramString, int paramInt)
    throws JSchException
  {
    ChannelForwardedTCPIP.delPort(this, paramString, paramInt);
  }
  
  public void disconnect()
  {
    if (!this.isConnected) {
      return;
    }
    Object localObject1;
    if (JSch.getLogger().isEnabled(1))
    {
      localObject1 = JSch.getLogger();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("Disconnecting from ");
      ((StringBuilder)???).append(this.host);
      ((StringBuilder)???).append(" port ");
      ((StringBuilder)???).append(this.port);
      ((Logger)localObject1).log(1, ((StringBuilder)???).toString());
    }
    Channel.disconnect(this);
    this.isConnected = false;
    PortWatcher.delPort(this);
    ChannelForwardedTCPIP.delPort(this);
    ChannelX11.removeFakedCookie(this);
    synchronized (this.lock)
    {
      if (this.connectThread != null)
      {
        Thread.yield();
        this.connectThread.interrupt();
        this.connectThread = null;
      }
      this.thread = null;
      try
      {
        ??? = this.io;
        if (??? != null)
        {
          ??? = ((IO)???).in;
          if (??? != null) {
            ((InputStream)???).close();
          }
          ??? = this.io.out;
          if (??? != null) {
            ((OutputStream)???).close();
          }
          ??? = this.io.out_ext;
          if (??? != null) {
            ((OutputStream)???).close();
          }
        }
        localObject1 = this.proxy;
        if (localObject1 == null)
        {
          ??? = this.socket;
          if (??? != null) {
            ((Socket)???).close();
          }
        }
        else
        {
          try
          {
            this.proxy.close();
            this.proxy = null;
          }
          finally {}
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      this.io = null;
      this.socket = null;
      this.jsch.removeSession(this);
      return;
    }
  }
  
  public void encode(Packet paramPacket)
    throws Exception
  {
    Object localObject1 = this.deflater;
    if (localObject1 != null)
    {
      ??? = this.compress_len;
      localObject3 = paramPacket.buffer;
      ???[0] = ((Buffer)localObject3).index;
      ((Buffer)localObject3).buffer = ((Compression)localObject1).compress(((Buffer)localObject3).buffer, 5, (int[])???);
      paramPacket.buffer.index = this.compress_len[0];
    }
    if (this.c2scipher != null)
    {
      paramPacket.padding(this.c2scipher_size);
      int i = paramPacket.buffer.buffer[4];
      synchronized (random)
      {
        localObject1 = random;
        localObject3 = paramPacket.buffer;
        ((Random)localObject1).fill(((Buffer)localObject3).buffer, ((Buffer)localObject3).index - i, i);
      }
    }
    paramPacket.padding(8);
    ??? = this.c2smac;
    if (??? != null)
    {
      ((MAC)???).update(this.seqo);
      ??? = this.c2smac;
      localObject3 = paramPacket.buffer;
      ((MAC)???).update(((Buffer)localObject3).buffer, 0, ((Buffer)localObject3).index);
      ??? = this.c2smac;
      localObject3 = paramPacket.buffer;
      ((MAC)???).doFinal(((Buffer)localObject3).buffer, ((Buffer)localObject3).index);
    }
    Object localObject3 = this.c2scipher;
    if (localObject3 != null)
    {
      ??? = paramPacket.buffer;
      localObject1 = ((Buffer)???).buffer;
      ((Cipher)localObject3).update((byte[])localObject1, 0, ((Buffer)???).index, (byte[])localObject1, 0);
    }
    ??? = this.c2smac;
    if (??? != null) {
      paramPacket.buffer.skip(((MAC)???).getBlockSize());
    }
  }
  
  public String getClientVersion()
  {
    return Util.byte2str(this.V_C);
  }
  
  public String getConfig(String paramString)
  {
    Object localObject = this.config;
    if (localObject != null)
    {
      localObject = ((Hashtable)localObject).get(paramString);
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
    }
    paramString = JSch.getConfig(paramString);
    if ((paramString instanceof String)) {
      return paramString;
    }
    return null;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public HostKey getHostKey()
  {
    return this.hostkey;
  }
  
  public String getHostKeyAlias()
  {
    return this.hostKeyAlias;
  }
  
  public HostKeyRepository getHostKeyRepository()
  {
    HostKeyRepository localHostKeyRepository1 = this.hostkeyRepository;
    HostKeyRepository localHostKeyRepository2 = localHostKeyRepository1;
    if (localHostKeyRepository1 == null) {
      localHostKeyRepository2 = this.jsch.getHostKeyRepository();
    }
    return localHostKeyRepository2;
  }
  
  IdentityRepository getIdentityRepository()
  {
    IdentityRepository localIdentityRepository1 = this.identityRepository;
    IdentityRepository localIdentityRepository2 = localIdentityRepository1;
    if (localIdentityRepository1 == null) {
      localIdentityRepository2 = this.jsch.getIdentityRepository();
    }
    return localIdentityRepository2;
  }
  
  public int getPort()
  {
    return this.port;
  }
  
  public String[] getPortForwardingL()
    throws JSchException
  {
    return PortWatcher.getPortForwarding(this);
  }
  
  public String[] getPortForwardingR()
    throws JSchException
  {
    return ChannelForwardedTCPIP.getPortForwarding(this);
  }
  
  public int getServerAliveCountMax()
  {
    return this.serverAliveCountMax;
  }
  
  public int getServerAliveInterval()
  {
    return this.serverAliveInterval;
  }
  
  public String getServerVersion()
  {
    return Util.byte2str(this.V_S);
  }
  
  byte[] getSessionId()
  {
    return this.session_id;
  }
  
  public Channel getStreamForwarder(String paramString, int paramInt)
    throws JSchException
  {
    ChannelDirectTCPIP localChannelDirectTCPIP = new ChannelDirectTCPIP();
    localChannelDirectTCPIP.init();
    addChannel(localChannelDirectTCPIP);
    localChannelDirectTCPIP.setHost(paramString);
    localChannelDirectTCPIP.setPort(paramInt);
    return localChannelDirectTCPIP;
  }
  
  public int getTimeout()
  {
    return this.timeout;
  }
  
  public UserInfo getUserInfo()
  {
    return this.userinfo;
  }
  
  public String getUserName()
  {
    return this.username;
  }
  
  public boolean isConnected()
  {
    return this.isConnected;
  }
  
  public void noMoreSessionChannels()
    throws Exception
  {
    Buffer localBuffer = new Buffer();
    Packet localPacket = new Packet(localBuffer);
    localPacket.reset();
    localBuffer.putByte((byte)80);
    localBuffer.putString(nomoresessions);
    localBuffer.putByte((byte)0);
    write(localPacket);
  }
  
  public Channel openChannel(String paramString)
    throws JSchException
  {
    if (this.isConnected) {
      try
      {
        paramString = Channel.getChannel(paramString);
        addChannel(paramString);
        paramString.init();
        if ((paramString instanceof ChannelSession)) {
          applyConfigChannel((ChannelSession)paramString);
        }
        return paramString;
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
    throw new JSchException("session is down");
  }
  
  public Buffer read(Buffer paramBuffer)
    throws Exception
  {
    for (;;)
    {
      paramBuffer.reset();
      this.io.getByte(paramBuffer.buffer, paramBuffer.index, this.s2ccipher_size);
      i = paramBuffer.index;
      int j = this.s2ccipher_size;
      paramBuffer.index = (i + j);
      localObject1 = this.s2ccipher;
      if (localObject1 != null)
      {
        localObject2 = paramBuffer.buffer;
        ((Cipher)localObject1).update((byte[])localObject2, 0, j, (byte[])localObject2, 0);
      }
      localObject1 = paramBuffer.buffer;
      j = localObject1[0] << 24 & 0xFF000000 | localObject1[1] << 16 & 0xFF0000 | localObject1[2] << 8 & 0xFF00 | localObject1[3] & 0xFF;
      if ((j < 5) || (j > 262144)) {
        start_discard(paramBuffer, this.s2ccipher, this.s2cmac, j, 262144);
      }
      i = j + 4 - this.s2ccipher_size;
      int k = paramBuffer.index;
      localObject1 = paramBuffer.buffer;
      if (k + i > localObject1.length)
      {
        localObject2 = new byte[k + i];
        System.arraycopy(localObject1, 0, localObject2, 0, k);
        paramBuffer.buffer = ((byte[])localObject2);
      }
      if (i % this.s2ccipher_size != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Bad packet length ");
        ((StringBuilder)localObject1).append(i);
        localObject1 = ((StringBuilder)localObject1).toString();
        if (JSch.getLogger().isEnabled(4)) {
          JSch.getLogger().log(4, (String)localObject1);
        }
        start_discard(paramBuffer, this.s2ccipher, this.s2cmac, j, 262144 - this.s2ccipher_size);
      }
      if (i > 0)
      {
        this.io.getByte(paramBuffer.buffer, paramBuffer.index, i);
        paramBuffer.index += i;
        localObject2 = this.s2ccipher;
        if (localObject2 != null)
        {
          localObject1 = paramBuffer.buffer;
          k = this.s2ccipher_size;
          ((Cipher)localObject2).update((byte[])localObject1, k, i, (byte[])localObject1, k);
        }
      }
      localObject1 = this.s2cmac;
      if (localObject1 != null)
      {
        ((MAC)localObject1).update(this.seqi);
        this.s2cmac.update(paramBuffer.buffer, 0, paramBuffer.index);
        this.s2cmac.doFinal(this.s2cmac_result1, 0);
        localObject2 = this.io;
        localObject1 = this.s2cmac_result2;
        ((IO)localObject2).getByte((byte[])localObject1, 0, localObject1.length);
        if (!Arrays.equals(this.s2cmac_result1, this.s2cmac_result2))
        {
          if (i <= 262144)
          {
            start_discard(paramBuffer, this.s2ccipher, this.s2cmac, j, 262144 - i);
            continue;
          }
          throw new IOException("MAC Error");
        }
      }
      this.seqi += 1;
      Compression localCompression = this.inflater;
      if (localCompression != null)
      {
        localObject1 = paramBuffer.buffer;
        i = localObject1[4];
        localObject2 = this.uncompress_len;
        localObject2[0] = (paramBuffer.index - 5 - i);
        localObject1 = localCompression.uncompress((byte[])localObject1, 5, (int[])localObject2);
        if (localObject1 != null)
        {
          paramBuffer.buffer = ((byte[])localObject1);
          paramBuffer.index = (this.uncompress_len[0] + 5);
        }
        else
        {
          System.err.println("fail in inflater");
          break label819;
        }
      }
      i = paramBuffer.getCommand() & 0xFF;
      if (i == 1) {
        break label825;
      }
      if (i != 2) {
        if (i == 3)
        {
          paramBuffer.rewind();
          paramBuffer.getInt();
          paramBuffer.getShort();
          i = paramBuffer.getInt();
          if (JSch.getLogger().isEnabled(1))
          {
            localObject1 = JSch.getLogger();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Received SSH_MSG_UNIMPLEMENTED for ");
            ((StringBuilder)localObject2).append(i);
            ((Logger)localObject1).log(1, ((StringBuilder)localObject2).toString());
          }
        }
        else if (i == 4)
        {
          paramBuffer.rewind();
          paramBuffer.getInt();
          paramBuffer.getShort();
        }
        else
        {
          if (i != 93) {
            break;
          }
          paramBuffer.rewind();
          paramBuffer.getInt();
          paramBuffer.getShort();
          localObject1 = Channel.getChannel(paramBuffer.getInt(), this);
          if (localObject1 != null) {
            ((Channel)localObject1).addRemoteWindowSize(paramBuffer.getUInt());
          }
        }
      }
    }
    if (i == 52)
    {
      this.isAuthed = true;
      if ((this.inflater == null) && (this.deflater == null))
      {
        initDeflater(this.guess[6]);
        initInflater(this.guess[7]);
      }
    }
    label819:
    paramBuffer.rewind();
    return paramBuffer;
    label825:
    paramBuffer.rewind();
    paramBuffer.getInt();
    paramBuffer.getShort();
    int i = paramBuffer.getInt();
    Object localObject1 = paramBuffer.getString();
    paramBuffer = paramBuffer.getString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("SSH_MSG_DISCONNECT: ");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(Util.byte2str((byte[])localObject1));
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(Util.byte2str(paramBuffer));
    throw new JSchException(((StringBuilder)localObject2).toString());
  }
  
  public void rekey()
    throws Exception
  {
    send_kexinit();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: putfield 1297	com/jcraft/jsch/Session:thread	Ljava/lang/Runnable;
    //   5: new 281	com/jcraft/jsch/Buffer
    //   8: dup
    //   9: invokespecial 282	com/jcraft/jsch/Buffer:<init>	()V
    //   12: astore_1
    //   13: new 286	com/jcraft/jsch/Packet
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 289	com/jcraft/jsch/Packet:<init>	(Lcom/jcraft/jsch/Buffer;)V
    //   21: astore_2
    //   22: iconst_1
    //   23: newarray <illegal type>
    //   25: astore_3
    //   26: iconst_1
    //   27: newarray <illegal type>
    //   29: astore 4
    //   31: aconst_null
    //   32: astore 5
    //   34: iconst_0
    //   35: istore 6
    //   37: aload_0
    //   38: getfield 208	com/jcraft/jsch/Session:isConnected	Z
    //   41: ifeq +1709 -> 1750
    //   44: aload_0
    //   45: getfield 1297	com/jcraft/jsch/Session:thread	Ljava/lang/Runnable;
    //   48: astore 7
    //   50: aload 7
    //   52: ifnull +1698 -> 1750
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 1152	com/jcraft/jsch/Session:read	(Lcom/jcraft/jsch/Buffer;)Lcom/jcraft/jsch/Buffer;
    //   60: astore 7
    //   62: aload 7
    //   64: invokevirtual 1156	com/jcraft/jsch/Buffer:getCommand	()B
    //   67: sipush 255
    //   70: iand
    //   71: istore 8
    //   73: aload 5
    //   75: ifnull +82 -> 157
    //   78: aload 5
    //   80: invokevirtual 1163	com/jcraft/jsch/KeyExchange:getState	()I
    //   83: iload 8
    //   85: if_icmpne +72 -> 157
    //   88: aload_0
    //   89: invokestatic 969	java/lang/System:currentTimeMillis	()J
    //   92: putfield 242	com/jcraft/jsch/Session:kex_start_time	J
    //   95: aload 5
    //   97: aload 7
    //   99: invokevirtual 1167	com/jcraft/jsch/KeyExchange:next	(Lcom/jcraft/jsch/Buffer;)Z
    //   102: istore 9
    //   104: iload 9
    //   106: ifeq +9 -> 115
    //   109: aload 7
    //   111: astore_1
    //   112: goto -78 -> 34
    //   115: new 190	com/jcraft/jsch/JSchException
    //   118: astore_1
    //   119: new 377	java/lang/StringBuilder
    //   122: astore 5
    //   124: aload 5
    //   126: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   129: aload 5
    //   131: ldc_w 1237
    //   134: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 5
    //   140: iload 9
    //   142: invokevirtual 1240	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_1
    //   147: aload 5
    //   149: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   155: aload_1
    //   156: athrow
    //   157: iload 8
    //   159: bipush 20
    //   161: if_icmpeq +1461 -> 1622
    //   164: iload 8
    //   166: bipush 21
    //   168: if_icmpeq +1436 -> 1604
    //   171: iload 8
    //   173: tableswitch	default:+27->200, 80:+1366->1539, 81:+1270->1443, 82:+1270->1443
    //   200: iload 8
    //   202: tableswitch	default:+58->260, 90:+1002->1204, 91:+917->1119, 92:+852->1054, 93:+805->1007, 94:+599->801, 95:+409->611, 96:+367->569, 97:+325->527, 98:+186->388, 99:+143->345, 100:+100->302
    //   260: new 997	java/io/IOException
    //   263: astore_1
    //   264: new 377	java/lang/StringBuilder
    //   267: astore 5
    //   269: aload 5
    //   271: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   274: aload 5
    //   276: ldc_w 1435
    //   279: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 5
    //   285: iload 8
    //   287: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload_1
    //   292: aload 5
    //   294: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokespecial 1391	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   300: aload_1
    //   301: athrow
    //   302: aload 7
    //   304: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   307: pop
    //   308: aload 7
    //   310: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   313: pop
    //   314: aload 7
    //   316: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   319: aload_0
    //   320: invokestatic 1416	com/jcraft/jsch/Channel:getChannel	(ILcom/jcraft/jsch/Session;)Lcom/jcraft/jsch/Channel;
    //   323: astore_1
    //   324: aload_1
    //   325: ifnonnull +9 -> 334
    //   328: aload 7
    //   330: astore_1
    //   331: goto -297 -> 34
    //   334: aload_1
    //   335: iconst_0
    //   336: putfield 1438	com/jcraft/jsch/Channel:reply	I
    //   339: aload 7
    //   341: astore_1
    //   342: goto -308 -> 34
    //   345: aload 7
    //   347: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   350: pop
    //   351: aload 7
    //   353: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   356: pop
    //   357: aload 7
    //   359: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   362: aload_0
    //   363: invokestatic 1416	com/jcraft/jsch/Channel:getChannel	(ILcom/jcraft/jsch/Session;)Lcom/jcraft/jsch/Channel;
    //   366: astore_1
    //   367: aload_1
    //   368: ifnonnull +9 -> 377
    //   371: aload 7
    //   373: astore_1
    //   374: goto -340 -> 34
    //   377: aload_1
    //   378: iconst_1
    //   379: putfield 1438	com/jcraft/jsch/Channel:reply	I
    //   382: aload 7
    //   384: astore_1
    //   385: goto -351 -> 34
    //   388: aload 7
    //   390: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   393: pop
    //   394: aload 7
    //   396: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   399: pop
    //   400: aload 7
    //   402: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   405: istore 8
    //   407: aload 7
    //   409: invokevirtual 1425	com/jcraft/jsch/Buffer:getString	()[B
    //   412: astore 10
    //   414: aload 7
    //   416: invokevirtual 907	com/jcraft/jsch/Buffer:getByte	()I
    //   419: ifeq +9 -> 428
    //   422: iconst_1
    //   423: istore 6
    //   425: goto +6 -> 431
    //   428: iconst_0
    //   429: istore 6
    //   431: iload 8
    //   433: aload_0
    //   434: invokestatic 1416	com/jcraft/jsch/Channel:getChannel	(ILcom/jcraft/jsch/Session;)Lcom/jcraft/jsch/Channel;
    //   437: astore 11
    //   439: aload 7
    //   441: astore_1
    //   442: aload 11
    //   444: ifnull -410 -> 34
    //   447: bipush 100
    //   449: istore 8
    //   451: iload 8
    //   453: istore 12
    //   455: aload 10
    //   457: invokestatic 744	com/jcraft/jsch/Util:byte2str	([B)Ljava/lang/String;
    //   460: ldc_w 1440
    //   463: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   466: ifeq +21 -> 487
    //   469: aload 11
    //   471: aload 7
    //   473: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   476: invokevirtual 1443	com/jcraft/jsch/Channel:setExitStatus	(I)V
    //   479: bipush 99
    //   481: istore 8
    //   483: iload 8
    //   485: istore 12
    //   487: aload 7
    //   489: astore_1
    //   490: iload 6
    //   492: ifeq -458 -> 34
    //   495: aload_2
    //   496: invokevirtual 345	com/jcraft/jsch/Packet:reset	()V
    //   499: aload 7
    //   501: iload 12
    //   503: invokevirtual 349	com/jcraft/jsch/Buffer:putByte	(B)V
    //   506: aload 7
    //   508: aload 11
    //   510: invokevirtual 1446	com/jcraft/jsch/Channel:getRecipient	()I
    //   513: invokevirtual 358	com/jcraft/jsch/Buffer:putInt	(I)V
    //   516: aload_0
    //   517: aload_2
    //   518: invokevirtual 362	com/jcraft/jsch/Session:write	(Lcom/jcraft/jsch/Packet;)V
    //   521: aload 7
    //   523: astore_1
    //   524: goto -490 -> 34
    //   527: aload 7
    //   529: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   532: pop
    //   533: aload 7
    //   535: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   538: pop
    //   539: aload 7
    //   541: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   544: aload_0
    //   545: invokestatic 1416	com/jcraft/jsch/Channel:getChannel	(ILcom/jcraft/jsch/Session;)Lcom/jcraft/jsch/Channel;
    //   548: astore 11
    //   550: aload 7
    //   552: astore_1
    //   553: aload 11
    //   555: ifnull -521 -> 34
    //   558: aload 11
    //   560: invokevirtual 1447	com/jcraft/jsch/Channel:disconnect	()V
    //   563: aload 7
    //   565: astore_1
    //   566: goto -532 -> 34
    //   569: aload 7
    //   571: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   574: pop
    //   575: aload 7
    //   577: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   580: pop
    //   581: aload 7
    //   583: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   586: aload_0
    //   587: invokestatic 1416	com/jcraft/jsch/Channel:getChannel	(ILcom/jcraft/jsch/Session;)Lcom/jcraft/jsch/Channel;
    //   590: astore 11
    //   592: aload 7
    //   594: astore_1
    //   595: aload 11
    //   597: ifnull -563 -> 34
    //   600: aload 11
    //   602: invokevirtual 1450	com/jcraft/jsch/Channel:eof_remote	()V
    //   605: aload 7
    //   607: astore_1
    //   608: goto -574 -> 34
    //   611: aload 7
    //   613: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   616: pop
    //   617: aload 7
    //   619: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   622: pop
    //   623: aload 7
    //   625: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   628: aload_0
    //   629: invokestatic 1416	com/jcraft/jsch/Channel:getChannel	(ILcom/jcraft/jsch/Session;)Lcom/jcraft/jsch/Channel;
    //   632: astore 11
    //   634: aload 7
    //   636: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   639: pop
    //   640: aload 7
    //   642: aload_3
    //   643: aload 4
    //   645: invokevirtual 1453	com/jcraft/jsch/Buffer:getString	([I[I)[B
    //   648: astore_1
    //   649: aload 11
    //   651: ifnonnull +9 -> 660
    //   654: aload 7
    //   656: astore_1
    //   657: goto -623 -> 34
    //   660: aload 4
    //   662: iconst_0
    //   663: iaload
    //   664: ifne +9 -> 673
    //   667: aload 7
    //   669: astore_1
    //   670: goto -636 -> 34
    //   673: aload 11
    //   675: aload_1
    //   676: aload_3
    //   677: iconst_0
    //   678: iaload
    //   679: aload 4
    //   681: iconst_0
    //   682: iaload
    //   683: invokevirtual 1456	com/jcraft/jsch/Channel:write_ext	([BII)V
    //   686: aload 4
    //   688: iconst_0
    //   689: iaload
    //   690: istore 6
    //   692: aload 11
    //   694: aload 11
    //   696: getfield 1459	com/jcraft/jsch/Channel:lwsize	I
    //   699: iload 6
    //   701: isub
    //   702: invokevirtual 1462	com/jcraft/jsch/Channel:setLocalWindowSize	(I)V
    //   705: aload 7
    //   707: astore_1
    //   708: aload 11
    //   710: getfield 1459	com/jcraft/jsch/Channel:lwsize	I
    //   713: aload 11
    //   715: getfield 1465	com/jcraft/jsch/Channel:lwsize_max	I
    //   718: iconst_2
    //   719: idiv
    //   720: if_icmpge -686 -> 34
    //   723: aload_2
    //   724: invokevirtual 345	com/jcraft/jsch/Packet:reset	()V
    //   727: aload 7
    //   729: bipush 93
    //   731: invokevirtual 349	com/jcraft/jsch/Buffer:putByte	(B)V
    //   734: aload 7
    //   736: aload 11
    //   738: invokevirtual 1446	com/jcraft/jsch/Channel:getRecipient	()I
    //   741: invokevirtual 358	com/jcraft/jsch/Buffer:putInt	(I)V
    //   744: aload 7
    //   746: aload 11
    //   748: getfield 1465	com/jcraft/jsch/Channel:lwsize_max	I
    //   751: aload 11
    //   753: getfield 1459	com/jcraft/jsch/Channel:lwsize	I
    //   756: isub
    //   757: invokevirtual 358	com/jcraft/jsch/Buffer:putInt	(I)V
    //   760: aload 11
    //   762: monitorenter
    //   763: aload 11
    //   765: getfield 1467	com/jcraft/jsch/Channel:close	Z
    //   768: ifne +8 -> 776
    //   771: aload_0
    //   772: aload_2
    //   773: invokevirtual 362	com/jcraft/jsch/Session:write	(Lcom/jcraft/jsch/Packet;)V
    //   776: aload 11
    //   778: monitorexit
    //   779: aload 11
    //   781: aload 11
    //   783: getfield 1465	com/jcraft/jsch/Channel:lwsize_max	I
    //   786: invokevirtual 1462	com/jcraft/jsch/Channel:setLocalWindowSize	(I)V
    //   789: aload 7
    //   791: astore_1
    //   792: goto -758 -> 34
    //   795: astore_1
    //   796: aload 11
    //   798: monitorexit
    //   799: aload_1
    //   800: athrow
    //   801: aload 7
    //   803: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   806: pop
    //   807: aload 7
    //   809: invokevirtual 907	com/jcraft/jsch/Buffer:getByte	()I
    //   812: pop
    //   813: aload 7
    //   815: invokevirtual 907	com/jcraft/jsch/Buffer:getByte	()I
    //   818: pop
    //   819: aload 7
    //   821: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   824: aload_0
    //   825: invokestatic 1416	com/jcraft/jsch/Channel:getChannel	(ILcom/jcraft/jsch/Session;)Lcom/jcraft/jsch/Channel;
    //   828: astore 11
    //   830: aload 7
    //   832: aload_3
    //   833: aload 4
    //   835: invokevirtual 1453	com/jcraft/jsch/Buffer:getString	([I[I)[B
    //   838: astore_1
    //   839: aload 11
    //   841: ifnonnull +9 -> 850
    //   844: aload 7
    //   846: astore_1
    //   847: goto -813 -> 34
    //   850: aload 4
    //   852: iconst_0
    //   853: iaload
    //   854: istore 6
    //   856: iload 6
    //   858: ifne +9 -> 867
    //   861: aload 7
    //   863: astore_1
    //   864: goto -830 -> 34
    //   867: aload 11
    //   869: aload_1
    //   870: aload_3
    //   871: iconst_0
    //   872: iaload
    //   873: aload 4
    //   875: iconst_0
    //   876: iaload
    //   877: invokevirtual 1469	com/jcraft/jsch/Channel:write	([BII)V
    //   880: aload 4
    //   882: iconst_0
    //   883: iaload
    //   884: istore 6
    //   886: aload 11
    //   888: aload 11
    //   890: getfield 1459	com/jcraft/jsch/Channel:lwsize	I
    //   893: iload 6
    //   895: isub
    //   896: invokevirtual 1462	com/jcraft/jsch/Channel:setLocalWindowSize	(I)V
    //   899: aload 7
    //   901: astore_1
    //   902: aload 11
    //   904: getfield 1459	com/jcraft/jsch/Channel:lwsize	I
    //   907: aload 11
    //   909: getfield 1465	com/jcraft/jsch/Channel:lwsize_max	I
    //   912: iconst_2
    //   913: idiv
    //   914: if_icmpge -880 -> 34
    //   917: aload_2
    //   918: invokevirtual 345	com/jcraft/jsch/Packet:reset	()V
    //   921: aload 7
    //   923: bipush 93
    //   925: invokevirtual 349	com/jcraft/jsch/Buffer:putByte	(B)V
    //   928: aload 7
    //   930: aload 11
    //   932: invokevirtual 1446	com/jcraft/jsch/Channel:getRecipient	()I
    //   935: invokevirtual 358	com/jcraft/jsch/Buffer:putInt	(I)V
    //   938: aload 7
    //   940: aload 11
    //   942: getfield 1465	com/jcraft/jsch/Channel:lwsize_max	I
    //   945: aload 11
    //   947: getfield 1459	com/jcraft/jsch/Channel:lwsize	I
    //   950: isub
    //   951: invokevirtual 358	com/jcraft/jsch/Buffer:putInt	(I)V
    //   954: aload 11
    //   956: monitorenter
    //   957: aload 11
    //   959: getfield 1467	com/jcraft/jsch/Channel:close	Z
    //   962: ifne +8 -> 970
    //   965: aload_0
    //   966: aload_2
    //   967: invokevirtual 362	com/jcraft/jsch/Session:write	(Lcom/jcraft/jsch/Packet;)V
    //   970: aload 11
    //   972: monitorexit
    //   973: aload 11
    //   975: aload 11
    //   977: getfield 1465	com/jcraft/jsch/Channel:lwsize_max	I
    //   980: invokevirtual 1462	com/jcraft/jsch/Channel:setLocalWindowSize	(I)V
    //   983: aload 7
    //   985: astore_1
    //   986: goto -952 -> 34
    //   989: astore_1
    //   990: aload 11
    //   992: monitorexit
    //   993: aload_1
    //   994: athrow
    //   995: astore_1
    //   996: aload 11
    //   998: invokevirtual 1447	com/jcraft/jsch/Channel:disconnect	()V
    //   1001: aload 7
    //   1003: astore_1
    //   1004: goto -970 -> 34
    //   1007: aload 7
    //   1009: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1012: pop
    //   1013: aload 7
    //   1015: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   1018: pop
    //   1019: aload 7
    //   1021: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1024: aload_0
    //   1025: invokestatic 1416	com/jcraft/jsch/Channel:getChannel	(ILcom/jcraft/jsch/Session;)Lcom/jcraft/jsch/Channel;
    //   1028: astore_1
    //   1029: aload_1
    //   1030: ifnonnull +9 -> 1039
    //   1033: aload 7
    //   1035: astore_1
    //   1036: goto -1002 -> 34
    //   1039: aload_1
    //   1040: aload 7
    //   1042: invokevirtual 1419	com/jcraft/jsch/Buffer:getUInt	()J
    //   1045: invokevirtual 1422	com/jcraft/jsch/Channel:addRemoteWindowSize	(J)V
    //   1048: aload 7
    //   1050: astore_1
    //   1051: goto -1017 -> 34
    //   1054: aload 7
    //   1056: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1059: pop
    //   1060: aload 7
    //   1062: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   1065: pop
    //   1066: aload 7
    //   1068: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1071: aload_0
    //   1072: invokestatic 1416	com/jcraft/jsch/Channel:getChannel	(ILcom/jcraft/jsch/Session;)Lcom/jcraft/jsch/Channel;
    //   1075: astore 11
    //   1077: aload 7
    //   1079: astore_1
    //   1080: aload 11
    //   1082: ifnull -1048 -> 34
    //   1085: aload 11
    //   1087: aload 7
    //   1089: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1092: invokevirtual 1443	com/jcraft/jsch/Channel:setExitStatus	(I)V
    //   1095: aload 11
    //   1097: iconst_1
    //   1098: putfield 1467	com/jcraft/jsch/Channel:close	Z
    //   1101: aload 11
    //   1103: iconst_1
    //   1104: putfield 1471	com/jcraft/jsch/Channel:eof_remote	Z
    //   1107: aload 11
    //   1109: iconst_0
    //   1110: invokevirtual 1474	com/jcraft/jsch/Channel:setRecipient	(I)V
    //   1113: aload 7
    //   1115: astore_1
    //   1116: goto -1082 -> 34
    //   1119: aload 7
    //   1121: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1124: pop
    //   1125: aload 7
    //   1127: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   1130: pop
    //   1131: aload 7
    //   1133: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1136: aload_0
    //   1137: invokestatic 1416	com/jcraft/jsch/Channel:getChannel	(ILcom/jcraft/jsch/Session;)Lcom/jcraft/jsch/Channel;
    //   1140: astore 11
    //   1142: aload 7
    //   1144: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1147: istore 6
    //   1149: aload 7
    //   1151: invokevirtual 1419	com/jcraft/jsch/Buffer:getUInt	()J
    //   1154: lstore 13
    //   1156: aload 7
    //   1158: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1161: istore 8
    //   1163: aload 7
    //   1165: astore_1
    //   1166: aload 11
    //   1168: ifnull -1134 -> 34
    //   1171: aload 11
    //   1173: lload 13
    //   1175: invokevirtual 1477	com/jcraft/jsch/Channel:setRemoteWindowSize	(J)V
    //   1178: aload 11
    //   1180: iload 8
    //   1182: invokevirtual 1480	com/jcraft/jsch/Channel:setRemotePacketSize	(I)V
    //   1185: aload 11
    //   1187: iconst_1
    //   1188: putfield 1483	com/jcraft/jsch/Channel:open_confirmation	Z
    //   1191: aload 11
    //   1193: iload 6
    //   1195: invokevirtual 1474	com/jcraft/jsch/Channel:setRecipient	(I)V
    //   1198: aload 7
    //   1200: astore_1
    //   1201: goto -1167 -> 34
    //   1204: aload 7
    //   1206: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1209: pop
    //   1210: aload 7
    //   1212: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   1215: pop
    //   1216: aload 7
    //   1218: invokevirtual 1425	com/jcraft/jsch/Buffer:getString	()[B
    //   1221: invokestatic 744	com/jcraft/jsch/Util:byte2str	([B)Ljava/lang/String;
    //   1224: astore_1
    //   1225: ldc_w 1485
    //   1228: aload_1
    //   1229: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1232: ifne +91 -> 1323
    //   1235: ldc_w 1487
    //   1238: aload_1
    //   1239: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1242: ifeq +10 -> 1252
    //   1245: aload_0
    //   1246: getfield 216	com/jcraft/jsch/Session:x11_forwarding	Z
    //   1249: ifne +74 -> 1323
    //   1252: ldc_w 1489
    //   1255: aload_1
    //   1256: invokevirtual 507	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1259: ifeq +10 -> 1269
    //   1262: aload_0
    //   1263: getfield 218	com/jcraft/jsch/Session:agent_forwarding	Z
    //   1266: ifne +57 -> 1323
    //   1269: aload_2
    //   1270: invokevirtual 345	com/jcraft/jsch/Packet:reset	()V
    //   1273: aload 7
    //   1275: bipush 92
    //   1277: invokevirtual 349	com/jcraft/jsch/Buffer:putByte	(B)V
    //   1280: aload 7
    //   1282: aload 7
    //   1284: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1287: invokevirtual 358	com/jcraft/jsch/Buffer:putInt	(I)V
    //   1290: aload 7
    //   1292: iconst_1
    //   1293: invokevirtual 358	com/jcraft/jsch/Buffer:putInt	(I)V
    //   1296: getstatic 1492	com/jcraft/jsch/Util:empty	[B
    //   1299: astore_1
    //   1300: aload 7
    //   1302: aload_1
    //   1303: invokevirtual 355	com/jcraft/jsch/Buffer:putString	([B)V
    //   1306: aload 7
    //   1308: aload_1
    //   1309: invokevirtual 355	com/jcraft/jsch/Buffer:putString	([B)V
    //   1312: aload_0
    //   1313: aload_2
    //   1314: invokevirtual 362	com/jcraft/jsch/Session:write	(Lcom/jcraft/jsch/Packet;)V
    //   1317: aload 7
    //   1319: astore_1
    //   1320: goto -1286 -> 34
    //   1323: aload_1
    //   1324: invokestatic 1371	com/jcraft/jsch/Channel:getChannel	(Ljava/lang/String;)Lcom/jcraft/jsch/Channel;
    //   1327: astore 10
    //   1329: aload_0
    //   1330: aload 10
    //   1332: invokevirtual 1357	com/jcraft/jsch/Session:addChannel	(Lcom/jcraft/jsch/Channel;)V
    //   1335: aload 10
    //   1337: aload 7
    //   1339: invokevirtual 1495	com/jcraft/jsch/Channel:getData	(Lcom/jcraft/jsch/Buffer;)V
    //   1342: aload 10
    //   1344: invokevirtual 1372	com/jcraft/jsch/Channel:init	()V
    //   1347: new 331	java/lang/Thread
    //   1350: astore 11
    //   1352: aload 11
    //   1354: aload 10
    //   1356: invokespecial 1217	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   1359: new 377	java/lang/StringBuilder
    //   1362: astore 10
    //   1364: aload 10
    //   1366: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1369: aload 10
    //   1371: ldc_w 1497
    //   1374: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: pop
    //   1378: aload 10
    //   1380: aload_1
    //   1381: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: pop
    //   1385: aload 10
    //   1387: ldc_w 850
    //   1390: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: pop
    //   1394: aload 10
    //   1396: aload_0
    //   1397: getfield 250	com/jcraft/jsch/Session:host	Ljava/lang/String;
    //   1400: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: pop
    //   1404: aload 11
    //   1406: aload 10
    //   1408: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1411: invokevirtual 1224	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   1414: aload_0
    //   1415: getfield 240	com/jcraft/jsch/Session:daemon_thread	Z
    //   1418: istore 9
    //   1420: iload 9
    //   1422: ifeq +10 -> 1432
    //   1425: aload 11
    //   1427: iload 9
    //   1429: invokevirtual 1227	java/lang/Thread:setDaemon	(Z)V
    //   1432: aload 11
    //   1434: invokevirtual 1229	java/lang/Thread:start	()V
    //   1437: aload 7
    //   1439: astore_1
    //   1440: goto -1406 -> 34
    //   1443: aload_0
    //   1444: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   1447: invokevirtual 1500	com/jcraft/jsch/Session$GlobalRequestReply:getThread	()Ljava/lang/Thread;
    //   1450: astore 11
    //   1452: aload 7
    //   1454: astore_1
    //   1455: aload 11
    //   1457: ifnull -1423 -> 34
    //   1460: aload_0
    //   1461: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   1464: astore_1
    //   1465: iload 8
    //   1467: bipush 81
    //   1469: if_icmpne +9 -> 1478
    //   1472: iconst_1
    //   1473: istore 6
    //   1475: goto +6 -> 1481
    //   1478: iconst_0
    //   1479: istore 6
    //   1481: aload_1
    //   1482: iload 6
    //   1484: invokevirtual 1503	com/jcraft/jsch/Session$GlobalRequestReply:setReply	(I)V
    //   1487: iload 8
    //   1489: bipush 81
    //   1491: if_icmpne +37 -> 1528
    //   1494: aload_0
    //   1495: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   1498: invokevirtual 375	com/jcraft/jsch/Session$GlobalRequestReply:getPort	()I
    //   1501: ifne +27 -> 1528
    //   1504: aload 7
    //   1506: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1509: pop
    //   1510: aload 7
    //   1512: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   1515: pop
    //   1516: aload_0
    //   1517: getfield 275	com/jcraft/jsch/Session:grr	Lcom/jcraft/jsch/Session$GlobalRequestReply;
    //   1520: aload 7
    //   1522: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1525: invokevirtual 342	com/jcraft/jsch/Session$GlobalRequestReply:setPort	(I)V
    //   1528: aload 11
    //   1530: invokevirtual 1295	java/lang/Thread:interrupt	()V
    //   1533: aload 7
    //   1535: astore_1
    //   1536: goto -1502 -> 34
    //   1539: aload 7
    //   1541: invokevirtual 901	com/jcraft/jsch/Buffer:getInt	()I
    //   1544: pop
    //   1545: aload 7
    //   1547: invokevirtual 1411	com/jcraft/jsch/Buffer:getShort	()I
    //   1550: pop
    //   1551: aload 7
    //   1553: invokevirtual 1425	com/jcraft/jsch/Buffer:getString	()[B
    //   1556: pop
    //   1557: aload 7
    //   1559: invokevirtual 907	com/jcraft/jsch/Buffer:getByte	()I
    //   1562: ifeq +9 -> 1571
    //   1565: iconst_1
    //   1566: istore 6
    //   1568: goto +6 -> 1574
    //   1571: iconst_0
    //   1572: istore 6
    //   1574: aload 7
    //   1576: astore_1
    //   1577: iload 6
    //   1579: ifeq -1545 -> 34
    //   1582: aload_2
    //   1583: invokevirtual 345	com/jcraft/jsch/Packet:reset	()V
    //   1586: aload 7
    //   1588: bipush 82
    //   1590: invokevirtual 349	com/jcraft/jsch/Buffer:putByte	(B)V
    //   1593: aload_0
    //   1594: aload_2
    //   1595: invokevirtual 362	com/jcraft/jsch/Session:write	(Lcom/jcraft/jsch/Packet;)V
    //   1598: aload 7
    //   1600: astore_1
    //   1601: goto -1567 -> 34
    //   1604: aload_0
    //   1605: invokespecial 1171	com/jcraft/jsch/Session:send_newkeys	()V
    //   1608: aload_0
    //   1609: aload 7
    //   1611: aload 5
    //   1613: invokespecial 1175	com/jcraft/jsch/Session:receive_newkeys	(Lcom/jcraft/jsch/Buffer;Lcom/jcraft/jsch/KeyExchange;)V
    //   1616: aload 7
    //   1618: astore_1
    //   1619: goto -1588 -> 31
    //   1622: aload_0
    //   1623: aload 7
    //   1625: invokespecial 1160	com/jcraft/jsch/Session:receive_kexinit	(Lcom/jcraft/jsch/Buffer;)Lcom/jcraft/jsch/KeyExchange;
    //   1628: astore 5
    //   1630: aload 7
    //   1632: astore_1
    //   1633: goto -1599 -> 34
    //   1636: astore 7
    //   1638: aload_0
    //   1639: getfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   1642: ifne +22 -> 1664
    //   1645: iload 6
    //   1647: aload_0
    //   1648: getfield 234	com/jcraft/jsch/Session:serverAliveCountMax	I
    //   1651: if_icmpge +13 -> 1664
    //   1654: aload_0
    //   1655: invokevirtual 1506	com/jcraft/jsch/Session:sendKeepAliveMsg	()V
    //   1658: iinc 6 1
    //   1661: goto -1624 -> 37
    //   1664: aload_0
    //   1665: getfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   1668: ifeq +15 -> 1683
    //   1671: iload 6
    //   1673: aload_0
    //   1674: getfield 234	com/jcraft/jsch/Session:serverAliveCountMax	I
    //   1677: if_icmpge +6 -> 1683
    //   1680: goto -22 -> 1658
    //   1683: aload 7
    //   1685: athrow
    //   1686: astore 7
    //   1688: aload_0
    //   1689: iconst_0
    //   1690: putfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   1693: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1696: iconst_1
    //   1697: invokeinterface 595 2 0
    //   1702: ifeq +48 -> 1750
    //   1705: invokestatic 589	com/jcraft/jsch/JSch:getLogger	()Lcom/jcraft/jsch/Logger;
    //   1708: astore_1
    //   1709: new 377	java/lang/StringBuilder
    //   1712: dup
    //   1713: invokespecial 378	java/lang/StringBuilder:<init>	()V
    //   1716: astore 5
    //   1718: aload 5
    //   1720: ldc_w 1508
    //   1723: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1726: pop
    //   1727: aload 5
    //   1729: aload 7
    //   1731: invokevirtual 1511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1734: invokevirtual 384	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1737: pop
    //   1738: aload_1
    //   1739: iconst_1
    //   1740: aload 5
    //   1742: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1745: invokeinterface 601 3 0
    //   1750: aload_0
    //   1751: invokevirtual 1256	com/jcraft/jsch/Session:disconnect	()V
    //   1754: aload_0
    //   1755: iconst_0
    //   1756: putfield 208	com/jcraft/jsch/Session:isConnected	Z
    //   1759: return
    //   1760: astore_1
    //   1761: aload 7
    //   1763: astore_1
    //   1764: goto -1730 -> 34
    //   1767: astore_1
    //   1768: goto -14 -> 1754
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1771	0	this	Session
    //   12	780	1	localObject1	Object
    //   795	5	1	localObject2	Object
    //   838	148	1	localObject3	Object
    //   989	5	1	localObject4	Object
    //   995	1	1	localException1	Exception
    //   1003	736	1	localObject5	Object
    //   1760	1	1	localException2	Exception
    //   1763	1	1	localObject6	Object
    //   1767	1	1	localNullPointerException	NullPointerException
    //   21	1574	2	localPacket	Packet
    //   25	846	3	arrayOfInt1	int[]
    //   29	852	4	arrayOfInt2	int[]
    //   32	1709	5	localObject7	Object
    //   35	1643	6	i	int
    //   48	1583	7	localObject8	Object
    //   1636	48	7	localInterruptedIOException	java.io.InterruptedIOException
    //   1686	76	7	localException3	Exception
    //   71	1421	8	j	int
    //   102	1326	9	bool	boolean
    //   412	995	10	localObject9	Object
    //   437	1092	11	localObject10	Object
    //   453	49	12	k	int
    //   1154	20	13	l	long
    // Exception table:
    //   from	to	target	type
    //   763	776	795	finally
    //   776	779	795	finally
    //   796	799	795	finally
    //   957	970	989	finally
    //   970	973	989	finally
    //   990	993	989	finally
    //   867	880	995	java/lang/Exception
    //   55	62	1636	java/io/InterruptedIOException
    //   37	50	1686	java/lang/Exception
    //   55	62	1686	java/lang/Exception
    //   62	73	1686	java/lang/Exception
    //   78	104	1686	java/lang/Exception
    //   115	157	1686	java/lang/Exception
    //   260	302	1686	java/lang/Exception
    //   302	324	1686	java/lang/Exception
    //   334	339	1686	java/lang/Exception
    //   345	367	1686	java/lang/Exception
    //   377	382	1686	java/lang/Exception
    //   388	422	1686	java/lang/Exception
    //   431	439	1686	java/lang/Exception
    //   455	479	1686	java/lang/Exception
    //   495	521	1686	java/lang/Exception
    //   527	550	1686	java/lang/Exception
    //   558	563	1686	java/lang/Exception
    //   569	592	1686	java/lang/Exception
    //   600	605	1686	java/lang/Exception
    //   611	649	1686	java/lang/Exception
    //   673	686	1686	java/lang/Exception
    //   692	705	1686	java/lang/Exception
    //   708	763	1686	java/lang/Exception
    //   779	789	1686	java/lang/Exception
    //   799	801	1686	java/lang/Exception
    //   801	839	1686	java/lang/Exception
    //   886	899	1686	java/lang/Exception
    //   902	957	1686	java/lang/Exception
    //   973	983	1686	java/lang/Exception
    //   993	995	1686	java/lang/Exception
    //   1007	1029	1686	java/lang/Exception
    //   1039	1048	1686	java/lang/Exception
    //   1054	1077	1686	java/lang/Exception
    //   1085	1113	1686	java/lang/Exception
    //   1119	1163	1686	java/lang/Exception
    //   1171	1198	1686	java/lang/Exception
    //   1204	1252	1686	java/lang/Exception
    //   1252	1269	1686	java/lang/Exception
    //   1269	1317	1686	java/lang/Exception
    //   1323	1420	1686	java/lang/Exception
    //   1425	1432	1686	java/lang/Exception
    //   1432	1437	1686	java/lang/Exception
    //   1443	1452	1686	java/lang/Exception
    //   1460	1465	1686	java/lang/Exception
    //   1481	1487	1686	java/lang/Exception
    //   1494	1528	1686	java/lang/Exception
    //   1528	1533	1686	java/lang/Exception
    //   1539	1565	1686	java/lang/Exception
    //   1582	1598	1686	java/lang/Exception
    //   1604	1616	1686	java/lang/Exception
    //   1622	1630	1686	java/lang/Exception
    //   1638	1658	1686	java/lang/Exception
    //   1664	1680	1686	java/lang/Exception
    //   1683	1686	1686	java/lang/Exception
    //   996	1001	1760	java/lang/Exception
    //   1750	1754	1767	java/lang/NullPointerException
    //   1750	1754	1767	java/lang/Exception
  }
  
  public void sendIgnore()
    throws Exception
  {
    Buffer localBuffer = new Buffer();
    Packet localPacket = new Packet(localBuffer);
    localPacket.reset();
    localBuffer.putByte((byte)2);
    write(localPacket);
  }
  
  public void sendKeepAliveMsg()
    throws Exception
  {
    Buffer localBuffer = new Buffer();
    Packet localPacket = new Packet(localBuffer);
    localPacket.reset();
    localBuffer.putByte((byte)80);
    localBuffer.putString(keepalivemsg);
    localBuffer.putByte((byte)1);
    write(localPacket);
  }
  
  public void setClientVersion(String paramString)
  {
    this.V_C = Util.str2byte(paramString);
  }
  
  public void setConfig(String paramString1, String paramString2)
  {
    synchronized (this.lock)
    {
      if (this.config == null)
      {
        Hashtable localHashtable = new java/util/Hashtable;
        localHashtable.<init>();
        this.config = localHashtable;
      }
      this.config.put(paramString1, paramString2);
      return;
    }
  }
  
  public void setConfig(Hashtable paramHashtable)
  {
    synchronized (this.lock)
    {
      Object localObject2;
      if (this.config == null)
      {
        localObject2 = new java/util/Hashtable;
        ((Hashtable)localObject2).<init>();
        this.config = ((Hashtable)localObject2);
      }
      Enumeration localEnumeration = paramHashtable.keys();
      while (localEnumeration.hasMoreElements())
      {
        localObject2 = (String)localEnumeration.nextElement();
        this.config.put(localObject2, (String)paramHashtable.get(localObject2));
      }
      return;
    }
  }
  
  public void setConfig(Properties paramProperties)
  {
    setConfig(paramProperties);
  }
  
  public void setDaemonThread(boolean paramBoolean)
  {
    this.daemon_thread = paramBoolean;
  }
  
  public void setHost(String paramString)
  {
    this.host = paramString;
  }
  
  public void setHostKeyAlias(String paramString)
  {
    this.hostKeyAlias = paramString;
  }
  
  public void setHostKeyRepository(HostKeyRepository paramHostKeyRepository)
  {
    this.hostkeyRepository = paramHostKeyRepository;
  }
  
  public void setIdentityRepository(IdentityRepository paramIdentityRepository)
  {
    this.identityRepository = paramIdentityRepository;
  }
  
  public void setInputStream(InputStream paramInputStream)
  {
    this.in = paramInputStream;
  }
  
  public void setOutputStream(OutputStream paramOutputStream)
  {
    this.out = paramOutputStream;
  }
  
  public void setPassword(String paramString)
  {
    if (paramString != null) {
      this.password = Util.str2byte(paramString);
    }
  }
  
  public void setPassword(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      this.password = arrayOfByte;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    }
  }
  
  public void setPort(int paramInt)
  {
    this.port = paramInt;
  }
  
  public int setPortForwardingL(int paramInt1, String paramString, int paramInt2)
    throws JSchException
  {
    return setPortForwardingL("127.0.0.1", paramInt1, paramString, paramInt2);
  }
  
  public int setPortForwardingL(String paramString)
    throws JSchException
  {
    paramString = parseForwarding(paramString);
    return setPortForwardingL(paramString.bind_address, paramString.port, paramString.host, paramString.hostport);
  }
  
  public int setPortForwardingL(String paramString1, int paramInt1, String paramString2, int paramInt2)
    throws JSchException
  {
    return setPortForwardingL(paramString1, paramInt1, paramString2, paramInt2, null);
  }
  
  public int setPortForwardingL(String paramString1, int paramInt1, String paramString2, int paramInt2, ServerSocketFactory paramServerSocketFactory)
    throws JSchException
  {
    return setPortForwardingL(paramString1, paramInt1, paramString2, paramInt2, paramServerSocketFactory, 0);
  }
  
  public int setPortForwardingL(String paramString1, int paramInt1, String paramString2, int paramInt2, ServerSocketFactory paramServerSocketFactory, int paramInt3)
    throws JSchException
  {
    paramServerSocketFactory = PortWatcher.addPort(this, paramString1, paramInt1, paramString2, paramInt2, paramServerSocketFactory);
    paramServerSocketFactory.setConnectTimeout(paramInt3);
    paramString1 = new Thread(paramServerSocketFactory);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PortWatcher Thread for ");
    localStringBuilder.append(paramString2);
    paramString1.setName(localStringBuilder.toString());
    boolean bool = this.daemon_thread;
    if (bool) {
      paramString1.setDaemon(bool);
    }
    paramString1.start();
    return paramServerSocketFactory.lport;
  }
  
  public int setPortForwardingR(String paramString)
    throws JSchException
  {
    paramString = parseForwarding(paramString);
    int i = _setPortForwardingR(paramString.bind_address, paramString.port);
    ChannelForwardedTCPIP.addPort(this, paramString.bind_address, paramString.port, i, paramString.host, paramString.hostport, null);
    return i;
  }
  
  public void setPortForwardingR(int paramInt, String paramString)
    throws JSchException
  {
    setPortForwardingR(null, paramInt, paramString, null);
  }
  
  public void setPortForwardingR(int paramInt1, String paramString, int paramInt2)
    throws JSchException
  {
    setPortForwardingR(null, paramInt1, paramString, paramInt2, null);
  }
  
  public void setPortForwardingR(int paramInt1, String paramString, int paramInt2, SocketFactory paramSocketFactory)
    throws JSchException
  {
    setPortForwardingR(null, paramInt1, paramString, paramInt2, paramSocketFactory);
  }
  
  public void setPortForwardingR(int paramInt, String paramString, Object[] paramArrayOfObject)
    throws JSchException
  {
    setPortForwardingR(null, paramInt, paramString, paramArrayOfObject);
  }
  
  public void setPortForwardingR(String paramString1, int paramInt1, String paramString2, int paramInt2)
    throws JSchException
  {
    setPortForwardingR(paramString1, paramInt1, paramString2, paramInt2, null);
  }
  
  public void setPortForwardingR(String paramString1, int paramInt1, String paramString2, int paramInt2, SocketFactory paramSocketFactory)
    throws JSchException
  {
    ChannelForwardedTCPIP.addPort(this, paramString1, paramInt1, _setPortForwardingR(paramString1, paramInt1), paramString2, paramInt2, paramSocketFactory);
  }
  
  public void setPortForwardingR(String paramString1, int paramInt, String paramString2, Object[] paramArrayOfObject)
    throws JSchException
  {
    ChannelForwardedTCPIP.addPort(this, paramString1, paramInt, _setPortForwardingR(paramString1, paramInt), paramString2, paramArrayOfObject);
  }
  
  public void setProxy(Proxy paramProxy)
  {
    this.proxy = paramProxy;
  }
  
  public void setServerAliveCountMax(int paramInt)
  {
    this.serverAliveCountMax = paramInt;
  }
  
  public void setServerAliveInterval(int paramInt)
    throws JSchException
  {
    setTimeout(paramInt);
    this.serverAliveInterval = paramInt;
  }
  
  public void setSocketFactory(SocketFactory paramSocketFactory)
  {
    this.socket_factory = paramSocketFactory;
  }
  
  public void setTimeout(int paramInt)
    throws JSchException
  {
    Socket localSocket = this.socket;
    if (localSocket == null)
    {
      if (paramInt >= 0)
      {
        this.timeout = paramInt;
        return;
      }
      throw new JSchException("invalid timeout value");
    }
    try
    {
      localSocket.setSoTimeout(paramInt);
      this.timeout = paramInt;
      return;
    }
    catch (Exception localException)
    {
      throw new JSchException(localException.toString(), localException);
    }
  }
  
  public void setUserInfo(UserInfo paramUserInfo)
  {
    this.userinfo = paramUserInfo;
  }
  
  void setUserName(String paramString)
  {
    this.username = paramString;
  }
  
  public void setX11Cookie(String paramString)
  {
    ChannelX11.setCookie(paramString);
  }
  
  public void setX11Host(String paramString)
  {
    ChannelX11.setHost(paramString);
  }
  
  public void setX11Port(int paramInt)
  {
    ChannelX11.setPort(paramInt);
  }
  
  public void write(Packet paramPacket)
    throws Exception
  {
    long l = getTimeout();
    while (this.in_kex)
    {
      if ((l > 0L) && (System.currentTimeMillis() - this.kex_start_time > l) && (!this.in_prompt)) {
        throw new JSchException("timeout in waiting for rekeying process.");
      }
      int i = paramPacket.buffer.getCommand();
      if ((i == 20) || (i == 21) || (i == 30) || (i == 31) || (i == 31) || (i == 32) || (i == 33) || (i == 34) || (i == 1)) {
        break;
      }
      try
      {
        Thread.sleep(10L);
      }
      catch (InterruptedException localInterruptedException) {}
    }
    _write(paramPacket);
  }
  
  /* Error */
  void write(Packet paramPacket, Channel paramChannel, int paramInt)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1599	com/jcraft/jsch/Session:getTimeout	()I
    //   4: i2l
    //   5: lstore 4
    //   7: aload_0
    //   8: getfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   11: ifeq +52 -> 63
    //   14: lload 4
    //   16: lconst_0
    //   17: lcmp
    //   18: ifle +31 -> 49
    //   21: invokestatic 969	java/lang/System:currentTimeMillis	()J
    //   24: aload_0
    //   25: getfield 242	com/jcraft/jsch/Session:kex_start_time	J
    //   28: lsub
    //   29: lload 4
    //   31: lcmp
    //   32: ifgt +6 -> 38
    //   35: goto +14 -> 49
    //   38: new 190	com/jcraft/jsch/JSchException
    //   41: dup
    //   42: ldc_w 1601
    //   45: invokespecial 315	com/jcraft/jsch/JSchException:<init>	(Ljava/lang/String;)V
    //   48: athrow
    //   49: ldc2_w 1602
    //   52: invokestatic 372	java/lang/Thread:sleep	(J)V
    //   55: goto -48 -> 7
    //   58: astore 6
    //   60: goto -53 -> 7
    //   63: aload_2
    //   64: monitorenter
    //   65: aload_2
    //   66: getfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   69: lstore 7
    //   71: iload_3
    //   72: i2l
    //   73: lstore 9
    //   75: iconst_1
    //   76: istore 11
    //   78: lload 7
    //   80: lload 9
    //   82: lcmp
    //   83: ifge +61 -> 144
    //   86: aload_2
    //   87: aload_2
    //   88: getfield 1612	com/jcraft/jsch/Channel:notifyme	I
    //   91: iconst_1
    //   92: iadd
    //   93: putfield 1612	com/jcraft/jsch/Channel:notifyme	I
    //   96: aload_2
    //   97: ldc2_w 1613
    //   100: invokevirtual 1617	java/lang/Object:wait	(J)V
    //   103: aload_2
    //   104: getfield 1612	com/jcraft/jsch/Channel:notifyme	I
    //   107: istore 12
    //   109: aload_2
    //   110: iload 12
    //   112: iconst_1
    //   113: isub
    //   114: putfield 1612	com/jcraft/jsch/Channel:notifyme	I
    //   117: goto +27 -> 144
    //   120: astore_1
    //   121: aload_2
    //   122: aload_2
    //   123: getfield 1612	com/jcraft/jsch/Channel:notifyme	I
    //   126: iconst_1
    //   127: isub
    //   128: putfield 1612	com/jcraft/jsch/Channel:notifyme	I
    //   131: aload_1
    //   132: athrow
    //   133: astore 6
    //   135: aload_2
    //   136: getfield 1612	com/jcraft/jsch/Channel:notifyme	I
    //   139: istore 12
    //   141: goto -32 -> 109
    //   144: aload_0
    //   145: getfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   148: ifeq +8 -> 156
    //   151: aload_2
    //   152: monitorexit
    //   153: goto -146 -> 7
    //   156: aload_2
    //   157: getfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   160: lload 9
    //   162: lcmp
    //   163: iflt +19 -> 182
    //   166: aload_2
    //   167: aload_2
    //   168: getfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   171: lload 9
    //   173: lsub
    //   174: putfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   177: aload_2
    //   178: monitorexit
    //   179: goto +271 -> 450
    //   182: aload_2
    //   183: monitorexit
    //   184: aload_2
    //   185: getfield 1467	com/jcraft/jsch/Channel:close	Z
    //   188: ifne +286 -> 474
    //   191: aload_2
    //   192: invokevirtual 1619	com/jcraft/jsch/Channel:isConnected	()Z
    //   195: ifeq +279 -> 474
    //   198: iconst_m1
    //   199: istore 13
    //   201: aload_2
    //   202: monitorenter
    //   203: aload_2
    //   204: getfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   207: lstore 7
    //   209: iconst_0
    //   210: istore 14
    //   212: iconst_0
    //   213: istore 15
    //   215: iconst_0
    //   216: istore 12
    //   218: lload 7
    //   220: lconst_0
    //   221: lcmp
    //   222: ifle +130 -> 352
    //   225: aload_2
    //   226: getfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   229: lstore 16
    //   231: lload 16
    //   233: lstore 7
    //   235: lload 16
    //   237: lload 9
    //   239: lcmp
    //   240: ifle +7 -> 247
    //   243: lload 9
    //   245: lstore 7
    //   247: iload 14
    //   249: istore_3
    //   250: lload 7
    //   252: lload 9
    //   254: lcmp
    //   255: ifeq +56 -> 311
    //   258: lload 7
    //   260: l2i
    //   261: istore 14
    //   263: aload_0
    //   264: getfield 1051	com/jcraft/jsch/Session:c2scipher	Lcom/jcraft/jsch/Cipher;
    //   267: ifnull +11 -> 278
    //   270: aload_0
    //   271: getfield 270	com/jcraft/jsch/Session:c2scipher_size	I
    //   274: istore_3
    //   275: goto +6 -> 281
    //   278: bipush 8
    //   280: istore_3
    //   281: aload_0
    //   282: getfield 1053	com/jcraft/jsch/Session:c2smac	Lcom/jcraft/jsch/MAC;
    //   285: astore 6
    //   287: aload 6
    //   289: ifnull +12 -> 301
    //   292: aload 6
    //   294: invokeinterface 1041 1 0
    //   299: istore 12
    //   301: aload_1
    //   302: iload 14
    //   304: iload_3
    //   305: iload 12
    //   307: invokevirtual 1623	com/jcraft/jsch/Packet:shift	(III)I
    //   310: istore_3
    //   311: aload_1
    //   312: getfield 1317	com/jcraft/jsch/Packet:buffer	Lcom/jcraft/jsch/Buffer;
    //   315: invokevirtual 1156	com/jcraft/jsch/Buffer:getCommand	()B
    //   318: istore 13
    //   320: aload_2
    //   321: invokevirtual 1446	com/jcraft/jsch/Channel:getRecipient	()I
    //   324: istore 12
    //   326: lload 9
    //   328: lload 7
    //   330: lsub
    //   331: l2i
    //   332: istore 14
    //   334: aload_2
    //   335: aload_2
    //   336: getfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   339: lload 7
    //   341: lsub
    //   342: putfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   345: iload 13
    //   347: istore 18
    //   349: goto +23 -> 372
    //   352: iconst_0
    //   353: istore 11
    //   355: iconst_0
    //   356: istore 19
    //   358: iload_3
    //   359: istore 14
    //   361: iload 15
    //   363: istore 18
    //   365: iload 13
    //   367: istore 12
    //   369: iload 19
    //   371: istore_3
    //   372: aload_2
    //   373: monitorexit
    //   374: iload 11
    //   376: ifeq +25 -> 401
    //   379: aload_0
    //   380: aload_1
    //   381: invokespecial 1605	com/jcraft/jsch/Session:_write	(Lcom/jcraft/jsch/Packet;)V
    //   384: iload 14
    //   386: ifne +4 -> 390
    //   389: return
    //   390: aload_1
    //   391: iload 18
    //   393: iload 12
    //   395: iload_3
    //   396: iload 14
    //   398: invokevirtual 1627	com/jcraft/jsch/Packet:unshift	(BIII)V
    //   401: aload_2
    //   402: monitorenter
    //   403: aload_0
    //   404: getfield 260	com/jcraft/jsch/Session:in_kex	Z
    //   407: ifeq +11 -> 418
    //   410: aload_2
    //   411: monitorexit
    //   412: iload 14
    //   414: istore_3
    //   415: goto -408 -> 7
    //   418: aload_2
    //   419: getfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   422: lstore 9
    //   424: iload 14
    //   426: i2l
    //   427: lstore 7
    //   429: lload 9
    //   431: lload 7
    //   433: lcmp
    //   434: iflt +22 -> 456
    //   437: aload_2
    //   438: aload_2
    //   439: getfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   442: lload 7
    //   444: lsub
    //   445: putfield 1609	com/jcraft/jsch/Channel:rwsize	J
    //   448: aload_2
    //   449: monitorexit
    //   450: aload_0
    //   451: aload_1
    //   452: invokespecial 1605	com/jcraft/jsch/Session:_write	(Lcom/jcraft/jsch/Packet;)V
    //   455: return
    //   456: aload_2
    //   457: monitorexit
    //   458: iload 14
    //   460: istore_3
    //   461: goto -454 -> 7
    //   464: astore_1
    //   465: aload_2
    //   466: monitorexit
    //   467: aload_1
    //   468: athrow
    //   469: astore_1
    //   470: aload_2
    //   471: monitorexit
    //   472: aload_1
    //   473: athrow
    //   474: new 997	java/io/IOException
    //   477: dup
    //   478: ldc_w 1629
    //   481: invokespecial 1391	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   484: athrow
    //   485: astore_1
    //   486: aload_2
    //   487: monitorexit
    //   488: aload_1
    //   489: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	Session
    //   0	490	1	paramPacket	Packet
    //   0	490	2	paramChannel	Channel
    //   0	490	3	paramInt	int
    //   5	25	4	l1	long
    //   58	1	6	localInterruptedException1	InterruptedException
    //   133	1	6	localInterruptedException2	InterruptedException
    //   285	8	6	localMAC	MAC
    //   69	374	7	l2	long
    //   73	357	9	l3	long
    //   76	299	11	i	int
    //   107	287	12	j	int
    //   199	167	13	k	int
    //   210	249	14	m	int
    //   213	149	15	b1	byte
    //   229	7	16	l4	long
    //   347	45	18	b2	byte
    //   356	14	19	n	int
    // Exception table:
    //   from	to	target	type
    //   49	55	58	java/lang/InterruptedException
    //   86	103	120	finally
    //   86	103	133	java/lang/InterruptedException
    //   403	412	464	finally
    //   418	424	464	finally
    //   437	450	464	finally
    //   456	458	464	finally
    //   465	467	464	finally
    //   203	209	469	finally
    //   225	231	469	finally
    //   263	275	469	finally
    //   281	287	469	finally
    //   292	301	469	finally
    //   301	311	469	finally
    //   311	326	469	finally
    //   334	345	469	finally
    //   372	374	469	finally
    //   470	472	469	finally
    //   65	71	485	finally
    //   103	109	485	finally
    //   109	117	485	finally
    //   121	133	485	finally
    //   135	141	485	finally
    //   144	153	485	finally
    //   156	179	485	finally
    //   182	184	485	finally
    //   486	488	485	finally
  }
  
  private class Forwarding
  {
    String bind_address = null;
    String host = null;
    int hostport = -1;
    int port = -1;
    
    private Forwarding() {}
  }
  
  private class GlobalRequestReply
  {
    private int port = 0;
    private int reply = -1;
    private Thread thread = null;
    
    private GlobalRequestReply() {}
    
    int getPort()
    {
      return this.port;
    }
    
    int getReply()
    {
      return this.reply;
    }
    
    Thread getThread()
    {
      return this.thread;
    }
    
    void setPort(int paramInt)
    {
      this.port = paramInt;
    }
    
    void setReply(int paramInt)
    {
      this.reply = paramInt;
    }
    
    void setThread(Thread paramThread)
    {
      this.thread = paramThread;
      this.reply = -1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Session.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */