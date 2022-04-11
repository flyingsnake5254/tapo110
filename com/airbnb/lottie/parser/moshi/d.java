package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;

final class d
  extends JsonReader
{
  private static final ByteString H3 = ByteString.encodeUtf8("*/");
  private static final ByteString p0 = ByteString.encodeUtf8("'\\");
  private static final ByteString p1 = ByteString.encodeUtf8("\"\\");
  private static final ByteString p2 = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
  private static final ByteString p3 = ByteString.encodeUtf8("\n\r");
  private final BufferedSource I3;
  private final Buffer J3;
  private int K3 = 0;
  private long L3;
  private int M3;
  @Nullable
  private String N3;
  
  d(BufferedSource paramBufferedSource)
  {
    Objects.requireNonNull(paramBufferedSource, "source == null");
    this.I3 = paramBufferedSource;
    this.J3 = paramBufferedSource.getBuffer();
    x(6);
  }
  
  private void D()
    throws IOException
  {
    if (this.y) {
      return;
    }
    throw C("Use JsonReader.setLenient(true) to accept malformed JSON");
  }
  
  private int E()
    throws IOException
  {
    int[] arrayOfInt = this.f;
    int i = this.d;
    int j = arrayOfInt[(i - 1)];
    if (j == 1)
    {
      arrayOfInt[(i - 1)] = 2;
    }
    else if (j == 2)
    {
      i = H(true);
      this.J3.readByte();
      if (i != 44)
      {
        if (i != 59)
        {
          if (i == 93)
          {
            this.K3 = 4;
            return 4;
          }
          throw C("Unterminated array");
        }
        D();
      }
    }
    else
    {
      if ((j == 3) || (j == 5)) {
        break label475;
      }
      if (j == 4)
      {
        arrayOfInt[(i - 1)] = 5;
        i = H(true);
        this.J3.readByte();
        if (i != 58) {
          if (i == 61)
          {
            D();
            if ((this.I3.request(1L)) && (this.J3.getByte(0L) == 62)) {
              this.J3.readByte();
            }
          }
          else
          {
            throw C("Expected ':'");
          }
        }
      }
      else if (j == 6)
      {
        arrayOfInt[(i - 1)] = 7;
      }
      else if (j == 7)
      {
        if (H(false) == -1)
        {
          this.K3 = 18;
          return 18;
        }
        D();
      }
      else
      {
        if (j == 8) {
          break label465;
        }
      }
    }
    i = H(true);
    if (i != 34)
    {
      if (i != 39)
      {
        if ((i != 44) && (i != 59)) {
          if (i != 91)
          {
            if (i != 93)
            {
              if (i != 123)
              {
                j = K();
                if (j != 0) {
                  return j;
                }
                j = L();
                if (j != 0) {
                  return j;
                }
                if (G(this.J3.getByte(0L)))
                {
                  D();
                  this.K3 = 10;
                  return 10;
                }
                throw C("Expected value");
              }
              this.J3.readByte();
              this.K3 = 1;
              return 1;
            }
            if (j == 1)
            {
              this.J3.readByte();
              this.K3 = 4;
              return 4;
            }
          }
          else
          {
            this.J3.readByte();
            this.K3 = 3;
            return 3;
          }
        }
        if ((j != 1) && (j != 2)) {
          throw C("Unexpected value");
        }
        D();
        this.K3 = 7;
        return 7;
      }
      D();
      this.J3.readByte();
      this.K3 = 8;
      return 8;
    }
    this.J3.readByte();
    this.K3 = 9;
    return 9;
    label465:
    throw new IllegalStateException("JsonReader is closed");
    label475:
    arrayOfInt[(i - 1)] = 4;
    if (j == 5)
    {
      i = H(true);
      this.J3.readByte();
      if (i != 44)
      {
        if (i != 59)
        {
          if (i == 125)
          {
            this.K3 = 2;
            return 2;
          }
          throw C("Unterminated object");
        }
        D();
      }
    }
    i = H(true);
    if (i != 34)
    {
      if (i != 39)
      {
        if (i != 125)
        {
          D();
          if (G((char)i))
          {
            this.K3 = 14;
            return 14;
          }
          throw C("Expected name");
        }
        if (j != 5)
        {
          this.J3.readByte();
          this.K3 = 2;
          return 2;
        }
        throw C("Expected name");
      }
      this.J3.readByte();
      D();
      this.K3 = 12;
      return 12;
    }
    this.J3.readByte();
    this.K3 = 13;
    return 13;
  }
  
  private int F(String paramString, JsonReader.a parama)
  {
    int i = parama.a.length;
    for (int j = 0; j < i; j++) {
      if (paramString.equals(parama.a[j]))
      {
        this.K3 = 0;
        this.q[(this.d - 1)] = paramString;
        return j;
      }
    }
    return -1;
  }
  
  private boolean G(int paramInt)
    throws IOException
  {
    if ((paramInt != 9) && (paramInt != 10) && (paramInt != 12) && (paramInt != 13) && (paramInt != 32))
    {
      if (paramInt != 35)
      {
        if (paramInt == 44) {
          break label110;
        }
        if ((paramInt != 47) && (paramInt != 61))
        {
          if ((paramInt == 123) || (paramInt == 125) || (paramInt == 58)) {
            break label110;
          }
          if (paramInt == 59) {}
        }
      }
      switch (paramInt)
      {
      default: 
        return true;
      case 92: 
        D();
      }
    }
    label110:
    return false;
  }
  
  private int H(boolean paramBoolean)
    throws IOException
  {
    int j;
    for (int i = 0;; i = j)
    {
      BufferedSource localBufferedSource = this.I3;
      j = i + 1;
      if (!localBufferedSource.request(j)) {
        break label207;
      }
      i = this.J3.getByte(i);
      if ((i != 10) && (i != 32) && (i != 13) && (i != 9))
      {
        this.J3.skip(j - 1);
        if (i == 47)
        {
          if (!this.I3.request(2L)) {
            return i;
          }
          D();
          j = this.J3.getByte(1L);
          if (j != 42)
          {
            if (j != 47) {
              return i;
            }
            this.J3.readByte();
            this.J3.readByte();
            P();
            break;
          }
          this.J3.readByte();
          this.J3.readByte();
          if (O()) {
            break;
          }
          throw C("Unterminated comment");
        }
        if (i == 35)
        {
          D();
          P();
          break;
        }
        return i;
      }
    }
    label207:
    if (!paramBoolean) {
      return -1;
    }
    throw new EOFException("End of input");
  }
  
  private String I(ByteString paramByteString)
    throws IOException
  {
    long l;
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      l = this.I3.indexOfElement(paramByteString);
      if (l == -1L) {
        break label137;
      }
      if (this.J3.getByte(l) != 92) {
        break;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(this.J3.readUtf8(l));
      this.J3.readByte();
      ((StringBuilder)localObject2).append(M());
    }
    if (localObject1 == null)
    {
      paramByteString = this.J3.readUtf8(l);
      this.J3.readByte();
      return paramByteString;
    }
    ((StringBuilder)localObject1).append(this.J3.readUtf8(l));
    this.J3.readByte();
    return ((StringBuilder)localObject1).toString();
    label137:
    throw C("Unterminated string");
  }
  
  private String J()
    throws IOException
  {
    long l = this.I3.indexOfElement(p2);
    String str;
    if (l != -1L) {
      str = this.J3.readUtf8(l);
    } else {
      str = this.J3.readUtf8();
    }
    return str;
  }
  
  private int K()
    throws IOException
  {
    int i = this.J3.getByte(0L);
    String str1;
    String str2;
    if ((i != 116) && (i != 84))
    {
      if ((i != 102) && (i != 70))
      {
        if ((i != 110) && (i != 78)) {
          return 0;
        }
        i = 7;
        str1 = "null";
        str2 = "NULL";
      }
      else
      {
        i = 6;
        str1 = "false";
        str2 = "FALSE";
      }
    }
    else
    {
      i = 5;
      str1 = "true";
      str2 = "TRUE";
    }
    int j = str1.length();
    int m;
    for (int k = 1; k < j; k = m)
    {
      BufferedSource localBufferedSource = this.I3;
      m = k + 1;
      if (!localBufferedSource.request(m)) {
        return 0;
      }
      int n = this.J3.getByte(k);
      if ((n != str1.charAt(k)) && (n != str2.charAt(k))) {
        return 0;
      }
    }
    if ((this.I3.request(j + 1)) && (G(this.J3.getByte(j)))) {
      return 0;
    }
    this.J3.skip(j);
    this.K3 = i;
    return i;
  }
  
  private int L()
    throws IOException
  {
    int i = 0;
    long l1 = 0L;
    int k = 0;
    int m = 0;
    int n = 1;
    int i1 = 0;
    int j;
    for (;;)
    {
      BufferedSource localBufferedSource = this.I3;
      int i2 = k + 1;
      if (localBufferedSource.request(i2))
      {
        int i3 = this.J3.getByte(k);
        if (i3 == 43) {
          break label446;
        }
        if ((i3 == 69) || (i3 == 101)) {
          break label423;
        }
        if (i3 == 45) {
          break label398;
        }
        if (i3 == 46) {
          break label384;
        }
        if ((i3 >= 48) && (i3 <= 57))
        {
          if ((m != 1) && (m != 0))
          {
            long l2;
            if (m == 2)
            {
              if (l1 == 0L) {
                return i;
              }
              l2 = 10L * l1 - (i3 - 48);
              j = l1 < -922337203685477580L;
              if ((j <= 0) && ((j != 0) || (l2 >= l1))) {
                j = 0;
              } else {
                j = 1;
              }
              k = n & j;
            }
            else
            {
              if (m == 3)
              {
                j = 0;
                m = 4;
                break label456;
              }
              if (m == 5) {
                break label239;
              }
              k = n;
              l2 = l1;
              if (m == 6) {
                break label239;
              }
            }
            j = 0;
            n = k;
            l1 = l2;
            break label456;
            label239:
            j = 0;
            m = 7;
            break label456;
          }
          l1 = -(i3 - 48);
          j = 0;
          m = 2;
          break label456;
        }
        if (G(i3)) {}
      }
      else
      {
        if ((m == 2) && (n != 0) && ((l1 != Long.MIN_VALUE) || (i1 != 0)) && ((l1 != 0L) || (i1 == 0)))
        {
          if (i1 == 0) {
            l1 = -l1;
          }
          this.L3 = l1;
          this.J3.skip(k);
          this.K3 = 16;
          return 16;
        }
        if ((m != 2) && (m != 4) && (m != 7)) {
          return 0;
        }
        this.M3 = k;
        this.K3 = 17;
        return 17;
      }
      return 0;
      label384:
      if (m == 2)
      {
        m = 3;
      }
      else
      {
        return j;
        label398:
        if (m == 0)
        {
          m = 1;
          i1 = 1;
        }
        else if (m != 5)
        {
          return j;
          label423:
          if ((m != 2) && (m != 4)) {
            return j;
          }
          m = 5;
          break label456;
          label446:
          if (m != 5) {
            break;
          }
        }
        else
        {
          m = 6;
        }
      }
      label456:
      k = i2;
    }
    return j;
  }
  
  private char M()
    throws IOException
  {
    if (this.I3.request(1L))
    {
      int i = this.J3.readByte();
      if ((i != 10) && (i != 34) && (i != 39) && (i != 47) && (i != 92))
      {
        if (i != 98)
        {
          if (i != 102)
          {
            if (i != 110)
            {
              if (i != 114)
              {
                if (i != 116)
                {
                  if (i != 117)
                  {
                    if (this.y) {
                      return (char)i;
                    }
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("Invalid escape sequence: \\");
                    localStringBuilder.append((char)i);
                    throw C(localStringBuilder.toString());
                  }
                  if (this.I3.request(4L))
                  {
                    i = 0;
                    int j = 0;
                    int k = j;
                    while (i < 4)
                    {
                      j = this.J3.getByte(i);
                      int m = (char)(k << 4);
                      if ((j >= 48) && (j <= 57))
                      {
                        j -= 48;
                        j = (char)(m + j);
                      }
                      else
                      {
                        if ((j >= 97) && (j <= 102)) {
                          j -= 97;
                        }
                        for (;;)
                        {
                          j += 10;
                          break;
                          if ((j < 65) || (j > 70)) {
                            break label244;
                          }
                          j -= 65;
                        }
                      }
                      i++;
                      k = j;
                      continue;
                      label244:
                      localStringBuilder = new StringBuilder();
                      localStringBuilder.append("\\u");
                      localStringBuilder.append(this.J3.readUtf8(4L));
                      throw C(localStringBuilder.toString());
                    }
                    this.J3.skip(4L);
                    return k;
                  }
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("Unterminated escape sequence at path ");
                  localStringBuilder.append(getPath());
                  throw new EOFException(localStringBuilder.toString());
                }
                return '\t';
              }
              return '\r';
            }
            return '\n';
          }
          return '\f';
        }
        return '\b';
      }
      return (char)i;
    }
    throw C("Unterminated escape sequence");
  }
  
  private void N(ByteString paramByteString)
    throws IOException
  {
    long l;
    for (;;)
    {
      l = this.I3.indexOfElement(paramByteString);
      if (l == -1L) {
        break label61;
      }
      if (this.J3.getByte(l) != 92) {
        break;
      }
      this.J3.skip(l + 1L);
      M();
    }
    this.J3.skip(l + 1L);
    return;
    label61:
    throw C("Unterminated string");
  }
  
  private boolean O()
    throws IOException
  {
    Object localObject = this.I3;
    ByteString localByteString = H3;
    long l = ((BufferedSource)localObject).indexOf(localByteString);
    boolean bool;
    if (l != -1L) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = this.J3;
    if (bool) {
      l += localByteString.size();
    } else {
      l = ((Buffer)localObject).size();
    }
    ((Buffer)localObject).skip(l);
    return bool;
  }
  
  private void P()
    throws IOException
  {
    long l = this.I3.indexOfElement(p3);
    Buffer localBuffer = this.J3;
    if (l != -1L) {
      l += 1L;
    } else {
      l = localBuffer.size();
    }
    localBuffer.skip(l);
  }
  
  private void Q()
    throws IOException
  {
    long l = this.I3.indexOfElement(p2);
    Buffer localBuffer = this.J3;
    if (l == -1L) {
      l = localBuffer.size();
    }
    localBuffer.skip(l);
  }
  
  public void A()
    throws IOException
  {
    if (!this.z)
    {
      int i = 0;
      label396:
      do
      {
        int j = this.K3;
        k = j;
        if (j == 0) {
          k = E();
        }
        if (k == 3) {
          x(1);
        }
        for (;;)
        {
          k = i + 1;
          break label396;
          if (k != 1) {
            break;
          }
          x(3);
        }
        if (k == 4)
        {
          k = i - 1;
          if (k >= 0)
          {
            this.d -= 1;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Expected a value but was ");
            ((StringBuilder)localObject).append(w());
            ((StringBuilder)localObject).append(" at path ");
            ((StringBuilder)localObject).append(getPath());
            throw new a(((StringBuilder)localObject).toString());
          }
        }
        else if (k == 2)
        {
          k = i - 1;
          if (k >= 0)
          {
            this.d -= 1;
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Expected a value but was ");
            ((StringBuilder)localObject).append(w());
            ((StringBuilder)localObject).append(" at path ");
            ((StringBuilder)localObject).append(getPath());
            throw new a(((StringBuilder)localObject).toString());
          }
        }
        else if ((k != 14) && (k != 10))
        {
          if ((k != 9) && (k != 13))
          {
            if ((k != 8) && (k != 12))
            {
              if (k == 17)
              {
                this.J3.skip(this.M3);
                k = i;
              }
              else if (k != 18)
              {
                k = i;
              }
              else
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("Expected a value but was ");
                ((StringBuilder)localObject).append(w());
                ((StringBuilder)localObject).append(" at path ");
                ((StringBuilder)localObject).append(getPath());
                throw new a(((StringBuilder)localObject).toString());
              }
            }
            else
            {
              N(p0);
              k = i;
            }
          }
          else
          {
            N(p1);
            k = i;
          }
        }
        else
        {
          Q();
          k = i;
        }
        this.K3 = 0;
        i = k;
      } while (k != 0);
      localObject = this.x;
      i = this.d;
      int k = i - 1;
      localObject[k] += 1;
      this.q[(i - 1)] = "null";
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot skip unexpected ");
    ((StringBuilder)localObject).append(w());
    ((StringBuilder)localObject).append(" at ");
    ((StringBuilder)localObject).append(getPath());
    throw new a(((StringBuilder)localObject).toString());
  }
  
  public void c()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    if (j == 3)
    {
      x(1);
      this.x[(this.d - 1)] = 0;
      this.K3 = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected BEGIN_ARRAY but was ");
    localStringBuilder.append(w());
    localStringBuilder.append(" at path ");
    localStringBuilder.append(getPath());
    throw new a(localStringBuilder.toString());
  }
  
  public void close()
    throws IOException
  {
    this.K3 = 0;
    this.f[0] = 8;
    this.d = 1;
    this.J3.clear();
    this.I3.close();
  }
  
  public void e()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    if (j == 1)
    {
      x(3);
      this.K3 = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected BEGIN_OBJECT but was ");
    localStringBuilder.append(w());
    localStringBuilder.append(" at path ");
    localStringBuilder.append(getPath());
    throw new a(localStringBuilder.toString());
  }
  
  public void g()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    if (j == 4)
    {
      j = this.d - 1;
      this.d = j;
      localObject = this.x;
      j--;
      localObject[j] += 1;
      this.K3 = 0;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected END_ARRAY but was ");
    ((StringBuilder)localObject).append(w());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new a(((StringBuilder)localObject).toString());
  }
  
  public void i()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    if (j == 2)
    {
      j = this.d - 1;
      this.d = j;
      this.q[j] = null;
      localObject = this.x;
      j--;
      localObject[j] += 1;
      this.K3 = 0;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected END_OBJECT but was ");
    ((StringBuilder)localObject).append(w());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new a(((StringBuilder)localObject).toString());
  }
  
  public boolean j()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    boolean bool;
    if ((j != 2) && (j != 4) && (j != 18)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean k()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    if (j == 5)
    {
      this.K3 = 0;
      localObject = this.x;
      j = this.d - 1;
      localObject[j] += 1;
      return true;
    }
    if (j == 6)
    {
      this.K3 = 0;
      localObject = this.x;
      j = this.d - 1;
      localObject[j] += 1;
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a boolean but was ");
    ((StringBuilder)localObject).append(w());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new a(((StringBuilder)localObject).toString());
  }
  
  public double l()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    Object localObject;
    if (j == 16)
    {
      this.K3 = 0;
      localObject = this.x;
      j = this.d - 1;
      localObject[j] += 1;
      return this.L3;
    }
    if (j == 17) {
      this.N3 = this.J3.readUtf8(this.M3);
    } else if (j == 9) {
      this.N3 = I(p1);
    } else if (j == 8) {
      this.N3 = I(p0);
    } else if (j == 10) {
      this.N3 = J();
    } else {
      if (j != 11) {
        break label322;
      }
    }
    this.K3 = 11;
    try
    {
      double d = Double.parseDouble(this.N3);
      if ((!this.y) && ((Double.isNaN(d)) || (Double.isInfinite(d))))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("JSON forbids NaN and infinities: ");
        ((StringBuilder)localObject).append(d);
        ((StringBuilder)localObject).append(" at path ");
        ((StringBuilder)localObject).append(getPath());
        throw new b(((StringBuilder)localObject).toString());
      }
      this.N3 = null;
      this.K3 = 0;
      localObject = this.x;
      j = this.d - 1;
      localObject[j] += 1;
      return d;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected a double but was ");
      localStringBuilder.append(this.N3);
      localStringBuilder.append(" at path ");
      localStringBuilder.append(getPath());
      throw new a(localStringBuilder.toString());
    }
    label322:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected a double but was ");
    localStringBuilder.append(w());
    localStringBuilder.append(" at path ");
    localStringBuilder.append(getPath());
    throw new a(localStringBuilder.toString());
  }
  
  public int s()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    Object localObject;
    if (j == 16)
    {
      long l = this.L3;
      j = (int)l;
      if (l == j)
      {
        this.K3 = 0;
        localObject = this.x;
        i = this.d - 1;
        localObject[i] += 1;
        return j;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Expected an int but was ");
      ((StringBuilder)localObject).append(this.L3);
      ((StringBuilder)localObject).append(" at path ");
      ((StringBuilder)localObject).append(getPath());
      throw new a(((StringBuilder)localObject).toString());
    }
    if (j == 17)
    {
      this.N3 = this.J3.readUtf8(this.M3);
    }
    else if ((j != 9) && (j != 8))
    {
      if (j != 11)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Expected an int but was ");
        ((StringBuilder)localObject).append(w());
        ((StringBuilder)localObject).append(" at path ");
        ((StringBuilder)localObject).append(getPath());
        throw new a(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (j == 9) {
        localObject = I(p1);
      } else {
        localObject = I(p0);
      }
      this.N3 = ((String)localObject);
    }
    try
    {
      i = Integer.parseInt((String)localObject);
      this.K3 = 0;
      localObject = this.x;
      j = this.d - 1;
      localObject[j] += 1;
      return i;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      for (;;) {}
    }
    this.K3 = 11;
    try
    {
      double d = Double.parseDouble(this.N3);
      j = (int)d;
      if (j == d)
      {
        this.N3 = null;
        this.K3 = 0;
        localObject = this.x;
        i = this.d - 1;
        localObject[i] += 1;
        return j;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Expected an int but was ");
      ((StringBuilder)localObject).append(this.N3);
      ((StringBuilder)localObject).append(" at path ");
      ((StringBuilder)localObject).append(getPath());
      throw new a(((StringBuilder)localObject).toString());
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected an int but was ");
      localStringBuilder.append(this.N3);
      localStringBuilder.append(" at path ");
      localStringBuilder.append(getPath());
      throw new a(localStringBuilder.toString());
    }
  }
  
  public String t()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    if (j == 14)
    {
      localObject = J();
    }
    else if (j == 13)
    {
      localObject = I(p1);
    }
    else if (j == 12)
    {
      localObject = I(p0);
    }
    else
    {
      if (j != 15) {
        break label94;
      }
      localObject = this.N3;
    }
    this.K3 = 0;
    this.q[(this.d - 1)] = localObject;
    return (String)localObject;
    label94:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a name but was ");
    ((StringBuilder)localObject).append(w());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new a(((StringBuilder)localObject).toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JsonReader(");
    localStringBuilder.append(this.I3);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public String u()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    if (j == 10)
    {
      localObject = J();
    }
    else if (j == 9)
    {
      localObject = I(p1);
    }
    else if (j == 8)
    {
      localObject = I(p0);
    }
    else if (j == 11)
    {
      localObject = this.N3;
      this.N3 = null;
    }
    else if (j == 16)
    {
      localObject = Long.toString(this.L3);
    }
    else
    {
      if (j != 17) {
        break label149;
      }
      localObject = this.J3.readUtf8(this.M3);
    }
    this.K3 = 0;
    int[] arrayOfInt = this.x;
    j = this.d - 1;
    arrayOfInt[j] += 1;
    return (String)localObject;
    label149:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a string but was ");
    ((StringBuilder)localObject).append(w());
    ((StringBuilder)localObject).append(" at path ");
    ((StringBuilder)localObject).append(getPath());
    throw new a(((StringBuilder)localObject).toString());
  }
  
  public JsonReader.Token w()
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    switch (j)
    {
    default: 
      throw new AssertionError();
    case 18: 
      return JsonReader.Token.END_DOCUMENT;
    case 16: 
    case 17: 
      return JsonReader.Token.NUMBER;
    case 12: 
    case 13: 
    case 14: 
    case 15: 
      return JsonReader.Token.NAME;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return JsonReader.Token.STRING;
    case 7: 
      return JsonReader.Token.NULL;
    case 5: 
    case 6: 
      return JsonReader.Token.BOOLEAN;
    case 4: 
      return JsonReader.Token.END_ARRAY;
    case 3: 
      return JsonReader.Token.BEGIN_ARRAY;
    case 2: 
      return JsonReader.Token.END_OBJECT;
    }
    return JsonReader.Token.BEGIN_OBJECT;
  }
  
  public int y(JsonReader.a parama)
    throws IOException
  {
    int i = this.K3;
    int j = i;
    if (i == 0) {
      j = E();
    }
    if ((j >= 12) && (j <= 15))
    {
      if (j == 15) {
        return F(this.N3, parama);
      }
      j = this.I3.select(parama.b);
      if (j != -1)
      {
        this.K3 = 0;
        this.q[(this.d - 1)] = parama.a[j];
        return j;
      }
      String str1 = this.q[(this.d - 1)];
      String str2 = t();
      j = F(str2, parama);
      if (j == -1)
      {
        this.K3 = 15;
        this.N3 = str2;
        this.q[(this.d - 1)] = str1;
      }
      return j;
    }
    return -1;
  }
  
  public void z()
    throws IOException
  {
    if (!this.z)
    {
      int i = this.K3;
      int j = i;
      if (i == 0) {
        j = E();
      }
      if (j == 14) {
        Q();
      } else if (j == 13) {
        N(p1);
      } else if (j == 12) {
        N(p0);
      } else {
        if (j != 15) {
          break label93;
        }
      }
      this.K3 = 0;
      this.q[(this.d - 1)] = "null";
      return;
      label93:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected a name but was ");
      localStringBuilder.append(w());
      localStringBuilder.append(" at path ");
      localStringBuilder.append(getPath());
      throw new a(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot skip unexpected ");
    localStringBuilder.append(w());
    localStringBuilder.append(" at ");
    localStringBuilder.append(getPath());
    throw new a(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\parser\moshi\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */