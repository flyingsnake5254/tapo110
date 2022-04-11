package com.tplink.iot.view.login;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV3.d;
import com.tplink.iot.Utils.login.CloudRegionCode;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.widget.skin.SkinCompatWordIndexView;
import com.tplink.iot.widget.skin.SkinCompatWordIndexView.a;
import f.a.f.a.d;
import java.util.ArrayList;
import java.util.List;

public class CloudRegionChooseActivity
  extends BaseActivity
{
  private RecyclerView H3;
  private SkinCompatWordIndexView I3;
  private RegionListNewAdapter J3;
  @BindView
  Toolbar mToolbar;
  private String p0 = "";
  private boolean p1;
  private TextView p2;
  private EditText p3;
  private List<com.tplink.iot.j.b.a> y = new ArrayList();
  private String z = "";
  
  private void k1(String paramString)
  {
    if (paramString.isEmpty())
    {
      this.J3.r(this.y, true);
      if (com.tplink.iot.Utils.login.a.e(getApplicationContext())) {
        this.I3.setVisibility(0);
      }
      findViewById(2131363834).setVisibility(8);
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; i < this.y.size(); i++)
      {
        com.tplink.iot.j.b.a locala = (com.tplink.iot.j.b.a)this.y.get(i);
        if (com.tplink.iot.j.b.a.e(locala.b()).toLowerCase().contains(paramString.toLowerCase())) {
          localArrayList.add(locala);
        }
      }
      this.J3.r(localArrayList, false);
      if (com.tplink.iot.Utils.login.a.e(getApplicationContext())) {
        this.I3.setVisibility(8);
      }
      if (localArrayList.isEmpty()) {
        findViewById(2131363834).setVisibility(0);
      } else {
        findViewById(2131363834).setVisibility(8);
      }
    }
  }
  
  private void l1()
  {
    s1();
    if (this.y.size() != 0)
    {
      Object localObject = new RegionListNewAdapter(this, new c());
      this.J3 = ((RegionListNewAdapter)localObject);
      ((RegionListNewAdapter)localObject).r(this.y, true);
      this.H3.setAdapter(this.J3);
      if (!TextUtils.isEmpty(this.z))
      {
        localObject = com.tplink.iot.Utils.login.a.c(this, this.z);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.J3.s((String)localObject);
          ((LinearLayoutManager)this.H3.getLayoutManager()).scrollToPositionWithOffset(this.J3.p(), 0);
        }
      }
    }
  }
  
  private void m1()
  {
    p1();
    if (this.p1) {
      this.mToolbar.setNavigationIcon(2131689570);
    }
    this.H3 = ((RecyclerView)findViewById(2131363833));
    Object localObject = (EditText)findViewById(2131363835);
    this.p3 = ((EditText)localObject);
    ((EditText)localObject).addTextChangedListener(new a());
    localObject = (SkinCompatWordIndexView)findViewById(2131363836);
    this.I3 = ((SkinCompatWordIndexView)localObject);
    ((SkinCompatWordIndexView)localObject).setOnTouchingLetterChangedListener(new b());
    if (com.tplink.iot.Utils.login.a.e(getApplicationContext())) {
      this.I3.setVisibility(0);
    }
  }
  
  private void n1()
  {
    b.d.w.f.a.g(this);
    Intent localIntent = new Intent();
    localIntent.putExtra("REGION_CODE", this.z);
    setResult(-1, localIntent);
    finish();
  }
  
  private void o1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      String str = localIntent.getStringExtra("REGION_CODE");
      this.p0 = str;
      this.z = str;
      this.p1 = localIntent.getBooleanExtra("args_is_from_dashboard", false);
    }
  }
  
  private void p1()
  {
    if ((!d.e().o()) && (Build.VERSION.SDK_INT >= 23))
    {
      View localView = getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xDFFF);
    }
  }
  
  private void q1()
  {
    new TPMaterialDialogV3.Builder(this).f(getString(2131953649)).b(false).c(false).h(2131952391, 2131099804, null).j(2131952434, 2131099808, new f()).a().show();
  }
  
  private void r1(boolean paramBoolean)
  {
    TextView localTextView = this.p2;
    if (localTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      localTextView.setEnabled(true);
      this.p2.setTextColor(getResources().getColor(2131099808));
    }
    else
    {
      localTextView.setEnabled(false);
      this.p2.setTextColor(getResources().getColor(2131099807));
    }
  }
  
  private void s1()
  {
    for (CloudRegionCode localCloudRegionCode : )
    {
      com.tplink.iot.j.b.a locala = new com.tplink.iot.j.b.a(localCloudRegionCode.getRegionCode(), getString(localCloudRegionCode.getResId()), false);
      Object localObject = this.y;
      ((List)localObject).add(((List)localObject).size(), locala);
      localObject = this.z;
      if ((localObject != null) && (((String)localObject).equals(localCloudRegionCode.getRegionCode())))
      {
        locala.d(true);
        r1(true);
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.p1) {
      q1();
    } else if (!this.p0.equalsIgnoreCase(this.z)) {
      new TPMaterialDialogV3.Builder(this).f(getString(2131952809)).b(false).c(false).h(2131952391, 2131099804, null).j(2131952432, 2131099808, new e()).a().show();
    } else {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558482);
    ButterKnife.a(this);
    o1();
    m1();
    l1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623940, paramMenu);
    paramMenu = paramMenu.findItem(2131362299);
    paramMenu.setActionView(2131559255);
    paramMenu = (TextView)paramMenu.getActionView().findViewById(2131364521);
    this.p2 = paramMenu;
    paramMenu.setText(2131952405);
    this.p2.setOnClickListener(new d());
    paramMenu = this.J3;
    boolean bool;
    if ((paramMenu != null) && (paramMenu.p() >= 0)) {
      bool = true;
    } else {
      bool = false;
    }
    r1(bool);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() != 16908332) {
      return super.onOptionsItemSelected(paramMenuItem);
    }
    b.d.w.f.a.g(this);
    onBackPressed();
    return true;
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      CloudRegionChooseActivity.e1(CloudRegionChooseActivity.this, paramCharSequence.toString());
    }
  }
  
  class b
    implements SkinCompatWordIndexView.a
  {
    b() {}
    
    public void a(String paramString)
    {
      int i = CloudRegionChooseActivity.f1(CloudRegionChooseActivity.this).q(paramString);
      if (i >= 0) {
        ((LinearLayoutManager)CloudRegionChooseActivity.g1(CloudRegionChooseActivity.this).getLayoutManager()).scrollToPositionWithOffset(i, 0);
      }
    }
  }
  
  class c
    implements RegionListNewAdapter.c
  {
    c() {}
    
    public void a(String paramString1, String paramString2)
    {
      CloudRegionChooseActivity.h1(CloudRegionChooseActivity.this, paramString2);
      CloudRegionChooseActivity.f1(CloudRegionChooseActivity.this).s(paramString1);
      CloudRegionChooseActivity.i1(CloudRegionChooseActivity.this, true);
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      CloudRegionChooseActivity.j1(CloudRegionChooseActivity.this);
    }
  }
  
  class e
    implements TPMaterialDialogV3.d
  {
    e() {}
    
    public void onClick(View paramView)
    {
      CloudRegionChooseActivity.this.finish();
    }
  }
  
  class f
    implements TPMaterialDialogV3.d
  {
    f() {}
    
    public void onClick(View paramView)
    {
      CloudRegionChooseActivity.this.setResult(101);
      CloudRegionChooseActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\login\CloudRegionChooseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */