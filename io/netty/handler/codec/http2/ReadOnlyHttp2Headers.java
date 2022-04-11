package io.netty.handler.codec.http2;

import io.netty.handler.codec.CharSequenceValueConverter;
import io.netty.handler.codec.DefaultHeaders.NameValidator;
import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import io.netty.util.HashingStrategy;
import io.netty.util.internal.EmptyArrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class ReadOnlyHttp2Headers
  implements Http2Headers
{
  private static final byte PSEUDO_HEADER_TOKEN = 58;
  private final AsciiString[] otherHeaders;
  private final AsciiString[] pseudoHeaders;
  
  private ReadOnlyHttp2Headers(boolean paramBoolean, AsciiString[] paramArrayOfAsciiString1, AsciiString... paramVarArgs)
  {
    if ((paramVarArgs.length & 0x1) == 0)
    {
      if (paramBoolean) {
        validateHeaders(paramArrayOfAsciiString1, paramVarArgs);
      }
      this.pseudoHeaders = paramArrayOfAsciiString1;
      this.otherHeaders = paramVarArgs;
      return;
    }
    throw newInvalidArraySizeException();
  }
  
  public static ReadOnlyHttp2Headers clientHeaders(boolean paramBoolean, AsciiString paramAsciiString1, AsciiString paramAsciiString2, AsciiString paramAsciiString3, AsciiString paramAsciiString4, AsciiString... paramVarArgs)
  {
    return new ReadOnlyHttp2Headers(paramBoolean, new AsciiString[] { Http2Headers.PseudoHeaderName.METHOD.value(), paramAsciiString1, Http2Headers.PseudoHeaderName.PATH.value(), paramAsciiString2, Http2Headers.PseudoHeaderName.SCHEME.value(), paramAsciiString3, Http2Headers.PseudoHeaderName.AUTHORITY.value(), paramAsciiString4 }, paramVarArgs);
  }
  
  private static boolean contains(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2, HashingStrategy<CharSequence> paramHashingStrategy, AsciiString[] paramArrayOfAsciiString)
  {
    int i = paramArrayOfAsciiString.length;
    for (int j = 0; j < i - 1; j += 2)
    {
      AsciiString localAsciiString1 = paramArrayOfAsciiString[j];
      AsciiString localAsciiString2 = paramArrayOfAsciiString[(j + 1)];
      if ((localAsciiString1.hashCode() == paramInt1) && (localAsciiString2.hashCode() == paramInt2) && (localAsciiString1.contentEqualsIgnoreCase(paramCharSequence1)) && (paramHashingStrategy.equals(localAsciiString2, paramCharSequence2))) {
        return true;
      }
    }
    return false;
  }
  
  private AsciiString get0(CharSequence paramCharSequence)
  {
    int i = AsciiString.hashCode(paramCharSequence);
    int j = this.pseudoHeaders.length;
    int k = 0;
    AsciiString localAsciiString;
    for (int m = 0; m < j - 1; m += 2)
    {
      localAsciiString = this.pseudoHeaders[m];
      if ((localAsciiString.hashCode() == i) && (localAsciiString.contentEqualsIgnoreCase(paramCharSequence))) {
        return this.pseudoHeaders[(m + 1)];
      }
    }
    j = this.otherHeaders.length;
    for (m = k; m < j - 1; m += 2)
    {
      localAsciiString = this.otherHeaders[m];
      if ((localAsciiString.hashCode() == i) && (localAsciiString.contentEqualsIgnoreCase(paramCharSequence))) {
        return this.otherHeaders[(m + 1)];
      }
    }
    return null;
  }
  
  private static IllegalArgumentException newInvalidArraySizeException()
  {
    return new IllegalArgumentException("pseudoHeaders and otherHeaders must be arrays of [name, value] pairs");
  }
  
  public static ReadOnlyHttp2Headers serverHeaders(boolean paramBoolean, AsciiString paramAsciiString, AsciiString... paramVarArgs)
  {
    return new ReadOnlyHttp2Headers(paramBoolean, new AsciiString[] { Http2Headers.PseudoHeaderName.STATUS.value(), paramAsciiString }, paramVarArgs);
  }
  
  public static ReadOnlyHttp2Headers trailers(boolean paramBoolean, AsciiString... paramVarArgs)
  {
    return new ReadOnlyHttp2Headers(paramBoolean, EmptyArrays.EMPTY_ASCII_STRINGS, paramVarArgs);
  }
  
  private static void validateHeaders(AsciiString[] paramArrayOfAsciiString1, AsciiString... paramVarArgs)
  {
    int i = 1;
    while (i < paramArrayOfAsciiString1.length) {
      if (paramArrayOfAsciiString1[i] != null)
      {
        i += 2;
      }
      else
      {
        paramArrayOfAsciiString1 = new StringBuilder();
        paramArrayOfAsciiString1.append("pseudoHeaders value at index ");
        paramArrayOfAsciiString1.append(i);
        paramArrayOfAsciiString1.append(" is null");
        throw new IllegalArgumentException(paramArrayOfAsciiString1.toString());
      }
    }
    int j = paramVarArgs.length;
    int k = 0;
    int m = 0;
    while (k < j - 1)
    {
      paramArrayOfAsciiString1 = paramVarArgs[k];
      DefaultHttp2Headers.HTTP2_NAME_VALIDATOR.validateName(paramArrayOfAsciiString1);
      if ((m == 0) && (!paramArrayOfAsciiString1.isEmpty()) && (paramArrayOfAsciiString1.byteAt(0) != 58))
      {
        i = 1;
      }
      else
      {
        i = m;
        if (m != 0)
        {
          i = m;
          if (!paramArrayOfAsciiString1.isEmpty()) {
            if (paramArrayOfAsciiString1.byteAt(0) != 58)
            {
              i = m;
            }
            else
            {
              paramArrayOfAsciiString1 = new StringBuilder();
              paramArrayOfAsciiString1.append("otherHeaders name at index ");
              paramArrayOfAsciiString1.append(k);
              paramArrayOfAsciiString1.append(" is a pseudo header that appears after non-pseudo headers.");
              throw new IllegalArgumentException(paramArrayOfAsciiString1.toString());
            }
          }
        }
      }
      m = k + 1;
      if (paramVarArgs[m] != null)
      {
        k += 2;
        m = i;
      }
      else
      {
        paramArrayOfAsciiString1 = new StringBuilder();
        paramArrayOfAsciiString1.append("otherHeaders value at index ");
        paramArrayOfAsciiString1.append(m);
        paramArrayOfAsciiString1.append(" is null");
        throw new IllegalArgumentException(paramArrayOfAsciiString1.toString());
      }
    }
  }
  
  public Http2Headers add(Headers<? extends CharSequence, ? extends CharSequence, ?> paramHeaders)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers add(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers add(CharSequence paramCharSequence, Iterable<? extends CharSequence> paramIterable)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers add(CharSequence paramCharSequence, CharSequence... paramVarArgs)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addBoolean(CharSequence paramCharSequence, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addByte(CharSequence paramCharSequence, byte paramByte)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addChar(CharSequence paramCharSequence, char paramChar)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addDouble(CharSequence paramCharSequence, double paramDouble)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addFloat(CharSequence paramCharSequence, float paramFloat)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addInt(CharSequence paramCharSequence, int paramInt)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addLong(CharSequence paramCharSequence, long paramLong)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addObject(CharSequence paramCharSequence, Iterable<?> paramIterable)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addObject(CharSequence paramCharSequence, Object paramObject)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addObject(CharSequence paramCharSequence, Object... paramVarArgs)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addShort(CharSequence paramCharSequence, short paramShort)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers addTimeMillis(CharSequence paramCharSequence, long paramLong)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers authority(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public CharSequence authority()
  {
    return get(Http2Headers.PseudoHeaderName.AUTHORITY.value());
  }
  
  public Http2Headers clear()
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public boolean contains(CharSequence paramCharSequence)
  {
    boolean bool;
    if (get(paramCharSequence) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return contains(paramCharSequence1, paramCharSequence2, false);
  }
  
  public boolean contains(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    int i = AsciiString.hashCode(paramCharSequence1);
    HashingStrategy localHashingStrategy;
    if (paramBoolean) {
      localHashingStrategy = AsciiString.CASE_INSENSITIVE_HASHER;
    } else {
      localHashingStrategy = AsciiString.CASE_SENSITIVE_HASHER;
    }
    int j = localHashingStrategy.hashCode(paramCharSequence2);
    if ((!contains(paramCharSequence1, i, paramCharSequence2, j, localHashingStrategy, this.otherHeaders)) && (!contains(paramCharSequence1, i, paramCharSequence2, j, localHashingStrategy, this.pseudoHeaders))) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean containsBoolean(CharSequence paramCharSequence, boolean paramBoolean)
  {
    return contains(paramCharSequence, String.valueOf(paramBoolean));
  }
  
  public boolean containsByte(CharSequence paramCharSequence, byte paramByte)
  {
    return contains(paramCharSequence, String.valueOf(paramByte));
  }
  
  public boolean containsChar(CharSequence paramCharSequence, char paramChar)
  {
    return contains(paramCharSequence, String.valueOf(paramChar));
  }
  
  public boolean containsDouble(CharSequence paramCharSequence, double paramDouble)
  {
    return contains(paramCharSequence, String.valueOf(paramDouble));
  }
  
  public boolean containsFloat(CharSequence paramCharSequence, float paramFloat)
  {
    return false;
  }
  
  public boolean containsInt(CharSequence paramCharSequence, int paramInt)
  {
    return contains(paramCharSequence, String.valueOf(paramInt));
  }
  
  public boolean containsLong(CharSequence paramCharSequence, long paramLong)
  {
    return contains(paramCharSequence, String.valueOf(paramLong));
  }
  
  public boolean containsObject(CharSequence paramCharSequence, Object paramObject)
  {
    if ((paramObject instanceof CharSequence)) {
      return contains(paramCharSequence, (CharSequence)paramObject);
    }
    return contains(paramCharSequence, paramObject.toString());
  }
  
  public boolean containsShort(CharSequence paramCharSequence, short paramShort)
  {
    return contains(paramCharSequence, String.valueOf(paramShort));
  }
  
  public boolean containsTimeMillis(CharSequence paramCharSequence, long paramLong)
  {
    return contains(paramCharSequence, String.valueOf(paramLong));
  }
  
  public CharSequence get(CharSequence paramCharSequence)
  {
    return get0(paramCharSequence);
  }
  
  public CharSequence get(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    paramCharSequence1 = get(paramCharSequence1);
    if (paramCharSequence1 != null) {
      paramCharSequence2 = paramCharSequence1;
    }
    return paramCharSequence2;
  }
  
  public List<CharSequence> getAll(CharSequence paramCharSequence)
  {
    int i = AsciiString.hashCode(paramCharSequence);
    ArrayList localArrayList = new ArrayList();
    int j = this.pseudoHeaders.length;
    int k = 0;
    AsciiString localAsciiString;
    for (int m = 0; m < j - 1; m += 2)
    {
      localAsciiString = this.pseudoHeaders[m];
      if ((localAsciiString.hashCode() == i) && (localAsciiString.contentEqualsIgnoreCase(paramCharSequence))) {
        localArrayList.add(this.pseudoHeaders[(m + 1)]);
      }
    }
    j = this.otherHeaders.length;
    for (m = k; m < j - 1; m += 2)
    {
      localAsciiString = this.otherHeaders[m];
      if ((localAsciiString.hashCode() == i) && (localAsciiString.contentEqualsIgnoreCase(paramCharSequence))) {
        localArrayList.add(this.otherHeaders[(m + 1)]);
      }
    }
    return localArrayList;
  }
  
  public List<CharSequence> getAllAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public CharSequence getAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public CharSequence getAndRemove(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Boolean getBoolean(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramCharSequence = Boolean.valueOf(CharSequenceValueConverter.INSTANCE.convertToBoolean(paramCharSequence));
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  public boolean getBoolean(CharSequence paramCharSequence, boolean paramBoolean)
  {
    paramCharSequence = getBoolean(paramCharSequence);
    if (paramCharSequence != null) {
      paramBoolean = paramCharSequence.booleanValue();
    }
    return paramBoolean;
  }
  
  public Boolean getBooleanAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public boolean getBooleanAndRemove(CharSequence paramCharSequence, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public byte getByte(CharSequence paramCharSequence, byte paramByte)
  {
    paramCharSequence = getByte(paramCharSequence);
    byte b = paramByte;
    if (paramCharSequence != null)
    {
      paramByte = paramCharSequence.byteValue();
      b = paramByte;
    }
    return b;
  }
  
  public Byte getByte(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramCharSequence = Byte.valueOf(CharSequenceValueConverter.INSTANCE.convertToByte(paramCharSequence));
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  public byte getByteAndRemove(CharSequence paramCharSequence, byte paramByte)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Byte getByteAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public char getChar(CharSequence paramCharSequence, char paramChar)
  {
    paramCharSequence = getChar(paramCharSequence);
    char c = paramChar;
    if (paramCharSequence != null)
    {
      paramChar = paramCharSequence.charValue();
      c = paramChar;
    }
    return c;
  }
  
  public Character getChar(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramCharSequence = Character.valueOf(CharSequenceValueConverter.INSTANCE.convertToChar(paramCharSequence));
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  public char getCharAndRemove(CharSequence paramCharSequence, char paramChar)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Character getCharAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public double getDouble(CharSequence paramCharSequence, double paramDouble)
  {
    paramCharSequence = getDouble(paramCharSequence);
    if (paramCharSequence != null) {
      paramDouble = paramCharSequence.doubleValue();
    }
    return paramDouble;
  }
  
  public Double getDouble(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramCharSequence = Double.valueOf(CharSequenceValueConverter.INSTANCE.convertToDouble(paramCharSequence));
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  public double getDoubleAndRemove(CharSequence paramCharSequence, double paramDouble)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Double getDoubleAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public float getFloat(CharSequence paramCharSequence, float paramFloat)
  {
    paramCharSequence = getFloat(paramCharSequence);
    if (paramCharSequence != null) {
      paramFloat = paramCharSequence.floatValue();
    }
    return paramFloat;
  }
  
  public Float getFloat(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramCharSequence = Float.valueOf(CharSequenceValueConverter.INSTANCE.convertToFloat(paramCharSequence));
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  public float getFloatAndRemove(CharSequence paramCharSequence, float paramFloat)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Float getFloatAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public int getInt(CharSequence paramCharSequence, int paramInt)
  {
    paramCharSequence = getInt(paramCharSequence);
    if (paramCharSequence != null) {
      paramInt = paramCharSequence.intValue();
    }
    return paramInt;
  }
  
  public Integer getInt(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramCharSequence = Integer.valueOf(CharSequenceValueConverter.INSTANCE.convertToInt(paramCharSequence));
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  public int getIntAndRemove(CharSequence paramCharSequence, int paramInt)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Integer getIntAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public long getLong(CharSequence paramCharSequence, long paramLong)
  {
    paramCharSequence = getLong(paramCharSequence);
    if (paramCharSequence != null) {
      paramLong = paramCharSequence.longValue();
    }
    return paramLong;
  }
  
  public Long getLong(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramCharSequence = Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToLong(paramCharSequence));
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  public long getLongAndRemove(CharSequence paramCharSequence, long paramLong)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Long getLongAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Short getShort(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramCharSequence = Short.valueOf(CharSequenceValueConverter.INSTANCE.convertToShort(paramCharSequence));
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  public short getShort(CharSequence paramCharSequence, short paramShort)
  {
    paramCharSequence = getShort(paramCharSequence);
    short s = paramShort;
    if (paramCharSequence != null)
    {
      paramShort = paramCharSequence.shortValue();
      s = paramShort;
    }
    return s;
  }
  
  public Short getShortAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public short getShortAndRemove(CharSequence paramCharSequence, short paramShort)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public long getTimeMillis(CharSequence paramCharSequence, long paramLong)
  {
    paramCharSequence = getTimeMillis(paramCharSequence);
    if (paramCharSequence != null) {
      paramLong = paramCharSequence.longValue();
    }
    return paramLong;
  }
  
  public Long getTimeMillis(CharSequence paramCharSequence)
  {
    paramCharSequence = get0(paramCharSequence);
    if (paramCharSequence != null) {
      paramCharSequence = Long.valueOf(CharSequenceValueConverter.INSTANCE.convertToTimeMillis(paramCharSequence));
    } else {
      paramCharSequence = null;
    }
    return paramCharSequence;
  }
  
  public long getTimeMillisAndRemove(CharSequence paramCharSequence, long paramLong)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Long getTimeMillisAndRemove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if ((this.pseudoHeaders.length == 0) && (this.otherHeaders.length == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<Map.Entry<CharSequence, CharSequence>> iterator()
  {
    return new ReadOnlyIterator(null);
  }
  
  public Http2Headers method(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public CharSequence method()
  {
    return get(Http2Headers.PseudoHeaderName.METHOD.value());
  }
  
  public Set<CharSequence> names()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(size());
    int i = this.pseudoHeaders.length;
    int j = 0;
    for (int k = 0; k < i - 1; k += 2) {
      localLinkedHashSet.add(this.pseudoHeaders[k]);
    }
    i = this.otherHeaders.length;
    for (k = j; k < i - 1; k += 2) {
      localLinkedHashSet.add(this.otherHeaders[k]);
    }
    return localLinkedHashSet;
  }
  
  public Http2Headers path(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public CharSequence path()
  {
    return get(Http2Headers.PseudoHeaderName.PATH.value());
  }
  
  public boolean remove(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers scheme(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public CharSequence scheme()
  {
    return get(Http2Headers.PseudoHeaderName.SCHEME.value());
  }
  
  public Http2Headers set(Headers<? extends CharSequence, ? extends CharSequence, ?> paramHeaders)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers set(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers set(CharSequence paramCharSequence, Iterable<? extends CharSequence> paramIterable)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers set(CharSequence paramCharSequence, CharSequence... paramVarArgs)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setAll(Headers<? extends CharSequence, ? extends CharSequence, ?> paramHeaders)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setBoolean(CharSequence paramCharSequence, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setByte(CharSequence paramCharSequence, byte paramByte)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setChar(CharSequence paramCharSequence, char paramChar)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setDouble(CharSequence paramCharSequence, double paramDouble)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setFloat(CharSequence paramCharSequence, float paramFloat)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setInt(CharSequence paramCharSequence, int paramInt)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setLong(CharSequence paramCharSequence, long paramLong)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setObject(CharSequence paramCharSequence, Iterable<?> paramIterable)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setObject(CharSequence paramCharSequence, Object paramObject)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setObject(CharSequence paramCharSequence, Object... paramVarArgs)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setShort(CharSequence paramCharSequence, short paramShort)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public Http2Headers setTimeMillis(CharSequence paramCharSequence, long paramLong)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public int size()
  {
    return this.pseudoHeaders.length + this.otherHeaders.length >>> 1;
  }
  
  public Http2Headers status(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("read only");
  }
  
  public CharSequence status()
  {
    return get(Http2Headers.PseudoHeaderName.STATUS.value());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(ReadOnlyHttp2Headers.class.getSimpleName());
    localStringBuilder.append('[');
    Iterator localIterator = iterator();
    for (String str = ""; localIterator.hasNext(); str = ", ")
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append((CharSequence)localEntry.getKey());
      localStringBuilder.append(": ");
      localStringBuilder.append((CharSequence)localEntry.getValue());
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public Iterator<CharSequence> valueIterator(CharSequence paramCharSequence)
  {
    return new ReadOnlyValueIterator(paramCharSequence);
  }
  
  private final class ReadOnlyIterator
    implements Map.Entry<CharSequence, CharSequence>, Iterator<Map.Entry<CharSequence, CharSequence>>
  {
    private AsciiString[] current;
    private int i;
    private AsciiString key;
    private AsciiString value;
    
    private ReadOnlyIterator()
    {
      if (ReadOnlyHttp2Headers.this.pseudoHeaders.length != 0) {
        this$1 = ReadOnlyHttp2Headers.this.pseudoHeaders;
      } else {
        this$1 = ReadOnlyHttp2Headers.this.otherHeaders;
      }
      this.current = ReadOnlyHttp2Headers.this;
    }
    
    public CharSequence getKey()
    {
      return this.key;
    }
    
    public CharSequence getValue()
    {
      return this.value;
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.i != this.current.length) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Map.Entry<CharSequence, CharSequence> next()
    {
      if (hasNext())
      {
        AsciiString[] arrayOfAsciiString = this.current;
        int j = this.i;
        this.key = arrayOfAsciiString[j];
        this.value = arrayOfAsciiString[(j + 1)];
        j += 2;
        this.i = j;
        if ((j == arrayOfAsciiString.length) && (arrayOfAsciiString == ReadOnlyHttp2Headers.this.pseudoHeaders))
        {
          this.current = ReadOnlyHttp2Headers.this.otherHeaders;
          this.i = 0;
        }
        return this;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("read only");
    }
    
    public CharSequence setValue(CharSequence paramCharSequence)
    {
      throw new UnsupportedOperationException("read only");
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.key.toString());
      localStringBuilder.append('=');
      localStringBuilder.append(this.value.toString());
      return localStringBuilder.toString();
    }
  }
  
  private final class ReadOnlyValueIterator
    implements Iterator<CharSequence>
  {
    private AsciiString[] current;
    private int i;
    private final CharSequence name;
    private final int nameHash;
    private AsciiString next;
    
    ReadOnlyValueIterator(CharSequence paramCharSequence)
    {
      if (ReadOnlyHttp2Headers.this.pseudoHeaders.length != 0) {
        this$1 = ReadOnlyHttp2Headers.this.pseudoHeaders;
      } else {
        this$1 = ReadOnlyHttp2Headers.this.otherHeaders;
      }
      this.current = ReadOnlyHttp2Headers.this;
      this.nameHash = AsciiString.hashCode(paramCharSequence);
      this.name = paramCharSequence;
      calculateNext();
    }
    
    private void calculateNext()
    {
      int j;
      Object localObject;
      for (;;)
      {
        j = this.i;
        localObject = this.current;
        if (j >= localObject.length) {
          break;
        }
        localObject = localObject[j];
        if ((((AsciiString)localObject).hashCode() == this.nameHash) && (((AsciiString)localObject).contentEqualsIgnoreCase(this.name)))
        {
          localObject = this.current;
          j = this.i;
          this.next = localObject[(j + 1)];
          this.i = (j + 2);
          return;
        }
        this.i += 2;
      }
      if ((j >= localObject.length) && (localObject == ReadOnlyHttp2Headers.this.pseudoHeaders))
      {
        this.i = 0;
        this.current = ReadOnlyHttp2Headers.this.otherHeaders;
        calculateNext();
      }
      else
      {
        this.next = null;
      }
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.next != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public CharSequence next()
    {
      if (hasNext())
      {
        AsciiString localAsciiString = this.next;
        calculateNext();
        return localAsciiString;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("read only");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\ReadOnlyHttp2Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */