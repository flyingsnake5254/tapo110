package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;

abstract interface StableIdStorage
{
  @NonNull
  public abstract StableIdLookup createStableIdLookup();
  
  public static class IsolatedStableIdStorage
    implements StableIdStorage
  {
    long mNextStableId = 0L;
    
    @NonNull
    public StableIdStorage.StableIdLookup createStableIdLookup()
    {
      return new WrapperStableIdLookup();
    }
    
    long obtainId()
    {
      long l = this.mNextStableId;
      this.mNextStableId = (1L + l);
      return l;
    }
    
    class WrapperStableIdLookup
      implements StableIdStorage.StableIdLookup
    {
      private final LongSparseArray<Long> mLocalToGlobalLookup = new LongSparseArray();
      
      WrapperStableIdLookup() {}
      
      public long localToGlobal(long paramLong)
      {
        Long localLong1 = (Long)this.mLocalToGlobalLookup.get(paramLong);
        Long localLong2 = localLong1;
        if (localLong1 == null)
        {
          localLong2 = Long.valueOf(StableIdStorage.IsolatedStableIdStorage.this.obtainId());
          this.mLocalToGlobalLookup.put(paramLong, localLong2);
        }
        return localLong2.longValue();
      }
    }
  }
  
  public static class NoStableIdStorage
    implements StableIdStorage
  {
    private final StableIdStorage.StableIdLookup mNoIdLookup = new StableIdStorage.StableIdLookup()
    {
      public long localToGlobal(long paramAnonymousLong)
      {
        return -1L;
      }
    };
    
    @NonNull
    public StableIdStorage.StableIdLookup createStableIdLookup()
    {
      return this.mNoIdLookup;
    }
  }
  
  public static class SharedPoolStableIdStorage
    implements StableIdStorage
  {
    private final StableIdStorage.StableIdLookup mSameIdLookup = new StableIdStorage.StableIdLookup()
    {
      public long localToGlobal(long paramAnonymousLong)
      {
        return paramAnonymousLong;
      }
    };
    
    @NonNull
    public StableIdStorage.StableIdLookup createStableIdLookup()
    {
      return this.mSameIdLookup;
    }
  }
  
  public static abstract interface StableIdLookup
  {
    public abstract long localToGlobal(long paramLong);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\StableIdStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */