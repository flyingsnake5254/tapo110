package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class MergedDataBinderMapper
  extends DataBinderMapper
{
  private static final String TAG = "MergedDataBinderMapper";
  private Set<Class<? extends DataBinderMapper>> mExistingMappers = new HashSet();
  private List<String> mFeatureBindingMappers = new CopyOnWriteArrayList();
  private List<DataBinderMapper> mMappers = new CopyOnWriteArrayList();
  
  private boolean loadFeatures()
  {
    Iterator localIterator = this.mFeatureBindingMappers.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        Class localClass = Class.forName(str);
        if (DataBinderMapper.class.isAssignableFrom(localClass))
        {
          addMapper((DataBinderMapper)localClass.newInstance());
          this.mFeatureBindingMappers.remove(str);
          bool = true;
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("unable to add feature mapper for ");
        localStringBuilder2.append(str);
        Log.e("MergedDataBinderMapper", localStringBuilder2.toString(), localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("unable to add feature mapper for ");
        localStringBuilder1.append(str);
        Log.e("MergedDataBinderMapper", localStringBuilder1.toString(), localIllegalAccessException);
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
    }
    return bool;
  }
  
  public void addMapper(DataBinderMapper paramDataBinderMapper)
  {
    Class localClass = paramDataBinderMapper.getClass();
    if (this.mExistingMappers.add(localClass))
    {
      this.mMappers.add(paramDataBinderMapper);
      paramDataBinderMapper = paramDataBinderMapper.collectDependencies().iterator();
      while (paramDataBinderMapper.hasNext()) {
        addMapper((DataBinderMapper)paramDataBinderMapper.next());
      }
    }
  }
  
  protected void addMapper(String paramString)
  {
    List localList = this.mFeatureBindingMappers;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".DataBinderMapperImpl");
    localList.add(localStringBuilder.toString());
  }
  
  public String convertBrIdToString(int paramInt)
  {
    Iterator localIterator = this.mMappers.iterator();
    while (localIterator.hasNext())
    {
      String str = ((DataBinderMapper)localIterator.next()).convertBrIdToString(paramInt);
      if (str != null) {
        return str;
      }
    }
    if (loadFeatures()) {
      return convertBrIdToString(paramInt);
    }
    return null;
  }
  
  public ViewDataBinding getDataBinder(DataBindingComponent paramDataBindingComponent, View paramView, int paramInt)
  {
    Iterator localIterator = this.mMappers.iterator();
    while (localIterator.hasNext())
    {
      ViewDataBinding localViewDataBinding = ((DataBinderMapper)localIterator.next()).getDataBinder(paramDataBindingComponent, paramView, paramInt);
      if (localViewDataBinding != null) {
        return localViewDataBinding;
      }
    }
    if (loadFeatures()) {
      return getDataBinder(paramDataBindingComponent, paramView, paramInt);
    }
    return null;
  }
  
  public ViewDataBinding getDataBinder(DataBindingComponent paramDataBindingComponent, View[] paramArrayOfView, int paramInt)
  {
    Iterator localIterator = this.mMappers.iterator();
    while (localIterator.hasNext())
    {
      ViewDataBinding localViewDataBinding = ((DataBinderMapper)localIterator.next()).getDataBinder(paramDataBindingComponent, paramArrayOfView, paramInt);
      if (localViewDataBinding != null) {
        return localViewDataBinding;
      }
    }
    if (loadFeatures()) {
      return getDataBinder(paramDataBindingComponent, paramArrayOfView, paramInt);
    }
    return null;
  }
  
  public int getLayoutId(String paramString)
  {
    Iterator localIterator = this.mMappers.iterator();
    while (localIterator.hasNext())
    {
      int i = ((DataBinderMapper)localIterator.next()).getLayoutId(paramString);
      if (i != 0) {
        return i;
      }
    }
    if (loadFeatures()) {
      return getLayoutId(paramString);
    }
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\MergedDataBinderMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */