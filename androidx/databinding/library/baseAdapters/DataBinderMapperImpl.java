package androidx.databinding.library.baseAdapters;

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
  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);
  
  public List<DataBinderMapper> collectDependencies()
  {
    return new ArrayList(0);
  }
  
  public String convertBrIdToString(int paramInt)
  {
    return (String)InnerBrLookup.sKeys.get(paramInt);
  }
  
  public ViewDataBinding getDataBinder(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt)
  {
    if ((INTERNAL_LAYOUT_ID_LOOKUP.get(paramInt) > 0) && (paramView.getTag() == null)) {
      throw new RuntimeException("view must have a tag");
    }
    return null;
  }
  
  public ViewDataBinding getDataBinder(DataBindingComponent paramDataBindingComponent, View[] paramArrayOfView, int paramInt)
  {
    if ((paramArrayOfView != null) && (paramArrayOfView.length != 0) && (INTERNAL_LAYOUT_ID_LOOKUP.get(paramInt) > 0) && (paramArrayOfView[0].getTag() == null)) {
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
    paramString = (Integer)InnerLayoutIdLookup.sKeys.get(paramString);
    if (paramString != null) {
      i = paramString.intValue();
    }
    return i;
  }
  
  private static class InnerBrLookup
  {
    static final SparseArray<String> sKeys;
    
    static
    {
      SparseArray localSparseArray = new SparseArray(1);
      sKeys = localSparseArray;
      localSparseArray.put(0, "_all");
    }
  }
  
  private static class InnerLayoutIdLookup
  {
    static final HashMap<String, Integer> sKeys = new HashMap(0);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\library\baseAdapters\DataBinderMapperImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */