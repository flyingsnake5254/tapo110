package com.tplink.iot.view.ipcamera.play;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import com.tplink.iot.Utils.m0;

public class RelayLimitDialogFragment
  extends AppCompatDialogFragment
{
  private a c;
  View d;
  private String f;
  private TextView q;
  private DialogInterface.OnDismissListener x;
  
  void A0()
  {
    dismissAllowingStateLoss();
    a locala = this.c;
    if (locala != null) {
      locala.a();
    }
  }
  
  void B0()
  {
    dismissAllowingStateLoss();
    a locala = this.c;
    if (locala != null) {
      locala.b();
    }
  }
  
  public void J0(String paramString)
  {
    this.f = paramString;
    TextView localTextView = this.q;
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
  }
  
  public void K0(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.x = paramOnDismissListener;
  }
  
  public void L0(a parama)
  {
    this.c = parama;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    getDialog().requestWindowFeature(1);
    paramLayoutInflater = paramLayoutInflater.inflate(2131558820, paramViewGroup);
    this.d = paramLayoutInflater;
    paramLayoutInflater = (TextView)paramLayoutInflater.findViewById(2131363452);
    this.q = paramLayoutInflater;
    paramLayoutInflater.setText(this.f);
    this.d.findViewById(2131362187).setOnClickListener(new t1(this));
    this.d.findViewById(2131362331).setOnClickListener(new s1(this));
    m0.b(true, this.d, 2131362331, new int[] { 2131362187 });
    return this.d;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    DialogInterface.OnDismissListener localOnDismissListener = this.x;
    if (localOnDismissListener != null) {
      localOnDismissListener.onDismiss(paramDialogInterface);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\RelayLimitDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */