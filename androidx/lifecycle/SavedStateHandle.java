package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class SavedStateHandle
{
  private static final Class[] ACCEPTABLE_CLASSES;
  private static final String KEYS = "keys";
  private static final String VALUES = "values";
  private final Map<String, SavingStateLiveData<?>> mLiveDatas = new HashMap();
  final Map<String, Object> mRegular;
  private final SavedStateRegistry.SavedStateProvider mSavedStateProvider = new SavedStateRegistry.SavedStateProvider()
  {
    @NonNull
    public Bundle saveState()
    {
      Object localObject = SavedStateHandle.this.mRegular.keySet();
      ArrayList localArrayList1 = new ArrayList(((Set)localObject).size());
      ArrayList localArrayList2 = new ArrayList(localArrayList1.size());
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localArrayList1.add(str);
        localArrayList2.add(SavedStateHandle.this.mRegular.get(str));
      }
      localObject = new Bundle();
      ((Bundle)localObject).putParcelableArrayList("keys", localArrayList1);
      ((Bundle)localObject).putParcelableArrayList("values", localArrayList2);
      return (Bundle)localObject;
    }
  };
  
  static
  {
    Class localClass1 = Boolean.TYPE;
    Class localClass2 = Double.TYPE;
    Class localClass3 = Integer.TYPE;
    Class localClass4 = Long.TYPE;
    Class localClass5 = Byte.TYPE;
    Class localClass6 = Character.TYPE;
    Class localClass7 = Float.TYPE;
    Class localClass8 = Short.TYPE;
    int i = Build.VERSION.SDK_INT;
    Class localClass9;
    if (i >= 21) {
      localClass9 = Size.class;
    } else {
      localClass9 = localClass3;
    }
    Class localClass10 = localClass3;
    if (i >= 21) {
      localClass10 = SizeF.class;
    }
    ACCEPTABLE_CLASSES = new Class[] { localClass1, boolean[].class, localClass2, double[].class, localClass3, int[].class, localClass4, long[].class, String.class, String[].class, Binder.class, Bundle.class, localClass5, byte[].class, localClass6, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, localClass7, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, localClass8, short[].class, SparseArray.class, localClass9, localClass10 };
  }
  
  public SavedStateHandle()
  {
    this.mRegular = new HashMap();
  }
  
  public SavedStateHandle(@NonNull Map<String, Object> paramMap)
  {
    this.mRegular = new HashMap(paramMap);
  }
  
  static SavedStateHandle createHandle(@Nullable Bundle paramBundle1, @Nullable Bundle paramBundle2)
  {
    if ((paramBundle1 == null) && (paramBundle2 == null)) {
      return new SavedStateHandle();
    }
    HashMap localHashMap = new HashMap();
    if (paramBundle2 != null)
    {
      Iterator localIterator = paramBundle2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramBundle2.get(str));
      }
    }
    if (paramBundle1 == null) {
      return new SavedStateHandle(localHashMap);
    }
    paramBundle2 = paramBundle1.getParcelableArrayList("keys");
    paramBundle1 = paramBundle1.getParcelableArrayList("values");
    if ((paramBundle2 != null) && (paramBundle1 != null) && (paramBundle2.size() == paramBundle1.size()))
    {
      for (int i = 0; i < paramBundle2.size(); i++) {
        localHashMap.put((String)paramBundle2.get(i), paramBundle1.get(i));
      }
      return new SavedStateHandle(localHashMap);
    }
    throw new IllegalStateException("Invalid bundle passed as restored state");
  }
  
  @NonNull
  private <T> MutableLiveData<T> getLiveDataInternal(@NonNull String paramString, boolean paramBoolean, @Nullable T paramT)
  {
    MutableLiveData localMutableLiveData = (MutableLiveData)this.mLiveDatas.get(paramString);
    if (localMutableLiveData != null) {
      return localMutableLiveData;
    }
    if (this.mRegular.containsKey(paramString)) {
      paramT = new SavingStateLiveData(this, paramString, this.mRegular.get(paramString));
    } else if (paramBoolean) {
      paramT = new SavingStateLiveData(this, paramString, paramT);
    } else {
      paramT = new SavingStateLiveData(this, paramString);
    }
    this.mLiveDatas.put(paramString, paramT);
    return paramT;
  }
  
  private static void validateValue(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    Object localObject = ACCEPTABLE_CLASSES;
    int i = localObject.length;
    for (int j = 0; j < i; j++) {
      if (localObject[j].isInstance(paramObject)) {
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Can't put value with type ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    ((StringBuilder)localObject).append(" into saved state");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  @MainThread
  public boolean contains(@NonNull String paramString)
  {
    return this.mRegular.containsKey(paramString);
  }
  
  @MainThread
  @Nullable
  public <T> T get(@NonNull String paramString)
  {
    return (T)this.mRegular.get(paramString);
  }
  
  @MainThread
  @NonNull
  public <T> MutableLiveData<T> getLiveData(@NonNull String paramString)
  {
    return getLiveDataInternal(paramString, false, null);
  }
  
  @MainThread
  @NonNull
  public <T> MutableLiveData<T> getLiveData(@NonNull String paramString, @SuppressLint({"UnknownNullness"}) T paramT)
  {
    return getLiveDataInternal(paramString, true, paramT);
  }
  
  @MainThread
  @NonNull
  public Set<String> keys()
  {
    return Collections.unmodifiableSet(this.mRegular.keySet());
  }
  
  @MainThread
  @Nullable
  public <T> T remove(@NonNull String paramString)
  {
    Object localObject = this.mRegular.remove(paramString);
    paramString = (SavingStateLiveData)this.mLiveDatas.remove(paramString);
    if (paramString != null) {
      paramString.detach();
    }
    return (T)localObject;
  }
  
  @NonNull
  SavedStateRegistry.SavedStateProvider savedStateProvider()
  {
    return this.mSavedStateProvider;
  }
  
  @MainThread
  public <T> void set(@NonNull String paramString, @Nullable T paramT)
  {
    validateValue(paramT);
    MutableLiveData localMutableLiveData = (MutableLiveData)this.mLiveDatas.get(paramString);
    if (localMutableLiveData != null) {
      localMutableLiveData.setValue(paramT);
    } else {
      this.mRegular.put(paramString, paramT);
    }
  }
  
  static class SavingStateLiveData<T>
    extends MutableLiveData<T>
  {
    private SavedStateHandle mHandle;
    private String mKey;
    
    SavingStateLiveData(SavedStateHandle paramSavedStateHandle, String paramString)
    {
      this.mKey = paramString;
      this.mHandle = paramSavedStateHandle;
    }
    
    SavingStateLiveData(SavedStateHandle paramSavedStateHandle, String paramString, T paramT)
    {
      super();
      this.mKey = paramString;
      this.mHandle = paramSavedStateHandle;
    }
    
    void detach()
    {
      this.mHandle = null;
    }
    
    public void setValue(T paramT)
    {
      SavedStateHandle localSavedStateHandle = this.mHandle;
      if (localSavedStateHandle != null) {
        localSavedStateHandle.mRegular.put(this.mKey, paramT);
      }
      super.setValue(paramT);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\lifecycle\SavedStateHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */