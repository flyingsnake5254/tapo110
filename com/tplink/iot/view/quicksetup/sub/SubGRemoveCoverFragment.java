package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.databinding.FragmentSubgRemoveCoverBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGEmptyViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public final class SubGRemoveCoverFragment
  extends SubGBaseFragment<FragmentSubgRemoveCoverBinding, SubGEmptyViewModel>
{
  public static final a x = new a(null);
  private HashMap y;
  
  public int B0()
  {
    return 2131558977;
  }
  
  public void G0()
  {
    HashMap localHashMap = this.y;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public SubGEmptyViewModel H0()
  {
    ViewModel localViewModel = new ViewModelProvider(this).get(SubGEmptyViewModel.class);
    j.d(localViewModel, "ViewModelProvider(this).…ptyViewModel::class.java)");
    return (SubGEmptyViewModel)localViewModel;
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    int i = paramView.getId();
    if (i != 2131362083)
    {
      if (i == 2131362826) {
        this.q.E0(20002);
      }
    }
    else {
      this.f.e0("SubGGuideFirstFragment.TAG", null);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    paramView = ((FragmentSubgRemoveCoverBinding)this.c).z;
    j.d(paramView, "binding.tvRemoveCoverTitle");
    paramBundle = this.q;
    j.d(paramBundle, "subGViewModel");
    paramView.setText(paramBundle.z().a());
    paramView = ((FragmentSubgRemoveCoverBinding)this.c).y;
    j.d(paramView, "binding.tvRemoveCoverHint");
    paramBundle = this.q;
    j.d(paramBundle, "subGViewModel");
    paramView.setText(paramBundle.z().b());
    paramView = ((FragmentSubgRemoveCoverBinding)this.c).f;
    paramBundle = this.q;
    j.d(paramBundle, "subGViewModel");
    paramView.setImageResource(paramBundle.z().j());
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGRemoveCoverFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */