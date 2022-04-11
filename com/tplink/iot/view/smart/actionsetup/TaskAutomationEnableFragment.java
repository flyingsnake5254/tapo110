package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartReferAction;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskAutomationEnableFragment
  extends BaseFragment
  implements Toolbar.OnMenuItemClickListener
{
  private a p0;
  private View q;
  private RadioGroup x;
  private ActionDetailActivity y;
  private ActionSetupViewModel z;
  
  private void H0()
  {
    ((TextView)this.q.findViewById(2131364290)).setText(this.z.u().getName());
    Object localObject = (Toolbar)this.q.findViewById(2131364275);
    ((Toolbar)localObject).inflateMenu(2131623954);
    ((Toolbar)localObject).setOnMenuItemClickListener(this);
    ((Toolbar)localObject).setNavigationOnClickListener(new y(this));
    this.x = ((RadioGroup)this.q.findViewById(2131363853));
    if ((this.z.u() != null) && (this.z.s() != null))
    {
      Boolean localBoolean = this.z.s();
      localObject = this.x;
      int i;
      if (localBoolean.booleanValue()) {
        i = 2131362536;
      } else {
        i = 2131362454;
      }
      ((RadioGroup)localObject).check(i);
    }
  }
  
  public void K0(a parama)
  {
    this.p0 = parama;
  }
  
  public boolean d()
  {
    if (getFragmentManager() != null) {
      getFragmentManager().popBackStackImmediate();
    }
    return true;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = paramLayoutInflater.inflate(2131558958, paramViewGroup, false);
    paramLayoutInflater = (ActionDetailActivity)getActivity();
    this.y = paramLayoutInflater;
    if (paramLayoutInflater == null) {
      B0();
    }
    d.J(this.y, this.q.findViewById(2131364275));
    setHasOptionsMenu(true);
    this.z = ((ActionSetupViewModel)ViewModelProviders.of(this.y).get(ActionSetupViewModel.class));
    H0();
    return this.q;
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 2131361892) && (this.p0 != null))
    {
      SmartInfo localSmartInfo = this.z.v();
      Object localObject1 = localSmartInfo.getActionSetting();
      paramMenuItem = (MenuItem)localObject1;
      if (localObject1 == null) {
        paramMenuItem = new SmartAction();
      }
      Object localObject2 = paramMenuItem.getSmarts();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ArrayList();
      }
      localObject2 = this.z.u().getId();
      Iterator localIterator = ((List)localObject1).iterator();
      int i = 1;
      int j = 1;
      while (localIterator.hasNext())
      {
        SmartReferAction localSmartReferAction = (SmartReferAction)localIterator.next();
        if (((String)localObject2).equals(localSmartReferAction.getId()))
        {
          if (this.x.getCheckedRadioButtonId() == 2131362536) {
            j = 1;
          } else {
            j = 0;
          }
          localSmartReferAction.setAction(j);
          j = 0;
        }
      }
      if (j != 0)
      {
        if (this.x.getCheckedRadioButtonId() == 2131362536) {
          j = i;
        } else {
          j = 0;
        }
        localObject2 = new SmartReferAction((String)localObject2, j, this.z.F());
        ((SmartReferAction)localObject2).setAvatarUrl(this.z.u().getAvatarUrl());
        ((SmartReferAction)localObject2).setName(this.z.u().getName());
        ((List)localObject1).add(0, localObject2);
      }
      paramMenuItem.setSmarts((List)localObject1);
      if ((paramMenuItem.getThings() != null) && (paramMenuItem.getThings().isEmpty())) {
        paramMenuItem.setThings(null);
      }
      localSmartInfo.setActionSetting(paramMenuItem);
      this.z.p0(localSmartInfo);
      this.p0.a();
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\smart\actionsetup\TaskAutomationEnableFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */