package com.google.android.gms.internal.vision;

import com.google.android.gms.vision.L;
import java.util.HashMap;

public final class zzr
{
  private static final Object sLock = new Object();
  private static final HashMap<String, Integer> zzcf = new HashMap();
  
  public static boolean zza(String paramString1, String paramString2)
  {
    synchronized (sLock)
    {
      paramString1 = String.valueOf(paramString1);
      Object localObject2 = String.valueOf(paramString2);
      if (((String)localObject2).length() != 0) {
        paramString1 = paramString1.concat((String)localObject2);
      } else {
        paramString1 = new String(paramString1);
      }
      localObject2 = zzcf;
      int i;
      if (((HashMap)localObject2).containsKey(paramString1)) {
        i = ((Integer)((HashMap)localObject2).get(paramString1)).intValue();
      } else {
        i = 0;
      }
      if ((i & 0x1) != 0) {
        return true;
      }
      try
      {
        System.loadLibrary(paramString2);
        ((HashMap)localObject2).put(paramString1, Integer.valueOf(i | 0x1));
        return true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if ((i & 0x4) == 0)
        {
          L.e(localUnsatisfiedLinkError, "System.loadLibrary failed: %s", new Object[] { paramString2 });
          zzcf.put(paramString1, Integer.valueOf(i | 0x4));
        }
        return false;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */