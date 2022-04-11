package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l;
import com.google.android.exoplayer2.o2.x;
import com.google.android.exoplayer2.o2.y.b;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l0;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class s
  implements com.google.android.exoplayer2.o2.j
{
  private static final Pattern a = Pattern.compile("LOCAL:([^,]+)");
  private static final Pattern b = Pattern.compile("MPEGTS:(-?\\d+)");
  @Nullable
  private final String c;
  private final l0 d;
  private final d0 e;
  private l f;
  private byte[] g;
  private int h;
  
  public s(@Nullable String paramString, l0 paraml0)
  {
    this.c = paramString;
    this.d = paraml0;
    this.e = new d0();
    this.g = new byte['Ѐ'];
  }
  
  @RequiresNonNull({"output"})
  private b0 a(long paramLong)
  {
    b0 localb0 = this.f.t(0, 3);
    localb0.d(new Format.b().e0("text/vtt").V(this.c).i0(paramLong).E());
    this.f.r();
    return localb0;
  }
  
  @RequiresNonNull({"output"})
  private void f()
    throws ParserException
  {
    d0 locald0 = new d0(this.g);
    com.google.android.exoplayer2.text.u.j.e(locald0);
    Object localObject = locald0.p();
    long l1 = 0L;
    long l2 = l1;
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (((String)localObject).startsWith("X-TIMESTAMP-MAP"))
      {
        Matcher localMatcher1 = a.matcher((CharSequence)localObject);
        if (!localMatcher1.find())
        {
          if (((String)localObject).length() != 0) {
            localObject = "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat((String)localObject);
          } else {
            localObject = new String("X-TIMESTAMP-MAP doesn't contain local timestamp: ");
          }
          throw ParserException.createForMalformedContainer((String)localObject, null);
        }
        Matcher localMatcher2 = b.matcher((CharSequence)localObject);
        if (!localMatcher2.find())
        {
          if (((String)localObject).length() != 0) {
            localObject = "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat((String)localObject);
          } else {
            localObject = new String("X-TIMESTAMP-MAP doesn't contain media timestamp: ");
          }
          throw ParserException.createForMalformedContainer((String)localObject, null);
        }
        l2 = com.google.android.exoplayer2.text.u.j.d((String)g.e(localMatcher1.group(1)));
        l1 = l0.f(Long.parseLong((String)g.e(localMatcher2.group(1))));
      }
      localObject = locald0.p();
    }
    localObject = com.google.android.exoplayer2.text.u.j.a(locald0);
    if (localObject == null)
    {
      a(0L);
      return;
    }
    long l3 = com.google.android.exoplayer2.text.u.j.d((String)g.e(((Matcher)localObject).group(1)));
    l2 = this.d.b(l0.j(l1 + l3 - l2));
    localObject = a(l2 - l3);
    this.e.N(this.g, this.h);
    ((b0)localObject).c(this.e, this.h);
    ((b0)localObject).e(l2, 1, this.h, 0, null);
  }
  
  public void b(l paraml)
  {
    this.f = paraml;
    paraml.o(new y.b(-9223372036854775807L));
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    throw new IllegalStateException();
  }
  
  public boolean d(k paramk)
    throws IOException
  {
    paramk.c(this.g, 0, 6, false);
    this.e.N(this.g, 6);
    if (com.google.android.exoplayer2.text.u.j.b(this.e)) {
      return true;
    }
    paramk.c(this.g, 6, 3, false);
    this.e.N(this.g, 9);
    return com.google.android.exoplayer2.text.u.j.b(this.e);
  }
  
  public int e(k paramk, x paramx)
    throws IOException
  {
    g.e(this.f);
    int i = (int)paramk.a();
    int j = this.h;
    paramx = this.g;
    if (j == paramx.length)
    {
      if (i != -1) {
        j = i;
      } else {
        j = paramx.length;
      }
      this.g = Arrays.copyOf(paramx, j * 3 / 2);
    }
    paramx = this.g;
    j = this.h;
    j = paramk.read(paramx, j, paramx.length - j);
    if (j != -1)
    {
      j = this.h + j;
      this.h = j;
      if ((i == -1) || (j != i)) {
        return 0;
      }
    }
    f();
    return -1;
  }
  
  public void release() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */