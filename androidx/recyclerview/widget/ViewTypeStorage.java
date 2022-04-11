package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

abstract interface ViewTypeStorage
{
  @NonNull
  public abstract ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper);
  
  @NonNull
  public abstract NestedAdapterWrapper getWrapperForGlobalType(int paramInt);
  
  public static class IsolatedViewTypeStorage
    implements ViewTypeStorage
  {
    SparseArray<NestedAdapterWrapper> mGlobalTypeToWrapper = new SparseArray();
    int mNextViewType = 0;
    
    @NonNull
    public ViewTypeStorage.ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper)
    {
      return new WrapperViewTypeLookup(paramNestedAdapterWrapper);
    }
    
    @NonNull
    public NestedAdapterWrapper getWrapperForGlobalType(int paramInt)
    {
      Object localObject = (NestedAdapterWrapper)this.mGlobalTypeToWrapper.get(paramInt);
      if (localObject != null) {
        return (NestedAdapterWrapper)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot find the wrapper for global view type ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    int obtainViewType(NestedAdapterWrapper paramNestedAdapterWrapper)
    {
      int i = this.mNextViewType;
      this.mNextViewType = (i + 1);
      this.mGlobalTypeToWrapper.put(i, paramNestedAdapterWrapper);
      return i;
    }
    
    void removeWrapper(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper)
    {
      for (int i = this.mGlobalTypeToWrapper.size() - 1; i >= 0; i--) {
        if ((NestedAdapterWrapper)this.mGlobalTypeToWrapper.valueAt(i) == paramNestedAdapterWrapper) {
          this.mGlobalTypeToWrapper.removeAt(i);
        }
      }
    }
    
    class WrapperViewTypeLookup
      implements ViewTypeStorage.ViewTypeLookup
    {
      private SparseIntArray mGlobalToLocalMapping = new SparseIntArray(1);
      private SparseIntArray mLocalToGlobalMapping = new SparseIntArray(1);
      final NestedAdapterWrapper mWrapper;
      
      WrapperViewTypeLookup(NestedAdapterWrapper paramNestedAdapterWrapper)
      {
        this.mWrapper = paramNestedAdapterWrapper;
      }
      
      public void dispose()
      {
        ViewTypeStorage.IsolatedViewTypeStorage.this.removeWrapper(this.mWrapper);
      }
      
      public int globalToLocal(int paramInt)
      {
        int i = this.mGlobalToLocalMapping.indexOfKey(paramInt);
        if (i >= 0) {
          return this.mGlobalToLocalMapping.valueAt(i);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requested global type ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" does not belong to the adapter:");
        localStringBuilder.append(this.mWrapper.adapter);
        throw new IllegalStateException(localStringBuilder.toString());
      }
      
      public int localToGlobal(int paramInt)
      {
        int i = this.mLocalToGlobalMapping.indexOfKey(paramInt);
        if (i > -1) {
          return this.mLocalToGlobalMapping.valueAt(i);
        }
        i = ViewTypeStorage.IsolatedViewTypeStorage.this.obtainViewType(this.mWrapper);
        this.mLocalToGlobalMapping.put(paramInt, i);
        this.mGlobalToLocalMapping.put(i, paramInt);
        return i;
      }
    }
  }
  
  public static class SharedIdRangeViewTypeStorage
    implements ViewTypeStorage
  {
    SparseArray<List<NestedAdapterWrapper>> mGlobalTypeToWrapper = new SparseArray();
    
    @NonNull
    public ViewTypeStorage.ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper)
    {
      return new WrapperViewTypeLookup(paramNestedAdapterWrapper);
    }
    
    @NonNull
    public NestedAdapterWrapper getWrapperForGlobalType(int paramInt)
    {
      Object localObject = (List)this.mGlobalTypeToWrapper.get(paramInt);
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        return (NestedAdapterWrapper)((List)localObject).get(0);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot find the wrapper for global view type ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    void removeWrapper(@NonNull NestedAdapterWrapper paramNestedAdapterWrapper)
    {
      for (int i = this.mGlobalTypeToWrapper.size() - 1; i >= 0; i--)
      {
        List localList = (List)this.mGlobalTypeToWrapper.valueAt(i);
        if ((localList.remove(paramNestedAdapterWrapper)) && (localList.isEmpty())) {
          this.mGlobalTypeToWrapper.removeAt(i);
        }
      }
    }
    
    class WrapperViewTypeLookup
      implements ViewTypeStorage.ViewTypeLookup
    {
      final NestedAdapterWrapper mWrapper;
      
      WrapperViewTypeLookup(NestedAdapterWrapper paramNestedAdapterWrapper)
      {
        this.mWrapper = paramNestedAdapterWrapper;
      }
      
      public void dispose()
      {
        ViewTypeStorage.SharedIdRangeViewTypeStorage.this.removeWrapper(this.mWrapper);
      }
      
      public int globalToLocal(int paramInt)
      {
        return paramInt;
      }
      
      public int localToGlobal(int paramInt)
      {
        List localList = (List)ViewTypeStorage.SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.get(paramInt);
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList();
          ViewTypeStorage.SharedIdRangeViewTypeStorage.this.mGlobalTypeToWrapper.put(paramInt, localObject);
        }
        if (!((List)localObject).contains(this.mWrapper)) {
          ((List)localObject).add(this.mWrapper);
        }
        return paramInt;
      }
    }
  }
  
  public static abstract interface ViewTypeLookup
  {
    public abstract void dispose();
    
    public abstract int globalToLocal(int paramInt);
    
    public abstract int localToGlobal(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\ViewTypeStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */