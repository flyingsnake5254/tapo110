package org.greenrobot.greendao.identityscope;

public abstract interface IdentityScope<K, T>
{
  public abstract void clear();
  
  public abstract boolean detach(K paramK, T paramT);
  
  public abstract T get(K paramK);
  
  public abstract T getNoLock(K paramK);
  
  public abstract void lock();
  
  public abstract void put(K paramK, T paramT);
  
  public abstract void putNoLock(K paramK, T paramT);
  
  public abstract void remove(Iterable<K> paramIterable);
  
  public abstract void remove(K paramK);
  
  public abstract void reserveRoom(int paramInt);
  
  public abstract void unlock();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\identityscope\IdentityScope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */