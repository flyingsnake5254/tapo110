package io.netty.util.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class StringUtil
{
  private static final String[] BYTE2HEX_NOPAD;
  private static final String[] BYTE2HEX_PAD;
  public static final char CARRIAGE_RETURN = '\r';
  public static final char COMMA = ',';
  private static final int CSV_NUMBER_ESCAPE_CHARACTERS = 7;
  public static final char DOUBLE_QUOTE = '"';
  public static final String EMPTY_STRING = "";
  private static final byte[] HEX2B;
  public static final char LINE_FEED = '\n';
  public static final String NEWLINE = SystemPropertyUtil.get("line.separator", "\n");
  private static final char PACKAGE_SEPARATOR_CHAR = '.';
  public static final char SPACE = ' ';
  public static final char TAB = '\t';
  
  static
  {
    BYTE2HEX_PAD = new String['Ā'];
    BYTE2HEX_NOPAD = new String['Ā'];
    for (int i = 0;; i++)
    {
      String[] arrayOfString = BYTE2HEX_PAD;
      if (i >= arrayOfString.length) {
        break;
      }
      String str = Integer.toHexString(i);
      if (i > 15)
      {
        localObject = str;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append('0');
        ((StringBuilder)localObject).append(str);
        localObject = ((StringBuilder)localObject).toString();
      }
      arrayOfString[i] = localObject;
      BYTE2HEX_NOPAD[i] = str;
    }
    Object localObject = new byte[65536];
    HEX2B = (byte[])localObject;
    Arrays.fill((byte[])localObject, (byte)-1);
    localObject[48] = ((byte)0);
    localObject[49] = ((byte)1);
    localObject[50] = ((byte)2);
    localObject[51] = ((byte)3);
    localObject[52] = ((byte)4);
    localObject[53] = ((byte)5);
    localObject[54] = ((byte)6);
    localObject[55] = ((byte)7);
    localObject[56] = ((byte)8);
    localObject[57] = ((byte)9);
    localObject[65] = ((byte)10);
    localObject[66] = ((byte)11);
    localObject[67] = ((byte)12);
    localObject[68] = ((byte)13);
    localObject[69] = ((byte)14);
    localObject[70] = ((byte)15);
    localObject[97] = ((byte)10);
    localObject[98] = ((byte)11);
    localObject[99] = ((byte)12);
    localObject[100] = ((byte)13);
    localObject[101] = ((byte)14);
    localObject[102] = ((byte)15);
  }
  
  public static <T extends Appendable> T byteToHexString(T paramT, int paramInt)
  {
    try
    {
      paramT.append(byteToHexString(paramInt));
    }
    catch (IOException localIOException)
    {
      PlatformDependent.throwException(localIOException);
    }
    return paramT;
  }
  
  public static String byteToHexString(int paramInt)
  {
    return BYTE2HEX_NOPAD[(paramInt & 0xFF)];
  }
  
  public static <T extends Appendable> T byteToHexStringPadded(T paramT, int paramInt)
  {
    try
    {
      paramT.append(byteToHexStringPadded(paramInt));
    }
    catch (IOException localIOException)
    {
      PlatformDependent.throwException(localIOException);
    }
    return paramT;
  }
  
  public static String byteToHexStringPadded(int paramInt)
  {
    return BYTE2HEX_PAD[(paramInt & 0xFF)];
  }
  
  public static boolean commonSuffixOfLength(String paramString1, String paramString2, int paramInt)
  {
    boolean bool;
    if ((paramString1 != null) && (paramString2 != null) && (paramInt >= 0) && (paramString1.regionMatches(paramString1.length() - paramInt, paramString2, paramString2.length() - paramInt, paramInt))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static byte decodeHexByte(CharSequence paramCharSequence, int paramInt)
  {
    int i = decodeHexNibble(paramCharSequence.charAt(paramInt));
    int j = decodeHexNibble(paramCharSequence.charAt(paramInt + 1));
    if ((i != -1) && (j != -1)) {
      return (byte)((i << 4) + j);
    }
    throw new IllegalArgumentException(String.format("invalid hex byte '%s' at index %d of '%s'", new Object[] { paramCharSequence.subSequence(paramInt, paramInt + 2), Integer.valueOf(paramInt), paramCharSequence }));
  }
  
  public static byte[] decodeHexDump(CharSequence paramCharSequence)
  {
    return decodeHexDump(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public static byte[] decodeHexDump(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && ((paramInt2 & 0x1) == 0))
    {
      if (paramInt2 == 0) {
        return EmptyArrays.EMPTY_BYTES;
      }
      byte[] arrayOfByte = new byte[paramInt2 >>> 1];
      for (int i = 0; i < paramInt2; i += 2) {
        arrayOfByte[(i >>> 1)] = decodeHexByte(paramCharSequence, paramInt1 + i);
      }
      return arrayOfByte;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("length: ");
    paramCharSequence.append(paramInt2);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  public static int decodeHexNibble(char paramChar)
  {
    return HEX2B[paramChar];
  }
  
  public static boolean endsWith(CharSequence paramCharSequence, char paramChar)
  {
    int i = paramCharSequence.length();
    boolean bool = true;
    if ((i <= 0) || (paramCharSequence.charAt(i - 1) != paramChar)) {
      bool = false;
    }
    return bool;
  }
  
  public static CharSequence escapeCsv(CharSequence paramCharSequence)
  {
    return escapeCsv(paramCharSequence, false);
  }
  
  public static CharSequence escapeCsv(CharSequence paramCharSequence, boolean paramBoolean)
  {
    int i = ((CharSequence)ObjectUtil.checkNotNull(paramCharSequence, "value")).length();
    int j = 0;
    if (paramBoolean)
    {
      k = indexOfFirstNonOwsChar(paramCharSequence, i);
      i = indexOfLastNonOwsChar(paramCharSequence, k, i);
    }
    else
    {
      i--;
      k = 0;
    }
    if (k > i) {
      return "";
    }
    if (isDoubleQuote(paramCharSequence.charAt(k)))
    {
      m = j;
      if (isDoubleQuote(paramCharSequence.charAt(i)))
      {
        m = j;
        if (i > k) {
          m = 1;
        }
      }
      if (m != 0)
      {
        k++;
        i--;
      }
      else
      {
        n = i;
        i = k;
        i1 = m;
        break label141;
      }
    }
    else
    {
      m = 0;
    }
    j = k;
    int k = -1;
    int i1 = m;
    int n = i;
    i = j;
    label141:
    int m = k;
    char c;
    if (k < 0)
    {
      if (i1 != 0) {
        for (m = i;; m = j + 1)
        {
          j = k;
          if (m > n) {
            break;
          }
          j = m;
          if (isDoubleQuote(paramCharSequence.charAt(m)))
          {
            j = m;
            if (m == n) {
              break;
            }
            j = m + 1;
            if (!isDoubleQuote(paramCharSequence.charAt(j)))
            {
              j = m;
              break;
            }
          }
        }
      }
      for (m = i;; m = j + 1)
      {
        j = k;
        if (m > n) {
          break;
        }
        c = paramCharSequence.charAt(m);
        j = m;
        if (c == '\n') {
          break;
        }
        j = m;
        if (c == '\r') {
          break;
        }
        if (c == ',')
        {
          j = m;
          break;
        }
        j = m;
        if (isDoubleQuote(c))
        {
          j = m;
          if (m == n) {
            break;
          }
          j = m + 1;
          if (!isDoubleQuote(paramCharSequence.charAt(j)))
          {
            j = m;
            break;
          }
        }
      }
      m = j;
      if (j < 0)
      {
        if (i1 != 0)
        {
          i--;
          k = n + 2;
        }
        else
        {
          k = n + 1;
        }
        return paramCharSequence.subSequence(i, k);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder(n - i + 1 + 7);
    localStringBuilder.append('"');
    localStringBuilder.append(paramCharSequence, i, m);
    while (m <= n)
    {
      c = paramCharSequence.charAt(m);
      i = m;
      if (isDoubleQuote(c))
      {
        localStringBuilder.append('"');
        i = m;
        if (m < n)
        {
          k = m + 1;
          i = m;
          if (isDoubleQuote(paramCharSequence.charAt(k))) {
            i = k;
          }
        }
      }
      localStringBuilder.append(c);
      m = i + 1;
    }
    localStringBuilder.append('"');
    return localStringBuilder;
  }
  
  private static int indexOfFirstNonOwsChar(CharSequence paramCharSequence, int paramInt)
  {
    for (int i = 0; (i < paramInt) && (isOws(paramCharSequence.charAt(i))); i++) {}
    return i;
  }
  
  private static int indexOfLastNonOwsChar(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    
    while ((paramInt2 > paramInt1) && (isOws(paramCharSequence.charAt(paramInt2)))) {
      paramInt2--;
    }
    return paramInt2;
  }
  
  public static int indexOfNonWhiteSpace(CharSequence paramCharSequence, int paramInt)
  {
    while (paramInt < paramCharSequence.length())
    {
      if (!Character.isWhitespace(paramCharSequence.charAt(paramInt))) {
        return paramInt;
      }
      paramInt++;
    }
    return -1;
  }
  
  public static int indexOfWhiteSpace(CharSequence paramCharSequence, int paramInt)
  {
    while (paramInt < paramCharSequence.length())
    {
      if (Character.isWhitespace(paramCharSequence.charAt(paramInt))) {
        return paramInt;
      }
      paramInt++;
    }
    return -1;
  }
  
  private static boolean isDoubleQuote(char paramChar)
  {
    boolean bool;
    if (paramChar == '"') {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (!paramString.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isOws(char paramChar)
  {
    boolean bool;
    if ((paramChar != ' ') && (paramChar != '\t')) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isSurrogate(char paramChar)
  {
    boolean bool;
    if ((paramChar >= 55296) && (paramChar <= 57343)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static CharSequence join(CharSequence paramCharSequence, Iterable<? extends CharSequence> paramIterable)
  {
    ObjectUtil.checkNotNull(paramCharSequence, "separator");
    ObjectUtil.checkNotNull(paramIterable, "elements");
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext()) {
      return "";
    }
    Object localObject = (CharSequence)paramIterable.next();
    if (!paramIterable.hasNext()) {
      return (CharSequence)localObject;
    }
    localObject = new StringBuilder((CharSequence)localObject);
    do
    {
      ((StringBuilder)localObject).append(paramCharSequence);
      ((StringBuilder)localObject).append((CharSequence)paramIterable.next());
    } while (paramIterable.hasNext());
    return (CharSequence)localObject;
  }
  
  public static int length(String paramString)
  {
    int i;
    if (paramString == null) {
      i = 0;
    } else {
      i = paramString.length();
    }
    return i;
  }
  
  private static IllegalArgumentException newInvalidEscapedCsvFieldException(CharSequence paramCharSequence, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid escaped CSV field: ");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(" index: ");
    localStringBuilder.append(paramInt);
    return new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static String simpleClassName(Class<?> paramClass)
  {
    String str = ((Class)ObjectUtil.checkNotNull(paramClass, "clazz")).getName();
    int i = str.lastIndexOf('.');
    paramClass = str;
    if (i > -1) {
      paramClass = str.substring(i + 1);
    }
    return paramClass;
  }
  
  public static String simpleClassName(Object paramObject)
  {
    if (paramObject == null) {
      return "null_object";
    }
    return simpleClassName(paramObject.getClass());
  }
  
  public static String substringAfter(String paramString, char paramChar)
  {
    paramChar = paramString.indexOf(paramChar);
    if (paramChar >= 0) {
      return paramString.substring(paramChar + '\001');
    }
    return null;
  }
  
  public static <T extends Appendable> T toHexString(T paramT, byte[] paramArrayOfByte)
  {
    return toHexString(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static <T extends Appendable> T toHexString(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return paramT;
    }
    paramInt2 += paramInt1;
    while ((paramInt1 < paramInt2 - 1) && (paramArrayOfByte[paramInt1] == 0)) {
      paramInt1++;
    }
    int i = paramInt1 + 1;
    byteToHexString(paramT, paramArrayOfByte[paramInt1]);
    toHexStringPadded(paramT, paramArrayOfByte, i, paramInt2 - i);
    return paramT;
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    return toHexString(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String toHexString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return ((StringBuilder)toHexString(new StringBuilder(paramInt2 << 1), paramArrayOfByte, paramInt1, paramInt2)).toString();
  }
  
  public static <T extends Appendable> T toHexStringPadded(T paramT, byte[] paramArrayOfByte)
  {
    return toHexStringPadded(paramT, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static <T extends Appendable> T toHexStringPadded(T paramT, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    for (int i = paramInt1; i < paramInt2 + paramInt1; i++) {
      byteToHexStringPadded(paramT, paramArrayOfByte[i]);
    }
    return paramT;
  }
  
  public static String toHexStringPadded(byte[] paramArrayOfByte)
  {
    return toHexStringPadded(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String toHexStringPadded(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return ((StringBuilder)toHexStringPadded(new StringBuilder(paramInt2 << 1), paramArrayOfByte, paramInt1, paramInt2)).toString();
  }
  
  public static CharSequence trimOws(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    if (i == 0) {
      return paramCharSequence;
    }
    int j = indexOfFirstNonOwsChar(paramCharSequence, i);
    int k = indexOfLastNonOwsChar(paramCharSequence, j, i);
    if ((j != 0) || (k != i - 1)) {
      paramCharSequence = paramCharSequence.subSequence(j, k + 1);
    }
    return paramCharSequence;
  }
  
  public static CharSequence unescapeCsv(CharSequence paramCharSequence)
  {
    int i = ((CharSequence)ObjectUtil.checkNotNull(paramCharSequence, "value")).length();
    if (i == 0) {
      return paramCharSequence;
    }
    int j = i - 1;
    int k = 0;
    int m = k;
    if (isDoubleQuote(paramCharSequence.charAt(0)))
    {
      m = k;
      if (isDoubleQuote(paramCharSequence.charAt(j)))
      {
        m = k;
        if (i != 1) {
          m = 1;
        }
      }
    }
    if (m == 0)
    {
      validateCsvFormat(paramCharSequence);
      return paramCharSequence;
    }
    StringBuilder localStringBuilder = InternalThreadLocalMap.get().stringBuilder();
    for (m = 1; m < j; m = k + 1)
    {
      char c = paramCharSequence.charAt(m);
      k = m;
      if (c == '"')
      {
        k = m + 1;
        if ((!isDoubleQuote(paramCharSequence.charAt(k))) || (k == j)) {
          throw newInvalidEscapedCsvFieldException(paramCharSequence, m);
        }
      }
      localStringBuilder.append(c);
    }
    return localStringBuilder.toString();
  }
  
  public static List<CharSequence> unescapeCsvFields(CharSequence paramCharSequence)
  {
    ArrayList localArrayList = new ArrayList(2);
    StringBuilder localStringBuilder = InternalThreadLocalMap.get().stringBuilder();
    int i = paramCharSequence.length() - 1;
    int j = 0;
    int k = 0;
    while (j <= i)
    {
      char c = paramCharSequence.charAt(j);
      if (k != 0)
      {
        if (c != '"')
        {
          localStringBuilder.append(c);
        }
        else
        {
          if (j == i)
          {
            localArrayList.add(localStringBuilder.toString());
            return localArrayList;
          }
          j++;
          int m = paramCharSequence.charAt(j);
          if (m == 34)
          {
            localStringBuilder.append('"');
          }
          else if (m == 44)
          {
            localArrayList.add(localStringBuilder.toString());
            localStringBuilder.setLength(0);
            k = 0;
          }
          else
          {
            throw newInvalidEscapedCsvFieldException(paramCharSequence, j - 1);
          }
        }
      }
      else
      {
        if ((c == '\n') || (c == '\r')) {
          break label229;
        }
        if (c != '"')
        {
          if (c != ',')
          {
            localStringBuilder.append(c);
          }
          else
          {
            localArrayList.add(localStringBuilder.toString());
            localStringBuilder.setLength(0);
          }
        }
        else
        {
          if (localStringBuilder.length() != 0) {
            break label229;
          }
          k = 1;
        }
      }
      j++;
      continue;
      label229:
      throw newInvalidEscapedCsvFieldException(paramCharSequence, j);
    }
    if (k == 0)
    {
      localArrayList.add(localStringBuilder.toString());
      return localArrayList;
    }
    throw newInvalidEscapedCsvFieldException(paramCharSequence, i);
  }
  
  private static void validateCsvFormat(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    int j = 0;
    while (j < i)
    {
      int k = paramCharSequence.charAt(j);
      if ((k != 10) && (k != 13) && (k != 34) && (k != 44)) {
        j++;
      } else {
        throw newInvalidEscapedCsvFieldException(paramCharSequence, j);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */