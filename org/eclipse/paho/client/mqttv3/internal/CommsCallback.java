package org.eclipse.paho.client.mqttv3.internal;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPubComp;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class CommsCallback
  implements Runnable
{
  private static final String CLASS_NAME = CommsCallback.class.getName();
  private static final int INBOUND_QUEUE_SIZE = 10;
  private Future<?> callbackFuture;
  private Thread callbackThread;
  private Hashtable<String, IMqttMessageListener> callbacks;
  private ClientComms clientComms;
  private ClientState clientState;
  private final Vector<MqttToken> completeQueue;
  private State current_state;
  private final Object lifecycle;
  private final Logger log;
  private boolean manualAcks;
  private final Vector<MqttWireMessage> messageQueue;
  private MqttCallback mqttCallback;
  private MqttCallbackExtended reconnectInternalCallback;
  private final Object spaceAvailable;
  private State target_state;
  private String threadName;
  private final Object workAvailable;
  
  CommsCallback(ClientComms paramClientComms)
  {
    Logger localLogger = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
    this.log = localLogger;
    State localState = State.STOPPED;
    this.current_state = localState;
    this.target_state = localState;
    this.lifecycle = new Object();
    this.workAvailable = new Object();
    this.spaceAvailable = new Object();
    this.manualAcks = false;
    this.clientComms = paramClientComms;
    this.messageQueue = new Vector(10);
    this.completeQueue = new Vector(10);
    this.callbacks = new Hashtable();
    localLogger.setResourceName(paramClientComms.getClient().getClientId());
  }
  
  private void handleActionComplete(MqttToken paramMqttToken)
    throws MqttException
  {
    try
    {
      this.log.fine(CLASS_NAME, "handleActionComplete", "705", new Object[] { paramMqttToken.internalTok.getKey() });
      if (paramMqttToken.isComplete()) {
        this.clientState.notifyComplete(paramMqttToken);
      }
      paramMqttToken.internalTok.notifyComplete();
      if (!paramMqttToken.internalTok.isNotified())
      {
        if ((this.mqttCallback != null) && ((paramMqttToken instanceof MqttDeliveryToken)) && (paramMqttToken.isComplete())) {
          this.mqttCallback.deliveryComplete((MqttDeliveryToken)paramMqttToken);
        }
        fireActionEvent(paramMqttToken);
      }
      if ((paramMqttToken.isComplete()) && ((paramMqttToken instanceof MqttDeliveryToken))) {
        paramMqttToken.internalTok.setNotified(true);
      }
      return;
    }
    finally {}
  }
  
  private void handleMessage(MqttPublish paramMqttPublish)
    throws MqttException, Exception
  {
    Object localObject = paramMqttPublish.getTopicName();
    this.log.fine(CLASS_NAME, "handleMessage", "713", new Object[] { Integer.valueOf(paramMqttPublish.getMessageId()), localObject });
    deliverMessage((String)localObject, paramMqttPublish.getMessageId(), paramMqttPublish.getMessage());
    if (!this.manualAcks) {
      if (paramMqttPublish.getMessage().getQos() == 1)
      {
        this.clientComms.internalSend(new MqttPubAck(paramMqttPublish), new MqttToken(this.clientComms.getClient().getClientId()));
      }
      else if (paramMqttPublish.getMessage().getQos() == 2)
      {
        this.clientComms.deliveryComplete(paramMqttPublish);
        paramMqttPublish = new MqttPubComp(paramMqttPublish);
        localObject = this.clientComms;
        ((ClientComms)localObject).internalSend(paramMqttPublish, new MqttToken(((ClientComms)localObject).getClient().getClientId()));
      }
    }
  }
  
  /* Error */
  public void asyncOperationComplete(MqttToken paramMqttToken)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 232	org/eclipse/paho/client/mqttv3/internal/CommsCallback:isRunning	()Z
    //   4: ifeq +65 -> 69
    //   7: aload_0
    //   8: getfield 98	org/eclipse/paho/client/mqttv3/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   11: aload_1
    //   12: invokevirtual 236	java/util/Vector:addElement	(Ljava/lang/Object;)V
    //   15: aload_0
    //   16: getfield 83	org/eclipse/paho/client/mqttv3/internal/CommsCallback:workAvailable	Ljava/lang/Object;
    //   19: astore_2
    //   20: aload_2
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 72	org/eclipse/paho/client/mqttv3/internal/CommsCallback:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   26: getstatic 57	org/eclipse/paho/client/mqttv3/internal/CommsCallback:CLASS_NAME	Ljava/lang/String;
    //   29: ldc -19
    //   31: ldc -17
    //   33: iconst_1
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: getfield 133	org/eclipse/paho/client/mqttv3/MqttToken:internalTok	Lorg/eclipse/paho/client/mqttv3/internal/Token;
    //   43: invokevirtual 138	org/eclipse/paho/client/mqttv3/internal/Token:getKey	()Ljava/lang/String;
    //   46: aastore
    //   47: invokeinterface 142 5 0
    //   52: aload_0
    //   53: getfield 83	org/eclipse/paho/client/mqttv3/internal/CommsCallback:workAvailable	Ljava/lang/Object;
    //   56: invokevirtual 242	java/lang/Object:notifyAll	()V
    //   59: aload_2
    //   60: monitorexit
    //   61: goto +51 -> 112
    //   64: astore_1
    //   65: aload_2
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: aload_0
    //   70: aload_1
    //   71: invokespecial 244	org/eclipse/paho/client/mqttv3/internal/CommsCallback:handleActionComplete	(Lorg/eclipse/paho/client/mqttv3/MqttToken;)V
    //   74: goto +38 -> 112
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 72	org/eclipse/paho/client/mqttv3/internal/CommsCallback:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   82: getstatic 57	org/eclipse/paho/client/mqttv3/internal/CommsCallback:CLASS_NAME	Ljava/lang/String;
    //   85: ldc -19
    //   87: ldc -10
    //   89: aconst_null
    //   90: aload_1
    //   91: invokeinterface 249 6 0
    //   96: aload_0
    //   97: getfield 89	org/eclipse/paho/client/mqttv3/internal/CommsCallback:clientComms	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
    //   100: aconst_null
    //   101: new 124	org/eclipse/paho/client/mqttv3/MqttException
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 252	org/eclipse/paho/client/mqttv3/MqttException:<init>	(Ljava/lang/Throwable;)V
    //   109: invokevirtual 256	org/eclipse/paho/client/mqttv3/internal/ClientComms:shutdownConnection	(Lorg/eclipse/paho/client/mqttv3/MqttToken;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
    //   112: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	CommsCallback
    //   0	113	1	paramMqttToken	MqttToken
    //   19	47	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   22	61	64	finally
    //   65	67	64	finally
    //   69	74	77	finally
  }
  
  public void connectionLost(MqttException paramMqttException)
  {
    try
    {
      if ((this.mqttCallback != null) && (paramMqttException != null))
      {
        this.log.fine(CLASS_NAME, "connectionLost", "708", new Object[] { paramMqttException });
        this.mqttCallback.connectionLost(paramMqttException);
      }
      MqttCallbackExtended localMqttCallbackExtended = this.reconnectInternalCallback;
      if ((localMqttCallbackExtended != null) && (paramMqttException != null)) {
        localMqttCallbackExtended.connectionLost(paramMqttException);
      }
    }
    finally
    {
      this.log.fine(CLASS_NAME, "connectionLost", "720", new Object[] { paramMqttException });
    }
  }
  
  protected boolean deliverMessage(String paramString, int paramInt, MqttMessage paramMqttMessage)
    throws Exception
  {
    Enumeration localEnumeration = this.callbacks.keys();
    boolean bool1 = true;
    for (boolean bool2 = false;; bool2 = true)
    {
      String str;
      IMqttMessageListener localIMqttMessageListener;
      do
      {
        if (!localEnumeration.hasMoreElements())
        {
          if ((this.mqttCallback != null) && (!bool2))
          {
            paramMqttMessage.setId(paramInt);
            this.mqttCallback.messageArrived(paramString, paramMqttMessage);
            bool2 = bool1;
          }
          return bool2;
        }
        str = (String)localEnumeration.nextElement();
        localIMqttMessageListener = (IMqttMessageListener)this.callbacks.get(str);
      } while ((localIMqttMessageListener == null) || (!MqttTopic.isMatched(str, paramString)));
      paramMqttMessage.setId(paramInt);
      localIMqttMessageListener.messageArrived(paramString, paramMqttMessage);
    }
  }
  
  public void fireActionEvent(MqttToken paramMqttToken)
  {
    if (paramMqttToken != null)
    {
      IMqttActionListener localIMqttActionListener = paramMqttToken.getActionCallback();
      if (localIMqttActionListener != null) {
        if (paramMqttToken.getException() == null)
        {
          this.log.fine(CLASS_NAME, "fireActionEvent", "716", new Object[] { paramMqttToken.internalTok.getKey() });
          localIMqttActionListener.onSuccess(paramMqttToken);
        }
        else
        {
          this.log.fine(CLASS_NAME, "fireActionEvent", "716", new Object[] { paramMqttToken.internalTok.getKey() });
          localIMqttActionListener.onFailure(paramMqttToken, paramMqttToken.getException());
        }
      }
    }
  }
  
  protected Thread getThread()
  {
    return this.callbackThread;
  }
  
  public boolean isQuiesced()
  {
    return (isQuiescing()) && (this.completeQueue.size() == 0) && (this.messageQueue.size() == 0);
  }
  
  public boolean isQuiescing()
  {
    synchronized (this.lifecycle)
    {
      boolean bool;
      if (this.current_state == State.QUIESCING) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean isRunning()
  {
    synchronized (this.lifecycle)
    {
      State localState1 = this.current_state;
      State localState2 = State.RUNNING;
      boolean bool;
      if (((localState1 == localState2) || (localState1 == State.QUIESCING)) && (this.target_state == localState2)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void messageArrived(MqttPublish paramMqttPublish)
  {
    if ((this.mqttCallback != null) || (this.callbacks.size() > 0)) {}
    for (;;)
    {
      synchronized (this.spaceAvailable)
      {
        if ((isRunning()) && (!isQuiescing()))
        {
          int i = this.messageQueue.size();
          if (i >= 10) {}
        }
      }
      try
      {
        this.log.fine(CLASS_NAME, "messageArrived", "709");
        this.spaceAvailable.wait(200L);
      }
      catch (InterruptedException localInterruptedException) {}
      if (!isQuiescing())
      {
        this.messageQueue.addElement(paramMqttPublish);
        synchronized (this.workAvailable)
        {
          this.log.fine(CLASS_NAME, "messageArrived", "710");
          this.workAvailable.notifyAll();
        }
      }
      return;
      paramMqttPublish = finally;
      throw paramMqttPublish;
    }
  }
  
  public void messageArrivedComplete(int paramInt1, int paramInt2)
    throws MqttException
  {
    if (paramInt2 == 1)
    {
      this.clientComms.internalSend(new MqttPubAck(paramInt1), new MqttToken(this.clientComms.getClient().getClientId()));
    }
    else if (paramInt2 == 2)
    {
      this.clientComms.deliveryComplete(paramInt1);
      MqttPubComp localMqttPubComp = new MqttPubComp(paramInt1);
      ClientComms localClientComms = this.clientComms;
      localClientComms.internalSend(localMqttPubComp, new MqttToken(localClientComms.getClient().getClientId()));
    }
  }
  
  public void quiesce()
  {
    synchronized (this.lifecycle)
    {
      if (this.current_state == State.RUNNING) {
        this.current_state = State.QUIESCING;
      }
      synchronized (this.spaceAvailable)
      {
        this.log.fine(CLASS_NAME, "quiesce", "711");
        this.spaceAvailable.notifyAll();
        return;
      }
    }
  }
  
  public void removeMessageListener(String paramString)
  {
    this.callbacks.remove(paramString);
  }
  
  public void removeMessageListeners()
  {
    this.callbacks.clear();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 381	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: astore_1
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 327	org/eclipse/paho/client/mqttv3/internal/CommsCallback:callbackThread	Ljava/lang/Thread;
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 383	org/eclipse/paho/client/mqttv3/internal/CommsCallback:threadName	Ljava/lang/String;
    //   14: invokevirtual 386	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 81	org/eclipse/paho/client/mqttv3/internal/CommsCallback:lifecycle	Ljava/lang/Object;
    //   21: astore_2
    //   22: aload_2
    //   23: monitorenter
    //   24: aload_0
    //   25: getstatic 340	org/eclipse/paho/client/mqttv3/internal/CommsCallback$State:RUNNING	Lorg/eclipse/paho/client/mqttv3/internal/CommsCallback$State;
    //   28: putfield 77	org/eclipse/paho/client/mqttv3/internal/CommsCallback:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsCallback$State;
    //   31: aload_2
    //   32: monitorexit
    //   33: aload_0
    //   34: invokevirtual 232	org/eclipse/paho/client/mqttv3/internal/CommsCallback:isRunning	()Z
    //   37: ifne +30 -> 67
    //   40: aload_0
    //   41: getfield 81	org/eclipse/paho/client/mqttv3/internal/CommsCallback:lifecycle	Ljava/lang/Object;
    //   44: astore_2
    //   45: aload_2
    //   46: monitorenter
    //   47: aload_0
    //   48: getstatic 75	org/eclipse/paho/client/mqttv3/internal/CommsCallback$State:STOPPED	Lorg/eclipse/paho/client/mqttv3/internal/CommsCallback$State;
    //   51: putfield 77	org/eclipse/paho/client/mqttv3/internal/CommsCallback:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsCallback$State;
    //   54: aload_2
    //   55: monitorexit
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 327	org/eclipse/paho/client/mqttv3/internal/CommsCallback:callbackThread	Ljava/lang/Thread;
    //   61: return
    //   62: astore_1
    //   63: aload_2
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: aload_0
    //   68: getfield 83	org/eclipse/paho/client/mqttv3/internal/CommsCallback:workAvailable	Ljava/lang/Object;
    //   71: astore_1
    //   72: aload_1
    //   73: monitorenter
    //   74: aload_0
    //   75: invokevirtual 232	org/eclipse/paho/client/mqttv3/internal/CommsCallback:isRunning	()Z
    //   78: ifeq +48 -> 126
    //   81: aload_0
    //   82: getfield 96	org/eclipse/paho/client/mqttv3/internal/CommsCallback:messageQueue	Ljava/util/Vector;
    //   85: invokevirtual 389	java/util/Vector:isEmpty	()Z
    //   88: ifeq +38 -> 126
    //   91: aload_0
    //   92: getfield 98	org/eclipse/paho/client/mqttv3/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   95: invokevirtual 389	java/util/Vector:isEmpty	()Z
    //   98: ifeq +28 -> 126
    //   101: aload_0
    //   102: getfield 72	org/eclipse/paho/client/mqttv3/internal/CommsCallback:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   105: getstatic 57	org/eclipse/paho/client/mqttv3/internal/CommsCallback:CLASS_NAME	Ljava/lang/String;
    //   108: ldc_w 390
    //   111: ldc_w 392
    //   114: invokeinterface 349 4 0
    //   119: aload_0
    //   120: getfield 83	org/eclipse/paho/client/mqttv3/internal/CommsCallback:workAvailable	Ljava/lang/Object;
    //   123: invokevirtual 394	java/lang/Object:wait	()V
    //   126: aload_1
    //   127: monitorexit
    //   128: goto +12 -> 140
    //   131: astore_2
    //   132: aload_1
    //   133: monitorexit
    //   134: aload_2
    //   135: athrow
    //   136: astore_2
    //   137: goto +186 -> 323
    //   140: aload_0
    //   141: invokevirtual 232	org/eclipse/paho/client/mqttv3/internal/CommsCallback:isRunning	()Z
    //   144: ifeq +122 -> 266
    //   147: aload_0
    //   148: getfield 98	org/eclipse/paho/client/mqttv3/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   151: astore_2
    //   152: aload_2
    //   153: monitorenter
    //   154: aload_0
    //   155: getfield 98	org/eclipse/paho/client/mqttv3/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   158: invokevirtual 389	java/util/Vector:isEmpty	()Z
    //   161: ifne +26 -> 187
    //   164: aload_0
    //   165: getfield 98	org/eclipse/paho/client/mqttv3/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   168: iconst_0
    //   169: invokevirtual 398	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   172: checkcast 129	org/eclipse/paho/client/mqttv3/MqttToken
    //   175: astore_1
    //   176: aload_0
    //   177: getfield 98	org/eclipse/paho/client/mqttv3/internal/CommsCallback:completeQueue	Ljava/util/Vector;
    //   180: iconst_0
    //   181: invokevirtual 401	java/util/Vector:removeElementAt	(I)V
    //   184: goto +5 -> 189
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_2
    //   190: monitorexit
    //   191: aload_1
    //   192: ifnull +8 -> 200
    //   195: aload_0
    //   196: aload_1
    //   197: invokespecial 244	org/eclipse/paho/client/mqttv3/internal/CommsCallback:handleActionComplete	(Lorg/eclipse/paho/client/mqttv3/MqttToken;)V
    //   200: aload_0
    //   201: getfield 96	org/eclipse/paho/client/mqttv3/internal/CommsCallback:messageQueue	Ljava/util/Vector;
    //   204: astore_2
    //   205: aload_2
    //   206: monitorenter
    //   207: aload_0
    //   208: getfield 96	org/eclipse/paho/client/mqttv3/internal/CommsCallback:messageQueue	Ljava/util/Vector;
    //   211: invokevirtual 389	java/util/Vector:isEmpty	()Z
    //   214: ifne +26 -> 240
    //   217: aload_0
    //   218: getfield 96	org/eclipse/paho/client/mqttv3/internal/CommsCallback:messageQueue	Ljava/util/Vector;
    //   221: iconst_0
    //   222: invokevirtual 398	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   225: checkcast 182	org/eclipse/paho/client/mqttv3/internal/wire/MqttPublish
    //   228: astore_1
    //   229: aload_0
    //   230: getfield 96	org/eclipse/paho/client/mqttv3/internal/CommsCallback:messageQueue	Ljava/util/Vector;
    //   233: iconst_0
    //   234: invokevirtual 401	java/util/Vector:removeElementAt	(I)V
    //   237: goto +5 -> 242
    //   240: aconst_null
    //   241: astore_1
    //   242: aload_2
    //   243: monitorexit
    //   244: aload_1
    //   245: ifnull +21 -> 266
    //   248: aload_0
    //   249: aload_1
    //   250: invokespecial 403	org/eclipse/paho/client/mqttv3/internal/CommsCallback:handleMessage	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttPublish;)V
    //   253: goto +13 -> 266
    //   256: astore_1
    //   257: aload_2
    //   258: monitorexit
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: aload_2
    //   263: monitorexit
    //   264: aload_1
    //   265: athrow
    //   266: aload_0
    //   267: invokevirtual 331	org/eclipse/paho/client/mqttv3/internal/CommsCallback:isQuiescing	()Z
    //   270: ifeq +11 -> 281
    //   273: aload_0
    //   274: getfield 148	org/eclipse/paho/client/mqttv3/internal/CommsCallback:clientState	Lorg/eclipse/paho/client/mqttv3/internal/ClientState;
    //   277: invokevirtual 406	org/eclipse/paho/client/mqttv3/internal/ClientState:checkQuiesceLock	()Z
    //   280: pop
    //   281: aload_0
    //   282: getfield 85	org/eclipse/paho/client/mqttv3/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   285: astore_1
    //   286: aload_1
    //   287: monitorenter
    //   288: aload_0
    //   289: getfield 72	org/eclipse/paho/client/mqttv3/internal/CommsCallback:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   292: getstatic 57	org/eclipse/paho/client/mqttv3/internal/CommsCallback:CLASS_NAME	Ljava/lang/String;
    //   295: ldc_w 390
    //   298: ldc_w 408
    //   301: invokeinterface 349 4 0
    //   306: aload_0
    //   307: getfield 85	org/eclipse/paho/client/mqttv3/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   310: invokevirtual 242	java/lang/Object:notifyAll	()V
    //   313: aload_1
    //   314: monitorexit
    //   315: goto -282 -> 33
    //   318: astore_2
    //   319: aload_1
    //   320: monitorexit
    //   321: aload_2
    //   322: athrow
    //   323: aload_0
    //   324: getfield 72	org/eclipse/paho/client/mqttv3/internal/CommsCallback:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   327: astore_3
    //   328: getstatic 57	org/eclipse/paho/client/mqttv3/internal/CommsCallback:CLASS_NAME	Ljava/lang/String;
    //   331: astore_1
    //   332: aload_3
    //   333: aload_1
    //   334: ldc_w 390
    //   337: ldc_w 410
    //   340: aconst_null
    //   341: aload_2
    //   342: invokeinterface 249 6 0
    //   347: aload_0
    //   348: getfield 89	org/eclipse/paho/client/mqttv3/internal/CommsCallback:clientComms	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
    //   351: astore 4
    //   353: new 124	org/eclipse/paho/client/mqttv3/MqttException
    //   356: astore_3
    //   357: aload_3
    //   358: aload_2
    //   359: invokespecial 252	org/eclipse/paho/client/mqttv3/MqttException:<init>	(Ljava/lang/Throwable;)V
    //   362: aload 4
    //   364: aconst_null
    //   365: aload_3
    //   366: invokevirtual 256	org/eclipse/paho/client/mqttv3/internal/ClientComms:shutdownConnection	(Lorg/eclipse/paho/client/mqttv3/MqttToken;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
    //   369: aload_0
    //   370: getfield 85	org/eclipse/paho/client/mqttv3/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   373: astore_2
    //   374: aload_2
    //   375: monitorenter
    //   376: aload_0
    //   377: getfield 72	org/eclipse/paho/client/mqttv3/internal/CommsCallback:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   380: aload_1
    //   381: ldc_w 390
    //   384: ldc_w 408
    //   387: invokeinterface 349 4 0
    //   392: aload_0
    //   393: getfield 85	org/eclipse/paho/client/mqttv3/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   396: invokevirtual 242	java/lang/Object:notifyAll	()V
    //   399: aload_2
    //   400: monitorexit
    //   401: goto -368 -> 33
    //   404: astore_1
    //   405: aload_2
    //   406: monitorexit
    //   407: aload_1
    //   408: athrow
    //   409: astore_2
    //   410: aload_0
    //   411: getfield 85	org/eclipse/paho/client/mqttv3/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   414: astore_1
    //   415: aload_1
    //   416: monitorenter
    //   417: aload_0
    //   418: getfield 72	org/eclipse/paho/client/mqttv3/internal/CommsCallback:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   421: getstatic 57	org/eclipse/paho/client/mqttv3/internal/CommsCallback:CLASS_NAME	Ljava/lang/String;
    //   424: ldc_w 390
    //   427: ldc_w 408
    //   430: invokeinterface 349 4 0
    //   435: aload_0
    //   436: getfield 85	org/eclipse/paho/client/mqttv3/internal/CommsCallback:spaceAvailable	Ljava/lang/Object;
    //   439: invokevirtual 242	java/lang/Object:notifyAll	()V
    //   442: aload_1
    //   443: monitorexit
    //   444: aload_2
    //   445: athrow
    //   446: astore_2
    //   447: aload_1
    //   448: monitorexit
    //   449: aload_2
    //   450: athrow
    //   451: astore_1
    //   452: aload_2
    //   453: monitorexit
    //   454: aload_1
    //   455: athrow
    //   456: astore_1
    //   457: goto -317 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	CommsCallback
    //   3	7	1	localThread	Thread
    //   62	4	1	localObject1	Object
    //   71	179	1	localObject2	Object
    //   256	4	1	localObject3	Object
    //   261	4	1	localObject4	Object
    //   285	96	1	localObject5	Object
    //   404	4	1	localObject6	Object
    //   451	4	1	localObject8	Object
    //   456	1	1	localInterruptedException	InterruptedException
    //   21	43	2	localObject9	Object
    //   131	4	2	localObject10	Object
    //   136	1	2	localObject11	Object
    //   151	112	2	localVector	Vector
    //   318	41	2	localThrowable	Throwable
    //   409	36	2	localObject13	Object
    //   446	7	2	localObject14	Object
    //   327	39	3	localObject15	Object
    //   351	12	4	localClientComms	ClientComms
    // Exception table:
    //   from	to	target	type
    //   47	56	62	finally
    //   63	65	62	finally
    //   74	126	131	finally
    //   126	128	131	finally
    //   132	134	131	finally
    //   67	74	136	finally
    //   134	136	136	finally
    //   140	154	136	finally
    //   195	200	136	finally
    //   200	207	136	finally
    //   248	253	136	finally
    //   259	261	136	finally
    //   264	266	136	finally
    //   266	281	136	finally
    //   207	237	256	finally
    //   242	244	256	finally
    //   257	259	256	finally
    //   154	184	261	finally
    //   189	191	261	finally
    //   262	264	261	finally
    //   288	315	318	finally
    //   319	321	318	finally
    //   376	401	404	finally
    //   405	407	404	finally
    //   323	369	409	finally
    //   417	444	446	finally
    //   447	449	446	finally
    //   24	33	451	finally
    //   452	454	451	finally
    //   67	74	456	java/lang/InterruptedException
    //   134	136	456	java/lang/InterruptedException
  }
  
  public void setCallback(MqttCallback paramMqttCallback)
  {
    this.mqttCallback = paramMqttCallback;
  }
  
  public void setClientState(ClientState paramClientState)
  {
    this.clientState = paramClientState;
  }
  
  public void setManualAcks(boolean paramBoolean)
  {
    this.manualAcks = paramBoolean;
  }
  
  public void setMessageListener(String paramString, IMqttMessageListener paramIMqttMessageListener)
  {
    this.callbacks.put(paramString, paramIMqttMessageListener);
  }
  
  public void setReconnectCallback(MqttCallbackExtended paramMqttCallbackExtended)
  {
    this.reconnectInternalCallback = paramMqttCallbackExtended;
  }
  
  public void start(String arg1, ExecutorService paramExecutorService)
  {
    this.threadName = ???;
    synchronized (this.lifecycle)
    {
      if (this.current_state == State.STOPPED)
      {
        this.messageQueue.clear();
        this.completeQueue.clear();
        this.target_state = State.RUNNING;
        if (paramExecutorService == null)
        {
          paramExecutorService = new java/lang/Thread;
          paramExecutorService.<init>(this);
          paramExecutorService.start();
        }
        else
        {
          this.callbackFuture = paramExecutorService.submit(this);
        }
      }
      for (;;)
      {
        if (isRunning()) {
          return;
        }
        try
        {
          Thread.sleep(100L);
        }
        catch (Exception ???) {}
      }
    }
  }
  
  public void stop()
  {
    for (;;)
    {
      synchronized (this.lifecycle)
      {
        ??? = this.callbackFuture;
        if (??? != null) {
          ((Future)???).cancel(true);
        }
        if (isRunning())
        {
          ??? = this.log;
          ??? = CLASS_NAME;
          ((Logger)???).fine((String)???, "stop", "700");
          synchronized (this.lifecycle)
          {
            this.target_state = State.STOPPED;
            if (!Thread.currentThread().equals(this.callbackThread)) {
              synchronized (this.workAvailable)
              {
                this.log.fine((String)???, "stop", "701");
                this.workAvailable.notifyAll();
                if (isRunning()) {}
              }
            }
          }
        }
      }
      try
      {
        Thread.sleep(100L);
        this.clientState.notifyQueueLock();
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
        this.log.fine(CLASS_NAME, "stop", "703");
        break label173;
        localObject3 = finally;
        throw ((Throwable)localObject3);
        label173:
        return;
        localObject5 = finally;
        throw ((Throwable)localObject5);
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("STOPPED", 0);
      STOPPED = localState1;
      State localState2 = new State("RUNNING", 1);
      RUNNING = localState2;
      State localState3 = new State("QUIESCING", 2);
      QUIESCING = localState3;
      ENUM$VALUES = new State[] { localState1, localState2, localState3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\CommsCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */