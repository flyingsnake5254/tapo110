package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class AppCompatDialogFragment
  extends DialogFragment
{
  @NonNull
  public Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    return new AppCompatDialog(getContext(), getTheme());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setupDialog(@NonNull Dialog paramDialog, int paramInt)
  {
    if ((paramDialog instanceof AppCompatDialog))
    {
      AppCompatDialog localAppCompatDialog = (AppCompatDialog)paramDialog;
      if ((paramInt != 1) && (paramInt != 2))
      {
        if (paramInt == 3) {
          paramDialog.getWindow().addFlags(24);
        }
      }
      else {
        localAppCompatDialog.supportRequestWindowFeature(1);
      }
    }
    else
    {
      super.setupDialog(paramDialog, paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\app\AppCompatDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */