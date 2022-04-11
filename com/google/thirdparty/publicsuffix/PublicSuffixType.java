package com.google.thirdparty.publicsuffix;

public enum PublicSuffixType
{
  private final char innerNodeCode;
  private final char leafNodeCode;
  
  static
  {
    PublicSuffixType localPublicSuffixType1 = new PublicSuffixType("PRIVATE", 0, ':', ',');
    PRIVATE = localPublicSuffixType1;
    PublicSuffixType localPublicSuffixType2 = new PublicSuffixType("REGISTRY", 1, '!', '?');
    REGISTRY = localPublicSuffixType2;
    $VALUES = new PublicSuffixType[] { localPublicSuffixType1, localPublicSuffixType2 };
  }
  
  private PublicSuffixType(char paramChar1, char paramChar2)
  {
    this.innerNodeCode = ((char)paramChar1);
    this.leafNodeCode = ((char)paramChar2);
  }
  
  static PublicSuffixType fromCode(char paramChar)
  {
    PublicSuffixType[] arrayOfPublicSuffixType = values();
    int i = arrayOfPublicSuffixType.length;
    int j = 0;
    while (j < i)
    {
      localObject = arrayOfPublicSuffixType[j];
      if ((((PublicSuffixType)localObject).getInnerNodeCode() != paramChar) && (((PublicSuffixType)localObject).getLeafNodeCode() != paramChar)) {
        j++;
      } else {
        return (PublicSuffixType)localObject;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No enum corresponding to given code: ");
    ((StringBuilder)localObject).append(paramChar);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  static PublicSuffixType fromIsPrivate(boolean paramBoolean)
  {
    PublicSuffixType localPublicSuffixType;
    if (paramBoolean) {
      localPublicSuffixType = PRIVATE;
    } else {
      localPublicSuffixType = REGISTRY;
    }
    return localPublicSuffixType;
  }
  
  char getInnerNodeCode()
  {
    return this.innerNodeCode;
  }
  
  char getLeafNodeCode()
  {
    return this.leafNodeCode;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\thirdparty\publicsuffix\PublicSuffixType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */