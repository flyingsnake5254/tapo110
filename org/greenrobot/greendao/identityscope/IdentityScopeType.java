package org.greenrobot.greendao.identityscope;

public enum IdentityScopeType
{
  static
  {
    IdentityScopeType localIdentityScopeType1 = new IdentityScopeType("Session", 0);
    Session = localIdentityScopeType1;
    IdentityScopeType localIdentityScopeType2 = new IdentityScopeType("None", 1);
    None = localIdentityScopeType2;
    $VALUES = new IdentityScopeType[] { localIdentityScopeType1, localIdentityScopeType2 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\identityscope\IdentityScopeType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */