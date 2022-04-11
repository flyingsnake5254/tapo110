package org.eclipse.paho.client.mqttv3.persist;

import java.util.Enumeration;
import java.util.Hashtable;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttPersistable;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

public class MemoryPersistence
  implements MqttClientPersistence
{
  private Hashtable<String, MqttPersistable> data;
  
  private void checkIsOpen()
    throws MqttPersistenceException
  {
    if (this.data != null) {
      return;
    }
    throw new MqttPersistenceException();
  }
  
  public void clear()
    throws MqttPersistenceException
  {
    checkIsOpen();
    this.data.clear();
  }
  
  public void close()
    throws MqttPersistenceException
  {
    Hashtable localHashtable = this.data;
    if (localHashtable != null) {
      localHashtable.clear();
    }
  }
  
  public boolean containsKey(String paramString)
    throws MqttPersistenceException
  {
    checkIsOpen();
    return this.data.containsKey(paramString);
  }
  
  public MqttPersistable get(String paramString)
    throws MqttPersistenceException
  {
    checkIsOpen();
    return (MqttPersistable)this.data.get(paramString);
  }
  
  public Enumeration<String> keys()
    throws MqttPersistenceException
  {
    checkIsOpen();
    return this.data.keys();
  }
  
  public void open(String paramString1, String paramString2)
    throws MqttPersistenceException
  {
    this.data = new Hashtable();
  }
  
  public void put(String paramString, MqttPersistable paramMqttPersistable)
    throws MqttPersistenceException
  {
    checkIsOpen();
    this.data.put(paramString, paramMqttPersistable);
  }
  
  public void remove(String paramString)
    throws MqttPersistenceException
  {
    checkIsOpen();
    this.data.remove(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\eclipse\paho\client\mqttv3\persist\MemoryPersistence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */