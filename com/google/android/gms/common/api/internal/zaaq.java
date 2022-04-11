package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Api.Client;
import java.util.ArrayList;

final class zaaq
  extends zaau
{
  private final ArrayList<Api.Client> zagp;
  
  public zaaq(ArrayList<Api.Client> paramArrayList)
  {
    super(paramArrayList, null);
    ArrayList localArrayList;
    this.zagp = localArrayList;
  }
  
  @WorkerThread
  public final void zaan()
  {
    zaak.zad(this.zagj).zaee.zaha = zaak.zag(this.zagj);
    ArrayList localArrayList = this.zagp;
    int i = localArrayList.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = localArrayList.get(j);
      j++;
      ((Api.Client)localObject).getRemoteService(zaak.zah(this.zagj), zaak.zad(this.zagj).zaee.zaha);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */