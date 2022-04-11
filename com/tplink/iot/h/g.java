package com.tplink.iot.h;

import android.os.Handler;
import android.os.Message;
import com.tplink.iot.h.i.c;
import java.io.IOException;

public class g
{
  private static g a;
  private c b;
  private Handler c = new a();
  
  public static g d()
  {
    try
    {
      if (a == null)
      {
        g localg = new com/tplink/iot/h/g;
        localg.<init>();
        a = localg;
      }
      return a;
    }
    finally {}
  }
  
  private void f(Throwable paramThrowable)
  {
    Message localMessage = this.c.obtainMessage();
    localMessage.obj = paramThrowable;
    localMessage.what = 1101;
    this.c.sendMessage(localMessage);
  }
  
  private void g(com.tplink.iot.h.h.a parama)
  {
    Message localMessage = this.c.obtainMessage();
    localMessage.obj = parama;
    localMessage.what = 1102;
    this.c.sendMessage(localMessage);
  }
  
  public void e(String paramString1, String paramString2, c paramc)
  {
    try
    {
      this.b = paramc;
      paramc.onStart();
      paramc = new com/tplink/iot/h/g$b;
      paramc.<init>(this, paramString1, paramString2);
      paramc.start();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      int i = paramMessage.what;
      if (i != 1101)
      {
        if (i == 1102) {
          g.a(g.this).c((com.tplink.iot.h.h.a)paramMessage.obj);
        }
      }
      else {
        g.a(g.this).onError((Throwable)paramMessage.obj);
      }
    }
  }
  
  class b
    extends Thread
  {
    b(String paramString1, String paramString2) {}
    
    public void run()
    {
      try
      {
        com.tplink.iot.h.h.a locala = com.tplink.iot.h.j.a.d(this.c, this.d);
        g.b(g.this, locala);
      }
      catch (IOException localIOException)
      {
        g.c(g.this, localIOException);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\h\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */