package com.android.billingclient.api;

final class s
  implements Runnable
{
  s(v paramv, g paramg) {}
  
  public final void run()
  {
    synchronized (v.b(this.d))
    {
      if (v.c(this.d) != null) {
        v.c(this.d).a(this.c);
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */