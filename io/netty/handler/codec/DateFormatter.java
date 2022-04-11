package io.netty.handler.codec;

import io.netty.util.AsciiString;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.ObjectUtil;
import java.util.BitSet;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class DateFormatter
{
  private static final String[] CALENDAR_MONTH_TO_SHORT_NAME = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
  private static final String[] DAY_OF_WEEK_TO_SHORT_NAME;
  private static final BitSet DELIMITERS;
  private static final FastThreadLocal<DateFormatter> INSTANCES = new FastThreadLocal()
  {
    protected DateFormatter initialValue()
    {
      return new DateFormatter(null);
    }
  };
  private final GregorianCalendar cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
  private int dayOfMonth;
  private boolean dayOfMonthFound;
  private int hours;
  private int minutes;
  private int month;
  private boolean monthFound;
  private final StringBuilder sb = new StringBuilder(29);
  private int seconds;
  private boolean timeFound;
  private int year;
  private boolean yearFound;
  
  static
  {
    BitSet localBitSet = new BitSet();
    DELIMITERS = localBitSet;
    localBitSet.set(9);
    for (int i = 32; i <= 47; i = (char)(i + 1)) {
      DELIMITERS.set(i);
    }
    for (i = 59; i <= 64; i = (char)(i + 1)) {
      DELIMITERS.set(i);
    }
    for (i = 91; i <= 96; i = (char)(i + 1)) {
      DELIMITERS.set(i);
    }
    for (i = 123; i <= 126; i = (char)(i + 1)) {
      DELIMITERS.set(i);
    }
    DAY_OF_WEEK_TO_SHORT_NAME = new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
  }
  
  private DateFormatter()
  {
    reset();
  }
  
  public static StringBuilder append(Date paramDate, StringBuilder paramStringBuilder)
  {
    return formatter().append0((Date)ObjectUtil.checkNotNull(paramDate, "date"), (StringBuilder)ObjectUtil.checkNotNull(paramStringBuilder, "sb"));
  }
  
  private StringBuilder append0(Date paramDate, StringBuilder paramStringBuilder)
  {
    this.cal.setTime(paramDate);
    paramStringBuilder.append(DAY_OF_WEEK_TO_SHORT_NAME[(this.cal.get(7) - 1)]);
    paramStringBuilder.append(", ");
    appendZeroLeftPadded(this.cal.get(5), paramStringBuilder).append(' ');
    paramStringBuilder.append(CALENDAR_MONTH_TO_SHORT_NAME[this.cal.get(2)]);
    paramStringBuilder.append(' ');
    paramStringBuilder.append(this.cal.get(1));
    paramStringBuilder.append(' ');
    appendZeroLeftPadded(this.cal.get(11), paramStringBuilder).append(':');
    appendZeroLeftPadded(this.cal.get(12), paramStringBuilder).append(':');
    paramDate = appendZeroLeftPadded(this.cal.get(13), paramStringBuilder);
    paramDate.append(" GMT");
    return paramDate;
  }
  
  private static StringBuilder appendZeroLeftPadded(int paramInt, StringBuilder paramStringBuilder)
  {
    if (paramInt < 10) {
      paramStringBuilder.append('0');
    }
    paramStringBuilder.append(paramInt);
    return paramStringBuilder;
  }
  
  private Date computeDate()
  {
    this.cal.set(5, this.dayOfMonth);
    this.cal.set(2, this.month);
    this.cal.set(1, this.year);
    this.cal.set(11, this.hours);
    this.cal.set(12, this.minutes);
    this.cal.set(13, this.seconds);
    return this.cal.getTime();
  }
  
  public static String format(Date paramDate)
  {
    return formatter().format0((Date)ObjectUtil.checkNotNull(paramDate, "date"));
  }
  
  private String format0(Date paramDate)
  {
    append0(paramDate, this.sb);
    return this.sb.toString();
  }
  
  private static DateFormatter formatter()
  {
    DateFormatter localDateFormatter = (DateFormatter)INSTANCES.get();
    localDateFormatter.reset();
    return localDateFormatter;
  }
  
  private static int getNumericalValue(char paramChar)
  {
    return paramChar - '0';
  }
  
  private static boolean isDelim(char paramChar)
  {
    return DELIMITERS.get(paramChar);
  }
  
  private static boolean isDigit(char paramChar)
  {
    boolean bool;
    if ((paramChar >= '0') && (paramChar <= '9')) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean normalizeAndValidate()
  {
    int i = this.dayOfMonth;
    if ((i >= 1) && (i <= 31) && (this.hours <= 23) && (this.minutes <= 59) && (this.seconds <= 59))
    {
      i = this.year;
      if ((i >= 70) && (i <= 99)) {
        this.year = (i + 1900);
      } else if ((i >= 0) && (i < 70)) {
        this.year = (i + 2000);
      } else if (i < 1601) {
        return false;
      }
      return true;
    }
    return false;
  }
  
  private Date parse0(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((parse1(paramCharSequence, paramInt1, paramInt2)) && (normalizeAndValidate())) {
      paramCharSequence = computeDate();
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  private boolean parse1(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool;
    int j;
    for (int i = -1;; i = j)
    {
      bool = true;
      if (paramInt1 >= paramInt2) {
        break;
      }
      if (isDelim(paramCharSequence.charAt(paramInt1)))
      {
        j = i;
        if (i != -1)
        {
          if (parseToken(paramCharSequence, i, paramInt1)) {
            return true;
          }
          j = -1;
        }
      }
      else
      {
        j = i;
        if (i == -1) {
          j = paramInt1;
        }
      }
      paramInt1++;
    }
    if ((i == -1) || (!parseToken(paramCharSequence, i, paramCharSequence.length()))) {
      bool = false;
    }
    return bool;
  }
  
  public static Date parseHttpDate(CharSequence paramCharSequence)
  {
    return parseHttpDate(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public static Date parseHttpDate(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (i == 0) {
      return null;
    }
    if (i >= 0)
    {
      if (i <= 64) {
        return formatter().parse0((CharSequence)ObjectUtil.checkNotNull(paramCharSequence, "txt"), paramInt1, paramInt2);
      }
      throw new IllegalArgumentException("Can't parse more than 64 chars,looks like a user error or a malformed header");
    }
    throw new IllegalArgumentException("Can't have end < start");
  }
  
  private boolean parseToken(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    boolean bool1 = this.timeFound;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    if (!bool1)
    {
      bool1 = tryParseTime(paramCharSequence, paramInt1, paramInt2);
      this.timeFound = bool1;
      if (bool1)
      {
        if ((this.dayOfMonthFound) && (this.monthFound) && (this.yearFound)) {
          bool3 = bool5;
        } else {
          bool3 = false;
        }
        return bool3;
      }
    }
    if (!this.dayOfMonthFound)
    {
      bool5 = tryParseDayOfMonth(paramCharSequence, paramInt1, paramInt2);
      this.dayOfMonthFound = bool5;
      if (bool5)
      {
        if ((this.timeFound) && (this.monthFound) && (this.yearFound)) {
          bool3 = bool2;
        } else {
          bool3 = false;
        }
        return bool3;
      }
    }
    if (!this.monthFound)
    {
      bool2 = tryParseMonth(paramCharSequence, paramInt1, paramInt2);
      this.monthFound = bool2;
      if (bool2)
      {
        if ((!this.timeFound) || (!this.dayOfMonthFound) || (!this.yearFound)) {
          bool3 = false;
        }
        return bool3;
      }
    }
    if (!this.yearFound) {
      this.yearFound = tryParseYear(paramCharSequence, paramInt1, paramInt2);
    }
    if ((this.timeFound) && (this.dayOfMonthFound) && (this.monthFound) && (this.yearFound)) {
      bool3 = bool4;
    } else {
      bool3 = false;
    }
    return bool3;
  }
  
  private boolean tryParseDayOfMonth(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    char c1;
    if (paramInt2 == 1)
    {
      c1 = paramCharSequence.charAt(paramInt1);
      if (isDigit(c1))
      {
        this.dayOfMonth = getNumericalValue(c1);
        return true;
      }
    }
    else if (paramInt2 == 2)
    {
      char c2 = paramCharSequence.charAt(paramInt1);
      c1 = paramCharSequence.charAt(paramInt1 + 1);
      if ((isDigit(c2)) && (isDigit(c1)))
      {
        this.dayOfMonth = (getNumericalValue(c2) * 10 + getNumericalValue(c1));
        return true;
      }
    }
    return false;
  }
  
  private boolean tryParseMonth(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt2 - paramInt1 != 3) {
      return false;
    }
    int i = AsciiString.toLowerCase(paramCharSequence.charAt(paramInt1));
    paramInt2 = AsciiString.toLowerCase(paramCharSequence.charAt(paramInt1 + 1));
    paramInt1 = AsciiString.toLowerCase(paramCharSequence.charAt(paramInt1 + 2));
    if ((i == 106) && (paramInt2 == 97) && (paramInt1 == 110))
    {
      this.month = 0;
    }
    else if ((i == 102) && (paramInt2 == 101) && (paramInt1 == 98))
    {
      this.month = 1;
    }
    else if ((i == 109) && (paramInt2 == 97) && (paramInt1 == 114))
    {
      this.month = 2;
    }
    else if ((i == 97) && (paramInt2 == 112) && (paramInt1 == 114))
    {
      this.month = 3;
    }
    else if ((i == 109) && (paramInt2 == 97) && (paramInt1 == 121))
    {
      this.month = 4;
    }
    else if ((i == 106) && (paramInt2 == 117) && (paramInt1 == 110))
    {
      this.month = 5;
    }
    else if ((i == 106) && (paramInt2 == 117) && (paramInt1 == 108))
    {
      this.month = 6;
    }
    else if ((i == 97) && (paramInt2 == 117) && (paramInt1 == 103))
    {
      this.month = 7;
    }
    else if ((i == 115) && (paramInt2 == 101) && (paramInt1 == 112))
    {
      this.month = 8;
    }
    else if ((i == 111) && (paramInt2 == 99) && (paramInt1 == 116))
    {
      this.month = 9;
    }
    else if ((i == 110) && (paramInt2 == 111) && (paramInt1 == 118))
    {
      this.month = 10;
    }
    else
    {
      if ((i != 100) || (paramInt2 != 101) || (paramInt1 != 99)) {
        break label376;
      }
      this.month = 11;
    }
    return true;
    label376:
    return false;
  }
  
  private boolean tryParseTime(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if ((i >= 5) && (i <= 8))
    {
      int j = -1;
      int k = 0;
      int m = 0;
      i = -1;
      int n = -1;
      int i1 = 0;
      int i2 = paramInt1;
      paramInt1 = m;
      while (i2 < paramInt2)
      {
        char c = paramCharSequence.charAt(i2);
        if (isDigit(c))
        {
          paramInt1 = paramInt1 * 10 + getNumericalValue(c);
          m = k + 1;
          k = m;
          if (m > 2) {
            return false;
          }
        }
        else
        {
          if (c != ':') {
            break label153;
          }
          if (k == 0) {
            return false;
          }
          k = paramInt1;
          if (i1 != 0)
          {
            if (i1 != 1) {
              return false;
            }
            n = paramInt1;
            k = i;
          }
          i1++;
          i = k;
          k = 0;
          paramInt1 = 0;
        }
        i2++;
        continue;
        label153:
        return false;
      }
      paramInt2 = j;
      if (k > 0) {
        paramInt2 = paramInt1;
      }
      if ((i >= 0) && (n >= 0) && (paramInt2 >= 0))
      {
        this.hours = i;
        this.minutes = n;
        this.seconds = paramInt2;
        return true;
      }
    }
    return false;
  }
  
  private boolean tryParseYear(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    char c1;
    char c2;
    if (paramInt2 == 2)
    {
      c1 = paramCharSequence.charAt(paramInt1);
      c2 = paramCharSequence.charAt(paramInt1 + 1);
      if ((isDigit(c1)) && (isDigit(c2)))
      {
        this.year = (getNumericalValue(c1) * 10 + getNumericalValue(c2));
        return true;
      }
    }
    else if (paramInt2 == 4)
    {
      char c3 = paramCharSequence.charAt(paramInt1);
      c2 = paramCharSequence.charAt(paramInt1 + 1);
      c1 = paramCharSequence.charAt(paramInt1 + 2);
      char c4 = paramCharSequence.charAt(paramInt1 + 3);
      if ((isDigit(c3)) && (isDigit(c2)) && (isDigit(c1)) && (isDigit(c4)))
      {
        this.year = (getNumericalValue(c3) * 1000 + getNumericalValue(c2) * 100 + getNumericalValue(c1) * 10 + getNumericalValue(c4));
        return true;
      }
    }
    return false;
  }
  
  public void reset()
  {
    this.timeFound = false;
    this.hours = -1;
    this.minutes = -1;
    this.seconds = -1;
    this.dayOfMonthFound = false;
    this.dayOfMonth = -1;
    this.monthFound = false;
    this.month = -1;
    this.yearFound = false;
    this.year = -1;
    this.cal.clear();
    this.sb.setLength(0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\DateFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */