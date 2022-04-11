package okhttp3.internal.tls;

import javax.security.auth.x500.X500Principal;

final class DistinguishedNameParser
{
  private int beg;
  private char[] chars;
  private int cur;
  private final String dn;
  private int end;
  private final int length;
  private int pos;
  
  DistinguishedNameParser(X500Principal paramX500Principal)
  {
    paramX500Principal = paramX500Principal.getName("RFC2253");
    this.dn = paramX500Principal;
    this.length = paramX500Principal.length();
  }
  
  private String escapedAV()
  {
    int i = this.pos;
    this.beg = i;
    this.end = i;
    label180:
    do
    {
      for (;;)
      {
        i = this.pos;
        if (i >= this.length)
        {
          arrayOfChar = this.chars;
          i = this.beg;
          return new String(arrayOfChar, i, this.end - i);
        }
        arrayOfChar = this.chars;
        j = arrayOfChar[i];
        if (j == 32) {
          break label180;
        }
        if (j == 59) {
          break;
        }
        if (j != 92)
        {
          if ((j == 43) || (j == 44)) {
            break;
          }
          j = this.end;
          this.end = (j + 1);
          arrayOfChar[j] = ((char)arrayOfChar[i]);
          this.pos = (i + 1);
        }
        else
        {
          i = this.end;
          this.end = (i + 1);
          arrayOfChar[i] = getEscaped();
          this.pos += 1;
        }
      }
      arrayOfChar = this.chars;
      i = this.beg;
      return new String(arrayOfChar, i, this.end - i);
      int j = this.end;
      this.cur = j;
      this.pos = (i + 1);
      this.end = (j + 1);
      arrayOfChar[j] = ((char)32);
      for (;;)
      {
        i = this.pos;
        j = this.length;
        if (i >= j) {
          break;
        }
        arrayOfChar = this.chars;
        if (arrayOfChar[i] != ' ') {
          break;
        }
        j = this.end;
        this.end = (j + 1);
        arrayOfChar[j] = ((char)32);
        this.pos = (i + 1);
      }
      if (i == j) {
        break;
      }
      arrayOfChar = this.chars;
    } while ((arrayOfChar[i] != ',') && (arrayOfChar[i] != '+') && (arrayOfChar[i] != ';'));
    char[] arrayOfChar = this.chars;
    i = this.beg;
    return new String(arrayOfChar, i, this.cur - i);
  }
  
  private int getByte(int paramInt)
  {
    int i = paramInt + 1;
    if (i < this.length)
    {
      localObject = this.chars;
      paramInt = localObject[paramInt];
      if ((paramInt >= 48) && (paramInt <= 57))
      {
        paramInt -= 48;
      }
      else if ((paramInt >= 97) && (paramInt <= 102))
      {
        paramInt -= 87;
      }
      else
      {
        if ((paramInt < 65) || (paramInt > 70)) {
          break label169;
        }
        paramInt -= 55;
      }
      i = localObject[i];
      if ((i >= 48) && (i <= 57))
      {
        i -= 48;
      }
      else if ((i >= 97) && (i <= 102))
      {
        i -= 87;
      }
      else
      {
        if ((i < 65) || (i > 70)) {
          break label133;
        }
        i -= 55;
      }
      return (paramInt << 4) + i;
      label133:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Malformed DN: ");
      ((StringBuilder)localObject).append(this.dn);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
      label169:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Malformed DN: ");
      ((StringBuilder)localObject).append(this.dn);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Malformed DN: ");
    ((StringBuilder)localObject).append(this.dn);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private char getEscaped()
  {
    int i = this.pos + 1;
    this.pos = i;
    if (i != this.length)
    {
      localObject = this.chars;
      int j = localObject[i];
      if ((j != 32) && (j != 37) && (j != 92) && (j != 95) && (j != 34) && (j != 35)) {
        switch (j)
        {
        default: 
          switch (j)
          {
          default: 
            return getUTF8();
          }
          break;
        }
      }
      return localObject[i];
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected end of DN: ");
    ((StringBuilder)localObject).append(this.dn);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private char getUTF8()
  {
    int i = getByte(this.pos);
    this.pos += 1;
    if (i < 128) {
      return (char)i;
    }
    if ((i >= 192) && (i <= 247))
    {
      int j;
      if (i <= 223)
      {
        i &= 0x1F;
        j = 1;
      }
      else if (i <= 239)
      {
        j = 2;
        i &= 0xF;
      }
      else
      {
        j = 3;
        i &= 0x7;
      }
      int k = 0;
      while (k < j)
      {
        int m = this.pos + 1;
        this.pos = m;
        if ((m != this.length) && (this.chars[m] == '\\'))
        {
          m++;
          this.pos = m;
          m = getByte(m);
          this.pos += 1;
          if ((m & 0xC0) != 128) {
            return '?';
          }
          i = (i << 6) + (m & 0x3F);
          k++;
        }
        else
        {
          return '?';
        }
      }
      return (char)i;
    }
    return '?';
  }
  
  private String hexAV()
  {
    int i = this.pos;
    if (i + 4 < this.length)
    {
      this.beg = i;
      for (this.pos = (i + 1);; this.pos = (i + 1))
      {
        i = this.pos;
        if (i == this.length) {
          break;
        }
        localObject = this.chars;
        if ((localObject[i] == '+') || (localObject[i] == ',') || (localObject[i] == ';')) {
          break;
        }
        if (localObject[i] == ' ')
        {
          this.end = i;
          for (this.pos = (i + 1);; this.pos = (i + 1))
          {
            i = this.pos;
            if ((i >= this.length) || (this.chars[i] != ' ')) {
              break;
            }
          }
        }
        if ((localObject[i] >= 'A') && (localObject[i] <= 'F')) {
          localObject[i] = ((char)(char)(localObject[i] + ' '));
        }
      }
      this.end = i;
      i = this.end;
      int j = this.beg;
      int k = i - j;
      if ((k >= 5) && ((k & 0x1) != 0))
      {
        int m = k / 2;
        localObject = new byte[m];
        i = 0;
        j++;
        while (i < m)
        {
          localObject[i] = ((byte)(byte)getByte(j));
          j += 2;
          i++;
        }
        return new String(this.chars, this.beg, k);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unexpected end of DN: ");
      ((StringBuilder)localObject).append(this.dn);
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected end of DN: ");
    ((StringBuilder)localObject).append(this.dn);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private String nextAT()
  {
    int i;
    int j;
    for (;;)
    {
      i = this.pos;
      j = this.length;
      if ((i >= j) || (this.chars[i] != ' ')) {
        break;
      }
      this.pos = (i + 1);
    }
    if (i == j) {
      return null;
    }
    this.beg = i;
    for (this.pos = (i + 1);; this.pos = (i + 1))
    {
      i = this.pos;
      j = this.length;
      if (i >= j) {
        break;
      }
      localObject = this.chars;
      if ((localObject[i] == '=') || (localObject[i] == ' ')) {
        break;
      }
    }
    if (i < j)
    {
      this.end = i;
      if (this.chars[i] == ' ')
      {
        for (;;)
        {
          i = this.pos;
          j = this.length;
          if (i >= j) {
            break;
          }
          localObject = this.chars;
          if ((localObject[i] == '=') || (localObject[i] != ' ')) {
            break;
          }
          this.pos = (i + 1);
        }
        if ((this.chars[i] != '=') || (i == j))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unexpected end of DN: ");
          ((StringBuilder)localObject).append(this.dn);
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
      for (this.pos += 1;; this.pos = (i + 1))
      {
        i = this.pos;
        if ((i >= this.length) || (this.chars[i] != ' ')) {
          break;
        }
      }
      i = this.end;
      j = this.beg;
      if (i - j > 4)
      {
        localObject = this.chars;
        if ((localObject[(j + 3)] == '.') && ((localObject[j] == 'O') || (localObject[j] == 'o')) && ((localObject[(j + 1)] == 'I') || (localObject[(j + 1)] == 'i')) && ((localObject[(j + 2)] == 'D') || (localObject[(j + 2)] == 'd'))) {
          this.beg = (j + 4);
        }
      }
      localObject = this.chars;
      i = this.beg;
      return new String((char[])localObject, i, this.end - i);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected end of DN: ");
    ((StringBuilder)localObject).append(this.dn);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  private String quotedAV()
  {
    int i = this.pos + 1;
    this.pos = i;
    this.beg = i;
    for (this.end = i;; this.end += 1)
    {
      i = this.pos;
      if (i == this.length) {
        break;
      }
      localObject = this.chars;
      if (localObject[i] == '"')
      {
        for (this.pos = (i + 1);; this.pos = (i + 1))
        {
          i = this.pos;
          if ((i >= this.length) || (this.chars[i] != ' ')) {
            break;
          }
        }
        localObject = this.chars;
        i = this.beg;
        return new String((char[])localObject, i, this.end - i);
      }
      if (localObject[i] == '\\') {
        localObject[this.end] = getEscaped();
      } else {
        localObject[this.end] = ((char)localObject[i]);
      }
      this.pos += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected end of DN: ");
    ((StringBuilder)localObject).append(this.dn);
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public String findMostSpecific(String paramString)
  {
    this.pos = 0;
    this.beg = 0;
    this.end = 0;
    this.cur = 0;
    this.chars = this.dn.toCharArray();
    Object localObject1 = nextAT();
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      return null;
    }
    do
    {
      int i = this.pos;
      if (i == this.length) {
        return null;
      }
      i = this.chars[i];
      if (i != 34)
      {
        if (i != 35)
        {
          if ((i != 43) && (i != 44) && (i != 59)) {
            localObject1 = escapedAV();
          } else {
            localObject1 = "";
          }
        }
        else {
          localObject1 = hexAV();
        }
      }
      else {
        localObject1 = quotedAV();
      }
      if (paramString.equalsIgnoreCase((String)localObject2)) {
        return (String)localObject1;
      }
      i = this.pos;
      if (i >= this.length) {
        return null;
      }
      localObject1 = this.chars;
      if ((localObject1[i] != ',') && (localObject1[i] != ';') && (localObject1[i] != '+'))
      {
        paramString = new StringBuilder();
        paramString.append("Malformed DN: ");
        paramString.append(this.dn);
        throw new IllegalStateException(paramString.toString());
      }
      this.pos = (i + 1);
      localObject2 = nextAT();
    } while (localObject2 != null);
    paramString = new StringBuilder();
    paramString.append("Malformed DN: ");
    paramString.append(this.dn);
    throw new IllegalStateException(paramString.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\tls\DistinguishedNameParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */