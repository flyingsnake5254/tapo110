package com.google.android.exoplayer2.o2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.util.d0;
import java.io.IOException;
import java.util.Arrays;

public abstract interface b0
{
  public abstract int a(i parami, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException;
  
  public abstract int b(i parami, int paramInt, boolean paramBoolean)
    throws IOException;
  
  public abstract void c(d0 paramd0, int paramInt);
  
  public abstract void d(Format paramFormat);
  
  public abstract void e(long paramLong, int paramInt1, int paramInt2, int paramInt3, @Nullable a parama);
  
  public abstract void f(d0 paramd0, int paramInt1, int paramInt2);
  
  public static final class a
  {
    public final int a;
    public final byte[] b;
    public final int c;
    public final int d;
    
    public a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramArrayOfByte;
      this.c = paramInt2;
      this.d = paramInt3;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject != null) && (a.class == paramObject.getClass()))
      {
        paramObject = (a)paramObject;
        if ((this.a != ((a)paramObject).a) || (this.c != ((a)paramObject).c) || (this.d != ((a)paramObject).d) || (!Arrays.equals(this.b, ((a)paramObject).b))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      return ((this.a * 31 + Arrays.hashCode(this.b)) * 31 + this.c) * 31 + this.d;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\o2\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */