package com.tplink.iot.view.familymanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.annotation.Nullable;
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
import com.tplink.iot.viewmodel.familymanager.FamilyViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;

public class AddFamilyActivity
  extends BaseActivity
  implements TextWatcher
{
  @BindView
  TPRefreshableButton mAddHomeBtn;
  @BindView
  DrawableEditText mAddHomeEditText;
  private CharSequence y;
  private FamilyViewModel z;
  
  private void h1()
  {
    Intent localIntent = new Intent(this, FamilyDetailActivity.class);
    localIntent.putExtra("args_key_need_add_home", false);
    startActivity(localIntent);
  }
  
  private void i1(FamilyBean paramFamilyBean)
  {
    this.mAddHomeBtn.h();
    s0.g();
    if (paramFamilyBean != null) {
      new TPMaterialDialogV2.Builder(this).t(getString(2131951778)).j(getString(2131951777)).l(2131952431, 2131099804, new d()).o(2131951780, 2131099808, new c()).g(8, 8).b(false).c(false).a().show();
    } else {
      s0.p(this, "Failed add a home.");
    }
  }
  
  private void j1()
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131952673, new Object[] { Integer.valueOf(8) })).o(2131951761, 2131099808, new e()).g(8, 8).b(false).c(false).a().show();
  }
  
  private void k1()
  {
    this.z.r().observe(this, new a());
    this.z.p().observe(this, new b());
  }
  
  @OnClick
  void addHome()
  {
    a.g(this);
    FamilyDataManager localFamilyDataManager = FamilyDataManager.INSTANCE;
    boolean bool;
    if ((localFamilyDataManager.getFamilyList() != null) && (this.y.length() > 0)) {
      bool = localFamilyDataManager.isHomeNameAlreadyExist(this.y.toString());
    } else {
      bool = false;
    }
    if (bool)
    {
      this.mAddHomeBtn.h();
      s0.p(this, getString(2131953674));
    }
    else
    {
      s0.l(this);
      this.z.t(null, this.y.toString(), true);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.y.toString().getBytes().length;
    if (i == 0)
    {
      this.mAddHomeBtn.setEnabled(false);
    }
    else
    {
      this.mAddHomeBtn.setEnabled(true);
      if (i > 64)
      {
        paramEditable.delete(this.y.length() - 1, this.y.length());
        this.mAddHomeEditText.setText(paramEditable);
        this.mAddHomeEditText.setSelection(paramEditable.length());
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558727);
    ButterKnife.a(this);
    b1(2131951776);
    this.mAddHomeEditText.m();
    this.mAddHomeEditText.f(this);
    this.mAddHomeBtn.setEnabled(false);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.z = ((FamilyViewModel)ViewModelProviders.of(this).get(FamilyViewModel.class));
    k1();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.y = paramCharSequence;
  }
  
  class a
    implements Observer<FamilyBean>
  {
    a() {}
    
    public void a(@Nullable FamilyBean paramFamilyBean)
    {
      AddFamilyActivity.e1(AddFamilyActivity.this, paramFamilyBean);
    }
  }
  
  class b
    implements Observer<Integer>
  {
    b() {}
    
    public void a(@Nullable Integer paramInteger)
    {
      AddFamilyActivity.this.mAddHomeBtn.h();
      s0.g();
      if (paramInteger.intValue() == 15008) {
        AddFamilyActivity.f1(AddFamilyActivity.this);
      }
    }
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView)
    {
      AddFamilyActivity.this.W0(AddRoomActivity.class);
      AddFamilyActivity.this.finish();
    }
  }
  
  class d
    implements TPMaterialDialogV2.d
  {
    d() {}
    
    public void onClick(View paramView)
    {
      AddFamilyActivity.g1(AddFamilyActivity.this);
      AddFamilyActivity.this.finish();
    }
  }
  
  class e
    implements TPMaterialDialogV2.d
  {
    e() {}
    
    public void onClick(View paramView)
    {
      AddFamilyActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\AddFamilyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */