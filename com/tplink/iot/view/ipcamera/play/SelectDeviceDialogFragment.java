package com.tplink.iot.view.ipcamera.play;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import b.d.w.f.a;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.databinding.DialogSelectDeviceBinding;
import com.tplink.iot.viewmodel.ipcamera.play.SelectDeviceViewModel;
import com.tplink.libmediaapi.live.LiveMediaAPI;
import com.tplink.libtpnetwork.Utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SelectDeviceDialogFragment
  extends DialogFragment
{
  public static String c = "SelectDeviceDialogFragment";
  SelectDeviceViewModel d;
  RecyclerView f;
  DataBindingListAdapter q;
  b x;
  int y;
  
  private void L0()
  {
    Iterator localIterator = this.d.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      LiveMediaAPI.previewCapture((String)localEntry.getKey(), (MutableLiveData)localEntry.getValue());
    }
  }
  
  private void N0()
  {
    Iterator localIterator = this.d.d.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((MutableLiveData)((Map.Entry)localIterator.next()).getValue()).observe(this, new a2(this));
    }
  }
  
  private int P0(Context paramContext, float paramFloat)
  {
    return Math.round(TypedValue.applyDimension(2, paramFloat, paramContext.getResources().getDisplayMetrics()));
  }
  
  void O0(b paramb)
  {
    this.x = paramb;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = ((SelectDeviceViewModel)ViewModelProviders.of(this).get(SelectDeviceViewModel.class));
    if (getArguments() != null) {
      this.d.o(getArguments().getStringArrayList("added_mac_list"), getArguments().getString("persisted_mac"));
    }
    Paint localPaint = new Paint();
    localPaint.setTextSize(P0(getContext(), 14.0F));
    paramBundle = getResources().getString(2131953747);
    String str = getResources().getString(2131953748);
    Object localObject = this.d;
    localObject = ((SelectDeviceViewModel)localObject).j(((Integer)j.e(((SelectDeviceViewModel)localObject).e, Integer.valueOf(0))).intValue());
    float f1 = localPaint.measureText(paramBundle);
    float f2 = localPaint.measureText(str);
    float f3 = localPaint.measureText((String)localObject);
    if (f1 <= f3) {
      f1 = f3;
    }
    this.y = ((int)(f1 * 2.0F + f2 + a.a(getContext(), 90.0F)) + 1);
    N0();
    L0();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    getDialog().requestWindowFeature(1);
    paramLayoutInflater = (DialogSelectDeviceBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558821, paramViewGroup, true);
    paramLayoutInflater.setLifecycleOwner(this);
    paramLayoutInflater.h(this.d);
    this.f = paramLayoutInflater.d;
    paramBundle = new z1(this);
    paramViewGroup = this.d.l();
    paramViewGroup = new DataBindingListAdapter(2131559006, new int[] { 31, 9 }, new int[] { 31 }, new Object[] { paramViewGroup, paramBundle });
    this.q = paramViewGroup;
    paramViewGroup.B(this);
    this.f.setAdapter(this.q);
    this.f.addItemDecoration(new a());
    paramLayoutInflater.c.setOnClickListener(new y1(this));
    paramLayoutInflater.f.setOnClickListener(new x1(this));
    return paramLayoutInflater.getRoot();
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = getDialog().getWindow();
    if (localWindow != null)
    {
      localWindow.setDimAmount(0.0F);
      localWindow.setBackgroundDrawable(new ColorDrawable(0));
      Object localObject = new DisplayMetrics();
      localWindow.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      int i = (int)(((DisplayMetrics)localObject).widthPixels * 0.5D) + 1;
      localObject = localWindow.getAttributes();
      ((WindowManager.LayoutParams)localObject).gravity = 8388613;
      int j = this.y;
      if (i <= j) {
        i = j;
      }
      ((WindowManager.LayoutParams)localObject).width = i;
      ((WindowManager.LayoutParams)localObject).height = -1;
      localWindow.setAttributes((WindowManager.LayoutParams)localObject);
    }
  }
  
  class a
    extends RecyclerView.ItemDecoration
  {
    int a = a.a(SelectDeviceDialogFragment.this.getContext(), 0.5F);
    
    a() {}
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      if (paramRecyclerView.getChildAdapterPosition(paramView) == 0)
      {
        int i = this.a;
        paramRect.set(0, i, 0, i);
      }
      else
      {
        paramRect.set(0, 0, 0, this.a);
      }
    }
  }
  
  static abstract interface b
  {
    public abstract void a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\SelectDeviceDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */