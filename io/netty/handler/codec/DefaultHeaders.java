package io.netty.handler.codec;

import io.netty.util.HashingStrategy;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public class DefaultHeaders<K, V, T extends Headers<K, V, T>>
  implements Headers<K, V, T>
{
  static final int HASH_CODE_SEED = -1028477387;
  private final HeaderEntry<K, V>[] entries;
  private final byte hashMask;
  private final HashingStrategy<K> hashingStrategy;
  protected final HeaderEntry<K, V> head;
  private final NameValidator<K> nameValidator;
  int size;
  private final ValueConverter<V> valueConverter;
  
  public DefaultHeaders(ValueConverter<V> paramValueConverter)
  {
    this(HashingStrategy.JAVA_HASHER, paramValueConverter);
  }
  
  public DefaultHeaders(ValueConverter<V> paramValueConverter, NameValidator<K> paramNameValidator)
  {
    this(HashingStrategy.JAVA_HASHER, paramValueConverter, paramNameValidator);
  }
  
  public DefaultHeaders(HashingStrategy<K> paramHashingStrategy, ValueConverter<V> paramValueConverter)
  {
    this(paramHashingStrategy, paramValueConverter, NameValidator.NOT_NULL);
  }
  
  public DefaultHeaders(HashingStrategy<K> paramHashingStrategy, ValueConverter<V> paramValueConverter, NameValidator<K> paramNameValidator)
  {
    this(paramHashingStrategy, paramValueConverter, paramNameValidator, 16);
  }
  
  public DefaultHeaders(HashingStrategy<K> paramHashingStrategy, ValueConverter<V> paramValueConverter, NameValidator<K> paramNameValidator, int paramInt)
  {
    this.valueConverter = ((ValueConverter)ObjectUtil.checkNotNull(paramValueConverter, "valueConverter"));
    this.nameValidator = ((NameValidator)ObjectUtil.checkNotNull(paramNameValidator, "nameValidator"));
    this.hashingStrategy = ((HashingStrategy)ObjectUtil.checkNotNull(paramHashingStrategy, "nameHashingStrategy"));
    paramHashingStrategy = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(paramInt, 128)))];
    this.entries = paramHashingStrategy;
    this.hashMask = ((byte)(byte)(paramHashingStrategy.length - 1));
    this.head = new HeaderEntry();
  }
  
  private void add0(int paramInt1, int paramInt2, K paramK, V paramV)
  {
    HeaderEntry[] arrayOfHeaderEntry = this.entries;
    arrayOfHeaderEntry[paramInt2] = newHeaderEntry(paramInt1, paramK, paramV, arrayOfHeaderEntry[paramInt2]);
    this.size += 1;
  }
  
  private int index(int paramInt)
  {
    return paramInt & this.hashMask;
  }
  
  private HeaderEntry<K, V> remove0(HeaderEntry<K, V> paramHeaderEntry1, HeaderEntry<K, V> paramHeaderEntry2)
  {
    int i = index(paramHeaderEntry1.hash);
    HeaderEntry[] arrayOfHeaderEntry = this.entries;
    if (arrayOfHeaderEntry[i] == paramHeaderEntry1)
    {
      arrayOfHeaderEntry[i] = paramHeaderEntry1.next;
      paramHeaderEntry2 = arrayOfHeaderEntry[i];
    }
    else
    {
      paramHeaderEntry2.next = paramHeaderEntry1.next;
    }
    paramHeaderEntry1.remove();
    this.size -= 1;
    return paramHeaderEntry2;
  }
  
  private V remove0(int paramInt1, int paramInt2, K paramK)
  {
    Object localObject1 = this.entries[paramInt2];
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    for (Object localObject3 = ((HeaderEntry)localObject1).next; localObject3 != null; localObject3 = ((HeaderEntry)localObject1).next) {
      if ((((HeaderEntry)localObject3).hash == paramInt1) && (this.hashingStrategy.equals(paramK, ((HeaderEntry)localObject3).key)))
      {
        localObject2 = ((HeaderEntry)localObject3).value;
        ((HeaderEntry)localObject1).next = ((HeaderEntry)localObject3).next;
        ((HeaderEntry)localObject3).remove();
        this.size -= 1;
      }
      else
      {
        localObject1 = localObject3;
      }
    }
    localObject1 = this.entries[paramInt2];
    localObject3 = localObject2;
    if (((HeaderEntry)localObject1).hash == paramInt1)
    {
      localObject3 = localObject2;
      if (this.hashingStrategy.equals(paramK, ((HeaderEntry)localObject1).key))
      {
        paramK = (K)localObject2;
        if (localObject2 == null) {
          paramK = ((HeaderEntry)localObject1).value;
        }
        this.entries[paramInt2] = ((HeaderEntry)localObject1).next;
        ((HeaderEntry)localObject1).remove();
        this.size -= 1;
        localObject3 = paramK;
      }
    }
    return (V)localObject3;
  }
  
  private T thisT()
  {
    return this;
  }
  
  public T add(Headers<? extends K, ? extends V, ?> paramHeaders)
  {
    if (paramHeaders != this)
    {
      addImpl(paramHeaders);
      return thisT();
    }
    throw new IllegalArgumentException("can't add to itself.");
  }
  
  public T add(K paramK, Iterable<? extends V> paramIterable)
  {
    this.nameValidator.validateName(paramK);
    int i = this.hashingStrategy.hashCode(paramK);
    int j = index(i);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      add0(i, j, paramK, paramIterable.next());
    }
    return thisT();
  }
  
  public T add(K paramK, V paramV)
  {
    this.nameValidator.validateName(paramK);
    ObjectUtil.checkNotNull(paramV, "value");
    int i = this.hashingStrategy.hashCode(paramK);
    add0(i, index(i), paramK, paramV);
    return thisT();
  }
  
  public T add(K paramK, V... paramVarArgs)
  {
    this.nameValidator.validateName(paramK);
    int i = this.hashingStrategy.hashCode(paramK);
    int j = index(i);
    int k = paramVarArgs.length;
    for (int m = 0; m < k; m++) {
      add0(i, j, paramK, paramVarArgs[m]);
    }
    return thisT();
  }
  
  public T addBoolean(K paramK, boolean paramBoolean)
  {
    return add(paramK, this.valueConverter.convertBoolean(paramBoolean));
  }
  
  public T addByte(K paramK, byte paramByte)
  {
    return add(paramK, this.valueConverter.convertByte(paramByte));
  }
  
  public T addChar(K paramK, char paramChar)
  {
    return add(paramK, this.valueConverter.convertChar(paramChar));
  }
  
  public T addDouble(K paramK, double paramDouble)
  {
    return add(paramK, this.valueConverter.convertDouble(paramDouble));
  }
  
  public T addFloat(K paramK, float paramFloat)
  {
    return add(paramK, this.valueConverter.convertFloat(paramFloat));
  }
  
  protected void addImpl(Headers<? extends K, ? extends V, ?> paramHeaders)
  {
    if ((paramHeaders instanceof DefaultHeaders))
    {
      DefaultHeaders localDefaultHeaders = (DefaultHeaders)paramHeaders;
      paramHeaders = localDefaultHeaders.head.after;
      localObject = paramHeaders;
      if (localDefaultHeaders.hashingStrategy == this.hashingStrategy)
      {
        localObject = paramHeaders;
        if (localDefaultHeaders.nameValidator == this.nameValidator) {
          while (paramHeaders != localDefaultHeaders.head)
          {
            int i = paramHeaders.hash;
            add0(i, index(i), paramHeaders.key, paramHeaders.value);
            paramHeaders = paramHeaders.after;
          }
        }
      }
      while (localObject != localDefaultHeaders.head)
      {
        add(((HeaderEntry)localObject).key, ((HeaderEntry)localObject).value);
        localObject = ((HeaderEntry)localObject).after;
      }
    }
    Object localObject = paramHeaders.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramHeaders = (Map.Entry)((Iterator)localObject).next();
      add(paramHeaders.getKey(), paramHeaders.getValue());
    }
  }
  
  public T addInt(K paramK, int paramInt)
  {
    return add(paramK, this.valueConverter.convertInt(paramInt));
  }
  
  public T addLong(K paramK, long paramLong)
  {
    return add(paramK, this.valueConverter.convertLong(paramLong));
  }
  
  public T addObject(K paramK, Iterable<?> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      addObject(paramK, paramIterable.next());
    }
    return thisT();
  }
  
  public T addObject(K paramK, Object paramObject)
  {
    return add(paramK, this.valueConverter.convertObject(ObjectUtil.checkNotNull(paramObject, "value")));
  }
  
  public T addObject(K paramK, Object... paramVarArgs)
  {
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      addObject(paramK, paramVarArgs[j]);
    }
    return thisT();
  }
  
  public T addShort(K paramK, short paramShort)
  {
    return add(paramK, this.valueConverter.convertShort(paramShort));
  }
  
  public T addTimeMillis(K paramK, long paramLong)
  {
    return add(paramK, this.valueConverter.convertTimeMillis(paramLong));
  }
  
  public T clear()
  {
    Arrays.fill(this.entries, null);
    HeaderEntry localHeaderEntry = this.head;
    localHeaderEntry.after = localHeaderEntry;
    localHeaderEntry.before = localHeaderEntry;
    this.size = 0;
    return thisT();
  }
  
  public boolean contains(K paramK)
  {
    boolean bool;
    if (get(paramK) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean contains(K paramK, V paramV)
  {
    return contains(paramK, paramV, HashingStrategy.JAVA_HASHER);
  }
  
  public final boolean contains(K paramK, V paramV, HashingStrategy<? super V> paramHashingStrategy)
  {
    ObjectUtil.checkNotNull(paramK, "name");
    int i = this.hashingStrategy.hashCode(paramK);
    int j = index(i);
    for (HeaderEntry localHeaderEntry = this.entries[j]; localHeaderEntry != null; localHeaderEntry = localHeaderEntry.next) {
      if ((localHeaderEntry.hash == i) && (this.hashingStrategy.equals(paramK, localHeaderEntry.key)) && (paramHashingStrategy.equals(paramV, localHeaderEntry.value))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsBoolean(K paramK, boolean paramBoolean)
  {
    return contains(paramK, this.valueConverter.convertBoolean(paramBoolean));
  }
  
  public boolean containsByte(K paramK, byte paramByte)
  {
    return contains(paramK, this.valueConverter.convertByte(paramByte));
  }
  
  public boolean containsChar(K paramK, char paramChar)
  {
    return contains(paramK, this.valueConverter.convertChar(paramChar));
  }
  
  public boolean containsDouble(K paramK, double paramDouble)
  {
    return contains(paramK, this.valueConverter.convertDouble(paramDouble));
  }
  
  public boolean containsFloat(K paramK, float paramFloat)
  {
    return contains(paramK, this.valueConverter.convertFloat(paramFloat));
  }
  
  public boolean containsInt(K paramK, int paramInt)
  {
    return contains(paramK, this.valueConverter.convertInt(paramInt));
  }
  
  public boolean containsLong(K paramK, long paramLong)
  {
    return contains(paramK, this.valueConverter.convertLong(paramLong));
  }
  
  public boolean containsObject(K paramK, Object paramObject)
  {
    return contains(paramK, this.valueConverter.convertObject(ObjectUtil.checkNotNull(paramObject, "value")));
  }
  
  public boolean containsShort(K paramK, short paramShort)
  {
    return contains(paramK, this.valueConverter.convertShort(paramShort));
  }
  
  public boolean containsTimeMillis(K paramK, long paramLong)
  {
    return contains(paramK, this.valueConverter.convertTimeMillis(paramLong));
  }
  
  public DefaultHeaders<K, V, T> copy()
  {
    DefaultHeaders localDefaultHeaders = new DefaultHeaders(this.hashingStrategy, this.valueConverter, this.nameValidator, this.entries.length);
    localDefaultHeaders.addImpl(this);
    return localDefaultHeaders;
  }
  
  public final boolean equals(Headers<K, V, ?> paramHeaders, HashingStrategy<V> paramHashingStrategy)
  {
    if (paramHeaders.size() != size()) {
      return false;
    }
    if (this == paramHeaders) {
      return true;
    }
    Iterator localIterator = names().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      List localList = paramHeaders.getAll(localObject);
      localObject = getAll(localObject);
      if (localList.size() != ((List)localObject).size()) {
        return false;
      }
      for (int i = 0; i < localList.size(); i++) {
        if (!paramHashingStrategy.equals(localList.get(i), ((List)localObject).get(i))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Headers)) {
      return false;
    }
    return equals((Headers)paramObject, HashingStrategy.JAVA_HASHER);
  }
  
  public V get(K paramK)
  {
    ObjectUtil.checkNotNull(paramK, "name");
    int i = this.hashingStrategy.hashCode(paramK);
    int j = index(i);
    HeaderEntry localHeaderEntry = this.entries[j];
    Object localObject2;
    for (Object localObject1 = null; localHeaderEntry != null; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (localHeaderEntry.hash == i)
      {
        localObject2 = localObject1;
        if (this.hashingStrategy.equals(paramK, localHeaderEntry.key)) {
          localObject2 = localHeaderEntry.value;
        }
      }
      localHeaderEntry = localHeaderEntry.next;
    }
    return (V)localObject1;
  }
  
  public V get(K paramK, V paramV)
  {
    paramK = get(paramK);
    if (paramK == null) {
      return paramV;
    }
    return paramK;
  }
  
  public List<V> getAll(K paramK)
  {
    ObjectUtil.checkNotNull(paramK, "name");
    LinkedList localLinkedList = new LinkedList();
    int i = this.hashingStrategy.hashCode(paramK);
    int j = index(i);
    for (HeaderEntry localHeaderEntry = this.entries[j]; localHeaderEntry != null; localHeaderEntry = localHeaderEntry.next) {
      if ((localHeaderEntry.hash == i) && (this.hashingStrategy.equals(paramK, localHeaderEntry.key))) {
        localLinkedList.addFirst(localHeaderEntry.getValue());
      }
    }
    return localLinkedList;
  }
  
  public List<V> getAllAndRemove(K paramK)
  {
    List localList = getAll(paramK);
    remove(paramK);
    return localList;
  }
  
  public V getAndRemove(K paramK)
  {
    int i = this.hashingStrategy.hashCode(paramK);
    return (V)remove0(i, index(i), ObjectUtil.checkNotNull(paramK, "name"));
  }
  
  public V getAndRemove(K paramK, V paramV)
  {
    paramK = getAndRemove(paramK);
    if (paramK == null) {
      return paramV;
    }
    return paramK;
  }
  
  public Boolean getBoolean(K paramK)
  {
    Object localObject1 = get(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Boolean.valueOf(this.valueConverter.convertToBoolean(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public boolean getBoolean(K paramK, boolean paramBoolean)
  {
    paramK = getBoolean(paramK);
    if (paramK != null) {
      paramBoolean = paramK.booleanValue();
    }
    return paramBoolean;
  }
  
  public Boolean getBooleanAndRemove(K paramK)
  {
    Object localObject1 = getAndRemove(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Boolean.valueOf(this.valueConverter.convertToBoolean(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public boolean getBooleanAndRemove(K paramK, boolean paramBoolean)
  {
    paramK = getBooleanAndRemove(paramK);
    if (paramK != null) {
      paramBoolean = paramK.booleanValue();
    }
    return paramBoolean;
  }
  
  public byte getByte(K paramK, byte paramByte)
  {
    paramK = getByte(paramK);
    byte b = paramByte;
    if (paramK != null)
    {
      paramByte = paramK.byteValue();
      b = paramByte;
    }
    return b;
  }
  
  public Byte getByte(K paramK)
  {
    Object localObject1 = get(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Byte.valueOf(this.valueConverter.convertToByte(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public byte getByteAndRemove(K paramK, byte paramByte)
  {
    paramK = getByteAndRemove(paramK);
    byte b = paramByte;
    if (paramK != null)
    {
      paramByte = paramK.byteValue();
      b = paramByte;
    }
    return b;
  }
  
  public Byte getByteAndRemove(K paramK)
  {
    Object localObject1 = getAndRemove(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Byte.valueOf(this.valueConverter.convertToByte(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public char getChar(K paramK, char paramChar)
  {
    paramK = getChar(paramK);
    char c = paramChar;
    if (paramK != null)
    {
      paramChar = paramK.charValue();
      c = paramChar;
    }
    return c;
  }
  
  public Character getChar(K paramK)
  {
    Object localObject1 = get(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Character.valueOf(this.valueConverter.convertToChar(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public char getCharAndRemove(K paramK, char paramChar)
  {
    paramK = getCharAndRemove(paramK);
    char c = paramChar;
    if (paramK != null)
    {
      paramChar = paramK.charValue();
      c = paramChar;
    }
    return c;
  }
  
  public Character getCharAndRemove(K paramK)
  {
    Object localObject1 = getAndRemove(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Character.valueOf(this.valueConverter.convertToChar(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public double getDouble(K paramK, double paramDouble)
  {
    paramK = getDouble(paramK);
    if (paramK != null) {
      paramDouble = paramK.doubleValue();
    }
    return paramDouble;
  }
  
  public Double getDouble(K paramK)
  {
    Object localObject1 = get(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Double.valueOf(this.valueConverter.convertToDouble(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public double getDoubleAndRemove(K paramK, double paramDouble)
  {
    paramK = getDoubleAndRemove(paramK);
    if (paramK != null) {
      paramDouble = paramK.doubleValue();
    }
    return paramDouble;
  }
  
  public Double getDoubleAndRemove(K paramK)
  {
    Object localObject1 = getAndRemove(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Double.valueOf(this.valueConverter.convertToDouble(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public float getFloat(K paramK, float paramFloat)
  {
    paramK = getFloat(paramK);
    if (paramK != null) {
      paramFloat = paramK.floatValue();
    }
    return paramFloat;
  }
  
  public Float getFloat(K paramK)
  {
    Object localObject1 = get(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Float.valueOf(this.valueConverter.convertToFloat(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public float getFloatAndRemove(K paramK, float paramFloat)
  {
    paramK = getFloatAndRemove(paramK);
    if (paramK != null) {
      paramFloat = paramK.floatValue();
    }
    return paramFloat;
  }
  
  public Float getFloatAndRemove(K paramK)
  {
    Object localObject1 = getAndRemove(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Float.valueOf(this.valueConverter.convertToFloat(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public int getInt(K paramK, int paramInt)
  {
    paramK = getInt(paramK);
    if (paramK != null) {
      paramInt = paramK.intValue();
    }
    return paramInt;
  }
  
  public Integer getInt(K paramK)
  {
    Object localObject1 = get(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Integer.valueOf(this.valueConverter.convertToInt(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public int getIntAndRemove(K paramK, int paramInt)
  {
    paramK = getIntAndRemove(paramK);
    if (paramK != null) {
      paramInt = paramK.intValue();
    }
    return paramInt;
  }
  
  public Integer getIntAndRemove(K paramK)
  {
    Object localObject1 = getAndRemove(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Integer.valueOf(this.valueConverter.convertToInt(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public long getLong(K paramK, long paramLong)
  {
    paramK = getLong(paramK);
    if (paramK != null) {
      paramLong = paramK.longValue();
    }
    return paramLong;
  }
  
  public Long getLong(K paramK)
  {
    Object localObject1 = get(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Long.valueOf(this.valueConverter.convertToLong(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public long getLongAndRemove(K paramK, long paramLong)
  {
    paramK = getLongAndRemove(paramK);
    if (paramK != null) {
      paramLong = paramK.longValue();
    }
    return paramLong;
  }
  
  public Long getLongAndRemove(K paramK)
  {
    Object localObject1 = getAndRemove(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Long.valueOf(this.valueConverter.convertToLong(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public Short getShort(K paramK)
  {
    Object localObject1 = get(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Short.valueOf(this.valueConverter.convertToShort(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public short getShort(K paramK, short paramShort)
  {
    paramK = getShort(paramK);
    short s = paramShort;
    if (paramK != null)
    {
      paramShort = paramK.shortValue();
      s = paramShort;
    }
    return s;
  }
  
  public Short getShortAndRemove(K paramK)
  {
    Object localObject1 = getAndRemove(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Short.valueOf(this.valueConverter.convertToShort(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public short getShortAndRemove(K paramK, short paramShort)
  {
    paramK = getShortAndRemove(paramK);
    short s = paramShort;
    if (paramK != null)
    {
      paramShort = paramK.shortValue();
      s = paramShort;
    }
    return s;
  }
  
  public long getTimeMillis(K paramK, long paramLong)
  {
    paramK = getTimeMillis(paramK);
    if (paramK != null) {
      paramLong = paramK.longValue();
    }
    return paramLong;
  }
  
  public Long getTimeMillis(K paramK)
  {
    Object localObject1 = get(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Long.valueOf(this.valueConverter.convertToTimeMillis(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public long getTimeMillisAndRemove(K paramK, long paramLong)
  {
    paramK = getTimeMillisAndRemove(paramK);
    if (paramK != null) {
      paramLong = paramK.longValue();
    }
    return paramLong;
  }
  
  public Long getTimeMillisAndRemove(K paramK)
  {
    Object localObject1 = getAndRemove(paramK);
    Object localObject2 = null;
    paramK = (K)localObject2;
    if (localObject1 != null) {}
    try
    {
      paramK = Long.valueOf(this.valueConverter.convertToTimeMillis(localObject1));
      return paramK;
    }
    catch (RuntimeException paramK)
    {
      for (;;)
      {
        paramK = (K)localObject2;
      }
    }
  }
  
  public int hashCode()
  {
    return hashCode(HashingStrategy.JAVA_HASHER);
  }
  
  public final int hashCode(HashingStrategy<V> paramHashingStrategy)
  {
    Iterator localIterator = names().iterator();
    int i = -1028477387;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      int j = i * 31 + this.hashingStrategy.hashCode(localObject);
      localObject = getAll(localObject);
      for (int k = 0;; k++)
      {
        i = j;
        if (k >= ((List)localObject).size()) {
          break;
        }
        j = j * 31 + paramHashingStrategy.hashCode(((List)localObject).get(k));
      }
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    HeaderEntry localHeaderEntry = this.head;
    boolean bool;
    if (localHeaderEntry == localHeaderEntry.after) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return new HeaderIterator(null);
  }
  
  public Set<K> names()
  {
    if (isEmpty()) {
      return Collections.emptySet();
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(size());
    for (HeaderEntry localHeaderEntry = this.head.after; localHeaderEntry != this.head; localHeaderEntry = localHeaderEntry.after) {
      localLinkedHashSet.add(localHeaderEntry.getKey());
    }
    return localLinkedHashSet;
  }
  
  protected HeaderEntry<K, V> newHeaderEntry(int paramInt, K paramK, V paramV, HeaderEntry<K, V> paramHeaderEntry)
  {
    return new HeaderEntry(paramInt, paramK, paramV, paramHeaderEntry, this.head);
  }
  
  public boolean remove(K paramK)
  {
    boolean bool;
    if (getAndRemove(paramK) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public T set(Headers<? extends K, ? extends V, ?> paramHeaders)
  {
    if (paramHeaders != this)
    {
      clear();
      addImpl(paramHeaders);
    }
    return thisT();
  }
  
  public T set(K paramK, Iterable<? extends V> paramIterable)
  {
    this.nameValidator.validateName(paramK);
    ObjectUtil.checkNotNull(paramIterable, "values");
    int i = this.hashingStrategy.hashCode(paramK);
    int j = index(i);
    remove0(i, j, paramK);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (localObject == null) {
        break;
      }
      add0(i, j, paramK, localObject);
    }
    return thisT();
  }
  
  public T set(K paramK, V paramV)
  {
    this.nameValidator.validateName(paramK);
    ObjectUtil.checkNotNull(paramV, "value");
    int i = this.hashingStrategy.hashCode(paramK);
    int j = index(i);
    remove0(i, j, paramK);
    add0(i, j, paramK, paramV);
    return thisT();
  }
  
  public T set(K paramK, V... paramVarArgs)
  {
    this.nameValidator.validateName(paramK);
    ObjectUtil.checkNotNull(paramVarArgs, "values");
    int i = this.hashingStrategy.hashCode(paramK);
    int j = index(i);
    remove0(i, j, paramK);
    int k = paramVarArgs.length;
    for (int m = 0; m < k; m++)
    {
      V ? = paramVarArgs[m];
      if (? == null) {
        break;
      }
      add0(i, j, paramK, ?);
    }
    return thisT();
  }
  
  public T setAll(Headers<? extends K, ? extends V, ?> paramHeaders)
  {
    if (paramHeaders != this)
    {
      Iterator localIterator = paramHeaders.names().iterator();
      while (localIterator.hasNext()) {
        remove(localIterator.next());
      }
      addImpl(paramHeaders);
    }
    return thisT();
  }
  
  public T setBoolean(K paramK, boolean paramBoolean)
  {
    return set(paramK, this.valueConverter.convertBoolean(paramBoolean));
  }
  
  public T setByte(K paramK, byte paramByte)
  {
    return set(paramK, this.valueConverter.convertByte(paramByte));
  }
  
  public T setChar(K paramK, char paramChar)
  {
    return set(paramK, this.valueConverter.convertChar(paramChar));
  }
  
  public T setDouble(K paramK, double paramDouble)
  {
    return set(paramK, this.valueConverter.convertDouble(paramDouble));
  }
  
  public T setFloat(K paramK, float paramFloat)
  {
    return set(paramK, this.valueConverter.convertFloat(paramFloat));
  }
  
  public T setInt(K paramK, int paramInt)
  {
    return set(paramK, this.valueConverter.convertInt(paramInt));
  }
  
  public T setLong(K paramK, long paramLong)
  {
    return set(paramK, this.valueConverter.convertLong(paramLong));
  }
  
  public T setObject(K paramK, Iterable<?> paramIterable)
  {
    this.nameValidator.validateName(paramK);
    int i = this.hashingStrategy.hashCode(paramK);
    int j = index(i);
    remove0(i, j, paramK);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (localObject == null) {
        break;
      }
      add0(i, j, paramK, this.valueConverter.convertObject(localObject));
    }
    return thisT();
  }
  
  public T setObject(K paramK, Object paramObject)
  {
    ObjectUtil.checkNotNull(paramObject, "value");
    return set(paramK, ObjectUtil.checkNotNull(this.valueConverter.convertObject(paramObject), "convertedValue"));
  }
  
  public T setObject(K paramK, Object... paramVarArgs)
  {
    this.nameValidator.validateName(paramK);
    int i = this.hashingStrategy.hashCode(paramK);
    int j = index(i);
    remove0(i, j, paramK);
    int k = paramVarArgs.length;
    for (int m = 0; m < k; m++)
    {
      Object localObject = paramVarArgs[m];
      if (localObject == null) {
        break;
      }
      add0(i, j, paramK, this.valueConverter.convertObject(localObject));
    }
    return thisT();
  }
  
  public T setShort(K paramK, short paramShort)
  {
    return set(paramK, this.valueConverter.convertShort(paramShort));
  }
  
  public T setTimeMillis(K paramK, long paramLong)
  {
    return set(paramK, this.valueConverter.convertTimeMillis(paramLong));
  }
  
  public int size()
  {
    return this.size;
  }
  
  public String toString()
  {
    return HeadersUtils.toString(getClass(), iterator(), size());
  }
  
  protected ValueConverter<V> valueConverter()
  {
    return this.valueConverter;
  }
  
  public Iterator<V> valueIterator(K paramK)
  {
    return new ValueIterator(paramK);
  }
  
  protected static class HeaderEntry<K, V>
    implements Map.Entry<K, V>
  {
    protected HeaderEntry<K, V> after;
    protected HeaderEntry<K, V> before;
    protected final int hash;
    protected final K key;
    protected HeaderEntry<K, V> next;
    protected V value;
    
    HeaderEntry()
    {
      this.hash = -1;
      this.key = null;
      this.after = this;
      this.before = this;
    }
    
    protected HeaderEntry(int paramInt, K paramK)
    {
      this.hash = paramInt;
      this.key = paramK;
    }
    
    HeaderEntry(int paramInt, K paramK, V paramV, HeaderEntry<K, V> paramHeaderEntry1, HeaderEntry<K, V> paramHeaderEntry2)
    {
      this.hash = paramInt;
      this.key = paramK;
      this.value = paramV;
      this.next = paramHeaderEntry1;
      this.after = paramHeaderEntry2;
      this.before = paramHeaderEntry2.before;
      pointNeighborsToThis();
    }
    
    public final HeaderEntry<K, V> after()
    {
      return this.after;
    }
    
    public final HeaderEntry<K, V> before()
    {
      return this.before;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof Map.Entry;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (Map.Entry)paramObject;
      if (getKey() == null)
      {
        bool1 = bool2;
        if (((Map.Entry)paramObject).getKey() != null) {
          return bool1;
        }
      }
      else
      {
        bool1 = bool2;
        if (!getKey().equals(((Map.Entry)paramObject).getKey())) {
          return bool1;
        }
      }
      if (getValue() == null)
      {
        bool1 = bool2;
        if (((Map.Entry)paramObject).getValue() != null) {
          return bool1;
        }
      }
      else
      {
        bool1 = bool2;
        if (!getValue().equals(((Map.Entry)paramObject).getValue())) {
          return bool1;
        }
      }
      bool1 = true;
      return bool1;
    }
    
    public final K getKey()
    {
      return (K)this.key;
    }
    
    public final V getValue()
    {
      return (V)this.value;
    }
    
    public int hashCode()
    {
      Object localObject = this.key;
      int i = 0;
      int j;
      if (localObject == null) {
        j = 0;
      } else {
        j = localObject.hashCode();
      }
      localObject = this.value;
      if (localObject != null) {
        i = localObject.hashCode();
      }
      return j ^ i;
    }
    
    protected final void pointNeighborsToThis()
    {
      this.before.after = this;
      this.after.before = this;
    }
    
    protected void remove()
    {
      HeaderEntry localHeaderEntry = this.before;
      localHeaderEntry.after = this.after;
      this.after.before = localHeaderEntry;
    }
    
    public final V setValue(V paramV)
    {
      ObjectUtil.checkNotNull(paramV, "value");
      Object localObject = this.value;
      this.value = paramV;
      return (V)localObject;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.key.toString());
      localStringBuilder.append('=');
      localStringBuilder.append(this.value.toString());
      return localStringBuilder.toString();
    }
  }
  
  private final class HeaderIterator
    implements Iterator<Map.Entry<K, V>>
  {
    private DefaultHeaders.HeaderEntry<K, V> current = DefaultHeaders.this.head;
    
    private HeaderIterator() {}
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.current.after != DefaultHeaders.this.head) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Map.Entry<K, V> next()
    {
      DefaultHeaders.HeaderEntry localHeaderEntry = this.current.after;
      this.current = localHeaderEntry;
      if (localHeaderEntry != DefaultHeaders.this.head) {
        return localHeaderEntry;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("read only");
    }
  }
  
  public static abstract interface NameValidator<K>
  {
    public static final NameValidator NOT_NULL = new NameValidator()
    {
      public void validateName(Object paramAnonymousObject)
      {
        ObjectUtil.checkNotNull(paramAnonymousObject, "name");
      }
    };
    
    public abstract void validateName(K paramK);
  }
  
  private final class ValueIterator
    implements Iterator<V>
  {
    private final int hash;
    private final K name;
    private DefaultHeaders.HeaderEntry<K, V> next;
    private DefaultHeaders.HeaderEntry<K, V> previous;
    private DefaultHeaders.HeaderEntry<K, V> removalPrevious;
    
    ValueIterator()
    {
      Object localObject;
      this.name = ObjectUtil.checkNotNull(localObject, "name");
      int i = DefaultHeaders.this.hashingStrategy.hashCode(localObject);
      this.hash = i;
      calculateNext(DefaultHeaders.this.entries[DefaultHeaders.this.index(i)]);
    }
    
    private void calculateNext(DefaultHeaders.HeaderEntry<K, V> paramHeaderEntry)
    {
      while (paramHeaderEntry != null)
      {
        if ((paramHeaderEntry.hash == this.hash) && (DefaultHeaders.this.hashingStrategy.equals(this.name, paramHeaderEntry.key)))
        {
          this.next = paramHeaderEntry;
          return;
        }
        paramHeaderEntry = paramHeaderEntry.next;
      }
      this.next = null;
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
    
    public V next()
    {
      if (hasNext())
      {
        DefaultHeaders.HeaderEntry localHeaderEntry = this.previous;
        if (localHeaderEntry != null) {
          this.removalPrevious = localHeaderEntry;
        }
        localHeaderEntry = this.next;
        this.previous = localHeaderEntry;
        calculateNext(localHeaderEntry.next);
        return (V)this.previous.value;
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      DefaultHeaders.HeaderEntry localHeaderEntry = this.previous;
      if (localHeaderEntry != null)
      {
        this.removalPrevious = DefaultHeaders.this.remove0(localHeaderEntry, this.removalPrevious);
        this.previous = null;
        return;
      }
      throw new IllegalStateException();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\DefaultHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */