package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.Component;

public class HeartBeatConsumerComponent
{
  public static Component<?> create()
  {
    Component.intoSet(new HeartBeatConsumer() {}, HeartBeatConsumer.class);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\heartbeatinfo\HeartBeatConsumerComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */