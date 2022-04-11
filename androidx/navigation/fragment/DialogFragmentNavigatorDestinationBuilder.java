package androidx.navigation.fragment;

import androidx.annotation.IdRes;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import kotlin.jvm.a;
import kotlin.reflect.c;

@NavDestinationDsl
public final class DialogFragmentNavigatorDestinationBuilder
  extends NavDestinationBuilder<DialogFragmentNavigator.Destination>
{
  private final c<? extends DialogFragment> fragmentClass;
  
  public DialogFragmentNavigatorDestinationBuilder(DialogFragmentNavigator paramDialogFragmentNavigator, @IdRes int paramInt, c<? extends DialogFragment> paramc)
  {
    super(paramDialogFragmentNavigator, paramInt);
    this.fragmentClass = paramc;
  }
  
  public DialogFragmentNavigator.Destination build()
  {
    DialogFragmentNavigator.Destination localDestination = (DialogFragmentNavigator.Destination)super.build();
    localDestination.setClassName(a.a(this.fragmentClass).getName());
    return localDestination;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\fragment\DialogFragmentNavigatorDestinationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */