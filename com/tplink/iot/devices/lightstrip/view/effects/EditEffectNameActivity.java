package com.tplink.iot.devices.lightstrip.view.effects;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityEditEffectsNameBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.widget.DrawableEditText;
import java.nio.charset.Charset;
import java.util.Objects;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.d;

public final class EditEffectNameActivity
  extends IoTMVVMBaseActivity<ActivityEditEffectsNameBinding>
  implements TextWatcher
{
  public static final a p0 = new a(null);
  private String H3 = "";
  private MenuItem p1;
  private final f p2 = h.b(new b(this));
  private CharSequence p3;
  
  private final DrawableEditText o1()
  {
    return (DrawableEditText)this.p2.getValue();
  }
  
  private final void p1()
  {
    String str = o1().getText().toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("EffectName", str);
    setResult(-1, localIntent);
    finish();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    j.e(paramEditable, "s");
    Object localObject1 = this.p3;
    if (localObject1 == null) {
      localObject1 = "";
    }
    String str = localObject1.toString();
    Object localObject2 = d.a;
    Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
    localObject2 = str.getBytes((Charset)localObject2);
    j.d(localObject2, "(this as java.lang.String).getBytes(charset)");
    int i = localObject2.length;
    boolean bool1 = true;
    if (i > 64)
    {
      paramEditable.delete(((CharSequence)localObject1).length() - 1, ((CharSequence)localObject1).length());
      o1().setText(paramEditable);
      o1().setSelection(paramEditable.length());
    }
    localObject1 = this.p1;
    if (localObject1 != null)
    {
      if (paramEditable.toString().length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (this.H3.length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        bool2 = bool1;
        if (i != 0) {
          break label201;
        }
        if ((j.a(this.H3, paramEditable.toString()) ^ true))
        {
          bool2 = bool1;
          break label201;
        }
      }
      boolean bool2 = false;
      label201:
      ((MenuItem)localObject1).setEnabled(bool2);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public int e1()
  {
    return 2131558513;
  }
  
  public void h1()
  {
    super.h1();
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("EffectName");
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    this.H3 = ((String)localObject);
    this.p3 = ((CharSequence)localObject);
  }
  
  public void j1()
  {
    o1().m();
    o1().f(this);
    int i;
    if (this.H3.length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      l.m(o1(), this.H3);
    }
  }
  
  public void m1() {}
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623954, paramMenu);
    String str = null;
    Object localObject1 = null;
    Object localObject2 = str;
    if (paramMenu != null)
    {
      MenuItem localMenuItem = paramMenu.findItem(2131361892);
      localObject2 = str;
      if (localMenuItem != null)
      {
        localObject2 = this.p3;
        boolean bool1 = false;
        int i;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          i = 0;
        } else {
          i = 1;
        }
        boolean bool2 = bool1;
        if (i == 0)
        {
          if (this.H3.length() == 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            str = this.H3;
            CharSequence localCharSequence = this.p3;
            localObject2 = localObject1;
            if (localCharSequence != null) {
              localObject2 = localCharSequence.toString();
            }
            bool2 = bool1;
            if (!(j.a(str, localObject2) ^ true)) {}
          }
          else
          {
            bool2 = true;
          }
        }
        localMenuItem.setEnabled(bool2);
        localObject2 = p.a;
        localObject2 = localMenuItem;
      }
    }
    this.p1 = ((MenuItem)localObject2);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    j.e(paramMenuItem, "item");
    if (paramMenuItem.getItemId() == 2131361892)
    {
      p1();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.p3 = paramCharSequence;
  }
  
  public static final class a
  {
    public final Intent a(Context paramContext, String paramString)
    {
      j.e(paramContext, "context");
      paramContext = new Intent(paramContext, EditEffectNameActivity.class);
      paramContext.putExtra("EffectName", paramString);
      return paramContext;
    }
  }
  
  static final class b
    extends Lambda
    implements a<DrawableEditText>
  {
    b(EditEffectNameActivity paramEditEffectNameActivity)
    {
      super();
    }
    
    public final DrawableEditText a()
    {
      DrawableEditText localDrawableEditText = EditEffectNameActivity.n1(this.c).c;
      j.d(localDrawableEditText, "mBinding.editEffectName");
      return localDrawableEditText;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\effects\EditEffectNameActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */