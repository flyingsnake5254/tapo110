package com.google.gson.stream;

import com.google.gson.internal.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

public class a
  implements Closeable
{
  private static final char[] c = ")]}'\n".toCharArray();
  private String H3;
  private int[] I3;
  private int J3;
  private String[] K3;
  private int[] L3;
  private final Reader d;
  private boolean f = false;
  private int p0 = 0;
  int p1 = 0;
  private long p2;
  private int p3;
  private final char[] q = new char['Ѐ'];
  private int x = 0;
  private int y = 0;
  private int z = 0;
  
  static
  {
    e.a = new a();
  }
  
  public a(Reader paramReader)
  {
    int[] arrayOfInt = new int[32];
    this.I3 = arrayOfInt;
    this.J3 = 0;
    this.J3 = (0 + 1);
    arrayOfInt[0] = 6;
    this.K3 = new String[32];
    this.L3 = new int[32];
    Objects.requireNonNull(paramReader, "in == null");
    this.d = paramReader;
  }
  
  private int B(boolean paramBoolean)
    throws IOException
  {
    Object localObject = this.q;
    int i = this.x;
    int j = this.y;
    for (;;)
    {
      int k = i;
      int m = j;
      if (i == j)
      {
        this.x = i;
        if (!l(1))
        {
          if (!paramBoolean) {
            return -1;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("End of input");
          ((StringBuilder)localObject).append(v());
          throw new EOFException(((StringBuilder)localObject).toString());
        }
        k = this.x;
        m = this.y;
      }
      i = k + 1;
      j = localObject[k];
      if (j == 10)
      {
        this.z += 1;
        this.p0 = i;
      }
      else if ((j != 32) && (j != 13) && (j != 9))
      {
        if (j == 47)
        {
          this.x = i;
          if (i == m)
          {
            this.x = (i - 1);
            boolean bool = l(2);
            this.x += 1;
            if (!bool) {
              return j;
            }
          }
          e();
          i = this.x;
          m = localObject[i];
          if (m != 42)
          {
            if (m != 47) {
              return j;
            }
            this.x = (i + 1);
            O();
            i = this.x;
            j = this.y;
            continue;
          }
          this.x = (i + 1);
          if (N("*/"))
          {
            i = this.x + 2;
            j = this.y;
            continue;
          }
          throw R("Unterminated comment");
        }
        if (j == 35)
        {
          this.x = i;
          e();
          O();
          i = this.x;
          j = this.y;
          continue;
        }
        this.x = i;
        return j;
      }
      j = m;
    }
  }
  
  private String D(char paramChar)
    throws IOException
  {
    char[] arrayOfChar = this.q;
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      char c1 = this.x;
      int i = this.y;
      char c2 = c1;
      char c3;
      for (;;)
      {
        c3 = c2;
        if (c3 >= i) {
          break label210;
        }
        c2 = c3 + '\001';
        c3 = arrayOfChar[c3];
        if (c3 == paramChar)
        {
          this.x = c2;
          paramChar = c2 - c1 - 1;
          if (localObject1 == null) {
            return new String(arrayOfChar, c1, paramChar);
          }
          ((StringBuilder)localObject1).append(arrayOfChar, c1, paramChar);
          return ((StringBuilder)localObject1).toString();
        }
        if (c3 == '\\')
        {
          this.x = c2;
          c2 = c2 - c1 - 1;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder(Math.max((c2 + '\001') * 2, 16));
          }
          ((StringBuilder)localObject2).append(arrayOfChar, c1, c2);
          ((StringBuilder)localObject2).append(K());
          c1 = this.x;
          i = this.y;
          localObject1 = localObject2;
          break;
        }
        if (c3 == '\n')
        {
          this.z += 1;
          this.p0 = c2;
        }
      }
      label210:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(Math.max((c3 - c1) * 2, 16));
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c1, c3 - c1);
      this.x = c3;
      if (!l(1)) {
        break;
      }
    }
    throw R("Unterminated string");
  }
  
  private String F()
    throws IOException
  {
    int i = 0;
    Object localObject1 = null;
    label165:
    label187:
    Object localObject2;
    label193:
    do
    {
      j = 0;
      do
      {
        for (;;)
        {
          int k = this.x;
          if (k + j >= this.y) {
            break label165;
          }
          k = this.q[(k + j)];
          if ((k == 9) || (k == 10) || (k == 12) || (k == 13) || (k == 32)) {
            break label187;
          }
          if (k == 35) {
            break;
          }
          if (k == 44) {
            break label187;
          }
          if ((k == 47) || (k == 61)) {
            break;
          }
          if ((k == 123) || (k == 125) || (k == 58)) {
            break label187;
          }
          if (k == 59) {
            break;
          }
          switch (k)
          {
          default: 
            j++;
          }
        }
        e();
        break;
        if (j >= this.q.length) {
          break label193;
        }
      } while (l(j + 1));
      localObject2 = localObject1;
      break;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(Math.max(j, 16));
      }
      ((StringBuilder)localObject2).append(this.q, this.x, j);
      this.x += j;
      localObject1 = localObject2;
    } while (l(1));
    int j = i;
    if (localObject2 == null)
    {
      localObject2 = new String(this.q, this.x, j);
    }
    else
    {
      ((StringBuilder)localObject2).append(this.q, this.x, j);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    this.x += j;
    return (String)localObject2;
  }
  
  private int H()
    throws IOException
  {
    int i = this.q[this.x];
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
    for (int k = 1; k < j; k++)
    {
      if ((this.x + k >= this.y) && (!l(k + 1))) {
        return 0;
      }
      int m = this.q[(this.x + k)];
      if ((m != str1.charAt(k)) && (m != str2.charAt(k))) {
        return 0;
      }
    }
    if (((this.x + j < this.y) || (l(j + 1))) && (u(this.q[(this.x + j)]))) {
      return 0;
    }
    this.x += j;
    this.p1 = i;
    return i;
  }
  
  private int I()
    throws IOException
  {
    char[] arrayOfChar = this.q;
    int i = this.x;
    int j = this.y;
    int k = 0;
    int m = 0;
    boolean bool2 = true;
    long l1 = 0L;
    int n = 0;
    for (;;)
    {
      int i1 = i;
      int i2 = j;
      if (i + k == j)
      {
        if (k == arrayOfChar.length) {
          return 0;
        }
        if (l(k + 1))
        {
          i1 = this.x;
          i2 = this.y;
        }
      }
      else
      {
        char c1 = arrayOfChar[(i1 + k)];
        if (c1 == '+') {
          break label480;
        }
        if ((c1 == 'E') || (c1 == 'e')) {
          break label457;
        }
        if (c1 == '-') {
          break label432;
        }
        if (c1 == '.') {
          break label418;
        }
        if ((c1 >= '0') && (c1 <= '9'))
        {
          if ((m != 1) && (m != 0))
          {
            long l2;
            if (m == 2)
            {
              if (l1 == 0L) {
                return 0;
              }
              l2 = 10L * l1 - (c1 - '0');
              bool1 = l1 < -922337203685477580L;
              if ((!bool1) && ((bool1) || (l2 >= l1))) {
                bool1 = false;
              } else {
                bool1 = true;
              }
              bool1 = bool2 & bool1;
            }
            else
            {
              if (m == 3)
              {
                m = 4;
                break label289;
              }
              if (m == 5) {
                break label270;
              }
              bool1 = bool2;
              l2 = l1;
              if (m == 6) {
                break label270;
              }
            }
            bool2 = bool1;
            l1 = l2;
            break label289;
            label270:
            m = 7;
          }
          else
          {
            l1 = -(c1 - '0');
            m = 2;
          }
          label289:
          break label490;
        }
        if (u(c1)) {
          break label416;
        }
      }
      if ((m == 2) && (bool2) && ((l1 != Long.MIN_VALUE) || (n != 0)) && ((l1 != 0L) || (n == 0)))
      {
        if (n == 0) {
          l1 = -l1;
        }
        this.p2 = l1;
        this.x += k;
        this.p1 = 15;
        return 15;
      }
      if ((m != 2) && (m != 4) && (m != 7)) {
        return 0;
      }
      this.p3 = k;
      this.p1 = 16;
      return 16;
      label416:
      return 0;
      label418:
      if (m == 2)
      {
        m = 3;
      }
      else
      {
        return 0;
        label432:
        if (m == 0)
        {
          m = 1;
          n = 1;
        }
        else if (m != 5)
        {
          return 0;
          label457:
          if ((m != 2) && (m != 4)) {
            return 0;
          }
          m = 5;
          break label490;
          label480:
          if (m != 5) {
            break;
          }
        }
        else
        {
          m = 6;
        }
      }
      label490:
      k++;
      i = i1;
      boolean bool1 = i2;
    }
    return 0;
  }
  
  private void J(int paramInt)
  {
    int i = this.J3;
    int[] arrayOfInt = this.I3;
    if (i == arrayOfInt.length)
    {
      i *= 2;
      this.I3 = Arrays.copyOf(arrayOfInt, i);
      this.L3 = Arrays.copyOf(this.L3, i);
      this.K3 = ((String[])Arrays.copyOf(this.K3, i));
    }
    arrayOfInt = this.I3;
    i = this.J3;
    this.J3 = (i + 1);
    arrayOfInt[i] = paramInt;
  }
  
  private char K()
    throws IOException
  {
    if ((this.x == this.y) && (!l(1))) {
      throw R("Unterminated escape sequence");
    }
    Object localObject = this.q;
    int i = this.x;
    int j = i + 1;
    this.x = j;
    char c1 = localObject[i];
    if (c1 != '\n')
    {
      if ((c1 != '"') && (c1 != '\'') && (c1 != '/') && (c1 != '\\'))
      {
        if (c1 != 'b')
        {
          if (c1 != 'f')
          {
            if (c1 != 'n')
            {
              if (c1 != 'r')
              {
                if (c1 != 't')
                {
                  if (c1 == 'u')
                  {
                    if ((j + 4 > this.y) && (!l(4))) {
                      throw R("Unterminated escape sequence");
                    }
                    int k = 0;
                    j = this.x;
                    i = j;
                    int m;
                    for (c1 = k;; c1 = m)
                    {
                      k = i;
                      if (k >= j + 4) {
                        break label322;
                      }
                      i = this.q[k];
                      m = (char)(c1 << '\004');
                      if ((i >= 48) && (i <= 57))
                      {
                        i -= 48;
                        m = (char)(m + i);
                      }
                      else
                      {
                        if ((i >= 97) && (i <= 102)) {
                          i -= 97;
                        }
                        for (;;)
                        {
                          i += 10;
                          break;
                          if ((i < 65) || (i > 70)) {
                            break label274;
                          }
                          i -= 65;
                        }
                      }
                      i = k + 1;
                    }
                    label274:
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("\\u");
                    ((StringBuilder)localObject).append(new String(this.q, this.x, 4));
                    throw new NumberFormatException(((StringBuilder)localObject).toString());
                    label322:
                    this.x += 4;
                    return c1;
                  }
                  throw R("Invalid escape sequence");
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
    }
    else
    {
      this.z += 1;
      this.p0 = j;
    }
    return c1;
  }
  
  private void M(char paramChar)
    throws IOException
  {
    char[] arrayOfChar = this.q;
    do
    {
      char c1 = this.x;
      char c2 = this.y;
      while (c1 < c2)
      {
        char c3 = c1 + '\001';
        c1 = arrayOfChar[c1];
        if (c1 == paramChar)
        {
          this.x = c3;
          return;
        }
        if (c1 == '\\')
        {
          this.x = c3;
          K();
          c1 = this.x;
          c2 = this.y;
        }
        else
        {
          if (c1 == '\n')
          {
            this.z += 1;
            this.p0 = c3;
          }
          c1 = c3;
        }
      }
      this.x = c1;
    } while (l(1));
    throw R("Unterminated string");
  }
  
  private boolean N(String paramString)
    throws IOException
  {
    int i = paramString.length();
    int j = this.x;
    int k = this.y;
    int m = 0;
    if ((j + i > k) && (!l(i))) {
      return false;
    }
    char[] arrayOfChar = this.q;
    j = this.x;
    if (arrayOfChar[j] == '\n')
    {
      this.z += 1;
      this.p0 = (j + 1);
    }
    for (;;)
    {
      if (m >= i) {
        break label126;
      }
      if (this.q[(this.x + m)] != paramString.charAt(m))
      {
        this.x += 1;
        break;
      }
      m++;
    }
    label126:
    return true;
  }
  
  private void O()
    throws IOException
  {
    int i;
    do
    {
      if ((this.x >= this.y) && (!l(1))) {
        break;
      }
      char[] arrayOfChar = this.q;
      i = this.x;
      int j = i + 1;
      this.x = j;
      i = arrayOfChar[i];
      if (i == 10)
      {
        this.z += 1;
        this.p0 = j;
        break;
      }
    } while (i != 13);
  }
  
  private void P()
    throws IOException
  {
    label142:
    label153:
    do
    {
      int j;
      for (int i = 0;; i++)
      {
        j = this.x;
        if (j + i >= this.y) {
          break label153;
        }
        j = this.q[(j + i)];
        if ((j == 9) || (j == 10) || (j == 12) || (j == 13) || (j == 32)) {
          break label142;
        }
        if (j == 35) {
          break;
        }
        if (j == 44) {
          break label142;
        }
        if ((j == 47) || (j == 61)) {
          break;
        }
        if ((j == 123) || (j == 125) || (j == 58)) {
          break label142;
        }
        if (j == 59) {
          break;
        }
        switch (j)
        {
        }
      }
      e();
      this.x += i;
      return;
      this.x = (j + i);
    } while (l(1));
  }
  
  private IOException R(String paramString)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(v());
    throw new MalformedJsonException(localStringBuilder.toString());
  }
  
  private void e()
    throws IOException
  {
    if (this.f) {
      return;
    }
    throw R("Use JsonReader.setLenient(true) to accept malformed JSON");
  }
  
  private void g()
    throws IOException
  {
    B(true);
    int i = this.x - 1;
    this.x = i;
    char[] arrayOfChar = c;
    if ((i + arrayOfChar.length > this.y) && (!l(arrayOfChar.length))) {
      return;
    }
    for (i = 0;; i++)
    {
      arrayOfChar = c;
      if (i >= arrayOfChar.length) {
        break;
      }
      if (this.q[(this.x + i)] != arrayOfChar[i]) {
        return;
      }
    }
    this.x += arrayOfChar.length;
  }
  
  private boolean l(int paramInt)
    throws IOException
  {
    char[] arrayOfChar = this.q;
    int i = this.p0;
    int j = this.x;
    this.p0 = (i - j);
    i = this.y;
    if (i != j)
    {
      i -= j;
      this.y = i;
      System.arraycopy(arrayOfChar, j, arrayOfChar, 0, i);
    }
    else
    {
      this.y = 0;
    }
    this.x = 0;
    do
    {
      Reader localReader = this.d;
      j = this.y;
      j = localReader.read(arrayOfChar, j, arrayOfChar.length - j);
      if (j == -1) {
        break;
      }
      i = this.y + j;
      this.y = i;
      j = paramInt;
      if (this.z == 0)
      {
        int k = this.p0;
        j = paramInt;
        if (k == 0)
        {
          j = paramInt;
          if (i > 0)
          {
            j = paramInt;
            if (arrayOfChar[0] == 65279)
            {
              this.x += 1;
              this.p0 = (k + 1);
              j = paramInt + 1;
            }
          }
        }
      }
      paramInt = j;
    } while (i < j);
    return true;
    return false;
  }
  
  private boolean u(char paramChar)
    throws IOException
  {
    if ((paramChar != '\t') && (paramChar != '\n') && (paramChar != '\f') && (paramChar != '\r') && (paramChar != ' '))
    {
      if (paramChar != '#')
      {
        if (paramChar == ',') {
          break label110;
        }
        if ((paramChar != '/') && (paramChar != '='))
        {
          if ((paramChar == '{') || (paramChar == '}') || (paramChar == ':')) {
            break label110;
          }
          if (paramChar == ';') {}
        }
      }
      switch (paramChar)
      {
      default: 
        return true;
      case '\\': 
        e();
      }
    }
    label110:
    return false;
  }
  
  public String A()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    if (j == 14)
    {
      localObject = F();
    }
    else if (j == 12)
    {
      localObject = D('\'');
    }
    else
    {
      if (j != 13) {
        break label78;
      }
      localObject = D('"');
    }
    this.p1 = 0;
    this.K3[(this.J3 - 1)] = localObject;
    return (String)localObject;
    label78:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a name but was ");
    ((StringBuilder)localObject).append(G());
    ((StringBuilder)localObject).append(v());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void C()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    if (j == 7)
    {
      this.p1 = 0;
      localObject = this.L3;
      j = this.J3 - 1;
      localObject[j] += 1;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected null but was ");
    ((StringBuilder)localObject).append(G());
    ((StringBuilder)localObject).append(v());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public String E()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    if (j == 10)
    {
      localObject = F();
    }
    else if (j == 8)
    {
      localObject = D('\'');
    }
    else if (j == 9)
    {
      localObject = D('"');
    }
    else if (j == 11)
    {
      localObject = this.H3;
      this.H3 = null;
    }
    else if (j == 15)
    {
      localObject = Long.toString(this.p2);
    }
    else
    {
      if (j != 16) {
        break label167;
      }
      localObject = new String(this.q, this.x, this.p3);
      this.x += this.p3;
    }
    this.p1 = 0;
    int[] arrayOfInt = this.L3;
    j = this.J3 - 1;
    arrayOfInt[j] += 1;
    return (String)localObject;
    label167:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a string but was ");
    ((StringBuilder)localObject).append(G());
    ((StringBuilder)localObject).append(v());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public JsonToken G()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    switch (j)
    {
    default: 
      throw new AssertionError();
    case 17: 
      return JsonToken.END_DOCUMENT;
    case 15: 
    case 16: 
      return JsonToken.NUMBER;
    case 12: 
    case 13: 
    case 14: 
      return JsonToken.NAME;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return JsonToken.STRING;
    case 7: 
      return JsonToken.NULL;
    case 5: 
    case 6: 
      return JsonToken.BOOLEAN;
    case 4: 
      return JsonToken.END_ARRAY;
    case 3: 
      return JsonToken.BEGIN_ARRAY;
    case 2: 
      return JsonToken.END_OBJECT;
    }
    return JsonToken.BEGIN_OBJECT;
  }
  
  public final void L(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void Q()
    throws IOException
  {
    int i = 0;
    label187:
    do
    {
      j = this.p1;
      int k = j;
      if (j == 0) {
        k = i();
      }
      if (k == 3) {
        J(1);
      }
      for (;;)
      {
        j = i + 1;
        break label187;
        if (k != 1) {
          break;
        }
        J(3);
      }
      if (k == 4) {}
      for (this.J3 -= 1;; this.J3 -= 1)
      {
        j = i - 1;
        break label187;
        if (k != 2) {
          break;
        }
      }
      if ((k != 14) && (k != 10))
      {
        if ((k != 8) && (k != 12))
        {
          if ((k != 9) && (k != 13))
          {
            j = i;
            if (k == 16)
            {
              this.x += this.p3;
              j = i;
            }
          }
          else
          {
            M('"');
            j = i;
          }
        }
        else
        {
          M('\'');
          j = i;
        }
      }
      else
      {
        P();
        j = i;
      }
      this.p1 = 0;
      i = j;
    } while (j != 0);
    int[] arrayOfInt = this.L3;
    int j = this.J3;
    i = j - 1;
    arrayOfInt[i] += 1;
    this.K3[(j - 1)] = "null";
  }
  
  public void a()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    if (j == 3)
    {
      J(1);
      this.L3[(this.J3 - 1)] = 0;
      this.p1 = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected BEGIN_ARRAY but was ");
    localStringBuilder.append(G());
    localStringBuilder.append(v());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void c()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    if (j == 1)
    {
      J(3);
      this.p1 = 0;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected BEGIN_OBJECT but was ");
    localStringBuilder.append(G());
    localStringBuilder.append(v());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public void close()
    throws IOException
  {
    this.p1 = 0;
    this.I3[0] = 8;
    this.J3 = 1;
    this.d.close();
  }
  
  public String getPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    int i = this.J3;
    for (int j = 0; j < i; j++)
    {
      int k = this.I3[j];
      if ((k != 1) && (k != 2))
      {
        if ((k == 3) || (k == 4) || (k == 5))
        {
          localStringBuilder.append('.');
          String[] arrayOfString = this.K3;
          if (arrayOfString[j] != null) {
            localStringBuilder.append(arrayOfString[j]);
          }
        }
      }
      else
      {
        localStringBuilder.append('[');
        localStringBuilder.append(this.L3[j]);
        localStringBuilder.append(']');
      }
    }
    return localStringBuilder.toString();
  }
  
  int i()
    throws IOException
  {
    Object localObject = this.I3;
    int i = this.J3;
    int j = localObject[(i - 1)];
    if (j == 1)
    {
      localObject[(i - 1)] = 2;
    }
    else if (j == 2)
    {
      i = B(true);
      if (i != 44)
      {
        if (i != 59)
        {
          if (i == 93)
          {
            this.p1 = 4;
            return 4;
          }
          throw R("Unterminated array");
        }
        e();
      }
    }
    else
    {
      if ((j == 3) || (j == 5)) {
        break label482;
      }
      if (j == 4)
      {
        localObject[(i - 1)] = 5;
        i = B(true);
        if (i != 58) {
          if (i == 61)
          {
            e();
            if ((this.x < this.y) || (l(1)))
            {
              localObject = this.q;
              i = this.x;
              if (localObject[i] == '>') {
                this.x = (i + 1);
              }
            }
          }
          else
          {
            throw R("Expected ':'");
          }
        }
      }
      else if (j == 6)
      {
        if (this.f) {
          g();
        }
        this.I3[(this.J3 - 1)] = 7;
      }
      else if (j == 7)
      {
        if (B(false) == -1)
        {
          this.p1 = 17;
          return 17;
        }
        e();
        this.x -= 1;
      }
      else
      {
        if (j == 8) {
          break label471;
        }
      }
    }
    i = B(true);
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
                this.x -= 1;
                j = H();
                if (j != 0) {
                  return j;
                }
                j = I();
                if (j != 0) {
                  return j;
                }
                if (u(this.q[this.x]))
                {
                  e();
                  this.p1 = 10;
                  return 10;
                }
                throw R("Expected value");
              }
              this.p1 = 1;
              return 1;
            }
            if (j == 1)
            {
              this.p1 = 4;
              return 4;
            }
          }
          else
          {
            this.p1 = 3;
            return 3;
          }
        }
        if ((j != 1) && (j != 2)) {
          throw R("Unexpected value");
        }
        e();
        this.x -= 1;
        this.p1 = 7;
        return 7;
      }
      e();
      this.p1 = 8;
      return 8;
    }
    this.p1 = 9;
    return 9;
    label471:
    throw new IllegalStateException("JsonReader is closed");
    label482:
    localObject[(i - 1)] = 4;
    if (j == 5)
    {
      i = B(true);
      if (i != 44)
      {
        if (i != 59)
        {
          if (i == 125)
          {
            this.p1 = 2;
            return 2;
          }
          throw R("Unterminated object");
        }
        e();
      }
    }
    i = B(true);
    if (i != 34)
    {
      if (i != 39)
      {
        if (i != 125)
        {
          e();
          this.x -= 1;
          if (u((char)i))
          {
            this.p1 = 14;
            return 14;
          }
          throw R("Expected name");
        }
        if (j != 5)
        {
          this.p1 = 2;
          return 2;
        }
        throw R("Expected name");
      }
      e();
      this.p1 = 12;
      return 12;
    }
    this.p1 = 13;
    return 13;
  }
  
  public void j()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    if (j == 4)
    {
      j = this.J3 - 1;
      this.J3 = j;
      localObject = this.L3;
      j--;
      localObject[j] += 1;
      this.p1 = 0;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected END_ARRAY but was ");
    ((StringBuilder)localObject).append(G());
    ((StringBuilder)localObject).append(v());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void k()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    if (j == 2)
    {
      j = this.J3 - 1;
      this.J3 = j;
      this.K3[j] = null;
      localObject = this.L3;
      j--;
      localObject[j] += 1;
      this.p1 = 0;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected END_OBJECT but was ");
    ((StringBuilder)localObject).append(G());
    ((StringBuilder)localObject).append(v());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public boolean s()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    boolean bool;
    if ((j != 2) && (j != 4)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean t()
  {
    return this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(v());
    return localStringBuilder.toString();
  }
  
  String v()
  {
    int i = this.z;
    int j = this.x;
    int k = this.p0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" at line ");
    localStringBuilder.append(i + 1);
    localStringBuilder.append(" column ");
    localStringBuilder.append(j - k + 1);
    localStringBuilder.append(" path ");
    localStringBuilder.append(getPath());
    return localStringBuilder.toString();
  }
  
  public boolean w()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    if (j == 5)
    {
      this.p1 = 0;
      localObject = this.L3;
      j = this.J3 - 1;
      localObject[j] += 1;
      return true;
    }
    if (j == 6)
    {
      this.p1 = 0;
      localObject = this.L3;
      j = this.J3 - 1;
      localObject[j] += 1;
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected a boolean but was ");
    ((StringBuilder)localObject).append(G());
    ((StringBuilder)localObject).append(v());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public double x()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    if (j == 15)
    {
      this.p1 = 0;
      localObject = this.L3;
      j = this.J3 - 1;
      localObject[j] += 1;
      return this.p2;
    }
    if (j == 16)
    {
      this.H3 = new String(this.q, this.x, this.p3);
      this.x += this.p3;
    }
    else if ((j != 8) && (j != 9))
    {
      if (j == 10)
      {
        this.H3 = F();
      }
      else if (j != 11)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Expected a double but was ");
        ((StringBuilder)localObject).append(G());
        ((StringBuilder)localObject).append(v());
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      int k;
      if (j == 8)
      {
        j = 39;
        k = j;
      }
      else
      {
        j = 34;
        k = j;
      }
      this.H3 = D(k);
    }
    this.p1 = 11;
    double d1 = Double.parseDouble(this.H3);
    if ((!this.f) && ((Double.isNaN(d1)) || (Double.isInfinite(d1))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSON forbids NaN and infinities: ");
      ((StringBuilder)localObject).append(d1);
      ((StringBuilder)localObject).append(v());
      throw new MalformedJsonException(((StringBuilder)localObject).toString());
    }
    this.H3 = null;
    this.p1 = 0;
    Object localObject = this.L3;
    j = this.J3 - 1;
    localObject[j] += 1;
    return d1;
  }
  
  public int y()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    Object localObject1;
    if (j == 15)
    {
      long l = this.p2;
      j = (int)l;
      if (l == j)
      {
        this.p1 = 0;
        localObject1 = this.L3;
        i = this.J3 - 1;
        localObject1[i] += 1;
        return j;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Expected an int but was ");
      ((StringBuilder)localObject1).append(this.p2);
      ((StringBuilder)localObject1).append(v());
      throw new NumberFormatException(((StringBuilder)localObject1).toString());
    }
    if (j == 16)
    {
      this.H3 = new String(this.q, this.x, this.p3);
      this.x += this.p3;
    }
    else
    {
      if ((j != 8) && (j != 9) && (j != 10))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Expected an int but was ");
        ((StringBuilder)localObject1).append(G());
        ((StringBuilder)localObject1).append(v());
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
      }
      if (j == 10)
      {
        this.H3 = F();
      }
      else
      {
        int k;
        if (j == 8)
        {
          j = 39;
          k = j;
        }
        else
        {
          j = 34;
          k = j;
        }
        this.H3 = D(k);
      }
      try
      {
        j = Integer.parseInt(this.H3);
        this.p1 = 0;
        localObject1 = this.L3;
        i = this.J3 - 1;
        localObject1[i] += 1;
        return j;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    this.p1 = 11;
    double d1 = Double.parseDouble(this.H3);
    i = (int)d1;
    if (i == d1)
    {
      this.H3 = null;
      this.p1 = 0;
      localObject2 = this.L3;
      j = this.J3 - 1;
      localObject2[j] += 1;
      return i;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Expected an int but was ");
    ((StringBuilder)localObject2).append(this.H3);
    ((StringBuilder)localObject2).append(v());
    throw new NumberFormatException(((StringBuilder)localObject2).toString());
  }
  
  public long z()
    throws IOException
  {
    int i = this.p1;
    int j = i;
    if (i == 0) {
      j = i();
    }
    Object localObject1;
    if (j == 15)
    {
      this.p1 = 0;
      localObject1 = this.L3;
      j = this.J3 - 1;
      localObject1[j] += 1;
      return this.p2;
    }
    if (j == 16)
    {
      this.H3 = new String(this.q, this.x, this.p3);
      this.x += this.p3;
    }
    else
    {
      if ((j != 8) && (j != 9) && (j != 10))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Expected a long but was ");
        ((StringBuilder)localObject1).append(G());
        ((StringBuilder)localObject1).append(v());
        throw new IllegalStateException(((StringBuilder)localObject1).toString());
      }
      if (j == 10)
      {
        this.H3 = F();
      }
      else
      {
        int k;
        if (j == 8)
        {
          j = 39;
          k = j;
        }
        else
        {
          j = 34;
          k = j;
        }
        this.H3 = D(k);
      }
      try
      {
        l = Long.parseLong(this.H3);
        this.p1 = 0;
        localObject1 = this.L3;
        j = this.J3 - 1;
        localObject1[j] += 1;
        return l;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    this.p1 = 11;
    double d1 = Double.parseDouble(this.H3);
    long l = d1;
    if (l == d1)
    {
      this.H3 = null;
      this.p1 = 0;
      localObject2 = this.L3;
      j = this.J3 - 1;
      localObject2[j] += 1;
      return l;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Expected a long but was ");
    ((StringBuilder)localObject2).append(this.H3);
    ((StringBuilder)localObject2).append(v());
    throw new NumberFormatException(((StringBuilder)localObject2).toString());
  }
  
  class a
    extends e
  {
    public void a(a parama)
      throws IOException
    {
      if ((parama instanceof com.google.gson.internal.bind.a))
      {
        ((com.google.gson.internal.bind.a)parama).V();
        return;
      }
      int i = parama.p1;
      int j = i;
      if (i == 0) {
        j = parama.i();
      }
      if (j == 13)
      {
        parama.p1 = 9;
      }
      else if (j == 12)
      {
        parama.p1 = 8;
      }
      else
      {
        if (j != 14) {
          break label74;
        }
        parama.p1 = 10;
      }
      return;
      label74:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected a name but was ");
      localStringBuilder.append(parama.G());
      localStringBuilder.append(parama.v());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\stream\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */