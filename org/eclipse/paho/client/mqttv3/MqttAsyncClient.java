package org.eclipse.paho.client.mqttv3;

import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.internal.ConnectActionListener;
import org.eclipse.paho.client.mqttv3.internal.DisconnectedMessageBuffer;
import org.eclipse.paho.client.mqttv3.internal.ExceptionHelper;
import org.eclipse.paho.client.mqttv3.internal.HighResolutionTimer;
import org.eclipse.paho.client.mqttv3.internal.NetworkModule;
import org.eclipse.paho.client.mqttv3.internal.NetworkModuleService;
import org.eclipse.paho.client.mqttv3.internal.SystemHighResolutionTimer;
import org.eclipse.paho.client.mqttv3.internal.Token;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttDisconnect;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttSubscribe;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttUnsubscribe;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.eclipse.paho.client.mqttv3.util.Debug;

public class MqttAsyncClient
  implements IMqttAsyncClient
{
  private static final String CLASS_NAME = MqttAsyncClient.class.getName();
  private static final String CLIENT_ID_PREFIX = "paho";
  private static final long DISCONNECT_TIMEOUT = 10000L;
  private static final char MAX_HIGH_SURROGATE = '?';
  private static final char MIN_HIGH_SURROGATE = '?';
  private static final long QUIESCE_TIMEOUT = 30000L;
  private static final Object clientLock = new Object();
  private static int reconnectDelay = 1000;
  private String clientId;
  protected ClientComms comms;
  private MqttConnectOptions connOpts;
  private ScheduledExecutorService executorService;
  private Logger log;
  private MqttCallback mqttCallback;
  private MqttClientPersistence persistence;
  private Timer reconnectTimer;
  private boolean reconnecting;
  private String serverURI;
  private Hashtable topics;
  private Object userContext;
  
  public MqttAsyncClient(String paramString1, String paramString2)
    throws MqttException
  {
    this(paramString1, paramString2, new MqttDefaultFilePersistence());
  }
  
  public MqttAsyncClient(String paramString1, String paramString2, MqttClientPersistence paramMqttClientPersistence)
    throws MqttException
  {
    this(paramString1, paramString2, paramMqttClientPersistence, new TimerPingSender());
  }
  
  public MqttAsyncClient(String paramString1, String paramString2, MqttClientPersistence paramMqttClientPersistence, MqttPingSender paramMqttPingSender)
    throws MqttException
  {
    this(paramString1, paramString2, paramMqttClientPersistence, paramMqttPingSender, null);
  }
  
  public MqttAsyncClient(String paramString1, String paramString2, MqttClientPersistence paramMqttClientPersistence, MqttPingSender paramMqttPingSender, ScheduledExecutorService paramScheduledExecutorService)
    throws MqttException
  {
    this(paramString1, paramString2, paramMqttClientPersistence, paramMqttPingSender, paramScheduledExecutorService, null);
  }
  
  public MqttAsyncClient(String paramString1, String paramString2, MqttClientPersistence paramMqttClientPersistence, MqttPingSender paramMqttPingSender, ScheduledExecutorService paramScheduledExecutorService, HighResolutionTimer paramHighResolutionTimer)
    throws MqttException
  {
    Logger localLogger = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
    this.log = localLogger;
    this.reconnecting = false;
    localLogger.setResourceName(paramString2);
    if (paramString2 != null)
    {
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (i >= paramString2.length() - 1)
        {
          if (j <= 65535)
          {
            NetworkModuleService.validateURI(paramString1);
            this.serverURI = paramString1;
            this.clientId = paramString2;
            this.persistence = paramMqttClientPersistence;
            if (paramMqttClientPersistence == null) {
              this.persistence = new MemoryPersistence();
            }
            if (paramHighResolutionTimer == null) {
              paramHighResolutionTimer = new SystemHighResolutionTimer();
            }
            this.executorService = paramScheduledExecutorService;
            this.log.fine(CLASS_NAME, "MqttAsyncClient", "101", new Object[] { paramString2, paramString1, paramMqttClientPersistence });
            this.persistence.open(paramString2, paramString1);
            this.comms = new ClientComms(this, this.persistence, paramMqttPingSender, this.executorService, paramHighResolutionTimer);
            this.persistence.close();
            this.topics = new Hashtable();
            return;
          }
          throw new IllegalArgumentException("ClientId longer than 65535 characters");
        }
        int k = i;
        if (Character_isHighSurrogate(paramString2.charAt(i))) {
          k = i + 1;
        }
        j++;
        i = k + 1;
      }
    }
    throw new IllegalArgumentException("Null clientId");
  }
  
  protected static boolean Character_isHighSurrogate(char paramChar)
  {
    return (paramChar >= 55296) && (paramChar <= 56319);
  }
  
  private void attemptReconnect()
  {
    this.log.fine(CLASS_NAME, "attemptReconnect", "500", new Object[] { this.clientId });
    try
    {
      MqttConnectOptions localMqttConnectOptions = this.connOpts;
      Object localObject = this.userContext;
      MqttReconnectActionListener localMqttReconnectActionListener = new org/eclipse/paho/client/mqttv3/MqttAsyncClient$MqttReconnectActionListener;
      localMqttReconnectActionListener.<init>(this, "attemptReconnect");
      connect(localMqttConnectOptions, localObject, localMqttReconnectActionListener);
    }
    catch (MqttException localMqttException)
    {
      this.log.fine(CLASS_NAME, "attemptReconnect", "804", null, localMqttException);
    }
    catch (MqttSecurityException localMqttSecurityException)
    {
      this.log.fine(CLASS_NAME, "attemptReconnect", "804", null, localMqttSecurityException);
    }
  }
  
  private NetworkModule createNetworkModule(String paramString, MqttConnectOptions paramMqttConnectOptions)
    throws MqttException, MqttSecurityException
  {
    this.log.fine(CLASS_NAME, "createNetworkModule", "115", new Object[] { paramString });
    return NetworkModuleService.createInstance(paramString, paramMqttConnectOptions, this.clientId);
  }
  
  public static String generateClientId()
  {
    StringBuilder localStringBuilder = new StringBuilder("paho");
    localStringBuilder.append(System.nanoTime());
    return localStringBuilder.toString();
  }
  
  private String getHostName(String paramString)
  {
    int i = paramString.indexOf(':');
    int j = i;
    if (i == -1) {
      j = paramString.indexOf('/');
    }
    i = j;
    if (j == -1) {
      i = paramString.length();
    }
    return paramString.substring(0, i);
  }
  
  private void startReconnectCycle()
  {
    this.log.fine(CLASS_NAME, "startReconnectCycle", "503", new Object[] { this.clientId, Long.valueOf(reconnectDelay) });
    Object localObject = new StringBuilder("MQTT Reconnect: ");
    ((StringBuilder)localObject).append(this.clientId);
    localObject = new Timer(((StringBuilder)localObject).toString());
    this.reconnectTimer = ((Timer)localObject);
    ((Timer)localObject).schedule(new ReconnectTask(null), reconnectDelay);
  }
  
  private void stopReconnectCycle()
  {
    this.log.fine(CLASS_NAME, "stopReconnectCycle", "504", new Object[] { this.clientId });
    synchronized (clientLock)
    {
      if (this.connOpts.isAutomaticReconnect())
      {
        Timer localTimer = this.reconnectTimer;
        if (localTimer != null)
        {
          localTimer.cancel();
          this.reconnectTimer = null;
        }
        reconnectDelay = 1000;
      }
      return;
    }
  }
  
  private IMqttToken subscribeBase(String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    if (this.log.isLoggable(5))
    {
      localObject = new StringBuffer();
      for (int i = 0;; i++)
      {
        if (i >= paramArrayOfString.length)
        {
          this.log.fine(CLASS_NAME, "subscribe", "106", new Object[] { ((StringBuffer)localObject).toString(), paramObject, paramIMqttActionListener });
          break;
        }
        if (i > 0) {
          ((StringBuffer)localObject).append(", ");
        }
        ((StringBuffer)localObject).append("topic=");
        ((StringBuffer)localObject).append(paramArrayOfString[i]);
        ((StringBuffer)localObject).append(" qos=");
        ((StringBuffer)localObject).append(paramArrayOfInt[i]);
      }
    }
    Object localObject = new MqttToken(getClientId());
    ((MqttToken)localObject).setActionCallback(paramIMqttActionListener);
    ((MqttToken)localObject).setUserContext(paramObject);
    ((MqttToken)localObject).internalTok.setTopics(paramArrayOfString);
    paramArrayOfString = new MqttSubscribe(paramArrayOfString, paramArrayOfInt);
    this.comms.sendNoWait(paramArrayOfString, (MqttToken)localObject);
    this.log.fine(CLASS_NAME, "subscribe", "109");
    return (IMqttToken)localObject;
  }
  
  public IMqttToken checkPing(Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    Logger localLogger = this.log;
    paramObject = CLASS_NAME;
    localLogger.fine((String)paramObject, "ping", "117");
    paramIMqttActionListener = this.comms.checkForActivity(paramIMqttActionListener);
    this.log.fine((String)paramObject, "ping", "118");
    return paramIMqttActionListener;
  }
  
  public void close()
    throws MqttException
  {
    close(false);
  }
  
  public void close(boolean paramBoolean)
    throws MqttException
  {
    Logger localLogger = this.log;
    String str = CLASS_NAME;
    localLogger.fine(str, "close", "113");
    this.comms.close(paramBoolean);
    this.log.fine(str, "close", "114");
  }
  
  public IMqttToken connect()
    throws MqttException, MqttSecurityException
  {
    return connect(null, null);
  }
  
  public IMqttToken connect(Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttSecurityException
  {
    return connect(new MqttConnectOptions(), paramObject, paramIMqttActionListener);
  }
  
  public IMqttToken connect(MqttConnectOptions paramMqttConnectOptions)
    throws MqttException, MqttSecurityException
  {
    return connect(paramMqttConnectOptions, null, null);
  }
  
  public IMqttToken connect(MqttConnectOptions paramMqttConnectOptions, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttSecurityException
  {
    if (!this.comms.isConnected())
    {
      if (!this.comms.isConnecting())
      {
        if (!this.comms.isDisconnecting())
        {
          if (!this.comms.isClosed())
          {
            MqttConnectOptions localMqttConnectOptions = paramMqttConnectOptions;
            if (paramMqttConnectOptions == null) {
              localMqttConnectOptions = new MqttConnectOptions();
            }
            this.connOpts = localMqttConnectOptions;
            this.userContext = paramObject;
            boolean bool1 = localMqttConnectOptions.isAutomaticReconnect();
            Logger localLogger = this.log;
            String str1 = CLASS_NAME;
            boolean bool2 = localMqttConnectOptions.isCleanSession();
            int i = localMqttConnectOptions.getConnectionTimeout();
            int j = localMqttConnectOptions.getKeepAliveInterval();
            String str2 = localMqttConnectOptions.getUserName();
            paramMqttConnectOptions = localMqttConnectOptions.getPassword();
            String str3 = "[null]";
            if (paramMqttConnectOptions == null) {
              paramMqttConnectOptions = "[null]";
            } else {
              paramMqttConnectOptions = "[notnull]";
            }
            if (localMqttConnectOptions.getWillMessage() != null) {
              str3 = "[notnull]";
            }
            localLogger.fine(str1, "connect", "103", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j), str2, paramMqttConnectOptions, str3, paramObject, paramIMqttActionListener });
            this.comms.setNetworkModules(createNetworkModules(this.serverURI, localMqttConnectOptions));
            this.comms.setReconnectCallback(new MqttReconnectCallback(bool1));
            paramMqttConnectOptions = new MqttToken(getClientId());
            paramObject = new ConnectActionListener(this, this.persistence, this.comms, localMqttConnectOptions, paramMqttConnectOptions, paramObject, paramIMqttActionListener, this.reconnecting);
            paramMqttConnectOptions.setActionCallback((IMqttActionListener)paramObject);
            paramMqttConnectOptions.setUserContext(this);
            paramIMqttActionListener = this.mqttCallback;
            if ((paramIMqttActionListener instanceof MqttCallbackExtended)) {
              ((ConnectActionListener)paramObject).setMqttCallbackExtended((MqttCallbackExtended)paramIMqttActionListener);
            }
            this.comms.setNetworkModuleIndex(0);
            ((ConnectActionListener)paramObject).connect();
            return paramMqttConnectOptions;
          }
          throw new MqttException(32111);
        }
        throw new MqttException(32102);
      }
      throw new MqttException(32110);
    }
    throw ExceptionHelper.createMqttException(32100);
  }
  
  protected NetworkModule[] createNetworkModules(String paramString, MqttConnectOptions paramMqttConnectOptions)
    throws MqttException, MqttSecurityException
  {
    Object localObject1 = this.log;
    Object localObject2 = CLASS_NAME;
    int i = 0;
    ((Logger)localObject1).fine((String)localObject2, "createNetworkModules", "116", new Object[] { paramString });
    localObject1 = paramMqttConnectOptions.getServerURIs();
    if (localObject1 == null)
    {
      localObject2 = new String[1];
      localObject2[0] = paramString;
    }
    else
    {
      localObject2 = localObject1;
      if (localObject1.length == 0)
      {
        localObject2 = new String[1];
        localObject2[0] = paramString;
      }
    }
    paramString = new NetworkModule[localObject2.length];
    for (;;)
    {
      if (i >= localObject2.length)
      {
        this.log.fine(CLASS_NAME, "createNetworkModules", "108");
        return paramString;
      }
      paramString[i] = createNetworkModule(localObject2[i], paramMqttConnectOptions);
      i++;
    }
  }
  
  public void deleteBufferedMessage(int paramInt)
  {
    this.comms.deleteBufferedMessage(paramInt);
  }
  
  public IMqttToken disconnect()
    throws MqttException
  {
    return disconnect(null, null);
  }
  
  public IMqttToken disconnect(long paramLong)
    throws MqttException
  {
    return disconnect(paramLong, null, null);
  }
  
  public IMqttToken disconnect(long paramLong, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    Object localObject = this.log;
    String str = CLASS_NAME;
    ((Logger)localObject).fine(str, "disconnect", "104", new Object[] { Long.valueOf(paramLong), paramObject, paramIMqttActionListener });
    localObject = new MqttToken(getClientId());
    ((MqttToken)localObject).setActionCallback(paramIMqttActionListener);
    ((MqttToken)localObject).setUserContext(paramObject);
    paramObject = new MqttDisconnect();
    try
    {
      this.comms.disconnect((MqttDisconnect)paramObject, paramLong, (MqttToken)localObject);
      this.log.fine(str, "disconnect", "108");
      return (IMqttToken)localObject;
    }
    catch (MqttException paramObject)
    {
      this.log.fine(CLASS_NAME, "disconnect", "105", null, (Throwable)paramObject);
      throw ((Throwable)paramObject);
    }
  }
  
  public IMqttToken disconnect(Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    return disconnect(30000L, paramObject, paramIMqttActionListener);
  }
  
  public void disconnectForcibly()
    throws MqttException
  {
    disconnectForcibly(30000L, 10000L);
  }
  
  public void disconnectForcibly(long paramLong)
    throws MqttException
  {
    disconnectForcibly(30000L, paramLong);
  }
  
  public void disconnectForcibly(long paramLong1, long paramLong2)
    throws MqttException
  {
    this.comms.disconnectForcibly(paramLong1, paramLong2);
  }
  
  public void disconnectForcibly(long paramLong1, long paramLong2, boolean paramBoolean)
    throws MqttException
  {
    this.comms.disconnectForcibly(paramLong1, paramLong2, paramBoolean);
  }
  
  public MqttMessage getBufferedMessage(int paramInt)
  {
    return this.comms.getBufferedMessage(paramInt);
  }
  
  public int getBufferedMessageCount()
  {
    return this.comms.getBufferedMessageCount();
  }
  
  public String getClientId()
  {
    return this.clientId;
  }
  
  public String getCurrentServerURI()
  {
    return this.comms.getNetworkModules()[this.comms.getNetworkModuleIndex()].getServerURI();
  }
  
  public Debug getDebug()
  {
    return new Debug(this.clientId, this.comms);
  }
  
  public int getInFlightMessageCount()
  {
    return this.comms.getActualInFlight();
  }
  
  public IMqttDeliveryToken[] getPendingDeliveryTokens()
  {
    return this.comms.getPendingDeliveryTokens();
  }
  
  public String getServerURI()
  {
    return this.serverURI;
  }
  
  protected MqttTopic getTopic(String paramString)
  {
    MqttTopic.validate(paramString, false);
    MqttTopic localMqttTopic1 = (MqttTopic)this.topics.get(paramString);
    MqttTopic localMqttTopic2 = localMqttTopic1;
    if (localMqttTopic1 == null)
    {
      localMqttTopic2 = new MqttTopic(paramString, this.comms);
      this.topics.put(paramString, localMqttTopic2);
    }
    return localMqttTopic2;
  }
  
  public boolean isConnected()
  {
    return this.comms.isConnected();
  }
  
  public void messageArrivedComplete(int paramInt1, int paramInt2)
    throws MqttException
  {
    this.comms.messageArrivedComplete(paramInt1, paramInt2);
  }
  
  public IMqttDeliveryToken publish(String paramString, MqttMessage paramMqttMessage)
    throws MqttException, MqttPersistenceException
  {
    return publish(paramString, paramMqttMessage, null, null);
  }
  
  public IMqttDeliveryToken publish(String paramString, MqttMessage paramMqttMessage, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttPersistenceException
  {
    Object localObject = this.log;
    String str = CLASS_NAME;
    ((Logger)localObject).fine(str, "publish", "111", new Object[] { paramString, paramObject, paramIMqttActionListener });
    MqttTopic.validate(paramString, false);
    localObject = new MqttDeliveryToken(getClientId());
    ((MqttToken)localObject).setActionCallback(paramIMqttActionListener);
    ((MqttToken)localObject).setUserContext(paramObject);
    ((MqttDeliveryToken)localObject).setMessage(paramMqttMessage);
    ((MqttToken)localObject).internalTok.setTopics(new String[] { paramString });
    paramString = new MqttPublish(paramString, paramMqttMessage);
    this.comms.sendNoWait(paramString, (MqttToken)localObject);
    this.log.fine(str, "publish", "112");
    return (IMqttDeliveryToken)localObject;
  }
  
  public IMqttDeliveryToken publish(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws MqttException, MqttPersistenceException
  {
    return publish(paramString, paramArrayOfByte, paramInt, paramBoolean, null, null);
  }
  
  public IMqttDeliveryToken publish(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException, MqttPersistenceException
  {
    paramArrayOfByte = new MqttMessage(paramArrayOfByte);
    paramArrayOfByte.setQos(paramInt);
    paramArrayOfByte.setRetained(paramBoolean);
    return publish(paramString, paramArrayOfByte, paramObject, paramIMqttActionListener);
  }
  
  public void reconnect()
    throws MqttException
  {
    this.log.fine(CLASS_NAME, "reconnect", "500", new Object[] { this.clientId });
    if (!this.comms.isConnected())
    {
      if (!this.comms.isConnecting())
      {
        if (!this.comms.isDisconnecting())
        {
          if (!this.comms.isClosed())
          {
            stopReconnectCycle();
            attemptReconnect();
            return;
          }
          throw new MqttException(32111);
        }
        throw new MqttException(32102);
      }
      throw new MqttException(32110);
    }
    throw ExceptionHelper.createMqttException(32100);
  }
  
  public boolean removeMessage(IMqttDeliveryToken paramIMqttDeliveryToken)
    throws MqttException
  {
    return this.comms.removeMessage(paramIMqttDeliveryToken);
  }
  
  public void setBufferOpts(DisconnectedBufferOptions paramDisconnectedBufferOptions)
  {
    this.comms.setDisconnectedMessageBuffer(new DisconnectedMessageBuffer(paramDisconnectedBufferOptions));
  }
  
  public void setCallback(MqttCallback paramMqttCallback)
  {
    this.mqttCallback = paramMqttCallback;
    this.comms.setCallback(paramMqttCallback);
  }
  
  public void setManualAcks(boolean paramBoolean)
  {
    this.comms.setManualAcks(paramBoolean);
  }
  
  public IMqttToken subscribe(String paramString, int paramInt)
    throws MqttException
  {
    return subscribe(new String[] { paramString }, new int[] { paramInt }, null, null);
  }
  
  public IMqttToken subscribe(String paramString, int paramInt, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    return subscribe(new String[] { paramString }, new int[] { paramInt }, paramObject, paramIMqttActionListener);
  }
  
  public IMqttToken subscribe(String paramString, int paramInt, Object paramObject, IMqttActionListener paramIMqttActionListener, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException
  {
    return subscribe(new String[] { paramString }, new int[] { paramInt }, paramObject, paramIMqttActionListener, new IMqttMessageListener[] { paramIMqttMessageListener });
  }
  
  public IMqttToken subscribe(String paramString, int paramInt, IMqttMessageListener paramIMqttMessageListener)
    throws MqttException
  {
    return subscribe(new String[] { paramString }, new int[] { paramInt }, null, null, new IMqttMessageListener[] { paramIMqttMessageListener });
  }
  
  public IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt)
    throws MqttException
  {
    return subscribe(paramArrayOfString, paramArrayOfInt, null, null);
  }
  
  public IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    if (paramArrayOfString.length == paramArrayOfInt.length)
    {
      int i = paramArrayOfString.length;
      for (int j = 0;; j++)
      {
        if (j >= i) {
          return subscribeBase(paramArrayOfString, paramArrayOfInt, paramObject, paramIMqttActionListener);
        }
        String str = paramArrayOfString[j];
        MqttTopic.validate(str, true);
        this.comms.removeMessageListener(str);
      }
    }
    throw new IllegalArgumentException();
  }
  
  public IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, Object paramObject, IMqttActionListener paramIMqttActionListener, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException
  {
    if (((paramArrayOfIMqttMessageListener == null) || (paramArrayOfIMqttMessageListener.length == paramArrayOfInt.length)) && (paramArrayOfInt.length == paramArrayOfString.length))
    {
      int i = 0;
      for (int j = 0;; j++)
      {
        if (j >= paramArrayOfString.length) {
          try
          {
            paramArrayOfInt = subscribeBase(paramArrayOfString, paramArrayOfInt, paramObject, paramIMqttActionListener);
            return paramArrayOfInt;
          }
          catch (Exception paramArrayOfInt)
          {
            int k = paramArrayOfString.length;
            for (j = i; j < k; j++)
            {
              paramObject = paramArrayOfString[j];
              this.comms.removeMessageListener((String)paramObject);
            }
            throw paramArrayOfInt;
          }
        }
        MqttTopic.validate(paramArrayOfString[j], true);
        if ((paramArrayOfIMqttMessageListener != null) && (paramArrayOfIMqttMessageListener[j] != null)) {
          this.comms.setMessageListener(paramArrayOfString[j], paramArrayOfIMqttMessageListener[j]);
        } else {
          this.comms.removeMessageListener(paramArrayOfString[j]);
        }
      }
    }
    throw new IllegalArgumentException();
  }
  
  public IMqttToken subscribe(String[] paramArrayOfString, int[] paramArrayOfInt, IMqttMessageListener[] paramArrayOfIMqttMessageListener)
    throws MqttException
  {
    return subscribe(paramArrayOfString, paramArrayOfInt, null, null, paramArrayOfIMqttMessageListener);
  }
  
  public IMqttToken unsubscribe(String paramString)
    throws MqttException
  {
    return unsubscribe(new String[] { paramString }, null, null);
  }
  
  public IMqttToken unsubscribe(String paramString, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    return unsubscribe(new String[] { paramString }, paramObject, paramIMqttActionListener);
  }
  
  public IMqttToken unsubscribe(String[] paramArrayOfString)
    throws MqttException
  {
    return unsubscribe(paramArrayOfString, null, null);
  }
  
  public IMqttToken unsubscribe(String[] paramArrayOfString, Object paramObject, IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    boolean bool = this.log.isLoggable(5);
    int i = 0;
    Object localObject1;
    if (bool)
    {
      localObject1 = "";
      for (j = 0;; j++)
      {
        if (j >= paramArrayOfString.length)
        {
          this.log.fine(CLASS_NAME, "unsubscribe", "107", new Object[] { localObject1, paramObject, paramIMqttActionListener });
          break;
        }
        Object localObject2 = localObject1;
        if (j > 0)
        {
          localObject1 = new StringBuilder(String.valueOf(localObject1));
          ((StringBuilder)localObject1).append(", ");
          localObject2 = ((StringBuilder)localObject1).toString();
        }
        localObject1 = new StringBuilder(String.valueOf(localObject2));
        ((StringBuilder)localObject1).append(paramArrayOfString[j]);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    int k = paramArrayOfString.length;
    for (int j = 0;; j++)
    {
      if (j >= k)
      {
        k = paramArrayOfString.length;
        for (j = i;; j++)
        {
          if (j >= k)
          {
            localObject1 = new MqttToken(getClientId());
            ((MqttToken)localObject1).setActionCallback(paramIMqttActionListener);
            ((MqttToken)localObject1).setUserContext(paramObject);
            ((MqttToken)localObject1).internalTok.setTopics(paramArrayOfString);
            paramArrayOfString = new MqttUnsubscribe(paramArrayOfString);
            this.comms.sendNoWait(paramArrayOfString, (MqttToken)localObject1);
            this.log.fine(CLASS_NAME, "unsubscribe", "110");
            return (IMqttToken)localObject1;
          }
          localObject1 = paramArrayOfString[j];
          this.comms.removeMessageListener((String)localObject1);
        }
      }
      MqttTopic.validate(paramArrayOfString[j], true);
    }
  }
  
  class MqttReconnectActionListener
    implements IMqttActionListener
  {
    final String methodName;
    
    MqttReconnectActionListener(String paramString)
    {
      this.methodName = paramString;
    }
    
    private void rescheduleReconnectCycle(int paramInt)
    {
      ??? = new StringBuilder(String.valueOf(this.methodName));
      ((StringBuilder)???).append(":rescheduleReconnectCycle");
      ??? = ((StringBuilder)???).toString();
      MqttAsyncClient.this.log.fine(MqttAsyncClient.CLASS_NAME, (String)???, "505", new Object[] { MqttAsyncClient.this.clientId, String.valueOf(MqttAsyncClient.reconnectDelay) });
      synchronized (MqttAsyncClient.clientLock)
      {
        if (MqttAsyncClient.this.connOpts.isAutomaticReconnect()) {
          if (MqttAsyncClient.this.reconnectTimer != null)
          {
            Timer localTimer = MqttAsyncClient.this.reconnectTimer;
            MqttAsyncClient.ReconnectTask localReconnectTask = new org/eclipse/paho/client/mqttv3/MqttAsyncClient$ReconnectTask;
            localReconnectTask.<init>(MqttAsyncClient.this, null);
            localTimer.schedule(localReconnectTask, paramInt);
          }
          else
          {
            MqttAsyncClient.reconnectDelay = paramInt;
            MqttAsyncClient.this.startReconnectCycle();
          }
        }
        return;
      }
    }
    
    public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
    {
      MqttAsyncClient.this.log.fine(MqttAsyncClient.CLASS_NAME, this.methodName, "502", new Object[] { paramIMqttToken.getClient().getClientId() });
      if (MqttAsyncClient.reconnectDelay < MqttAsyncClient.this.connOpts.getMaxReconnectDelay()) {
        MqttAsyncClient.reconnectDelay *= 2;
      }
      rescheduleReconnectCycle(MqttAsyncClient.reconnectDelay);
    }
    
    public void onSuccess(IMqttToken paramIMqttToken)
    {
      MqttAsyncClient.this.log.fine(MqttAsyncClient.CLASS_NAME, this.methodName, "501", new Object[] { paramIMqttToken.getClient().getClientId() });
      MqttAsyncClient.this.comms.setRestingState(false);
      MqttAsyncClient.this.stopReconnectCycle();
    }
  }
  
  class MqttReconnectCallback
    implements MqttCallbackExtended
  {
    final boolean automaticReconnect;
    
    MqttReconnectCallback(boolean paramBoolean)
    {
      this.automaticReconnect = paramBoolean;
    }
    
    public void connectComplete(boolean paramBoolean, String paramString) {}
    
    public void connectionLost(Throwable paramThrowable)
    {
      if (this.automaticReconnect)
      {
        MqttAsyncClient.this.comms.setRestingState(true);
        MqttAsyncClient.this.reconnecting = true;
        MqttAsyncClient.this.startReconnectCycle();
      }
    }
    
    public void deliveryComplete(IMqttDeliveryToken paramIMqttDeliveryToken) {}
    
    public void messageArrived(String paramString, MqttMessage paramMqttMessage)
      throws Exception
    {}
  }
  
  private class ReconnectTask
    extends TimerTask
  {
    private static final String methodName = "ReconnectTask.run";
    
    private ReconnectTask() {}
    
    public void run()
    {
      MqttAsyncClient.this.log.fine(MqttAsyncClient.CLASS_NAME, "ReconnectTask.run", "506");
      MqttAsyncClient.this.attemptReconnect();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\MqttAsyncClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */