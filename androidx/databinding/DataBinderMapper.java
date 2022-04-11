package androidx.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.List;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public abstract class DataBinderMapper
{
  @NonNull
  public List<DataBinderMapper> collectDependencies()
  {
    return Collections.emptyList();
  }
  
  public abstract String convertBrIdToString(int paramInt);
  
  public abstract ViewDataBinding getDataBinder(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt);
  
  public abstract ViewDataBinding getDataBinder(DataBindingComponent paramDataBindingComponent, View[] paramArrayOfView, int paramInt);
  
  public abstract int getLayoutId(String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\DataBinderMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */