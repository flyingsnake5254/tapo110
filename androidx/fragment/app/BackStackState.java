package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator()
  {
    public BackStackState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BackStackState(paramAnonymousParcel);
    }
    
    public BackStackState[] newArray(int paramAnonymousInt)
    {
      return new BackStackState[paramAnonymousInt];
    }
  };
  private static final String TAG = "FragmentManager";
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int[] mCurrentMaxLifecycleStates;
  final ArrayList<String> mFragmentWhos;
  final int mIndex;
  final String mName;
  final int[] mOldMaxLifecycleStates;
  final int[] mOps;
  final boolean mReorderingAllowed;
  final ArrayList<String> mSharedElementSourceNames;
  final ArrayList<String> mSharedElementTargetNames;
  final int mTransition;
  
  public BackStackState(Parcel paramParcel)
  {
    this.mOps = paramParcel.createIntArray();
    this.mFragmentWhos = paramParcel.createStringArrayList();
    this.mOldMaxLifecycleStates = paramParcel.createIntArray();
    this.mCurrentMaxLifecycleStates = paramParcel.createIntArray();
    this.mTransition = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.mBreadCrumbTitleRes = paramParcel.readInt();
    this.mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mBreadCrumbShortTitleRes = paramParcel.readInt();
    this.mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.mSharedElementSourceNames = paramParcel.createStringArrayList();
    this.mSharedElementTargetNames = paramParcel.createStringArrayList();
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.mReorderingAllowed = bool;
  }
  
  public BackStackState(BackStackRecord paramBackStackRecord)
  {
    int i = paramBackStackRecord.mOps.size();
    this.mOps = new int[i * 5];
    if (paramBackStackRecord.mAddToBackStack)
    {
      this.mFragmentWhos = new ArrayList(i);
      this.mOldMaxLifecycleStates = new int[i];
      this.mCurrentMaxLifecycleStates = new int[i];
      int j = 0;
      int n;
      for (int k = 0; j < i; k = n + 1)
      {
        FragmentTransaction.Op localOp = (FragmentTransaction.Op)paramBackStackRecord.mOps.get(j);
        Object localObject = this.mOps;
        int m = k + 1;
        localObject[k] = localOp.mCmd;
        ArrayList localArrayList = this.mFragmentWhos;
        localObject = localOp.mFragment;
        if (localObject != null) {
          localObject = ((Fragment)localObject).mWho;
        } else {
          localObject = null;
        }
        localArrayList.add(localObject);
        localObject = this.mOps;
        n = m + 1;
        localObject[m] = localOp.mEnterAnim;
        k = n + 1;
        localObject[n] = localOp.mExitAnim;
        n = k + 1;
        localObject[k] = localOp.mPopEnterAnim;
        localObject[n] = localOp.mPopExitAnim;
        this.mOldMaxLifecycleStates[j] = localOp.mOldMaxState.ordinal();
        this.mCurrentMaxLifecycleStates[j] = localOp.mCurrentMaxState.ordinal();
        j++;
      }
      this.mTransition = paramBackStackRecord.mTransition;
      this.mName = paramBackStackRecord.mName;
      this.mIndex = paramBackStackRecord.mIndex;
      this.mBreadCrumbTitleRes = paramBackStackRecord.mBreadCrumbTitleRes;
      this.mBreadCrumbTitleText = paramBackStackRecord.mBreadCrumbTitleText;
      this.mBreadCrumbShortTitleRes = paramBackStackRecord.mBreadCrumbShortTitleRes;
      this.mBreadCrumbShortTitleText = paramBackStackRecord.mBreadCrumbShortTitleText;
      this.mSharedElementSourceNames = paramBackStackRecord.mSharedElementSourceNames;
      this.mSharedElementTargetNames = paramBackStackRecord.mSharedElementTargetNames;
      this.mReorderingAllowed = paramBackStackRecord.mReorderingAllowed;
      return;
    }
    throw new IllegalStateException("Not on back stack");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public BackStackRecord instantiate(FragmentManager paramFragmentManager)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManager);
    int i = 0;
    int j = 0;
    while (i < this.mOps.length)
    {
      FragmentTransaction.Op localOp = new FragmentTransaction.Op();
      Object localObject = this.mOps;
      int k = i + 1;
      localOp.mCmd = localObject[i];
      if (FragmentManager.isLoggingEnabled(2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Instantiate ");
        ((StringBuilder)localObject).append(localBackStackRecord);
        ((StringBuilder)localObject).append(" op #");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" base fragment #");
        ((StringBuilder)localObject).append(this.mOps[k]);
        Log.v("FragmentManager", ((StringBuilder)localObject).toString());
      }
      localObject = (String)this.mFragmentWhos.get(j);
      if (localObject != null) {
        localOp.mFragment = paramFragmentManager.findActiveFragment((String)localObject);
      } else {
        localOp.mFragment = null;
      }
      localOp.mOldMaxState = androidx.lifecycle.Lifecycle.State.values()[this.mOldMaxLifecycleStates[j]];
      localOp.mCurrentMaxState = androidx.lifecycle.Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[j]];
      localObject = this.mOps;
      i = k + 1;
      k = localObject[k];
      localOp.mEnterAnim = k;
      int m = i + 1;
      int n = localObject[i];
      localOp.mExitAnim = n;
      i = m + 1;
      int i1 = localObject[m];
      localOp.mPopEnterAnim = i1;
      m = localObject[i];
      localOp.mPopExitAnim = m;
      localBackStackRecord.mEnterAnim = k;
      localBackStackRecord.mExitAnim = n;
      localBackStackRecord.mPopEnterAnim = i1;
      localBackStackRecord.mPopExitAnim = m;
      localBackStackRecord.addOp(localOp);
      j++;
      i++;
    }
    localBackStackRecord.mTransition = this.mTransition;
    localBackStackRecord.mName = this.mName;
    localBackStackRecord.mIndex = this.mIndex;
    localBackStackRecord.mAddToBackStack = true;
    localBackStackRecord.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
    localBackStackRecord.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
    localBackStackRecord.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
    localBackStackRecord.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
    localBackStackRecord.mSharedElementSourceNames = this.mSharedElementSourceNames;
    localBackStackRecord.mSharedElementTargetNames = this.mSharedElementTargetNames;
    localBackStackRecord.mReorderingAllowed = this.mReorderingAllowed;
    localBackStackRecord.bumpBackStackNesting(1);
    return localBackStackRecord;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.mOps);
    paramParcel.writeStringList(this.mFragmentWhos);
    paramParcel.writeIntArray(this.mOldMaxLifecycleStates);
    paramParcel.writeIntArray(this.mCurrentMaxLifecycleStates);
    paramParcel.writeInt(this.mTransition);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.mBreadCrumbTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbTitleText, paramParcel, 0);
    paramParcel.writeInt(this.mBreadCrumbShortTitleRes);
    TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, paramParcel, 0);
    paramParcel.writeStringList(this.mSharedElementSourceNames);
    paramParcel.writeStringList(this.mSharedElementTargetNames);
    paramParcel.writeInt(this.mReorderingAllowed);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\BackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */