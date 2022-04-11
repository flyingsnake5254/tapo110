package org.eclipse.paho.client.mqttv3;

import java.util.Timer;
import java.util.TimerTask;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

public class TimerPingSender
  implements MqttPingSender
{
  private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.TimerPingSender";
  private String clientid;
  private ClientComms comms;
  private Logger log = LoggerFactory.getLogger("org.eclipse.paho.client.mqttv3.internal.nls.logcat", CLASS_NAME);
  private Timer timer;
  
  public void init(ClientComms paramClientComms)
  {
    if (paramClientComms != null)
    {
      this.comms = paramClientComms;
      paramClientComms = paramClientComms.getClient().getClientId();
      this.clientid = paramClientComms;
      this.log.setResourceName(paramClientComms);
      return;
    }
    throw new IllegalArgumentException("ClientComms cannot be null.");
  }
  
  public void schedule(long paramLong)
  {
    this.timer.schedule(new PingTask(null), paramLong);
  }
  
  public void start()
  {
    this.log.fine(CLASS_NAME, "start", "659", new Object[] { this.clientid });
    Object localObject = new StringBuilder("MQTT Ping: ");
    ((StringBuilder)localObject).append(this.clientid);
    localObject = new Timer(((StringBuilder)localObject).toString());
    this.timer = ((Timer)localObject);
    ((Timer)localObject).schedule(new PingTask(null), this.comms.getKeepAlive());
  }
  
  public void stop()
  {
    this.log.fine(CLASS_NAME, "stop", "661", null);
    Timer localTimer = this.timer;
    if (localTimer != null) {
      localTimer.cancel();
    }
  }
  
  private class PingTask
    extends TimerTask
  {
    private static final String methodName = "PingTask.run";
    
    private PingTask() {}
    
    public void run()
    {
      TimerPingSender.this.log.fine(TimerPingSender.CLASS_NAME, "PingTask.run", "660", new Object[] { Long.valueOf(System.nanoTime()) });
      TimerPingSender.this.comms.checkForActivity();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\TimerPingSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */