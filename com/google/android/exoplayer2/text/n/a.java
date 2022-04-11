package com.google.android.exoplayer2.text.n;

import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import java.util.List;

public final class a
  extends d
{
  private final b o;
  
  public a(List<byte[]> paramList)
  {
    super("DvbDecoder");
    paramList = new d0((byte[])paramList.get(0));
    this.o = new b(paramList.J(), paramList.J());
  }
  
  protected f y(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.o.r();
    }
    return new c(this.o.b(paramArrayOfByte, paramInt));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\n\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */