package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import kotlin.jvm.a;
import kotlin.reflect.c;

@NavDestinationDsl
public final class FragmentNavigatorDestinationBuilder
  extends NavDestinationBuilder<FragmentNavigator.Destination>
{
  private final c<? extends Fragment> fragmentClass;
  
  public FragmentNavigatorDestinationBuilder(FragmentNavigator paramFragmentNavigator, @IdRes int paramInt, c<? extends Fragment> paramc)
  {
    super(paramFragmentNavigator, paramInt);
    this.fragmentClass = paramc;
  }
  
  public FragmentNavigator.Destination build()
  {
    FragmentNavigator.Destination localDestination = (FragmentNavigator.Destination)super.build();
    localDestination.setClassName(a.a(this.fragmentClass).getName());
    return localDestination;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\fragment\FragmentNavigatorDestinationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */