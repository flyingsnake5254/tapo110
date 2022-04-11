package org.apache.commons.lang;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CharSet
  implements Serializable
{
  public static final CharSet ASCII_ALPHA;
  public static final CharSet ASCII_ALPHA_LOWER;
  public static final CharSet ASCII_ALPHA_UPPER;
  public static final CharSet ASCII_NUMERIC;
  protected static final Map COMMON;
  public static final CharSet EMPTY;
  private static final long serialVersionUID = 5947847346149275958L;
  private final Set set = Collections.synchronizedSet(new HashSet());
  
  static
  {
    CharSet localCharSet1 = new CharSet(null);
    EMPTY = localCharSet1;
    CharSet localCharSet2 = new CharSet("a-zA-Z");
    ASCII_ALPHA = localCharSet2;
    CharSet localCharSet3 = new CharSet("a-z");
    ASCII_ALPHA_LOWER = localCharSet3;
    CharSet localCharSet4 = new CharSet("A-Z");
    ASCII_ALPHA_UPPER = localCharSet4;
    CharSet localCharSet5 = new CharSet("0-9");
    ASCII_NUMERIC = localCharSet5;
    Map localMap = Collections.synchronizedMap(new HashMap());
    COMMON = localMap;
    localMap.put(null, localCharSet1);
    localMap.put("", localCharSet1);
    localMap.put("a-zA-Z", localCharSet2);
    localMap.put("A-Za-z", localCharSet2);
    localMap.put("a-z", localCharSet3);
    localMap.put("A-Z", localCharSet4);
    localMap.put("0-9", localCharSet5);
  }
  
  protected CharSet(String paramString)
  {
    add(paramString);
  }
  
  protected CharSet(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++) {
      add(paramArrayOfString[j]);
    }
  }
  
  public static CharSet getInstance(String paramString)
  {
    Object localObject = COMMON.get(paramString);
    if (localObject != null) {
      return (CharSet)localObject;
    }
    return new CharSet(paramString);
  }
  
  public static CharSet getInstance(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    return new CharSet(paramArrayOfString);
  }
  
  protected void add(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i = paramString.length();
    int j = 0;
    while (j < i)
    {
      int k = i - j;
      if ((k >= 4) && (paramString.charAt(j) == '^') && (paramString.charAt(j + 2) == '-'))
      {
        this.set.add(CharRange.isNotIn(paramString.charAt(j + 1), paramString.charAt(j + 3)));
        j += 4;
      }
      else if ((k >= 3) && (paramString.charAt(j + 1) == '-'))
      {
        this.set.add(CharRange.isIn(paramString.charAt(j), paramString.charAt(j + 2)));
        j += 3;
      }
      else if ((k >= 2) && (paramString.charAt(j) == '^'))
      {
        this.set.add(CharRange.isNot(paramString.charAt(j + 1)));
        j += 2;
      }
      else
      {
        this.set.add(CharRange.is(paramString.charAt(j)));
        j++;
      }
    }
  }
  
  public boolean contains(char paramChar)
  {
    Iterator localIterator = this.set.iterator();
    while (localIterator.hasNext()) {
      if (((CharRange)localIterator.next()).contains(paramChar)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof CharSet)) {
      return false;
    }
    paramObject = (CharSet)paramObject;
    return this.set.equals(((CharSet)paramObject).set);
  }
  
  public CharRange[] getCharRanges()
  {
    Set localSet = this.set;
    return (CharRange[])localSet.toArray(new CharRange[localSet.size()]);
  }
  
  public int hashCode()
  {
    return this.set.hashCode() + 89;
  }
  
  public String toString()
  {
    return this.set.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\CharSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */