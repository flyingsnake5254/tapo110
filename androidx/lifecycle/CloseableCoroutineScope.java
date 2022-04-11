package androidx.lifecycle;

import java.io.Closeable;
import kotlin.coroutines.f;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.g1;

public final class CloseableCoroutineScope
  implements Closeable, d0
{
  private final f coroutineContext;
  
  public CloseableCoroutineScope(f paramf)
  {
    this.coroutineContext = paramf;
  }
  
  public void close()
  {
    g1.b(getCoroutineContext(), null, 1, null);
  }
  
  public f getCoroutineContext()
  {
    return this.coroutineContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\CloseableCoroutineScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */