package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

@KeepForSdk
public class ListenerHolders
{
  private final Set<ListenerHolder<?>> zajo = Collections.newSetFromMap(new WeakHashMap());
  
  @KeepForSdk
  public static <L> ListenerHolder<L> createListenerHolder(@NonNull L paramL, @NonNull Looper paramLooper, @NonNull String paramString)
  {
    Preconditions.checkNotNull(paramL, "Listener must not be null");
    Preconditions.checkNotNull(paramLooper, "Looper must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    return new ListenerHolder(paramLooper, paramL, paramString);
  }
  
  @KeepForSdk
  public static <L> ListenerHolder.ListenerKey<L> createListenerKey(@NonNull L paramL, @NonNull String paramString)
  {
    Preconditions.checkNotNull(paramL, "Listener must not be null");
    Preconditions.checkNotNull(paramString, "Listener type must not be null");
    Preconditions.checkNotEmpty(paramString, "Listener type must not be empty");
    return new ListenerHolder.ListenerKey(paramL, paramString);
  }
  
  public final void release()
  {
    Iterator localIterator = this.zajo.iterator();
    while (localIterator.hasNext()) {
      ((ListenerHolder)localIterator.next()).clear();
    }
    this.zajo.clear();
  }
  
  public final <L> ListenerHolder<L> zaa(@NonNull L paramL, @NonNull Looper paramLooper, @NonNull String paramString)
  {
    paramL = createListenerHolder(paramL, paramLooper, paramString);
    this.zajo.add(paramL);
    return paramL;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\ListenerHolders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */