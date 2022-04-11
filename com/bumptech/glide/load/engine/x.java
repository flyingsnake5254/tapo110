package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

class x
{
  private boolean a;
  private final Handler b = new Handler(Looper.getMainLooper(), new a());
  
  void a(u<?> paramu, boolean paramBoolean)
  {
    try
    {
      if ((!this.a) && (!paramBoolean))
      {
        this.a = true;
        paramu.c();
        this.a = false;
      }
      else
      {
        this.b.obtainMessage(1, paramu).sendToTarget();
      }
      return;
    }
    finally {}
  }
  
  private static final class a
    implements Handler.Callback
  {
    public boolean handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        ((u)paramMessage.obj).c();
        return true;
      }
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */