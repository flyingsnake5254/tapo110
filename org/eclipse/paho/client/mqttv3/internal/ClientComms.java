package org.eclipse.paho.client.mqttv3.internal;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.BufferedMessage;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttPingSender;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnack;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnect;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttDisconnect;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class ClientComms
{
  public static String BUILD_LEVEL = "L${build.level}";
  private static final byte CLOSED = 4;
  private static final byte CONNECTED = 0;
  private static final byte CONNECTING = 1;
  private static final byte DISCONNECTED = 3;
  private static final byte DISCONNECTING = 2;
  public static String VERSION = "${project.version}";
  private final String CLASS_NAME;
  private CommsCallback callback;
  private IMqttAsyncClient client;
  private ClientState clientState;
  private boolean closePending;
  private final Object conLock;
  private MqttConnectOptions conOptions;
  private byte conState;
  private DisconnectedMessageBuffer disconnectedMessageBuffer;
  private ExecutorService executorService;
  private final Logger log;
  private int networkModuleIndex;
  private NetworkModule[] networkModules;
  private MqttClientPersistence persistence;
  private MqttPingSender pingSender;
  private CommsReceiver receiver;
  private boolean resting;
  private CommsSender sender;
  private boolean stoppingComms;
  private CommsTokenStore tokenStore;
  
  public ClientComms(IMqttAsyncClient paramIMqttAsyncClient, MqttClientPersistence paramMqttClientPersistence, MqttPingSender paramMqttPingSender, ExecutorService paramExecutorService, HighResolutionTimer paramHighResolutionTimer)
    throws MqttException
  {
    Object localObject = ClientComms.class.getName();
    this.CLASS_NAME = ((String)localObject);
    localObject = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", (String)localObject);
    this.log = ((Logger)localObject);
    this.stoppingComms = false;
    this.conState = ((byte)3);
    this.conLock = new Object();
    this.closePending = false;
    this.resting = false;
    this.conState = ((byte)3);
    this.client = paramIMqttAsyncClient;
    this.persistence = paramMqttClientPersistence;
    this.pingSender = paramMqttPingSender;
    paramMqttPingSender.init(this);
    this.executorService = paramExecutorService;
    this.tokenStore = new CommsTokenStore(getClient().getClientId());
    this.callback = new CommsCallback(this);
    paramIMqttAsyncClient = new ClientState(paramMqttClientPersistence, this.tokenStore, this.callback, this, paramMqttPingSender, paramHighResolutionTimer);
    this.clientState = paramIMqttAsyncClient;
    this.callback.setClientState(paramIMqttAsyncClient);
    ((Logger)localObject).setResourceName(getClient().getClientId());
  }
  
  private MqttToken handleOldTokens(MqttToken paramMqttToken, MqttException paramMqttException)
  {
    this.log.fine(this.CLASS_NAME, "handleOldTokens", "222");
    Enumeration localEnumeration = null;
    Object localObject1 = null;
    if (paramMqttToken != null) {
      localObject2 = localEnumeration;
    }
    try
    {
      if (!paramMqttToken.isComplete())
      {
        localObject2 = localEnumeration;
        if (this.tokenStore.getToken(paramMqttToken.internalTok.getKey()) == null)
        {
          localObject2 = localEnumeration;
          this.tokenStore.saveToken(paramMqttToken, paramMqttToken.internalTok.getKey());
        }
      }
      localObject2 = localEnumeration;
      localEnumeration = this.clientState.resolveOldTokens(paramMqttException).elements();
      paramMqttToken = (MqttToken)localObject1;
      for (;;)
      {
        localObject2 = paramMqttToken;
        if (!localEnumeration.hasMoreElements()) {
          break;
        }
        localObject2 = paramMqttToken;
        paramMqttException = (MqttToken)localEnumeration.nextElement();
        localObject2 = paramMqttToken;
        if (!paramMqttException.internalTok.getKey().equals("Disc"))
        {
          localObject2 = paramMqttToken;
          if (!paramMqttException.internalTok.getKey().equals("Con"))
          {
            localObject2 = paramMqttToken;
            this.callback.asyncOperationComplete(paramMqttException);
            continue;
          }
        }
        paramMqttToken = paramMqttException;
      }
    }
    catch (Exception paramMqttToken)
    {
      for (;;)
      {
        paramMqttToken = (MqttToken)localObject2;
      }
    }
    return paramMqttToken;
  }
  
  private void handleRunException(Exception paramException)
  {
    this.log.fine(this.CLASS_NAME, "handleRunException", "804", null, paramException);
    if (!(paramException instanceof MqttException)) {
      paramException = new MqttException(32109, paramException);
    } else {
      paramException = (MqttException)paramException;
    }
    shutdownConnection(null, paramException);
  }
  
  private void shutdownExecutorService()
  {
    this.executorService.shutdown();
    try
    {
      ExecutorService localExecutorService = this.executorService;
      if (localExecutorService != null)
      {
        Object localObject = this.conOptions;
        if (localObject != null)
        {
          long l = ((MqttConnectOptions)localObject).getExecutorServiceTimeout();
          localObject = TimeUnit.SECONDS;
          if (!localExecutorService.awaitTermination(l, (TimeUnit)localObject))
          {
            this.executorService.shutdownNow();
            if (!this.executorService.awaitTermination(this.conOptions.getExecutorServiceTimeout(), (TimeUnit)localObject)) {
              this.log.fine(this.CLASS_NAME, "shutdownExecutorService", "executorService did not terminate");
            }
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      this.executorService.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }
  
  public MqttToken checkForActivity()
  {
    return checkForActivity(null);
  }
  
  public MqttToken checkForActivity(IMqttActionListener paramIMqttActionListener)
  {
    try
    {
      paramIMqttActionListener = this.clientState.checkForActivity(paramIMqttActionListener);
    }
    catch (Exception paramIMqttActionListener)
    {
      handleRunException(paramIMqttActionListener);
    }
    catch (MqttException paramIMqttActionListener)
    {
      handleRunException(paramIMqttActionListener);
    }
    paramIMqttActionListener = null;
    return paramIMqttActionListener;
  }
  
  public void close(boolean paramBoolean)
    throws MqttException
  {
    synchronized (this.conLock)
    {
      if (!isClosed())
      {
        if ((!isDisconnected()) || (paramBoolean))
        {
          this.log.fine(this.CLASS_NAME, "close", "224");
          if (isConnecting()) {
            break label141;
          }
          if (isConnected()) {
            break label134;
          }
          if (isDisconnecting())
          {
            this.closePending = true;
            return;
          }
        }
        this.conState = ((byte)4);
        this.clientState.close();
        this.clientState = null;
        this.callback = null;
        this.persistence = null;
        this.sender = null;
        this.pingSender = null;
        this.receiver = null;
        this.networkModules = null;
        this.conOptions = null;
        this.tokenStore = null;
        break label154;
        label134:
        throw ExceptionHelper.createMqttException(32100);
        label141:
        MqttException localMqttException = new org/eclipse/paho/client/mqttv3/MqttException;
        localMqttException.<init>(32110);
        throw localMqttException;
      }
      label154:
      return;
    }
  }
  
  public void connect(MqttConnectOptions paramMqttConnectOptions, MqttToken paramMqttToken)
    throws MqttException
  {
    synchronized (this.conLock)
    {
      if ((isDisconnected()) && (!this.closePending))
      {
        this.log.fine(this.CLASS_NAME, "connect", "214");
        this.conState = ((byte)1);
        this.conOptions = paramMqttConnectOptions;
        paramMqttConnectOptions = new org/eclipse/paho/client/mqttv3/internal/wire/MqttConnect;
        paramMqttConnectOptions.<init>(this.client.getClientId(), this.conOptions.getMqttVersion(), this.conOptions.isCleanSession(), this.conOptions.getKeepAliveInterval(), this.conOptions.getUserName(), this.conOptions.getPassword(), this.conOptions.getWillMessage(), this.conOptions.getWillDestination());
        this.clientState.setKeepAliveSecs(this.conOptions.getKeepAliveInterval());
        this.clientState.setCleanSession(this.conOptions.isCleanSession());
        this.clientState.setMaxInflight(this.conOptions.getMaxInflight());
        this.tokenStore.open();
        ConnectBG localConnectBG = new org/eclipse/paho/client/mqttv3/internal/ClientComms$ConnectBG;
        localConnectBG.<init>(this, this, paramMqttToken, paramMqttConnectOptions, this.executorService);
        localConnectBG.start();
        return;
      }
      this.log.fine(this.CLASS_NAME, "connect", "207", new Object[] { Byte.valueOf(this.conState) });
      if ((!isClosed()) && (!this.closePending))
      {
        if (!isConnecting())
        {
          if (isDisconnecting())
          {
            paramMqttConnectOptions = new org/eclipse/paho/client/mqttv3/MqttException;
            paramMqttConnectOptions.<init>(32102);
            throw paramMqttConnectOptions;
          }
          throw ExceptionHelper.createMqttException(32100);
        }
        paramMqttConnectOptions = new org/eclipse/paho/client/mqttv3/MqttException;
        paramMqttConnectOptions.<init>(32110);
        throw paramMqttConnectOptions;
      }
      paramMqttConnectOptions = new org/eclipse/paho/client/mqttv3/MqttException;
      paramMqttConnectOptions.<init>(32111);
      throw paramMqttConnectOptions;
    }
  }
  
  public void connectComplete(MqttConnack paramMqttConnack, MqttException paramMqttException)
    throws MqttException
  {
    int i = paramMqttConnack.getReturnCode();
    paramMqttConnack = this.conLock;
    if (i == 0) {}
    try
    {
      this.log.fine(this.CLASS_NAME, "connectComplete", "215");
      this.conState = ((byte)0);
      return;
    }
    finally {}
    this.log.fine(this.CLASS_NAME, "connectComplete", "204", new Object[] { Integer.valueOf(i) });
    throw paramMqttException;
  }
  
  public void deleteBufferedMessage(int paramInt)
  {
    this.disconnectedMessageBuffer.deleteMessage(paramInt);
  }
  
  protected void deliveryComplete(int paramInt)
    throws MqttPersistenceException
  {
    this.clientState.deliveryComplete(paramInt);
  }
  
  protected void deliveryComplete(MqttPublish paramMqttPublish)
    throws MqttPersistenceException
  {
    this.clientState.deliveryComplete(paramMqttPublish);
  }
  
  public void disconnect(MqttDisconnect paramMqttDisconnect, long paramLong, MqttToken paramMqttToken)
    throws MqttException
  {
    synchronized (this.conLock)
    {
      if (!isClosed())
      {
        if (!isDisconnected())
        {
          if (!isDisconnecting())
          {
            if (Thread.currentThread() != this.callback.getThread())
            {
              this.log.fine(this.CLASS_NAME, "disconnect", "218");
              this.conState = ((byte)2);
              DisconnectBG localDisconnectBG = new org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG;
              localDisconnectBG.<init>(this, paramMqttDisconnect, paramLong, paramMqttToken, this.executorService);
              localDisconnectBG.start();
              return;
            }
            this.log.fine(this.CLASS_NAME, "disconnect", "210");
            throw ExceptionHelper.createMqttException(32107);
          }
          this.log.fine(this.CLASS_NAME, "disconnect", "219");
          throw ExceptionHelper.createMqttException(32102);
        }
        this.log.fine(this.CLASS_NAME, "disconnect", "211");
        throw ExceptionHelper.createMqttException(32101);
      }
      this.log.fine(this.CLASS_NAME, "disconnect", "223");
      throw ExceptionHelper.createMqttException(32111);
    }
  }
  
  public void disconnectForcibly(long paramLong1, long paramLong2)
    throws MqttException
  {
    disconnectForcibly(paramLong1, paramLong2, true);
  }
  
  /* Error */
  public void disconnectForcibly(long paramLong1, long paramLong2, boolean paramBoolean)
    throws MqttException
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_2
    //   2: i2b
    //   3: putfield 101	org/eclipse/paho/client/mqttv3/internal/ClientComms:conState	B
    //   6: aload_0
    //   7: getfield 150	org/eclipse/paho/client/mqttv3/internal/ClientComms:clientState	Lorg/eclipse/paho/client/mqttv3/internal/ClientState;
    //   10: astore 6
    //   12: aload 6
    //   14: ifnull +9 -> 23
    //   17: aload 6
    //   19: lload_1
    //   20: invokevirtual 484	org/eclipse/paho/client/mqttv3/internal/ClientState:quiesce	(J)V
    //   23: new 209	org/eclipse/paho/client/mqttv3/MqttToken
    //   26: dup
    //   27: aload_0
    //   28: getfield 109	org/eclipse/paho/client/mqttv3/internal/ClientComms:client	Lorg/eclipse/paho/client/mqttv3/IMqttAsyncClient;
    //   31: invokeinterface 132 1 0
    //   36: invokespecial 485	org/eclipse/paho/client/mqttv3/MqttToken:<init>	(Ljava/lang/String;)V
    //   39: astore 6
    //   41: iload 5
    //   43: ifeq +52 -> 95
    //   46: new 487	org/eclipse/paho/client/mqttv3/internal/wire/MqttDisconnect
    //   49: astore 7
    //   51: aload 7
    //   53: invokespecial 488	org/eclipse/paho/client/mqttv3/internal/wire/MqttDisconnect:<init>	()V
    //   56: aload_0
    //   57: aload 7
    //   59: aload 6
    //   61: invokevirtual 492	org/eclipse/paho/client/mqttv3/internal/ClientComms:internalSend	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/eclipse/paho/client/mqttv3/MqttToken;)V
    //   64: aload 6
    //   66: lload_3
    //   67: invokevirtual 495	org/eclipse/paho/client/mqttv3/MqttToken:waitForCompletion	(J)V
    //   70: goto +25 -> 95
    //   73: astore 7
    //   75: aload 6
    //   77: getfield 217	org/eclipse/paho/client/mqttv3/MqttToken:internalTok	Lorg/eclipse/paho/client/mqttv3/internal/Token;
    //   80: aconst_null
    //   81: aconst_null
    //   82: invokevirtual 499	org/eclipse/paho/client/mqttv3/internal/Token:markComplete	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
    //   85: aload_0
    //   86: aload 6
    //   88: aconst_null
    //   89: invokevirtual 278	org/eclipse/paho/client/mqttv3/internal/ClientComms:shutdownConnection	(Lorg/eclipse/paho/client/mqttv3/MqttToken;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
    //   92: aload 7
    //   94: athrow
    //   95: aload 6
    //   97: getfield 217	org/eclipse/paho/client/mqttv3/MqttToken:internalTok	Lorg/eclipse/paho/client/mqttv3/internal/Token;
    //   100: aconst_null
    //   101: aconst_null
    //   102: invokevirtual 499	org/eclipse/paho/client/mqttv3/internal/Token:markComplete	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
    //   105: aload_0
    //   106: aload 6
    //   108: aconst_null
    //   109: invokevirtual 278	org/eclipse/paho/client/mqttv3/internal/ClientComms:shutdownConnection	(Lorg/eclipse/paho/client/mqttv3/MqttToken;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
    //   112: return
    //   113: astore 7
    //   115: goto -20 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	ClientComms
    //   0	118	1	paramLong1	long
    //   0	118	3	paramLong2	long
    //   0	118	5	paramBoolean	boolean
    //   10	97	6	localObject1	Object
    //   49	9	7	localMqttDisconnect	MqttDisconnect
    //   73	20	7	localObject2	Object
    //   113	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   46	70	73	finally
    //   46	70	113	java/lang/Exception
  }
  
  public int getActualInFlight()
  {
    return this.clientState.getActualInFlight();
  }
  
  public MqttMessage getBufferedMessage(int paramInt)
  {
    return ((MqttPublish)this.disconnectedMessageBuffer.getMessage(paramInt).getMessage()).getMessage();
  }
  
  public int getBufferedMessageCount()
  {
    return this.disconnectedMessageBuffer.getMessageCount();
  }
  
  public IMqttAsyncClient getClient()
  {
    return this.client;
  }
  
  public ClientState getClientState()
  {
    return this.clientState;
  }
  
  public MqttConnectOptions getConOptions()
  {
    return this.conOptions;
  }
  
  public Properties getDebug()
  {
    Properties localProperties = new Properties();
    localProperties.put("conState", Integer.valueOf(this.conState));
    localProperties.put("serverURI", getClient().getServerURI());
    localProperties.put("callback", this.callback);
    localProperties.put("stoppingComms", Boolean.valueOf(this.stoppingComms));
    return localProperties;
  }
  
  public long getKeepAlive()
  {
    return this.clientState.getKeepAlive();
  }
  
  public int getNetworkModuleIndex()
  {
    return this.networkModuleIndex;
  }
  
  public NetworkModule[] getNetworkModules()
  {
    return this.networkModules;
  }
  
  public MqttDeliveryToken[] getPendingDeliveryTokens()
  {
    return this.tokenStore.getOutstandingDelTokens();
  }
  
  CommsReceiver getReceiver()
  {
    return this.receiver;
  }
  
  protected MqttTopic getTopic(String paramString)
  {
    return new MqttTopic(paramString, this);
  }
  
  void internalSend(MqttWireMessage paramMqttWireMessage, MqttToken paramMqttToken)
    throws MqttException
  {
    this.log.fine(this.CLASS_NAME, "internalSend", "200", new Object[] { paramMqttWireMessage.getKey(), paramMqttWireMessage, paramMqttToken });
    if (paramMqttToken.getClient() == null)
    {
      paramMqttToken.internalTok.setClient(getClient());
      try
      {
        this.clientState.send(paramMqttWireMessage, paramMqttToken);
        return;
      }
      catch (MqttException localMqttException)
      {
        paramMqttToken.internalTok.setClient(null);
        if ((paramMqttWireMessage instanceof MqttPublish)) {
          this.clientState.undo((MqttPublish)paramMqttWireMessage);
        }
        throw localMqttException;
      }
    }
    this.log.fine(this.CLASS_NAME, "internalSend", "213", new Object[] { paramMqttWireMessage.getKey(), paramMqttWireMessage, paramMqttToken });
    throw new MqttException(32201);
  }
  
  public boolean isClosed()
  {
    synchronized (this.conLock)
    {
      boolean bool;
      if (this.conState == 4) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean isConnected()
  {
    synchronized (this.conLock)
    {
      boolean bool;
      if (this.conState == 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean isConnecting()
  {
    synchronized (this.conLock)
    {
      int i = this.conState;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean isDisconnected()
  {
    synchronized (this.conLock)
    {
      boolean bool;
      if (this.conState == 3) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean isDisconnecting()
  {
    synchronized (this.conLock)
    {
      boolean bool;
      if (this.conState == 2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean isResting()
  {
    synchronized (this.conLock)
    {
      boolean bool = this.resting;
      return bool;
    }
  }
  
  public void messageArrivedComplete(int paramInt1, int paramInt2)
    throws MqttException
  {
    this.callback.messageArrivedComplete(paramInt1, paramInt2);
  }
  
  public void notifyConnect()
  {
    if (this.disconnectedMessageBuffer != null)
    {
      this.log.fine(this.CLASS_NAME, "notifyConnect", "509", null);
      this.disconnectedMessageBuffer.setPublishCallback(new ReconnectDisconnectedBufferCallback("notifyConnect"));
      this.disconnectedMessageBuffer.setMessageDiscardedCallBack(new MessageDiscardedCallback());
      ExecutorService localExecutorService = this.executorService;
      if (localExecutorService == null) {
        new Thread(this.disconnectedMessageBuffer).start();
      } else {
        localExecutorService.execute(this.disconnectedMessageBuffer);
      }
    }
  }
  
  public boolean removeMessage(IMqttDeliveryToken paramIMqttDeliveryToken)
    throws MqttException
  {
    return this.clientState.removeMessage(paramIMqttDeliveryToken);
  }
  
  public void removeMessageListener(String paramString)
  {
    this.callback.removeMessageListener(paramString);
  }
  
  public void sendNoWait(MqttWireMessage paramMqttWireMessage, MqttToken paramMqttToken)
    throws MqttException
  {
    if ((!isConnected()) && ((isConnected()) || (!(paramMqttWireMessage instanceof MqttConnect))) && ((!isDisconnecting()) || (!(paramMqttWireMessage instanceof MqttDisconnect))))
    {
      if (this.disconnectedMessageBuffer != null)
      {
        this.log.fine(this.CLASS_NAME, "sendNoWait", "508", new Object[] { paramMqttWireMessage.getKey() });
        if (this.disconnectedMessageBuffer.isPersistBuffer()) {
          this.clientState.persistBufferedMessage(paramMqttWireMessage);
        }
        this.disconnectedMessageBuffer.putMessage(paramMqttWireMessage, paramMqttToken);
      }
      else
      {
        this.log.fine(this.CLASS_NAME, "sendNoWait", "208");
        throw ExceptionHelper.createMqttException(32104);
      }
    }
    else
    {
      DisconnectedMessageBuffer localDisconnectedMessageBuffer = this.disconnectedMessageBuffer;
      if ((localDisconnectedMessageBuffer != null) && (localDisconnectedMessageBuffer.getMessageCount() != 0))
      {
        this.log.fine(this.CLASS_NAME, "sendNoWait", "507", new Object[] { paramMqttWireMessage.getKey() });
        if (this.disconnectedMessageBuffer.isPersistBuffer()) {
          this.clientState.persistBufferedMessage(paramMqttWireMessage);
        }
        this.disconnectedMessageBuffer.putMessage(paramMqttWireMessage, paramMqttToken);
      }
      else
      {
        internalSend(paramMqttWireMessage, paramMqttToken);
      }
    }
  }
  
  public void setCallback(MqttCallback paramMqttCallback)
  {
    this.callback.setCallback(paramMqttCallback);
  }
  
  public void setDisconnectedMessageBuffer(DisconnectedMessageBuffer paramDisconnectedMessageBuffer)
  {
    this.disconnectedMessageBuffer = paramDisconnectedMessageBuffer;
  }
  
  public void setManualAcks(boolean paramBoolean)
  {
    this.callback.setManualAcks(paramBoolean);
  }
  
  public void setMessageListener(String paramString, IMqttMessageListener paramIMqttMessageListener)
  {
    this.callback.setMessageListener(paramString, paramIMqttMessageListener);
  }
  
  public void setNetworkModuleIndex(int paramInt)
  {
    this.networkModuleIndex = paramInt;
  }
  
  public void setNetworkModules(NetworkModule[] paramArrayOfNetworkModule)
  {
    this.networkModules = ((NetworkModule[])paramArrayOfNetworkModule.clone());
  }
  
  public void setReconnectCallback(MqttCallbackExtended paramMqttCallbackExtended)
  {
    this.callback.setReconnectCallback(paramMqttCallbackExtended);
  }
  
  public void setRestingState(boolean paramBoolean)
  {
    this.resting = paramBoolean;
  }
  
  public void shutdownConnection(MqttToken arg1, MqttException paramMqttException)
  {
    synchronized (this.conLock)
    {
      if ((!this.stoppingComms) && (!this.closePending) && (!isClosed()))
      {
        this.stoppingComms = true;
        this.log.fine(this.CLASS_NAME, "shutdownConnection", "216");
        if ((!isConnected()) && (!isDisconnecting())) {
          i = 0;
        } else {
          i = 1;
        }
        this.conState = ((byte)2);
        if ((??? != null) && (!???.isComplete())) {
          ???.internalTok.setException(paramMqttException);
        }
        ??? = this.callback;
        if (??? != null) {
          ((CommsCallback)???).stop();
        }
        ??? = this.receiver;
        if (??? != null) {
          ((CommsReceiver)???).stop();
        }
      }
      try
      {
        ??? = this.networkModules;
        if (??? != null)
        {
          ??? = ???[this.networkModuleIndex];
          if (??? != null) {
            ((NetworkModule)???).stop();
          }
        }
      }
      catch (Exception localException3)
      {
        try
        {
          if (this.disconnectedMessageBuffer != null) {
            break label260;
          }
          ??? = this.persistence;
          if (??? == null) {
            break label260;
          }
          ((MqttClientPersistence)???).close();
          synchronized (this.conLock)
          {
            this.log.fine(this.CLASS_NAME, "shutdownConnection", "217");
            this.conState = ((byte)3);
            this.stoppingComms = false;
            if (??? == null) {
              break label317;
            }
            ??? = this.callback;
            if (??? == null) {
              break label317;
            }
            ((CommsCallback)???).asyncOperationComplete(???);
            if (i == 0) {
              break label336;
            }
            ??? = this.callback;
            if (??? == null) {
              break label336;
            }
            ???.connectionLost(paramMqttException);
            synchronized (this.conLock)
            {
              boolean bool = this.closePending;
              if (!bool) {
                break label359;
              }
            }
          }
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              close(true);
              return;
              paramMqttException = finally;
              throw paramMqttException;
              ??? = finally;
              throw ???;
              return;
              ??? = finally;
              throw ???;
              localException2 = localException2;
            }
            localException3 = localException3;
          }
          catch (Exception paramMqttException)
          {
            for (;;) {}
          }
        }
      }
      this.tokenStore.quiesce(new MqttException(32102));
      ??? = handleOldTokens(???, paramMqttException);
      try
      {
        this.clientState.disconnected(paramMqttException);
        if (this.clientState.getCleanSession()) {
          this.callback.removeMessageListeners();
        }
      }
      catch (Exception localException1) {}
      ??? = this.sender;
      if (??? != null) {
        ((CommsSender)???).stop();
      }
      ??? = this.pingSender;
      if (??? != null) {
        ((MqttPingSender)???).stop();
      }
    }
  }
  
  private class ConnectBG
    implements Runnable
  {
    ClientComms clientComms = null;
    MqttConnect conPacket;
    MqttToken conToken;
    private String threadName;
    
    ConnectBG(ClientComms paramClientComms, MqttToken paramMqttToken, MqttConnect paramMqttConnect, ExecutorService paramExecutorService)
    {
      this.clientComms = paramClientComms;
      this.conToken = paramMqttToken;
      this.conPacket = paramMqttConnect;
      paramClientComms = new StringBuilder("MQTT Con: ");
      paramClientComms.append(ClientComms.this.getClient().getClientId());
      this.threadName = paramClientComms.toString();
    }
    
    public void run()
    {
      Thread.currentThread().setName(this.threadName);
      ClientComms.this.log.fine(ClientComms.this.CLASS_NAME, "connectBG:run", "220");
      Object localObject1 = null;
      try
      {
        Object localObject2 = ClientComms.this.tokenStore.getOutstandingDelTokens();
        int i = localObject2.length;
        for (int j = 0;; j++)
        {
          if (j >= i)
          {
            ClientComms.this.tokenStore.saveToken(this.conToken, this.conPacket);
            localObject2 = ClientComms.this.networkModules[ClientComms.this.networkModuleIndex];
            ((NetworkModule)localObject2).start();
            Object localObject3 = ClientComms.this;
            Object localObject4 = new org/eclipse/paho/client/mqttv3/internal/CommsReceiver;
            ((CommsReceiver)localObject4).<init>(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, ((NetworkModule)localObject2).getInputStream());
            ((ClientComms)localObject3).receiver = ((CommsReceiver)localObject4);
            localObject4 = ClientComms.this.receiver;
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>("MQTT Rec: ");
            ((StringBuilder)localObject3).append(ClientComms.this.getClient().getClientId());
            ((CommsReceiver)localObject4).start(((StringBuilder)localObject3).toString(), ClientComms.this.executorService);
            localObject3 = ClientComms.this;
            localObject4 = new org/eclipse/paho/client/mqttv3/internal/CommsSender;
            ((CommsSender)localObject4).<init>(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, ((NetworkModule)localObject2).getOutputStream());
            ((ClientComms)localObject3).sender = ((CommsSender)localObject4);
            localObject2 = ClientComms.this.sender;
            localObject4 = new java/lang/StringBuilder;
            ((StringBuilder)localObject4).<init>("MQTT Snd: ");
            ((StringBuilder)localObject4).append(ClientComms.this.getClient().getClientId());
            ((CommsSender)localObject2).start(((StringBuilder)localObject4).toString(), ClientComms.this.executorService);
            localObject2 = ClientComms.this.callback;
            localObject4 = new java/lang/StringBuilder;
            ((StringBuilder)localObject4).<init>("MQTT Call: ");
            ((StringBuilder)localObject4).append(ClientComms.this.getClient().getClientId());
            ((CommsCallback)localObject2).start(((StringBuilder)localObject4).toString(), ClientComms.this.executorService);
            ClientComms.this.internalSend(this.conPacket, this.conToken);
            break;
          }
          localObject2[j].internalTok.setException(null);
        }
        MqttException localMqttException1;
        if (localMqttException2 == null) {
          return;
        }
      }
      catch (Exception localException)
      {
        ClientComms.this.log.fine(ClientComms.this.CLASS_NAME, "connectBG:run", "209", null, localException);
        localMqttException1 = ExceptionHelper.createMqttException(localException);
      }
      catch (MqttException localMqttException2)
      {
        ClientComms.this.log.fine(ClientComms.this.CLASS_NAME, "connectBG:run", "212", null, localMqttException2);
      }
      ClientComms.this.shutdownConnection(this.conToken, localMqttException2);
    }
    
    void start()
    {
      if (ClientComms.this.executorService == null) {
        new Thread(this).start();
      } else {
        ClientComms.this.executorService.execute(this);
      }
    }
  }
  
  private class DisconnectBG
    implements Runnable
  {
    MqttDisconnect disconnect;
    long quiesceTimeout;
    private String threadName;
    MqttToken token;
    
    DisconnectBG(MqttDisconnect paramMqttDisconnect, long paramLong, MqttToken paramMqttToken, ExecutorService paramExecutorService)
    {
      this.disconnect = paramMqttDisconnect;
      this.quiesceTimeout = paramLong;
      this.token = paramMqttToken;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 42	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   3: aload_0
      //   4: getfield 44	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:threadName	Ljava/lang/String;
      //   7: invokevirtual 48	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   10: aload_0
      //   11: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   14: invokestatic 52	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$1	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Lorg/eclipse/paho/client/mqttv3/logging/Logger;
      //   17: aload_0
      //   18: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   21: invokestatic 56	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$2	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Ljava/lang/String;
      //   24: ldc 58
      //   26: ldc 60
      //   28: invokeinterface 66 4 0
      //   33: aload_0
      //   34: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   37: invokestatic 70	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$6	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Lorg/eclipse/paho/client/mqttv3/internal/ClientState;
      //   40: aload_0
      //   41: getfield 30	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:quiesceTimeout	J
      //   44: invokevirtual 76	org/eclipse/paho/client/mqttv3/internal/ClientState:quiesce	(J)V
      //   47: aload_0
      //   48: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   51: aload_0
      //   52: getfield 28	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:disconnect	Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttDisconnect;
      //   55: aload_0
      //   56: getfield 32	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:token	Lorg/eclipse/paho/client/mqttv3/MqttToken;
      //   59: invokevirtual 80	org/eclipse/paho/client/mqttv3/internal/ClientComms:internalSend	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/eclipse/paho/client/mqttv3/MqttToken;)V
      //   62: aload_0
      //   63: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   66: invokestatic 84	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$10	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Lorg/eclipse/paho/client/mqttv3/internal/CommsSender;
      //   69: ifnull +26 -> 95
      //   72: aload_0
      //   73: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   76: invokestatic 84	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$10	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Lorg/eclipse/paho/client/mqttv3/internal/CommsSender;
      //   79: invokevirtual 90	org/eclipse/paho/client/mqttv3/internal/CommsSender:isRunning	()Z
      //   82: ifeq +13 -> 95
      //   85: aload_0
      //   86: getfield 32	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:token	Lorg/eclipse/paho/client/mqttv3/MqttToken;
      //   89: getfield 96	org/eclipse/paho/client/mqttv3/MqttToken:internalTok	Lorg/eclipse/paho/client/mqttv3/internal/Token;
      //   92: invokevirtual 101	org/eclipse/paho/client/mqttv3/internal/Token:waitUntilSent	()V
      //   95: aload_0
      //   96: getfield 32	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:token	Lorg/eclipse/paho/client/mqttv3/MqttToken;
      //   99: getfield 96	org/eclipse/paho/client/mqttv3/MqttToken:internalTok	Lorg/eclipse/paho/client/mqttv3/internal/Token;
      //   102: aconst_null
      //   103: aconst_null
      //   104: invokevirtual 105	org/eclipse/paho/client/mqttv3/internal/Token:markComplete	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
      //   107: aload_0
      //   108: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   111: invokestatic 84	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$10	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Lorg/eclipse/paho/client/mqttv3/internal/CommsSender;
      //   114: ifnull +115 -> 229
      //   117: aload_0
      //   118: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   121: invokestatic 84	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$10	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Lorg/eclipse/paho/client/mqttv3/internal/CommsSender;
      //   124: invokevirtual 90	org/eclipse/paho/client/mqttv3/internal/CommsSender:isRunning	()Z
      //   127: ifne +112 -> 239
      //   130: goto +99 -> 229
      //   133: astore_1
      //   134: aload_0
      //   135: getfield 32	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:token	Lorg/eclipse/paho/client/mqttv3/MqttToken;
      //   138: getfield 96	org/eclipse/paho/client/mqttv3/MqttToken:internalTok	Lorg/eclipse/paho/client/mqttv3/internal/Token;
      //   141: aconst_null
      //   142: aconst_null
      //   143: invokevirtual 105	org/eclipse/paho/client/mqttv3/internal/Token:markComplete	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
      //   146: aload_0
      //   147: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   150: invokestatic 84	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$10	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Lorg/eclipse/paho/client/mqttv3/internal/CommsSender;
      //   153: ifnull +16 -> 169
      //   156: aload_0
      //   157: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   160: invokestatic 84	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$10	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Lorg/eclipse/paho/client/mqttv3/internal/CommsSender;
      //   163: invokevirtual 90	org/eclipse/paho/client/mqttv3/internal/CommsSender:isRunning	()Z
      //   166: ifne +13 -> 179
      //   169: aload_0
      //   170: getfield 32	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:token	Lorg/eclipse/paho/client/mqttv3/MqttToken;
      //   173: getfield 96	org/eclipse/paho/client/mqttv3/MqttToken:internalTok	Lorg/eclipse/paho/client/mqttv3/internal/Token;
      //   176: invokevirtual 108	org/eclipse/paho/client/mqttv3/internal/Token:notifyComplete	()V
      //   179: aload_0
      //   180: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   183: aload_0
      //   184: getfield 32	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:token	Lorg/eclipse/paho/client/mqttv3/MqttToken;
      //   187: aconst_null
      //   188: invokevirtual 112	org/eclipse/paho/client/mqttv3/internal/ClientComms:shutdownConnection	(Lorg/eclipse/paho/client/mqttv3/MqttToken;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
      //   191: aload_1
      //   192: athrow
      //   193: astore_1
      //   194: aload_0
      //   195: getfield 32	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:token	Lorg/eclipse/paho/client/mqttv3/MqttToken;
      //   198: getfield 96	org/eclipse/paho/client/mqttv3/MqttToken:internalTok	Lorg/eclipse/paho/client/mqttv3/internal/Token;
      //   201: aconst_null
      //   202: aconst_null
      //   203: invokevirtual 105	org/eclipse/paho/client/mqttv3/internal/Token:markComplete	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
      //   206: aload_0
      //   207: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   210: invokestatic 84	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$10	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Lorg/eclipse/paho/client/mqttv3/internal/CommsSender;
      //   213: ifnull +16 -> 229
      //   216: aload_0
      //   217: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   220: invokestatic 84	org/eclipse/paho/client/mqttv3/internal/ClientComms:access$10	(Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;)Lorg/eclipse/paho/client/mqttv3/internal/CommsSender;
      //   223: invokevirtual 90	org/eclipse/paho/client/mqttv3/internal/CommsSender:isRunning	()Z
      //   226: ifne +13 -> 239
      //   229: aload_0
      //   230: getfield 32	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:token	Lorg/eclipse/paho/client/mqttv3/MqttToken;
      //   233: getfield 96	org/eclipse/paho/client/mqttv3/MqttToken:internalTok	Lorg/eclipse/paho/client/mqttv3/internal/Token;
      //   236: invokevirtual 108	org/eclipse/paho/client/mqttv3/internal/Token:notifyComplete	()V
      //   239: aload_0
      //   240: getfield 23	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:this$0	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
      //   243: aload_0
      //   244: getfield 32	org/eclipse/paho/client/mqttv3/internal/ClientComms$DisconnectBG:token	Lorg/eclipse/paho/client/mqttv3/MqttToken;
      //   247: aconst_null
      //   248: invokevirtual 112	org/eclipse/paho/client/mqttv3/internal/ClientComms:shutdownConnection	(Lorg/eclipse/paho/client/mqttv3/MqttToken;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
      //   251: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	252	0	this	DisconnectBG
      //   133	59	1	localObject	Object
      //   193	1	1	localMqttException	MqttException
      // Exception table:
      //   from	to	target	type
      //   47	95	133	finally
      //   47	95	193	org/eclipse/paho/client/mqttv3/MqttException
    }
    
    void start()
    {
      StringBuilder localStringBuilder = new StringBuilder("MQTT Disc: ");
      localStringBuilder.append(ClientComms.this.getClient().getClientId());
      this.threadName = localStringBuilder.toString();
      if (ClientComms.this.executorService == null) {
        new Thread(this).start();
      } else {
        ClientComms.this.executorService.execute(this);
      }
    }
  }
  
  class MessageDiscardedCallback
    implements IDiscardedBufferMessageCallback
  {
    MessageDiscardedCallback() {}
    
    public void messageDiscarded(MqttWireMessage paramMqttWireMessage)
    {
      if (ClientComms.this.disconnectedMessageBuffer.isPersistBuffer()) {
        ClientComms.this.clientState.unPersistBufferedMessage(paramMqttWireMessage);
      }
    }
  }
  
  class ReconnectDisconnectedBufferCallback
    implements IDisconnectedBufferCallback
  {
    final String methodName;
    
    ReconnectDisconnectedBufferCallback(String paramString)
    {
      this.methodName = paramString;
    }
    
    public void publishBufferedMessage(BufferedMessage paramBufferedMessage)
      throws MqttException
    {
      if (ClientComms.this.isConnected()) {
        for (;;)
        {
          if (ClientComms.this.clientState.getActualInFlight() < ClientComms.this.clientState.getMaxInFlight() - 3)
          {
            ClientComms.this.log.fine(ClientComms.this.CLASS_NAME, this.methodName, "510", new Object[] { paramBufferedMessage.getMessage().getKey() });
            ClientComms.this.internalSend(paramBufferedMessage.getMessage(), paramBufferedMessage.getToken());
            ClientComms.this.clientState.unPersistBufferedMessage(paramBufferedMessage.getMessage());
            return;
          }
          Thread.yield();
        }
      }
      ClientComms.this.log.fine(ClientComms.this.CLASS_NAME, this.methodName, "208");
      throw ExceptionHelper.createMqttException(32104);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\ClientComms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */