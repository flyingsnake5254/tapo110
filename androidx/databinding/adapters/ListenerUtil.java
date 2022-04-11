package androidx.databinding.adapters;

import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class ListenerUtil
{
  private static final SparseArray<WeakHashMap<View, WeakReference<?>>> sListeners = new SparseArray();
  
  public static <T> T getListener(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return (T)paramView.getTag(paramInt);
    }
    synchronized (sListeners)
    {
      WeakHashMap localWeakHashMap = (WeakHashMap)???.get(paramInt);
      if (localWeakHashMap == null) {
        return null;
      }
      paramView = (WeakReference)localWeakHashMap.get(paramView);
      if (paramView == null) {
        return null;
      }
      paramView = paramView.get();
      return paramView;
    }
  }
  
  public static <T> T trackListener(View paramView, T paramT, int paramInt)
  {
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 14)
    {
      localObject1 = paramView.getTag(paramInt);
      paramView.setTag(paramInt, paramT);
      return (T)localObject1;
    }
    synchronized (sListeners)
    {
      Object localObject2 = (WeakHashMap)???.get(paramInt);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new java/util/WeakHashMap;
        ((WeakHashMap)localObject1).<init>();
        ???.put(paramInt, localObject1);
      }
      if (paramT == null)
      {
        paramView = (WeakReference)((WeakHashMap)localObject1).remove(paramView);
      }
      else
      {
        localObject2 = new java/lang/ref/WeakReference;
        ((WeakReference)localObject2).<init>(paramT);
        paramView = (WeakReference)((WeakHashMap)localObject1).put(paramView, localObject2);
      }
      if (paramView == null) {
        return null;
      }
      paramView = paramView.get();
      return paramView;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\ListenerUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */