package com.tplink.iot.view.familymanager;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.familymanager.RoomViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.FamilyBean;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyDataManager;

public class EditRoomNameActivity
  extends BaseActivity
  implements TextWatcher
{
  @BindView
  DrawableEditText mRoomNameEditText;
  private CharSequence p0;
  private RoomViewModel p1;
  private MenuItem y;
  private String z;
  
  private boolean f1(String paramString)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.z))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void g1()
  {
    a.g(this);
    if (f1(this.mRoomNameEditText.getText().toString())) {
      i1();
    } else {
      finish();
    }
  }
  
  private void h1()
  {
    FamilyDataManager localFamilyDataManager = FamilyDataManager.INSTANCE;
    if (localFamilyDataManager.isRoomNameAlreadyExist(this.p0.toString())) {
      s0.p(this, getString(2131953674));
    } else {
      this.p1.C(localFamilyDataManager.getCurFamily().getFamilyId(), localFamilyDataManager.getCurRoombean().getRoomId(), this.p0.toString(), false);
    }
  }
  
  private void i1()
  {
    new TPMaterialDialogV2.Builder(this).i(2131952581, 2131099840).o(2131952404, 2131099808, new b()).l(2131952391, 2131099804, null).g(8, 8).b(false).a().show();
  }
  
  private void j1(RoomBean paramRoomBean)
  {
    
    if (paramRoomBean != null) {
      finish();
    } else {
      s0.n(this, 2131953328);
    }
  }
  
  private void k1()
  {
    this.p1.v().observe(this, new a());
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.p0.toString().getBytes().length;
    boolean bool = true;
    if (i > 64)
    {
      paramEditable.delete(this.p0.length() - 1, this.p0.length());
      this.mRoomNameEditText.setText(paramEditable);
      this.mRoomNameEditText.setSelection(paramEditable.length());
    }
    if (this.y != null)
    {
      if (TextUtils.isEmpty(paramEditable.toString())) {}
      while ((!TextUtils.isEmpty(this.z)) && (this.z.equals(paramEditable.toString())))
      {
        bool = false;
        break;
      }
      this.y.setEnabled(bool);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onBackPressed()
  {
    g1();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558835);
    ButterKnife.a(this);
    b1(2131952610);
    paramBundle = FamilyDataManager.INSTANCE;
    if ((paramBundle.getCurRoombean() == null) || (paramBundle.getCurRoomList() == null)) {
      finish();
    }
    this.mRoomNameEditText.m();
    this.mRoomNameEditText.f(this);
    paramBundle = paramBundle.getCurRoombean().getRoomName();
    this.z = paramBundle;
    if (!TextUtils.isEmpty(paramBundle)) {
      l.m(this.mRoomNameEditText, this.z);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    this.y = paramMenu.findItem(2131362300);
    boolean bool;
    if ((this.mRoomNameEditText != null) && (((TextUtils.isEmpty(this.z)) && (!TextUtils.isEmpty(this.mRoomNameEditText.getText()))) || (!TextUtils.equals(this.z, this.mRoomNameEditText.getText().toString())))) {
      bool = true;
    } else {
      bool = false;
    }
    this.y.setEnabled(bool);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 2131362300)
    {
      s0.l(this);
      h1();
    }
    else if (i == 16908332)
    {
      g1();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.p1 = ((RoomViewModel)ViewModelProviders.of(this).get(RoomViewModel.class));
    k1();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.p0 = paramCharSequence;
  }
  
  class a
    implements Observer<RoomBean>
  {
    a() {}
    
    public void a(@Nullable RoomBean paramRoomBean)
    {
      EditRoomNameActivity.e1(EditRoomNameActivity.this, paramRoomBean);
    }
  }
  
  class b
    implements TPMaterialDialogV2.d
  {
    b() {}
    
    public void onClick(View paramView)
    {
      EditRoomNameActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\familymanager\EditRoomNameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */