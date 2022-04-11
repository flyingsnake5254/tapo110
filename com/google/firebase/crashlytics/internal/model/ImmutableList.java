package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class ImmutableList<E>
  implements List<E>, RandomAccess
{
  private final List<E> immutableList;
  
  private ImmutableList(List<E> paramList)
  {
    this.immutableList = Collections.unmodifiableList(paramList);
  }
  
  @NonNull
  public static <E> ImmutableList<E> from(@NonNull List<E> paramList)
  {
    return new ImmutableList(paramList);
  }
  
  @NonNull
  public static <E> ImmutableList<E> from(E... paramVarArgs)
  {
    return new ImmutableList(Arrays.asList(paramVarArgs));
  }
  
  public void add(int paramInt, @NonNull E paramE)
  {
    this.immutableList.add(paramInt, paramE);
  }
  
  public boolean add(@NonNull E paramE)
  {
    return this.immutableList.add(paramE);
  }
  
  public boolean addAll(int paramInt, @NonNull Collection<? extends E> paramCollection)
  {
    return this.immutableList.addAll(paramInt, paramCollection);
  }
  
  public boolean addAll(@NonNull Collection<? extends E> paramCollection)
  {
    return this.immutableList.addAll(paramCollection);
  }
  
  public void clear()
  {
    this.immutableList.clear();
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    return this.immutableList.contains(paramObject);
  }
  
  public boolean containsAll(@NonNull Collection<?> paramCollection)
  {
    return this.immutableList.containsAll(paramCollection);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return this.immutableList.equals(paramObject);
  }
  
  @NonNull
  public E get(int paramInt)
  {
    return (E)this.immutableList.get(paramInt);
  }
  
  public int hashCode()
  {
    return this.immutableList.hashCode();
  }
  
  public int indexOf(@Nullable Object paramObject)
  {
    return this.immutableList.indexOf(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.immutableList.isEmpty();
  }
  
  @NonNull
  public Iterator<E> iterator()
  {
    return this.immutableList.iterator();
  }
  
  public int lastIndexOf(@Nullable Object paramObject)
  {
    return this.immutableList.lastIndexOf(paramObject);
  }
  
  @NonNull
  public ListIterator<E> listIterator()
  {
    return this.immutableList.listIterator();
  }
  
  @NonNull
  public ListIterator<E> listIterator(int paramInt)
  {
    return this.immutableList.listIterator(paramInt);
  }
  
  public E remove(int paramInt)
  {
    return (E)this.immutableList.remove(paramInt);
  }
  
  public boolean remove(@Nullable Object paramObject)
  {
    return this.immutableList.remove(paramObject);
  }
  
  public boolean removeAll(@NonNull Collection<?> paramCollection)
  {
    return this.immutableList.removeAll(paramCollection);
  }
  
  public boolean retainAll(@NonNull Collection<?> paramCollection)
  {
    return this.immutableList.retainAll(paramCollection);
  }
  
  @NonNull
  public E set(int paramInt, @NonNull E paramE)
  {
    return (E)this.immutableList.set(paramInt, paramE);
  }
  
  public int size()
  {
    return this.immutableList.size();
  }
  
  @NonNull
  public List<E> subList(int paramInt1, int paramInt2)
  {
    return this.immutableList.subList(paramInt1, paramInt2);
  }
  
  @Nullable
  public Object[] toArray()
  {
    return this.immutableList.toArray();
  }
  
  public <T> T[] toArray(@Nullable T[] paramArrayOfT)
  {
    return this.immutableList.toArray(paramArrayOfT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\crashlytics\internal\model\ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */