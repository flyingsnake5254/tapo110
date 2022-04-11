package com.tplink.iot.musicphonerhythm.views;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public abstract class MusicRhymeBaseSheetDialog
  extends BottomSheetDialogFragment
  implements View.OnClickListener
{
  protected abstract int A0();
  
  protected abstract void B0(View paramView);
  
  public void C0()
  {
    dismissAllowingStateLoss();
  }
  
  @NonNull
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    BottomSheetDialog localBottomSheetDialog = (BottomSheetDialog)super.onCreateDialog(paramBundle);
    View localView = View.inflate(getContext(), A0(), null);
    localBottomSheetDialog.setContentView(localView);
    paramBundle = localBottomSheetDialog.getWindow();
    if (paramBundle != null)
    {
      paramBundle.findViewById(2131362392).setBackgroundColor(0);
      paramBundle.setWindowAnimations(2132017412);
    }
    B0(localView);
    return localBottomSheetDialog;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\musicphonerhythm\views\MusicRhymeBaseSheetDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */