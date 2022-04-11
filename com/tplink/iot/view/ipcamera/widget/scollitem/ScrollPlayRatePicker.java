package com.tplink.iot.view.ipcamera.widget.scollitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.viewmodel.ipcamera.play.VodPlayRate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScrollPlayRatePicker
  extends FrameLayout
{
  private RecyclerView c;
  private ScrollPlayRateAdapter d;
  private a f;
  private List<VodPlayRate> q = new ArrayList();
  
  public ScrollPlayRatePicker(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ScrollPlayRatePicker(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.c = ((RecyclerView)LayoutInflater.from(paramContext).inflate(2131559195, this, true).findViewById(2131363664));
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, com.tplink.iot.b.ScrollPlayRatePicker);
    paramAttributeSet.getBoolean(0, false);
    paramAttributeSet.recycle();
    paramAttributeSet = new LinearLayoutManager(paramContext);
    this.c.setLayoutManager(paramAttributeSet);
    paramAttributeSet = Arrays.asList(VodPlayRate.values());
    this.q = paramAttributeSet;
    paramContext = new ScrollPlayRateAdapter(paramContext, paramAttributeSet);
    this.d = paramContext;
    this.c.setAdapter(paramContext);
    this.d.p(new b(this));
  }
  
  public void d(VodPlayRate paramVodPlayRate)
  {
    if ((paramVodPlayRate != null) && (!this.q.isEmpty()))
    {
      int i = this.q.indexOf(paramVodPlayRate);
      paramVodPlayRate = this.d;
      if (paramVodPlayRate != null) {
        paramVodPlayRate.q(i);
      }
    }
  }
  
  public void e()
  {
    ScrollPlayRateAdapter localScrollPlayRateAdapter = this.d;
    if (localScrollPlayRateAdapter != null) {
      localScrollPlayRateAdapter.o();
    }
  }
  
  public void setItemClickListener(a parama)
  {
    this.f = parama;
  }
  
  public static abstract interface a
  {
    public abstract void e(VodPlayRate paramVodPlayRate);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\scollitem\ScrollPlayRatePicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */