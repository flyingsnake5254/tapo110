package org.eclipse.paho.client.mqttv3.internal;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttInputStream;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class CommsReceiver
  implements Runnable
{
  private static final String CLASS_NAME = CommsReceiver.class.getName();
  private ClientComms clientComms;
  private ClientState clientState;
  private State current_state;
  private MqttInputStream in;
  private final Object lifecycle;
  private Logger log = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
  private Thread recThread;
  private Future<?> receiverFuture;
  private State target_state;
  private String threadName;
  private CommsTokenStore tokenStore;
  
  public CommsReceiver(ClientComms paramClientComms, ClientState paramClientState, CommsTokenStore paramCommsTokenStore, InputStream paramInputStream)
  {
    State localState = State.STOPPED;
    this.current_state = localState;
    this.target_state = localState;
    this.lifecycle = new Object();
    this.clientState = null;
    this.clientComms = null;
    this.tokenStore = null;
    this.recThread = null;
    this.in = new MqttInputStream(paramClientState, paramInputStream);
    this.clientComms = paramClientComms;
    this.clientState = paramClientState;
    this.tokenStore = paramCommsTokenStore;
    this.log.setResourceName(paramClientComms.getClient().getClientId());
  }
  
  public boolean isReceiving()
  {
    synchronized (this.lifecycle)
    {
      boolean bool;
      if (this.current_state == State.RECEIVING) {
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
      if (((localState1 == localState2) || (localState1 == State.RECEIVING)) && (this.target_state == localState2)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 118	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: astore_1
    //   4: aload_0
    //   5: aload_1
    //   6: putfield 74	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:recThread	Ljava/lang/Thread;
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 120	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:threadName	Ljava/lang/String;
    //   14: invokevirtual 123	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   21: astore_1
    //   22: aload_1
    //   23: monitorenter
    //   24: aload_0
    //   25: getstatic 107	org/eclipse/paho/client/mqttv3/internal/CommsReceiver$State:RUNNING	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   28: putfield 62	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   31: aload_1
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   37: astore_1
    //   38: aload_1
    //   39: monitorenter
    //   40: aload_0
    //   41: getfield 64	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:target_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   44: astore_2
    //   45: aload_1
    //   46: monitorexit
    //   47: aconst_null
    //   48: astore_1
    //   49: getstatic 107	org/eclipse/paho/client/mqttv3/internal/CommsReceiver$State:RUNNING	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   52: astore_3
    //   53: aload_2
    //   54: aload_3
    //   55: if_acmpne +709 -> 764
    //   58: aload_0
    //   59: getfield 81	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:in	Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttInputStream;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnonnull +6 -> 70
    //   67: goto +697 -> 764
    //   70: aload_1
    //   71: astore_2
    //   72: aload_1
    //   73: astore 4
    //   75: aload_0
    //   76: getfield 57	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   79: astore 5
    //   81: aload_1
    //   82: astore_2
    //   83: aload_1
    //   84: astore 4
    //   86: getstatic 42	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:CLASS_NAME	Ljava/lang/String;
    //   89: astore 6
    //   91: aload_1
    //   92: astore_2
    //   93: aload_1
    //   94: astore 4
    //   96: aload 5
    //   98: aload 6
    //   100: ldc 124
    //   102: ldc 126
    //   104: invokeinterface 130 4 0
    //   109: aload_1
    //   110: astore_2
    //   111: aload_1
    //   112: astore 4
    //   114: aload_0
    //   115: getfield 81	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:in	Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttInputStream;
    //   118: invokevirtual 134	org/eclipse/paho/client/mqttv3/internal/wire/MqttInputStream:available	()I
    //   121: ifle +48 -> 169
    //   124: aload_1
    //   125: astore_2
    //   126: aload_1
    //   127: astore 4
    //   129: aload_0
    //   130: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   133: astore 5
    //   135: aload_1
    //   136: astore_2
    //   137: aload_1
    //   138: astore 4
    //   140: aload 5
    //   142: monitorenter
    //   143: aload_0
    //   144: getstatic 103	org/eclipse/paho/client/mqttv3/internal/CommsReceiver$State:RECEIVING	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   147: putfield 62	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   150: aload 5
    //   152: monitorexit
    //   153: goto +16 -> 169
    //   156: astore 6
    //   158: aload 5
    //   160: monitorexit
    //   161: aload_1
    //   162: astore_2
    //   163: aload_1
    //   164: astore 4
    //   166: aload 6
    //   168: athrow
    //   169: aload_1
    //   170: astore_2
    //   171: aload_1
    //   172: astore 4
    //   174: aload_0
    //   175: getfield 81	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:in	Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttInputStream;
    //   178: invokevirtual 138	org/eclipse/paho/client/mqttv3/internal/wire/MqttInputStream:readMqttWireMessage	()Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;
    //   181: astore 5
    //   183: aload_1
    //   184: astore_2
    //   185: aload_1
    //   186: astore 4
    //   188: aload_0
    //   189: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   192: astore 7
    //   194: aload_1
    //   195: astore_2
    //   196: aload_1
    //   197: astore 4
    //   199: aload 7
    //   201: monitorenter
    //   202: aload_0
    //   203: aload_3
    //   204: putfield 62	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   207: aload 7
    //   209: monitorexit
    //   210: aload_1
    //   211: astore_2
    //   212: aload_1
    //   213: astore 4
    //   215: aload 5
    //   217: instanceof 140
    //   220: ifeq +159 -> 379
    //   223: aload_1
    //   224: astore_2
    //   225: aload_1
    //   226: astore 4
    //   228: aload_0
    //   229: getfield 72	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:tokenStore	Lorg/eclipse/paho/client/mqttv3/internal/CommsTokenStore;
    //   232: aload 5
    //   234: invokevirtual 146	org/eclipse/paho/client/mqttv3/internal/CommsTokenStore:getToken	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;)Lorg/eclipse/paho/client/mqttv3/MqttToken;
    //   237: astore_1
    //   238: aload_1
    //   239: ifnull +42 -> 281
    //   242: aload_1
    //   243: astore_2
    //   244: aload_1
    //   245: astore 4
    //   247: aload_1
    //   248: monitorenter
    //   249: aload_0
    //   250: getfield 68	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:clientState	Lorg/eclipse/paho/client/mqttv3/internal/ClientState;
    //   253: aload 5
    //   255: checkcast 140	org/eclipse/paho/client/mqttv3/internal/wire/MqttAck
    //   258: invokevirtual 152	org/eclipse/paho/client/mqttv3/internal/ClientState:notifyReceivedAck	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttAck;)V
    //   261: aload_1
    //   262: monitorexit
    //   263: aload_1
    //   264: astore 6
    //   266: goto +207 -> 473
    //   269: astore 6
    //   271: aload_1
    //   272: monitorexit
    //   273: aload_1
    //   274: astore_2
    //   275: aload_1
    //   276: astore 4
    //   278: aload 6
    //   280: athrow
    //   281: aload_1
    //   282: astore_2
    //   283: aload_1
    //   284: astore 4
    //   286: aload 5
    //   288: instanceof 154
    //   291: ifne +62 -> 353
    //   294: aload_1
    //   295: astore_2
    //   296: aload_1
    //   297: astore 4
    //   299: aload 5
    //   301: instanceof 156
    //   304: ifne +49 -> 353
    //   307: aload_1
    //   308: astore_2
    //   309: aload_1
    //   310: astore 4
    //   312: aload 5
    //   314: instanceof 158
    //   317: ifeq +6 -> 323
    //   320: goto +33 -> 353
    //   323: aload_1
    //   324: astore_2
    //   325: aload_1
    //   326: astore 4
    //   328: new 110	org/eclipse/paho/client/mqttv3/MqttException
    //   331: astore 6
    //   333: aload_1
    //   334: astore_2
    //   335: aload_1
    //   336: astore 4
    //   338: aload 6
    //   340: bipush 6
    //   342: invokespecial 161	org/eclipse/paho/client/mqttv3/MqttException:<init>	(I)V
    //   345: aload_1
    //   346: astore_2
    //   347: aload_1
    //   348: astore 4
    //   350: aload 6
    //   352: athrow
    //   353: aload_1
    //   354: astore_2
    //   355: aload_1
    //   356: astore 4
    //   358: aload_0
    //   359: getfield 57	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   362: aload 6
    //   364: ldc 124
    //   366: ldc -93
    //   368: invokeinterface 130 4 0
    //   373: aload_1
    //   374: astore 6
    //   376: goto +97 -> 473
    //   379: aload 5
    //   381: ifnull +23 -> 404
    //   384: aload_1
    //   385: astore_2
    //   386: aload_1
    //   387: astore 4
    //   389: aload_0
    //   390: getfield 68	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:clientState	Lorg/eclipse/paho/client/mqttv3/internal/ClientState;
    //   393: aload 5
    //   395: invokevirtual 167	org/eclipse/paho/client/mqttv3/internal/ClientState:notifyReceivedMsg	(Lorg/eclipse/paho/client/mqttv3/internal/wire/MqttWireMessage;)V
    //   398: aload_1
    //   399: astore 6
    //   401: goto +72 -> 473
    //   404: aload_1
    //   405: astore 6
    //   407: aload_1
    //   408: astore_2
    //   409: aload_1
    //   410: astore 4
    //   412: aload_0
    //   413: getfield 70	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:clientComms	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
    //   416: invokevirtual 170	org/eclipse/paho/client/mqttv3/internal/ClientComms:isConnected	()Z
    //   419: ifne +54 -> 473
    //   422: aload_1
    //   423: astore_2
    //   424: aload_1
    //   425: astore 4
    //   427: aload_0
    //   428: getfield 70	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:clientComms	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
    //   431: invokevirtual 173	org/eclipse/paho/client/mqttv3/internal/ClientComms:isConnecting	()Z
    //   434: ifeq +9 -> 443
    //   437: aload_1
    //   438: astore 6
    //   440: goto +33 -> 473
    //   443: aload_1
    //   444: astore_2
    //   445: aload_1
    //   446: astore 4
    //   448: new 112	java/io/IOException
    //   451: astore 6
    //   453: aload_1
    //   454: astore_2
    //   455: aload_1
    //   456: astore 4
    //   458: aload 6
    //   460: ldc -81
    //   462: invokespecial 177	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   465: aload_1
    //   466: astore_2
    //   467: aload_1
    //   468: astore 4
    //   470: aload 6
    //   472: athrow
    //   473: aload_0
    //   474: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   477: astore_1
    //   478: aload_1
    //   479: monitorenter
    //   480: aload_0
    //   481: aload_3
    //   482: putfield 62	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   485: aload_1
    //   486: monitorexit
    //   487: aload 6
    //   489: astore_1
    //   490: goto +215 -> 705
    //   493: astore_2
    //   494: aload_1
    //   495: monitorexit
    //   496: aload_2
    //   497: athrow
    //   498: astore 6
    //   500: aload 7
    //   502: monitorexit
    //   503: aload_1
    //   504: astore_2
    //   505: aload_1
    //   506: astore 4
    //   508: aload 6
    //   510: athrow
    //   511: astore_2
    //   512: goto +229 -> 741
    //   515: astore_1
    //   516: aload_0
    //   517: getfield 57	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   520: getstatic 42	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:CLASS_NAME	Ljava/lang/String;
    //   523: ldc 124
    //   525: ldc -77
    //   527: invokeinterface 130 4 0
    //   532: aload_0
    //   533: getfield 64	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:target_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   536: astore 6
    //   538: getstatic 60	org/eclipse/paho/client/mqttv3/internal/CommsReceiver$State:STOPPED	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   541: astore 4
    //   543: aload 6
    //   545: aload 4
    //   547: if_acmpeq +68 -> 615
    //   550: aload_0
    //   551: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   554: astore 6
    //   556: aload 6
    //   558: monitorenter
    //   559: aload_0
    //   560: aload 4
    //   562: putfield 64	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:target_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   565: aload 6
    //   567: monitorexit
    //   568: aload_0
    //   569: getfield 70	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:clientComms	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
    //   572: invokevirtual 182	org/eclipse/paho/client/mqttv3/internal/ClientComms:isDisconnecting	()Z
    //   575: ifne +40 -> 615
    //   578: aload_0
    //   579: getfield 70	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:clientComms	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
    //   582: astore 4
    //   584: new 110	org/eclipse/paho/client/mqttv3/MqttException
    //   587: astore 6
    //   589: aload 6
    //   591: sipush 32109
    //   594: aload_1
    //   595: invokespecial 185	org/eclipse/paho/client/mqttv3/MqttException:<init>	(ILjava/lang/Throwable;)V
    //   598: aload 4
    //   600: aload_2
    //   601: aload 6
    //   603: invokevirtual 189	org/eclipse/paho/client/mqttv3/internal/ClientComms:shutdownConnection	(Lorg/eclipse/paho/client/mqttv3/MqttToken;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
    //   606: goto +9 -> 615
    //   609: astore_1
    //   610: aload 6
    //   612: monitorexit
    //   613: aload_1
    //   614: athrow
    //   615: aload_0
    //   616: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   619: astore_1
    //   620: aload_1
    //   621: monitorenter
    //   622: aload_0
    //   623: getstatic 107	org/eclipse/paho/client/mqttv3/internal/CommsReceiver$State:RUNNING	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   626: putfield 62	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   629: aload_1
    //   630: monitorexit
    //   631: aload_2
    //   632: astore_1
    //   633: goto +72 -> 705
    //   636: astore_2
    //   637: aload_1
    //   638: monitorexit
    //   639: aload_2
    //   640: athrow
    //   641: astore_2
    //   642: aload_0
    //   643: getfield 57	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   646: getstatic 42	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:CLASS_NAME	Ljava/lang/String;
    //   649: ldc 124
    //   651: ldc -65
    //   653: aconst_null
    //   654: aload_2
    //   655: invokeinterface 194 6 0
    //   660: aload_0
    //   661: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   664: astore_1
    //   665: aload_1
    //   666: monitorenter
    //   667: aload_0
    //   668: getstatic 60	org/eclipse/paho/client/mqttv3/internal/CommsReceiver$State:STOPPED	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   671: putfield 64	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:target_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   674: aload_1
    //   675: monitorexit
    //   676: aload_0
    //   677: getfield 70	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:clientComms	Lorg/eclipse/paho/client/mqttv3/internal/ClientComms;
    //   680: aload 4
    //   682: aload_2
    //   683: invokevirtual 189	org/eclipse/paho/client/mqttv3/internal/ClientComms:shutdownConnection	(Lorg/eclipse/paho/client/mqttv3/MqttToken;Lorg/eclipse/paho/client/mqttv3/MqttException;)V
    //   686: aload_0
    //   687: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   690: astore_1
    //   691: aload_1
    //   692: monitorenter
    //   693: aload_0
    //   694: getstatic 107	org/eclipse/paho/client/mqttv3/internal/CommsReceiver$State:RUNNING	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   697: putfield 62	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   700: aload_1
    //   701: monitorexit
    //   702: aload 4
    //   704: astore_1
    //   705: aload_0
    //   706: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   709: astore 4
    //   711: aload 4
    //   713: monitorenter
    //   714: aload_0
    //   715: getfield 64	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:target_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   718: astore_2
    //   719: aload 4
    //   721: monitorexit
    //   722: goto -673 -> 49
    //   725: astore_1
    //   726: aload 4
    //   728: monitorexit
    //   729: aload_1
    //   730: athrow
    //   731: astore_2
    //   732: aload_1
    //   733: monitorexit
    //   734: aload_2
    //   735: athrow
    //   736: astore_2
    //   737: aload_1
    //   738: monitorexit
    //   739: aload_2
    //   740: athrow
    //   741: aload_0
    //   742: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   745: astore_1
    //   746: aload_1
    //   747: monitorenter
    //   748: aload_0
    //   749: getstatic 107	org/eclipse/paho/client/mqttv3/internal/CommsReceiver$State:RUNNING	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   752: putfield 62	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   755: aload_1
    //   756: monitorexit
    //   757: aload_2
    //   758: athrow
    //   759: astore_2
    //   760: aload_1
    //   761: monitorexit
    //   762: aload_2
    //   763: athrow
    //   764: aload_0
    //   765: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   768: astore_1
    //   769: aload_1
    //   770: monitorenter
    //   771: aload_0
    //   772: getstatic 60	org/eclipse/paho/client/mqttv3/internal/CommsReceiver$State:STOPPED	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   775: putfield 62	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   778: aload_1
    //   779: monitorexit
    //   780: aload_0
    //   781: aconst_null
    //   782: putfield 74	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:recThread	Ljava/lang/Thread;
    //   785: aload_0
    //   786: getfield 57	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:log	Lorg/eclipse/paho/client/mqttv3/logging/Logger;
    //   789: getstatic 42	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:CLASS_NAME	Ljava/lang/String;
    //   792: ldc 124
    //   794: ldc -60
    //   796: invokeinterface 130 4 0
    //   801: return
    //   802: astore_2
    //   803: aload_1
    //   804: monitorexit
    //   805: aload_2
    //   806: athrow
    //   807: astore_2
    //   808: aload_1
    //   809: monitorexit
    //   810: aload_2
    //   811: athrow
    //   812: astore_2
    //   813: aload_0
    //   814: getfield 66	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:lifecycle	Ljava/lang/Object;
    //   817: astore_1
    //   818: aload_1
    //   819: monitorenter
    //   820: aload_0
    //   821: getstatic 60	org/eclipse/paho/client/mqttv3/internal/CommsReceiver$State:STOPPED	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   824: putfield 62	org/eclipse/paho/client/mqttv3/internal/CommsReceiver:current_state	Lorg/eclipse/paho/client/mqttv3/internal/CommsReceiver$State;
    //   827: aload_1
    //   828: monitorexit
    //   829: aload_2
    //   830: athrow
    //   831: astore_2
    //   832: aload_1
    //   833: monitorexit
    //   834: aload_2
    //   835: athrow
    //   836: astore_2
    //   837: aload_1
    //   838: monitorexit
    //   839: aload_2
    //   840: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	841	0	this	CommsReceiver
    //   515	80	1	localIOException	java.io.IOException
    //   609	5	1	localObject2	Object
    //   725	13	1	localObject4	Object
    //   44	423	2	localObject6	Object
    //   493	4	2	localObject7	Object
    //   504	1	2	localObject8	Object
    //   511	121	2	localMqttToken	org.eclipse.paho.client.mqttv3.MqttToken
    //   636	4	2	localObject9	Object
    //   641	42	2	localMqttException	org.eclipse.paho.client.mqttv3.MqttException
    //   718	1	2	localState1	State
    //   731	4	2	localObject10	Object
    //   736	22	2	localObject11	Object
    //   759	4	2	localObject12	Object
    //   802	4	2	localObject13	Object
    //   807	4	2	localObject14	Object
    //   812	18	2	localObject15	Object
    //   831	4	2	localObject16	Object
    //   836	4	2	localObject17	Object
    //   52	430	3	localState2	State
    //   79	315	5	localObject19	Object
    //   89	10	6	str	String
    //   156	11	6	localObject20	Object
    //   264	1	6	localObject21	Object
    //   269	10	6	localObject22	Object
    //   331	157	6	localObject23	Object
    //   498	11	6	localObject24	Object
    //   192	309	7	localObject26	Object
    // Exception table:
    //   from	to	target	type
    //   143	153	156	finally
    //   158	161	156	finally
    //   249	263	269	finally
    //   271	273	269	finally
    //   480	487	493	finally
    //   494	496	493	finally
    //   202	210	498	finally
    //   500	503	498	finally
    //   75	81	511	finally
    //   86	91	511	finally
    //   96	109	511	finally
    //   114	124	511	finally
    //   129	135	511	finally
    //   140	143	511	finally
    //   166	169	511	finally
    //   174	183	511	finally
    //   188	194	511	finally
    //   199	202	511	finally
    //   215	223	511	finally
    //   228	238	511	finally
    //   247	249	511	finally
    //   278	281	511	finally
    //   286	294	511	finally
    //   299	307	511	finally
    //   312	320	511	finally
    //   328	333	511	finally
    //   338	345	511	finally
    //   350	353	511	finally
    //   358	373	511	finally
    //   389	398	511	finally
    //   412	422	511	finally
    //   427	437	511	finally
    //   448	453	511	finally
    //   458	465	511	finally
    //   470	473	511	finally
    //   508	511	511	finally
    //   516	543	511	finally
    //   550	559	511	finally
    //   568	606	511	finally
    //   613	615	511	finally
    //   642	667	511	finally
    //   676	686	511	finally
    //   739	741	511	finally
    //   75	81	515	java/io/IOException
    //   86	91	515	java/io/IOException
    //   96	109	515	java/io/IOException
    //   114	124	515	java/io/IOException
    //   129	135	515	java/io/IOException
    //   140	143	515	java/io/IOException
    //   166	169	515	java/io/IOException
    //   174	183	515	java/io/IOException
    //   188	194	515	java/io/IOException
    //   199	202	515	java/io/IOException
    //   215	223	515	java/io/IOException
    //   228	238	515	java/io/IOException
    //   247	249	515	java/io/IOException
    //   278	281	515	java/io/IOException
    //   286	294	515	java/io/IOException
    //   299	307	515	java/io/IOException
    //   312	320	515	java/io/IOException
    //   328	333	515	java/io/IOException
    //   338	345	515	java/io/IOException
    //   350	353	515	java/io/IOException
    //   358	373	515	java/io/IOException
    //   389	398	515	java/io/IOException
    //   412	422	515	java/io/IOException
    //   427	437	515	java/io/IOException
    //   448	453	515	java/io/IOException
    //   458	465	515	java/io/IOException
    //   470	473	515	java/io/IOException
    //   508	511	515	java/io/IOException
    //   559	568	609	finally
    //   610	613	609	finally
    //   622	631	636	finally
    //   637	639	636	finally
    //   75	81	641	org/eclipse/paho/client/mqttv3/MqttException
    //   86	91	641	org/eclipse/paho/client/mqttv3/MqttException
    //   96	109	641	org/eclipse/paho/client/mqttv3/MqttException
    //   114	124	641	org/eclipse/paho/client/mqttv3/MqttException
    //   129	135	641	org/eclipse/paho/client/mqttv3/MqttException
    //   140	143	641	org/eclipse/paho/client/mqttv3/MqttException
    //   166	169	641	org/eclipse/paho/client/mqttv3/MqttException
    //   174	183	641	org/eclipse/paho/client/mqttv3/MqttException
    //   188	194	641	org/eclipse/paho/client/mqttv3/MqttException
    //   199	202	641	org/eclipse/paho/client/mqttv3/MqttException
    //   215	223	641	org/eclipse/paho/client/mqttv3/MqttException
    //   228	238	641	org/eclipse/paho/client/mqttv3/MqttException
    //   247	249	641	org/eclipse/paho/client/mqttv3/MqttException
    //   278	281	641	org/eclipse/paho/client/mqttv3/MqttException
    //   286	294	641	org/eclipse/paho/client/mqttv3/MqttException
    //   299	307	641	org/eclipse/paho/client/mqttv3/MqttException
    //   312	320	641	org/eclipse/paho/client/mqttv3/MqttException
    //   328	333	641	org/eclipse/paho/client/mqttv3/MqttException
    //   338	345	641	org/eclipse/paho/client/mqttv3/MqttException
    //   350	353	641	org/eclipse/paho/client/mqttv3/MqttException
    //   358	373	641	org/eclipse/paho/client/mqttv3/MqttException
    //   389	398	641	org/eclipse/paho/client/mqttv3/MqttException
    //   412	422	641	org/eclipse/paho/client/mqttv3/MqttException
    //   427	437	641	org/eclipse/paho/client/mqttv3/MqttException
    //   448	453	641	org/eclipse/paho/client/mqttv3/MqttException
    //   458	465	641	org/eclipse/paho/client/mqttv3/MqttException
    //   470	473	641	org/eclipse/paho/client/mqttv3/MqttException
    //   508	511	641	org/eclipse/paho/client/mqttv3/MqttException
    //   714	722	725	finally
    //   726	729	725	finally
    //   693	702	731	finally
    //   732	734	731	finally
    //   667	676	736	finally
    //   737	739	736	finally
    //   748	757	759	finally
    //   760	762	759	finally
    //   771	780	802	finally
    //   803	805	802	finally
    //   40	47	807	finally
    //   808	810	807	finally
    //   33	40	812	finally
    //   49	53	812	finally
    //   58	63	812	finally
    //   473	480	812	finally
    //   496	498	812	finally
    //   615	622	812	finally
    //   639	641	812	finally
    //   686	693	812	finally
    //   705	714	812	finally
    //   729	731	812	finally
    //   734	736	812	finally
    //   741	748	812	finally
    //   757	759	812	finally
    //   762	764	812	finally
    //   810	812	812	finally
    //   820	829	831	finally
    //   832	834	831	finally
    //   24	33	836	finally
    //   837	839	836	finally
  }
  
  public void start(String arg1, ExecutorService paramExecutorService)
  {
    this.threadName = ???;
    this.log.fine(CLASS_NAME, "start", "855");
    synchronized (this.lifecycle)
    {
      State localState1 = this.current_state;
      State localState2 = State.STOPPED;
      if ((localState1 == localState2) && (this.target_state == localState2))
      {
        this.target_state = State.RUNNING;
        if (paramExecutorService == null)
        {
          paramExecutorService = new java/lang/Thread;
          paramExecutorService.<init>(this);
          paramExecutorService.start();
        }
        else
        {
          this.receiverFuture = paramExecutorService.submit(this);
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
    synchronized (this.lifecycle)
    {
      Future localFuture = this.receiverFuture;
      if (localFuture != null) {
        localFuture.cancel(true);
      }
      this.log.fine(CLASS_NAME, "stop", "850");
      if (isRunning()) {
        this.target_state = State.STOPPED;
      }
      for (;;)
      {
        if (!isRunning())
        {
          this.log.fine(CLASS_NAME, "stop", "851");
          return;
        }
        try
        {
          Thread.sleep(100L);
        }
        catch (Exception localException) {}
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
      State localState3 = new State("STARTING", 2);
      STARTING = localState3;
      State localState4 = new State("RECEIVING", 3);
      RECEIVING = localState4;
      ENUM$VALUES = new State[] { localState1, localState2, localState3, localState4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\CommsReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */