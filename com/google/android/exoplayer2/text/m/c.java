package com.google.android.exoplayer2.text.m;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
  extends e
{
  private static final int[] g = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] h = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] i = { -1, -16711936, -16776961, -16711681, -65536, 65280, -65281 };
  private static final int[] j = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] k = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] l = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] m = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private static final boolean[] n = { 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0 };
  private boolean A;
  private byte B;
  private byte C;
  private int D = 0;
  private boolean E;
  private long F;
  private final d0 o = new d0();
  private final int p;
  private final int q;
  private final int r;
  private final long s;
  private final ArrayList<a> t = new ArrayList();
  private a u = new a(0, 4);
  @Nullable
  private List<com.google.android.exoplayer2.text.c> v;
  @Nullable
  private List<com.google.android.exoplayer2.text.c> w;
  private int x;
  private int y;
  private boolean z;
  
  public c(String paramString, int paramInt, long paramLong)
  {
    if (paramLong > 0L) {
      paramLong *= 1000L;
    } else {
      paramLong = -9223372036854775807L;
    }
    this.s = paramLong;
    int i1;
    if ("application/x-mp4-cea-608".equals(paramString)) {
      i1 = 2;
    } else {
      i1 = 3;
    }
    this.p = i1;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            u.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.r = 0;
            this.q = 0;
          }
          else
          {
            this.r = 1;
            this.q = 1;
          }
        }
        else
        {
          this.r = 0;
          this.q = 1;
        }
      }
      else
      {
        this.r = 1;
        this.q = 0;
      }
    }
    else
    {
      this.r = 0;
      this.q = 0;
    }
    M(0);
    L();
    this.E = true;
    this.F = -9223372036854775807L;
  }
  
  private static boolean A(byte paramByte1, byte paramByte2)
  {
    boolean bool;
    if (((paramByte1 & 0xF6) == 18) && ((paramByte2 & 0xE0) == 32)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean B(byte paramByte1, byte paramByte2)
  {
    boolean bool;
    if (((paramByte1 & 0xF7) == 17) && ((paramByte2 & 0xF0) == 32)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean C(byte paramByte1, byte paramByte2)
  {
    boolean bool;
    if (((paramByte1 & 0xF6) == 20) && ((paramByte2 & 0xF0) == 32)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean D(byte paramByte1, byte paramByte2)
  {
    boolean bool;
    if (((paramByte1 & 0xF0) == 16) && ((paramByte2 & 0xC0) == 64)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean E(byte paramByte)
  {
    boolean bool;
    if ((paramByte & 0xF0) == 16) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean F(boolean paramBoolean, byte paramByte1, byte paramByte2)
  {
    if ((paramBoolean) && (E(paramByte1)))
    {
      if ((this.A) && (this.B == paramByte1) && (this.C == paramByte2))
      {
        this.A = false;
        return true;
      }
      this.A = true;
      this.B = paramByte1;
      this.C = ((byte)paramByte2);
    }
    else
    {
      this.A = false;
    }
    return false;
  }
  
  private static boolean G(byte paramByte)
  {
    boolean bool;
    if ((paramByte & 0xF7) == 20) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean H(byte paramByte1, byte paramByte2)
  {
    boolean bool;
    if (((paramByte1 & 0xF7) == 17) && ((paramByte2 & 0xF0) == 48)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean I(byte paramByte1, byte paramByte2)
  {
    boolean bool;
    if (((paramByte1 & 0xF7) == 23) && (paramByte2 >= 33) && (paramByte2 <= 35)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean J(byte paramByte)
  {
    boolean bool = true;
    if ((1 > paramByte) || (paramByte > 15)) {
      bool = false;
    }
    return bool;
  }
  
  private void K(byte paramByte1, byte paramByte2)
  {
    if (J(paramByte1))
    {
      this.E = false;
    }
    else if (G(paramByte1))
    {
      if ((paramByte2 != 32) && (paramByte2 != 47)) {}
      switch (paramByte2)
      {
      default: 
        switch (paramByte2)
        {
        default: 
          break;
        case 42: 
        case 43: 
          this.E = false;
        }
        break;
      case 37: 
      case 38: 
      case 39: 
        this.E = true;
      }
    }
  }
  
  private void L()
  {
    this.u.j(this.x);
    this.t.clear();
    this.t.add(this.u);
  }
  
  private void M(int paramInt)
  {
    int i1 = this.x;
    if (i1 == paramInt) {
      return;
    }
    this.x = paramInt;
    if (paramInt == 3)
    {
      for (i1 = 0; i1 < this.t.size(); i1++) {
        ((a)this.t.get(i1)).l(paramInt);
      }
      return;
    }
    L();
    if ((i1 == 3) || (paramInt == 1) || (paramInt == 0)) {
      this.v = Collections.emptyList();
    }
  }
  
  private void N(int paramInt)
  {
    this.y = paramInt;
    this.u.m(paramInt);
  }
  
  private boolean O()
  {
    long l1 = this.s;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (l1 != -9223372036854775807L) {
      if (this.F == -9223372036854775807L)
      {
        bool2 = bool1;
      }
      else
      {
        bool2 = bool1;
        if (j() - this.F >= this.s) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  private boolean P(byte paramByte)
  {
    if (z(paramByte)) {
      this.D = q(paramByte);
    }
    boolean bool;
    if (this.D == this.r) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static char p(byte paramByte)
  {
    return (char)j[((paramByte & 0x7F) - 32)];
  }
  
  private static int q(byte paramByte)
  {
    return paramByte >> 3 & 0x1;
  }
  
  private List<com.google.android.exoplayer2.text.c> r()
  {
    int i1 = this.t.size();
    ArrayList localArrayList1 = new ArrayList(i1);
    int i2 = 0;
    int i3 = 2;
    int i4 = 0;
    Object localObject;
    while (i4 < i1)
    {
      localObject = ((a)this.t.get(i4)).g(Integer.MIN_VALUE);
      localArrayList1.add(localObject);
      int i5 = i3;
      if (localObject != null) {
        i5 = Math.min(i3, ((com.google.android.exoplayer2.text.c)localObject).k);
      }
      i4++;
      i3 = i5;
    }
    ArrayList localArrayList2 = new ArrayList(i1);
    for (i4 = i2; i4 < i1; i4++)
    {
      com.google.android.exoplayer2.text.c localc = (com.google.android.exoplayer2.text.c)localArrayList1.get(i4);
      if (localc != null)
      {
        localObject = localc;
        if (localc.k != i3) {
          localObject = (com.google.android.exoplayer2.text.c)g.e(((a)this.t.get(i4)).g(i3));
        }
        localArrayList2.add(localObject);
      }
    }
    return localArrayList2;
  }
  
  private static char s(byte paramByte)
  {
    return (char)l[(paramByte & 0x1F)];
  }
  
  private static char t(byte paramByte)
  {
    return (char)m[(paramByte & 0x1F)];
  }
  
  private static char u(byte paramByte1, byte paramByte2)
  {
    if ((paramByte1 & 0x1) == 0) {
      return s(paramByte2);
    }
    return t(paramByte2);
  }
  
  private static char v(byte paramByte)
  {
    return (char)k[(paramByte & 0xF)];
  }
  
  private void w(byte paramByte)
  {
    this.u.e(' ');
    boolean bool;
    if ((paramByte & 0x1) == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.u.p(paramByte >> 1 & 0x7, bool);
  }
  
  private void x(byte paramByte)
  {
    if (paramByte != 32)
    {
      if (paramByte != 41)
      {
        switch (paramByte)
        {
        default: 
          int i1 = this.x;
          if (i1 == 0) {
            return;
          }
          if (paramByte != 33) {
            switch (paramByte)
            {
            default: 
              break;
            case 47: 
              this.v = r();
              L();
              break;
            case 46: 
              L();
              break;
            case 45: 
              if ((i1 != 1) || (this.u.i())) {
                break;
              }
              this.u.k();
              break;
            case 44: 
              this.v = Collections.emptyList();
              paramByte = this.x;
              if ((paramByte != 1) && (paramByte != 3)) {
                break;
              }
              L();
              break;
            }
          } else {
            this.u.f();
          }
          return;
        case 39: 
          M(1);
          N(4);
          return;
        case 38: 
          M(1);
          N(3);
          return;
        }
        M(1);
        N(2);
        return;
      }
      M(3);
      return;
    }
    M(2);
  }
  
  private void y(byte paramByte1, byte paramByte2)
  {
    byte b1 = g[(paramByte1 & 0x7)];
    boolean bool = false;
    if ((paramByte2 & 0x20) != 0) {
      paramByte1 = 1;
    } else {
      paramByte1 = 0;
    }
    byte b2 = b1;
    if (paramByte1 != 0) {
      b2 = b1 + 1;
    }
    if (b2 != a.b(this.u))
    {
      if ((this.x != 1) && (!this.u.i()))
      {
        locala = new a(this.x, this.y);
        this.u = locala;
        this.t.add(locala);
      }
      a.c(this.u, b2);
    }
    if ((paramByte2 & 0x10) == 16) {
      paramByte1 = 1;
    } else {
      paramByte1 = 0;
    }
    if ((paramByte2 & 0x1) == 1) {
      bool = true;
    }
    b2 = paramByte2 >> 1 & 0x7;
    a locala = this.u;
    if (paramByte1 != 0) {
      paramByte2 = 8;
    } else {
      paramByte2 = b2;
    }
    locala.p(paramByte2, bool);
    if (paramByte1 != 0) {
      a.d(this.u, h[b2]);
    }
  }
  
  private static boolean z(byte paramByte)
  {
    boolean bool;
    if ((paramByte & 0xE0) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected com.google.android.exoplayer2.text.f e()
  {
    List localList = this.v;
    this.w = localList;
    return new f((List)g.e(localList));
  }
  
  protected void f(i parami)
  {
    parami = (ByteBuffer)g.e(parami.f);
    this.o.N(parami.array(), parami.limit());
    int i1 = 0;
    byte b;
    int i5;
    boolean bool1;
    label180:
    do
    {
      boolean bool2;
      do
      {
        int i2;
        int i3;
        int i4;
        do
        {
          do
          {
            i2 = this.o.a();
            i3 = this.p;
            if (i2 < i3) {
              break;
            }
            if (i3 == 2) {
              i3 = -4;
            } else {
              i3 = (byte)this.o.D();
            }
            i2 = this.o.D();
            i4 = this.o.D();
          } while (((i3 & 0x2) != 0) || ((i3 & 0x1) != this.q));
          b = (byte)(i2 & 0x7F);
          i5 = (byte)(i4 & 0x7F);
        } while ((b == 0) && (i5 == 0));
        bool1 = this.z;
        if ((i3 & 0x4) == 4)
        {
          parami = n;
          if ((parami[i2] != 0) && (parami[i4] != 0))
          {
            bool2 = true;
            break label180;
          }
        }
        bool2 = false;
        this.z = bool2;
      } while (F(bool2, b, i5));
      if (this.z) {
        break;
      }
    } while (!bool1);
    L();
    for (;;)
    {
      i1 = 1;
      break;
      K(b, i5);
      if ((!this.E) || (!P(b))) {
        break;
      }
      if (z(b))
      {
        if (H(b, i5))
        {
          this.u.e(v(i5));
        }
        else if (A(b, i5))
        {
          this.u.f();
          this.u.e(u(b, i5));
        }
        else if (B(b, i5))
        {
          w(i5);
        }
        else if (D(b, i5))
        {
          y(b, i5);
        }
        else if (I(b, i5))
        {
          a.a(this.u, i5 - 32);
        }
        else if (C(b, i5))
        {
          x(i5);
        }
      }
      else
      {
        this.u.e(p(b));
        if ((i5 & 0xE0) != 0) {
          this.u.e(p(i5));
        }
      }
    }
    if (i1 != 0)
    {
      i1 = this.x;
      if ((i1 == 1) || (i1 == 3))
      {
        this.v = r();
        this.F = j();
      }
    }
  }
  
  public void flush()
  {
    super.flush();
    this.v = null;
    this.w = null;
    M(0);
    N(4);
    L();
    this.z = false;
    this.A = false;
    this.B = ((byte)0);
    this.C = ((byte)0);
    this.D = 0;
    this.E = true;
    this.F = -9223372036854775807L;
  }
  
  public String getName()
  {
    return "Cea608Decoder";
  }
  
  @Nullable
  public j h()
    throws SubtitleDecoderException
  {
    Object localObject = super.h();
    if (localObject != null) {
      return (j)localObject;
    }
    if (O())
    {
      j localj = i();
      if (localj != null)
      {
        this.v = Collections.emptyList();
        this.F = -9223372036854775807L;
        localObject = e();
        localj.o(j(), (com.google.android.exoplayer2.text.f)localObject, Long.MAX_VALUE);
        return localj;
      }
    }
    return null;
  }
  
  protected boolean k()
  {
    boolean bool;
    if (this.v != this.w) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void release() {}
  
  private static final class a
  {
    private final List<a> a = new ArrayList();
    private final List<SpannableString> b = new ArrayList();
    private final StringBuilder c = new StringBuilder();
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    
    public a(int paramInt1, int paramInt2)
    {
      j(paramInt1);
      this.h = paramInt2;
    }
    
    private SpannableString h()
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.c);
      int i = localSpannableStringBuilder.length();
      int j = 0;
      int k = -1;
      int m = -1;
      int n = 0;
      int i1 = -1;
      int i2 = -1;
      int i3 = 0;
      while (j < this.a.size())
      {
        a locala = (a)this.a.get(j);
        boolean bool = locala.b;
        int i4 = locala.a;
        int i5 = i2;
        int i6 = i3;
        if (i4 != 8)
        {
          if (i4 == 7) {
            i5 = 1;
          } else {
            i5 = 0;
          }
          if (i4 != 7) {
            i2 = c.o()[i4];
          }
          i6 = i5;
          i5 = i2;
        }
        i4 = locala.c;
        int i7 = j + 1;
        if (i7 < this.a.size()) {
          i2 = ((a)this.a.get(i7)).c;
        } else {
          i2 = i;
        }
        if (i4 == i2)
        {
          j = i7;
          i2 = i5;
          i3 = i6;
        }
        else
        {
          int i8;
          if ((k != -1) && (!bool))
          {
            q(localSpannableStringBuilder, k, i4);
            i8 = -1;
          }
          else
          {
            i8 = k;
            if (k == -1)
            {
              i8 = k;
              if (bool) {
                i8 = i4;
              }
            }
          }
          int i9;
          if ((m != -1) && (i6 == 0))
          {
            o(localSpannableStringBuilder, m, i4);
            i9 = -1;
          }
          else
          {
            i9 = m;
            if (m == -1)
            {
              i9 = m;
              if (i6 != 0) {
                i9 = i4;
              }
            }
          }
          j = i7;
          k = i8;
          m = i9;
          i2 = i5;
          i3 = i6;
          if (i5 != i1)
          {
            n(localSpannableStringBuilder, n, i4, i1);
            i1 = i5;
            j = i7;
            k = i8;
            m = i9;
            n = i4;
            i2 = i5;
            i3 = i6;
          }
        }
      }
      if ((k != -1) && (k != i)) {
        q(localSpannableStringBuilder, k, i);
      }
      if ((m != -1) && (m != i)) {
        o(localSpannableStringBuilder, m, i);
      }
      if (n != i) {
        n(localSpannableStringBuilder, n, i, i1);
      }
      return new SpannableString(localSpannableStringBuilder);
    }
    
    private static void n(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt3 == -1) {
        return;
      }
      paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt3), paramInt1, paramInt2, 33);
    }
    
    private static void o(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
    {
      paramSpannableStringBuilder.setSpan(new StyleSpan(2), paramInt1, paramInt2, 33);
    }
    
    private static void q(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
    {
      paramSpannableStringBuilder.setSpan(new UnderlineSpan(), paramInt1, paramInt2, 33);
    }
    
    public void e(char paramChar)
    {
      if (this.c.length() < 32) {
        this.c.append(paramChar);
      }
    }
    
    public void f()
    {
      int i = this.c.length();
      if (i > 0)
      {
        this.c.delete(i - 1, i);
        for (int j = this.a.size() - 1; j >= 0; j--)
        {
          a locala = (a)this.a.get(j);
          int k = locala.c;
          if (k != i) {
            break;
          }
          locala.c = (k - 1);
        }
      }
    }
    
    @Nullable
    public com.google.android.exoplayer2.text.c g(int paramInt)
    {
      int i = this.e + this.f;
      int j = 32 - i;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      for (int k = 0; k < this.b.size(); k++)
      {
        localSpannableStringBuilder.append(o0.M0((CharSequence)this.b.get(k), j));
        localSpannableStringBuilder.append('\n');
      }
      localSpannableStringBuilder.append(o0.M0(h(), j));
      if (localSpannableStringBuilder.length() == 0) {
        return null;
      }
      k = j - localSpannableStringBuilder.length();
      j = i - k;
      if (paramInt == Integer.MIN_VALUE) {
        if ((this.g == 2) && ((Math.abs(j) < 3) || (k < 0))) {
          paramInt = 1;
        } else if ((this.g == 2) && (j > 0)) {
          paramInt = 2;
        } else {
          paramInt = 0;
        }
      }
      if (paramInt != 1)
      {
        if (paramInt != 2) {}
        for (k = i;; k = 32 - k)
        {
          f1 = k / 32.0F * 0.8F + 0.1F;
          break;
        }
      }
      float f1 = 0.5F;
      i = this.d;
      if (i > 7)
      {
        k = i - 15 - 2;
      }
      else
      {
        k = i;
        if (this.g == 1) {
          k = i - (this.h - 1);
        }
      }
      return new c.b().o(localSpannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(k, 1).k(f1).l(paramInt).a();
    }
    
    public boolean i()
    {
      boolean bool;
      if ((this.a.isEmpty()) && (this.b.isEmpty()) && (this.c.length() == 0)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public void j(int paramInt)
    {
      this.g = paramInt;
      this.a.clear();
      this.b.clear();
      this.c.setLength(0);
      this.d = 15;
      this.e = 0;
      this.f = 0;
    }
    
    public void k()
    {
      this.b.add(h());
      this.c.setLength(0);
      this.a.clear();
      int i = Math.min(this.h, this.d);
      while (this.b.size() >= i) {
        this.b.remove(0);
      }
    }
    
    public void l(int paramInt)
    {
      this.g = paramInt;
    }
    
    public void m(int paramInt)
    {
      this.h = paramInt;
    }
    
    public void p(int paramInt, boolean paramBoolean)
    {
      this.a.add(new a(paramInt, paramBoolean, this.c.length()));
    }
    
    private static class a
    {
      public final int a;
      public final boolean b;
      public int c;
      
      public a(int paramInt1, boolean paramBoolean, int paramInt2)
      {
        this.a = paramInt1;
        this.b = paramBoolean;
        this.c = paramInt2;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\m\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */