package com.tplink.iot.view.familymanager;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.f.a;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.familymanager.RoomViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;
import java.util.ArrayList;
import java.util.List;

public class AddRoomActivity
  extends BaseActivity
  implements TextWatcher, LineBreakLayout.b
{
  @BindView
  TPRefreshableButton mAddRoomBtn;
  @BindView
  DrawableEditText mAddRoomEditText;
  @BindView
  LineBreakLayout mLineBreakLayout;
  private CharSequence p0;
  private RoomViewModel p1;
  private List<String> y = new ArrayList();
  private List<String> z;
  
  private void g1()
  {
    this.y.add(getString(2131953007));
    this.y.add(getString(2131953003));
    this.y.add(getString(2131953005));
    this.y.add(getString(2131953006));
    this.y.add(getString(2131953008));
    this.y.add(getString(2131953010));
    this.y.add(getString(2131953011));
    this.mLineBreakLayout.setSingleSelectionLables(this.y);
    this.mLineBreakLayout.setListener(this);
  }
  
  private void h1(RoomBean paramRoomBean)
  {
    this.mAddRoomBtn.h();
    s0.g();
    if (paramRoomBean != null)
    {
      W0(AddDeviceActivity.class);
      finish();
    }
    else
    {
      s0.n(this, 2131953328);
    }
  }
  
  private void i1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953671, new Object[] { Integer.valueOf(32) })).o(2131951761, 2131099808, new c()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void j1()
  {
    this.p1.v().observe(this, new a());
    this.p1.t().observe(this, new b());
  }
  
  public void M()
  {
    List localList = this.mLineBreakLayout.getSelectedLables();
    this.z = localList;
    if ((localList != null) && (localList.size() > 0)) {
      this.mAddRoomEditText.setText((CharSequence)this.z.get(0));
    }
  }
  
  @OnClick
  void addRoom()
  {
    a.g(this);
    FamilyDataManager localFamilyDataManager = FamilyDataManager.INSTANCE;
    if (localFamilyDataManager.isRoomNameAlreadyExist(this.p0.toString()))
    {
      this.mAddRoomBtn.h();
      s0.p(this, getString(2131953674));
    }
    else if (localFamilyDataManager.getCurFamily() != null)
    {
      s0.l(this);
      this.p1.C(localFamilyDataManager.getCurFamily().getFamilyId(), null, this.p0.toString(), true);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.p0.toString().getBytes().length;
    if (i == 0)
    {
      this.mAddRoomBtn.setEnabled(false);
    }
    else
    {
      this.mAddRoomBtn.setEnabled(true);
      if (i > 64)
      {
        paramEditable.delete(this.p0.length() - 1, this.p0.length());
        this.mAddRoomEditText.setText(paramEditable);
        this.mAddRoomEditText.setSelection(paramEditable.length());
      }
    }
    if (!this.y.contains(this.p0.toString())) {
      this.mLineBreakLayout.d();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558728);
    ButterKnife.a(this);
    b1(2131951780);
    this.mAddRoomEditText.m();
    this.mAddRoomEditText.f(this);
    this.mAddRoomBtn.setEnabled(false);
    g1();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.p1 = ((RoomViewModel)ViewModelProviders.of(this).get(RoomViewModel.class));
    j1();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.p0 = paramCharSequence;
  }
  
  class a
    implements Observer<RoomBean>
  {
    a() {}
    
    public void a(RoomBean paramRoomBean)
    {
      AddRoomActivity.e1(AddRoomActivity.this, paramRoomBean);
    }
  }
  
  class b
    implements Observer<Integer>
  {
    b() {}
    
    public void a(Integer paramInteger)
    {
      AddRoomActivity.this.mAddRoomBtn.h();
      s0.g();
      if (paramInteger.intValue() == 15009) {
        AddRoomActivity.f1(AddRoomActivity.this);
      }
    }
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView)
    {
      AddRoomActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\AddRoomActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */