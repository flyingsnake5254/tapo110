package com.tplink.iot.view.ipcamera.play;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ForcedUpdateFwDialog
  extends DialogFragment
{
  private Unbinder c;
  private a d;
  @BindView
  TextView detail;
  @BindView
  TextView deviceName;
  private String f;
  @BindView
  TextView fwInfoTv;
  @BindView
  TextView laterTv;
  
  public void A0(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.f = paramString.replace("\\n", "\n");
  }
  
  public void B0(a parama)
  {
    this.d = parama;
  }
  
  @OnClick
  void detailClick()
  {
    dismiss();
    a locala = this.d;
    if (locala != null) {
      locala.b();
    }
  }
  
  @OnClick
  void doUpdate()
  {
    dismiss();
    a locala = this.d;
    if (locala != null) {
      locala.c();
    }
  }
  
  @OnClick
  void doUpdateLater()
  {
    dismiss();
    a locala = this.d;
    if (locala != null) {
      locala.a();
    }
  }
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558787, paramViewGroup);
    getDialog().requestWindowFeature(1);
    this.c = ButterKnife.b(this, paramLayoutInflater);
    this.fwInfoTv.setText(this.f);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.c.a();
    super.onDestroyView();
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\ForcedUpdateFwDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */