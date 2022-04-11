package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

@Deprecated
public class FragmentManagerNonConfig
{
  @Nullable
  private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;
  @Nullable
  private final Collection<Fragment> mFragments;
  @Nullable
  private final Map<String, ViewModelStore> mViewModelStores;
  
  FragmentManagerNonConfig(@Nullable Collection<Fragment> paramCollection, @Nullable Map<String, FragmentManagerNonConfig> paramMap, @Nullable Map<String, ViewModelStore> paramMap1)
  {
    this.mFragments = paramCollection;
    this.mChildNonConfigs = paramMap;
    this.mViewModelStores = paramMap1;
  }
  
  @Nullable
  Map<String, FragmentManagerNonConfig> getChildNonConfigs()
  {
    return this.mChildNonConfigs;
  }
  
  @Nullable
  Collection<Fragment> getFragments()
  {
    return this.mFragments;
  }
  
  @Nullable
  Map<String, ViewModelStore> getViewModelStores()
  {
    return this.mViewModelStores;
  }
  
  boolean isRetaining(Fragment paramFragment)
  {
    Collection localCollection = this.mFragments;
    if (localCollection == null) {
      return false;
    }
    return localCollection.contains(paramFragment);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentManagerNonConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */