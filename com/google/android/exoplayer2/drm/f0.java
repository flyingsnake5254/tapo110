package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.o0;
import java.util.UUID;

public final class f0
  implements d0
{
  public static final boolean a;
  public final UUID b;
  public final byte[] c;
  public final boolean d;
  
  static
  {
    if ("Amazon".equals(o0.c))
    {
      String str = o0.d;
      if (("AFTM".equals(str)) || ("AFTB".equals(str)))
      {
        bool = true;
        break label40;
      }
    }
    boolean bool = false;
    label40:
    a = bool;
  }
  
  public f0(UUID paramUUID, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.b = paramUUID;
    this.c = paramArrayOfByte;
    this.d = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\f0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */