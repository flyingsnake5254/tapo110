package com.google.common.collect;

import com.google.common.base.t;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class HashBasedTable<R, C, V>
  extends e3<R, C, V>
{
  private static final long serialVersionUID = 0L;
  
  HashBasedTable(Map<R, Map<C, V>> paramMap, a<C, V> parama)
  {
    super(paramMap, parama);
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create()
  {
    return new HashBasedTable(new LinkedHashMap(), new a(0));
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create(int paramInt1, int paramInt2)
  {
    v.b(paramInt2, "expectedCellsPerRow");
    return new HashBasedTable(q1.s(paramInt1), new a(paramInt2));
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create(f3<? extends R, ? extends C, ? extends V> paramf3)
  {
    HashBasedTable localHashBasedTable = create();
    localHashBasedTable.putAll(paramf3);
    return localHashBasedTable;
  }
  
  public boolean contains(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    return super.contains(paramObject1, paramObject2);
  }
  
  public boolean containsColumn(@NullableDecl Object paramObject)
  {
    return super.containsColumn(paramObject);
  }
  
  public boolean containsRow(@NullableDecl Object paramObject)
  {
    return super.containsRow(paramObject);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject)
  {
    return super.containsValue(paramObject);
  }
  
  public boolean equals(@NullableDecl Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public V get(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    return (V)super.get(paramObject1, paramObject2);
  }
  
  @CanIgnoreReturnValue
  public V remove(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2)
  {
    return (V)super.remove(paramObject1, paramObject2);
  }
  
  private static class a<C, V>
    implements t<Map<C, V>>, Serializable
  {
    final int c;
    
    a(int paramInt)
    {
      this.c = paramInt;
    }
    
    public Map<C, V> a()
    {
      return q1.s(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\HashBasedTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */