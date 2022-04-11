package androidx.core.os;

import kotlin.jvm.b.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;

public final class TraceKt
{
  public static final <T> T trace(String paramString, a<? extends T> parama)
  {
    j.f(paramString, "sectionName");
    j.f(parama, "block");
    TraceCompat.beginSection(paramString);
    try
    {
      paramString = parama.invoke();
      return paramString;
    }
    finally
    {
      i.b(1);
      TraceCompat.endSection();
      i.a(1);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\TraceKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */