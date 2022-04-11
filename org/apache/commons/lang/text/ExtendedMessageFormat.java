package org.apache.commons.lang.text;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.g;

public class ExtendedMessageFormat
  extends MessageFormat
{
  private static final String DUMMY_PATTERN = "";
  private static final char END_FE = '}';
  private static final String ESCAPED_QUOTE = "''";
  private static final int HASH_SEED = 31;
  private static final char QUOTE = '\'';
  private static final char START_FE = '{';
  private static final char START_FMT = ',';
  private static final long serialVersionUID = -2362048321261811743L;
  private final Map registry;
  private String toPattern;
  
  public ExtendedMessageFormat(String paramString)
  {
    this(paramString, Locale.getDefault());
  }
  
  public ExtendedMessageFormat(String paramString, Locale paramLocale)
  {
    this(paramString, paramLocale, null);
  }
  
  public ExtendedMessageFormat(String paramString, Locale paramLocale, Map paramMap)
  {
    super("");
    setLocale(paramLocale);
    this.registry = paramMap;
    applyPattern(paramString);
  }
  
  public ExtendedMessageFormat(String paramString, Map paramMap)
  {
    this(paramString, Locale.getDefault(), paramMap);
  }
  
  private b appendQuotedString(String paramString, ParsePosition paramParsePosition, b paramb, boolean paramBoolean)
  {
    int i = paramParsePosition.getIndex();
    char[] arrayOfChar = paramString.toCharArray();
    Object localObject1 = null;
    Object localObject2 = null;
    if ((paramBoolean) && (arrayOfChar[i] == '\''))
    {
      next(paramParsePosition);
      if (paramb == null) {
        paramString = (String)localObject2;
      } else {
        paramString = paramb.a('\'');
      }
      return paramString;
    }
    int j = paramParsePosition.getIndex();
    int k = i;
    while (j < paramString.length())
    {
      if ((paramBoolean) && (paramString.substring(j).startsWith("''")))
      {
        paramb.g(arrayOfChar, k, paramParsePosition.getIndex() - k).a('\'');
        paramParsePosition.setIndex(j + 2);
        k = paramParsePosition.getIndex();
      }
      else
      {
        if (arrayOfChar[paramParsePosition.getIndex()] == '\'') {
          break label158;
        }
        next(paramParsePosition);
      }
      j++;
      continue;
      label158:
      next(paramParsePosition);
      if (paramb == null) {
        paramString = (String)localObject1;
      } else {
        paramString = paramb.g(arrayOfChar, k, paramParsePosition.getIndex() - k);
      }
      return paramString;
    }
    paramString = new StringBuffer();
    paramString.append("Unterminated quoted string at position ");
    paramString.append(i);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  private boolean containsElements(Collection paramCollection)
  {
    if ((paramCollection != null) && (paramCollection.size() != 0))
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (paramCollection.next() != null) {
          return true;
        }
      }
    }
    return false;
  }
  
  private Format getFormat(String paramString)
  {
    if (this.registry != null)
    {
      int i = paramString.indexOf(',');
      Object localObject1;
      if (i > 0)
      {
        localObject1 = paramString.substring(0, i).trim();
        localObject2 = paramString.substring(i + 1).trim();
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = null;
      }
      Object localObject2 = (a)this.registry.get(paramString);
      if (localObject2 != null) {
        return ((a)localObject2).a(paramString, (String)localObject1, getLocale());
      }
    }
    return null;
  }
  
  private void getQuotedString(String paramString, ParsePosition paramParsePosition, boolean paramBoolean)
  {
    appendQuotedString(paramString, paramParsePosition, null, paramBoolean);
  }
  
  private String insertFormats(String paramString, ArrayList paramArrayList)
  {
    if (!containsElements(paramArrayList)) {
      return paramString;
    }
    b localb = new b(paramString.length() * 2);
    ParsePosition localParsePosition = new ParsePosition(0);
    int i = -1;
    int j = 0;
    while (localParsePosition.getIndex() < paramString.length())
    {
      char c = paramString.charAt(localParsePosition.getIndex());
      if (c != '\'')
      {
        if (c != '{')
        {
          if (c == '}') {
            j--;
          }
          localb.a(c);
          next(localParsePosition);
        }
        else
        {
          int k = j + 1;
          j = k;
          if (k == 1)
          {
            int m = i + 1;
            localb.a('{').c(readArgumentIndex(paramString, next(localParsePosition)));
            String str = (String)paramArrayList.get(m);
            i = m;
            j = k;
            if (str != null)
            {
              localb.a(',').f(str);
              i = m;
              j = k;
            }
          }
        }
      }
      else {
        appendQuotedString(paramString, localParsePosition, localb, false);
      }
    }
    return localb.toString();
  }
  
  private ParsePosition next(ParsePosition paramParsePosition)
  {
    paramParsePosition.setIndex(paramParsePosition.getIndex() + 1);
    return paramParsePosition;
  }
  
  private String parseFormatDescription(String paramString, ParsePosition paramParsePosition)
  {
    int i = paramParsePosition.getIndex();
    seekNonWs(paramString, paramParsePosition);
    int j = paramParsePosition.getIndex();
    int k = 1;
    while (paramParsePosition.getIndex() < paramString.length())
    {
      int m = paramString.charAt(paramParsePosition.getIndex());
      if (m != 39)
      {
        if (m != 123)
        {
          if (m == 125)
          {
            m = k - 1;
            k = m;
            if (m == 0) {
              return paramString.substring(j, paramParsePosition.getIndex());
            }
          }
        }
        else {
          k++;
        }
      }
      else {
        getQuotedString(paramString, paramParsePosition, false);
      }
      next(paramParsePosition);
    }
    paramString = new StringBuffer();
    paramString.append("Unterminated format element at position ");
    paramString.append(i);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  private int readArgumentIndex(String paramString, ParsePosition paramParsePosition)
  {
    int i = paramParsePosition.getIndex();
    seekNonWs(paramString, paramParsePosition);
    Object localObject = new b();
    int j = 0;
    while ((j == 0) && (paramParsePosition.getIndex() < paramString.length()))
    {
      char c1 = paramString.charAt(paramParsePosition.getIndex());
      char c2 = c1;
      if (Character.isWhitespace(c1))
      {
        seekNonWs(paramString, paramParsePosition);
        j = paramString.charAt(paramParsePosition.getIndex());
        c2 = j;
        if (j != 44)
        {
          c2 = j;
          if (j != 125)
          {
            j = 1;
            break label161;
          }
        }
      }
      if (((c2 == ',') || (c2 == '}')) && (((b)localObject).l() > 0)) {}
      try
      {
        j = Integer.parseInt(((b)localObject).toString());
        return j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        boolean bool;
        label161:
        for (;;) {}
      }
      bool = Character.isDigit(c2);
      ((b)localObject).a(c2);
      j = bool ^ true;
      next(paramParsePosition);
    }
    if (j != 0)
    {
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append("Invalid format argument index at position ");
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(": ");
      ((StringBuffer)localObject).append(paramString.substring(i, paramParsePosition.getIndex()));
      throw new IllegalArgumentException(((StringBuffer)localObject).toString());
    }
    paramString = new StringBuffer();
    paramString.append("Unterminated format element at position ");
    paramString.append(i);
    throw new IllegalArgumentException(paramString.toString());
  }
  
  private void seekNonWs(String paramString, ParsePosition paramParsePosition)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i;
    do
    {
      i = c.c().a(arrayOfChar, paramParsePosition.getIndex());
      paramParsePosition.setIndex(paramParsePosition.getIndex() + i);
    } while ((i > 0) && (paramParsePosition.getIndex() < paramString.length()));
  }
  
  public final void applyPattern(String paramString)
  {
    if (this.registry == null)
    {
      super.applyPattern(paramString);
      this.toPattern = super.toPattern();
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    b localb = new b(paramString.length());
    int i = 0;
    ParsePosition localParsePosition = new ParsePosition(0);
    char[] arrayOfChar = paramString.toCharArray();
    int j = 0;
    Object localObject2;
    Object localObject3;
    while (localParsePosition.getIndex() < paramString.length())
    {
      int k = arrayOfChar[localParsePosition.getIndex()];
      boolean bool1 = true;
      if (k != 39)
      {
        if (k == 123)
        {
          j++;
          seekNonWs(paramString, localParsePosition);
          k = localParsePosition.getIndex();
          int m = readArgumentIndex(paramString, next(localParsePosition));
          localb.a('{').c(m);
          seekNonWs(paramString, localParsePosition);
          m = arrayOfChar[localParsePosition.getIndex()];
          Object localObject1 = null;
          if (m == 44)
          {
            String str = parseFormatDescription(paramString, next(localParsePosition));
            Format localFormat = getFormat(str);
            localObject2 = str;
            localObject3 = localFormat;
            if (localFormat == null)
            {
              localb.a(',').f(str);
              localObject2 = str;
              localObject3 = localFormat;
            }
          }
          else
          {
            localObject2 = null;
            localObject3 = localObject2;
          }
          localArrayList1.add(localObject3);
          if (localObject3 == null) {
            localObject2 = localObject1;
          }
          localArrayList2.add(localObject2);
          boolean bool2;
          if (localArrayList1.size() == j) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          g.a(bool2);
          if (localArrayList2.size() == j) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
          g.a(bool2);
          if (arrayOfChar[localParsePosition.getIndex()] != '}') {}
        }
        else
        {
          localb.a(arrayOfChar[localParsePosition.getIndex()]);
          next(localParsePosition);
          continue;
        }
        paramString = new StringBuffer();
        paramString.append("Unreadable format element at position ");
        paramString.append(k);
        throw new IllegalArgumentException(paramString.toString());
      }
      else
      {
        appendQuotedString(paramString, localParsePosition, localb, true);
      }
    }
    super.applyPattern(localb.toString());
    this.toPattern = insertFormats(super.toPattern(), localArrayList2);
    if (containsElements(localArrayList1))
    {
      paramString = getFormats();
      localObject3 = localArrayList1.iterator();
      for (j = i; ((Iterator)localObject3).hasNext(); j++)
      {
        localObject2 = (Format)((Iterator)localObject3).next();
        if (localObject2 != null) {
          paramString[j] = localObject2;
        }
      }
      super.setFormats(paramString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    if (ObjectUtils.d(getClass(), paramObject.getClass())) {
      return false;
    }
    paramObject = (ExtendedMessageFormat)paramObject;
    if (ObjectUtils.d(this.toPattern, ((ExtendedMessageFormat)paramObject).toPattern)) {
      return false;
    }
    return !ObjectUtils.d(this.registry, ((ExtendedMessageFormat)paramObject).registry);
  }
  
  public int hashCode()
  {
    return (super.hashCode() * 31 + ObjectUtils.b(this.registry)) * 31 + ObjectUtils.b(this.toPattern);
  }
  
  public void setFormat(int paramInt, Format paramFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFormatByArgumentIndex(int paramInt, Format paramFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFormats(Format[] paramArrayOfFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setFormatsByArgumentIndex(Format[] paramArrayOfFormat)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toPattern()
  {
    return this.toPattern;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\text\ExtendedMessageFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */