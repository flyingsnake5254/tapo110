package com.tplink.iot.devices.lightstrip.view;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.iot.Utils.extension.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightStripSetLengthBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import java.util.Arrays;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class LightStripSetLengthActivity
  extends IoTMVVMBaseActivity<ActivityLightStripSetLengthBinding>
{
  private final f p0 = h.b(new b(this));
  private boolean p1;
  private int p2;
  private MenuItem p3;
  
  private final void A1(int paramInt)
  {
    float f = t1(paramInt);
    ((ActivityLightStripSetLengthBinding)f1()).c.setText(v1(f));
  }
  
  private final float t1(int paramInt)
  {
    return paramInt * 0.1F;
  }
  
  private final void u1()
  {
    Object localObject = w1();
    boolean bool1 = false;
    if (localObject == null)
    {
      localObject = this.p3;
      if (localObject != null) {
        ((MenuItem)localObject).setEnabled(false);
      }
      return;
    }
    int i = y1(((Float)localObject).floatValue());
    localObject = this.p3;
    if (localObject != null)
    {
      boolean bool2 = bool1;
      if (i != this.p2)
      {
        bool2 = bool1;
        if (i != 0) {
          bool2 = true;
        }
      }
      ((MenuItem)localObject).setEnabled(bool2);
    }
  }
  
  private final String v1(float paramFloat)
  {
    String str = String.format("%.1f", Arrays.copyOf(new Object[] { Float.valueOf(paramFloat) }, 1));
    j.d(str, "java.lang.String.format(this, *args)");
    return str;
  }
  
  private final Float w1()
  {
    Object localObject = ((ActivityLightStripSetLengthBinding)f1()).c;
    j.d(localObject, "mBinding.etStripLength");
    localObject = ((AppCompatEditText)localObject).getText();
    if (localObject != null)
    {
      localObject = localObject.toString();
      if (localObject != null)
      {
        localObject = m.v((String)localObject, ',', '.', false, 4, null);
        if (localObject != null) {
          return m.j((String)localObject);
        }
      }
    }
    localObject = null;
    return (Float)localObject;
  }
  
  private final LightStripSettingsViewModel x1()
  {
    return (LightStripSettingsViewModel)this.p0.getValue();
  }
  
  private final int y1(float paramFloat)
  {
    return kotlin.s.a.b(paramFloat / 0.1F);
  }
  
  private final void z1()
  {
    Object localObject = w1();
    if (localObject == null)
    {
      e.e(this, null, 1, null);
      return;
    }
    int i = y1(((Float)localObject).floatValue());
    if (i > 50)
    {
      localObject = getString(2131952952, new Object[] { Float.valueOf(t1(50)) });
      j.d(localObject, "getString(R.string.light…pUtils.MAXIMUM_SEGMENTS))");
      e.o(this, (String)localObject, null, 2, null);
      return;
    }
    if (i <= 0)
    {
      e.q(this, null, 1, null);
      return;
    }
    x1().J(i).r(io.reactivex.d0.b.a.a()).l(new c(this)).i(new d(this)).j(new e(this)).y();
  }
  
  @LayoutRes
  public int e1()
  {
    return 2131558566;
  }
  
  public void j1()
  {
    b1(2131952949);
    Object localObject = ((ActivityLightStripSetLengthBinding)f1()).f;
    j.d(localObject, "tvStripLengthHint");
    ((TextView)localObject).setText(getString(2131952951, new Object[] { Float.valueOf(t1(50)) }));
    A1(50);
    localObject = ((ActivityLightStripSetLengthBinding)f1()).c;
    ((View)localObject).setPadding(0, ((View)localObject).getPaddingTop(), 0, ((View)localObject).getPaddingBottom());
    ((EditText)localObject).setFilters(new com.tplink.iot.g.b.c.a[] { new com.tplink.iot.g.b.c.a(2, 1) });
    ((TextView)localObject).addTextChangedListener(new a(this));
  }
  
  public void m1()
  {
    x1().C().observe(this, new f(this));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623941, paramMenu);
    MenuItem localMenuItem;
    if (paramMenu != null) {
      localMenuItem = paramMenu.findItem(2131362300);
    } else {
      localMenuItem = null;
    }
    this.p3 = localMenuItem;
    u1();
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131362300)
    {
      z1();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public static final class a
    implements TextWatcher
  {
    public a(LightStripSetLengthActivity paramLightStripSetLengthActivity) {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      LightStripSetLengthActivity.n1(this.c);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<LightStripSettingsViewModel>
  {
    b(LightStripSetLengthActivity paramLightStripSetLengthActivity)
    {
      super();
    }
    
    public final LightStripSettingsViewModel a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, LightStripSetLengthActivity.o1((LightStripSetLengthActivity)localObject))).get(LightStripSettingsViewModel.class);
      j.d(localObject, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
      return (LightStripSettingsViewModel)localObject;
    }
  }
  
  static final class c<T>
    implements g<c>
  {
    c(LightStripSetLengthActivity paramLightStripSetLengthActivity) {}
    
    public final void a(c paramc)
    {
      e.m(this.c, null, 1, null);
    }
  }
  
  static final class d
    implements io.reactivex.g0.a
  {
    d(LightStripSetLengthActivity paramLightStripSetLengthActivity) {}
    
    public final void run()
    {
      e.a();
      this.a.finish();
    }
  }
  
  static final class e<T>
    implements g<Throwable>
  {
    e(LightStripSetLengthActivity paramLightStripSetLengthActivity) {}
    
    public final void a(Throwable paramThrowable)
    {
      e.e(this.c, null, 1, null);
    }
  }
  
  static final class f<T>
    implements Observer<Integer>
  {
    f(LightStripSetLengthActivity paramLightStripSetLengthActivity) {}
    
    public final void a(Integer paramInteger)
    {
      if ((paramInteger != null) && (!LightStripSetLengthActivity.p1(this.a)))
      {
        LightStripSetLengthActivity.r1(this.a, paramInteger.intValue());
        LightStripSetLengthActivity.s1(this.a, paramInteger.intValue());
        LightStripSetLengthActivity.q1(this.a, true);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\LightStripSetLengthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */