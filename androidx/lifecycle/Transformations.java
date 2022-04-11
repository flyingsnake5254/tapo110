package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

public class Transformations
{
  @MainThread
  @NonNull
  public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> paramLiveData)
  {
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    localMediatorLiveData.addSource(paramLiveData, new Observer()
    {
      boolean mFirstTime = true;
      
      public void onChanged(X paramAnonymousX)
      {
        Object localObject = this.val$outputLiveData.getValue();
        if ((this.mFirstTime) || ((localObject == null) && (paramAnonymousX != null)) || ((localObject != null) && (!localObject.equals(paramAnonymousX))))
        {
          this.mFirstTime = false;
          this.val$outputLiveData.setValue(paramAnonymousX);
        }
      }
    });
    return localMediatorLiveData;
  }
  
  @MainThread
  @NonNull
  public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> paramLiveData, @NonNull final Function<X, Y> paramFunction)
  {
    MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    localMediatorLiveData.addSource(paramLiveData, new Observer()
    {
      public void onChanged(@Nullable X paramAnonymousX)
      {
        this.val$result.setValue(paramFunction.apply(paramAnonymousX));
      }
    });
    return localMediatorLiveData;
  }
  
  @MainThread
  @NonNull
  public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> paramLiveData, @NonNull Function<X, LiveData<Y>> paramFunction)
  {
    final MediatorLiveData localMediatorLiveData = new MediatorLiveData();
    localMediatorLiveData.addSource(paramLiveData, new Observer()
    {
      LiveData<Y> mSource;
      
      public void onChanged(@Nullable X paramAnonymousX)
      {
        LiveData localLiveData = (LiveData)this.val$switchMapFunction.apply(paramAnonymousX);
        paramAnonymousX = this.mSource;
        if (paramAnonymousX == localLiveData) {
          return;
        }
        if (paramAnonymousX != null) {
          localMediatorLiveData.removeSource(paramAnonymousX);
        }
        this.mSource = localLiveData;
        if (localLiveData != null) {
          localMediatorLiveData.addSource(localLiveData, new Observer()
          {
            public void onChanged(@Nullable Y paramAnonymous2Y)
            {
              Transformations.2.this.val$result.setValue(paramAnonymous2Y);
            }
          });
        }
      }
    });
    return localMediatorLiveData;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\Transformations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */