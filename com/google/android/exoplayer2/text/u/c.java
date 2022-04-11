package com.google.android.exoplayer2.text.u;

import android.text.SpannedString;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
  extends com.google.android.exoplayer2.text.d
{
  private final d0 o = new d0();
  
  public c()
  {
    super("Mp4WebvttDecoder");
  }
  
  private static com.google.android.exoplayer2.text.c B(d0 paramd0, int paramInt)
    throws SubtitleDecoderException
  {
    SpannedString localSpannedString = null;
    Object localObject = localSpannedString;
    while (paramInt > 0) {
      if (paramInt >= 8)
      {
        int i = paramd0.n();
        int j = paramd0.n();
        i -= 8;
        String str = o0.C(paramd0.d(), paramd0.e(), i);
        paramd0.Q(i);
        i = paramInt - 8 - i;
        if (j == 1937011815)
        {
          localObject = h.o(str);
          paramInt = i;
        }
        else
        {
          paramInt = i;
          if (j == 1885436268)
          {
            localSpannedString = h.q(null, str.trim(), Collections.emptyList());
            paramInt = i;
          }
        }
      }
      else
      {
        throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
      }
    }
    paramd0 = localSpannedString;
    if (localSpannedString == null) {
      paramd0 = "";
    }
    if (localObject != null) {
      paramd0 = ((c.b)localObject).o(paramd0).a();
    } else {
      paramd0 = h.l(paramd0);
    }
    return paramd0;
  }
  
  protected f y(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws SubtitleDecoderException
  {
    this.o.N(paramArrayOfByte, paramInt);
    paramArrayOfByte = new ArrayList();
    while (this.o.a() > 0) {
      if (this.o.a() >= 8)
      {
        paramInt = this.o.n();
        if (this.o.n() == 1987343459) {
          paramArrayOfByte.add(B(this.o, paramInt - 8));
        } else {
          this.o.Q(paramInt - 8);
        }
      }
      else
      {
        throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
      }
    }
    return new d(paramArrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\u\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */