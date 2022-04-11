package androidx.navigation.fragment;

import android.view.View;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class FragmentNavigatorExtrasKt
{
  public static final FragmentNavigator.Extras FragmentNavigatorExtras(Pair<? extends View, String>... paramVarArgs)
  {
    j.f(paramVarArgs, "sharedElements");
    FragmentNavigator.Extras.Builder localBuilder = new FragmentNavigator.Extras.Builder();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      Pair<? extends View, String> localPair = paramVarArgs[j];
      localBuilder.addSharedElement((View)localPair.component1(), (String)localPair.component2());
    }
    paramVarArgs = localBuilder.build();
    j.b(paramVarArgs, "FragmentNavigator.Extras…      }\n        }.build()");
    return paramVarArgs;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\fragment\FragmentNavigatorExtrasKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */