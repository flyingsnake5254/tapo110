package org.eclipse.paho.client.mqttv3.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttToken;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttDisconnect;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttOutputStream;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class CommsSender
  implements Runnable
{
  private static final String CLASS_NAME = CommsSender.class.getName();
  private ClientComms clientComms;
  private ClientState clientState;
  private State current_state;
  private final Object lifecycle;
  private Logger log = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
  private MqttOutputStream out;
  private Thread sendThread;
  private Future<?> senderFuture;
  private State target_state;
  private String threadName;
  private CommsTokenStore tokenStore;
  
  public CommsSender(ClientComms paramClientComms, ClientState paramClientState, CommsTokenStore paramCommsTokenStore, OutputStream paramOutputStream)
  {
    State localState = State.STOPPED;
    this.current_state = localState;
    this.target_state = localState;
    this.lifecycle = new Object();
    this.sendThread = null;
    this.clientState = null;
    this.clientComms = null;
    this.tokenStore = null;
    this.out = new MqttOutputStream(paramClientState, paramOutputStream);
    this.clientComms = paramClientComms;
    this.clientState = paramClientState;
    this.tokenStore = paramCommsTokenStore;
    this.log.setResourceName(paramClientComms.getClient().getClientId());
  }
  
  private void handleRunException(MqttWireMessage paramMqttWireMessage, Exception arg2)
  {
    this.log.fine(CLASS_NAME, "handleRunException", "804", null, ???);
    if (!(??? instanceof MqttException)) {
      paramMqttWireMessage = new MqttException(32109, ???);
    } else {
      paramMqttWireMessage = (MqttException)???;
    }
    synchronized (this.lifecycle)
    {
      this.target_state = State.STOPPED;
      this.clientComms.shutdownConnection(null, paramMqttWireMessage);
      return;
    }
  }
  
  public boolean isRunning()
  {
    synchronized (this.lifecycle)
    {
      State localState1 = this.current_state;
      State localState2 = State.RUNNING;
      boolean bool;
      if ((localState1 == localState2) && (this.target_state == localState2)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void run()
  {
    ??? = Thread.currentThread();
    this.sendThread = ((Thread)???);
    ((Thread)???).setName(this.threadName);
    synchronized (this.lifecycle)
    {
      this.current_state = State.RUNNING;
      try
      {
        synchronized (this.lifecycle)
        {
          Object localObject6 = this.target_state;
          ??? = null;
          if (localObject6 == State.RUNNING)
          {
            localObject6 = this.out;
            if (localObject6 != null)
            {
              localObject6 = ???;
              try
              {
                ??? = this.clientState.get();
                Object localObject15;
                Object localObject2;
                if (??? != null)
                {
                  localObject6 = ???;
                  ??? = ???;
                  this.log.fine(CLASS_NAME, "run", "802", new Object[] { ((MqttWireMessage)???).getKey(), ??? });
                  localObject6 = ???;
                  ??? = ???;
                  if ((??? instanceof MqttAck))
                  {
                    localObject6 = ???;
                    ??? = ???;
                    this.out.write((MqttWireMessage)???);
                    localObject6 = ???;
                    ??? = ???;
                    this.out.flush();
                    ??? = ???;
                  }
                  else
                  {
                    localObject6 = ???;
                    ??? = ???;
                    MqttToken localMqttToken = ((MqttWireMessage)???).getToken();
                    localObject15 = localMqttToken;
                    if (localMqttToken == null)
                    {
                      localObject6 = ???;
                      ??? = ???;
                      localObject15 = this.tokenStore.getToken((MqttWireMessage)???);
                    }
                    ??? = ???;
                    if (localObject15 != null)
                    {
                      localObject6 = ???;
                      ??? = ???;
                      try
                      {
                        this.out.write((MqttWireMessage)???);
                        try
                        {
                          this.out.flush();
                        }
                        catch (IOException localIOException)
                        {
                          if (!(??? instanceof MqttDisconnect)) {
                            break label245;
                          }
                        }
                        this.clientState.notifySent((MqttWireMessage)???);
                        localObject2 = ???;
                      }
                      finally
                      {
                        label245:
                        localObject6 = ???;
                        localObject2 = ???;
                      }
                      throw ((Throwable)localObject2);
                    }
                  }
                }
                else
                {
                  localObject6 = ???;
                  localObject2 = ???;
                  this.log.fine(CLASS_NAME, "run", "803");
                  localObject6 = ???;
                  localObject2 = ???;
                  localObject15 = this.lifecycle;
                  localObject6 = ???;
                  localObject2 = ???;
                  try
                  {
                    this.target_state = State.STOPPED;
                    localObject2 = ???;
                  }
                  finally
                  {
                    localObject6 = ???;
                    localObject2 = ???;
                  }
                }
                synchronized (this.lifecycle)
                {
                  Object localObject3;
                  localState = this.target_state;
                }
              }
              catch (Exception localException)
              {
                handleRunException((MqttWireMessage)localObject6, localException);
                localObject3 = localObject6;
              }
              catch (MqttException localMqttException)
              {
                handleRunException((MqttWireMessage)localObject3, localMqttException);
              }
            }
          }
          synchronized (this.lifecycle)
          {
            State localState;
            this.current_state = State.STOPPED;
            this.sendThread = null;
            this.log.fine(CLASS_NAME, "run", "805");
            return;
          }
        }
        synchronized (this.lifecycle)
        {
          this.current_state = State.STOPPED;
          this.sendThread = null;
          throw ((Throwable)localObject9);
        }
      }
      finally {}
    }
  }
  
  public void start(String arg1, ExecutorService paramExecutorService)
  {
    this.threadName = ???;
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
          this.senderFuture = paramExecutorService.submit(this);
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
    if (!isRunning()) {
      return;
    }
    for (;;)
    {
      synchronized (this.lifecycle)
      {
        Future localFuture = this.senderFuture;
        if (localFuture != null) {
          localFuture.cancel(true);
        }
        this.log.fine(CLASS_NAME, "stop", "800");
        if (isRunning())
        {
          this.target_state = State.STOPPED;
          this.clientState.notifyQueueLock();
        }
        if (!isRunning())
        {
          this.log.fine(CLASS_NAME, "stop", "801");
          return;
        }
      }
      try
      {
        Thread.sleep(100L);
        this.clientState.notifyQueueLock();
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
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
      State localState3 = new State("STARTING", 2);
      STARTING = localState3;
      ENUM$VALUES = new State[] { localState1, localState2, localState3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\CommsSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */