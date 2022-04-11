package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.SocketTimeoutException;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class WebSocketReceiver
  implements Runnable
{
  private static final String CLASS_NAME = WebSocketReceiver.class.getName();
  private InputStream input;
  private final Object lifecycle = new Object();
  private Logger log = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
  private PipedOutputStream pipedOutputStream;
  private Thread receiverThread = null;
  private volatile boolean receiving;
  private boolean running = false;
  private boolean stopping = false;
  
  public WebSocketReceiver(InputStream paramInputStream, PipedInputStream paramPipedInputStream)
    throws IOException
  {
    this.input = paramInputStream;
    paramInputStream = new PipedOutputStream();
    this.pipedOutputStream = paramInputStream;
    paramPipedInputStream.connect(paramInputStream);
  }
  
  private void closeOutputStream()
  {
    try
    {
      this.pipedOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public boolean isReceiving()
  {
    return this.receiving;
  }
  
  public boolean isRunning()
  {
    return this.running;
  }
  
  public void run()
  {
    while ((this.running) && (this.input != null)) {
      try
      {
        this.log.fine(CLASS_NAME, "run", "852");
        boolean bool;
        if (this.input.available() > 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.receiving = bool;
        Object localObject = new org/eclipse/paho/client/mqttv3/internal/websocket/WebSocketFrame;
        ((WebSocketFrame)localObject).<init>(this.input);
        if (!((WebSocketFrame)localObject).isCloseFlag()) {
          for (int i = 0;; i++)
          {
            if (i >= ((WebSocketFrame)localObject).getPayload().length)
            {
              this.pipedOutputStream.flush();
              break;
            }
            this.pipedOutputStream.write(localObject.getPayload()[i]);
          }
        }
        if (this.stopping)
        {
          this.receiving = false;
        }
        else
        {
          localObject = new java/io/IOException;
          ((IOException)localObject).<init>("Server sent a WebSocket Frame with the Stop OpCode");
          throw ((Throwable)localObject);
        }
      }
      catch (IOException localIOException)
      {
        stop();
      }
      catch (SocketTimeoutException localSocketTimeoutException) {}
    }
  }
  
  public void start(String paramString)
  {
    this.log.fine(CLASS_NAME, "start", "855");
    synchronized (this.lifecycle)
    {
      if (!this.running)
      {
        this.running = true;
        Thread localThread = new java/lang/Thread;
        localThread.<init>(this, paramString);
        this.receiverThread = localThread;
        localThread.start();
      }
      return;
    }
  }
  
  public void stop()
  {
    int i = 1;
    this.stopping = true;
    synchronized (this.lifecycle)
    {
      this.log.fine(CLASS_NAME, "stop", "850");
      if (this.running)
      {
        this.running = false;
        this.receiving = false;
        closeOutputStream();
      }
      else
      {
        i = 0;
      }
      if ((i != 0) && (!Thread.currentThread().equals(this.receiverThread)))
      {
        ??? = this.receiverThread;
        if (??? == null) {}
      }
    }
    try
    {
      ((Thread)???).join();
      this.receiverThread = null;
      this.log.fine(CLASS_NAME, "stop", "851");
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\websocket\WebSocketReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */