package com.google.android.exoplayer2.text.t;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.common.base.e;
import java.util.List;

public final class a
  extends d
{
  private final d0 o = new d0();
  private final boolean p;
  private final int q;
  private final int r;
  private final String s;
  private final float t;
  private final int u;
  
  public a(List<byte[]> paramList)
  {
    super("Tx3gDecoder");
    int i = paramList.size();
    String str = "sans-serif";
    boolean bool = true;
    if ((i == 1) && ((((byte[])paramList.get(0)).length == 48) || (((byte[])paramList.get(0)).length == 53)))
    {
      byte[] arrayOfByte = (byte[])paramList.get(0);
      this.q = arrayOfByte[24];
      this.r = ((arrayOfByte[26] & 0xFF) << 24 | (arrayOfByte[27] & 0xFF) << 16 | (arrayOfByte[28] & 0xFF) << 8 | arrayOfByte[29] & 0xFF);
      paramList = str;
      if ("Serif".equals(o0.C(arrayOfByte, 43, arrayOfByte.length - 43))) {
        paramList = "serif";
      }
      this.s = paramList;
      i = arrayOfByte[25] * 20;
      this.u = i;
      if ((arrayOfByte[0] & 0x20) == 0) {
        bool = false;
      }
      this.p = bool;
      if (bool)
      {
        int j = arrayOfByte[10];
        this.t = o0.o((arrayOfByte[11] & 0xFF | (j & 0xFF) << 8) / i, 0.0F, 0.95F);
      }
      else
      {
        this.t = 0.85F;
      }
    }
    else
    {
      this.q = 0;
      this.r = -1;
      this.s = "sans-serif";
      this.p = false;
      this.t = 0.85F;
      this.u = -1;
    }
  }
  
  private void B(d0 paramd0, SpannableStringBuilder paramSpannableStringBuilder)
    throws SubtitleDecoderException
  {
    boolean bool;
    if (paramd0.a() >= 12) {
      bool = true;
    } else {
      bool = false;
    }
    C(bool);
    int i = paramd0.J();
    int j = paramd0.J();
    paramd0.Q(2);
    int k = paramd0.D();
    paramd0.Q(1);
    int m = paramd0.n();
    if (j > paramSpannableStringBuilder.length())
    {
      int n = paramSpannableStringBuilder.length();
      paramd0 = new StringBuilder(68);
      paramd0.append("Truncating styl end (");
      paramd0.append(j);
      paramd0.append(") to cueText.length() (");
      paramd0.append(n);
      paramd0.append(").");
      u.h("Tx3gDecoder", paramd0.toString());
      j = paramSpannableStringBuilder.length();
    }
    if (i >= j)
    {
      paramd0 = new StringBuilder(60);
      paramd0.append("Ignoring styl with start (");
      paramd0.append(i);
      paramd0.append(") >= end (");
      paramd0.append(j);
      paramd0.append(").");
      u.h("Tx3gDecoder", paramd0.toString());
      return;
    }
    E(paramSpannableStringBuilder, k, this.q, i, j, 0);
    D(paramSpannableStringBuilder, m, this.r, i, j, 0);
  }
  
  private static void C(boolean paramBoolean)
    throws SubtitleDecoderException
  {
    if (paramBoolean) {
      return;
    }
    throw new SubtitleDecoderException("Unexpected subtitle format.");
  }
  
  private static void D(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 != paramInt2) {
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt1 >>> 8 | (paramInt1 & 0xFF) << 24), paramInt3, paramInt4, paramInt5 | 0x21);
    }
  }
  
  private static void E(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 != paramInt2)
    {
      int i = paramInt5 | 0x21;
      int j = 1;
      if ((paramInt1 & 0x1) != 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      if ((paramInt1 & 0x2) != 0) {
        paramInt5 = 1;
      } else {
        paramInt5 = 0;
      }
      if (paramInt2 != 0)
      {
        if (paramInt5 != 0) {
          paramSpannableStringBuilder.setSpan(new StyleSpan(3), paramInt3, paramInt4, i);
        } else {
          paramSpannableStringBuilder.setSpan(new StyleSpan(1), paramInt3, paramInt4, i);
        }
      }
      else if (paramInt5 != 0) {
        paramSpannableStringBuilder.setSpan(new StyleSpan(2), paramInt3, paramInt4, i);
      }
      if ((paramInt1 & 0x4) != 0) {
        paramInt1 = j;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0) {
        paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt3, paramInt4, i);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt5 == 0)) {
        paramSpannableStringBuilder.setSpan(new StyleSpan(0), paramInt3, paramInt4, i);
      }
    }
  }
  
  private static void F(SpannableStringBuilder paramSpannableStringBuilder, String paramString, int paramInt1, int paramInt2)
  {
    if (paramString != "sans-serif") {
      paramSpannableStringBuilder.setSpan(new TypefaceSpan(paramString), paramInt1, paramInt2, 16711713);
    }
  }
  
  private static String G(d0 paramd0)
    throws SubtitleDecoderException
  {
    boolean bool;
    if (paramd0.a() >= 2) {
      bool = true;
    } else {
      bool = false;
    }
    C(bool);
    int i = paramd0.J();
    if (i == 0) {
      return "";
    }
    if (paramd0.a() >= 2)
    {
      int j = paramd0.g();
      if ((j == 65279) || (j == 65534)) {
        return paramd0.B(i, e.f);
      }
    }
    return paramd0.B(i, e.c);
  }
  
  protected f y(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
    throws SubtitleDecoderException
  {
    this.o.N(paramArrayOfByte, paramInt);
    paramArrayOfByte = G(this.o);
    if (paramArrayOfByte.isEmpty()) {
      return b.c;
    }
    paramArrayOfByte = new SpannableStringBuilder(paramArrayOfByte);
    E(paramArrayOfByte, this.q, 0, 0, paramArrayOfByte.length(), 16711680);
    D(paramArrayOfByte, this.r, -1, 0, paramArrayOfByte.length(), 16711680);
    F(paramArrayOfByte, this.s, 0, paramArrayOfByte.length());
    float f2;
    for (float f1 = this.t; this.o.a() >= 8; f1 = f2)
    {
      int i = this.o.e();
      int j = this.o.n();
      paramInt = this.o.n();
      boolean bool = true;
      paramBoolean = true;
      if (paramInt == 1937013100)
      {
        if (this.o.a() < 2) {
          paramBoolean = false;
        }
        C(paramBoolean);
        int k = this.o.J();
        for (paramInt = 0;; paramInt++)
        {
          f2 = f1;
          if (paramInt >= k) {
            break;
          }
          B(this.o, paramArrayOfByte);
        }
      }
      f2 = f1;
      if (paramInt == 1952608120)
      {
        f2 = f1;
        if (this.p)
        {
          if (this.o.a() >= 2) {
            paramBoolean = bool;
          } else {
            paramBoolean = false;
          }
          C(paramBoolean);
          f2 = o0.o(this.o.J() / this.u, 0.0F, 0.95F);
        }
      }
      this.o.P(i + j);
    }
    return new b(new c.b().o(paramArrayOfByte).h(f1, 0).i(0).a());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\t\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */