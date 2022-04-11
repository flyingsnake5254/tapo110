package org.apache.commons.lang.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang.g;
import org.apache.commons.lang.text.b;

public class FastDateFormat
  extends Format
{
  public static final int FULL = 0;
  public static final int LONG = 1;
  public static final int MEDIUM = 2;
  public static final int SHORT = 3;
  private static final Map cDateInstanceCache;
  private static final Map cDateTimeInstanceCache = new HashMap(7);
  private static String cDefaultPattern;
  private static final Map cInstanceCache = new HashMap(7);
  private static final Map cTimeInstanceCache;
  private static final Map cTimeZoneDisplayCache = new HashMap(7);
  private static final long serialVersionUID = 1L;
  private final Locale mLocale;
  private final boolean mLocaleForced;
  private transient int mMaxLengthEstimate;
  private final String mPattern;
  private transient e[] mRules;
  private final TimeZone mTimeZone;
  private final boolean mTimeZoneForced;
  
  static
  {
    cDateInstanceCache = new HashMap(7);
    cTimeInstanceCache = new HashMap(7);
  }
  
  protected FastDateFormat(String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    if (paramString != null)
    {
      this.mPattern = paramString;
      boolean bool1 = true;
      boolean bool2;
      if (paramTimeZone != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      this.mTimeZoneForced = bool2;
      paramString = paramTimeZone;
      if (paramTimeZone == null) {
        paramString = TimeZone.getDefault();
      }
      this.mTimeZone = paramString;
      if (paramLocale != null) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      this.mLocaleForced = bool2;
      paramString = paramLocale;
      if (paramLocale == null) {
        paramString = Locale.getDefault();
      }
      this.mLocale = paramString;
      return;
    }
    throw new IllegalArgumentException("The pattern must not be null");
  }
  
  public static FastDateFormat getDateInstance(int paramInt)
  {
    return getDateInstance(paramInt, null, null);
  }
  
  public static FastDateFormat getDateInstance(int paramInt, Locale paramLocale)
  {
    return getDateInstance(paramInt, null, paramLocale);
  }
  
  public static FastDateFormat getDateInstance(int paramInt, TimeZone paramTimeZone)
  {
    return getDateInstance(paramInt, paramTimeZone, null);
  }
  
  public static FastDateFormat getDateInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale)
  {
    try
    {
      Object localObject1 = new java/lang/Integer;
      ((Integer)localObject1).<init>(paramInt);
      Object localObject2 = localObject1;
      if (paramTimeZone != null)
      {
        localObject2 = new org/apache/commons/lang/time/FastDateFormat$d;
        ((d)localObject2).<init>(localObject1, paramTimeZone);
      }
      localObject1 = paramLocale;
      if (paramLocale == null) {
        localObject1 = Locale.getDefault();
      }
      d locald = new org/apache/commons/lang/time/FastDateFormat$d;
      locald.<init>(localObject2, localObject1);
      Map localMap = cDateInstanceCache;
      localObject2 = (FastDateFormat)localMap.get(locald);
      paramLocale = (Locale)localObject2;
      if (localObject2 == null) {
        try
        {
          paramLocale = getInstance(((SimpleDateFormat)DateFormat.getDateInstance(paramInt, (Locale)localObject1)).toPattern(), paramTimeZone, (Locale)localObject1);
          localMap.put(locald, paramLocale);
        }
        catch (ClassCastException paramTimeZone)
        {
          paramLocale = new java/lang/IllegalArgumentException;
          paramTimeZone = new java/lang/StringBuffer;
          paramTimeZone.<init>();
          paramTimeZone.append("No date pattern for locale: ");
          paramTimeZone.append(localObject1);
          paramLocale.<init>(paramTimeZone.toString());
          throw paramLocale;
        }
      }
      return paramLocale;
    }
    finally {}
  }
  
  public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2)
  {
    return getDateTimeInstance(paramInt1, paramInt2, null, null);
  }
  
  public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, Locale paramLocale)
  {
    return getDateTimeInstance(paramInt1, paramInt2, null, paramLocale);
  }
  
  public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, TimeZone paramTimeZone)
  {
    return getDateTimeInstance(paramInt1, paramInt2, paramTimeZone, null);
  }
  
  public static FastDateFormat getDateTimeInstance(int paramInt1, int paramInt2, TimeZone paramTimeZone, Locale paramLocale)
  {
    try
    {
      Object localObject1 = new org/apache/commons/lang/time/FastDateFormat$d;
      Object localObject2 = new java/lang/Integer;
      ((Integer)localObject2).<init>(paramInt1);
      Object localObject3 = new java/lang/Integer;
      ((Integer)localObject3).<init>(paramInt2);
      ((d)localObject1).<init>(localObject2, localObject3);
      localObject2 = localObject1;
      if (paramTimeZone != null)
      {
        localObject2 = new org/apache/commons/lang/time/FastDateFormat$d;
        ((d)localObject2).<init>(localObject1, paramTimeZone);
      }
      localObject1 = paramLocale;
      if (paramLocale == null) {
        localObject1 = Locale.getDefault();
      }
      localObject3 = new org/apache/commons/lang/time/FastDateFormat$d;
      ((d)localObject3).<init>(localObject2, localObject1);
      Map localMap = cDateTimeInstanceCache;
      localObject2 = (FastDateFormat)localMap.get(localObject3);
      paramLocale = (Locale)localObject2;
      if (localObject2 == null) {
        try
        {
          paramLocale = getInstance(((SimpleDateFormat)DateFormat.getDateTimeInstance(paramInt1, paramInt2, (Locale)localObject1)).toPattern(), paramTimeZone, (Locale)localObject1);
          localMap.put(localObject3, paramLocale);
        }
        catch (ClassCastException paramTimeZone)
        {
          paramLocale = new java/lang/IllegalArgumentException;
          paramTimeZone = new java/lang/StringBuffer;
          paramTimeZone.<init>();
          paramTimeZone.append("No date time pattern for locale: ");
          paramTimeZone.append(localObject1);
          paramLocale.<init>(paramTimeZone.toString());
          throw paramLocale;
        }
      }
      return paramLocale;
    }
    finally {}
  }
  
  private static String getDefaultPattern()
  {
    try
    {
      if (cDefaultPattern == null)
      {
        localObject1 = new java/text/SimpleDateFormat;
        ((SimpleDateFormat)localObject1).<init>();
        cDefaultPattern = ((SimpleDateFormat)localObject1).toPattern();
      }
      Object localObject1 = cDefaultPattern;
      return (String)localObject1;
    }
    finally {}
  }
  
  public static FastDateFormat getInstance()
  {
    return getInstance(getDefaultPattern(), null, null);
  }
  
  public static FastDateFormat getInstance(String paramString)
  {
    return getInstance(paramString, null, null);
  }
  
  public static FastDateFormat getInstance(String paramString, Locale paramLocale)
  {
    return getInstance(paramString, null, paramLocale);
  }
  
  public static FastDateFormat getInstance(String paramString, TimeZone paramTimeZone)
  {
    return getInstance(paramString, paramTimeZone, null);
  }
  
  public static FastDateFormat getInstance(String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    try
    {
      FastDateFormat localFastDateFormat = new org/apache/commons/lang/time/FastDateFormat;
      localFastDateFormat.<init>(paramString, paramTimeZone, paramLocale);
      paramTimeZone = cInstanceCache;
      paramString = (FastDateFormat)paramTimeZone.get(localFastDateFormat);
      if (paramString == null)
      {
        localFastDateFormat.init();
        paramTimeZone.put(localFastDateFormat, localFastDateFormat);
        paramString = localFastDateFormat;
      }
      return paramString;
    }
    finally {}
  }
  
  public static FastDateFormat getTimeInstance(int paramInt)
  {
    return getTimeInstance(paramInt, null, null);
  }
  
  public static FastDateFormat getTimeInstance(int paramInt, Locale paramLocale)
  {
    return getTimeInstance(paramInt, null, paramLocale);
  }
  
  public static FastDateFormat getTimeInstance(int paramInt, TimeZone paramTimeZone)
  {
    return getTimeInstance(paramInt, paramTimeZone, null);
  }
  
  public static FastDateFormat getTimeInstance(int paramInt, TimeZone paramTimeZone, Locale paramLocale)
  {
    try
    {
      Object localObject1 = new java/lang/Integer;
      ((Integer)localObject1).<init>(paramInt);
      Object localObject2 = localObject1;
      if (paramTimeZone != null)
      {
        localObject2 = new org/apache/commons/lang/time/FastDateFormat$d;
        ((d)localObject2).<init>(localObject1, paramTimeZone);
      }
      localObject1 = localObject2;
      if (paramLocale != null)
      {
        localObject1 = new org/apache/commons/lang/time/FastDateFormat$d;
        ((d)localObject1).<init>(localObject2, paramLocale);
      }
      Map localMap = cTimeInstanceCache;
      FastDateFormat localFastDateFormat = (FastDateFormat)localMap.get(localObject1);
      localObject2 = localFastDateFormat;
      if (localFastDateFormat == null)
      {
        localObject2 = paramLocale;
        if (paramLocale == null) {
          localObject2 = Locale.getDefault();
        }
        try
        {
          paramTimeZone = getInstance(((SimpleDateFormat)DateFormat.getTimeInstance(paramInt, (Locale)localObject2)).toPattern(), paramTimeZone, (Locale)localObject2);
          localMap.put(localObject1, paramTimeZone);
          localObject2 = paramTimeZone;
        }
        catch (ClassCastException paramTimeZone)
        {
          paramLocale = new java/lang/IllegalArgumentException;
          paramTimeZone = new java/lang/StringBuffer;
          paramTimeZone.<init>();
          paramTimeZone.append("No date pattern for locale: ");
          paramTimeZone.append(localObject2);
          paramLocale.<init>(paramTimeZone.toString());
          throw paramLocale;
        }
      }
      return (FastDateFormat)localObject2;
    }
    finally {}
  }
  
  static String getTimeZoneDisplay(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale)
  {
    try
    {
      h localh = new org/apache/commons/lang/time/FastDateFormat$h;
      localh.<init>(paramTimeZone, paramBoolean, paramInt, paramLocale);
      Map localMap = cTimeZoneDisplayCache;
      String str1 = (String)localMap.get(localh);
      String str2 = str1;
      if (str1 == null)
      {
        str2 = paramTimeZone.getDisplayName(paramBoolean, paramInt, paramLocale);
        localMap.put(localh, str2);
      }
      return str2;
    }
    finally {}
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    init();
  }
  
  protected StringBuffer applyRules(Calendar paramCalendar, StringBuffer paramStringBuffer)
  {
    e[] arrayOfe = this.mRules;
    int i = arrayOfe.length;
    for (int j = 0; j < i; j++) {
      arrayOfe[j].b(paramStringBuffer, paramCalendar);
    }
    return paramStringBuffer;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FastDateFormat)) {
      return false;
    }
    paramObject = (FastDateFormat)paramObject;
    Object localObject1 = this.mPattern;
    Object localObject2 = ((FastDateFormat)paramObject).mPattern;
    if ((localObject1 == localObject2) || (((String)localObject1).equals(localObject2)))
    {
      localObject1 = this.mTimeZone;
      localObject2 = ((FastDateFormat)paramObject).mTimeZone;
      if ((localObject1 == localObject2) || (localObject1.equals(localObject2)))
      {
        localObject2 = this.mLocale;
        localObject1 = ((FastDateFormat)paramObject).mLocale;
        if (((localObject2 == localObject1) || (((Locale)localObject2).equals(localObject1))) && (this.mTimeZoneForced == ((FastDateFormat)paramObject).mTimeZoneForced) && (this.mLocaleForced == ((FastDateFormat)paramObject).mLocaleForced)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String format(long paramLong)
  {
    return format(new Date(paramLong));
  }
  
  public String format(Calendar paramCalendar)
  {
    return format(paramCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
  }
  
  public String format(Date paramDate)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(this.mTimeZone, this.mLocale);
    localGregorianCalendar.setTime(paramDate);
    return applyRules(localGregorianCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
  }
  
  public StringBuffer format(long paramLong, StringBuffer paramStringBuffer)
  {
    return format(new Date(paramLong), paramStringBuffer);
  }
  
  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    if ((paramObject instanceof Date)) {
      return format((Date)paramObject, paramStringBuffer);
    }
    if ((paramObject instanceof Calendar)) {
      return format((Calendar)paramObject, paramStringBuffer);
    }
    if ((paramObject instanceof Long)) {
      return format(((Long)paramObject).longValue(), paramStringBuffer);
    }
    paramStringBuffer = new StringBuffer();
    paramStringBuffer.append("Unknown class: ");
    if (paramObject == null) {
      paramObject = "<null>";
    } else {
      paramObject = paramObject.getClass().getName();
    }
    paramStringBuffer.append((String)paramObject);
    throw new IllegalArgumentException(paramStringBuffer.toString());
  }
  
  public StringBuffer format(Calendar paramCalendar, StringBuffer paramStringBuffer)
  {
    Calendar localCalendar = paramCalendar;
    if (this.mTimeZoneForced)
    {
      paramCalendar.getTime();
      localCalendar = (Calendar)paramCalendar.clone();
      localCalendar.setTimeZone(this.mTimeZone);
    }
    return applyRules(localCalendar, paramStringBuffer);
  }
  
  public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(this.mTimeZone);
    localGregorianCalendar.setTime(paramDate);
    return applyRules(localGregorianCalendar, paramStringBuffer);
  }
  
  public Locale getLocale()
  {
    return this.mLocale;
  }
  
  public int getMaxLengthEstimate()
  {
    return this.mMaxLengthEstimate;
  }
  
  public String getPattern()
  {
    return this.mPattern;
  }
  
  public TimeZone getTimeZone()
  {
    return this.mTimeZone;
  }
  
  public boolean getTimeZoneOverridesCalendar()
  {
    return this.mTimeZoneForced;
  }
  
  public int hashCode()
  {
    return this.mPattern.hashCode() + 0 + this.mTimeZone.hashCode() + this.mTimeZoneForced + this.mLocale.hashCode() + this.mLocaleForced;
  }
  
  protected void init()
  {
    Object localObject = parsePattern();
    localObject = (e[])((List)localObject).toArray(new e[((List)localObject).size()]);
    this.mRules = ((e[])localObject);
    int i = localObject.length;
    int j = 0;
    for (;;)
    {
      i--;
      if (i < 0) {
        break;
      }
      j += this.mRules[i].a();
    }
    this.mMaxLengthEstimate = j;
  }
  
  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    paramParsePosition.setIndex(0);
    paramParsePosition.setErrorIndex(0);
    return null;
  }
  
  protected List parsePattern()
  {
    Object localObject1 = new DateFormatSymbols(this.mLocale);
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = ((DateFormatSymbols)localObject1).getEras();
    String[] arrayOfString2 = ((DateFormatSymbols)localObject1).getMonths();
    String[] arrayOfString3 = ((DateFormatSymbols)localObject1).getShortMonths();
    Object localObject2 = ((DateFormatSymbols)localObject1).getWeekdays();
    String[] arrayOfString4 = ((DateFormatSymbols)localObject1).getShortWeekdays();
    String[] arrayOfString5 = ((DateFormatSymbols)localObject1).getAmPmStrings();
    int i = this.mPattern.length();
    int[] arrayOfInt = new int[1];
    int k;
    for (int j = 0; j < i; j = k + 1)
    {
      arrayOfInt[0] = j;
      localObject1 = parseToken(this.mPattern, arrayOfInt);
      k = arrayOfInt[0];
      int m = ((String)localObject1).length();
      if (m == 0) {
        break;
      }
      j = ((String)localObject1).charAt(0);
      if (j != 121)
      {
        if (j != 122) {
          switch (j)
          {
          default: 
            switch (j)
            {
            default: 
              localObject2 = new StringBuffer();
              ((StringBuffer)localObject2).append("Illegal pattern component: ");
              ((StringBuffer)localObject2).append((String)localObject1);
              throw new IllegalArgumentException(((StringBuffer)localObject2).toString());
            case 72: 
              localObject1 = selectNumberRule(11, m);
              break;
            case 71: 
              localObject1 = new g(0, arrayOfString1);
              break;
            case 70: 
              localObject1 = selectNumberRule(8, m);
              break;
            case 69: 
              if (m < 4) {
                localObject1 = arrayOfString4;
              } else {
                localObject1 = localObject2;
              }
              localObject1 = new g(7, (String[])localObject1);
              break;
            case 68: 
              localObject1 = selectNumberRule(6, m);
            }
            break;
          }
        }
        for (;;)
        {
          break label735;
          localObject1 = selectNumberRule(3, m);
          continue;
          localObject1 = selectNumberRule(13, m);
          continue;
          localObject1 = selectNumberRule(12, m);
          continue;
          localObject1 = new l(selectNumberRule(11, m));
          continue;
          localObject1 = new k(selectNumberRule(10, m));
          continue;
          localObject1 = selectNumberRule(5, m);
          continue;
          localObject1 = new g(9, arrayOfString5);
          continue;
          if (m == 1)
          {
            localObject1 = j.b;
          }
          else
          {
            localObject1 = j.a;
            continue;
            localObject1 = selectNumberRule(4, m);
            continue;
            localObject1 = selectNumberRule(14, m);
            continue;
            if (m >= 4)
            {
              localObject1 = new g(2, arrayOfString2);
            }
            else if (m == 3)
            {
              localObject1 = new g(2, arrayOfString3);
            }
            else if (m == 2)
            {
              localObject1 = m.a;
            }
            else
            {
              localObject1 = p.a;
              continue;
              localObject1 = selectNumberRule(10, m);
              continue;
              localObject1 = ((String)localObject1).substring(1);
              if (((String)localObject1).length() == 1)
              {
                localObject1 = new a(((String)localObject1).charAt(0));
              }
              else
              {
                localObject1 = new f((String)localObject1);
                continue;
                if (m < 4) {
                  break;
                }
                localObject1 = new i(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 1);
              }
            }
          }
        }
        localObject1 = new i(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 0);
      }
      else if (m >= 4)
      {
        localObject1 = selectNumberRule(1, m);
      }
      else
      {
        localObject1 = o.a;
      }
      label735:
      localArrayList.add(localObject1);
    }
    return localArrayList;
  }
  
  protected String parseToken(String paramString, int[] paramArrayOfInt)
  {
    b localb = new b();
    int i = paramArrayOfInt[0];
    int j = paramString.length();
    char c = paramString.charAt(i);
    int m;
    if (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z')))
    {
      localb.a(c);
      for (;;)
      {
        k = i + 1;
        m = i;
        if (k >= j) {
          break;
        }
        m = i;
        if (paramString.charAt(k) != c) {
          break;
        }
        localb.a(c);
        i = k;
      }
    }
    localb.a('\'');
    int k = 0;
    for (;;)
    {
      m = i;
      if (i >= j) {
        break;
      }
      c = paramString.charAt(i);
      if (c == '\'')
      {
        m = i + 1;
        if ((m < j) && (paramString.charAt(m) == '\''))
        {
          localb.a(c);
          i = m;
        }
        else
        {
          k ^= 0x1;
        }
      }
      else
      {
        if ((k == 0) && (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z'))))
        {
          m = i - 1;
          break;
        }
        localb.a(c);
      }
      i++;
    }
    paramArrayOfInt[0] = m;
    return localb.toString();
  }
  
  protected b selectNumberRule(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 1)
    {
      if (paramInt2 != 2) {
        return new c(paramInt1, paramInt2);
      }
      return new n(paramInt1);
    }
    return new q(paramInt1);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FastDateFormat[");
    localStringBuffer.append(this.mPattern);
    localStringBuffer.append("]");
    return localStringBuffer.toString();
  }
  
  private static class a
    implements FastDateFormat.e
  {
    private final char a;
    
    a(char paramChar)
    {
      this.a = ((char)paramChar);
    }
    
    public int a()
    {
      return 1;
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      paramStringBuffer.append(this.a);
    }
  }
  
  private static abstract interface b
    extends FastDateFormat.e
  {
    public abstract void c(StringBuffer paramStringBuffer, int paramInt);
  }
  
  private static class c
    implements FastDateFormat.b
  {
    private final int a;
    private final int b;
    
    c(int paramInt1, int paramInt2)
    {
      if (paramInt2 >= 3)
      {
        this.a = paramInt1;
        this.b = paramInt2;
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public int a()
    {
      return 4;
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      c(paramStringBuffer, paramCalendar.get(this.a));
    }
    
    public final void c(StringBuffer paramStringBuffer, int paramInt)
    {
      int i;
      if (paramInt < 100)
      {
        i = this.b;
        for (;;)
        {
          i--;
          if (i < 2) {
            break;
          }
          paramStringBuffer.append('0');
        }
        paramStringBuffer.append((char)(paramInt / 10 + 48));
        paramStringBuffer.append((char)(paramInt % 10 + 48));
      }
      else
      {
        if (paramInt < 1000)
        {
          i = 3;
        }
        else
        {
          boolean bool;
          if (paramInt > -1) {
            bool = true;
          } else {
            bool = false;
          }
          g.b(bool, "Negative values should not be possible", paramInt);
          i = Integer.toString(paramInt).length();
        }
        int j = this.b;
        for (;;)
        {
          j--;
          if (j < i) {
            break;
          }
          paramStringBuffer.append('0');
        }
        paramStringBuffer.append(Integer.toString(paramInt));
      }
    }
  }
  
  private static class d
  {
    private final Object a;
    private final Object b;
    
    public d(Object paramObject1, Object paramObject2)
    {
      this.a = paramObject1;
      this.b = paramObject2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof d)) {
        return false;
      }
      Object localObject = (d)paramObject;
      paramObject = this.a;
      if (paramObject == null ? ((d)localObject).a == null : paramObject.equals(((d)localObject).a))
      {
        paramObject = this.b;
        localObject = ((d)localObject).b;
        if (paramObject == null ? localObject == null : paramObject.equals(localObject)) {}
      }
      else
      {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      Object localObject = this.a;
      int i = 0;
      int j;
      if (localObject == null) {
        j = 0;
      } else {
        j = localObject.hashCode();
      }
      localObject = this.b;
      if (localObject != null) {
        i = localObject.hashCode();
      }
      return j + i;
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("[");
      localStringBuffer.append(this.a);
      localStringBuffer.append(':');
      localStringBuffer.append(this.b);
      localStringBuffer.append(']');
      return localStringBuffer.toString();
    }
  }
  
  private static abstract interface e
  {
    public abstract int a();
    
    public abstract void b(StringBuffer paramStringBuffer, Calendar paramCalendar);
  }
  
  private static class f
    implements FastDateFormat.e
  {
    private final String a;
    
    f(String paramString)
    {
      this.a = paramString;
    }
    
    public int a()
    {
      return this.a.length();
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      paramStringBuffer.append(this.a);
    }
  }
  
  private static class g
    implements FastDateFormat.e
  {
    private final int a;
    private final String[] b;
    
    g(int paramInt, String[] paramArrayOfString)
    {
      this.a = paramInt;
      this.b = paramArrayOfString;
    }
    
    public int a()
    {
      int i = this.b.length;
      int j = 0;
      for (;;)
      {
        int k = i - 1;
        if (k < 0) {
          break;
        }
        int m = this.b[k].length();
        i = k;
        if (m > j)
        {
          j = m;
          i = k;
        }
      }
      return j;
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      paramStringBuffer.append(this.b[paramCalendar.get(this.a)]);
    }
  }
  
  private static class h
  {
    private final TimeZone a;
    private final int b;
    private final Locale c;
    
    h(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale)
    {
      this.a = paramTimeZone;
      int i = paramInt;
      if (paramBoolean) {
        i = paramInt | 0x80000000;
      }
      this.b = i;
      this.c = paramLocale;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (this == paramObject) {
        return true;
      }
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!this.a.equals(((h)paramObject).a)) || (this.b != ((h)paramObject).b) || (!this.c.equals(((h)paramObject).c))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      return this.b * 31 + this.c.hashCode();
    }
  }
  
  private static class i
    implements FastDateFormat.e
  {
    private final TimeZone a;
    private final boolean b;
    private final Locale c;
    private final int d;
    private final String e;
    private final String f;
    
    i(TimeZone paramTimeZone, boolean paramBoolean, Locale paramLocale, int paramInt)
    {
      this.a = paramTimeZone;
      this.b = paramBoolean;
      this.c = paramLocale;
      this.d = paramInt;
      if (paramBoolean)
      {
        this.e = FastDateFormat.getTimeZoneDisplay(paramTimeZone, false, paramInt, paramLocale);
        this.f = FastDateFormat.getTimeZoneDisplay(paramTimeZone, true, paramInt, paramLocale);
      }
      else
      {
        this.e = null;
        this.f = null;
      }
    }
    
    public int a()
    {
      if (this.b) {
        return Math.max(this.e.length(), this.f.length());
      }
      if (this.d == 0) {
        return 4;
      }
      return 40;
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      if (this.b)
      {
        if ((this.a.useDaylightTime()) && (paramCalendar.get(16) != 0)) {
          paramStringBuffer.append(this.f);
        } else {
          paramStringBuffer.append(this.e);
        }
      }
      else
      {
        TimeZone localTimeZone = paramCalendar.getTimeZone();
        if ((localTimeZone.useDaylightTime()) && (paramCalendar.get(16) != 0)) {
          paramStringBuffer.append(FastDateFormat.getTimeZoneDisplay(localTimeZone, true, this.d, this.c));
        } else {
          paramStringBuffer.append(FastDateFormat.getTimeZoneDisplay(localTimeZone, false, this.d, this.c));
        }
      }
    }
  }
  
  private static class j
    implements FastDateFormat.e
  {
    static final j a = new j(true);
    static final j b = new j(false);
    final boolean c;
    
    j(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }
    
    public int a()
    {
      return 5;
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      int i = paramCalendar.get(15) + paramCalendar.get(16);
      if (i < 0)
      {
        paramStringBuffer.append('-');
        i = -i;
      }
      else
      {
        paramStringBuffer.append('+');
      }
      int j = i / 3600000;
      paramStringBuffer.append((char)(j / 10 + 48));
      paramStringBuffer.append((char)(j % 10 + 48));
      if (this.c) {
        paramStringBuffer.append(':');
      }
      i = i / 60000 - j * 60;
      paramStringBuffer.append((char)(i / 10 + 48));
      paramStringBuffer.append((char)(i % 10 + 48));
    }
  }
  
  private static class k
    implements FastDateFormat.b
  {
    private final FastDateFormat.b a;
    
    k(FastDateFormat.b paramb)
    {
      this.a = paramb;
    }
    
    public int a()
    {
      return this.a.a();
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      int i = paramCalendar.get(10);
      int j = i;
      if (i == 0) {
        j = paramCalendar.getLeastMaximum(10) + 1;
      }
      this.a.c(paramStringBuffer, j);
    }
    
    public void c(StringBuffer paramStringBuffer, int paramInt)
    {
      this.a.c(paramStringBuffer, paramInt);
    }
  }
  
  private static class l
    implements FastDateFormat.b
  {
    private final FastDateFormat.b a;
    
    l(FastDateFormat.b paramb)
    {
      this.a = paramb;
    }
    
    public int a()
    {
      return this.a.a();
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      int i = paramCalendar.get(11);
      int j = i;
      if (i == 0) {
        j = paramCalendar.getMaximum(11) + 1;
      }
      this.a.c(paramStringBuffer, j);
    }
    
    public void c(StringBuffer paramStringBuffer, int paramInt)
    {
      this.a.c(paramStringBuffer, paramInt);
    }
  }
  
  private static class m
    implements FastDateFormat.b
  {
    static final m a = new m();
    
    public int a()
    {
      return 2;
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      c(paramStringBuffer, paramCalendar.get(2) + 1);
    }
    
    public final void c(StringBuffer paramStringBuffer, int paramInt)
    {
      paramStringBuffer.append((char)(paramInt / 10 + 48));
      paramStringBuffer.append((char)(paramInt % 10 + 48));
    }
  }
  
  private static class n
    implements FastDateFormat.b
  {
    private final int a;
    
    n(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int a()
    {
      return 2;
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      c(paramStringBuffer, paramCalendar.get(this.a));
    }
    
    public final void c(StringBuffer paramStringBuffer, int paramInt)
    {
      if (paramInt < 100)
      {
        paramStringBuffer.append((char)(paramInt / 10 + 48));
        paramStringBuffer.append((char)(paramInt % 10 + 48));
      }
      else
      {
        paramStringBuffer.append(Integer.toString(paramInt));
      }
    }
  }
  
  private static class o
    implements FastDateFormat.b
  {
    static final o a = new o();
    
    public int a()
    {
      return 2;
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      c(paramStringBuffer, paramCalendar.get(1) % 100);
    }
    
    public final void c(StringBuffer paramStringBuffer, int paramInt)
    {
      paramStringBuffer.append((char)(paramInt / 10 + 48));
      paramStringBuffer.append((char)(paramInt % 10 + 48));
    }
  }
  
  private static class p
    implements FastDateFormat.b
  {
    static final p a = new p();
    
    public int a()
    {
      return 2;
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      c(paramStringBuffer, paramCalendar.get(2) + 1);
    }
    
    public final void c(StringBuffer paramStringBuffer, int paramInt)
    {
      if (paramInt < 10)
      {
        paramStringBuffer.append((char)(paramInt + 48));
      }
      else
      {
        paramStringBuffer.append((char)(paramInt / 10 + 48));
        paramStringBuffer.append((char)(paramInt % 10 + 48));
      }
    }
  }
  
  private static class q
    implements FastDateFormat.b
  {
    private final int a;
    
    q(int paramInt)
    {
      this.a = paramInt;
    }
    
    public int a()
    {
      return 4;
    }
    
    public void b(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      c(paramStringBuffer, paramCalendar.get(this.a));
    }
    
    public final void c(StringBuffer paramStringBuffer, int paramInt)
    {
      if (paramInt < 10)
      {
        paramStringBuffer.append((char)(paramInt + 48));
      }
      else if (paramInt < 100)
      {
        paramStringBuffer.append((char)(paramInt / 10 + 48));
        paramStringBuffer.append((char)(paramInt % 10 + 48));
      }
      else
      {
        paramStringBuffer.append(Integer.toString(paramInt));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\time\FastDateFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */