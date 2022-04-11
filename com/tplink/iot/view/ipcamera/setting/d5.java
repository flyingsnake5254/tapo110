package com.tplink.iot.view.ipcamera.setting;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tplink.libtpnetwork.cameranetwork.util.e;
import com.tplink.libtpnetwork.cameranetwork.util.h;
import java.util.ArrayList;
import java.util.List;

public class d5
  extends Dialog
{
  public static ArrayList<String> c;
  public static ArrayList<String> d;
  public static ArrayList<String> f;
  public static ArrayList<String> q;
  private k H3;
  private boolean I3;
  private int J3;
  private int K3;
  private j L3;
  private TextView M3;
  private TextView N3;
  private TextView O3;
  private TextView P3;
  private Context p0;
  private ArrayList<l> p1;
  private ArrayList<WheelPicker> p2;
  private i p3;
  private TextView x;
  private String y;
  private boolean z;
  
  static
  {
    Object localObject1 = new ArrayList(3);
    c = (ArrayList)localObject1;
    ((ArrayList)localObject1).add("上午");
    c.add("下午");
    d = new ArrayList(24);
    int i = 0;
    Object localObject2;
    for (int j = 0; j < 24; j++) {
      if (j < 10)
      {
        localObject1 = d;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("0");
        ((StringBuilder)localObject2).append(j);
        ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject1 = d;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(j);
        ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
      }
    }
    f = new ArrayList(12);
    for (j = 0; j < 12; j++) {
      if (j < 10)
      {
        localObject1 = f;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("0");
        ((StringBuilder)localObject2).append(j);
        ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject1 = f;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(j);
        ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
      }
    }
    q = new ArrayList(60);
    for (j = i; j < 60; j++) {
      if (j < 10)
      {
        localObject2 = q;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("0");
        ((StringBuilder)localObject1).append(j);
        ((ArrayList)localObject2).add(((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject1 = q;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(j);
        ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private d5(h paramh)
  {
    super(h.a(paramh), h.b(paramh));
    this.p0 = h.a(paramh);
    this.p1 = h.c(paramh);
    this.y = h.d(paramh);
    this.z = h.e(paramh);
    this.p2 = new ArrayList(this.p1.size());
    this.p3 = h.f(paramh);
    this.I3 = h.g(paramh);
    this.J3 = h.h(paramh);
    this.L3 = h.i(paramh);
    r();
  }
  
  private void p(int paramInt, boolean paramBoolean)
  {
    if ((paramInt == this.K3) && (!paramBoolean)) {
      return;
    }
    this.K3 = paramInt;
    if (this.J3 == 1) {
      paramInt = getContext().getResources().getColor(2131100108);
    } else {
      paramInt = getContext().getResources().getColor(2131099745);
    }
    int i = this.K3;
    if (i != 1)
    {
      if (i == 2)
      {
        h.b(this.M3, getContext().getResources().getColor(2131100188));
        h.b(this.N3, getContext().getResources().getColor(2131100188));
        h.b(this.O3, paramInt);
        h.b(this.P3, paramInt);
      }
    }
    else
    {
      h.b(this.M3, paramInt);
      h.b(this.N3, paramInt);
      h.b(this.O3, getContext().getResources().getColor(2131100188));
      h.b(this.P3, getContext().getResources().getColor(2131100188));
    }
    x();
  }
  
  private void q(String paramString1, String paramString2)
  {
    TextView localTextView;
    if (this.K3 == 1) {
      localTextView = this.N3;
    } else {
      localTextView = this.P3;
    }
    String str1 = localTextView.getText().toString();
    String str2 = paramString1;
    if (paramString1 == null) {
      str2 = str1.split(":")[0];
    }
    String str3 = paramString2;
    if (paramString2 == null) {
      str3 = str1.split(":")[1];
    }
    if ((this.K3 == 2) && (str2.equals("00")) && (str3.equals("00")))
    {
      paramString1 = "24";
    }
    else
    {
      paramString1 = str2;
      if (this.K3 == 2)
      {
        paramString1 = str2;
        if (str2.equals("24"))
        {
          paramString1 = str2;
          if (!str3.equals("00")) {
            paramString1 = "00";
          }
        }
      }
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(":");
    paramString2.append(str3);
    h.a(localTextView, paramString2.toString());
  }
  
  private void r()
  {
    View localView = LayoutInflater.from(this.p0).inflate(2131558832, null);
    setContentView(localView);
    setCanceledOnTouchOutside(false);
    Object localObject1 = (FrameLayout)localView.findViewById(2131364850);
    TextView localTextView = (TextView)localView.findViewById(2131364847);
    localObject1 = (TextView)localView.findViewById(2131364848);
    Object localObject2 = (TextView)localView.findViewById(2131364849);
    this.x = ((TextView)localObject2);
    if (this.J3 == 0)
    {
      ((TextView)localObject2).setText(this.y);
    }
    else
    {
      ((TextView)localObject2).setPadding(20, 4, 24, 4);
      this.x.setTextColor(getContext().getResources().getColor(2131100206));
      this.x.setOnClickListener(new a());
    }
    localObject2 = (WheelPicker)localView.findViewById(2131364851);
    this.p2.add(localObject2);
    localObject2 = (WheelPicker)localView.findViewById(2131364852);
    this.p2.add(localObject2);
    w();
    int k;
    for (int i = 0;; i++)
    {
      int j = this.p1.size();
      k = 8;
      if (i >= j) {
        break;
      }
      localObject2 = (WheelPicker)this.p2.get(i);
      if (((l)this.p1.get(i)).e()) {
        k = 0;
      }
      ((View)localObject2).setVisibility(k);
      s((WheelPicker)this.p2.get(i), ((l)this.p1.get(i)).a(), ((l)this.p1.get(i)).d());
      ((WheelPicker)this.p2.get(i)).setSelectedItemPosition(((l)this.p1.get(i)).c());
    }
    localObject2 = (LinearLayout)localView.findViewById(2131364232);
    if (this.I3) {
      k = 0;
    }
    ((LinearLayout)localObject2).setVisibility(k);
    if (this.I3)
    {
      this.M3 = ((TextView)localView.findViewById(2131364234));
      this.N3 = ((TextView)localView.findViewById(2131364235));
      this.O3 = ((TextView)localView.findViewById(2131364230));
      this.P3 = ((TextView)localView.findViewById(2131364231));
      p(1, true);
      localView.findViewById(2131364233).setOnClickListener(new b());
      localView.findViewById(2131364229).setOnClickListener(new c());
    }
    ((WheelPicker)this.p2.get(0)).setOnItemSelectedListener(new d());
    ((WheelPicker)this.p2.get(1)).setOnItemSelectedListener(new e());
    localTextView.setOnClickListener(new f());
    ((TextView)localObject1).setOnClickListener(new g());
  }
  
  private void s(WheelPicker paramWheelPicker, List<String> paramList, boolean paramBoolean)
  {
    paramWheelPicker.setData(paramList);
    paramWheelPicker.setCyclic(paramBoolean);
    paramWheelPicker.setVisibleItemCount(7);
    paramWheelPicker.setSelectedItemTextColor(getContext().getResources().getColor(2131100108));
    paramWheelPicker.setItemTextColor(getContext().getResources().getColor(2131099690));
    paramWheelPicker.setIndicator(true);
    paramWheelPicker.setIndicatorColor(getContext().getResources().getColor(2131099689));
    paramWheelPicker.setIndicatorSize(e.a(1, getContext()));
  }
  
  private void t()
  {
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localLayoutParams.gravity = 80;
      localWindow.setAttributes(localLayoutParams);
    }
  }
  
  private void w()
  {
    int i = this.J3;
    if (i == 0) {
      return;
    }
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject = getContext().getResources().getDrawable(2131689622);
    } else {
      localObject = getContext().getResources().getDrawable(2131690214);
    }
    int j;
    if (i != 0) {
      j = 2131231479;
    } else {
      j = 2131231480;
    }
    this.x.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
    this.x.setBackgroundResource(j);
    Object localObject = this.x;
    if (i != 0) {
      j = 2131952449;
    } else {
      j = 2131952448;
    }
    ((TextView)localObject).setText(j);
    if (i != 0)
    {
      ((WheelPicker)this.p2.get(0)).setIndicatorColor(getContext().getResources().getColor(2131100108));
      ((WheelPicker)this.p2.get(1)).setIndicatorColor(getContext().getResources().getColor(2131100108));
    }
    else
    {
      ((WheelPicker)this.p2.get(0)).setIndicatorColor(getContext().getResources().getColor(2131099745));
      ((WheelPicker)this.p2.get(1)).setIndicatorColor(getContext().getResources().getColor(2131099745));
    }
  }
  
  private void x()
  {
    String str;
    if (this.K3 == 1) {
      str = this.N3.getText().toString();
    } else {
      str = this.P3.getText().toString();
    }
    if ((this.K3 == 2) && (Integer.valueOf(str.split(":")[0]).intValue() == 24)) {
      ((WheelPicker)this.p2.get(0)).setSelectedItemPosition(0);
    } else {
      ((WheelPicker)this.p2.get(0)).setSelectedItemPosition(Integer.valueOf(str.split(":")[0]).intValue());
    }
    ((WheelPicker)this.p2.get(1)).setSelectedItemPosition(Integer.valueOf(str.split(":")[1]).intValue());
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void u()
  {
    t();
    show();
  }
  
  public void v(int paramInt, String paramString1, String paramString2)
  {
    if (!this.I3) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localObject1 = this.P3;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(":");
        ((StringBuilder)localObject2).append(paramString2);
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      localObject2 = this.N3;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(":");
      ((StringBuilder)localObject1).append(paramString2);
      ((TextView)localObject2).setText(((StringBuilder)localObject1).toString());
    }
    if (paramInt == this.K3) {
      x();
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      paramView = d5.this;
      int i;
      if (d5.n(paramView) == 1) {
        i = 2;
      } else {
        i = 1;
      }
      d5.o(paramView, i);
      d5.a(d5.this);
      if (d5.b(d5.this) != null) {
        d5.b(d5.this).a(d5.n(d5.this));
      }
      paramView = d5.this;
      d5.d(paramView, d5.c(paramView), true);
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      d5.d(d5.this, 1, false);
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      d5.d(d5.this, 2, false);
    }
  }
  
  class d
    implements WheelPicker.a
  {
    d() {}
    
    public void a(WheelPicker paramWheelPicker, Object paramObject, int paramInt)
    {
      if (d5.e(d5.this) != null) {
        d5.e(d5.this).a(0, paramInt, String.valueOf(paramObject));
      }
      ((d5.l)d5.f(d5.this).get(0)).f(paramInt);
      if (d5.g(d5.this))
      {
        paramWheelPicker = d5.this;
        d5.h(paramWheelPicker, ((d5.l)d5.f(paramWheelPicker).get(0)).b(), null);
      }
    }
  }
  
  class e
    implements WheelPicker.a
  {
    e() {}
    
    public void a(WheelPicker paramWheelPicker, Object paramObject, int paramInt)
    {
      if (d5.e(d5.this) != null) {
        d5.e(d5.this).a(1, paramInt, String.valueOf(paramObject));
      }
      ((d5.l)d5.f(d5.this).get(1)).f(paramInt);
      if (d5.g(d5.this))
      {
        paramWheelPicker = d5.this;
        d5.h(paramWheelPicker, null, ((d5.l)d5.f(paramWheelPicker).get(1)).b());
      }
    }
  }
  
  class f
    implements View.OnClickListener
  {
    f() {}
    
    public void onClick(View paramView)
    {
      if (d5.i(d5.this) != null) {
        d5.i(d5.this).b();
      }
      d5.this.dismiss();
    }
  }
  
  class g
    implements View.OnClickListener
  {
    g() {}
    
    public void onClick(View paramView)
    {
      paramView = new String[0];
      if (d5.i(d5.this) != null)
      {
        String[] arrayOfString1;
        if (d5.g(d5.this))
        {
          paramView = new String[4];
          arrayOfString1 = d5.j(d5.this).getText().toString().split(":");
          String[] arrayOfString2 = d5.k(d5.this).getText().toString().split(":");
          paramView[0] = arrayOfString1[0];
          paramView[1] = arrayOfString1[1];
          paramView[2] = arrayOfString2[0];
          paramView[3] = arrayOfString2[1];
        }
        else
        {
          arrayOfString1 = new String[d5.l(d5.this).size()];
          for (int i = 0;; i++)
          {
            paramView = arrayOfString1;
            if (i >= d5.l(d5.this).size()) {
              break;
            }
            arrayOfString1[i] = ((d5.l)d5.f(d5.this).get(i)).b();
          }
        }
        d5.i(d5.this).a(paramView);
      }
      if (d5.m(d5.this))
      {
        if (Integer.valueOf(paramView[0]).intValue() * 60 + Integer.valueOf(paramView[1]).intValue() < Integer.valueOf(paramView[2]).intValue() * 60 + Integer.valueOf(paramView[3]).intValue()) {
          d5.this.dismiss();
        }
      }
      else {
        d5.this.dismiss();
      }
    }
  }
  
  public static class h
  {
    private Context a;
    private int b;
    private int c;
    private String d;
    private boolean e;
    private ArrayList<d5.l> f;
    private d5.i g;
    private boolean h;
    private d5.j i;
    
    public h(Context paramContext)
    {
      this(paramContext, 2132017559);
    }
    
    public h(Context paramContext, int paramInt)
    {
      this.a = paramContext;
      this.c = paramInt;
      this.f = new ArrayList(4);
      this.h = false;
      this.e = false;
      this.b = 0;
    }
    
    public h j(List<String> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.f.add(new d5.l(paramList, paramInt, paramBoolean1, paramBoolean2));
      return this;
    }
    
    public d5 k()
    {
      return new d5(this, null);
    }
    
    public h l(int paramInt, d5.j paramj)
    {
      this.b = paramInt;
      this.i = paramj;
      this.h = true;
      return this;
    }
    
    public h m(d5.i parami)
    {
      this.g = parami;
      return this;
    }
    
    public h n(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }
  }
  
  public static abstract interface i
  {
    public abstract void a(String... paramVarArgs);
    
    public abstract void b();
  }
  
  public static abstract interface j
  {
    public abstract void a(int paramInt);
  }
  
  public static abstract interface k
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString);
  }
  
  public static class l
  {
    private List<String> a;
    private boolean b;
    private int c;
    private boolean d;
    
    public l(List<String> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramList;
      this.b = paramBoolean1;
      this.c = paramInt;
      this.d = paramBoolean2;
    }
    
    public List<String> a()
    {
      return this.a;
    }
    
    public String b()
    {
      return (String)this.a.get(this.c);
    }
    
    public int c()
    {
      return this.c;
    }
    
    public boolean d()
    {
      return this.b;
    }
    
    public boolean e()
    {
      return this.d;
    }
    
    public void f(int paramInt)
    {
      this.c = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\d5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */