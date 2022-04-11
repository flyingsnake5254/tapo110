package com.google.android.exoplayer2.text;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import java.nio.ByteBuffer;

public abstract class d
  extends com.google.android.exoplayer2.decoder.g<i, j, SubtitleDecoderException>
  implements g
{
  private final String n;
  
  protected d(String paramString)
  {
    super(new i[2], new j[2]);
    this.n = paramString;
    u(1024);
  }
  
  public void a(long paramLong) {}
  
  public final String getName()
  {
    return this.n;
  }
  
  protected final i v()
  {
    return new i();
  }
  
  protected final j w()
  {
    return new e(new b(this));
  }
  
  protected final SubtitleDecoderException x(Throwable paramThrowable)
  {
    return new SubtitleDecoderException("Unexpected decode error", paramThrowable);
  }
  
  protected abstract f y(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws SubtitleDecoderException;
  
  @Nullable
  protected final SubtitleDecoderException z(i parami, j paramj, boolean paramBoolean)
  {
    try
    {
      Object localObject = (ByteBuffer)com.google.android.exoplayer2.util.g.e(parami.f);
      localObject = y(((ByteBuffer)localObject).array(), ((ByteBuffer)localObject).limit(), paramBoolean);
      paramj.o(parami.x, (f)localObject, parami.p1);
      paramj.g(Integer.MIN_VALUE);
      return null;
    }
    catch (SubtitleDecoderException parami) {}
    return parami;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */