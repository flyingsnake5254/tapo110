package com.google.common.collect;

import com.google.common.base.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class EnumHashBiMap<K extends Enum<K>, V>
  extends a<K, V>
{
  private static final long serialVersionUID = 0L;
  private transient Class<K> keyType;
  
  private EnumHashBiMap(Class<K> paramClass)
  {
    super(new EnumMap(paramClass), q1.p(((Enum[])paramClass.getEnumConstants()).length));
    this.keyType = paramClass;
  }
  
  public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> paramClass)
  {
    return new EnumHashBiMap(paramClass);
  }
  
  public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> paramMap)
  {
    EnumHashBiMap localEnumHashBiMap = create(EnumBiMap.inferKeyType(paramMap));
    localEnumHashBiMap.putAll(paramMap);
    return localEnumHashBiMap;
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.keyType = ((Class)paramObjectInputStream.readObject());
    setDelegates(new EnumMap(this.keyType), new HashMap(((Enum[])this.keyType.getEnumConstants()).length * 3 / 2));
    r2.b(this, paramObjectInputStream);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.keyType);
    r2.i(this, paramObjectOutputStream);
  }
  
  K checkKey(K paramK)
  {
    return (Enum)n.o(paramK);
  }
  
  @CanIgnoreReturnValue
  public V forcePut(K paramK, @NullableDecl V paramV)
  {
    return (V)super.forcePut(paramK, paramV);
  }
  
  public Class<K> keyType()
  {
    return this.keyType;
  }
  
  @CanIgnoreReturnValue
  public V put(K paramK, @NullableDecl V paramV)
  {
    return (V)super.put(paramK, paramV);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\EnumHashBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */