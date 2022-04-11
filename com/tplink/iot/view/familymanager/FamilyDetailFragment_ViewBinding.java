package com.tplink.iot.view.familymanager;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;

public class FamilyDetailFragment_ViewBinding
  implements Unbinder
{
  private FamilyDetailFragment b;
  private View c;
  
  @UiThread
  public FamilyDetailFragment_ViewBinding(final FamilyDetailFragment paramFamilyDetailFragment, View paramView)
  {
    this.b = paramFamilyDetailFragment;
    paramFamilyDetailFragment.mToolbar = ((Toolbar)c.d(paramView, 2131364275, "field 'mToolbar'", Toolbar.class));
    paramFamilyDetailFragment.mToolbarTitle = ((TextView)c.d(paramView, 2131364290, "field 'mToolbarTitle'", TextView.class));
    paramFamilyDetailFragment.mRoomListRecyclerView = ((RecyclerView)c.d(paramView, 2131363807, "field 'mRoomListRecyclerView'", RecyclerView.class));
    paramView = c.c(paramView, 2131362047, "field 'mDeleteHomeButton' and method 'deleteHome'");
    paramFamilyDetailFragment.mDeleteHomeButton = ((Button)c.b(paramView, 2131362047, "field 'mDeleteHomeButton'", Button.class));
    this.c = paramView;
    paramView.setOnClickListener(new a(paramFamilyDetailFragment));
  }
  
  @CallSuper
  public void a()
  {
    FamilyDetailFragment localFamilyDetailFragment = this.b;
    if (localFamilyDetailFragment != null)
    {
      this.b = null;
      localFamilyDetailFragment.mToolbar = null;
      localFamilyDetailFragment.mToolbarTitle = null;
      localFamilyDetailFragment.mRoomListRecyclerView = null;
      localFamilyDetailFragment.mDeleteHomeButton = null;
      this.c.setOnClickListener(null);
      this.c = null;
      return;
    }
    throw new IllegalStateException("Bindings already cleared.");
  }
  
  class a
    extends b
  {
    a(FamilyDetailFragment paramFamilyDetailFragment) {}
    
    public void a(View paramView)
    {
      paramFamilyDetailFragment.deleteHome();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\FamilyDetailFragment_ViewBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */