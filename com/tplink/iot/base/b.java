package com.tplink.iot.base;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class b
  extends Handler
{
  private WeakReference<a> a;
  public boolean b = false;
  private boolean c = false;
  
  public b(a parama)
  {
    this.a = new WeakReference(parama);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.c) {
      return;
    }
    a locala = (a)this.a.get();
    if (locala != null) {
      locala.handleMessage(paramMessage);
    }
  }
  
  public static abstract interface a
  {
    public abstract void handleMessage(Message paramMessage);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\base\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */