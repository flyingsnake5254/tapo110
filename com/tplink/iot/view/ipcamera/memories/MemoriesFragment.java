package com.tplink.iot.view.ipcamera.memories;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tplink.iot.Utils.x0.e;
import com.tplink.iot.adapter.home.HomeMainSpaceItemDecoration;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.DialogMemoryBottomOperationBinding;
import com.tplink.iot.databinding.FragmentPhotosBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.memories.filter.MemoriesFilterActivity;
import com.tplink.iot.view.ipcamera.memories.filter.MemoriesFilterBean;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesViewModel;
import com.tplink.libtpmediaother.memory.MemoryBean;
import com.tplink.libtpmediaother.memory.r.d;
import com.tplink.libtpnetwork.Utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.AppSettingsDialog.b;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks;

public class MemoriesFragment
  extends BaseFragment
  implements MemoriesAdapter.b, MemoriesAdapter.d, MemoriesAdapter.c, g, EasyPermissions.PermissionCallbacks
{
  private Animation p0;
  private Animation p1;
  private int p2 = -1;
  private c p3;
  private FragmentPhotosBinding q;
  private MemoriesAdapter x;
  private MemoriesViewModel y;
  private MemoriesFilterBean z = new MemoriesFilterBean();
  
  private boolean L0()
  {
    return EasyPermissions.a(requireContext(), com.tplink.iot.Utils.a1.b.a());
  }
  
  private void P0()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    this.p0 = localTranslateAnimation;
    localTranslateAnimation.setDuration(300L);
    this.p0.setFillAfter(true);
    localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.p1 = localTranslateAnimation;
    localTranslateAnimation.setFillAfter(false);
    this.p1.setDuration(300L);
  }
  
  private void Q0()
  {
    Object localObject = new MemoriesAdapter(getActivity());
    this.x = ((MemoriesAdapter)localObject);
    ((MemoriesAdapter)localObject).I(this);
    this.x.L(this);
    this.x.K(this);
    P0();
    localObject = new GridLayoutManager(getContext(), 2);
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.q.q.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new HomeMainSpaceItemDecoration(getActivity(), 4);
    this.q.q.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    this.q.q.setAdapter(this.x);
  }
  
  private void R0()
  {
    this.y.o.set(true);
  }
  
  private void X0() {}
  
  private void Y0()
  {
    int i = this.x.y();
    c localc = this.p3;
    if (localc != null) {
      localc.k(i);
    }
    if (i == 0)
    {
      this.y.d.set(false);
      this.y.e.set(false);
      this.y.f.set(false);
      this.y.g.set(false);
      this.q.z.c.setAlpha(0.6F);
    }
    else
    {
      this.y.d.set(true);
      this.y.e.set(true);
      this.y.f.set(true);
      this.y.g.set(true);
      this.q.z.c.setAlpha(1.0F);
    }
  }
  
  private void Z0()
  {
    if (this.z == null) {
      this.z = new MemoriesFilterBean();
    }
    if (this.z.isSelectAll())
    {
      this.y.w();
      return;
    }
    r.d locald = new r.d();
    if (this.z.getOnlyDeviceName().size() > 0) {
      locald.c(this.z.getOnlyDeviceName());
    }
    if (this.z.isOnlyLike()) {
      locald.f(Boolean.TRUE);
    }
    if (this.z.isOnlyUnLick()) {
      locald.h(Boolean.TRUE);
    }
    if (this.z.isHasVideo()) {
      locald.i(Boolean.TRUE);
    }
    if (this.z.isHasPicture()) {
      locald.g(Boolean.TRUE);
    }
    if (this.z.isHasCloudVideo()) {
      locald.e(Boolean.TRUE);
    }
    if (this.z.getDesignatedDeviceidMD5() != null) {
      locald.d(this.z.getDesignatedDeviceidMD5());
    }
    this.y.x(locald);
  }
  
  private void a1(int paramInt, String paramString)
  {
    EasyPermissions.h(this, paramString, paramInt, com.tplink.iot.Utils.a1.b.a());
  }
  
  private void b1()
  {
    if (!this.y.c.get())
    {
      ObservableBoolean localObservableBoolean = this.y.c;
      localObservableBoolean.set(localObservableBoolean.get() ^ true);
    }
    this.y.h.set(this.x.w());
    Y0();
  }
  
  private void e1()
  {
    this.y.i().observe(getViewLifecycleOwner(), new a());
    j.c(this.y.q, this, new d(this));
  }
  
  public void E0(int paramInt, List<String> paramList)
  {
    if (4 == paramInt)
    {
      this.x.q();
      K0();
    }
  }
  
  public void K0()
  {
    Object localObject = this.x;
    if (localObject != null) {
      ((MemoriesAdapter)localObject).H(false);
    }
    localObject = this.y;
    if (localObject != null)
    {
      localObject = ((MemoriesViewModel)localObject).c;
      if (localObject != null) {
        ((ObservableBoolean)localObject).set(false);
      }
    }
    localObject = this.p3;
    if (localObject != null) {
      ((c)localObject).T();
    }
  }
  
  public void N0()
  {
    MemoriesAdapter localMemoriesAdapter = this.x;
    if ((localMemoriesAdapter != null) && (localMemoriesAdapter.getItemCount() > 0))
    {
      if (!this.x.x()) {
        this.x.H(true);
      } else if (this.x.v()) {
        this.x.n();
      } else {
        this.x.G();
      }
      b1();
    }
  }
  
  public void O0()
  {
    d1();
    K0();
  }
  
  public void R(List<MemoryBean> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    this.y.g(paramList);
  }
  
  public boolean S0()
  {
    MemoriesAdapter localMemoriesAdapter = this.x;
    boolean bool;
    if ((localMemoriesAdapter != null) && (localMemoriesAdapter.x())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean T0()
  {
    MemoriesAdapter localMemoriesAdapter = this.x;
    boolean bool;
    if ((localMemoriesAdapter != null) && (localMemoriesAdapter.x()) && (this.x.v())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void W0()
  {
    if (getContext() == null) {
      return;
    }
    if (this.y != null) {
      Z0();
    }
  }
  
  public void Z(View paramView, int paramInt, MemoryBean paramMemoryBean)
  {
    if (!this.y.c.get())
    {
      paramView = this.y.c;
      paramView.set(paramView.get() ^ true);
    }
    this.y.d.set(true);
    this.y.e.set(true);
    this.y.f.set(true);
    this.y.g.set(true);
    this.y.h.set(this.x.w());
    Y0();
  }
  
  public void c1(c paramc)
  {
    this.p3 = paramc;
  }
  
  public boolean d()
  {
    if (this.y.c.get())
    {
      K0();
      return false;
    }
    return super.d();
  }
  
  public void d1()
  {
    Object localObject = getActivity();
    if (localObject != null)
    {
      localObject = new Intent((Context)localObject, MemoriesFilterActivity.class);
      ((Intent)localObject).putExtra("memories_filter_bean", this.z);
      startActivityForResult((Intent)localObject, 1013);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1011) && (paramInt2 == 1012))
    {
      if (this.p2 != -1)
      {
        if (paramIntent.getBooleanExtra("MemoryDelete", false))
        {
          this.x.p(this.p2);
        }
        else
        {
          paramIntent = (MemoryBean)paramIntent.getSerializableExtra("MemoryBean");
          if (paramIntent != null) {
            this.x.E(paramIntent, this.p2);
          }
        }
        this.p2 = -1;
      }
    }
    else if ((paramInt1 == 1013) && (paramInt2 == 1014))
    {
      paramIntent = (MemoriesFilterBean)paramIntent.getSerializableExtra("memories_filter_bean");
      if (paramIntent != null) {
        this.z = paramIntent.clone();
      }
    }
    else if ((5 == paramInt1) && (L0()))
    {
      this.x.q();
      K0();
    }
  }
  
  public void onClick(final View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364626: 
      X0();
      this.x.M();
      K0();
      break;
    case 2131364458: 
      paramView = this.y.h;
      paramView.set(paramView.get() ^ true);
      this.x.D(this.y.h.get());
      K0();
      break;
    case 2131364424: 
      if (L0())
      {
        this.x.q();
        K0();
      }
      else
      {
        a1(4, getString(2131953355));
      }
      break;
    case 2131364400: 
      paramView = MemoryDeleteDialogFragment.A0();
      paramView.B0(new b(paramView));
      paramView.show(getChildFragmentManager(), "MemoryDeleteDialogFragment");
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.q = ((FragmentPhotosBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558941, paramViewGroup, false));
    paramLayoutInflater = (MemoriesViewModel)ViewModelProviders.of(this).get(MemoriesViewModel.class);
    this.y = paramLayoutInflater;
    paramLayoutInflater.c.set(false);
    this.q.i(this);
    this.q.h(this.y);
    Q0();
    R0();
    e1();
    return this.q.getRoot();
  }
  
  public void onDataChanged()
  {
    if (this.x.getItemCount() <= 0) {
      this.y.i.set(true);
    } else {
      this.y.i.set(false);
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    EasyPermissions.d(paramInt, paramArrayOfString, paramArrayOfInt, new Object[] { this });
  }
  
  public void onResume()
  {
    super.onResume();
    Z0();
  }
  
  public void s(View paramView, int paramInt, MemoryBean paramMemoryBean)
  {
    this.p2 = paramInt;
    if (paramMemoryBean.getVideoPath() == null)
    {
      paramView = new Intent(getActivity(), MemoriesImageActivity.class);
      paramView.putExtra("MemoryBean", paramMemoryBean);
    }
    else
    {
      paramView = new Intent(getActivity(), MemoriesVideoPlayActivity.class);
      paramView.putExtra("MemoryBean", paramMemoryBean);
    }
    startActivityForResult(paramView, 1011);
  }
  
  public void setArguments(@Nullable Bundle paramBundle)
  {
    super.setArguments(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("device_id_md5");
      this.z.setDesignatedDeviceidMD5(paramBundle);
    }
  }
  
  public void t(int paramInt, List<String> paramList)
  {
    if (4 == paramInt) {
      paramInt = 5;
    } else {
      paramInt = -1;
    }
    new AppSettingsDialog.b(this).d(2131953354).c(2131952441).b(2131952391).e(paramInt).a().d();
  }
  
  public void v(List<MemoryBean> paramList)
  {
    if (paramList.isEmpty()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (MemoryBean)localIterator.next();
      int i = 0;
      if (paramList.getVideoPath() == null)
      {
        paramList = paramList.getThumbnailPath();
        i = 1;
      }
      else
      {
        paramList = paramList.getVideoPath();
      }
      paramList = new File(paramList);
      if (paramList.exists())
      {
        Object localObject;
        if (i != 0)
        {
          localObject = Uri.fromFile(paramList);
          if ((Build.VERSION.SDK_INT >= 20) && ("file".equals(((Uri)localObject).getScheme())))
          {
            localObject = b.d.q.b.p.b.n().concat(".provider");
            try
            {
              paramList = FileProvider.getUriForFile(requireContext(), (String)localObject, paramList);
            }
            catch (IllegalArgumentException paramList)
            {
              paramList.printStackTrace();
              return;
            }
          }
          else
          {
            paramList = requireContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
          }
          localArrayList.add(paramList);
        }
        else
        {
          localObject = Uri.fromFile(paramList);
          if ((Build.VERSION.SDK_INT >= 20) && ("file".equals(((Uri)localObject).getScheme())))
          {
            localObject = b.d.q.b.p.b.n().concat(".provider");
            try
            {
              paramList = FileProvider.getUriForFile(requireContext(), (String)localObject, paramList);
            }
            catch (IllegalArgumentException paramList)
            {
              paramList.printStackTrace();
              return;
            }
          }
          else
          {
            paramList = requireContext().getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new ContentValues());
          }
          localArrayList.add(paramList);
        }
      }
    }
    if (localArrayList.isEmpty()) {
      return;
    }
    paramList = new Intent("android.intent.action.SEND_MULTIPLE");
    paramList.setType("*/*");
    paramList.putParcelableArrayListExtra("android.intent.extra.STREAM", localArrayList);
    startActivity(paramList);
  }
  
  public void w0(int paramInt, MemoryBean paramMemoryBean)
  {
    this.y.d.set(this.x.u());
    this.y.e.set(this.x.u());
    this.y.f.set(this.x.u());
    this.y.g.set(this.x.u());
    this.y.h.set(this.x.w());
    Y0();
  }
  
  class a
    implements Observer<List<MemoryBean>>
  {
    a() {}
    
    public void a(@Nullable List<MemoryBean> paramList)
    {
      MemoriesFragment.H0(MemoriesFragment.this).o.set(false);
      if (paramList != null) {
        MemoriesFragment.I0(MemoriesFragment.this).J(paramList);
      }
    }
  }
  
  class b
    implements MemoryDeleteDialogFragment.a
  {
    b(MemoryDeleteDialogFragment paramMemoryDeleteDialogFragment) {}
    
    public void a()
    {
      paramView.dismiss();
    }
    
    public void b()
    {
      paramView.dismiss();
      MemoriesFragment.I0(MemoriesFragment.this).o();
      MemoriesFragment.J0(MemoriesFragment.this);
      MemoriesFragment.H0(MemoriesFragment.this).d.set(false);
      MemoriesFragment.H0(MemoriesFragment.this).g.set(false);
      MemoriesFragment.H0(MemoriesFragment.this).e.set(false);
      MemoriesFragment.H0(MemoriesFragment.this).f.set(false);
      MemoriesFragment.this.K0();
    }
  }
  
  public static abstract interface c
  {
    public abstract void T();
    
    public abstract void k(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\memories\MemoriesFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */