package com.tplink.iot.view.account;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.andexert.library.RippleView;
import com.andexert.library.RippleView.b;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.c;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.a1.b;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.u;
import com.tplink.iot.Utils.x0.p;
import com.tplink.iot.Utils.y0.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.model.about.c;
import com.tplink.iot.viewmodel.account.AccountInfoViewModel;
import com.tplink.iot.viewmodel.account.AccountInfoViewModel.h;
import com.tplink.libtpcontrols.TPCircleMaskView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AccountActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private AccountInfoViewModel H3 = null;
  private TextView p0;
  private TPCircleMaskView p1;
  private TextView p2;
  private File p3 = null;
  private LinearLayout y;
  private TextView z;
  
  private void A1()
  {
    this.H3.p().observe(this, new h());
    this.H3.s().observe(this, new i());
    this.H3.r().observe(this, new j());
    this.H3.u().observe(this, new k());
  }
  
  private void B1()
  {
    Intent localIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    localIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
    startActivityForResult(localIntent, 10);
  }
  
  private void C1()
  {
    Object localObject1 = m1(this);
    if (localObject1 == null)
    {
      s0.p(this, getString(2131952444));
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Long.toString(System.currentTimeMillis()));
    ((StringBuilder)localObject2).append(".jpg");
    localObject2 = new File((File)localObject1, ((StringBuilder)localObject2).toString());
    this.p3 = ((File)localObject2);
    if (Build.VERSION.SDK_INT < 21)
    {
      localObject2 = Uri.fromFile((File)localObject2);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(getApplicationContext().getPackageName());
      ((StringBuilder)localObject2).append(".provider");
      localObject2 = FileProvider.getUriForFile(this, ((StringBuilder)localObject2).toString(), this.p3);
    }
    localObject1 = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject1).putExtra("output", (Parcelable)localObject2);
    startActivityForResult((Intent)localObject1, 11);
  }
  
  @TargetApi(23)
  private boolean l1(List<String> paramList, String paramString)
  {
    if (checkSelfPermission(paramString) != 0)
    {
      paramList.add(paramString);
      return shouldShowRequestPermissionRationale(paramString);
    }
    return true;
  }
  
  public static File m1(@NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramContext = paramContext.getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
    }
    else
    {
      if (!Environment.getExternalStorageState().equals("mounted")) {
        break label59;
      }
      paramContext = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    }
    if ((paramContext != null) && (!paramContext.exists())) {
      paramContext.mkdirs();
    }
    return paramContext;
    label59:
    return null;
  }
  
  private void n1()
  {
    this.y = ((LinearLayout)findViewById(2131361925));
    Toolbar localToolbar = (Toolbar)findViewById(2131364275);
    this.p1 = ((TPCircleMaskView)findViewById(2131361855));
    this.z = ((TextView)findViewById(2131361866));
    this.p0 = ((TextView)findViewById(2131361854));
    RippleView localRippleView1 = (RippleView)findViewById(2131361861);
    RippleView localRippleView2 = (RippleView)findViewById(2131361856);
    this.p2 = ((TextView)findViewById(2131361863));
    setSupportActionBar(localToolbar);
    localToolbar.setTitle(2131952596);
    localRippleView1.setOnRippleCompleteListener(new e());
    localRippleView2.setOnRippleCompleteListener(new f());
    findViewById(2131361859).setOnClickListener(this);
    this.p1.setOnClickListener(this);
    localToolbar.setNavigationOnClickListener(new g());
  }
  
  @TargetApi(23)
  private void o1()
  {
    final ArrayList localArrayList = new ArrayList();
    if (com.tplink.libtpnetwork.Utils.o.h0().m0())
    {
      l1(localArrayList, "android.permission.CAMERA");
      l1(localArrayList, "android.permission.READ_EXTERNAL_STORAGE");
      if (b.c()) {
        l1(localArrayList, "android.permission.WRITE_EXTERNAL_STORAGE");
      }
    }
    else
    {
      if (!l1(localArrayList, "android.permission.CAMERA"))
      {
        w1();
        return;
      }
      if (p1(localArrayList))
      {
        x1();
        return;
      }
    }
    if (!localArrayList.isEmpty()) {
      new TPMaterialDialogV2.Builder(this).s(2131952447, 2131099761).h(2131951705).o(2131952389, 2131099808, new b(localArrayList)).l(2131952391, 2131099804, null).g(8, 8).y();
    } else {
      C1();
    }
  }
  
  private boolean p1(List<String> paramList)
  {
    boolean bool1 = b.c();
    boolean bool2 = true;
    if (bool1)
    {
      bool1 = bool2;
      if (l1(paramList, "android.permission.READ_EXTERNAL_STORAGE")) {
        if (!l1(paramList, "android.permission.WRITE_EXTERNAL_STORAGE")) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return bool1;
    }
    return l1(paramList, "android.permission.READ_EXTERNAL_STORAGE") ^ true;
  }
  
  private void q1(Intent paramIntent)
  {
    this.H3.z(paramIntent.getData(), null);
  }
  
  private void r1()
  {
    this.H3.A(this.p3);
  }
  
  private void s1(String paramString)
  {
    if (!paramString.isEmpty()) {
      this.p1.setImageUrl(paramString);
    } else {
      this.p1.setStrokeWidth(0.0F);
    }
  }
  
  private void t1(TCAccountBean paramTCAccountBean)
  {
    if (paramTCAccountBean != null)
    {
      String str = paramTCAccountBean.getDisplayUserName();
      this.z.setText(str);
      this.p2.setText(str);
      if (!TextUtils.isEmpty(paramTCAccountBean.getEmail())) {
        this.p0.setText(paramTCAccountBean.getEmail());
      } else {
        this.p0.setText(paramTCAccountBean.getCloudUserName());
      }
      paramTCAccountBean = paramTCAccountBean.getAvatarUrl();
      if (paramTCAccountBean != null)
      {
        this.p1.setImageUrl(paramTCAccountBean);
        this.H3.y(paramTCAccountBean);
      }
      else
      {
        s1(this.H3.t());
      }
    }
  }
  
  private void u1(AccountInfoViewModel.h paramh)
  {
    if (paramh == null)
    {
      s0.k(this);
    }
    else
    {
      int i = paramh.a();
      if (i != -1)
      {
        if (i != 0)
        {
          s0.g();
          s0.p(this, getString(2131952444));
        }
        else
        {
          s0.g();
          s0.C(this, "", null);
        }
      }
      else
      {
        this.p1.setImageBitmap(paramh.b());
        s0.l(this);
      }
    }
  }
  
  private void v1()
  {
    new TPMaterialDialogV2.Builder(this).d(2131559111).f(new l()).g(8, 8).y();
  }
  
  private void w1()
  {
    new TPMaterialDialogV2.Builder(this).s(2131952447, 2131099761).h(2131951703).o(2131953327, 2131099808, new c()).l(2131952391, 2131099804, null).g(8, 8).y();
  }
  
  private void x1()
  {
    new TPMaterialDialogV2.Builder(this).s(2131952447, 2131099761).h(2131951706).o(2131953327, 2131099808, new d()).l(2131952391, 2131099804, null).g(8, 8).y();
  }
  
  private void y1()
  {
    new TPMaterialDialogV2.Builder(this).v(2131559149).x(new a()).l(2131952391, 2131099804, null).o(2131952434, 2131099808, new m()).c(true).g(8, 8).y();
  }
  
  private void z1()
  {
    o1();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      return;
    }
    if (paramInt1 != 10)
    {
      if (paramInt1 != 11) {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
      } else {
        r1();
      }
    }
    else {
      q1(paramIntent);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131361855)
    {
      if (i == 2131361859)
      {
        p.j();
        y1();
      }
    }
    else
    {
      this.H3.x();
      p.b();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    setContentView(2131558429);
    StatusBarUtils.n(this, ContextCompat.getColor(this, 2131099771));
    this.H3 = ((AccountInfoViewModel)ViewModelProviders.of(this).get(AccountInfoViewModel.class));
    n1();
    A1();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    if (paramInt != 13)
    {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    else
    {
      int i = 1;
      int j = 1;
      paramInt = 0;
      while (paramInt < paramArrayOfString.length)
      {
        int k;
        int m;
        if ("android.permission.CAMERA".equals(paramArrayOfString[paramInt]))
        {
          k = i;
          m = j;
          if (paramArrayOfInt[paramInt] != 0)
          {
            k = 0;
            m = j;
          }
        }
        else if (!"android.permission.READ_EXTERNAL_STORAGE".equals(paramArrayOfString[paramInt]))
        {
          k = i;
          m = j;
          if (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(paramArrayOfString[paramInt])) {}
        }
        else
        {
          k = i;
          m = j;
          if (paramArrayOfInt[paramInt] != 0)
          {
            m = 0;
            k = i;
          }
        }
        paramInt++;
        i = k;
        j = m;
      }
      if ((i != 0) && (j != 0)) {
        C1();
      } else if (i == 0) {
        w1();
      } else {
        x1();
      }
      com.tplink.libtpnetwork.Utils.o.h0().B0();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  class a
    implements TPMaterialDialogV2.c
  {
    a() {}
    
    public void a(TPMaterialDialogV2 paramTPMaterialDialogV2, View paramView)
    {
      paramTPMaterialDialogV2 = (TextView)paramView.findViewById(2131362440);
      paramTPMaterialDialogV2.setText(2131951731);
      paramTPMaterialDialogV2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 2131689922, 0, 0);
    }
  }
  
  class b
    implements TPMaterialDialogV2.d
  {
    b(List paramList) {}
    
    public void onClick(View paramView)
    {
      AccountActivity localAccountActivity = AccountActivity.this;
      paramView = localArrayList;
      localAccountActivity.requestPermissions((String[])paramView.toArray(new String[paramView.size()]), 13);
    }
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView)
    {
      paramView = new StringBuilder();
      paramView.append("package:");
      paramView.append(AccountActivity.this.getPackageName());
      paramView = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(paramView.toString()));
      AccountActivity.this.startActivity(paramView);
    }
  }
  
  class d
    implements TPMaterialDialogV2.d
  {
    d() {}
    
    public void onClick(View paramView)
    {
      paramView = new StringBuilder();
      paramView.append("package:");
      paramView.append(AccountActivity.this.getPackageName());
      paramView = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(paramView.toString()));
      AccountActivity.this.startActivity(paramView);
    }
  }
  
  class e
    implements RippleView.b
  {
    e() {}
    
    public void j0(RippleView paramRippleView)
    {
      AccountActivity.this.W0(AccountChangeNameActivity.class);
      p.c();
    }
  }
  
  class f
    implements RippleView.b
  {
    f() {}
    
    public void j0(RippleView paramRippleView)
    {
      AccountActivity.this.W0(AccountPasswordVerifyActivity.class);
      p.d();
    }
  }
  
  class g
    implements View.OnClickListener
  {
    g() {}
    
    public void onClick(View paramView)
    {
      AccountActivity.this.finish();
    }
  }
  
  class h
    implements Observer<TCAccountBean>
  {
    h() {}
    
    public void a(@Nullable TCAccountBean paramTCAccountBean)
    {
      AccountActivity.e1(AccountActivity.this, paramTCAccountBean);
    }
  }
  
  class i
    implements Observer<Boolean>
  {
    i() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        AccountActivity.f1(AccountActivity.this);
      } else {
        s0.k(AccountActivity.this);
      }
    }
  }
  
  class j
    implements Observer<AccountInfoViewModel.h>
  {
    j() {}
    
    public void a(@Nullable AccountInfoViewModel.h paramh)
    {
      AccountActivity.g1(AccountActivity.this, paramh);
    }
  }
  
  class k
    implements Observer<Boolean>
  {
    k() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if (paramBoolean == null)
      {
        s0.l(AccountActivity.this);
      }
      else
      {
        s0.g();
        u.a(AccountActivity.this);
        c.c();
        d.a(AppContext.c);
        AccountActivity.this.setResult(-1);
        AccountActivity.this.finish();
      }
    }
  }
  
  class l
    implements TPMaterialDialogV2.c
  {
    l() {}
    
    public void a(final TPMaterialDialogV2 paramTPMaterialDialogV2, View paramView)
    {
      View localView = paramView.findViewById(2131362488);
      paramView = paramView.findViewById(2131362487);
      localView.setOnClickListener(new a(paramTPMaterialDialogV2));
      paramView.setOnClickListener(new b(paramTPMaterialDialogV2));
    }
    
    class a
      implements View.OnClickListener
    {
      a(TPMaterialDialogV2 paramTPMaterialDialogV2) {}
      
      public void onClick(View paramView)
      {
        paramTPMaterialDialogV2.dismiss();
        if (Build.VERSION.SDK_INT >= 23) {
          AccountActivity.h1(AccountActivity.this);
        } else {
          AccountActivity.i1(AccountActivity.this);
        }
      }
    }
    
    class b
      implements View.OnClickListener
    {
      b(TPMaterialDialogV2 paramTPMaterialDialogV2) {}
      
      public void onClick(View paramView)
      {
        paramTPMaterialDialogV2.dismiss();
        AccountActivity.j1(AccountActivity.this);
      }
    }
  }
  
  class m
    implements TPMaterialDialogV2.d
  {
    m() {}
    
    public void onClick(View paramView)
    {
      AccountActivity.k1(AccountActivity.this).w();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\account\AccountActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */