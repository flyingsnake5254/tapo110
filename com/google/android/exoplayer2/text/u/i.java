package com.google.android.exoplayer2.text.u;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends d
{
  private final d0 o = new d0();
  private final e p = new e();
  
  public i()
  {
    super("WebvttDecoder");
  }
  
  private static int B(d0 paramd0)
  {
    int i = -1;
    int j = 0;
    while (i == -1)
    {
      j = paramd0.e();
      String str = paramd0.p();
      if (str == null) {
        i = 0;
      } else if ("STYLE".equals(str)) {
        i = 2;
      } else if (str.startsWith("NOTE")) {
        i = 1;
      } else {
        i = 3;
      }
    }
    paramd0.P(j);
    return i;
  }
  
  private static void C(d0 paramd0)
  {
    while (!TextUtils.isEmpty(paramd0.p())) {}
  }
  
  protected f y(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws SubtitleDecoderException
  {
    this.o.N(paramArrayOfByte, paramInt);
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      j.e(this.o);
      while (!TextUtils.isEmpty(this.o.p())) {}
      ArrayList localArrayList2 = new ArrayList();
      for (;;)
      {
        paramInt = B(this.o);
        if (paramInt == 0) {
          break;
        }
        if (paramInt == 1)
        {
          C(this.o);
        }
        else if (paramInt == 2)
        {
          if (localArrayList2.isEmpty())
          {
            this.o.p();
            localArrayList1.addAll(this.p.d(this.o));
          }
          else
          {
            throw new SubtitleDecoderException("A style block was found after the first cue.");
          }
        }
        else if (paramInt == 3)
        {
          paramArrayOfByte = h.m(this.o, localArrayList1);
          if (paramArrayOfByte != null) {
            localArrayList2.add(paramArrayOfByte);
          }
        }
      }
      return new k(localArrayList2);
    }
    catch (ParserException paramArrayOfByte)
    {
      throw new SubtitleDecoderException(paramArrayOfByte);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\u\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */