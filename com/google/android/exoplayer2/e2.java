package com.google.android.exoplayer2;

import androidx.annotation.Nullable;

public final class e2
{
  public static final e2 a = new e2(false);
  public final boolean b;
  
  public e2(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (e2.class == paramObject.getClass()))
    {
      paramObject = (e2)paramObject;
      if (this.b != ((e2)paramObject).b) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.b ^ true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\e2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */