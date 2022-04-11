package com.tplink.libtplivemedia;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl
  extends DataBinderMapper
{
  private static final SparseIntArray a = new SparseIntArray(0);
  
  public List<DataBinderMapper> collectDependencies()
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return localArrayList;
  }
  
  public String convertBrIdToString(int paramInt)
  {
    return (String)a.a.get(paramInt);
  }
  
  public ViewDataBinding getDataBinder(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt)
  {
    if ((a.get(paramInt) > 0) && (paramView.getTag() == null)) {
      throw new RuntimeException("view must have a tag");
    }
    return null;
  }
  
  public ViewDataBinding getDataBinder(DataBindingComponent paramDataBindingComponent, View[] paramArrayOfView, int paramInt)
  {
    if ((paramArrayOfView != null) && (paramArrayOfView.length != 0) && (a.get(paramInt) > 0) && (paramArrayOfView[0].getTag() == null)) {
      throw new RuntimeException("view must have a tag");
    }
    return null;
  }
  
  public int getLayoutId(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return 0;
    }
    paramString = (Integer)b.a.get(paramString);
    if (paramString != null) {
      i = paramString.intValue();
    }
    return i;
  }
  
  private static class a
  {
    static final SparseArray<String> a;
    
    static
    {
      SparseArray localSparseArray = new SparseArray(1);
      a = localSparseArray;
      localSparseArray.put(0, "_all");
    }
  }
  
  private static class b
  {
    static final HashMap<String, Integer> a = new HashMap(0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtplivemedia\DataBinderMapperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */