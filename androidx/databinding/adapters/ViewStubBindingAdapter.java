package androidx.databinding.adapters;

import android.view.ViewStub.OnInflateListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;
import androidx.databinding.Untaggable;
import androidx.databinding.ViewStubProxy;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:layout", method="setLayoutResource", type=android.view.ViewStub.class)})
@Untaggable({"android.view.ViewStub"})
public class ViewStubBindingAdapter
{
  @BindingAdapter({"android:onInflate"})
  public static void setOnInflateListener(ViewStubProxy paramViewStubProxy, ViewStub.OnInflateListener paramOnInflateListener)
  {
    paramViewStubProxy.setOnInflateListener(paramOnInflateListener);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\ViewStubBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */