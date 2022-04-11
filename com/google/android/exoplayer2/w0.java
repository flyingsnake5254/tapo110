package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioManager;
import androidx.annotation.RequiresApi;
import java.util.UUID;

public final class w0
{
  public static final UUID a = new UUID(0L, 0L);
  public static final UUID b = new UUID(1186680826959645954L, -5988876978535335093L);
  public static final UUID c = new UUID(-2129748144642739255L, 8654423357094679310L);
  public static final UUID d = new UUID(-1301668207276963122L, -6645017420763422227L);
  public static final UUID e = new UUID(-7348484286925749626L, -6083546864340672619L);
  
  @RequiresApi(21)
  public static int a(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    int i;
    if (paramContext == null) {
      i = -1;
    } else {
      i = paramContext.generateAudioSessionId();
    }
    return i;
  }
  
  public static int b(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 4))
    {
      if (paramInt != 10)
      {
        if (paramInt == 7) {
          break label128;
        }
        if (paramInt == 8) {}
      }
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return 6006;
        }
        return 6002;
      case 15: 
        return 6003;
      case 17: 
      case 19: 
      case 20: 
      case 21: 
      case 22: 
        return 6004;
      }
    }
    label128:
    return 6005;
  }
  
  public static String c(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4) {
              return "YES";
            }
            throw new IllegalStateException();
          }
          return "NO_EXCEEDS_CAPABILITIES";
        }
        return "NO_UNSUPPORTED_DRM";
      }
      return "NO_UNSUPPORTED_TYPE";
    }
    return "NO";
  }
  
  public static long d(long paramLong)
  {
    long l = paramLong;
    if (paramLong != -9223372036854775807L) {
      if (paramLong == Long.MIN_VALUE) {
        l = paramLong;
      } else {
        l = paramLong * 1000L;
      }
    }
    return l;
  }
  
  public static long e(long paramLong)
  {
    long l = paramLong;
    if (paramLong != -9223372036854775807L) {
      if (paramLong == Long.MIN_VALUE) {
        l = paramLong;
      } else {
        l = paramLong / 1000L;
      }
    }
    return l;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\w0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */