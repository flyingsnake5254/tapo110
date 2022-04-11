package kotlin.r;

import kotlin.jvm.internal.j;
import kotlin.p;

public final class a
{
  public static final Thread a(boolean paramBoolean1, boolean paramBoolean2, ClassLoader paramClassLoader, String paramString, int paramInt, kotlin.jvm.b.a<p> parama)
  {
    j.e(parama, "block");
    parama = new a(parama);
    if (paramBoolean2) {
      parama.setDaemon(true);
    }
    if (paramInt > 0) {
      parama.setPriority(paramInt);
    }
    if (paramString != null) {
      parama.setName(paramString);
    }
    if (paramClassLoader != null) {
      parama.setContextClassLoader(paramClassLoader);
    }
    if (paramBoolean1) {
      parama.start();
    }
    return parama;
  }
  
  public static final class a
    extends Thread
  {
    a(kotlin.jvm.b.a parama) {}
    
    public void run()
    {
      this.c.invoke();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\r\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */