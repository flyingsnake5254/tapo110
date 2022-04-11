package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class ViewModel
{
  @Nullable
  private final Map<String, Object> mBagOfTags = new HashMap();
  private volatile boolean mCleared = false;
  
  private static void closeWithRuntimeException(Object paramObject)
  {
    if ((paramObject instanceof Closeable)) {
      try
      {
        ((Closeable)paramObject).close();
      }
      catch (IOException paramObject)
      {
        throw new RuntimeException((Throwable)paramObject);
      }
    }
  }
  
  @MainThread
  final void clear()
  {
    this.mCleared = true;
    Map localMap = this.mBagOfTags;
    if (localMap != null) {
      try
      {
        Iterator localIterator = this.mBagOfTags.values().iterator();
        while (localIterator.hasNext()) {
          closeWithRuntimeException(localIterator.next());
        }
      }
      finally {}
    }
    onCleared();
  }
  
  <T> T getTag(String paramString)
  {
    Map localMap = this.mBagOfTags;
    if (localMap == null) {
      return null;
    }
    try
    {
      paramString = this.mBagOfTags.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  protected void onCleared() {}
  
  <T> T setTagIfAbsent(String paramString, T paramT)
  {
    synchronized (this.mBagOfTags)
    {
      Object localObject = this.mBagOfTags.get(paramString);
      if (localObject == null) {
        this.mBagOfTags.put(paramString, paramT);
      }
      if (localObject != null) {
        paramT = (T)localObject;
      }
      if (this.mCleared) {
        closeWithRuntimeException(paramT);
      }
      return paramT;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\ViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */