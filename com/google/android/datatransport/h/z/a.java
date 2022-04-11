package com.google.android.datatransport.h.z;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  private static SparseArray<Priority> a = new SparseArray();
  private static HashMap<Priority, Integer> b;
  
  static
  {
    Object localObject = new HashMap();
    b = (HashMap)localObject;
    ((HashMap)localObject).put(Priority.DEFAULT, Integer.valueOf(0));
    b.put(Priority.VERY_LOW, Integer.valueOf(1));
    b.put(Priority.HIGHEST, Integer.valueOf(2));
    localObject = b.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Priority localPriority = (Priority)((Iterator)localObject).next();
      a.append(((Integer)b.get(localPriority)).intValue(), localPriority);
    }
  }
  
  public static int a(@NonNull Priority paramPriority)
  {
    Object localObject = (Integer)b.get(paramPriority);
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("PriorityMapping is missing known Priority value ");
    ((StringBuilder)localObject).append(paramPriority);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  @NonNull
  public static Priority b(int paramInt)
  {
    Object localObject = (Priority)a.get(paramInt);
    if (localObject != null) {
      return (Priority)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unknown Priority for value ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\z\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */