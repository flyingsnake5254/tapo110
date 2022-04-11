package com.google.common.collect;

import com.google.common.base.n;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>>
  extends a<K, V>
{
  private static final long serialVersionUID = 0L;
  private transient Class<K> keyType;
  private transient Class<V> valueType;
  
  private EnumBiMap(Class<K> paramClass, Class<V> paramClass1)
  {
    super(new EnumMap(paramClass), new EnumMap(paramClass1));
    this.keyType = paramClass;
    this.valueType = paramClass1;
  }
  
  public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> paramClass, Class<V> paramClass1)
  {
    return new EnumBiMap(paramClass, paramClass1);
  }
  
  public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> paramMap)
  {
    EnumBiMap localEnumBiMap = create(inferKeyType(paramMap), inferValueType(paramMap));
    localEnumBiMap.putAll(paramMap);
    return localEnumBiMap;
  }
  
  static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> paramMap)
  {
    if ((paramMap instanceof EnumBiMap)) {
      return ((EnumBiMap)paramMap).keyType();
    }
    if ((paramMap instanceof EnumHashBiMap)) {
      return ((EnumHashBiMap)paramMap).keyType();
    }
    n.d(paramMap.isEmpty() ^ true);
    return ((Enum)paramMap.keySet().iterator().next()).getDeclaringClass();
  }
  
  private static <V extends Enum<V>> Class<V> inferValueType(Map<?, V> paramMap)
  {
    if ((paramMap instanceof EnumBiMap)) {
      return ((EnumBiMap)paramMap).valueType;
    }
    n.d(paramMap.isEmpty() ^ true);
    return ((Enum)paramMap.values().iterator().next()).getDeclaringClass();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.keyType = ((Class)paramObjectInputStream.readObject());
    this.valueType = ((Class)paramObjectInputStream.readObject());
    setDelegates(new EnumMap(this.keyType), new EnumMap(this.valueType));
    r2.b(this, paramObjectInputStream);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.keyType);
    paramObjectOutputStream.writeObject(this.valueType);
    r2.i(this, paramObjectOutputStream);
  }
  
  K checkKey(K paramK)
  {
    return (Enum)n.o(paramK);
  }
  
  V checkValue(V paramV)
  {
    return (Enum)n.o(paramV);
  }
  
  public Class<K> keyType()
  {
    return this.keyType;
  }
  
  public Class<V> valueType()
  {
    return this.valueType;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\EnumBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */