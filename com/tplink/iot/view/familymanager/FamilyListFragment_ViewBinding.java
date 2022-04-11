package com.tplink.iot.view.familymanager;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.c;

public class FamilyListFragment_ViewBinding
  implements Unbinder
{
  private FamilyListFragment b;
  
  @UiThread
  public FamilyListFragment_ViewBinding(FamilyListFragment paramFamilyListFragment, View paramView)
  {
    this.b = paramFamilyListFragment;
    paramFamilyListFragment.mToolbar = ((Toolbar)c.d(paramView, 2131364275, "field 'mToolbar'", Toolbar.class));
    paramFamilyListFragment.mToolbarTitle = ((TextView)c.d(paramView, 2131364290, "field 'mToolbarTitle'", TextView.class));
    paramFamilyListFragment.mHomeListRecyclerView = ((RecyclerView)c.d(paramView, 2131363804, "field 'mHomeListRecyclerView'", RecyclerView.class));
  }
  
  @CallSuper
  public void a()
  {
    FamilyListFragment localFamilyListFragment = this.b;
    if (localFamilyListFragment != null)
    {
      this.b = null;
      localFamilyListFragment.mToolbar = null;
      localFamilyListFragment.mToolbarTitle = null;
      localFamilyListFragment.mHomeListRecyclerView = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\FamilyListFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */