package com.tplink.iot.adapter.playback;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpimagedownloadmedia.loader.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class SnapshotAdapter
  extends RecyclerView.Adapter
{
  private Activity a;
  private List<com.tplink.iot.j.c.a> b = new ArrayList();
  private List<com.tplink.iot.j.c.a> c = new ArrayList();
  private SimpleDateFormat d = new SimpleDateFormat("HH:mm:ss", Locale.US);
  private a e;
  private PlayBackControlViewModel f;
  
  public SnapshotAdapter(Activity paramActivity, a parama, PlayBackControlViewModel paramPlayBackControlViewModel)
  {
    this.a = paramActivity;
    this.e = parama;
    this.f = paramPlayBackControlViewModel;
  }
  
  private void p(List<com.tplink.iot.j.c.a> paramList)
  {
    this.b.clear();
    if (paramList != null) {
      this.b.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    List localList = this.b;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    return i;
  }
  
  public void o(List<com.tplink.iot.j.c.a> paramList)
  {
    this.b.clear();
    this.c.clear();
    if (paramList != null)
    {
      this.b.addAll(paramList);
      this.c.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((b)paramViewHolder).c((com.tplink.iot.j.c.a)this.b.get(paramInt), paramInt, this.e);
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2131559068, paramViewGroup, false));
  }
  
  public void q(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      com.tplink.iot.j.c.a locala = (com.tplink.iot.j.c.a)localIterator.next();
      if (((paramInt & 0x1) == 1) && (locala.e() == 2)) {
        localArrayList.add(locala);
      }
      if (((paramInt & 0x2) == 2) && (locala.e() == 6)) {
        localArrayList.add(locala);
      }
      if (((paramInt & 0x4) == 4) && (locala.e() == 7)) {
        localArrayList.add(locala);
      }
      if (((paramInt & 0x8) == 8) && (locala.e() == 5)) {
        localArrayList.add(locala);
      }
      if (((paramInt & 0x10) == 16) && (locala.e() == 4)) {
        localArrayList.add(locala);
      }
      if (((paramInt & 0x20) == 32) && (locala.e() == 3)) {
        localArrayList.add(locala);
      }
    }
    p(localArrayList);
  }
  
  public void r(TimeZone paramTimeZone)
  {
    if (paramTimeZone != null) {
      this.d.setTimeZone(paramTimeZone);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tplink.iot.j.c.a parama);
  }
  
  private class b
    extends RecyclerView.ViewHolder
  {
    TextView a;
    TextView b;
    TextView c;
    ImageView d;
    View e;
    ConstraintLayout f;
    
    b(View paramView)
    {
      super();
      this.d = ((ImageView)paramView.findViewById(2131363096));
      this.a = ((TextView)paramView.findViewById(2131364671));
      this.b = ((TextView)paramView.findViewById(2131364670));
      this.c = ((TextView)paramView.findViewById(2131364705));
      this.e = paramView.findViewById(2131364755);
      this.f = ((ConstraintLayout)paramView.findViewById(2131362246));
    }
    
    private void e(com.tplink.iot.j.c.a parama, int paramInt)
    {
      if (TextUtils.isEmpty(parama.c())) {
        localObject = String.valueOf(parama.d());
      } else {
        localObject = parama.c();
      }
      parama = new g(parama.a(), parama.f(), (String)localObject);
      VodMediaAPI.downloadImageIntoView(parama, this.d, 2131231028);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadImage:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("--image:");
      ((StringBuilder)localObject).append(parama.c());
      b.d.w.c.a.d(((StringBuilder)localObject).toString());
    }
    
    private String f(int paramInt)
    {
      if (paramInt <= 0) {
        return "00:00";
      }
      int i = paramInt / 60;
      Object localObject;
      if (i < 60)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i(i));
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(i(paramInt % 60));
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        int j = i / 60;
        if (j > 99) {
          return "99:59:59";
        }
        i %= 60;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(i(j));
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(i(i));
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(i(paramInt - j * 3600 - i * 60));
        localObject = ((StringBuilder)localObject).toString();
      }
      return (String)localObject;
    }
    
    private void g(com.tplink.iot.j.c.a parama)
    {
      Date localDate = new Date();
      localDate.setTime(parama.d() * 1000L);
      if (parama.g())
      {
        TextView localTextView = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(SnapshotAdapter.m(SnapshotAdapter.this).format(localDate));
        localStringBuilder.append(SnapshotAdapter.n(SnapshotAdapter.this).getString(2131952030));
        localTextView.setText(localStringBuilder.toString());
      }
      else
      {
        this.b.setText(SnapshotAdapter.m(SnapshotAdapter.this).format(localDate));
      }
      this.a.setText(f((int)(parama.b() - parama.d())));
    }
    
    private void h(com.tplink.iot.j.c.a parama)
    {
      this.e.setBackgroundResource(2131231303);
      this.e.getBackground().setLevel(parama.e());
      switch (parama.e())
      {
      default: 
        this.c.setText(SnapshotAdapter.n(SnapshotAdapter.this).getString(2131953357));
        break;
      case 7: 
        this.c.setText(SnapshotAdapter.n(SnapshotAdapter.this).getString(2131951870));
        break;
      case 6: 
        this.c.setText(SnapshotAdapter.n(SnapshotAdapter.this).getString(2131954247));
        break;
      case 5: 
        this.c.setText(SnapshotAdapter.n(SnapshotAdapter.this).getString(2131953803));
        break;
      case 4: 
        this.c.setText(SnapshotAdapter.n(SnapshotAdapter.this).getString(2131953830));
        break;
      case 3: 
        this.c.setText(SnapshotAdapter.n(SnapshotAdapter.this).getString(2131953881));
        break;
      case 2: 
        this.c.setText(SnapshotAdapter.n(SnapshotAdapter.this).getString(2131953357));
      }
    }
    
    private String i(int paramInt)
    {
      Object localObject;
      if ((paramInt >= 0) && (paramInt < 10))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("0");
        ((StringBuilder)localObject).append(paramInt);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(paramInt);
        localObject = ((StringBuilder)localObject).toString();
      }
      return (String)localObject;
    }
    
    public void c(com.tplink.iot.j.c.a parama, int paramInt, SnapshotAdapter.a parama1)
    {
      e(parama, paramInt);
      g(parama);
      h(parama);
      this.f.setOnClickListener(new a(parama1, parama));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\playback\SnapshotAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */