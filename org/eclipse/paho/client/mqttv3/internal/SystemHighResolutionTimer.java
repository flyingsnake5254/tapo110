package org.eclipse.paho.client.mqttv3.internal;

public class SystemHighResolutionTimer
  implements HighResolutionTimer
{
  public long nanoTime()
  {
    return System.nanoTime();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\internal\SystemHighResolutionTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */