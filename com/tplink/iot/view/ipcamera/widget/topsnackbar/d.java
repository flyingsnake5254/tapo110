package com.tplink.iot.view.ipcamera.widget.topsnackbar;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import java.lang.ref.WeakReference;

class d
{
  private static d a;
  private final Object b = new Object();
  private final Handler c = new Handler(Looper.getMainLooper(), new a());
  private c d;
  private c e;
  
  private boolean b(c paramc, int paramInt)
  {
    b localb = (b)c.c(paramc).get();
    if (localb != null)
    {
      this.c.removeCallbacksAndMessages(paramc);
      localb.dismiss(paramInt);
      return true;
    }
    return false;
  }
  
  static d e()
  {
    if (a == null) {
      a = new d();
    }
    return a;
  }
  
  private void f(c paramc)
  {
    synchronized (this.b)
    {
      if ((this.d == paramc) || (this.e == paramc)) {
        b(paramc, 2);
      }
      return;
    }
  }
  
  private boolean g(b paramb)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return false;
    }
    localObject = (b)c.c((c)localObject).get();
    if ((paramb == null) && (localObject == null)) {
      return true;
    }
    if ((paramb != null) && (localObject != null))
    {
      paramb = paramb.content();
      localObject = ((b)localObject).content();
      if ((paramb == null) && (localObject == null)) {
        return true;
      }
      if ((paramb != null) && (localObject != null)) {
        return paramb.equals(localObject);
      }
    }
    return false;
  }
  
  private boolean i(b paramb)
  {
    c localc = this.d;
    boolean bool;
    if ((localc != null) && (localc.d(paramb))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean j(b paramb)
  {
    c localc = this.e;
    boolean bool;
    if ((localc != null) && (localc.d(paramb))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean k(b paramb)
  {
    Object localObject = this.d;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    localObject = (b)c.c((c)localObject).get();
    if ((paramb == null) && (localObject == null)) {
      return true;
    }
    boolean bool2 = bool1;
    if (paramb != null) {
      if (localObject == null)
      {
        bool2 = bool1;
      }
      else
      {
        bool2 = bool1;
        if (paramb.getParentView() == ((b)localObject).getParentView()) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private void o(c paramc)
  {
    if (c.a(paramc) == -2) {
      return;
    }
    int i = 2750;
    if (c.a(paramc) > 0) {
      i = c.a(paramc);
    } else if (c.a(paramc) == -1) {
      i = 1500;
    }
    this.c.removeCallbacksAndMessages(paramc);
    Handler localHandler = this.c;
    localHandler.sendMessageDelayed(Message.obtain(localHandler, 0, paramc), i);
  }
  
  private void q()
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      this.d = ((c)localObject);
      this.e = null;
      localObject = (b)c.c((c)localObject).get();
      if (localObject != null) {
        ((b)localObject).show();
      } else {
        this.d = null;
      }
    }
  }
  
  public void c(b paramb)
  {
    synchronized (this.b)
    {
      if (i(paramb)) {
        this.c.removeCallbacksAndMessages(this.d);
      }
      return;
    }
  }
  
  public void d(b paramb, int paramInt)
  {
    synchronized (this.b)
    {
      if (i(paramb)) {
        b(this.d, paramInt);
      } else if (j(paramb)) {
        b(this.e, paramInt);
      }
      return;
    }
  }
  
  public boolean h(b paramb)
  {
    synchronized (this.b)
    {
      boolean bool;
      if ((!i(paramb)) && (!j(paramb))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  public void l(b paramb)
  {
    synchronized (this.b)
    {
      if (i(paramb))
      {
        this.d = null;
        if (this.e != null) {
          q();
        }
      }
      return;
    }
  }
  
  public void m(b paramb)
  {
    synchronized (this.b)
    {
      if (i(paramb)) {
        o(this.d);
      }
      return;
    }
  }
  
  public void n(b paramb)
  {
    synchronized (this.b)
    {
      if (i(paramb)) {
        o(this.d);
      }
      return;
    }
  }
  
  public void p(int paramInt, b paramb)
  {
    synchronized (this.b)
    {
      if ((!i(paramb)) && ((!g(paramb)) || (!k(paramb))))
      {
        if (j(paramb))
        {
          c.b(this.e, paramInt);
        }
        else
        {
          c localc = new com/tplink/iot/view/ipcamera/widget/topsnackbar/d$c;
          localc.<init>(paramInt, paramb);
          this.e = localc;
        }
        paramb = this.d;
        if ((paramb == null) || (!b(paramb, 4)))
        {
          this.d = null;
          q();
        }
        return;
      }
      c.b(this.d, paramInt);
      this.c.removeCallbacksAndMessages(this.d);
      o(this.d);
      return;
    }
  }
  
  class a
    implements Handler.Callback
  {
    a() {}
    
    public boolean handleMessage(Message paramMessage)
    {
      if (paramMessage.what != 0) {
        return false;
      }
      d.a(d.this, (d.c)paramMessage.obj);
      return true;
    }
  }
  
  static abstract interface b
  {
    public abstract String content();
    
    public abstract void dismiss(int paramInt);
    
    public abstract View getParentView();
    
    public abstract void show();
  }
  
  private static class c
  {
    private final WeakReference<d.b> a;
    private int b;
    
    c(int paramInt, d.b paramb)
    {
      this.a = new WeakReference(paramb);
      this.b = paramInt;
    }
    
    boolean d(d.b paramb)
    {
      boolean bool;
      if ((paramb != null) && (this.a.get() == paramb)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\topsnackbar\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */