package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class k
{
  public final int a;
  private final j[] b;
  private int c;
  
  public k(j... paramVarArgs)
  {
    this.b = paramVarArgs;
    this.a = paramVarArgs.length;
  }
  
  @Nullable
  public j a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (k.class == paramObject.getClass()))
    {
      paramObject = (k)paramObject;
      return Arrays.equals(this.b, ((k)paramObject).b);
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.c == 0) {
      this.c = (527 + Arrays.hashCode(this.b));
    }
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\trackselection\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */