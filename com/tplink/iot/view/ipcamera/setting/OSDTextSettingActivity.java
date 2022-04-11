package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.MenuSaveBinding;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.setting.OSDTextSettingViewModel;
import com.tplink.iot.widget.DrawableEditText;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class OSDTextSettingActivity
  extends BaseActivity
  implements TextWatcher
{
  public static final a y = new a(null);
  private OSDTextSettingViewModel p0;
  private final MutableLiveData<Boolean> p1 = new MutableLiveData(Boolean.FALSE);
  private HashMap p2;
  private MenuItem z;
  
  private final void h1()
  {
    Object localObject = getSystemService("input_method");
    Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    InputMethodManager localInputMethodManager = (InputMethodManager)localObject;
    localObject = (DrawableEditText)e1(a.osd_info_customize_et);
    j.d(localObject, "osd_info_customize_et");
    localInputMethodManager.hideSoftInputFromWindow(((FrameLayout)localObject).getWindowToken(), 0);
  }
  
  private final void i1()
  {
    String str = getIntent().getStringExtra("deviceIdMD5");
    Object localObject = ViewModelProviders.of(this).get(OSDTextSettingViewModel.class);
    j.d(localObject, "ViewModelProviders.of(th…ingViewModel::class.java)");
    localObject = (OSDTextSettingViewModel)localObject;
    this.p0 = ((OSDTextSettingViewModel)localObject);
    if (localObject == null) {
      j.t("viewModel");
    }
    ((OSDTextSettingViewModel)localObject).l(str);
  }
  
  private final void j1()
  {
    OSDTextSettingViewModel localOSDTextSettingViewModel = this.p0;
    if (localOSDTextSettingViewModel == null) {
      j.t("viewModel");
    }
    localOSDTextSettingViewModel.k().observe(this, new b(this));
    localOSDTextSettingViewModel = this.p0;
    if (localOSDTextSettingViewModel == null) {
      j.t("viewModel");
    }
    localOSDTextSettingViewModel.i().observe(this, new c(this));
    localOSDTextSettingViewModel = this.p0;
    if (localOSDTextSettingViewModel == null) {
      j.t("viewModel");
    }
    localOSDTextSettingViewModel.h().observe(this, new d(this));
    localOSDTextSettingViewModel = this.p0;
    if (localOSDTextSettingViewModel == null) {
      j.t("viewModel");
    }
    localOSDTextSettingViewModel.j().observe(this, new e(this));
  }
  
  private final void k1()
  {
    setTitle(2131953329);
    View localView = findViewById(2131364275);
    j.d(localView, "findViewById(R.id.toolbar)");
    ((Toolbar)localView).setNavigationOnClickListener(new f(this));
    ((DrawableEditText)e1(a.osd_info_customize_et)).f(this);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    j.e(paramEditable, "s");
    MutableLiveData localMutableLiveData = this.p1;
    boolean bool;
    if (paramEditable.length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localMutableLiveData.postValue(Boolean.valueOf(bool));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    j.e(paramCharSequence, "s");
  }
  
  public View e1(int paramInt)
  {
    if (this.p2 == null) {
      this.p2 = new HashMap();
    }
    View localView1 = (View)this.p2.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.p2.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558596);
    i1();
    k1();
    j1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    j.e(paramMenu, "menu");
    getMenuInflater().inflate(2131623941, paramMenu);
    paramMenu = paramMenu.findItem(2131362300);
    j.d(paramMenu, "menu.findItem(R.id.common_save)");
    this.z = paramMenu;
    if (paramMenu == null) {
      j.t("mSaveMenu");
    }
    paramMenu.setActionView(2131559272);
    paramMenu = this.z;
    if (paramMenu == null) {
      j.t("mSaveMenu");
    }
    paramMenu = (MenuSaveBinding)DataBindingUtil.bind(paramMenu.getActionView());
    if (paramMenu != null)
    {
      paramMenu.setLifecycleOwner(this);
      paramMenu.h(this.p1);
      paramMenu.c.setOnClickListener(new g(this));
    }
    return true;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    j.e(paramCharSequence, "s");
  }
  
  public static final class a
  {
    public final void a(String paramString, Activity paramActivity)
    {
      j.e(paramString, "deviceIdMD5");
      j.e(paramActivity, "context");
      Intent localIntent = new Intent(paramActivity, OSDTextSettingActivity.class);
      localIntent.putExtra("deviceIdMD5", paramString);
      paramString = p.a;
      paramActivity.startActivityForResult(localIntent, 100);
    }
  }
  
  static final class b<T>
    implements Observer<String>
  {
    b(OSDTextSettingActivity paramOSDTextSettingActivity) {}
    
    public final void a(String paramString)
    {
      ((DrawableEditText)this.a.e1(a.osd_info_customize_et)).setText(paramString);
    }
  }
  
  static final class c<T>
    implements Observer<Boolean>
  {
    c(OSDTextSettingActivity paramOSDTextSettingActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      this.a.setResult(100);
      this.a.finish();
    }
  }
  
  static final class d<T>
    implements Observer<Boolean>
  {
    d(OSDTextSettingActivity paramOSDTextSettingActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      paramBoolean = this.a;
      TSnackbar.y(paramBoolean, paramBoolean.getString(2131952741), -1).N();
    }
  }
  
  static final class e<T>
    implements Observer<Boolean>
  {
    e(OSDTextSettingActivity paramOSDTextSettingActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      j.d(paramBoolean, "it");
      if (paramBoolean.booleanValue()) {
        ((CameraLoadingView)this.a.e1(a.live_loading_view)).b();
      } else {
        ((CameraLoadingView)this.a.e1(a.live_loading_view)).a();
      }
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(OSDTextSettingActivity paramOSDTextSettingActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.onBackPressed();
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(OSDTextSettingActivity paramOSDTextSettingActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = OSDTextSettingActivity.f1(this.c);
      Object localObject = this.c;
      int i = a.osd_info_customize_et;
      localObject = (DrawableEditText)((OSDTextSettingActivity)localObject).e1(i);
      j.d(localObject, "osd_info_customize_et");
      if (paramView.g(((DrawableEditText)localObject).getText().toString()))
      {
        OSDTextSettingActivity.g1(this.c);
        paramView = (DrawableEditText)this.c.e1(i);
        j.d(paramView, "osd_info_customize_et");
        paramView = paramView.getText();
        j.d(paramView, "osd_info_customize_et.text");
        int j;
        if (paramView.length() == 0) {
          j = 1;
        } else {
          j = 0;
        }
        if (j != 0)
        {
          paramView = " ";
        }
        else
        {
          paramView = (DrawableEditText)this.c.e1(i);
          j.d(paramView, "osd_info_customize_et");
          paramView = paramView.getText();
        }
        OSDTextSettingActivity.f1(this.c).m(paramView.toString());
      }
      else
      {
        paramView = this.c;
        TSnackbar.y(paramView, paramView.getString(2131953330), -1).N();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\OSDTextSettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */