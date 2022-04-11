package com.tplink.iot.view.ipcamera.memories;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore.Images.Media;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityMemoriesImageBinding;
import com.tplink.iot.databinding.DialogMemoryBottomOperationBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;
import com.tplink.libtpmediaother.memory.MemoryBean;
import com.tplink.libtpmediaother.memory.r;
import com.tplink.libtpnetwork.Utils.j;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.AppSettingsDialog.b;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.d.f;

public class MemoriesImageActivity
  extends BaseActivity
  implements g, EasyPermissions.PermissionCallbacks, d.f
{
  private MemoryBean p0;
  private ActivityMemoriesImageBinding y;
  private MemoriesViewModel z;
  
  private boolean f1()
  {
    return EasyPermissions.a(this, com.tplink.iot.Utils.a1.b.a());
  }
  
  private void g1()
  {
    final MemoryDeleteDialogFragment localMemoryDeleteDialogFragment = MemoryDeleteDialogFragment.A0();
    localMemoryDeleteDialogFragment.B0(new a(localMemoryDeleteDialogFragment));
    localMemoryDeleteDialogFragment.show(getSupportFragmentManager(), "MemoryDeleteDialogFragment");
  }
  
  private void h1()
  {
    this.z.h(this.p0);
  }
  
  private void i1()
  {
    if (this.z.h.get())
    {
      this.p0.setMark(true);
      this.z.y(this.p0);
    }
    else
    {
      this.p0.setMark(false);
      this.z.y(this.p0);
    }
  }
  
  private void k1()
  {
    this.z.g.set(true);
    this.z.f.set(true);
    this.z.d.set(true);
    this.z.e.set(true);
    this.z.j.set(this.p0.getDeviceAlias());
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(Long.valueOf(this.p0.getTimestamp()));
    this.z.k.set(str);
    r1(this.y.q);
    r1(this.y.f);
    this.z.h.set(this.p0.isMark());
  }
  
  private void p1(int paramInt, String paramString)
  {
    EasyPermissions.f(this, paramString, paramInt, com.tplink.iot.Utils.a1.b.a());
  }
  
  private void q1()
  {
    Toolbar localToolbar = this.y.x;
    setSupportActionBar(localToolbar);
    localToolbar.setNavigationOnClickListener(new f(this));
  }
  
  private void r1(PhotoView paramPhotoView)
  {
    Bitmap localBitmap = BitmapFactory.decodeFile(this.p0.getThumbnailPath());
    uk.co.senab.photoview.d locald = new uk.co.senab.photoview.d(paramPhotoView);
    paramPhotoView.setImageBitmap(localBitmap);
    locald.Q(this);
    locald.c0();
  }
  
  private void s1()
  {
    Object localObject1 = new File(this.p0.getThumbnailPath());
    if (((File)localObject1).exists())
    {
      Object localObject2 = Uri.fromFile((File)localObject1);
      if ((Build.VERSION.SDK_INT >= 20) && ("file".equals(((Uri)localObject2).getScheme()))) {
        localObject1 = FileProvider.getUriForFile(this, b.d.q.b.p.b.n().concat(".provider"), (File)localObject1);
      } else {
        localObject1 = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setAction("android.intent.action.SEND");
      ((Intent)localObject2).putExtra("android.intent.extra.STREAM", (Parcelable)localObject1);
      ((Intent)localObject2).setType("image/*");
      startActivity(Intent.createChooser((Intent)localObject2, getString(2131953082)));
    }
  }
  
  private void t1()
  {
    j.c(this.z.q, this, new e(this));
  }
  
  private void u1()
  {
    int i;
    if ((!this.z.l.get()) && (!this.z.m.get())) {
      i = 0;
    } else {
      i = 1;
    }
    int j = 1792;
    int k = Build.VERSION.SDK_INT;
    if (k >= 23) {
      j = 9984;
    }
    int m = j;
    if (k >= 19) {
      m = j | 0x1000;
    }
    j = m;
    if (i != 0) {
      j = m | 0x6;
    }
    getWindow().getDecorView().setSystemUiVisibility(j);
    Object localObject;
    if (i != 0)
    {
      localObject = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).flags |= 0x400;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      getWindow().addFlags(512);
    }
    else
    {
      localObject = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).flags &= 0xFBFF;
      getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      getWindow().clearFlags(512);
    }
    if (i == 0)
    {
      localObject = (ViewGroup.MarginLayoutParams)this.y.p0.c.getLayoutParams();
      m = com.tplink.iot.view.quicksetup.base.d.j(this);
      j = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
      if (j < m) {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (j + m);
      }
      this.y.p0.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void E0(int paramInt, List<String> paramList)
  {
    if (2 == paramInt) {
      h1();
    }
  }
  
  public void R() {}
  
  public void a0(View paramView, float paramFloat1, float paramFloat2)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364065: 
    case 2131364066: 
      paramView = this.z.m;
      paramView.set(paramView.get() ^ true);
      u1();
    }
  }
  
  public void j1()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("MemoryDelete", false);
    localIntent.putExtra("MemoryBean", this.p0);
    setResult(1012, localIntent);
    finish();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((3 == paramInt1) && (f1())) {
      h1();
    }
  }
  
  public void onBackPressed()
  {
    j1();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363124: 
    case 2131364626: 
      s1();
      com.tplink.iot.Utils.x0.e.x();
      break;
    case 2131363047: 
    case 2131364458: 
      paramView = this.z.h;
      paramView.set(paramView.get() ^ true);
      i1();
      break;
    case 2131363038: 
    case 2131364424: 
      if (f1()) {
        h1();
      } else {
        p1(2, getString(2131953355));
      }
      break;
    case 2131363025: 
    case 2131364400: 
      g1();
      break;
    case 2131361999: 
      onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    ObservableBoolean localObservableBoolean = this.z.l;
    boolean bool;
    if (paramConfiguration.orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    localObservableBoolean.set(bool);
    u1();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(128, 128);
    this.y = ((ActivityMemoriesImageBinding)DataBindingUtil.setContentView(this, 2131558580));
    ((ViewGroup.MarginLayoutParams)findViewById(2131364275).getLayoutParams()).topMargin = com.tplink.iot.view.quicksetup.base.d.A(this);
    com.tplink.iot.view.quicksetup.base.d.d(this);
    com.tplink.iot.view.quicksetup.base.d.K(this);
    this.z = ((MemoriesViewModel)ViewModelProviders.of(this).get(MemoriesViewModel.class));
    this.y.i(this);
    this.y.h(this.z);
    if (getIntent() != null)
    {
      paramBundle = getIntent().getExtras();
      Objects.requireNonNull(paramBundle);
      this.p0 = ((MemoryBean)((Bundle)paramBundle).getSerializable("MemoryBean"));
    }
    else
    {
      this.p0 = new MemoryBean();
    }
    q1();
    k1();
    setRequestedOrientation(2);
    t1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (16908332 == paramMenuItem.getItemId())
    {
      onBackPressed();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    EasyPermissions.d(paramInt, paramArrayOfString, paramArrayOfInt, new Object[] { this });
  }
  
  public void t(int paramInt, List<String> paramList)
  {
    if (2 == paramInt) {
      paramInt = 3;
    } else {
      paramInt = -1;
    }
    new AppSettingsDialog.b(this).d(2131953354).c(2131952441).b(2131952391).e(paramInt).a().d();
  }
  
  class a
    implements MemoryDeleteDialogFragment.a
  {
    a(MemoryDeleteDialogFragment paramMemoryDeleteDialogFragment) {}
    
    public void a()
    {
      localMemoryDeleteDialogFragment.dismiss();
    }
    
    public void b()
    {
      localMemoryDeleteDialogFragment.dismiss();
      Intent localIntent = new Intent();
      localIntent.putExtra("MemoryDelete", true);
      r.f().E(MemoriesImageActivity.e1(MemoriesImageActivity.this));
      MemoriesImageActivity.this.setResult(1012, localIntent);
      MemoriesImageActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\MemoriesImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */