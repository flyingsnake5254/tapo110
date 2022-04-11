package com.tplink.iot.adapter.camera;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import java.util.ArrayList;
import java.util.List;

public class VideoQualityAdapter
  extends RecyclerView.Adapter
{
  private Activity a;
  private List<ResolutionType> b = new ArrayList();
  private ResolutionType c = ResolutionType.HD_720P;
  private a d;
  
  public VideoQualityAdapter(Activity paramActivity, a parama)
  {
    this.a = paramActivity;
    this.d = parama;
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
  
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ((b)paramViewHolder).e((ResolutionType)this.b.get(paramInt));
  }
  
  @NonNull
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new b(LayoutInflater.from(this.a).inflate(2131559093, paramViewGroup, false));
  }
  
  public ResolutionType q()
  {
    return this.c;
  }
  
  public void r(ResolutionType paramResolutionType)
  {
    this.c = paramResolutionType;
    if (!this.b.isEmpty()) {
      notifyDataSetChanged();
    }
  }
  
  public void s(List<ResolutionType> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void a(ResolutionType paramResolutionType);
  }
  
  private class b
    extends RecyclerView.ViewHolder
  {
    TextView a;
    TextView b;
    CheckBox c;
    View d;
    
    b(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(2131364688));
      this.b = ((TextView)paramView.findViewById(2131364655));
      this.c = ((CheckBox)paramView.findViewById(2131362198));
      this.d = paramView;
    }
    
    private String c(ResolutionType paramResolutionType)
    {
      String str = VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954419);
      ResolutionType localResolutionType = ResolutionType.HD_4M;
      if (paramResolutionType == localResolutionType)
      {
        str = localResolutionType.toString();
      }
      else
      {
        localResolutionType = ResolutionType.HD_3M;
        if (paramResolutionType == localResolutionType) {
          str = localResolutionType.toString();
        } else if (paramResolutionType == ResolutionType.HD_1080P) {
          str = VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954421);
        } else if (paramResolutionType == ResolutionType.HD_720P) {
          str = VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954422);
        } else if (paramResolutionType == ResolutionType.VGA_360P) {
          str = "";
        }
      }
      return str;
    }
    
    private String d(ResolutionType paramResolutionType)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954419));
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954420));
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      if (paramResolutionType == ResolutionType.HD_4M)
      {
        localObject = VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954418);
      }
      else if (paramResolutionType == ResolutionType.HD_3M)
      {
        localObject = VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954417);
      }
      else if (paramResolutionType == ResolutionType.HD_1080P)
      {
        localObject = VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954414);
      }
      else if (paramResolutionType == ResolutionType.HD_720P)
      {
        paramResolutionType = new StringBuilder();
        paramResolutionType.append(VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954419));
        paramResolutionType.append("(");
        paramResolutionType.append(VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954420));
        paramResolutionType.append(")");
        localObject = paramResolutionType.toString();
      }
      else if (paramResolutionType == ResolutionType.VGA_360P)
      {
        paramResolutionType = new StringBuilder();
        paramResolutionType.append(VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954415));
        paramResolutionType.append("(");
        paramResolutionType.append(VideoQualityAdapter.o(VideoQualityAdapter.this).getString(2131954416));
        paramResolutionType.append(")");
        localObject = paramResolutionType.toString();
      }
      return (String)localObject;
    }
    
    public void e(ResolutionType paramResolutionType)
    {
      CheckBox localCheckBox = this.c;
      boolean bool;
      if (VideoQualityAdapter.m(VideoQualityAdapter.this) == paramResolutionType) {
        bool = true;
      } else {
        bool = false;
      }
      localCheckBox.setChecked(bool);
      this.a.setText(d(paramResolutionType));
      this.b.setText(c(paramResolutionType));
      this.d.setOnClickListener(new a(this, paramResolutionType));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\adapter\camera\VideoQualityAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */