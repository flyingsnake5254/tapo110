package com.tplink.libtpmediamanager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public enum ConnectionTypeManager
{
  private final AtomicBoolean enabled = new AtomicBoolean(false);
  private a listener;
  private final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap();
  
  static
  {
    ConnectionTypeManager localConnectionTypeManager = new ConnectionTypeManager("INSTANCE", 0);
    INSTANCE = localConnectionTypeManager;
    $VALUES = new ConnectionTypeManager[] { localConnectionTypeManager };
  }
  
  public static String TypeToString(int paramInt)
  {
    if (paramInt == 256) {
      return "Local";
    }
    if (paramInt == 16) {
      return "P2P";
    }
    if (paramInt == 0) {
      return "Relay";
    }
    if (paramInt == 17) {
      return "Upnp";
    }
    return "";
  }
  
  public int get(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    paramString = (Integer)this.map.get(paramString);
    if (paramString == null) {
      return -1;
    }
    return paramString.intValue();
  }
  
  public void set(String paramString, int paramInt)
  {
    if (!this.enabled.get()) {
      return;
    }
    if (paramString == null) {
      return;
    }
    this.map.put(paramString, Integer.valueOf(paramInt));
    a locala = this.listener;
    if (locala != null) {
      locala.onChange(paramString, paramInt);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if ((this.enabled.get()) && (!paramBoolean)) {
      this.map.clear();
    }
    this.enabled.set(paramBoolean);
  }
  
  public void setListener(a parama)
  {
    this.listener = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onChange(String paramString, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediamanager\ConnectionTypeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */