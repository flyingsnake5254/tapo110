package com.google.android.exoplayer2.o2.j0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.o2.b0.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.u;

public final class p
{
  public final boolean a;
  @Nullable
  public final String b;
  public final b0.a c;
  public final int d;
  @Nullable
  public final byte[] e;
  
  public p(boolean paramBoolean, @Nullable String paramString, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, @Nullable byte[] paramArrayOfByte2)
  {
    int i = 1;
    int j;
    if (paramInt1 == 0) {
      j = 1;
    } else {
      j = 0;
    }
    if (paramArrayOfByte2 != null) {
      i = 0;
    }
    g.a(i ^ j);
    this.a = paramBoolean;
    this.b = paramString;
    this.d = paramInt1;
    this.e = paramArrayOfByte2;
    this.c = new b0.a(a(paramString), paramArrayOfByte1, paramInt2, paramInt3);
  }
  
  private static int a(@Nullable String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 3049895: 
      if (paramString.equals("cens")) {
        i = 3;
      }
      break;
    case 3049879: 
      if (paramString.equals("cenc")) {
        i = 2;
      }
      break;
    case 3046671: 
      if (paramString.equals("cbcs")) {
        i = 1;
      }
      break;
    case 3046605: 
      if (paramString.equals("cbc1")) {
        i = 0;
      }
      break;
    }
    switch (i)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 68);
      localStringBuilder.append("Unsupported protection scheme type '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'. Assuming AES-CTR crypto mode.");
      u.h("TrackEncryptionBox", localStringBuilder.toString());
    case 2: 
    case 3: 
      return 1;
    }
    return 2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\j0\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */