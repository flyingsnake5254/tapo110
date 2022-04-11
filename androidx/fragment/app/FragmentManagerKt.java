package androidx.fragment.app;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class FragmentManagerKt
{
  public static final void commit(FragmentManager paramFragmentManager, boolean paramBoolean, l<? super FragmentTransaction, p> paraml)
  {
    j.f(paramFragmentManager, "$this$commit");
    j.f(paraml, "body");
    paramFragmentManager = paramFragmentManager.beginTransaction();
    j.b(paramFragmentManager, "beginTransaction()");
    paraml.invoke(paramFragmentManager);
    if (paramBoolean) {
      paramFragmentManager.commitAllowingStateLoss();
    } else {
      paramFragmentManager.commit();
    }
  }
  
  public static final void commitNow(FragmentManager paramFragmentManager, boolean paramBoolean, l<? super FragmentTransaction, p> paraml)
  {
    j.f(paramFragmentManager, "$this$commitNow");
    j.f(paraml, "body");
    paramFragmentManager = paramFragmentManager.beginTransaction();
    j.b(paramFragmentManager, "beginTransaction()");
    paraml.invoke(paramFragmentManager);
    if (paramBoolean) {
      paramFragmentManager.commitNowAllowingStateLoss();
    } else {
      paramFragmentManager.commitNow();
    }
  }
  
  public static final void transaction(FragmentManager paramFragmentManager, boolean paramBoolean1, boolean paramBoolean2, l<? super FragmentTransaction, p> paraml)
  {
    j.f(paramFragmentManager, "$this$transaction");
    j.f(paraml, "body");
    paramFragmentManager = paramFragmentManager.beginTransaction();
    j.b(paramFragmentManager, "beginTransaction()");
    paraml.invoke(paramFragmentManager);
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        paramFragmentManager.commitNowAllowingStateLoss();
      } else {
        paramFragmentManager.commitNow();
      }
    }
    else if (paramBoolean2) {
      paramFragmentManager.commitAllowingStateLoss();
    } else {
      paramFragmentManager.commit();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentManagerKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */