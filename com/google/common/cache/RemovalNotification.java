package com.google.common.cache;

import com.google.common.base.n;
import java.util.AbstractMap.SimpleImmutableEntry;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class RemovalNotification<K, V>
  extends AbstractMap.SimpleImmutableEntry<K, V>
{
  private static final long serialVersionUID = 0L;
  private final RemovalCause cause;
  
  private RemovalNotification(@NullableDecl K paramK, @NullableDecl V paramV, RemovalCause paramRemovalCause)
  {
    super(paramK, paramV);
    this.cause = ((RemovalCause)n.o(paramRemovalCause));
  }
  
  public static <K, V> RemovalNotification<K, V> create(@NullableDecl K paramK, @NullableDecl V paramV, RemovalCause paramRemovalCause)
  {
    return new RemovalNotification(paramK, paramV, paramRemovalCause);
  }
  
  public RemovalCause getCause()
  {
    return this.cause;
  }
  
  public boolean wasEvicted()
  {
    return this.cause.wasEvicted();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\cache\RemovalNotification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */