package com.google.android.exoplayer2.text.m;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class d
  extends e
{
  private final d0 g = new d0();
  private final c0 h = new c0();
  private int i = -1;
  private final boolean j;
  private final int k;
  private final b[] l;
  private b m;
  @Nullable
  private List<c> n;
  @Nullable
  private List<c> o;
  @Nullable
  private c p;
  private int q;
  
  public d(int paramInt, @Nullable List<byte[]> paramList)
  {
    boolean bool = true;
    int i1 = paramInt;
    if (paramInt == -1) {
      i1 = 1;
    }
    this.k = i1;
    if ((paramList == null) || (!com.google.android.exoplayer2.util.i.f(paramList))) {
      bool = false;
    }
    this.j = bool;
    this.l = new b[8];
    for (paramInt = 0; paramInt < 8; paramInt++) {
      this.l[paramInt] = new b();
    }
    this.m = this.l[0];
  }
  
  private void A()
  {
    int i1 = this.h.h(2);
    i1 = b.h(this.h.h(2), this.h.h(2), this.h.h(2), i1);
    int i2 = this.h.h(2);
    int i3 = b.h(this.h.h(2), this.h.h(2), this.h.h(2), i2);
    this.h.r(2);
    i2 = b.g(this.h.h(2), this.h.h(2), this.h.h(2));
    this.m.n(i1, i3, i2);
  }
  
  private void B()
  {
    this.h.r(4);
    int i1 = this.h.h(4);
    this.h.r(2);
    int i2 = this.h.h(6);
    this.m.o(i1, i2);
  }
  
  private void C()
  {
    int i1 = this.h.h(2);
    int i2 = b.h(this.h.h(2), this.h.h(2), this.h.h(2), i1);
    int i3 = this.h.h(2);
    int i4 = b.g(this.h.h(2), this.h.h(2), this.h.h(2));
    i1 = i3;
    if (this.h.g()) {
      i1 = i3 | 0x4;
    }
    boolean bool = this.h.g();
    int i5 = this.h.h(2);
    int i6 = this.h.h(2);
    i3 = this.h.h(2);
    this.h.r(8);
    this.m.q(i2, i4, bool, i1, i5, i6, i3);
  }
  
  @RequiresNonNull({"currentDtvCcPacket"})
  private void D()
  {
    Object localObject = this.p;
    int i1 = ((c)localObject).d;
    int i2 = ((c)localObject).b;
    if (i1 != i2 * 2 - 1)
    {
      i3 = ((c)localObject).a;
      localObject = new StringBuilder(115);
      ((StringBuilder)localObject).append("DtvCcPacket ended prematurely; size is ");
      ((StringBuilder)localObject).append(i2 * 2 - 1);
      ((StringBuilder)localObject).append(", but current index is ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" (sequence number ");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append(");");
      u.b("Cea708Decoder", ((StringBuilder)localObject).toString());
    }
    localObject = this.h;
    c localc = this.p;
    ((c0)localObject).o(localc.c, localc.d);
    i2 = this.h.h(3);
    int i3 = this.h.h(5);
    i1 = i2;
    if (i2 == 7)
    {
      this.h.r(2);
      i2 = this.h.h(6);
      i1 = i2;
      if (i2 < 7)
      {
        localObject = new StringBuilder(44);
        ((StringBuilder)localObject).append("Invalid extended service number: ");
        ((StringBuilder)localObject).append(i2);
        u.h("Cea708Decoder", ((StringBuilder)localObject).toString());
        i1 = i2;
      }
    }
    if (i3 == 0)
    {
      if (i1 != 0)
      {
        localObject = new StringBuilder(59);
        ((StringBuilder)localObject).append("serviceNumber is non-zero (");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(") when blockSize is 0");
        u.h("Cea708Decoder", ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (i1 != this.k) {
      return;
    }
    i1 = 0;
    while (this.h.b() > 0)
    {
      i2 = this.h.h(8);
      if (i2 != 16)
      {
        if (i2 <= 31)
        {
          q(i2);
          continue;
        }
        if (i2 <= 127)
        {
          v(i2);
        }
        else if (i2 <= 159)
        {
          r(i2);
        }
        else if (i2 <= 255)
        {
          w(i2);
        }
        else
        {
          localObject = new StringBuilder(33);
          ((StringBuilder)localObject).append("Invalid base command: ");
          ((StringBuilder)localObject).append(i2);
          u.h("Cea708Decoder", ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        i2 = this.h.h(8);
        if (i2 <= 31)
        {
          s(i2);
          continue;
        }
        if (i2 > 127) {
          break label431;
        }
        x(i2);
      }
      for (;;)
      {
        i1 = 1;
        break;
        label431:
        if (i2 <= 159)
        {
          t(i2);
          break;
        }
        if (i2 > 255) {
          break label461;
        }
        y(i2);
      }
      label461:
      localObject = new StringBuilder(37);
      ((StringBuilder)localObject).append("Invalid extended command: ");
      ((StringBuilder)localObject).append(i2);
      u.h("Cea708Decoder", ((StringBuilder)localObject).toString());
    }
    if (i1 != 0) {
      this.n = p();
    }
  }
  
  private void E()
  {
    for (int i1 = 0; i1 < 8; i1++) {
      this.l[i1].l();
    }
  }
  
  private void o()
  {
    if (this.p == null) {
      return;
    }
    D();
    this.p = null;
  }
  
  private List<c> p()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    for (int i2 = 0; i2 < 8; i2++) {
      if ((!this.l[i2].j()) && (this.l[i2].k()))
      {
        localObject = this.l[i2].c();
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    Collections.sort(localArrayList, a.a());
    Object localObject = new ArrayList(localArrayList.size());
    for (i2 = i1; i2 < localArrayList.size(); i2++) {
      ((List)localObject).add(((a)localArrayList.get(i2)).b);
    }
    return Collections.unmodifiableList((List)localObject);
  }
  
  private void q(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 3) {
        if (paramInt == 8) {}
      }
      switch (paramInt)
      {
      default: 
        StringBuilder localStringBuilder;
        if ((paramInt >= 17) && (paramInt <= 23))
        {
          localStringBuilder = new StringBuilder(55);
          localStringBuilder.append("Currently unsupported COMMAND_EXT1 Command: ");
          localStringBuilder.append(paramInt);
          u.h("Cea708Decoder", localStringBuilder.toString());
          this.h.r(8);
        }
        else if ((paramInt >= 24) && (paramInt <= 31))
        {
          localStringBuilder = new StringBuilder(54);
          localStringBuilder.append("Currently unsupported COMMAND_P16 Command: ");
          localStringBuilder.append(paramInt);
          u.h("Cea708Decoder", localStringBuilder.toString());
          this.h.r(16);
        }
        else
        {
          localStringBuilder = new StringBuilder(31);
          localStringBuilder.append("Invalid C0 command: ");
          localStringBuilder.append(paramInt);
          u.h("Cea708Decoder", localStringBuilder.toString());
        }
        break;
      case 13: 
        this.m.a('\n');
        break;
      case 12: 
        E();
        break;
        this.m.b();
        break;
        this.n = p();
      }
    }
  }
  
  private void r(int paramInt)
  {
    int i1 = 1;
    int i2 = 1;
    int i3 = 1;
    Object localObject;
    switch (paramInt)
    {
    case 147: 
    case 148: 
    case 149: 
    case 150: 
    default: 
      localObject = new StringBuilder(31);
      ((StringBuilder)localObject).append("Invalid C1 command: ");
      ((StringBuilder)localObject).append(paramInt);
      u.h("Cea708Decoder", ((StringBuilder)localObject).toString());
      break;
    case 152: 
    case 153: 
    case 154: 
    case 155: 
    case 156: 
    case 157: 
    case 158: 
    case 159: 
      paramInt -= 152;
      u(paramInt);
      if (this.q != paramInt)
      {
        this.q = paramInt;
        this.m = this.l[paramInt];
      }
      break;
    case 151: 
      if (!this.m.i()) {
        this.h.r(32);
      } else {
        C();
      }
      break;
    case 146: 
      if (!this.m.i()) {
        this.h.r(16);
      } else {
        B();
      }
      break;
    case 145: 
      if (!this.m.i()) {
        this.h.r(24);
      } else {
        A();
      }
      break;
    case 144: 
      if (!this.m.i()) {
        this.h.r(16);
      } else {
        z();
      }
      break;
    case 143: 
      E();
      break;
    case 141: 
      this.h.r(8);
      break;
    case 140: 
    case 139: 
    case 138: 
    case 137: 
    case 136: 
    case 128: 
    case 129: 
    case 130: 
    case 131: 
    case 132: 
    case 133: 
    case 134: 
    case 135: 
      while (i3 <= 8)
      {
        if (this.h.g()) {
          this.l[(8 - i3)].l();
        }
        i3++;
        continue;
        paramInt = 1;
        while (paramInt <= 8)
        {
          if (this.h.g())
          {
            localObject = this.l[(8 - paramInt)];
            ((b)localObject).p(((b)localObject).k() ^ true);
          }
          paramInt++;
          continue;
          while (i1 <= 8)
          {
            if (this.h.g()) {
              this.l[(8 - i1)].p(false);
            }
            i1++;
            continue;
            paramInt = 1;
            while (paramInt <= 8)
            {
              if (this.h.g()) {
                this.l[(8 - paramInt)].p(true);
              }
              paramInt++;
              continue;
              while (i2 <= 8)
              {
                if (this.h.g()) {
                  this.l[(8 - i2)].e();
                }
                i2++;
                continue;
                paramInt -= 128;
                if (this.q != paramInt)
                {
                  this.q = paramInt;
                  this.m = this.l[paramInt];
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void s(int paramInt)
  {
    if (paramInt > 7) {
      if (paramInt <= 15) {
        this.h.r(8);
      } else if (paramInt <= 23) {
        this.h.r(16);
      } else if (paramInt <= 31) {
        this.h.r(24);
      }
    }
  }
  
  private void t(int paramInt)
  {
    if (paramInt <= 135)
    {
      this.h.r(32);
    }
    else if (paramInt <= 143)
    {
      this.h.r(40);
    }
    else if (paramInt <= 159)
    {
      this.h.r(2);
      paramInt = this.h.h(6);
      this.h.r(paramInt * 8);
    }
  }
  
  private void u(int paramInt)
  {
    b localb = this.l[paramInt];
    this.h.r(2);
    boolean bool1 = this.h.g();
    boolean bool2 = this.h.g();
    boolean bool3 = this.h.g();
    int i1 = this.h.h(3);
    boolean bool4 = this.h.g();
    int i2 = this.h.h(7);
    int i3 = this.h.h(8);
    int i4 = this.h.h(4);
    int i5 = this.h.h(4);
    this.h.r(2);
    paramInt = this.h.h(6);
    this.h.r(2);
    localb.f(bool1, bool2, bool3, i1, bool4, i2, i3, i5, paramInt, i4, this.h.h(3), this.h.h(3));
  }
  
  private void v(int paramInt)
  {
    if (paramInt == 127) {
      this.m.a('♫');
    } else {
      this.m.a((char)(paramInt & 0xFF));
    }
  }
  
  private void w(int paramInt)
  {
    this.m.a((char)(paramInt & 0xFF));
  }
  
  private void x(int paramInt)
  {
    if (paramInt != 32)
    {
      if (paramInt != 33)
      {
        if (paramInt != 37)
        {
          if (paramInt != 42)
          {
            if (paramInt != 44)
            {
              if (paramInt != 63)
              {
                if (paramInt != 57)
                {
                  if (paramInt != 58)
                  {
                    if (paramInt != 60)
                    {
                      if (paramInt != 61) {
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            StringBuilder localStringBuilder = new StringBuilder(33);
                            localStringBuilder.append("Invalid G2 character: ");
                            localStringBuilder.append(paramInt);
                            u.h("Cea708Decoder", localStringBuilder.toString());
                            break;
                          case 127: 
                            this.m.a('┌');
                            break;
                          case 126: 
                            this.m.a('┘');
                            break;
                          case 125: 
                            this.m.a('─');
                            break;
                          case 124: 
                            this.m.a('└');
                            break;
                          case 123: 
                            this.m.a('┐');
                            break;
                          case 122: 
                            this.m.a('│');
                            break;
                          case 121: 
                            this.m.a('⅞');
                            break;
                          case 120: 
                            this.m.a('⅝');
                            break;
                          case 119: 
                            this.m.a('⅜');
                            break;
                          case 118: 
                            this.m.a('⅛');
                          }
                          break;
                        case 53: 
                          this.m.a('•');
                          break;
                        case 52: 
                          this.m.a('”');
                          break;
                        case 51: 
                          this.m.a('“');
                          break;
                        case 50: 
                          this.m.a('’');
                          break;
                        case 49: 
                          this.m.a('‘');
                          break;
                        case 48: 
                          this.m.a('█');
                          break;
                        }
                      } else {
                        this.m.a('℠');
                      }
                    }
                    else {
                      this.m.a('œ');
                    }
                  }
                  else {
                    this.m.a('š');
                  }
                }
                else {
                  this.m.a('™');
                }
              }
              else {
                this.m.a('Ÿ');
              }
            }
            else {
              this.m.a('Œ');
            }
          }
          else {
            this.m.a('Š');
          }
        }
        else {
          this.m.a('…');
        }
      }
      else {
        this.m.a(' ');
      }
    }
    else {
      this.m.a(' ');
    }
  }
  
  private void y(int paramInt)
  {
    if (paramInt == 160)
    {
      this.m.a('㏄');
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder(33);
      localStringBuilder.append("Invalid G3 character: ");
      localStringBuilder.append(paramInt);
      u.h("Cea708Decoder", localStringBuilder.toString());
      this.m.a('_');
    }
  }
  
  private void z()
  {
    int i1 = this.h.h(4);
    int i2 = this.h.h(2);
    int i3 = this.h.h(2);
    boolean bool1 = this.h.g();
    boolean bool2 = this.h.g();
    int i4 = this.h.h(3);
    int i5 = this.h.h(3);
    this.m.m(i1, i2, i3, bool1, bool2, i4, i5);
  }
  
  protected com.google.android.exoplayer2.text.f e()
  {
    List localList = this.n;
    this.o = localList;
    return new f((List)g.e(localList));
  }
  
  protected void f(com.google.android.exoplayer2.text.i parami)
  {
    parami = (ByteBuffer)g.e(parami.f);
    Object localObject = parami.array();
    this.g.N((byte[])localObject, parami.limit());
    while (this.g.a() >= 3)
    {
      int i1 = this.g.D() & 0x7;
      int i2 = i1 & 0x3;
      boolean bool = false;
      if ((i1 & 0x4) == 4) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i3 = (byte)this.g.D();
      int i4 = (byte)this.g.D();
      if (((i2 == 2) || (i2 == 3)) && (i1 != 0))
      {
        if (i2 == 3)
        {
          o();
          i2 = (i3 & 0xC0) >> 6;
          i1 = this.i;
          if ((i1 != -1) && (i2 != (i1 + 1) % 4))
          {
            E();
            i1 = this.i;
            parami = new StringBuilder(71);
            parami.append("Sequence number discontinuity. previous=");
            parami.append(i1);
            parami.append(" current=");
            parami.append(i2);
            u.h("Cea708Decoder", parami.toString());
          }
          this.i = i2;
          i3 &= 0x3F;
          i1 = i3;
          if (i3 == 0) {
            i1 = 64;
          }
          localObject = new c(i2, i1);
          this.p = ((c)localObject);
          parami = ((c)localObject).c;
          i1 = ((c)localObject).d;
          ((c)localObject).d = (i1 + 1);
          parami[i1] = ((byte)i4);
        }
        else
        {
          if (i2 == 2) {
            bool = true;
          }
          g.a(bool);
          localObject = this.p;
          if (localObject == null)
          {
            u.c("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
            continue;
          }
          parami = ((c)localObject).c;
          i2 = ((c)localObject).d;
          i1 = i2 + 1;
          ((c)localObject).d = i1;
          parami[i2] = ((byte)i3);
          ((c)localObject).d = (i1 + 1);
          parami[i1] = ((byte)i4);
        }
        parami = this.p;
        if (parami.d == parami.b * 2 - 1) {
          o();
        }
      }
    }
  }
  
  public void flush()
  {
    super.flush();
    this.n = null;
    this.o = null;
    this.q = 0;
    this.m = this.l[0];
    E();
    this.p = null;
  }
  
  public String getName()
  {
    return "Cea708Decoder";
  }
  
  protected boolean k()
  {
    boolean bool;
    if (this.n != this.o) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static final class a
  {
    private static final Comparator<a> a = a.c;
    public final c b;
    public final int c;
    
    public a(CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, boolean paramBoolean, int paramInt4, int paramInt5)
    {
      paramCharSequence = new c.b().o(paramCharSequence).p(paramAlignment).h(paramFloat1, paramInt1).i(paramInt2).k(paramFloat2).l(paramInt3).n(paramFloat3);
      if (paramBoolean) {
        paramCharSequence.s(paramInt4);
      }
      this.b = paramCharSequence.a();
      this.c = paramInt5;
    }
  }
  
  private static final class b
  {
    public static final int a = h(2, 2, 2, 0);
    public static final int b;
    public static final int c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;
    private static final boolean[] g;
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;
    private static final int[] k;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private final List<SpannableString> l = new ArrayList();
    private final SpannableStringBuilder m = new SpannableStringBuilder();
    private boolean n;
    private boolean o;
    private int p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;
    
    static
    {
      int i1 = h(0, 0, 0, 0);
      b = i1;
      int i2 = h(0, 0, 0, 3);
      c = i2;
      d = new int[] { 0, 0, 0, 0, 0, 2, 0 };
      e = new int[] { 0, 0, 0, 0, 0, 0, 2 };
      f = new int[] { 3, 3, 3, 3, 3, 3, 1 };
      g = new boolean[] { 0, 0, 0, 1, 1, 1, 0 };
      h = new int[] { i1, i2, i1, i1, i2, i1, i1 };
      i = new int[] { 0, 1, 2, 3, 4, 3, 4 };
      j = new int[] { 0, 0, 0, 0, 0, 3, 3 };
      k = new int[] { i1, i1, i1, i1, i1, i2, i2 };
    }
    
    public b()
    {
      l();
    }
    
    public static int g(int paramInt1, int paramInt2, int paramInt3)
    {
      return h(paramInt1, paramInt2, paramInt3, 0);
    }
    
    public static int h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i1 = 0;
      g.c(paramInt1, 0, 4);
      g.c(paramInt2, 0, 4);
      g.c(paramInt3, 0, 4);
      g.c(paramInt4, 0, 4);
      if ((paramInt4 != 0) && (paramInt4 != 1)) {
        if (paramInt4 != 2)
        {
          if (paramInt4 == 3)
          {
            paramInt4 = 0;
            break label68;
          }
        }
        else
        {
          paramInt4 = 127;
          break label68;
        }
      }
      paramInt4 = 255;
      label68:
      if (paramInt1 > 1) {
        paramInt1 = 255;
      } else {
        paramInt1 = 0;
      }
      if (paramInt2 > 1) {
        paramInt2 = 255;
      } else {
        paramInt2 = 0;
      }
      if (paramInt3 > 1) {
        i1 = 255;
      }
      return Color.argb(paramInt4, paramInt1, paramInt2, i1);
    }
    
    public void a(char paramChar)
    {
      if (paramChar == '\n')
      {
        this.l.add(d());
        this.m.clear();
        if (this.A != -1) {
          this.A = 0;
        }
        if (this.B != -1) {
          this.B = 0;
        }
        if (this.C != -1) {
          this.C = 0;
        }
        if (this.E != -1) {
          this.E = 0;
        }
        while (((this.v) && (this.l.size() >= this.u)) || (this.l.size() >= 15)) {
          this.l.remove(0);
        }
      }
      this.m.append(paramChar);
    }
    
    public void b()
    {
      int i1 = this.m.length();
      if (i1 > 0) {
        this.m.delete(i1 - 1, i1);
      }
    }
    
    @Nullable
    public d.a c()
    {
      if (j()) {
        return null;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      boolean bool = false;
      for (int i1 = 0; i1 < this.l.size(); i1++)
      {
        localSpannableStringBuilder.append((CharSequence)this.l.get(i1));
        localSpannableStringBuilder.append('\n');
      }
      localSpannableStringBuilder.append(d());
      i1 = this.w;
      if (i1 != 0) {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              i1 = this.w;
              localObject = new StringBuilder(43);
              ((StringBuilder)localObject).append("Unexpected justification value: ");
              ((StringBuilder)localObject).append(i1);
              throw new IllegalArgumentException(((StringBuilder)localObject).toString());
            }
          }
          else
          {
            localObject = Layout.Alignment.ALIGN_CENTER;
            break label166;
          }
        }
        else
        {
          localObject = Layout.Alignment.ALIGN_OPPOSITE;
          break label166;
        }
      }
      Object localObject = Layout.Alignment.ALIGN_NORMAL;
      label166:
      float f1;
      float f2;
      if (this.q)
      {
        f1 = this.s / 99.0F;
        f2 = this.r / 99.0F;
      }
      else
      {
        f1 = this.s / 209.0F;
        f2 = this.r / 74.0F;
      }
      int i2 = this.t;
      if (i2 / 3 == 0) {
        i1 = 0;
      } else if (i2 / 3 == 1) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      if (i2 % 3 == 0) {
        i2 = 0;
      } else if (i2 % 3 == 1) {
        i2 = 1;
      } else {
        i2 = 2;
      }
      if (this.z != b) {
        bool = true;
      }
      return new d.a(localSpannableStringBuilder, (Layout.Alignment)localObject, f2 * 0.9F + 0.05F, 0, i1, f1 * 0.9F + 0.05F, i2, -3.4028235E38F, bool, this.z, this.p);
    }
    
    public SpannableString d()
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(this.m);
      int i1 = localSpannableStringBuilder.length();
      if (i1 > 0)
      {
        if (this.A != -1) {
          localSpannableStringBuilder.setSpan(new StyleSpan(2), this.A, i1, 33);
        }
        if (this.B != -1) {
          localSpannableStringBuilder.setSpan(new UnderlineSpan(), this.B, i1, 33);
        }
        if (this.C != -1) {
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, i1, 33);
        }
        if (this.E != -1) {
          localSpannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, i1, 33);
        }
      }
      return new SpannableString(localSpannableStringBuilder);
    }
    
    public void e()
    {
      this.l.clear();
      this.m.clear();
      this.A = -1;
      this.B = -1;
      this.C = -1;
      this.E = -1;
      this.G = 0;
    }
    
    public void f(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, boolean paramBoolean4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      this.n = true;
      this.o = paramBoolean1;
      this.v = paramBoolean2;
      this.p = paramInt1;
      this.q = paramBoolean4;
      this.r = paramInt2;
      this.s = paramInt3;
      this.t = paramInt6;
      paramInt1 = this.u;
      paramInt2 = paramInt4 + 1;
      if (paramInt1 != paramInt2)
      {
        this.u = paramInt2;
        while (((paramBoolean2) && (this.l.size() >= this.u)) || (this.l.size() >= 15)) {
          this.l.remove(0);
        }
      }
      if ((paramInt7 != 0) && (this.x != paramInt7))
      {
        this.x = paramInt7;
        paramInt1 = paramInt7 - 1;
        q(h[paramInt1], c, g[paramInt1], 0, e[paramInt1], f[paramInt1], d[paramInt1]);
      }
      if ((paramInt8 != 0) && (this.y != paramInt8))
      {
        this.y = paramInt8;
        paramInt1 = paramInt8 - 1;
        m(0, 1, 1, false, false, j[paramInt1], i[paramInt1]);
        n(a, k[paramInt1], b);
      }
    }
    
    public boolean i()
    {
      return this.n;
    }
    
    public boolean j()
    {
      boolean bool;
      if ((i()) && ((!this.l.isEmpty()) || (this.m.length() != 0))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    public boolean k()
    {
      return this.o;
    }
    
    public void l()
    {
      e();
      this.n = false;
      this.o = false;
      this.p = 4;
      this.q = false;
      this.r = 0;
      this.s = 0;
      this.t = 0;
      this.u = 15;
      this.v = true;
      this.w = 0;
      this.x = 0;
      this.y = 0;
      int i1 = b;
      this.z = i1;
      this.D = a;
      this.F = i1;
    }
    
    public void m(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, int paramInt4, int paramInt5)
    {
      if (this.A != -1)
      {
        if (!paramBoolean1)
        {
          this.m.setSpan(new StyleSpan(2), this.A, this.m.length(), 33);
          this.A = -1;
        }
      }
      else if (paramBoolean1) {
        this.A = this.m.length();
      }
      if (this.B != -1)
      {
        if (!paramBoolean2)
        {
          this.m.setSpan(new UnderlineSpan(), this.B, this.m.length(), 33);
          this.B = -1;
        }
      }
      else if (paramBoolean2) {
        this.B = this.m.length();
      }
    }
    
    public void n(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((this.C != -1) && (this.D != paramInt1)) {
        this.m.setSpan(new ForegroundColorSpan(this.D), this.C, this.m.length(), 33);
      }
      if (paramInt1 != a)
      {
        this.C = this.m.length();
        this.D = paramInt1;
      }
      if ((this.E != -1) && (this.F != paramInt2)) {
        this.m.setSpan(new BackgroundColorSpan(this.F), this.E, this.m.length(), 33);
      }
      if (paramInt2 != b)
      {
        this.E = this.m.length();
        this.F = paramInt2;
      }
    }
    
    public void o(int paramInt1, int paramInt2)
    {
      if (this.G != paramInt1) {
        a('\n');
      }
      this.G = paramInt1;
    }
    
    public void p(boolean paramBoolean)
    {
      this.o = paramBoolean;
    }
    
    public void q(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
    {
      this.z = paramInt1;
      this.w = paramInt6;
    }
  }
  
  private static final class c
  {
    public final int a;
    public final int b;
    public final byte[] c;
    int d;
    
    public c(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = new byte[paramInt2 * 2 - 1];
      this.d = 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\text\m\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */