package com.tplink.iot.viewmodel.home;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.adapter.home.HomeFamilySelectBean;
import com.tplink.iot.adapter.home.HomeFamilySelectMenuAdapter;
import com.tplink.iot.adapter.home.HomeFamilySelectMenuAdapter.b;
import java.util.List;

public class y
  extends PopupWindow
{
  private Activity a;
  private View b;
  private c c;
  
  public y(Activity paramActivity, List<HomeFamilySelectBean> paramList)
  {
    super(paramActivity);
    this.a = paramActivity;
    d(paramActivity, paramList);
  }
  
  private int[] b(View paramView1, View paramView2)
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    paramView1.getLocationOnScreen(arrayOfInt2);
    int i = paramView1.getHeight();
    int j = this.a.getResources().getDisplayMetrics().heightPixels;
    int k = this.a.getResources().getDisplayMetrics().widthPixels;
    paramView2.measure(0, 0);
    int m = paramView2.getMeasuredHeight();
    int n = paramView2.getMeasuredWidth();
    int i1 = arrayOfInt2[1];
    int i2 = paramView1.getHeight();
    int i3;
    if (j - arrayOfInt2[1] - i < m) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i4;
    if (k - arrayOfInt2[0] - paramView1.getWidth() <= arrayOfInt2[0]) {
      i4 = 1;
    } else {
      i4 = 0;
    }
    if (i4 != 0) {
      arrayOfInt1[0] = (k - n - (k - arrayOfInt2[0] - paramView1.getWidth()));
    } else {
      arrayOfInt1[0] = arrayOfInt2[0];
    }
    if (i3 != 0) {
      arrayOfInt1[1] = (arrayOfInt2[1] - m - (j - i1 - i2));
    } else {
      arrayOfInt2[1] += i;
    }
    return arrayOfInt1;
  }
  
  private void d(Activity paramActivity, List<HomeFamilySelectBean> paramList)
  {
    Object localObject = (LayoutInflater)paramActivity.getSystemService("layout_inflater");
    if (localObject == null) {
      return;
    }
    localObject = ((LayoutInflater)localObject).inflate(2131558997, null);
    this.b = ((View)localObject);
    View localView = ((View)localObject).findViewById(2131363179);
    RecyclerView localRecyclerView = (RecyclerView)this.b.findViewById(2131363810);
    localObject = new HomeFamilySelectMenuAdapter(paramActivity, paramList);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(paramActivity));
    localRecyclerView.setAdapter((RecyclerView.Adapter)localObject);
    setContentView(this.b);
    setWidth(e(paramActivity, paramList));
    if (paramList.size() >= 4.0F) {
      setHeight(c(paramActivity, 225.0F));
    } else {
      setHeight(-2);
    }
    setFocusable(true);
    setTouchable(true);
    setOutsideTouchable(true);
    paramList = paramActivity.getResources().getDrawable(2131231416);
    if (Build.VERSION.SDK_INT >= 21)
    {
      setBackgroundDrawable(new ColorDrawable(0));
      setElevation(c(paramActivity, 3.0F));
    }
    else
    {
      setBackgroundDrawable(paramList);
    }
    setAnimationStyle(2132018154);
    ((HomeFamilySelectMenuAdapter)localObject).o(new a());
    localView.setOnClickListener(new b());
  }
  
  private int e(Context paramContext, List<HomeFamilySelectBean> paramList)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131558995, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    TextView localTextView = (TextView)localView.findViewById(2131364457);
    if (localTextView != null)
    {
      int i = 0;
      for (j = 0;; j = k)
      {
        k = j;
        if (i >= paramList.size()) {
          break;
        }
        localTextView.setText(((HomeFamilySelectBean)paramList.get(i)).getFamilyName());
        localView.measure(0, 0);
        k = j;
        if (j < localView.getMeasuredWidth()) {
          k = localView.getMeasuredWidth();
        }
        i++;
      }
    }
    int k = 0;
    paramContext = LayoutInflater.from(paramContext).inflate(2131558996, null);
    paramContext.measure(0, 0);
    int j = k;
    if (k < paramContext.getMeasuredWidth()) {
      j = paramContext.getMeasuredWidth();
    }
    return j;
  }
  
  public int c(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public void f(c paramc)
  {
    this.c = paramc;
  }
  
  public void g(View paramView)
  {
    if ((this.a != null) && (paramView != null))
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        localObject = b(paramView, (View)localObject);
        showAtLocation(paramView, 8388659, localObject[0], localObject[1]);
      }
    }
  }
  
  class a
    implements HomeFamilySelectMenuAdapter.b
  {
    a() {}
    
    public void a(View paramView, int paramInt)
    {
      y.this.dismiss();
      if (y.a(y.this) != null) {
        y.a(y.this).a(paramView, paramInt);
      }
      y.this.dismiss();
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      if (y.a(y.this) != null) {
        y.a(y.this).b(paramView);
      }
      y.this.dismiss();
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView, int paramInt);
    
    public abstract void b(View paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */