package org.apache.commons.lang;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang.text.b;

public final class CharRange
  implements Serializable
{
  private static final long serialVersionUID = 8270183163158333422L;
  private final char end;
  private transient String iToString;
  private final boolean negated;
  private final char start;
  
  public CharRange(char paramChar)
  {
    this(paramChar, paramChar, false);
  }
  
  public CharRange(char paramChar1, char paramChar2)
  {
    this(paramChar1, paramChar2, false);
  }
  
  public CharRange(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    int i = paramChar1;
    int j = paramChar2;
    if (paramChar1 > paramChar2)
    {
      j = paramChar1;
      i = paramChar2;
    }
    this.start = ((char)i);
    this.end = ((char)j);
    this.negated = paramBoolean;
  }
  
  public CharRange(char paramChar, boolean paramBoolean)
  {
    this(paramChar, paramChar, paramBoolean);
  }
  
  public static CharRange is(char paramChar)
  {
    return new CharRange(paramChar, paramChar, false);
  }
  
  public static CharRange isIn(char paramChar1, char paramChar2)
  {
    return new CharRange(paramChar1, paramChar2, false);
  }
  
  public static CharRange isNot(char paramChar)
  {
    return new CharRange(paramChar, paramChar, true);
  }
  
  public static CharRange isNotIn(char paramChar1, char paramChar2)
  {
    return new CharRange(paramChar1, paramChar2, true);
  }
  
  public boolean contains(char paramChar)
  {
    char c = this.start;
    boolean bool1 = true;
    boolean bool2;
    if ((paramChar >= c) && (paramChar <= this.end)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (bool2 != this.negated) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    return bool2;
  }
  
  public boolean contains(CharRange paramCharRange)
  {
    if (paramCharRange != null)
    {
      boolean bool1 = this.negated;
      boolean bool2 = true;
      boolean bool3 = true;
      boolean bool4 = true;
      boolean bool5 = true;
      if (bool1)
      {
        if (paramCharRange.negated)
        {
          if ((this.start < paramCharRange.start) || (this.end > paramCharRange.end)) {
            bool5 = false;
          }
          return bool5;
        }
        bool5 = bool2;
        if (paramCharRange.end >= this.start) {
          if (paramCharRange.start > this.end) {
            bool5 = bool2;
          } else {
            bool5 = false;
          }
        }
        return bool5;
      }
      if (paramCharRange.negated)
      {
        if ((this.start == 0) && (this.end == 65535)) {
          bool5 = bool3;
        } else {
          bool5 = false;
        }
        return bool5;
      }
      if ((this.start <= paramCharRange.start) && (this.end >= paramCharRange.end)) {
        bool5 = bool4;
      } else {
        bool5 = false;
      }
      return bool5;
    }
    throw new IllegalArgumentException("The Range must not be null");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof CharRange)) {
      return false;
    }
    paramObject = (CharRange)paramObject;
    if ((this.start != ((CharRange)paramObject).start) || (this.end != ((CharRange)paramObject).end) || (this.negated != ((CharRange)paramObject).negated)) {
      bool = false;
    }
    return bool;
  }
  
  public char getEnd()
  {
    return this.end;
  }
  
  public char getStart()
  {
    return this.start;
  }
  
  public int hashCode()
  {
    return this.start + 'S' + this.end * '\007' + this.negated;
  }
  
  public boolean isNegated()
  {
    return this.negated;
  }
  
  public Iterator iterator()
  {
    return new a(this, null);
  }
  
  public String toString()
  {
    if (this.iToString == null)
    {
      b localb = new b(4);
      if (isNegated()) {
        localb.a('^');
      }
      localb.a(this.start);
      if (this.start != this.end)
      {
        localb.a('-');
        localb.a(this.end);
      }
      this.iToString = localb.toString();
    }
    return this.iToString;
  }
  
  private static class a
    implements Iterator
  {
    private char c;
    private final CharRange d;
    private boolean f;
    
    private a(CharRange paramCharRange)
    {
      this.d = paramCharRange;
      this.f = true;
      if (paramCharRange.negated)
      {
        if (paramCharRange.start == 0)
        {
          if (paramCharRange.end == 65535) {
            this.f = false;
          } else {
            this.c = ((char)(char)(paramCharRange.end + '\001'));
          }
        }
        else {
          this.c = ((char)0);
        }
      }
      else {
        this.c = paramCharRange.start;
      }
    }
    
    private void a()
    {
      if (this.d.negated)
      {
        int i = this.c;
        if (i == 65535) {
          this.f = false;
        } else if (i + 1 == this.d.start)
        {
          if (this.d.end == 65535) {
            this.f = false;
          } else {
            this.c = ((char)(char)(this.d.end + '\001'));
          }
        }
        else {
          this.c = ((char)(char)(this.c + '\001'));
        }
      }
      else if (this.c < this.d.end)
      {
        this.c = ((char)(char)(this.c + '\001'));
      }
      else
      {
        this.f = false;
      }
    }
    
    public boolean hasNext()
    {
      return this.f;
    }
    
    public Object next()
    {
      if (this.f)
      {
        char c1 = this.c;
        a();
        return new Character(c1);
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\CharRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */