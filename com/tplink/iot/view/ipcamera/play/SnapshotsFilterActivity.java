package com.tplink.iot.view.ipcamera.play;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.tplink.iot.a;
import com.tplink.iot.base.BaseActivity;
import java.util.HashMap;
import kotlin.jvm.internal.j;

public final class SnapshotsFilterActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  private int p0;
  private HashMap p1;
  private CompoundButton[] z;
  
  private final void h1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.p0 = localIntent.getIntExtra("arg_snapshots_filter", 0);
    }
  }
  
  private final void i1()
  {
    ((RelativeLayout)e1(a.rl_baby_cry)).setOnClickListener(new b(this));
    ((RelativeLayout)e1(a.rl_human_move)).setOnClickListener(new c(this));
    ((RelativeLayout)e1(a.rl_motion)).setOnClickListener(new d(this));
    ((RelativeLayout)e1(a.rl_area_intrusion)).setOnClickListener(new e(this));
    ((RelativeLayout)e1(a.rl_line_crossing)).setOnClickListener(new f(this));
    ((RelativeLayout)e1(a.rl_camera_tamper)).setOnClickListener(new g(this));
    ((TextView)e1(a.tv_apply)).setOnClickListener(new h(this));
    ((TextView)e1(a.tv_back)).setOnClickListener(new i(this));
  }
  
  private final void j1() {}
  
  private final void k1()
  {
    Object localObject1 = new CompoundButton[6];
    Object localObject2 = (CheckBox)e1(a.cb_motion);
    j.d(localObject2, "cb_motion");
    boolean bool1 = false;
    localObject1[0] = localObject2;
    localObject2 = (CheckBox)e1(a.cb_human_move);
    j.d(localObject2, "cb_human_move");
    localObject1[1] = localObject2;
    localObject2 = (RadioButton)e1(a.cb_baby_cry);
    j.d(localObject2, "cb_baby_cry");
    localObject1[2] = localObject2;
    localObject2 = (RadioButton)e1(a.cb_area_intrusion);
    j.d(localObject2, "cb_area_intrusion");
    localObject1[3] = localObject2;
    localObject2 = (RadioButton)e1(a.cb_line_crossing);
    j.d(localObject2, "cb_line_crossing");
    localObject1[4] = localObject2;
    localObject2 = (RadioButton)e1(a.cb_camera_tamper);
    j.d(localObject2, "cb_camera_tamper");
    localObject1[5] = localObject2;
    this.z = ((CompoundButton[])localObject1);
    localObject1 = localObject1[0];
    if ((this.p0 & 0x1) == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((CompoundButton)localObject1).setChecked(bool2);
    localObject1 = this.z;
    if (localObject1 == null) {
      j.t("cbs");
    }
    localObject1 = localObject1[1];
    if ((this.p0 & 0x2) == 2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((CompoundButton)localObject1).setChecked(bool2);
    localObject1 = this.z;
    if (localObject1 == null) {
      j.t("cbs");
    }
    localObject1 = localObject1[2];
    if ((this.p0 & 0x4) == 4) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((CompoundButton)localObject1).setChecked(bool2);
    localObject1 = this.z;
    if (localObject1 == null) {
      j.t("cbs");
    }
    localObject1 = localObject1[3];
    if ((this.p0 & 0x8) == 8) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((CompoundButton)localObject1).setChecked(bool2);
    localObject1 = this.z;
    if (localObject1 == null) {
      j.t("cbs");
    }
    localObject1 = localObject1[4];
    if ((this.p0 & 0x10) == 16) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((CompoundButton)localObject1).setChecked(bool2);
    localObject1 = this.z;
    if (localObject1 == null) {
      j.t("cbs");
    }
    localObject1 = localObject1[5];
    boolean bool2 = bool1;
    if ((this.p0 & 0x20) == 32) {
      bool2 = true;
    }
    ((CompoundButton)localObject1).setChecked(bool2);
    n1();
  }
  
  private final void l1(int paramInt)
  {
    Object localObject = this.z;
    if (localObject == null) {
      j.t("cbs");
    }
    localObject = localObject[paramInt];
    CompoundButton[] arrayOfCompoundButton = this.z;
    if (arrayOfCompoundButton == null) {
      j.t("cbs");
    }
    ((CompoundButton)localObject).setChecked(arrayOfCompoundButton[paramInt].isChecked() ^ true);
    n1();
  }
  
  private final void m1()
  {
    Object localObject = this.z;
    if (localObject == null) {
      j.t("cbs");
    }
    int i = localObject.length;
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      localObject = this.z;
      if (localObject == null) {
        j.t("cbs");
      }
      m = k;
      if (localObject[j].isChecked()) {
        m = k + (1 << j);
      }
      j++;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("arg_result", k);
    setResult(-1, (Intent)localObject);
  }
  
  private final void n1()
  {
    Object localObject = this.z;
    if (localObject == null) {
      j.t("cbs");
    }
    int i = localObject.length;
    boolean bool = false;
    int j = 0;
    int m;
    for (int k = 0; j < i; k = m)
    {
      m = k;
      if (localObject[j].isChecked()) {
        m = k + 1;
      }
      j++;
    }
    j = a.tv_apply;
    localObject = (TextView)e1(j);
    j.d(localObject, "tv_apply");
    if (k != 0) {
      bool = true;
    }
    ((TextView)localObject).setEnabled(bool);
    TextView localTextView = (TextView)e1(j);
    localObject = (TextView)e1(j);
    j.d(localObject, "tv_apply");
    if (((TextView)localObject).isEnabled()) {
      k = ContextCompat.getColor(this, 2131099729);
    } else {
      k = ContextCompat.getColor(this, 2131099751);
    }
    localTextView.setTextColor(k);
  }
  
  public View e1(int paramInt)
  {
    if (this.p1 == null) {
      this.p1 = new HashMap();
    }
    View localView1 = (View)this.p1.get(Integer.valueOf(paramInt));
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = findViewById(paramInt);
      this.p1.put(Integer.valueOf(paramInt), localView2);
    }
    return localView2;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558663);
    h1();
    k1();
    i1();
    j1();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, int paramInt)
    {
      j.e(paramContext, "context");
      if ((paramContext instanceof Activity))
      {
        Intent localIntent = new Intent(paramContext, SnapshotsFilterActivity.class);
        localIntent.putExtra("arg_snapshots_filter", paramInt);
        ((Activity)paramContext).startActivityForResult(localIntent, 100);
      }
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(SnapshotsFilterActivity paramSnapshotsFilterActivity) {}
    
    public final void onClick(View paramView)
    {
      SnapshotsFilterActivity.f1(this.c, 2);
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(SnapshotsFilterActivity paramSnapshotsFilterActivity) {}
    
    public final void onClick(View paramView)
    {
      SnapshotsFilterActivity.f1(this.c, 1);
    }
  }
  
  static final class d
    implements View.OnClickListener
  {
    d(SnapshotsFilterActivity paramSnapshotsFilterActivity) {}
    
    public final void onClick(View paramView)
    {
      SnapshotsFilterActivity.f1(this.c, 0);
    }
  }
  
  static final class e
    implements View.OnClickListener
  {
    e(SnapshotsFilterActivity paramSnapshotsFilterActivity) {}
    
    public final void onClick(View paramView)
    {
      SnapshotsFilterActivity.f1(this.c, 3);
    }
  }
  
  static final class f
    implements View.OnClickListener
  {
    f(SnapshotsFilterActivity paramSnapshotsFilterActivity) {}
    
    public final void onClick(View paramView)
    {
      SnapshotsFilterActivity.f1(this.c, 4);
    }
  }
  
  static final class g
    implements View.OnClickListener
  {
    g(SnapshotsFilterActivity paramSnapshotsFilterActivity) {}
    
    public final void onClick(View paramView)
    {
      SnapshotsFilterActivity.f1(this.c, 5);
    }
  }
  
  static final class h
    implements View.OnClickListener
  {
    h(SnapshotsFilterActivity paramSnapshotsFilterActivity) {}
    
    public final void onClick(View paramView)
    {
      SnapshotsFilterActivity.g1(this.c);
      this.c.finish();
    }
  }
  
  static final class i
    implements View.OnClickListener
  {
    i(SnapshotsFilterActivity paramSnapshotsFilterActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\SnapshotsFilterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */