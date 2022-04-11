package io.netty.util;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class AsciiString
  implements CharSequence, Comparable<CharSequence>
{
  public static final HashingStrategy<CharSequence> CASE_INSENSITIVE_HASHER = new HashingStrategy()
  {
    public boolean equals(CharSequence paramAnonymousCharSequence1, CharSequence paramAnonymousCharSequence2)
    {
      return AsciiString.contentEqualsIgnoreCase(paramAnonymousCharSequence1, paramAnonymousCharSequence2);
    }
    
    public int hashCode(CharSequence paramAnonymousCharSequence)
    {
      return AsciiString.hashCode(paramAnonymousCharSequence);
    }
  };
  public static final HashingStrategy<CharSequence> CASE_SENSITIVE_HASHER = new HashingStrategy()
  {
    public boolean equals(CharSequence paramAnonymousCharSequence1, CharSequence paramAnonymousCharSequence2)
    {
      return AsciiString.contentEquals(paramAnonymousCharSequence1, paramAnonymousCharSequence2);
    }
    
    public int hashCode(CharSequence paramAnonymousCharSequence)
    {
      return AsciiString.hashCode(paramAnonymousCharSequence);
    }
  };
  public static final AsciiString EMPTY_STRING = cached("");
  public static final int INDEX_NOT_FOUND = -1;
  private static final char MAX_CHAR_VALUE = 'ÿ';
  private int hash;
  private final int length;
  private final int offset;
  private String string;
  private final byte[] value;
  
  public AsciiString(CharSequence paramCharSequence)
  {
    this(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public AsciiString(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt2, paramCharSequence.length()))
    {
      this.value = PlatformDependent.allocateUninitializedArray(paramInt2);
      int i = 0;
      while (i < paramInt2)
      {
        this.value[i] = c2b(paramCharSequence.charAt(paramInt1));
        i++;
        paramInt1++;
      }
      this.offset = 0;
      this.length = paramInt2;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expected: 0 <= start(");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") <= start + length(");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") <= value.length(");
    localStringBuilder.append(paramCharSequence.length());
    localStringBuilder.append(')');
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public AsciiString(CharSequence paramCharSequence, Charset paramCharset)
  {
    this(paramCharSequence, paramCharset, 0, paramCharSequence.length());
  }
  
  public AsciiString(CharSequence paramCharSequence, Charset paramCharset, int paramInt1, int paramInt2)
  {
    paramCharSequence = CharBuffer.wrap(paramCharSequence, paramInt1, paramInt1 + paramInt2);
    CharsetEncoder localCharsetEncoder = CharsetUtil.encoder(paramCharset);
    paramCharset = ByteBuffer.allocate((int)(localCharsetEncoder.maxBytesPerChar() * paramInt2));
    localCharsetEncoder.encode(paramCharSequence, paramCharset, true);
    paramInt1 = paramCharset.arrayOffset();
    paramCharSequence = Arrays.copyOfRange(paramCharset.array(), paramInt1, paramCharset.position() + paramInt1);
    this.value = paramCharSequence;
    this.offset = 0;
    this.length = paramCharSequence.length;
  }
  
  public AsciiString(ByteBuffer paramByteBuffer)
  {
    this(paramByteBuffer, true);
  }
  
  public AsciiString(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt2, paramByteBuffer.capacity()))
    {
      if (paramByteBuffer.hasArray())
      {
        if (paramBoolean)
        {
          paramInt1 = paramByteBuffer.arrayOffset() + paramInt1;
          this.value = Arrays.copyOfRange(paramByteBuffer.array(), paramInt1, paramInt1 + paramInt2);
          this.offset = 0;
        }
        else
        {
          this.value = paramByteBuffer.array();
          this.offset = paramInt1;
        }
      }
      else
      {
        localObject = PlatformDependent.allocateUninitializedArray(paramInt2);
        this.value = ((byte[])localObject);
        paramInt1 = paramByteBuffer.position();
        paramByteBuffer.get((byte[])localObject, 0, paramInt2);
        paramByteBuffer.position(paramInt1);
        this.offset = 0;
      }
      this.length = paramInt2;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("expected: 0 <= start(");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(") <= start + length(");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(") <= value.capacity(");
    ((StringBuilder)localObject).append(paramByteBuffer.capacity());
    ((StringBuilder)localObject).append(')');
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public AsciiString(ByteBuffer paramByteBuffer, boolean paramBoolean)
  {
    this(paramByteBuffer, paramByteBuffer.position(), paramByteBuffer.remaining(), paramBoolean);
  }
  
  public AsciiString(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, true);
  }
  
  public AsciiString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.value = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt1 + paramInt2);
      this.offset = 0;
    }
    else
    {
      if (MathUtil.isOutOfBounds(paramInt1, paramInt2, paramArrayOfByte.length)) {
        break label55;
      }
      this.value = paramArrayOfByte;
      this.offset = paramInt1;
    }
    this.length = paramInt2;
    return;
    label55:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expected: 0 <= start(");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") <= start + length(");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") <= value.length(");
    localStringBuilder.append(paramArrayOfByte.length);
    localStringBuilder.append(')');
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public AsciiString(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length, paramBoolean);
  }
  
  public AsciiString(char[] paramArrayOfChar)
  {
    this(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public AsciiString(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt2, paramArrayOfChar.length))
    {
      this.value = PlatformDependent.allocateUninitializedArray(paramInt2);
      int i = 0;
      while (i < paramInt2)
      {
        this.value[i] = c2b(paramArrayOfChar[paramInt1]);
        i++;
        paramInt1++;
      }
      this.offset = 0;
      this.length = paramInt2;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expected: 0 <= start(");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") <= start + length(");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") <= value.length(");
    localStringBuilder.append(paramArrayOfChar.length);
    localStringBuilder.append(')');
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public AsciiString(char[] paramArrayOfChar, Charset paramCharset)
  {
    this(paramArrayOfChar, paramCharset, 0, paramArrayOfChar.length);
  }
  
  public AsciiString(char[] paramArrayOfChar, Charset paramCharset, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
    CharsetEncoder localCharsetEncoder = CharsetUtil.encoder(paramCharset);
    paramCharset = ByteBuffer.allocate((int)(localCharsetEncoder.maxBytesPerChar() * paramInt2));
    localCharsetEncoder.encode(paramArrayOfChar, paramCharset, true);
    paramInt1 = paramCharset.arrayOffset();
    paramArrayOfChar = Arrays.copyOfRange(paramCharset.array(), paramInt1, paramCharset.position() + paramInt1);
    this.value = paramArrayOfChar;
    this.offset = 0;
    this.length = paramArrayOfChar.length;
  }
  
  public static char b2c(byte paramByte)
  {
    return (char)(paramByte & 0xFF);
  }
  
  public static byte c2b(char paramChar)
  {
    int i = paramChar;
    if (paramChar > 'ÿ') {
      i = 63;
    }
    return (byte)i;
  }
  
  private static byte c2b0(char paramChar)
  {
    return (byte)paramChar;
  }
  
  public static AsciiString cached(String paramString)
  {
    AsciiString localAsciiString = new AsciiString(paramString);
    localAsciiString.string = paramString;
    return localAsciiString;
  }
  
  public static boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return contains(paramCharSequence1, paramCharSequence2, DefaultCharEqualityComparator.INSTANCE);
  }
  
  private static boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharEqualityComparator paramCharEqualityComparator)
  {
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null) && (paramCharSequence1.length() >= paramCharSequence2.length()))
    {
      if (paramCharSequence2.length() == 0) {
        return true;
      }
      int i = 0;
      int j = 0;
      while (i < paramCharSequence1.length())
      {
        if (paramCharEqualityComparator.equals(paramCharSequence2.charAt(j), paramCharSequence1.charAt(i)))
        {
          int k = j + 1;
          j = k;
          if (k == paramCharSequence2.length()) {
            return true;
          }
        }
        else
        {
          if (paramCharSequence1.length() - i < paramCharSequence2.length()) {
            return false;
          }
          j = 0;
        }
        i++;
      }
    }
    return false;
  }
  
  public static boolean containsAllContentEqualsIgnoreCase(Collection<CharSequence> paramCollection1, Collection<CharSequence> paramCollection2)
  {
    paramCollection2 = paramCollection2.iterator();
    while (paramCollection2.hasNext()) {
      if (!containsContentEqualsIgnoreCase(paramCollection1, (CharSequence)paramCollection2.next())) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean containsContentEqualsIgnoreCase(Collection<CharSequence> paramCollection, CharSequence paramCharSequence)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (contentEqualsIgnoreCase(paramCharSequence, (CharSequence)paramCollection.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean containsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return contains(paramCharSequence1, paramCharSequence2, AsciiCaseInsensitiveCharEqualityComparator.INSTANCE);
  }
  
  public static boolean contentEquals(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    boolean bool = true;
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      if ((paramCharSequence1 instanceof AsciiString)) {
        return ((AsciiString)paramCharSequence1).contentEquals(paramCharSequence2);
      }
      if ((paramCharSequence2 instanceof AsciiString)) {
        return ((AsciiString)paramCharSequence2).contentEquals(paramCharSequence1);
      }
      if (paramCharSequence1.length() != paramCharSequence2.length()) {
        return false;
      }
      for (int i = 0; i < paramCharSequence1.length(); i++) {
        if (paramCharSequence1.charAt(i) != paramCharSequence2.charAt(i)) {
          return false;
        }
      }
      return true;
    }
    if (paramCharSequence1 != paramCharSequence2) {
      bool = false;
    }
    return bool;
  }
  
  public static boolean contentEqualsIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    boolean bool = true;
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      if ((paramCharSequence1 instanceof AsciiString)) {
        return ((AsciiString)paramCharSequence1).contentEqualsIgnoreCase(paramCharSequence2);
      }
      if ((paramCharSequence2 instanceof AsciiString)) {
        return ((AsciiString)paramCharSequence2).contentEqualsIgnoreCase(paramCharSequence1);
      }
      if (paramCharSequence1.length() != paramCharSequence2.length()) {
        return false;
      }
      for (int i = 0; i < paramCharSequence1.length(); i++) {
        if (!equalsIgnoreCase(paramCharSequence1.charAt(i), paramCharSequence2.charAt(i))) {
          return false;
        }
      }
      return true;
    }
    if (paramCharSequence1 != paramCharSequence2) {
      bool = false;
    }
    return bool;
  }
  
  private static boolean equalsIgnoreCase(byte paramByte1, byte paramByte2)
  {
    boolean bool;
    if ((paramByte1 != paramByte2) && (toLowerCase(paramByte1) != toLowerCase(paramByte2))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private static boolean equalsIgnoreCase(char paramChar1, char paramChar2)
  {
    boolean bool;
    if ((paramChar1 != paramChar2) && (toLowerCase(paramChar1) != toLowerCase(paramChar2))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private int forEachByte0(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
    throws Exception
  {
    int i = this.offset;
    for (int j = i + paramInt1; j < i + paramInt1 + paramInt2; j++) {
      if (!paramByteProcessor.process(this.value[j])) {
        return j - this.offset;
      }
    }
    return -1;
  }
  
  private int forEachByteDesc0(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
    throws Exception
  {
    int i = this.offset;
    for (paramInt2 = i + paramInt1 + paramInt2 - 1; paramInt2 >= i + paramInt1; paramInt2--) {
      if (!paramByteProcessor.process(this.value[paramInt2])) {
        return paramInt2 - this.offset;
      }
    }
    return -1;
  }
  
  public static int hashCode(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return 0;
    }
    if ((paramCharSequence instanceof AsciiString)) {
      return paramCharSequence.hashCode();
    }
    return PlatformDependent.hashCodeAscii(paramCharSequence);
  }
  
  public static int indexOf(CharSequence paramCharSequence, char paramChar, int paramInt)
  {
    if ((paramCharSequence instanceof String)) {
      return ((String)paramCharSequence).indexOf(paramChar, paramInt);
    }
    if ((paramCharSequence instanceof AsciiString)) {
      return ((AsciiString)paramCharSequence).indexOf(paramChar, paramInt);
    }
    if (paramCharSequence == null) {
      return -1;
    }
    int i = paramCharSequence.length();
    int j = paramInt;
    if (paramInt < 0) {}
    for (j = 0; j < i; j++) {
      if (paramCharSequence.charAt(j) == paramChar) {
        return j;
      }
    }
    return -1;
  }
  
  public static int indexOfIgnoreCase(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      int j = paramCharSequence2.length();
      int k = paramCharSequence1.length() - j + 1;
      if (i > k) {
        return -1;
      }
      paramInt = i;
      if (j == 0) {
        return i;
      }
      while (paramInt < k)
      {
        if (regionMatches(paramCharSequence1, true, paramInt, paramCharSequence2, 0, j)) {
          return paramInt;
        }
        paramInt++;
      }
    }
    return -1;
  }
  
  public static int indexOfIgnoreCaseAscii(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      int j = paramCharSequence2.length();
      int k = paramCharSequence1.length() - j + 1;
      if (i > k) {
        return -1;
      }
      paramInt = i;
      if (j == 0) {
        return i;
      }
      while (paramInt < k)
      {
        if (regionMatchesAscii(paramCharSequence1, true, paramInt, paramCharSequence2, 0, j)) {
          return paramInt;
        }
        paramInt++;
      }
    }
    return -1;
  }
  
  private static boolean isLowerCase(byte paramByte)
  {
    boolean bool;
    if ((paramByte >= 97) && (paramByte <= 122)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isUpperCase(byte paramByte)
  {
    boolean bool;
    if ((paramByte >= 65) && (paramByte <= 90)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isUpperCase(char paramChar)
  {
    boolean bool;
    if ((paramChar >= 'A') && (paramChar <= 'Z')) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static AsciiString of(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      paramCharSequence = (AsciiString)paramCharSequence;
    } else {
      paramCharSequence = new AsciiString(paramCharSequence);
    }
    return paramCharSequence;
  }
  
  private int parseInt(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = Integer.MIN_VALUE / paramInt3;
    int j = paramInt1;
    int k = 0;
    while (j < paramInt2)
    {
      int m = Character.digit((char)(this.value[(j + this.offset)] & 0xFF), paramInt3);
      if (m != -1)
      {
        if (i <= k)
        {
          m = k * paramInt3 - m;
          if (m <= k)
          {
            k = m;
            j++;
          }
          else
          {
            throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
          }
        }
        else
        {
          throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
        }
      }
      else {
        throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
      }
    }
    paramInt3 = k;
    if (!paramBoolean)
    {
      paramInt3 = -k;
      if (paramInt3 < 0) {
        throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
      }
    }
    return paramInt3;
  }
  
  private long parseLong(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l1 = paramInt3;
    long l2 = Long.MIN_VALUE / l1;
    int i = paramInt1;
    long l3 = 0L;
    while (i < paramInt2)
    {
      int j = Character.digit((char)(this.value[(i + this.offset)] & 0xFF), paramInt3);
      if (j != -1)
      {
        if (l2 <= l3)
        {
          l4 = l3 * l1 - j;
          if (l4 <= l3)
          {
            l3 = l4;
            i++;
          }
          else
          {
            throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
          }
        }
        else
        {
          throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
        }
      }
      else {
        throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
      }
    }
    long l4 = l3;
    if (!paramBoolean)
    {
      l4 = -l3;
      if (l4 < 0L) {
        throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
      }
    }
    return l4;
  }
  
  public static boolean regionMatches(CharSequence paramCharSequence1, boolean paramBoolean, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
        return ((String)paramCharSequence1).regionMatches(paramBoolean, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3);
      }
      if ((paramCharSequence1 instanceof AsciiString)) {
        return ((AsciiString)paramCharSequence1).regionMatches(paramBoolean, paramInt1, paramCharSequence2, paramInt2, paramInt3);
      }
      Object localObject;
      if (paramBoolean) {
        localObject = GeneralCaseInsensitiveCharEqualityComparator.INSTANCE;
      } else {
        localObject = DefaultCharEqualityComparator.INSTANCE;
      }
      return regionMatchesCharSequences(paramCharSequence1, paramInt1, paramCharSequence2, paramInt2, paramInt3, (CharEqualityComparator)localObject);
    }
    return false;
  }
  
  public static boolean regionMatchesAscii(CharSequence paramCharSequence1, boolean paramBoolean, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3)
  {
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      if ((!paramBoolean) && ((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
        return ((String)paramCharSequence1).regionMatches(false, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3);
      }
      if ((paramCharSequence1 instanceof AsciiString)) {
        return ((AsciiString)paramCharSequence1).regionMatches(paramBoolean, paramInt1, paramCharSequence2, paramInt2, paramInt3);
      }
      Object localObject;
      if (paramBoolean) {
        localObject = AsciiCaseInsensitiveCharEqualityComparator.INSTANCE;
      } else {
        localObject = DefaultCharEqualityComparator.INSTANCE;
      }
      return regionMatchesCharSequences(paramCharSequence1, paramInt1, paramCharSequence2, paramInt2, paramInt3, (CharEqualityComparator)localObject);
    }
    return false;
  }
  
  private static boolean regionMatchesCharSequences(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3, CharEqualityComparator paramCharEqualityComparator)
  {
    if ((paramInt1 >= 0) && (paramInt3 <= paramCharSequence1.length() - paramInt1) && (paramInt2 >= 0) && (paramInt3 <= paramCharSequence2.length() - paramInt2))
    {
      int i = paramInt2;
      paramInt2 = paramInt1;
      while (paramInt2 < paramInt3 + paramInt1)
      {
        if (!paramCharEqualityComparator.equals(paramCharSequence1.charAt(paramInt2), paramCharSequence2.charAt(i))) {
          return false;
        }
        paramInt2++;
        i++;
      }
      return true;
    }
    return false;
  }
  
  private static AsciiString[] toAsciiStringArray(String[] paramArrayOfString)
  {
    AsciiString[] arrayOfAsciiString = new AsciiString[paramArrayOfString.length];
    for (int i = 0; i < paramArrayOfString.length; i++) {
      arrayOfAsciiString[i] = new AsciiString(paramArrayOfString[i]);
    }
    return arrayOfAsciiString;
  }
  
  private static byte toLowerCase(byte paramByte)
  {
    byte b1 = paramByte;
    if (isUpperCase(paramByte))
    {
      byte b2 = (byte)(paramByte + 32);
      b1 = b2;
    }
    return b1;
  }
  
  public static char toLowerCase(char paramChar)
  {
    char c1 = paramChar;
    if (isUpperCase(paramChar))
    {
      char c2 = (char)(paramChar + ' ');
      c1 = c2;
    }
    return c1;
  }
  
  private static byte toUpperCase(byte paramByte)
  {
    byte b1 = paramByte;
    if (isLowerCase(paramByte))
    {
      byte b2 = (byte)(paramByte - 32);
      b1 = b2;
    }
    return b1;
  }
  
  public static CharSequence trim(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      return ((AsciiString)paramCharSequence).trim();
    }
    if ((paramCharSequence instanceof String)) {
      return ((String)paramCharSequence).trim();
    }
    int i = 0;
    int j = paramCharSequence.length() - 1;
    while ((i <= j) && (paramCharSequence.charAt(i) <= ' ')) {
      i++;
    }
    for (int k = j; (k >= i) && (paramCharSequence.charAt(k) <= ' '); k--) {}
    if ((i == 0) && (k == j)) {
      return paramCharSequence;
    }
    return paramCharSequence.subSequence(i, k);
  }
  
  public byte[] array()
  {
    return this.value;
  }
  
  public void arrayChanged()
  {
    this.string = null;
    this.hash = 0;
  }
  
  public int arrayOffset()
  {
    return this.offset;
  }
  
  public byte byteAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.length))
    {
      if (PlatformDependent.hasUnsafe()) {
        return PlatformDependent.getByte(this.value, paramInt + this.offset);
      }
      return this.value[(paramInt + this.offset)];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" must be in the range [0,");
    localStringBuilder.append(this.length);
    localStringBuilder.append(")");
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public char charAt(int paramInt)
  {
    return b2c(byteAt(paramInt));
  }
  
  public int compareTo(CharSequence paramCharSequence)
  {
    int i = 0;
    if (this == paramCharSequence) {
      return 0;
    }
    int j = length();
    int k = paramCharSequence.length();
    int m = Math.min(j, k);
    for (int n = arrayOffset(); i < m; n++)
    {
      int i1 = b2c(this.value[n]) - paramCharSequence.charAt(i);
      if (i1 != 0) {
        return i1;
      }
      i++;
    }
    return j - k;
  }
  
  public AsciiString concat(CharSequence paramCharSequence)
  {
    int i = length();
    int j = paramCharSequence.length();
    if (j == 0) {
      return this;
    }
    if ((paramCharSequence instanceof AsciiString))
    {
      localObject = (AsciiString)paramCharSequence;
      if (isEmpty()) {
        return (AsciiString)localObject;
      }
      paramCharSequence = PlatformDependent.allocateUninitializedArray(i + j);
      System.arraycopy(this.value, arrayOffset(), paramCharSequence, 0, i);
      System.arraycopy(((AsciiString)localObject).value, ((AsciiString)localObject).arrayOffset(), paramCharSequence, i, j);
      return new AsciiString(paramCharSequence, false);
    }
    if (isEmpty()) {
      return new AsciiString(paramCharSequence);
    }
    Object localObject = PlatformDependent.allocateUninitializedArray(j + i);
    System.arraycopy(this.value, arrayOffset(), localObject, 0, i);
    for (j = 0; i < localObject.length; j++)
    {
      localObject[i] = c2b(paramCharSequence.charAt(j));
      i++;
    }
    return new AsciiString((byte[])localObject, false);
  }
  
  public boolean contains(CharSequence paramCharSequence)
  {
    boolean bool;
    if (indexOf(paramCharSequence) >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean contentEquals(CharSequence paramCharSequence)
  {
    if (this == paramCharSequence) {
      return true;
    }
    if ((paramCharSequence != null) && (paramCharSequence.length() == length()))
    {
      if ((paramCharSequence instanceof AsciiString)) {
        return equals(paramCharSequence);
      }
      int i = arrayOffset();
      for (int j = 0; j < paramCharSequence.length(); j++)
      {
        if (b2c(this.value[i]) != paramCharSequence.charAt(j)) {
          return false;
        }
        i++;
      }
      return true;
    }
    return false;
  }
  
  public boolean contentEqualsIgnoreCase(CharSequence paramCharSequence)
  {
    if (this == paramCharSequence) {
      return true;
    }
    if ((paramCharSequence != null) && (paramCharSequence.length() == length()))
    {
      if ((paramCharSequence instanceof AsciiString))
      {
        paramCharSequence = (AsciiString)paramCharSequence;
        i = arrayOffset();
        j = paramCharSequence.arrayOffset();
        int k = length();
        m = i;
        while (m < k + i)
        {
          if (!equalsIgnoreCase(this.value[m], paramCharSequence.value[j])) {
            return false;
          }
          m++;
          j++;
        }
        return true;
      }
      int j = arrayOffset();
      int i = length();
      for (int m = 0; m < i; m++)
      {
        if (!equalsIgnoreCase(b2c(this.value[j]), paramCharSequence.charAt(m))) {
          return false;
        }
        j++;
      }
      return true;
    }
    return false;
  }
  
  public void copy(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt3, length()))
    {
      System.arraycopy(this.value, paramInt1 + this.offset, ObjectUtil.checkNotNull(paramArrayOfByte, "dst"), paramInt2, paramInt3);
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("expected: 0 <= srcIdx(");
    paramArrayOfByte.append(paramInt1);
    paramArrayOfByte.append(") <= srcIdx + length(");
    paramArrayOfByte.append(paramInt3);
    paramArrayOfByte.append(") <= srcLen(");
    paramArrayOfByte.append(length());
    paramArrayOfByte.append(')');
    throw new IndexOutOfBoundsException(paramArrayOfByte.toString());
  }
  
  public void copy(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    ObjectUtil.checkNotNull(paramArrayOfChar, "dst");
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt3, length()))
    {
      int i = paramInt1 + arrayOffset();
      paramInt1 = paramInt2;
      while (paramInt1 < paramInt3 + paramInt2)
      {
        paramArrayOfChar[paramInt1] = b2c(this.value[i]);
        paramInt1++;
        i++;
      }
      return;
    }
    paramArrayOfChar = new StringBuilder();
    paramArrayOfChar.append("expected: 0 <= srcIdx(");
    paramArrayOfChar.append(paramInt1);
    paramArrayOfChar.append(") <= srcIdx + length(");
    paramArrayOfChar.append(paramInt3);
    paramArrayOfChar.append(") <= srcLen(");
    paramArrayOfChar.append(length());
    paramArrayOfChar.append(')');
    throw new IndexOutOfBoundsException(paramArrayOfChar.toString());
  }
  
  public boolean endsWith(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    return regionMatches(length() - i, paramCharSequence, 0, i);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null) {
      if (paramObject.getClass() != AsciiString.class)
      {
        bool2 = bool1;
      }
      else
      {
        if (this == paramObject) {
          return true;
        }
        paramObject = (AsciiString)paramObject;
        bool2 = bool1;
        if (length() == ((AsciiString)paramObject).length())
        {
          bool2 = bool1;
          if (hashCode() == ((AsciiString)paramObject).hashCode())
          {
            bool2 = bool1;
            if (PlatformDependent.equals(array(), arrayOffset(), ((AsciiString)paramObject).array(), ((AsciiString)paramObject).arrayOffset(), length())) {
              bool2 = true;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public int forEachByte(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
    throws Exception
  {
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt2, length())) {
      return forEachByte0(paramInt1, paramInt2, paramByteProcessor);
    }
    paramByteProcessor = new StringBuilder();
    paramByteProcessor.append("expected: 0 <= index(");
    paramByteProcessor.append(paramInt1);
    paramByteProcessor.append(") <= start + length(");
    paramByteProcessor.append(paramInt2);
    paramByteProcessor.append(") <= length(");
    paramByteProcessor.append(length());
    paramByteProcessor.append(')');
    throw new IndexOutOfBoundsException(paramByteProcessor.toString());
  }
  
  public int forEachByte(ByteProcessor paramByteProcessor)
    throws Exception
  {
    return forEachByte0(0, length(), paramByteProcessor);
  }
  
  public int forEachByteDesc(int paramInt1, int paramInt2, ByteProcessor paramByteProcessor)
    throws Exception
  {
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt2, length())) {
      return forEachByteDesc0(paramInt1, paramInt2, paramByteProcessor);
    }
    paramByteProcessor = new StringBuilder();
    paramByteProcessor.append("expected: 0 <= index(");
    paramByteProcessor.append(paramInt1);
    paramByteProcessor.append(") <= start + length(");
    paramByteProcessor.append(paramInt2);
    paramByteProcessor.append(") <= length(");
    paramByteProcessor.append(length());
    paramByteProcessor.append(')');
    throw new IndexOutOfBoundsException(paramByteProcessor.toString());
  }
  
  public int forEachByteDesc(ByteProcessor paramByteProcessor)
    throws Exception
  {
    return forEachByteDesc0(0, length(), paramByteProcessor);
  }
  
  public int hashCode()
  {
    int i = this.hash;
    int j = i;
    if (i == 0)
    {
      j = PlatformDependent.hashCodeAscii(this.value, this.offset, this.length);
      this.hash = j;
    }
    return j;
  }
  
  public int indexOf(char paramChar, int paramInt)
  {
    if (paramChar > 'ÿ') {
      return -1;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    int j = c2b0(paramChar);
    int k = this.offset;
    int m = this.length;
    for (paramInt = i + k; paramInt < m + k; paramInt++) {
      if (this.value[paramInt] == j) {
        return paramInt - this.offset;
      }
    }
    return -1;
  }
  
  public int indexOf(CharSequence paramCharSequence)
  {
    return indexOf(paramCharSequence, 0);
  }
  
  public int indexOf(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    int j = paramInt;
    if (paramInt < 0) {
      j = 0;
    }
    if (i <= 0)
    {
      paramInt = this.length;
      if (j < paramInt) {
        paramInt = j;
      }
      return paramInt;
    }
    if (i > this.length - j) {
      return -1;
    }
    char c = paramCharSequence.charAt(0);
    if (c > 'ÿ') {
      return -1;
    }
    int k = c2b0(c);
    int m = this.offset;
    int n = this.length;
    for (paramInt = j + m; paramInt <= n + m - i; paramInt++) {
      if (this.value[paramInt] == k)
      {
        j = paramInt;
        int i1 = 0;
        byte[] arrayOfByte;
        do
        {
          i1++;
          if (i1 >= i) {
            break;
          }
          arrayOfByte = this.value;
          j++;
        } while (b2c(arrayOfByte[j]) == paramCharSequence.charAt(i1));
        if (i1 == i) {
          return paramInt - this.offset;
        }
      }
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.length == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isEntireArrayUsed()
  {
    boolean bool;
    if ((this.offset == 0) && (this.length == this.value.length)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int lastIndexOf(CharSequence paramCharSequence)
  {
    return lastIndexOf(paramCharSequence, this.length);
  }
  
  public int lastIndexOf(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    paramInt = Math.min(paramInt, this.length - i);
    if (paramInt < 0) {
      return -1;
    }
    if (i == 0) {
      return paramInt;
    }
    char c = paramCharSequence.charAt(0);
    if (c > 'ÿ') {
      return -1;
    }
    int j = c2b0(c);
    for (paramInt = this.offset + paramInt; paramInt >= 0; paramInt--) {
      if (this.value[paramInt] == j)
      {
        int k = paramInt;
        int m = 0;
        byte[] arrayOfByte;
        do
        {
          m++;
          if (m >= i) {
            break;
          }
          arrayOfByte = this.value;
          k++;
        } while (b2c(arrayOfByte[k]) == paramCharSequence.charAt(m));
        if (m == i) {
          return paramInt - this.offset;
        }
      }
    }
    return -1;
  }
  
  public int length()
  {
    return this.length;
  }
  
  public boolean matches(String paramString)
  {
    return Pattern.matches(paramString, this);
  }
  
  public boolean parseBoolean()
  {
    int i = this.length;
    boolean bool = true;
    if ((i < 1) || (this.value[this.offset] == 0)) {
      bool = false;
    }
    return bool;
  }
  
  public char parseChar()
  {
    return parseChar(0);
  }
  
  public char parseChar(int paramInt)
  {
    if (paramInt + 1 < length())
    {
      int i = paramInt + this.offset;
      paramInt = b2c(this.value[i]);
      return (char)(b2c(this.value[(i + 1)]) | paramInt << 8);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("2 bytes required to convert to character. index ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" would go out of bounds.");
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public double parseDouble()
  {
    return parseDouble(0, length());
  }
  
  public double parseDouble(int paramInt1, int paramInt2)
  {
    return Double.parseDouble(toString(paramInt1, paramInt2));
  }
  
  public float parseFloat()
  {
    return parseFloat(0, length());
  }
  
  public float parseFloat(int paramInt1, int paramInt2)
  {
    return Float.parseFloat(toString(paramInt1, paramInt2));
  }
  
  public int parseInt()
  {
    return parseInt(0, length(), 10);
  }
  
  public int parseInt(int paramInt)
  {
    return parseInt(0, length(), paramInt);
  }
  
  public int parseInt(int paramInt1, int paramInt2)
  {
    return parseInt(paramInt1, paramInt2, 10);
  }
  
  public int parseInt(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 >= 2) && (paramInt3 <= 36))
    {
      if (paramInt1 != paramInt2)
      {
        boolean bool;
        if (byteAt(paramInt1) == 45) {
          bool = true;
        } else {
          bool = false;
        }
        int i = paramInt1;
        if (bool)
        {
          i = paramInt1 + 1;
          if (i == paramInt2) {
            throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
          }
        }
        return parseInt(i, paramInt2, paramInt3, bool);
      }
      throw new NumberFormatException();
    }
    throw new NumberFormatException();
  }
  
  public long parseLong()
  {
    return parseLong(0, length(), 10);
  }
  
  public long parseLong(int paramInt)
  {
    return parseLong(0, length(), paramInt);
  }
  
  public long parseLong(int paramInt1, int paramInt2)
  {
    return parseLong(paramInt1, paramInt2, 10);
  }
  
  public long parseLong(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 >= 2) && (paramInt3 <= 36))
    {
      if (paramInt1 != paramInt2)
      {
        boolean bool;
        if (byteAt(paramInt1) == 45) {
          bool = true;
        } else {
          bool = false;
        }
        int i = paramInt1;
        if (bool)
        {
          i = paramInt1 + 1;
          if (i == paramInt2) {
            throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
          }
        }
        return parseLong(i, paramInt2, paramInt3, bool);
      }
      throw new NumberFormatException();
    }
    throw new NumberFormatException();
  }
  
  public short parseShort()
  {
    return parseShort(0, length(), 10);
  }
  
  public short parseShort(int paramInt)
  {
    return parseShort(0, length(), paramInt);
  }
  
  public short parseShort(int paramInt1, int paramInt2)
  {
    return parseShort(paramInt1, paramInt2, 10);
  }
  
  public short parseShort(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = parseInt(paramInt1, paramInt2, paramInt3);
    int i = (short)paramInt3;
    if (i == paramInt3) {
      return i;
    }
    throw new NumberFormatException(subSequence(paramInt1, paramInt2, false).toString());
  }
  
  public boolean regionMatches(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    ObjectUtil.checkNotNull(paramCharSequence, "string");
    if ((paramInt2 >= 0) && (paramCharSequence.length() - paramInt2 >= paramInt3))
    {
      int i = length();
      if ((paramInt1 >= 0) && (i - paramInt1 >= paramInt3))
      {
        if (paramInt3 <= 0) {
          return true;
        }
        i = paramInt1 + arrayOffset();
        paramInt1 = paramInt2;
        while (paramInt1 < paramInt3 + paramInt2)
        {
          if (b2c(this.value[i]) != paramCharSequence.charAt(paramInt1)) {
            return false;
          }
          paramInt1++;
          i++;
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean regionMatches(boolean paramBoolean, int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3)
  {
    if (!paramBoolean) {
      return regionMatches(paramInt1, paramCharSequence, paramInt2, paramInt3);
    }
    ObjectUtil.checkNotNull(paramCharSequence, "string");
    int i = length();
    if ((paramInt1 >= 0) && (paramInt3 <= i - paramInt1) && (paramInt2 >= 0) && (paramInt3 <= paramCharSequence.length() - paramInt2))
    {
      i = paramInt1 + arrayOffset();
      for (paramInt1 = i; paramInt1 < paramInt3 + i; paramInt1++)
      {
        if (!equalsIgnoreCase(b2c(this.value[paramInt1]), paramCharSequence.charAt(paramInt2))) {
          return false;
        }
        paramInt2++;
      }
      return true;
    }
    return false;
  }
  
  public AsciiString replace(char paramChar1, char paramChar2)
  {
    if (paramChar1 > 'ÿ') {
      return this;
    }
    int i = c2b0(paramChar1);
    int j = c2b(paramChar2);
    int k = this.offset;
    int m = this.length + k;
    while (k < m)
    {
      if (this.value[k] == i)
      {
        byte[] arrayOfByte1 = PlatformDependent.allocateUninitializedArray(length());
        byte[] arrayOfByte2 = this.value;
        int n = this.offset;
        System.arraycopy(arrayOfByte2, n, arrayOfByte1, 0, k - n);
        arrayOfByte1[(k - this.offset)] = ((byte)j);
        for (;;)
        {
          n = k + 1;
          if (n >= m) {
            break;
          }
          k = this.value[n];
          int i1 = this.offset;
          if (k == i) {
            k = j;
          }
          arrayOfByte1[(n - i1)] = ((byte)k);
          k = n;
        }
        return new AsciiString(arrayOfByte1, false);
      }
      k++;
    }
    return this;
  }
  
  public AsciiString[] split(char paramChar)
  {
    ArrayList localArrayList = InternalThreadLocalMap.get().arrayList();
    int i = length();
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      m = k;
      if (charAt(j) == paramChar)
      {
        if (k == j) {
          localArrayList.add(EMPTY_STRING);
        } else {
          localArrayList.add(new AsciiString(this.value, arrayOffset() + k, j - k, false));
        }
        m = j + 1;
      }
      j++;
    }
    if (k == 0) {
      localArrayList.add(this);
    } else if (k != i) {
      localArrayList.add(new AsciiString(this.value, arrayOffset() + k, i - k, false));
    } else {
      for (paramChar = localArrayList.size() - 1; (paramChar >= 0) && (((AsciiString)localArrayList.get(paramChar)).isEmpty()); paramChar--) {
        localArrayList.remove(paramChar);
      }
    }
    return (AsciiString[])localArrayList.toArray(new AsciiString[0]);
  }
  
  public AsciiString[] split(String paramString, int paramInt)
  {
    return toAsciiStringArray(Pattern.compile(paramString).split(this, paramInt));
  }
  
  public boolean startsWith(CharSequence paramCharSequence)
  {
    return startsWith(paramCharSequence, 0);
  }
  
  public boolean startsWith(CharSequence paramCharSequence, int paramInt)
  {
    return regionMatches(paramInt, paramCharSequence, 0, paramCharSequence.length());
  }
  
  public AsciiString subSequence(int paramInt)
  {
    return subSequence(paramInt, length());
  }
  
  public AsciiString subSequence(int paramInt1, int paramInt2)
  {
    return subSequence(paramInt1, paramInt2, true);
  }
  
  public AsciiString subSequence(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt2 - paramInt1;
    if (!MathUtil.isOutOfBounds(paramInt1, i, length()))
    {
      if ((paramInt1 == 0) && (paramInt2 == length())) {
        return this;
      }
      if (paramInt2 == paramInt1) {
        return EMPTY_STRING;
      }
      return new AsciiString(this.value, paramInt1 + this.offset, i, paramBoolean);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expected: 0 <= start(");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") <= end (");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") <= length(");
    localStringBuilder.append(length());
    localStringBuilder.append(')');
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public byte[] toByteArray()
  {
    return toByteArray(0, length());
  }
  
  public byte[] toByteArray(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this.value;
    int i = this.offset;
    return Arrays.copyOfRange(arrayOfByte, paramInt1 + i, paramInt2 + i);
  }
  
  public char[] toCharArray()
  {
    return toCharArray(0, length());
  }
  
  public char[] toCharArray(int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (i == 0) {
      return EmptyArrays.EMPTY_CHARS;
    }
    if (!MathUtil.isOutOfBounds(paramInt1, i, length()))
    {
      localObject = new char[i];
      paramInt2 = 0;
      paramInt1 += arrayOffset();
      while (paramInt2 < i)
      {
        localObject[paramInt2] = b2c(this.value[paramInt1]);
        paramInt2++;
        paramInt1++;
      }
      return (char[])localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("expected: 0 <= start(");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(") <= srcIdx + length(");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(") <= srcLen(");
    ((StringBuilder)localObject).append(length());
    ((StringBuilder)localObject).append(')');
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public AsciiString toLowerCase()
  {
    int i = length();
    int j = arrayOffset();
    for (int k = arrayOffset(); k < i + j; k++)
    {
      int m = this.value[k];
      if ((m >= 65) && (m <= 90))
      {
        k = 0;
        break label57;
      }
    }
    k = 1;
    label57:
    if (k != 0) {
      return this;
    }
    byte[] arrayOfByte = PlatformDependent.allocateUninitializedArray(length());
    k = arrayOffset();
    j = 0;
    while (j < arrayOfByte.length)
    {
      arrayOfByte[j] = toLowerCase(this.value[k]);
      j++;
      k++;
    }
    return new AsciiString(arrayOfByte, false);
  }
  
  public String toString()
  {
    String str1 = this.string;
    String str2 = str1;
    if (str1 == null)
    {
      str2 = toString(0);
      this.string = str2;
    }
    return str2;
  }
  
  public String toString(int paramInt)
  {
    return toString(paramInt, length());
  }
  
  public String toString(int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    if (paramInt2 == 0) {
      return "";
    }
    if (!MathUtil.isOutOfBounds(paramInt1, paramInt2, length())) {
      return new String(this.value, 0, paramInt1 + this.offset, paramInt2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("expected: 0 <= start(");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") <= srcIdx + length(");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(") <= srcLen(");
    localStringBuilder.append(length());
    localStringBuilder.append(')');
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public AsciiString toUpperCase()
  {
    int i = length();
    int j = arrayOffset();
    for (int k = arrayOffset(); k < i + j; k++)
    {
      int m = this.value[k];
      if ((m >= 97) && (m <= 122))
      {
        k = 0;
        break label57;
      }
    }
    k = 1;
    label57:
    if (k != 0) {
      return this;
    }
    byte[] arrayOfByte = PlatformDependent.allocateUninitializedArray(length());
    i = arrayOffset();
    k = 0;
    while (k < arrayOfByte.length)
    {
      arrayOfByte[k] = toUpperCase(this.value[i]);
      k++;
      i++;
    }
    return new AsciiString(arrayOfByte, false);
  }
  
  public AsciiString trim()
  {
    int i = arrayOffset();
    int j = arrayOffset() + length() - 1;
    while ((i <= j) && (this.value[i] <= 32)) {
      i++;
    }
    for (int k = j; (k >= i) && (this.value[k] <= 32); k--) {}
    if ((i == 0) && (k == j)) {
      return this;
    }
    return new AsciiString(this.value, i, k - i + 1, false);
  }
  
  private static final class AsciiCaseInsensitiveCharEqualityComparator
    implements AsciiString.CharEqualityComparator
  {
    static final AsciiCaseInsensitiveCharEqualityComparator INSTANCE = new AsciiCaseInsensitiveCharEqualityComparator();
    
    public boolean equals(char paramChar1, char paramChar2)
    {
      return AsciiString.equalsIgnoreCase(paramChar1, paramChar2);
    }
  }
  
  private static abstract interface CharEqualityComparator
  {
    public abstract boolean equals(char paramChar1, char paramChar2);
  }
  
  private static final class DefaultCharEqualityComparator
    implements AsciiString.CharEqualityComparator
  {
    static final DefaultCharEqualityComparator INSTANCE = new DefaultCharEqualityComparator();
    
    public boolean equals(char paramChar1, char paramChar2)
    {
      boolean bool;
      if (paramChar1 == paramChar2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  private static final class GeneralCaseInsensitiveCharEqualityComparator
    implements AsciiString.CharEqualityComparator
  {
    static final GeneralCaseInsensitiveCharEqualityComparator INSTANCE = new GeneralCaseInsensitiveCharEqualityComparator();
    
    public boolean equals(char paramChar1, char paramChar2)
    {
      boolean bool;
      if ((Character.toUpperCase(paramChar1) != Character.toUpperCase(paramChar2)) && (Character.toLowerCase(paramChar1) != Character.toLowerCase(paramChar2))) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\AsciiString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */