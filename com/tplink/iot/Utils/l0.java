package com.tplink.iot.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.d.w.f.a;
import java.util.List;

public class l0
  extends PopupWindow
{
  private Activity a;
  private View b;
  private ListView c;
  private TextView d;
  private int e;
  private d f;
  private int g = 0;
  
  public l0(Activity paramActivity, List<String> paramList)
  {
    super(paramActivity);
    this.a = paramActivity;
    d(paramActivity, paramList);
    h(paramActivity);
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
  
  private void d(Activity paramActivity, List<String> paramList)
  {
    Object localObject = (LayoutInflater)paramActivity.getSystemService("layout_inflater");
    if ((paramList != null) && (paramList.size() == 1))
    {
      paramActivity = ((LayoutInflater)localObject).inflate(2131559336, null);
      this.b = paramActivity;
      paramActivity = (TextView)paramActivity.findViewById(2131364252);
      this.d = paramActivity;
      paramActivity.setText((CharSequence)paramList.get(0));
      this.g = 1;
      this.d.measure(0, 0);
      this.e = this.d.getMeasuredWidth();
    }
    else if ((paramList != null) && (paramList.size() > 1))
    {
      localObject = ((LayoutInflater)localObject).inflate(2131559338, null);
      this.b = ((View)localObject);
      localObject = (ListView)((View)localObject).findViewById(2131363682);
      this.c = ((ListView)localObject);
      ((ListView)localObject).setAdapter(new c(paramList, paramActivity));
      this.g = 2;
      this.e = e(paramActivity, paramList);
    }
  }
  
  private int e(Context paramContext, List<String> paramList)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131559335, null);
    localView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    TextView localTextView = (TextView)localView.findViewById(2131364252);
    int i = 0;
    if (localTextView != null)
    {
      j = 0;
      int k;
      for (i = 0; j < paramList.size(); i = k)
      {
        localTextView.setText((CharSequence)paramList.get(j));
        localView.measure(0, 0);
        k = i;
        if (i < localView.getMeasuredWidth()) {
          k = localView.getMeasuredWidth();
        }
        j++;
      }
    }
    int j = i;
    if (i < c(paramContext, 176.0F)) {
      j = c(paramContext, 176.0F);
    }
    return j;
  }
  
  private void h(Activity paramActivity)
  {
    if (this.g != 0)
    {
      setContentView(this.b);
      setWidth(this.e);
      setHeight(-2);
      setFocusable(true);
      setTouchable(true);
      setOutsideTouchable(true);
      Drawable localDrawable = paramActivity.getResources().getDrawable(2131231416);
      if (Build.VERSION.SDK_INT >= 21)
      {
        setBackgroundDrawable(new ColorDrawable(-1));
        setElevation(c(paramActivity, 3.0F));
      }
      else
      {
        setBackgroundDrawable(localDrawable);
      }
      setAnimationStyle(2132018154);
      int i = this.g;
      if (i == 1) {
        this.d.setOnClickListener(new a());
      } else if (i == 2) {
        this.c.setOnItemClickListener(new b());
      }
    }
  }
  
  public int c(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public void f(d paramd)
  {
    this.f = paramd;
  }
  
  public void g(int paramInt)
  {
    TextView localTextView = this.d;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
  
  public void i(View paramView)
  {
    if ((this.a != null) && (paramView != null) && (this.b != null))
    {
      paramView.getLocationInWindow(new int[] { 0, 0 });
      a.a(this.a, 176.0F);
      paramView.getWidth();
      int[] arrayOfInt = b(paramView, this.b);
      showAtLocation(paramView, 8388659, arrayOfInt[0], arrayOfInt[1]);
    }
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (l0.a(l0.this) != null) {
        l0.a(l0.this).a(paramView, 0);
      }
      l0.this.dismiss();
    }
  }
  
  class b
    implements AdapterView.OnItemClickListener
  {
    b() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      l0.this.dismiss();
      if (l0.a(l0.this) != null) {
        l0.a(l0.this).a(paramView, (int)paramLong);
      }
      l0.this.dismiss();
    }
  }
  
  private class c
    extends BaseAdapter
  {
    private List<String> c;
    private Context d;
    
    public c(Context paramContext)
    {
      this.c = paramContext;
      Context localContext;
      this.d = localContext;
    }
    
    public String a(int paramInt)
    {
      return (String)this.c.get(paramInt);
    }
    
    public int getCount()
    {
      List localList = this.c;
      int i;
      if (localList == null) {
        i = 0;
      } else {
        i = localList.size();
      }
      return i;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.d).inflate(2131559336, null);
        paramViewGroup = new a();
        paramViewGroup.a = ((TextView)paramView.findViewById(2131364252));
        paramView.setTag(paramViewGroup);
      }
      else
      {
        paramViewGroup = (a)paramView.getTag();
      }
      String str = (String)this.c.get(paramInt);
      if (!TextUtils.isEmpty(str)) {
        paramViewGroup.a.setText(str);
      }
      return paramView;
    }
    
    protected class a
    {
      TextView a;
      
      protected a() {}
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(View paramView, int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\Utils\l0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */