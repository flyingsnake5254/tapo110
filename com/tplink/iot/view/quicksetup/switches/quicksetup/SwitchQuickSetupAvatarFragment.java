package com.tplink.iot.view.quicksetup.switches.quicksetup;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.adapter.quicksetup.IoTIconAdapter;
import com.tplink.iot.adapter.quicksetup.e;
import com.tplink.iot.databinding.ActivityQsPlugIconSelectIconBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment.a;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SwitchQuickSetupViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.internal.j;

public final class SwitchQuickSetupAvatarFragment
  extends SwitchQuickSetupBaseFragment<ActivityQsPlugIconSelectIconBinding>
{
  public static final a p3 = new a(null);
  private final List<e> H3 = new ArrayList();
  private IoTIconAdapter I3;
  private HashMap J3;
  
  private final int Q0()
  {
    String str = P0().z(L0());
    Iterator localIterator = this.H3.iterator();
    int i = 0;
    for (int j = 0; localIterator.hasNext(); j++) {
      if (j.a(((e)localIterator.next()).a(), str)) {
        break label67;
      }
    }
    j = -1;
    label67:
    if (j != -1) {
      i = j;
    }
    return i;
  }
  
  private final void R0()
  {
    Object localObject = O0().s();
    int i;
    if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localObject = N0();
      if (localObject != null) {
        ((z1)localObject).e0("SwitchQuickSetupLocationCustomFragment", null);
      }
    }
    else
    {
      localObject = N0();
      if (localObject != null) {
        ((z1)localObject).e0("SwitchQuickSetupLocationSelectFragment", null);
      }
    }
  }
  
  private final void S0()
  {
    List localList = this.H3;
    Object localObject = EnumSwitchAvatarType.getS220AvatarNames();
    j.d(localObject, "EnumSwitchAvatarType.getS220AvatarNames()");
    ArrayList localArrayList = new ArrayList(l.l((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new e((String)((Iterator)localObject).next(), false));
    }
    localList.addAll(localArrayList);
    ((e)this.H3.get(0)).d(true);
  }
  
  private final void T0()
  {
    this.I3 = new IoTIconAdapter(this.H3, EnumDeviceType.SWITCH);
    Object localObject = ((ActivityQsPlugIconSelectIconBinding)K0()).d;
    j.d(localObject, "mBinding.iconList");
    ((RecyclerView)localObject).setLayoutManager(new GridLayoutManager(getActivity(), 3));
    localObject = ((ActivityQsPlugIconSelectIconBinding)K0()).d;
    j.d(localObject, "mBinding.iconList");
    ((RecyclerView)localObject).setAdapter(this.I3);
    localObject = this.I3;
    if (localObject != null) {
      ((IoTIconAdapter)localObject).r(Q0());
    }
  }
  
  private final void U0()
  {
    ((ActivityQsPlugIconSelectIconBinding)K0()).c.h();
    SwitchQuickSetupViewModel localSwitchQuickSetupViewModel = P0();
    SwitchButton localSwitchButton = L0();
    Object localObject = this.I3;
    if (localObject != null)
    {
      localObject = ((IoTIconAdapter)localObject).o();
      if (localObject != null) {}
    }
    else
    {
      localObject = EnumSwitchAvatarType.SWITCH_S220.getName();
    }
    j.d(localObject, "mAvatarAdapter?.avatar ?…ype.SWITCH_S220.getName()");
    localSwitchQuickSetupViewModel.M(localSwitchButton, (String)localObject);
    if (L0() == SwitchButton.FIRST)
    {
      localObject = N0();
      if (localObject != null) {
        ((z1)localObject).e0("SwitchQuickSetupGuideFragment", SwitchQuickSetupBaseFragment.q.a(SwitchButton.SECOND));
      }
    }
    else
    {
      R0();
    }
  }
  
  public void H0()
  {
    HashMap localHashMap = this.J3;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public int J0()
  {
    return 2131558626;
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362826) {
        O0().E0(20002);
      }
    }
    else {
      U0();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    j.e(paramView, "view");
    paramView = (ActivityQsPlugIconSelectIconBinding)K0();
    paramView.f.setOnClickListener(this);
    paramView.c.setOnClickListener(this);
    paramView.x.setText(2131954194);
    S0();
    T0();
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\switches\quicksetup\SwitchQuickSetupAvatarFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */