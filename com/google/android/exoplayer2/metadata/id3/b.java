package com.google.android.exoplayer2.metadata.id3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.g;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.common.base.c;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class b
  extends g
{
  public static final a a = a.a;
  @Nullable
  private final a b;
  
  public b()
  {
    this(null);
  }
  
  public b(@Nullable a parama)
  {
    this.b = parama;
  }
  
  private static boolean A(d0 paramd0, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramd0.e();
    try
    {
      for (;;)
      {
        int j = paramd0.a();
        int k = 1;
        if (j < paramInt2) {
          break;
        }
        long l1;
        int n;
        if (paramInt1 >= 3)
        {
          j = paramd0.n();
          l1 = paramd0.F();
          m = paramd0.J();
        }
        else
        {
          j = paramd0.G();
          n = paramd0.G();
          l1 = n;
          m = 0;
        }
        if ((j == 0) && (l1 == 0L) && (m == 0)) {
          return true;
        }
        long l2 = l1;
        if (paramInt1 == 4)
        {
          l2 = l1;
          if (!paramBoolean)
          {
            if ((0x808080 & l1) != 0L) {
              return false;
            }
            l2 = (l1 >> 24 & 0xFF) << 21 | l1 & 0xFF | (l1 >> 8 & 0xFF) << 7 | (l1 >> 16 & 0xFF) << 14;
          }
        }
        if (paramInt1 == 4)
        {
          if ((m & 0x40) != 0) {
            n = 1;
          } else {
            n = 0;
          }
          j = n;
          if ((m & 0x1) != 0)
          {
            j = n;
            n = k;
            break label277;
          }
        }
        for (;;)
        {
          n = 0;
          break;
          if (paramInt1 == 3)
          {
            if ((m & 0x20) != 0) {
              n = 1;
            } else {
              n = 0;
            }
            j = n;
            if ((m & 0x80) != 0)
            {
              j = n;
              n = k;
              break;
            }
          }
          else
          {
            j = 0;
          }
        }
        label277:
        int m = j;
        if (n != 0) {
          m = j + 4;
        }
        if (l2 < m) {
          return false;
        }
        j = paramd0.a();
        if (j < l2) {
          return false;
        }
        j = (int)l2;
        paramd0.Q(j);
      }
      return true;
    }
    finally
    {
      paramd0.P(i);
    }
  }
  
  private static byte[] c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= paramInt1) {
      return o0.f;
    }
    return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private static ApicFrame e(d0 paramd0, int paramInt1, int paramInt2)
    throws UnsupportedEncodingException
  {
    int i = paramd0.D();
    String str1 = u(i);
    int j = paramInt1 - 1;
    byte[] arrayOfByte = new byte[j];
    paramd0.j(arrayOfByte, 0, j);
    String str2;
    if (paramInt2 == 2)
    {
      paramd0 = String.valueOf(c.e(new String(arrayOfByte, 0, 3, "ISO-8859-1")));
      if (paramd0.length() != 0) {
        str2 = "image/".concat(paramd0);
      } else {
        str2 = new String("image/");
      }
      paramd0 = str2;
      if ("image/jpg".equals(str2)) {
        paramd0 = "image/jpeg";
      }
      paramInt1 = 2;
    }
    else
    {
      paramInt1 = x(arrayOfByte, 0);
      str2 = c.e(new String(arrayOfByte, 0, paramInt1, "ISO-8859-1"));
      paramd0 = str2;
      if (str2.indexOf('/') == -1) {
        if (str2.length() != 0) {
          paramd0 = "image/".concat(str2);
        } else {
          paramd0 = new String("image/");
        }
      }
    }
    paramInt2 = arrayOfByte[(paramInt1 + 1)];
    int k = paramInt1 + 2;
    paramInt1 = w(arrayOfByte, k, i);
    return new ApicFrame(paramd0, new String(arrayOfByte, k, paramInt1 - k, str1), paramInt2 & 0xFF, c(arrayOfByte, paramInt1 + t(i), j));
  }
  
  private static BinaryFrame f(d0 paramd0, int paramInt, String paramString)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramd0.j(arrayOfByte, 0, paramInt);
    return new BinaryFrame(paramString, arrayOfByte);
  }
  
  private static ChapterFrame g(d0 paramd0, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, @Nullable a parama)
    throws UnsupportedEncodingException
  {
    int i = paramd0.e();
    int j = x(paramd0.d(), i);
    String str = new String(paramd0.d(), i, j - i, "ISO-8859-1");
    paramd0.P(j + 1);
    j = paramd0.n();
    int k = paramd0.n();
    long l1 = paramd0.F();
    if (l1 == 4294967295L) {
      l1 = -1L;
    }
    long l2 = paramd0.F();
    if (l2 == 4294967295L) {
      l2 = -1L;
    }
    ArrayList localArrayList = new ArrayList();
    while (paramd0.e() < i + paramInt1)
    {
      Id3Frame localId3Frame = j(paramInt2, paramd0, paramBoolean, paramInt3, parama);
      if (localId3Frame != null) {
        localArrayList.add(localId3Frame);
      }
    }
    return new ChapterFrame(str, j, k, l1, l2, (Id3Frame[])localArrayList.toArray(new Id3Frame[0]));
  }
  
  private static ChapterTocFrame h(d0 paramd0, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, @Nullable a parama)
    throws UnsupportedEncodingException
  {
    int i = paramd0.e();
    int j = x(paramd0.d(), i);
    String str = new String(paramd0.d(), i, j - i, "ISO-8859-1");
    paramd0.P(j + 1);
    j = paramd0.D();
    boolean bool1;
    if ((j & 0x2) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if ((j & 0x1) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    int k = paramd0.D();
    String[] arrayOfString = new String[k];
    for (j = 0; j < k; j++)
    {
      int m = paramd0.e();
      int n = x(paramd0.d(), m);
      arrayOfString[j] = new String(paramd0.d(), m, n - m, "ISO-8859-1");
      paramd0.P(n + 1);
    }
    ArrayList localArrayList = new ArrayList();
    while (paramd0.e() < i + paramInt1)
    {
      Id3Frame localId3Frame = j(paramInt2, paramd0, paramBoolean, paramInt3, parama);
      if (localId3Frame != null) {
        localArrayList.add(localId3Frame);
      }
    }
    return new ChapterTocFrame(str, bool1, bool2, arrayOfString, (Id3Frame[])localArrayList.toArray(new Id3Frame[0]));
  }
  
  @Nullable
  private static CommentFrame i(d0 paramd0, int paramInt)
    throws UnsupportedEncodingException
  {
    if (paramInt < 4) {
      return null;
    }
    int i = paramd0.D();
    String str = u(i);
    Object localObject = new byte[3];
    paramd0.j((byte[])localObject, 0, 3);
    localObject = new String((byte[])localObject, 0, 3);
    paramInt -= 4;
    byte[] arrayOfByte = new byte[paramInt];
    paramd0.j(arrayOfByte, 0, paramInt);
    paramInt = w(arrayOfByte, 0, i);
    paramd0 = new String(arrayOfByte, 0, paramInt, str);
    paramInt += t(i);
    return new CommentFrame((String)localObject, paramd0, o(arrayOfByte, paramInt, w(arrayOfByte, paramInt, i), str));
  }
  
  @Nullable
  private static Id3Frame j(int paramInt1, d0 paramd0, boolean paramBoolean, int paramInt2, @Nullable a parama)
  {
    int i = paramd0.D();
    int j = paramd0.D();
    int k = paramd0.D();
    int m;
    if (paramInt1 >= 3) {
      m = paramd0.D();
    } else {
      m = 0;
    }
    int n;
    int i1;
    if (paramInt1 == 4)
    {
      n = paramd0.H();
      i1 = n;
      if (!paramBoolean) {
        i1 = (n >> 24 & 0xFF) << 21 | n & 0xFF | (n >> 8 & 0xFF) << 7 | (n >> 16 & 0xFF) << 14;
      }
    }
    int i2;
    for (;;)
    {
      i2 = i1;
      break;
      if (paramInt1 == 3) {
        i1 = paramd0.H();
      } else {
        i1 = paramd0.G();
      }
    }
    if (paramInt1 >= 3) {
      i1 = paramd0.J();
    } else {
      i1 = 0;
    }
    if ((i == 0) && (j == 0) && (k == 0) && (m == 0) && (i2 == 0) && (i1 == 0))
    {
      paramd0.P(paramd0.f());
      return null;
    }
    int i3 = paramd0.e() + i2;
    if (i3 > paramd0.f())
    {
      u.h("Id3Decoder", "Frame size exceeds remaining tag data");
      paramd0.P(paramd0.f());
      return null;
    }
    if ((parama != null) && (!parama.a(paramInt1, i, j, k, m)))
    {
      paramd0.P(i3);
      return null;
    }
    int i4 = i1;
    int i5;
    int i6;
    if (paramInt1 == 3)
    {
      if ((i4 & 0x80) != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i4 & 0x40) != 0) {
        i5 = 1;
      } else {
        i5 = 0;
      }
      if ((i4 & 0x20) != 0) {
        i6 = 1;
      } else {
        i6 = 0;
      }
      i4 = i1;
      n = 0;
    }
    else if (paramInt1 == 4)
    {
      if ((i4 & 0x40) != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i4 & 0x8) != 0) {
        i6 = 1;
      } else {
        i6 = 0;
      }
      if ((i4 & 0x4) != 0) {
        i5 = 1;
      } else {
        i5 = 0;
      }
      if ((i4 & 0x2) != 0) {
        n = 1;
      } else {
        n = 0;
      }
      if ((i4 & 0x1) != 0) {
        i4 = 1;
      } else {
        i4 = 0;
      }
      int i7 = i4;
      i4 = i6;
      i6 = i1;
      i1 = i7;
    }
    else
    {
      i6 = 0;
      i1 = 0;
      i5 = 0;
      n = 0;
      i4 = 0;
    }
    if ((i4 == 0) && (i5 == 0))
    {
      i5 = i2;
      if (i6 != 0)
      {
        i5 = i2 - 1;
        paramd0.Q(1);
      }
      i6 = i5;
      if (i1 != 0)
      {
        i6 = i5 - 4;
        paramd0.Q(4);
      }
      i1 = i6;
      if (n != 0) {
        i1 = z(paramd0, i6);
      }
      if ((i == 84) && (j == 88) && (k == 88) && ((paramInt1 == 2) || (m == 88))) {}
      try
      {
        try
        {
          parama = q(paramd0, i1);
        }
        finally
        {
          break label1126;
        }
        if (i == 84) {
          parama = p(paramd0, i1, v(paramInt1, i, j, k, m));
        } else if ((i == 87) && (j == 88) && (k == 88) && ((paramInt1 == 2) || (m == 88))) {
          parama = s(paramd0, i1);
        } else if (i == 87) {
          parama = r(paramd0, i1, v(paramInt1, i, j, k, m));
        } else if ((i == 80) && (j == 82) && (k == 73) && (m == 86)) {
          parama = n(paramd0, i1);
        } else if ((i == 71) && (j == 69) && (k == 79) && ((m == 66) || (paramInt1 == 2))) {
          parama = k(paramd0, i1);
        } else if (paramInt1 == 2 ? (i == 80) && (j == 73) && (k == 67) : (i == 65) && (j == 80) && (k == 73) && (m == 67)) {
          parama = e(paramd0, i1, paramInt1);
        } else if ((i == 67) && (j == 79) && (k == 77) && ((m == 77) || (paramInt1 == 2))) {
          parama = i(paramd0, i1);
        } else if ((i == 67) && (j == 72) && (k == 65) && (m == 80)) {
          parama = g(paramd0, i1, paramInt1, paramBoolean, paramInt2, parama);
        } else if ((i == 67) && (j == 84) && (k == 79) && (m == 67)) {
          parama = h(paramd0, i1, paramInt1, paramBoolean, paramInt2, parama);
        } else if ((i == 77) && (j == 76) && (k == 76) && (m == 84)) {
          parama = m(paramd0, i1);
        } else {
          parama = f(paramd0, i1, v(paramInt1, i, j, k, m));
        }
        if (parama == null)
        {
          String str = v(paramInt1, i, j, k, m);
          paramInt1 = String.valueOf(str).length();
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>(paramInt1 + 50);
          localStringBuilder.append("Failed to decode frame: id=");
          localStringBuilder.append(str);
          localStringBuilder.append(", frameSize=");
          localStringBuilder.append(i1);
          u.h("Id3Decoder", localStringBuilder.toString());
        }
        paramd0.P(i3);
        return parama;
      }
      catch (UnsupportedEncodingException parama)
      {
        u.h("Id3Decoder", "Unsupported character encoding");
        paramd0.P(i3);
        return null;
      }
      label1126:
      paramd0.P(i3);
      throw parama;
    }
    u.h("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
    paramd0.P(i3);
    return null;
  }
  
  private static GeobFrame k(d0 paramd0, int paramInt)
    throws UnsupportedEncodingException
  {
    int i = paramd0.D();
    String str1 = u(i);
    paramInt--;
    byte[] arrayOfByte = new byte[paramInt];
    paramd0.j(arrayOfByte, 0, paramInt);
    int j = x(arrayOfByte, 0);
    String str2 = new String(arrayOfByte, 0, j, "ISO-8859-1");
    j++;
    int k = w(arrayOfByte, j, i);
    paramd0 = o(arrayOfByte, j, k, str1);
    k += t(i);
    j = w(arrayOfByte, k, i);
    return new GeobFrame(str2, paramd0, o(arrayOfByte, k, j, str1), c(arrayOfByte, j + t(i), paramInt));
  }
  
  @Nullable
  private static b l(d0 paramd0)
  {
    if (paramd0.a() < 10)
    {
      u.h("Id3Decoder", "Data too short to be an ID3 tag");
      return null;
    }
    int i = paramd0.G();
    boolean bool1 = false;
    if (i != 4801587)
    {
      paramd0 = String.valueOf(String.format("%06X", new Object[] { Integer.valueOf(i) }));
      if (paramd0.length() != 0) {
        paramd0 = "Unexpected first three bytes of ID3 tag header: 0x".concat(paramd0);
      } else {
        paramd0 = new String("Unexpected first three bytes of ID3 tag header: 0x");
      }
      u.h("Id3Decoder", paramd0);
      return null;
    }
    int j = paramd0.D();
    paramd0.Q(1);
    int k = paramd0.D();
    int m = paramd0.C();
    int n;
    if (j == 2)
    {
      if ((k & 0x40) != 0) {
        n = 1;
      } else {
        n = 0;
      }
      i = m;
      if (n != 0)
      {
        u.h("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
        return null;
      }
    }
    else if (j == 3)
    {
      if ((k & 0x40) != 0) {
        n = 1;
      } else {
        n = 0;
      }
      i = m;
      if (n != 0)
      {
        i = paramd0.n();
        paramd0.Q(i);
        i = m - (i + 4);
      }
    }
    else
    {
      if (j != 4) {
        break label315;
      }
      if ((k & 0x40) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      n = m;
      if (i != 0)
      {
        i = paramd0.C();
        paramd0.Q(i - 4);
        n = m - i;
      }
      if ((k & 0x10) != 0) {
        m = 1;
      } else {
        m = 0;
      }
      i = n;
      if (m != 0) {
        i = n - 10;
      }
    }
    boolean bool2 = bool1;
    if (j < 4)
    {
      bool2 = bool1;
      if ((k & 0x80) != 0) {
        bool2 = true;
      }
    }
    return new b(j, bool2, i);
    label315:
    paramd0 = new StringBuilder(57);
    paramd0.append("Skipped ID3 tag with unsupported majorVersion=");
    paramd0.append(j);
    u.h("Id3Decoder", paramd0.toString());
    return null;
  }
  
  private static MlltFrame m(d0 paramd0, int paramInt)
  {
    int i = paramd0.J();
    int j = paramd0.G();
    int k = paramd0.G();
    int m = paramd0.D();
    int n = paramd0.D();
    c0 localc0 = new c0();
    localc0.m(paramd0);
    int i1 = (paramInt - 10) * 8 / (m + n);
    int[] arrayOfInt = new int[i1];
    paramd0 = new int[i1];
    for (paramInt = 0; paramInt < i1; paramInt++)
    {
      int i2 = localc0.h(m);
      int i3 = localc0.h(n);
      arrayOfInt[paramInt] = i2;
      paramd0[paramInt] = i3;
    }
    return new MlltFrame(i, j, k, arrayOfInt, paramd0);
  }
  
  private static PrivFrame n(d0 paramd0, int paramInt)
    throws UnsupportedEncodingException
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramd0.j(arrayOfByte, 0, paramInt);
    int i = x(arrayOfByte, 0);
    return new PrivFrame(new String(arrayOfByte, 0, i, "ISO-8859-1"), c(arrayOfByte, i + 1, paramInt));
  }
  
  private static String o(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
    throws UnsupportedEncodingException
  {
    if ((paramInt2 > paramInt1) && (paramInt2 <= paramArrayOfByte.length)) {
      return new String(paramArrayOfByte, paramInt1, paramInt2 - paramInt1, paramString);
    }
    return "";
  }
  
  @Nullable
  private static TextInformationFrame p(d0 paramd0, int paramInt, String paramString)
    throws UnsupportedEncodingException
  {
    if (paramInt < 1) {
      return null;
    }
    int i = paramd0.D();
    String str = u(i);
    paramInt--;
    byte[] arrayOfByte = new byte[paramInt];
    paramd0.j(arrayOfByte, 0, paramInt);
    return new TextInformationFrame(paramString, null, new String(arrayOfByte, 0, w(arrayOfByte, 0, i), str));
  }
  
  @Nullable
  private static TextInformationFrame q(d0 paramd0, int paramInt)
    throws UnsupportedEncodingException
  {
    if (paramInt < 1) {
      return null;
    }
    int i = paramd0.D();
    String str = u(i);
    paramInt--;
    byte[] arrayOfByte = new byte[paramInt];
    paramd0.j(arrayOfByte, 0, paramInt);
    paramInt = w(arrayOfByte, 0, i);
    paramd0 = new String(arrayOfByte, 0, paramInt, str);
    paramInt += t(i);
    return new TextInformationFrame("TXXX", paramd0, o(arrayOfByte, paramInt, w(arrayOfByte, paramInt, i), str));
  }
  
  private static UrlLinkFrame r(d0 paramd0, int paramInt, String paramString)
    throws UnsupportedEncodingException
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramd0.j(arrayOfByte, 0, paramInt);
    return new UrlLinkFrame(paramString, null, new String(arrayOfByte, 0, x(arrayOfByte, 0), "ISO-8859-1"));
  }
  
  @Nullable
  private static UrlLinkFrame s(d0 paramd0, int paramInt)
    throws UnsupportedEncodingException
  {
    if (paramInt < 1) {
      return null;
    }
    int i = paramd0.D();
    String str = u(i);
    paramInt--;
    byte[] arrayOfByte = new byte[paramInt];
    paramd0.j(arrayOfByte, 0, paramInt);
    paramInt = w(arrayOfByte, 0, i);
    paramd0 = new String(arrayOfByte, 0, paramInt, str);
    paramInt += t(i);
    return new UrlLinkFrame("WXXX", paramd0, o(arrayOfByte, paramInt, x(arrayOfByte, paramInt), "ISO-8859-1"));
  }
  
  private static int t(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 3)) {
      paramInt = 2;
    } else {
      paramInt = 1;
    }
    return paramInt;
  }
  
  private static String u(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "ISO-8859-1";
        }
        return "UTF-8";
      }
      return "UTF-16BE";
    }
    return "UTF-16";
  }
  
  private static String v(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    String str;
    if (paramInt1 == 2) {
      str = String.format(Locale.US, "%c%c%c", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    } else {
      str = String.format(Locale.US, "%c%c%c%c", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
    }
    return str;
  }
  
  private static int w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = x(paramArrayOfByte, paramInt1);
    if (paramInt2 != 0)
    {
      paramInt1 = i;
      if (paramInt2 != 3)
      {
        while (paramInt1 < paramArrayOfByte.length - 1)
        {
          if ((paramInt1 % 2 == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 0)) {
            return paramInt1;
          }
          paramInt1 = x(paramArrayOfByte, paramInt1 + 1);
        }
        return paramArrayOfByte.length;
      }
    }
    return i;
  }
  
  private static int x(byte[] paramArrayOfByte, int paramInt)
  {
    while (paramInt < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[paramInt] == 0) {
        return paramInt;
      }
      paramInt++;
    }
    return paramArrayOfByte.length;
  }
  
  private static int z(d0 paramd0, int paramInt)
  {
    byte[] arrayOfByte = paramd0.d();
    int i = paramd0.e();
    int j = i;
    for (int k = paramInt;; k = paramInt)
    {
      int m = j + 1;
      if (m >= i + k) {
        break;
      }
      paramInt = k;
      if ((arrayOfByte[j] & 0xFF) == 255)
      {
        paramInt = k;
        if (arrayOfByte[m] == 0)
        {
          System.arraycopy(arrayOfByte, j + 2, arrayOfByte, m, k - (j - i) - 2);
          paramInt = k - 1;
        }
      }
      j = m;
    }
    return k;
  }
  
  @Nullable
  protected Metadata b(d paramd, ByteBuffer paramByteBuffer)
  {
    return d(paramByteBuffer.array(), paramByteBuffer.limit());
  }
  
  @Nullable
  public Metadata d(byte[] paramArrayOfByte, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    d0 locald0 = new d0(paramArrayOfByte, paramInt);
    b localb = l(locald0);
    if (localb == null) {
      return null;
    }
    int i = locald0.e();
    if (b.a(localb) == 2) {
      paramInt = 6;
    } else {
      paramInt = 10;
    }
    int j = b.b(localb);
    if (b.c(localb)) {
      j = z(locald0, b.b(localb));
    }
    locald0.O(i + j);
    j = b.a(localb);
    boolean bool = false;
    if (!A(locald0, j, paramInt, false)) {
      if ((b.a(localb) == 4) && (A(locald0, 4, paramInt, true)))
      {
        bool = true;
      }
      else
      {
        paramInt = b.a(localb);
        paramArrayOfByte = new StringBuilder(56);
        paramArrayOfByte.append("Failed to validate ID3 tag with majorVersion=");
        paramArrayOfByte.append(paramInt);
        u.h("Id3Decoder", paramArrayOfByte.toString());
        return null;
      }
    }
    while (locald0.a() >= paramInt)
    {
      paramArrayOfByte = j(b.a(localb), locald0, bool, paramInt, this.b);
      if (paramArrayOfByte != null) {
        localArrayList.add(paramArrayOfByte);
      }
    }
    return new Metadata(localArrayList);
  }
  
  public static abstract interface a
  {
    public abstract boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  }
  
  private static final class b
  {
    private final int a;
    private final boolean b;
    private final int c;
    
    public b(int paramInt1, boolean paramBoolean, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramBoolean;
      this.c = paramInt2;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */