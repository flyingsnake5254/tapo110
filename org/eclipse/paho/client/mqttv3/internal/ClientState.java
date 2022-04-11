package org.eclipse.paho.client.mqttv3.internal;

import java.io.EOFException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistable;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttPingSender;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnack;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnect;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPingReq;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPingResp;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubComp;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubRec;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubRel;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttSuback;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttSubscribe;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttUnsubAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttUnsubscribe;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class ClientState
{
  private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.ClientState";
  private static final int MAX_MSG_ID = 65535;
  private static final int MIN_MSG_ID = 1;
  private static final String PERSISTENCE_CONFIRMED_PREFIX = "sc-";
  private static final String PERSISTENCE_RECEIVED_PREFIX = "r-";
  private static final String PERSISTENCE_SENT_BUFFERED_PREFIX = "sb-";
  private static final String PERSISTENCE_SENT_PREFIX = "s-";
  private int actualInFlight;
  private CommsCallback callback;
  private boolean cleanSession;
  private ClientComms clientComms;
  private boolean connected;
  private HighResolutionTimer highResolutionTimer;
  private int inFlightPubRels;
  private Hashtable inUseMsgIds;
  private Hashtable inboundQoS2;
  private long keepAliveNanos;
  private long lastInboundActivity;
  private long lastOutboundActivity;
  private long lastPing;
  private Logger log;
  private int maxInflight;
  private int nextMsgId;
  private Hashtable outboundQoS0;
  private Hashtable outboundQoS1;
  private Hashtable outboundQoS2;
  private volatile Vector pendingFlows;
  private volatile Vector pendingMessages;
  private MqttClientPersistence persistence;
  private MqttWireMessage pingCommand;
  private int pingOutstanding;
  private final Object pingOutstandingLock;
  private MqttPingSender pingSender;
  private final Object queueLock;
  private final Object quiesceLock;
  private boolean quiescing;
  private CommsTokenStore tokenStore;
  
  protected ClientState(MqttClientPersistence paramMqttClientPersistence, CommsTokenStore paramCommsTokenStore, CommsCallback paramCommsCallback, ClientComms paramClientComms, MqttPingSender paramMqttPingSender, HighResolutionTimer paramHighResolutionTimer)
    throws MqttException
  {
    String str = CLASS_NAME;
    this.log = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", str);
    this.nextMsgId = 0;
    this.clientComms = null;
    this.callback = null;
    this.maxInflight = 0;
    this.actualInFlight = 0;
    this.inFlightPubRels = 0;
    this.queueLock = new Object();
    this.quiesceLock = new Object();
    this.quiescing = false;
    this.lastOutboundActivity = 0L;
    this.lastInboundActivity = 0L;
    this.lastPing = 0L;
    this.pingOutstandingLock = new Object();
    this.pingOutstanding = 0;
    this.connected = false;
    this.outboundQoS2 = null;
    this.outboundQoS1 = null;
    this.outboundQoS0 = null;
    this.inboundQoS2 = null;
    this.pingSender = null;
    this.log.setResourceName(paramClientComms.getClient().getClientId());
    this.log.finer(str, "<Init>", "");
    this.inUseMsgIds = new Hashtable();
    this.pendingFlows = new Vector();
    this.outboundQoS2 = new Hashtable();
    this.outboundQoS1 = new Hashtable();
    this.outboundQoS0 = new Hashtable();
    this.inboundQoS2 = new Hashtable();
    this.pingCommand = new MqttPingReq();
    this.inFlightPubRels = 0;
    this.actualInFlight = 0;
    this.persistence = paramMqttClientPersistence;
    this.callback = paramCommsCallback;
    this.tokenStore = paramCommsTokenStore;
    this.clientComms = paramClientComms;
    this.pingSender = paramMqttPingSender;
    this.highResolutionTimer = paramHighResolutionTimer;
    restoreState();
  }
  
  private void decrementInFlight()
  {
    synchronized (this.queueLock)
    {
      int i = this.actualInFlight - 1;
      this.actualInFlight = i;
      this.log.fine(CLASS_NAME, "decrementInFlight", "646", new Object[] { Integer.valueOf(i) });
      if (!checkQuiesceLock()) {
        this.queueLock.notifyAll();
      }
      return;
    }
  }
  
  private int getNextMessageId()
    throws MqttException
  {
    try
    {
      int i = this.nextMsgId;
      int j = 0;
      int m;
      do
      {
        int k = this.nextMsgId + 1;
        this.nextMsgId = k;
        if (k > 65535) {
          this.nextMsgId = 1;
        }
        m = this.nextMsgId;
        k = j;
        if (m == i)
        {
          k = j + 1;
          if (k == 2) {
            throw ExceptionHelper.createMqttException(32001);
          }
        }
        j = k;
      } while (this.inUseMsgIds.containsKey(Integer.valueOf(m)));
      Integer localInteger = Integer.valueOf(this.nextMsgId);
      this.inUseMsgIds.put(localInteger, localInteger);
      j = this.nextMsgId;
      return j;
    }
    finally {}
  }
  
  private String getReceivedPersistenceKey(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("r-");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private String getReceivedPersistenceKey(MqttWireMessage paramMqttWireMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder("r-");
    localStringBuilder.append(paramMqttWireMessage.getMessageId());
    return localStringBuilder.toString();
  }
  
  private String getSendBufferedPersistenceKey(MqttWireMessage paramMqttWireMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder("sb-");
    localStringBuilder.append(paramMqttWireMessage.getMessageId());
    return localStringBuilder.toString();
  }
  
  private String getSendConfirmPersistenceKey(MqttWireMessage paramMqttWireMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder("sc-");
    localStringBuilder.append(paramMqttWireMessage.getMessageId());
    return localStringBuilder.toString();
  }
  
  private String getSendPersistenceKey(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("s-");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private String getSendPersistenceKey(MqttWireMessage paramMqttWireMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder("s-");
    localStringBuilder.append(paramMqttWireMessage.getMessageId());
    return localStringBuilder.toString();
  }
  
  private void insertInOrder(Vector paramVector, MqttWireMessage paramMqttWireMessage)
  {
    int i = paramMqttWireMessage.getMessageId();
    for (int j = 0;; j++)
    {
      if (j >= paramVector.size())
      {
        paramVector.addElement(paramMqttWireMessage);
        return;
      }
      if (((MqttWireMessage)paramVector.elementAt(j)).getMessageId() > i)
      {
        paramVector.insertElementAt(paramMqttWireMessage, j);
        return;
      }
    }
  }
  
  private Vector reOrder(Vector paramVector)
  {
    Vector localVector = new Vector();
    if (paramVector.size() == 0) {
      return localVector;
    }
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    for (;;)
    {
      if (j >= paramVector.size())
      {
        if (65535 - k + ((MqttWireMessage)paramVector.elementAt(0)).getMessageId() > m) {
          j = 0;
        } else {
          j = n;
        }
        for (n = j;; n++)
        {
          if (n >= paramVector.size()) {
            for (n = i;; n++)
            {
              if (n >= j) {
                return localVector;
              }
              localVector.addElement(paramVector.elementAt(n));
            }
          }
          localVector.addElement(paramVector.elementAt(n));
        }
      }
      int i1 = ((MqttWireMessage)paramVector.elementAt(j)).getMessageId();
      k = i1 - k;
      int i2 = m;
      if (k > m)
      {
        n = j;
        i2 = k;
      }
      j++;
      k = i1;
      m = i2;
    }
  }
  
  private void releaseMessageId(int paramInt)
  {
    try
    {
      this.inUseMsgIds.remove(Integer.valueOf(paramInt));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void restoreInflightMessages()
  {
    this.pendingMessages = new Vector(this.maxInflight);
    this.pendingFlows = new Vector();
    Object localObject1 = this.outboundQoS2.keys();
    for (;;)
    {
      if (!((Enumeration)localObject1).hasMoreElements())
      {
        localObject1 = this.outboundQoS1.keys();
        for (;;)
        {
          if (!((Enumeration)localObject1).hasMoreElements())
          {
            localObject2 = this.outboundQoS0.keys();
            for (;;)
            {
              if (!((Enumeration)localObject2).hasMoreElements())
              {
                this.pendingFlows = reOrder(this.pendingFlows);
                this.pendingMessages = reOrder(this.pendingMessages);
                return;
              }
              localObject3 = ((Enumeration)localObject2).nextElement();
              localObject1 = (MqttPublish)this.outboundQoS0.get(localObject3);
              this.log.fine(CLASS_NAME, "restoreInflightMessages", "512", new Object[] { localObject3 });
              insertInOrder(this.pendingMessages, (MqttWireMessage)localObject1);
            }
          }
          localObject3 = ((Enumeration)localObject1).nextElement();
          localObject2 = (MqttPublish)this.outboundQoS1.get(localObject3);
          ((MqttWireMessage)localObject2).setDuplicate(true);
          this.log.fine(CLASS_NAME, "restoreInflightMessages", "612", new Object[] { localObject3 });
          insertInOrder(this.pendingMessages, (MqttWireMessage)localObject2);
        }
      }
      Object localObject3 = ((Enumeration)localObject1).nextElement();
      Object localObject2 = (MqttWireMessage)this.outboundQoS2.get(localObject3);
      if ((localObject2 instanceof MqttPublish))
      {
        this.log.fine(CLASS_NAME, "restoreInflightMessages", "610", new Object[] { localObject3 });
        ((MqttWireMessage)localObject2).setDuplicate(true);
        insertInOrder(this.pendingMessages, (MqttPublish)localObject2);
      }
      else if ((localObject2 instanceof MqttPubRel))
      {
        this.log.fine(CLASS_NAME, "restoreInflightMessages", "611", new Object[] { localObject3 });
        insertInOrder(this.pendingFlows, (MqttPubRel)localObject2);
      }
    }
  }
  
  private MqttWireMessage restoreMessage(String paramString, MqttPersistable paramMqttPersistable)
    throws MqttException
  {
    try
    {
      paramMqttPersistable = MqttWireMessage.createWireMessage(paramMqttPersistable);
    }
    catch (MqttException paramMqttPersistable)
    {
      this.log.fine(CLASS_NAME, "restoreMessage", "602", new Object[] { paramString }, paramMqttPersistable);
      if (!(paramMqttPersistable.getCause() instanceof EOFException)) {
        break label94;
      }
    }
    if (paramString != null) {
      this.persistence.remove(paramString);
    }
    paramMqttPersistable = null;
    this.log.fine(CLASS_NAME, "restoreMessage", "601", new Object[] { paramString, paramMqttPersistable });
    return paramMqttPersistable;
    label94:
    throw paramMqttPersistable;
  }
  
  public MqttToken checkForActivity(IMqttActionListener paramIMqttActionListener)
    throws MqttException
  {
    ??? = this.log;
    String str = CLASS_NAME;
    ((Logger)???).fine(str, "checkForActivity", "616", new Object[0]);
    synchronized (this.quiesceLock)
    {
      if (this.quiescing) {
        return null;
      }
      ??? = TimeUnit.NANOSECONDS;
      ((TimeUnit)???).toMillis(this.keepAliveNanos);
      if ((this.connected) && (this.keepAliveNanos > 0L))
      {
        long l1 = this.highResolutionTimer.nanoTime();
        synchronized (this.pingOutstandingLock)
        {
          int i = this.pingOutstanding;
          long l2;
          long l3;
          if (i > 0)
          {
            l2 = this.lastInboundActivity;
            l3 = this.keepAliveNanos;
            if (l1 - l2 >= 100000 + l3)
            {
              this.log.severe(str, "checkForActivity", "619", new Object[] { Long.valueOf(l3), Long.valueOf(this.lastOutboundActivity), Long.valueOf(this.lastInboundActivity), Long.valueOf(l1), Long.valueOf(this.lastPing) });
              throw ExceptionHelper.createMqttException(32000);
            }
          }
          if (i == 0)
          {
            l3 = this.lastOutboundActivity;
            l2 = this.keepAliveNanos;
            if (l1 - l3 >= 2L * l2)
            {
              this.log.severe(str, "checkForActivity", "642", new Object[] { Long.valueOf(l2), Long.valueOf(this.lastOutboundActivity), Long.valueOf(this.lastInboundActivity), Long.valueOf(l1), Long.valueOf(this.lastPing) });
              throw ExceptionHelper.createMqttException(32002);
            }
          }
          if (((i == 0) && (l1 - this.lastInboundActivity >= this.keepAliveNanos - 100000)) || (l1 - this.lastOutboundActivity >= this.keepAliveNanos - 100000))
          {
            this.log.fine(str, "checkForActivity", "620", new Object[] { Long.valueOf(this.keepAliveNanos), Long.valueOf(this.lastOutboundActivity), Long.valueOf(this.lastInboundActivity) });
            ??? = new org/eclipse/paho/client/mqttv3/MqttToken;
            ((MqttToken)???).<init>(this.clientComms.getClient().getClientId());
            if (paramIMqttActionListener != null) {
              ((MqttToken)???).setActionCallback(paramIMqttActionListener);
            }
            this.tokenStore.saveToken((MqttToken)???, this.pingCommand);
            this.pendingFlows.insertElementAt(this.pingCommand, 0);
            l1 = getKeepAlive();
            notifyQueueLock();
            paramIMqttActionListener = (IMqttActionListener)???;
          }
          else
          {
            this.log.fine(str, "checkForActivity", "634", null);
            l1 = ((TimeUnit)???).toMillis(l1 - this.lastOutboundActivity);
            l1 = Math.max(1L, getKeepAlive() - l1);
            paramIMqttActionListener = null;
          }
          this.log.fine(str, "checkForActivity", "624", new Object[] { Long.valueOf(l1) });
          this.pingSender.schedule(l1);
        }
      }
      paramIMqttActionListener = null;
      return paramIMqttActionListener;
    }
  }
  
  protected boolean checkQuiesceLock()
  {
    int i = this.tokenStore.count();
    if ((this.quiescing) && (i == 0) && (this.pendingFlows.size() == 0) && (this.callback.isQuiesced()))
    {
      this.log.fine(CLASS_NAME, "checkQuiesceLock", "626", new Object[] { Boolean.valueOf(this.quiescing), Integer.valueOf(this.actualInFlight), Integer.valueOf(this.pendingFlows.size()), Integer.valueOf(this.inFlightPubRels), Boolean.valueOf(this.callback.isQuiesced()), Integer.valueOf(i) });
      synchronized (this.quiesceLock)
      {
        this.quiesceLock.notifyAll();
        return true;
      }
    }
    return false;
  }
  
  protected void clearState()
    throws MqttException
  {
    this.log.fine(CLASS_NAME, "clearState", ">");
    this.persistence.clear();
    this.inUseMsgIds.clear();
    this.pendingMessages.clear();
    this.pendingFlows.clear();
    this.outboundQoS2.clear();
    this.outboundQoS1.clear();
    this.outboundQoS0.clear();
    this.inboundQoS2.clear();
    this.tokenStore.clear();
  }
  
  protected void close()
  {
    this.inUseMsgIds.clear();
    if (this.pendingMessages != null) {
      this.pendingMessages.clear();
    }
    this.pendingFlows.clear();
    this.outboundQoS2.clear();
    this.outboundQoS1.clear();
    this.outboundQoS0.clear();
    this.inboundQoS2.clear();
    this.tokenStore.clear();
    this.inUseMsgIds = null;
    this.pendingMessages = null;
    this.pendingFlows = null;
    this.outboundQoS2 = null;
    this.outboundQoS1 = null;
    this.outboundQoS0 = null;
    this.inboundQoS2 = null;
    this.tokenStore = null;
    this.callback = null;
    this.clientComms = null;
    this.persistence = null;
    this.pingCommand = null;
    this.highResolutionTimer = null;
  }
  
  public void connected()
  {
    this.log.fine(CLASS_NAME, "connected", "631");
    this.connected = true;
    this.pingSender.start();
  }
  
  protected void deliveryComplete(int paramInt)
    throws MqttPersistenceException
  {
    this.log.fine(CLASS_NAME, "deliveryComplete", "641", new Object[] { Integer.valueOf(paramInt) });
    this.persistence.remove(getReceivedPersistenceKey(paramInt));
    this.inboundQoS2.remove(Integer.valueOf(paramInt));
  }
  
  protected void deliveryComplete(MqttPublish paramMqttPublish)
    throws MqttPersistenceException
  {
    this.log.fine(CLASS_NAME, "deliveryComplete", "641", new Object[] { Integer.valueOf(paramMqttPublish.getMessageId()) });
    this.persistence.remove(getReceivedPersistenceKey(paramMqttPublish));
    this.inboundQoS2.remove(Integer.valueOf(paramMqttPublish.getMessageId()));
  }
  
  public void disconnected(MqttException arg1)
  {
    this.log.fine(CLASS_NAME, "disconnected", "633", new Object[] { ??? });
    this.connected = false;
    try
    {
      if (this.cleanSession) {
        clearState();
      }
      this.pendingMessages.clear();
      this.pendingFlows.clear();
      synchronized (this.pingOutstandingLock)
      {
        this.pingOutstanding = 0;
      }
      return;
    }
    catch (MqttException ???)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  protected MqttWireMessage get()
    throws MqttException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 103	org/eclipse/paho/client/mqttv3/internal/ClientState:queueLock	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +7 -> 17
    //   13: aload_1
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: getfield 269	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingMessages	Ljava/util/Vector;
    //   21: invokevirtual 466	java/util/Vector:isEmpty	()Z
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: getfield 165	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   31: invokevirtual 466	java/util/Vector:isEmpty	()Z
    //   34: ifne +30 -> 64
    //   37: aload_0
    //   38: getfield 165	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   41: invokevirtual 466	java/util/Vector:isEmpty	()Z
    //   44: ifeq +70 -> 114
    //   47: aload_0
    //   48: getfield 99	org/eclipse/paho/client/mqttv3/internal/ClientState:actualInFlight	I
    //   51: istore_3
    //   52: aload_0
    //   53: getfield 97	org/eclipse/paho/client/mqttv3/internal/ClientState:maxInflight	I
    //   56: istore 4
    //   58: iload_3
    //   59: iload 4
    //   61: if_icmplt +53 -> 114
    //   64: aload_0
    //   65: getfield 89	org/eclipse/paho/client/mqttv3/internal/ClientState:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   68: astore 5
    //   70: getstatic 79	org/eclipse/paho/client/mqttv3/internal/ClientState:CLASS_NAME	Ljava/lang/String;
    //   73: astore 6
    //   75: aload 5
    //   77: aload 6
    //   79: ldc_w 467
    //   82: ldc_w 469
    //   85: invokeinterface 427 4 0
    //   90: aload_0
    //   91: getfield 103	org/eclipse/paho/client/mqttv3/internal/ClientState:queueLock	Ljava/lang/Object;
    //   94: invokevirtual 472	java/lang/Object:wait	()V
    //   97: aload_0
    //   98: getfield 89	org/eclipse/paho/client/mqttv3/internal/ClientState:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   101: aload 6
    //   103: ldc_w 467
    //   106: ldc_w 474
    //   109: invokeinterface 427 4 0
    //   114: aload_0
    //   115: getfield 165	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   118: ifnull +230 -> 348
    //   121: aload_0
    //   122: getfield 119	org/eclipse/paho/client/mqttv3/internal/ClientState:connected	Z
    //   125: ifne +33 -> 158
    //   128: aload_0
    //   129: getfield 165	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   132: invokevirtual 466	java/util/Vector:isEmpty	()Z
    //   135: ifne +213 -> 348
    //   138: aload_0
    //   139: getfield 165	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   142: iconst_0
    //   143: invokevirtual 252	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   146: checkcast 233	org/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage
    //   149: instanceof 476
    //   152: ifne +6 -> 158
    //   155: goto +193 -> 348
    //   158: aload_0
    //   159: getfield 165	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   162: invokevirtual 466	java/util/Vector:isEmpty	()Z
    //   165: ifne +74 -> 239
    //   168: aload_0
    //   169: getfield 165	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingFlows	Ljava/util/Vector;
    //   172: iconst_0
    //   173: invokevirtual 478	java/util/Vector:remove	(I)Ljava/lang/Object;
    //   176: checkcast 233	org/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage
    //   179: astore_2
    //   180: aload_2
    //   181: instanceof 304
    //   184: ifeq +47 -> 231
    //   187: aload_0
    //   188: getfield 101	org/eclipse/paho/client/mqttv3/internal/ClientState:inFlightPubRels	I
    //   191: iconst_1
    //   192: iadd
    //   193: istore 4
    //   195: aload_0
    //   196: iload 4
    //   198: putfield 101	org/eclipse/paho/client/mqttv3/internal/ClientState:inFlightPubRels	I
    //   201: aload_0
    //   202: getfield 89	org/eclipse/paho/client/mqttv3/internal/ClientState:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   205: getstatic 79	org/eclipse/paho/client/mqttv3/internal/ClientState:CLASS_NAME	Ljava/lang/String;
    //   208: ldc_w 467
    //   211: ldc_w 480
    //   214: iconst_1
    //   215: anewarray 4	java/lang/Object
    //   218: dup
    //   219: iconst_0
    //   220: iload 4
    //   222: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: invokeinterface 194 5 0
    //   231: aload_0
    //   232: invokevirtual 198	org/eclipse/paho/client/mqttv3/internal/ClientState:checkQuiesceLock	()Z
    //   235: pop
    //   236: goto -227 -> 9
    //   239: aload_0
    //   240: getfield 269	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingMessages	Ljava/util/Vector;
    //   243: invokevirtual 466	java/util/Vector:isEmpty	()Z
    //   246: ifne -237 -> 9
    //   249: aload_0
    //   250: getfield 99	org/eclipse/paho/client/mqttv3/internal/ClientState:actualInFlight	I
    //   253: aload_0
    //   254: getfield 97	org/eclipse/paho/client/mqttv3/internal/ClientState:maxInflight	I
    //   257: if_icmpge +70 -> 327
    //   260: aload_0
    //   261: getfield 269	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingMessages	Ljava/util/Vector;
    //   264: iconst_0
    //   265: invokevirtual 252	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   268: checkcast 233	org/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage
    //   271: astore_2
    //   272: aload_0
    //   273: getfield 269	org/eclipse/paho/client/mqttv3/internal/ClientState:pendingMessages	Ljava/util/Vector;
    //   276: iconst_0
    //   277: invokevirtual 483	java/util/Vector:removeElementAt	(I)V
    //   280: aload_0
    //   281: getfield 99	org/eclipse/paho/client/mqttv3/internal/ClientState:actualInFlight	I
    //   284: iconst_1
    //   285: iadd
    //   286: istore 4
    //   288: aload_0
    //   289: iload 4
    //   291: putfield 99	org/eclipse/paho/client/mqttv3/internal/ClientState:actualInFlight	I
    //   294: aload_0
    //   295: getfield 89	org/eclipse/paho/client/mqttv3/internal/ClientState:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   298: getstatic 79	org/eclipse/paho/client/mqttv3/internal/ClientState:CLASS_NAME	Ljava/lang/String;
    //   301: ldc_w 467
    //   304: ldc_w 485
    //   307: iconst_1
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: iload 4
    //   315: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: aastore
    //   319: invokeinterface 194 5 0
    //   324: goto -315 -> 9
    //   327: aload_0
    //   328: getfield 89	org/eclipse/paho/client/mqttv3/internal/ClientState:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   331: getstatic 79	org/eclipse/paho/client/mqttv3/internal/ClientState:CLASS_NAME	Ljava/lang/String;
    //   334: ldc_w 467
    //   337: ldc_w 487
    //   340: invokeinterface 427 4 0
    //   345: goto -336 -> 9
    //   348: aload_0
    //   349: getfield 89	org/eclipse/paho/client/mqttv3/internal/ClientState:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   352: getstatic 79	org/eclipse/paho/client/mqttv3/internal/ClientState:CLASS_NAME	Ljava/lang/String;
    //   355: ldc_w 467
    //   358: ldc_w 489
    //   361: invokeinterface 427 4 0
    //   366: aload_1
    //   367: monitorexit
    //   368: aconst_null
    //   369: areturn
    //   370: astore_2
    //   371: aload_1
    //   372: monitorexit
    //   373: aload_2
    //   374: athrow
    //   375: astore 6
    //   377: goto -263 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	this	ClientState
    //   4	368	1	localObject1	Object
    //   8	264	2	localMqttWireMessage	MqttWireMessage
    //   370	4	2	localObject2	Object
    //   51	11	3	i	int
    //   56	258	4	j	int
    //   68	8	5	localLogger	Logger
    //   73	29	6	str	String
    //   375	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   13	15	370	finally
    //   17	37	370	finally
    //   37	58	370	finally
    //   64	114	370	finally
    //   114	155	370	finally
    //   158	231	370	finally
    //   231	236	370	finally
    //   239	324	370	finally
    //   327	345	370	finally
    //   348	368	370	finally
    //   371	373	370	finally
    //   64	114	375	java/lang/InterruptedException
  }
  
  public int getActualInFlight()
  {
    return this.actualInFlight;
  }
  
  protected boolean getCleanSession()
  {
    return this.cleanSession;
  }
  
  public Properties getDebug()
  {
    Properties localProperties = new Properties();
    localProperties.put("In use msgids", this.inUseMsgIds);
    localProperties.put("pendingMessages", this.pendingMessages);
    localProperties.put("pendingFlows", this.pendingFlows);
    localProperties.put("maxInflight", Integer.valueOf(this.maxInflight));
    localProperties.put("nextMsgID", Integer.valueOf(this.nextMsgId));
    localProperties.put("actualInFlight", Integer.valueOf(this.actualInFlight));
    localProperties.put("inFlightPubRels", Integer.valueOf(this.inFlightPubRels));
    localProperties.put("quiescing", Boolean.valueOf(this.quiescing));
    localProperties.put("pingoutstanding", Integer.valueOf(this.pingOutstanding));
    localProperties.put("lastOutboundActivity", Long.valueOf(this.lastOutboundActivity));
    localProperties.put("lastInboundActivity", Long.valueOf(this.lastInboundActivity));
    localProperties.put("outboundQoS2", this.outboundQoS2);
    localProperties.put("outboundQoS1", this.outboundQoS1);
    localProperties.put("outboundQoS0", this.outboundQoS0);
    localProperties.put("inboundQoS2", this.inboundQoS2);
    localProperties.put("tokens", this.tokenStore);
    return localProperties;
  }
  
  protected long getKeepAlive()
  {
    return TimeUnit.NANOSECONDS.toMillis(this.keepAliveNanos);
  }
  
  public int getMaxInFlight()
  {
    return this.maxInflight;
  }
  
  protected void notifyComplete(MqttToken paramMqttToken)
    throws MqttException
  {
    MqttWireMessage localMqttWireMessage = paramMqttToken.internalTok.getWireMessage();
    if ((localMqttWireMessage != null) && ((localMqttWireMessage instanceof MqttAck)))
    {
      Logger localLogger = this.log;
      String str = CLASS_NAME;
      localLogger.fine(str, "notifyComplete", "629", new Object[] { Integer.valueOf(localMqttWireMessage.getMessageId()), paramMqttToken, localMqttWireMessage });
      paramMqttToken = (MqttAck)localMqttWireMessage;
      if ((paramMqttToken instanceof MqttPubAck))
      {
        this.persistence.remove(getSendPersistenceKey(localMqttWireMessage));
        this.persistence.remove(getSendBufferedPersistenceKey(localMqttWireMessage));
        this.outboundQoS1.remove(Integer.valueOf(paramMqttToken.getMessageId()));
        decrementInFlight();
        releaseMessageId(localMqttWireMessage.getMessageId());
        this.tokenStore.removeToken(localMqttWireMessage);
        this.log.fine(str, "notifyComplete", "650", new Object[] { Integer.valueOf(paramMqttToken.getMessageId()) });
      }
      else if ((paramMqttToken instanceof MqttPubComp))
      {
        this.persistence.remove(getSendPersistenceKey(localMqttWireMessage));
        this.persistence.remove(getSendConfirmPersistenceKey(localMqttWireMessage));
        this.persistence.remove(getSendBufferedPersistenceKey(localMqttWireMessage));
        this.outboundQoS2.remove(Integer.valueOf(paramMqttToken.getMessageId()));
        this.inFlightPubRels -= 1;
        decrementInFlight();
        releaseMessageId(localMqttWireMessage.getMessageId());
        this.tokenStore.removeToken(localMqttWireMessage);
        this.log.fine(str, "notifyComplete", "645", new Object[] { Integer.valueOf(paramMqttToken.getMessageId()), Integer.valueOf(this.inFlightPubRels) });
      }
      checkQuiesceLock();
    }
  }
  
  public void notifyQueueLock()
  {
    synchronized (this.queueLock)
    {
      this.log.fine(CLASS_NAME, "notifyQueueLock", "638");
      this.queueLock.notifyAll();
      return;
    }
  }
  
  protected void notifyReceivedAck(MqttAck arg1)
    throws MqttException
  {
    this.lastInboundActivity = this.highResolutionTimer.nanoTime();
    Object localObject1 = this.log;
    Object localObject2 = CLASS_NAME;
    ((Logger)localObject1).fine((String)localObject2, "notifyReceivedAck", "627", new Object[] { Integer.valueOf(???.getMessageId()), ??? });
    localObject1 = this.tokenStore.getToken(???);
    if (localObject1 == null)
    {
      this.log.fine((String)localObject2, "notifyReceivedAck", "662", new Object[] { Integer.valueOf(???.getMessageId()) });
    }
    else if ((??? instanceof MqttPubRec))
    {
      send(new MqttPubRel((MqttPubRec)???), (MqttToken)localObject1);
    }
    else if ((!(??? instanceof MqttPubAck)) && (!(??? instanceof MqttPubComp)))
    {
      if ((??? instanceof MqttPingResp)) {
        synchronized (this.pingOutstandingLock)
        {
          this.pingOutstanding = Math.max(0, this.pingOutstanding - 1);
          notifyResult(???, (MqttToken)localObject1, null);
          if (this.pingOutstanding == 0) {
            this.tokenStore.removeToken(???);
          }
          this.log.fine((String)localObject2, "notifyReceivedAck", "636", new Object[] { Integer.valueOf(this.pingOutstanding) });
        }
      }
      if ((??? instanceof MqttConnack))
      {
        localObject2 = (MqttConnack)???;
        int i = ((MqttConnack)localObject2).getReturnCode();
        if (i == 0) {
          synchronized (this.queueLock)
          {
            if (this.cleanSession)
            {
              clearState();
              this.tokenStore.saveToken((MqttToken)localObject1, ???);
            }
            this.inFlightPubRels = 0;
            this.actualInFlight = 0;
            restoreInflightMessages();
            connected();
            this.clientComms.connectComplete((MqttConnack)localObject2, null);
            notifyResult(???, (MqttToken)localObject1, null);
            this.tokenStore.removeToken(???);
            synchronized (this.queueLock)
            {
              this.queueLock.notifyAll();
            }
          }
        }
        throw ExceptionHelper.createMqttException(i);
      }
      notifyResult(???, localMqttToken, null);
      releaseMessageId(???.getMessageId());
      this.tokenStore.removeToken(???);
    }
    else
    {
      notifyResult(???, localMqttToken, null);
    }
    checkQuiesceLock();
  }
  
  public void notifyReceivedBytes(int paramInt)
  {
    if (paramInt > 0) {
      this.lastInboundActivity = this.highResolutionTimer.nanoTime();
    }
    this.log.fine(CLASS_NAME, "notifyReceivedBytes", "630", new Object[] { Integer.valueOf(paramInt) });
  }
  
  protected void notifyReceivedMsg(MqttWireMessage paramMqttWireMessage)
    throws MqttException
  {
    this.lastInboundActivity = this.highResolutionTimer.nanoTime();
    this.log.fine(CLASS_NAME, "notifyReceivedMsg", "651", new Object[] { Integer.valueOf(paramMqttWireMessage.getMessageId()), paramMqttWireMessage });
    if (!this.quiescing)
    {
      MqttPublish localMqttPublish;
      if ((paramMqttWireMessage instanceof MqttPublish))
      {
        localMqttPublish = (MqttPublish)paramMqttWireMessage;
        int i = localMqttPublish.getMessage().getQos();
        if ((i != 0) && (i != 1))
        {
          if (i == 2)
          {
            this.persistence.put(getReceivedPersistenceKey(paramMqttWireMessage), localMqttPublish);
            this.inboundQoS2.put(Integer.valueOf(localMqttPublish.getMessageId()), localMqttPublish);
            send(new MqttPubRec(localMqttPublish), null);
          }
        }
        else
        {
          paramMqttWireMessage = this.callback;
          if (paramMqttWireMessage != null) {
            paramMqttWireMessage.messageArrived(localMqttPublish);
          }
        }
      }
      else if ((paramMqttWireMessage instanceof MqttPubRel))
      {
        localMqttPublish = (MqttPublish)this.inboundQoS2.get(Integer.valueOf(paramMqttWireMessage.getMessageId()));
        if (localMqttPublish != null)
        {
          paramMqttWireMessage = this.callback;
          if (paramMqttWireMessage != null) {
            paramMqttWireMessage.messageArrived(localMqttPublish);
          }
        }
        else
        {
          send(new MqttPubComp(paramMqttWireMessage.getMessageId()), null);
        }
      }
    }
  }
  
  protected void notifyResult(MqttWireMessage paramMqttWireMessage, MqttToken paramMqttToken, MqttException paramMqttException)
  {
    paramMqttToken.internalTok.markComplete(paramMqttWireMessage, paramMqttException);
    paramMqttToken.internalTok.notifyComplete();
    if ((paramMqttWireMessage != null) && ((paramMqttWireMessage instanceof MqttAck)) && (!(paramMqttWireMessage instanceof MqttPubRec)))
    {
      this.log.fine(CLASS_NAME, "notifyResult", "648", new Object[] { paramMqttToken.internalTok.getKey(), paramMqttWireMessage, paramMqttException });
      this.callback.asyncOperationComplete(paramMqttToken);
    }
    if (paramMqttWireMessage == null)
    {
      this.log.fine(CLASS_NAME, "notifyResult", "649", new Object[] { paramMqttToken.internalTok.getKey(), paramMqttException });
      this.callback.asyncOperationComplete(paramMqttToken);
    }
  }
  
  protected void notifySent(MqttWireMessage arg1)
  {
    this.lastOutboundActivity = this.highResolutionTimer.nanoTime();
    ??? = this.log;
    String str = CLASS_NAME;
    ((Logger)???).fine(str, "notifySent", "625", new Object[] { ???.getKey() });
    MqttToken localMqttToken2 = ???.getToken();
    ??? = localMqttToken2;
    if (localMqttToken2 == null)
    {
      localMqttToken2 = this.tokenStore.getToken(???);
      ??? = localMqttToken2;
      if (localMqttToken2 == null) {
        return;
      }
    }
    ((MqttToken)???).internalTok.notifySent();
    if ((??? instanceof MqttPingReq)) {
      synchronized (this.pingOutstandingLock)
      {
        long l = this.highResolutionTimer.nanoTime();
        synchronized (this.pingOutstandingLock)
        {
          this.lastPing = l;
          int i = this.pingOutstanding + 1;
          this.pingOutstanding = i;
          this.log.fine(str, "notifySent", "635", new Object[] { Integer.valueOf(i) });
        }
      }
    }
    if (((??? instanceof MqttPublish)) && (((MqttPublish)???).getMessage().getQos() == 0))
    {
      localMqttToken1.internalTok.markComplete(null, null);
      this.callback.asyncOperationComplete(localMqttToken1);
      decrementInFlight();
      releaseMessageId(???.getMessageId());
      this.tokenStore.removeToken(???);
      checkQuiesceLock();
    }
  }
  
  public void notifySentBytes(int paramInt)
  {
    if (paramInt > 0) {
      this.lastOutboundActivity = this.highResolutionTimer.nanoTime();
    }
    this.log.fine(CLASS_NAME, "notifySentBytes", "643", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void persistBufferedMessage(MqttWireMessage paramMqttWireMessage)
    throws MqttException
  {
    String str1 = getSendBufferedPersistenceKey(paramMqttWireMessage);
    String str2 = str1;
    try
    {
      paramMqttWireMessage.setMessageId(getNextMessageId());
      str2 = str1;
      str1 = getSendBufferedPersistenceKey(paramMqttWireMessage);
      str2 = str1;
      try
      {
        this.persistence.put(str1, (MqttPublish)paramMqttWireMessage);
      }
      catch (MqttPersistenceException localMqttPersistenceException)
      {
        str3 = str1;
        this.log.fine(CLASS_NAME, "persistBufferedMessage", "515");
        str3 = str1;
        this.persistence.open(this.clientComms.getClient().getClientId(), this.clientComms.getClient().getServerURI());
        str3 = str1;
        this.persistence.put(str1, (MqttPublish)paramMqttWireMessage);
      }
      str3 = str1;
      this.log.fine(CLASS_NAME, "persistBufferedMessage", "513", new Object[] { str1 });
      return;
    }
    catch (MqttException paramMqttWireMessage)
    {
      String str3;
      this.log.warning(CLASS_NAME, "persistBufferedMessage", "514", new Object[] { str3 });
      throw paramMqttWireMessage;
    }
  }
  
  public void quiesce(long paramLong)
  {
    if (paramLong > 0L)
    {
      ??? = this.log;
      String str = CLASS_NAME;
      ((Logger)???).fine(str, "quiesce", "637", new Object[] { Long.valueOf(paramLong) });
      synchronized (this.queueLock)
      {
        this.quiescing = true;
        this.callback.quiesce();
        notifyQueueLock();
        for (;;)
        {
          try
          {
            synchronized (this.quiesceLock)
            {
              int i = this.tokenStore.count();
              if ((i > 0) || (this.pendingFlows.size() > 0) || (!this.callback.isQuiesced()))
              {
                this.log.fine(str, "quiesce", "639", new Object[] { Integer.valueOf(this.actualInFlight), Integer.valueOf(this.pendingFlows.size()), Integer.valueOf(this.inFlightPubRels), Integer.valueOf(i) });
                this.quiesceLock.wait(paramLong);
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            continue;
          }
          synchronized (this.queueLock)
          {
            this.pendingMessages.clear();
            this.pendingFlows.clear();
            this.quiescing = false;
            this.actualInFlight = 0;
            this.log.fine(CLASS_NAME, "quiesce", "640");
          }
        }
        throw ((Throwable)localObject3);
      }
    }
  }
  
  protected boolean removeMessage(IMqttDeliveryToken arg1)
    throws MqttException
  {
    Object localObject1 = ???.getMessage();
    int i = ???.getMessageId();
    synchronized (this.queueLock)
    {
      int j = ((MqttMessage)localObject1).getQos();
      boolean bool1 = true;
      boolean bool2;
      if ((j == 1) && (this.outboundQoS1.remove(Integer.valueOf(i)) != null)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool3 = bool2;
      if (((MqttMessage)localObject1).getQos() == 2)
      {
        bool3 = bool2;
        if (this.outboundQoS2.remove(Integer.valueOf(i)) != null) {
          bool3 = true;
        }
      }
      if (this.pendingMessages.removeElement(localObject1)) {
        bool2 = bool1;
      } else {
        bool2 = bool3;
      }
      this.persistence.remove(getSendPersistenceKey(i));
      localObject1 = Integer.toString(i);
      this.tokenStore.removeToken((String)localObject1);
      releaseMessageId(i);
      decrementInFlight();
      return bool2;
    }
  }
  
  public Vector resolveOldTokens(MqttException arg1)
  {
    this.log.fine(CLASS_NAME, "resolveOldTokens", "632", new Object[] { ??? });
    MqttException localMqttException = ???;
    if (??? == null) {
      localMqttException = new MqttException(32102);
    }
    Vector localVector = this.tokenStore.getOutstandingTokens();
    Enumeration localEnumeration = localVector.elements();
    for (;;)
    {
      if (!localEnumeration.hasMoreElements()) {
        return localVector;
      }
      synchronized ((MqttToken)localEnumeration.nextElement())
      {
        if ((!???.isComplete()) && (!???.internalTok.isCompletePending()) && (???.getException() == null)) {
          ???.internalTok.setException(localMqttException);
        }
        if ((??? instanceof MqttDeliveryToken)) {
          continue;
        }
        this.tokenStore.removeToken(???.internalTok.getKey());
      }
    }
  }
  
  protected void restoreState()
    throws MqttException
  {
    Object localObject1 = this.persistence.keys();
    int i = this.nextMsgId;
    Vector localVector = new Vector();
    this.log.fine(CLASS_NAME, "restoreState", "600");
    for (;;)
    {
      if (!((Enumeration)localObject1).hasMoreElements())
      {
        localObject2 = localVector.elements();
        for (;;)
        {
          if (!((Enumeration)localObject2).hasMoreElements())
          {
            this.nextMsgId = i;
            return;
          }
          localObject1 = (String)((Enumeration)localObject2).nextElement();
          this.log.fine(CLASS_NAME, "restoreState", "609", new Object[] { localObject1 });
          this.persistence.remove((String)localObject1);
        }
      }
      Object localObject2 = (String)((Enumeration)localObject1).nextElement();
      Object localObject3 = restoreMessage((String)localObject2, this.persistence.get((String)localObject2));
      if (localObject3 != null) {
        if (((String)localObject2).startsWith("r-"))
        {
          this.log.fine(CLASS_NAME, "restoreState", "604", new Object[] { localObject2, localObject3 });
          this.inboundQoS2.put(Integer.valueOf(((MqttWireMessage)localObject3).getMessageId()), localObject3);
        }
        else
        {
          MqttPublish localMqttPublish;
          if (((String)localObject2).startsWith("s-"))
          {
            localMqttPublish = (MqttPublish)localObject3;
            i = Math.max(localMqttPublish.getMessageId(), i);
            if (this.persistence.containsKey(getSendConfirmPersistenceKey(localMqttPublish)))
            {
              MqttPubRel localMqttPubRel = (MqttPubRel)restoreMessage((String)localObject2, this.persistence.get(getSendConfirmPersistenceKey(localMqttPublish)));
              if (localMqttPubRel != null)
              {
                this.log.fine(CLASS_NAME, "restoreState", "605", new Object[] { localObject2, localObject3 });
                this.outboundQoS2.put(Integer.valueOf(localMqttPubRel.getMessageId()), localMqttPubRel);
              }
              else
              {
                this.log.fine(CLASS_NAME, "restoreState", "606", new Object[] { localObject2, localObject3 });
              }
            }
            else
            {
              localMqttPublish.setDuplicate(true);
              if (localMqttPublish.getMessage().getQos() == 2)
              {
                this.log.fine(CLASS_NAME, "restoreState", "607", new Object[] { localObject2, localObject3 });
                this.outboundQoS2.put(Integer.valueOf(localMqttPublish.getMessageId()), localMqttPublish);
              }
              else
              {
                this.log.fine(CLASS_NAME, "restoreState", "608", new Object[] { localObject2, localObject3 });
                this.outboundQoS1.put(Integer.valueOf(localMqttPublish.getMessageId()), localMqttPublish);
              }
            }
            this.tokenStore.restoreToken(localMqttPublish).internalTok.setClient(this.clientComms.getClient());
            this.inUseMsgIds.put(Integer.valueOf(localMqttPublish.getMessageId()), Integer.valueOf(localMqttPublish.getMessageId()));
          }
          else if (((String)localObject2).startsWith("sb-"))
          {
            localMqttPublish = (MqttPublish)localObject3;
            i = Math.max(localMqttPublish.getMessageId(), i);
            if (localMqttPublish.getMessage().getQos() == 2)
            {
              this.log.fine(CLASS_NAME, "restoreState", "607", new Object[] { localObject2, localObject3 });
              this.outboundQoS2.put(Integer.valueOf(localMqttPublish.getMessageId()), localMqttPublish);
            }
            else if (localMqttPublish.getMessage().getQos() == 1)
            {
              this.log.fine(CLASS_NAME, "restoreState", "608", new Object[] { localObject2, localObject3 });
              this.outboundQoS1.put(Integer.valueOf(localMqttPublish.getMessageId()), localMqttPublish);
            }
            else
            {
              this.log.fine(CLASS_NAME, "restoreState", "511", new Object[] { localObject2, localObject3 });
              this.outboundQoS0.put(Integer.valueOf(localMqttPublish.getMessageId()), localMqttPublish);
              this.persistence.remove((String)localObject2);
            }
            this.tokenStore.restoreToken(localMqttPublish).internalTok.setClient(this.clientComms.getClient());
            this.inUseMsgIds.put(Integer.valueOf(localMqttPublish.getMessageId()), Integer.valueOf(localMqttPublish.getMessageId()));
          }
          else if (((String)localObject2).startsWith("sc-"))
          {
            localObject3 = (MqttPubRel)localObject3;
            if (!this.persistence.containsKey(getSendPersistenceKey((MqttWireMessage)localObject3))) {
              localVector.addElement(localObject2);
            }
          }
        }
      }
    }
  }
  
  public void send(MqttWireMessage paramMqttWireMessage, MqttToken paramMqttToken)
    throws MqttException
  {
    if ((paramMqttWireMessage.isMessageIdRequired()) && (paramMqttWireMessage.getMessageId() == 0)) {
      if (((paramMqttWireMessage instanceof MqttPublish)) && (((MqttPublish)paramMqttWireMessage).getMessage().getQos() != 0)) {
        paramMqttWireMessage.setMessageId(getNextMessageId());
      } else if (((paramMqttWireMessage instanceof MqttPubAck)) || ((paramMqttWireMessage instanceof MqttPubRec)) || ((paramMqttWireMessage instanceof MqttPubRel)) || ((paramMqttWireMessage instanceof MqttPubComp)) || ((paramMqttWireMessage instanceof MqttSubscribe)) || ((paramMqttWireMessage instanceof MqttSuback)) || ((paramMqttWireMessage instanceof MqttUnsubscribe)) || ((paramMqttWireMessage instanceof MqttUnsubAck))) {
        paramMqttWireMessage.setMessageId(getNextMessageId());
      }
    }
    if (paramMqttToken != null)
    {
      paramMqttWireMessage.setToken(paramMqttToken);
      try
      {
        paramMqttToken.internalTok.setMessageID(paramMqttWireMessage.getMessageId());
      }
      catch (Exception localException) {}
    }
    if ((paramMqttWireMessage instanceof MqttPublish)) {
      synchronized (this.queueLock)
      {
        int i = this.actualInFlight;
        if (i < this.maxInflight)
        {
          MqttMessage localMqttMessage = ((MqttPublish)paramMqttWireMessage).getMessage();
          this.log.fine(CLASS_NAME, "send", "628", new Object[] { Integer.valueOf(paramMqttWireMessage.getMessageId()), Integer.valueOf(localMqttMessage.getQos()), paramMqttWireMessage });
          i = localMqttMessage.getQos();
          if (i != 1)
          {
            if (i == 2)
            {
              this.outboundQoS2.put(Integer.valueOf(paramMqttWireMessage.getMessageId()), paramMqttWireMessage);
              this.persistence.put(getSendPersistenceKey(paramMqttWireMessage), (MqttPublish)paramMqttWireMessage);
              this.tokenStore.saveToken(paramMqttToken, paramMqttWireMessage);
            }
          }
          else
          {
            this.outboundQoS1.put(Integer.valueOf(paramMqttWireMessage.getMessageId()), paramMqttWireMessage);
            this.persistence.put(getSendPersistenceKey(paramMqttWireMessage), (MqttPublish)paramMqttWireMessage);
            this.tokenStore.saveToken(paramMqttToken, paramMqttWireMessage);
          }
          this.pendingMessages.addElement(paramMqttWireMessage);
          this.queueLock.notifyAll();
          break label602;
        }
        this.log.fine(CLASS_NAME, "send", "613", new Object[] { Integer.valueOf(i) });
        paramMqttWireMessage = new org/eclipse/paho/client/mqttv3/MqttException;
        paramMqttWireMessage.<init>(32202);
        throw paramMqttWireMessage;
      }
    }
    this.log.fine(CLASS_NAME, "send", "615", new Object[] { Integer.valueOf(paramMqttWireMessage.getMessageId()), paramMqttWireMessage });
    if ((paramMqttWireMessage instanceof MqttConnect)) {
      synchronized (this.queueLock)
      {
        this.tokenStore.saveToken(paramMqttToken, paramMqttWireMessage);
        this.pendingFlows.insertElementAt(paramMqttWireMessage, 0);
        this.queueLock.notifyAll();
      }
    }
    if ((paramMqttWireMessage instanceof MqttPingReq))
    {
      this.pingCommand = paramMqttWireMessage;
    }
    else if ((paramMqttWireMessage instanceof MqttPubRel))
    {
      this.outboundQoS2.put(Integer.valueOf(paramMqttWireMessage.getMessageId()), paramMqttWireMessage);
      this.persistence.put(getSendConfirmPersistenceKey(paramMqttWireMessage), (MqttPubRel)paramMqttWireMessage);
    }
    else if ((paramMqttWireMessage instanceof MqttPubComp))
    {
      this.persistence.remove(getReceivedPersistenceKey(paramMqttWireMessage));
    }
    synchronized (this.queueLock)
    {
      if (!(paramMqttWireMessage instanceof MqttAck)) {
        this.tokenStore.saveToken(paramMqttToken, paramMqttWireMessage);
      }
      this.pendingFlows.addElement(paramMqttWireMessage);
      this.queueLock.notifyAll();
      label602:
      return;
    }
  }
  
  protected void setCleanSession(boolean paramBoolean)
  {
    this.cleanSession = paramBoolean;
  }
  
  public void setKeepAliveInterval(long paramLong)
  {
    this.keepAliveNanos = TimeUnit.MILLISECONDS.toNanos(paramLong);
  }
  
  protected void setKeepAliveSecs(long paramLong)
  {
    this.keepAliveNanos = TimeUnit.SECONDS.toNanos(paramLong);
  }
  
  protected void setMaxInflight(int paramInt)
  {
    this.maxInflight = paramInt;
    this.pendingMessages = new Vector(this.maxInflight);
  }
  
  public void unPersistBufferedMessage(MqttWireMessage paramMqttWireMessage)
  {
    try
    {
      this.log.fine(CLASS_NAME, "unPersistBufferedMessage", "517", new Object[] { paramMqttWireMessage.getKey() });
      this.persistence.remove(getSendBufferedPersistenceKey(paramMqttWireMessage));
    }
    catch (MqttPersistenceException localMqttPersistenceException)
    {
      this.log.fine(CLASS_NAME, "unPersistBufferedMessage", "518", new Object[] { paramMqttWireMessage.getKey() });
    }
  }
  
  protected void undo(MqttPublish paramMqttPublish)
    throws MqttPersistenceException
  {
    synchronized (this.queueLock)
    {
      this.log.fine(CLASS_NAME, "undo", "618", new Object[] { Integer.valueOf(paramMqttPublish.getMessageId()), Integer.valueOf(paramMqttPublish.getMessage().getQos()) });
      if (paramMqttPublish.getMessage().getQos() == 1) {
        this.outboundQoS1.remove(Integer.valueOf(paramMqttPublish.getMessageId()));
      } else {
        this.outboundQoS2.remove(Integer.valueOf(paramMqttPublish.getMessageId()));
      }
      this.pendingMessages.removeElement(paramMqttPublish);
      this.persistence.remove(getSendPersistenceKey(paramMqttPublish));
      this.tokenStore.removeToken(paramMqttPublish);
      if (paramMqttPublish.getMessage().getQos() > 0)
      {
        releaseMessageId(paramMqttPublish.getMessageId());
        paramMqttPublish.setMessageId(0);
      }
      checkQuiesceLock();
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\ClientState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */