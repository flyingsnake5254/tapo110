package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class TreeMultimap<K, V>
  extends n<K, V>
{
  private static final long serialVersionUID = 0L;
  private transient Comparator<? super K> keyComparator;
  private transient Comparator<? super V> valueComparator;
  
  TreeMultimap(Comparator<? super K> paramComparator, Comparator<? super V> paramComparator1)
  {
    super(new TreeMap(paramComparator));
    this.keyComparator = paramComparator;
    this.valueComparator = paramComparator1;
  }
  
  private TreeMultimap(Comparator<? super K> paramComparator, Comparator<? super V> paramComparator1, r1<? extends K, ? extends V> paramr1)
  {
    this(paramComparator, paramComparator1);
    putAll(paramr1);
  }
  
  public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create()
  {
    return new TreeMultimap(a2.g(), a2.g());
  }
  
  public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(r1<? extends K, ? extends V> paramr1)
  {
    return new TreeMultimap(a2.g(), a2.g(), paramr1);
  }
  
  public static <K, V> TreeMultimap<K, V> create(Comparator<? super K> paramComparator, Comparator<? super V> paramComparator1)
  {
    return new TreeMultimap((Comparator)com.google.common.base.n.o(paramComparator), (Comparator)com.google.common.base.n.o(paramComparator1));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.keyComparator = ((Comparator)com.google.common.base.n.o((Comparator)paramObjectInputStream.readObject()));
    this.valueComparator = ((Comparator)com.google.common.base.n.o((Comparator)paramObjectInputStream.readObject()));
    setMap(new TreeMap(this.keyComparator));
    r2.d(this, paramObjectInputStream);
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(keyComparator());
    paramObjectOutputStream.writeObject(valueComparator());
    r2.j(this, paramObjectOutputStream);
  }
  
  public NavigableMap<K, Collection<V>> asMap()
  {
    return (NavigableMap)super.asMap();
  }
  
  Map<K, Collection<V>> createAsMap()
  {
    return createMaybeNavigableAsMap();
  }
  
  Collection<V> createCollection(@NullableDecl K paramK)
  {
    if (paramK == null) {
      keyComparator().compare(paramK, paramK);
    }
    return super.createCollection(paramK);
  }
  
  SortedSet<V> createCollection()
  {
    return new TreeSet(this.valueComparator);
  }
  
  public NavigableSet<V> get(@NullableDecl K paramK)
  {
    return (NavigableSet)super.get(paramK);
  }
  
  @Deprecated
  public Comparator<? super K> keyComparator()
  {
    return this.keyComparator;
  }
  
  public NavigableSet<K> keySet()
  {
    return (NavigableSet)super.keySet();
  }
  
  public Comparator<? super V> valueComparator()
  {
    return this.valueComparator;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\TreeMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */