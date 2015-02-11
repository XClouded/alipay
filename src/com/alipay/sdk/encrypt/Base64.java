/*     */ package com.alipay.sdk.encrypt;
/*     */ 
/*     */ public final class Base64
/*     */ {
/*     */   private static final int a = 128;
/*     */   private static final int b = 64;
/*     */   private static final int c = 24;
/*     */   private static final int d = 8;
/*     */   private static final int e = 16;
/*     */   private static final int f = 4;
/*     */   private static final int g = -128;
/*     */   private static final char h = '=';
/*  19 */   private static final byte[] i = new byte[''];
/*  20 */   private static final char[] j = new char[64];
/*     */ 
/*     */   private static boolean a(char paramChar)
/*     */   {
/*  57 */     return (paramChar == ' ') || (paramChar == '\r') || (paramChar == '\n') || (paramChar == '\t');
/*     */   }
/*     */ 
/*     */   private static boolean b(char paramChar) {
/*  61 */     return paramChar == '=';
/*     */   }
/*     */ 
/*     */   private static boolean c(char paramChar) {
/*  65 */     return (paramChar < '') && (i[paramChar] != -1);
/*     */   }
/*     */ 
/*     */   public static String a(byte[] paramArrayOfByte)
/*     */   {
/*  77 */     if (paramArrayOfByte == null)
/*  78 */       return null;
/*     */     int k;
/*  82 */     if ((
/*  82 */       k = paramArrayOfByte.length * 8) == 0)
/*     */     {
/*  83 */       return "";
/*     */     }
/*     */ 
/*  86 */     int m = k % 24;
/*  87 */     k /= 24;
/*     */ 
/*  90 */     char[] arrayOfChar = new char[(m != 0 ? k + 1 : k) * 
/*  90 */       4];
/*     */ 
/*  94 */     int n = 0; int i1 = 0; int i2 = 0; int i3 = 0; int i4 = 0;
/*     */ 
/*  96 */     int i5 = 0;
/*  97 */     int i6 = 0;
/*     */ 
/*  99 */     for (int i7 = 0; i7 < k; i7++) {
/* 100 */       i2 = paramArrayOfByte[(i6++)];
/* 101 */       i3 = paramArrayOfByte[(i6++)];
/* 102 */       i4 = paramArrayOfByte[(i6++)];
/*     */ 
/* 105 */       i1 = (byte)(i3 & 0xF);
/* 106 */       n = (byte)(i2 & 0x3);
/*     */ 
/* 108 */       i2 = (i2 & 0xFFFFFF80) == 0 ? (byte)(i2 >> 2) : (byte)(i2 >> 2 ^ 0xC0);
/*     */ 
/* 110 */       i3 = (i3 & 0xFFFFFF80) == 0 ? (byte)(i3 >> 4) : (byte)(i3 >> 4 ^ 0xF0);
/*     */ 
/* 112 */       int i8 = (i4 & 0xFFFFFF80) == 0 ? (byte)(i4 >> 6) : (byte)(i4 >> 6 ^ 0xFC);
/*     */ 
/* 116 */       arrayOfChar[(i5++)] = j[i2];
/* 117 */       arrayOfChar[(i5++)] = j[(i3 | n << 4)];
/* 118 */       arrayOfChar[(i5++)] = j[(i1 << 2 | i8)];
/* 119 */       arrayOfChar[(i5++)] = j[(i4 & 0x3F)];
/*     */     }
/*     */ 
/* 123 */     if (m == 8)
/*     */     {
/* 125 */       n = (byte)((
/* 125 */         i2 = paramArrayOfByte[i6]) & 
/* 125 */         0x3);
/* 126 */       i7 = (i2 & 0xFFFFFF80) == 0 ? (byte)(i2 >> 2) : (byte)(i2 >> 2 ^ 0xC0);
/*     */ 
/* 128 */       arrayOfChar[(i5++)] = j[i7];
/* 129 */       arrayOfChar[(i5++)] = j[(n << 4)];
/* 130 */       arrayOfChar[(i5++)] = '=';
/* 131 */       arrayOfChar[i5] = '=';
/* 132 */     } else if (m == 16) {
/* 133 */       i2 = paramArrayOfByte[i6];
/*     */ 
/* 135 */       i1 = (byte)((
/* 135 */         i3 = paramArrayOfByte[(i6 + 1)]) & 
/* 135 */         0xF);
/* 136 */       n = (byte)(i2 & 0x3);
/*     */ 
/* 138 */       i7 = (i2 & 0xFFFFFF80) == 0 ? (byte)(i2 >> 2) : (byte)(i2 >> 2 ^ 0xC0);
/*     */ 
/* 140 */       i2 = (i3 & 0xFFFFFF80) == 0 ? (byte)(i3 >> 4) : (byte)(i3 >> 4 ^ 0xF0);
/*     */ 
/* 143 */       arrayOfChar[(i5++)] = j[i7];
/* 144 */       arrayOfChar[(i5++)] = j[(i2 | n << 4)];
/* 145 */       arrayOfChar[(i5++)] = j[(i1 << 2)];
/* 146 */       arrayOfChar[i5] = '=';
/*     */     }
/*     */ 
/* 149 */     return new String(arrayOfChar);
/*     */   }
/*     */ 
/*     */   public static byte[] a(String paramString)
/*     */   {
/* 161 */     if (paramString == null)
/* 162 */       return null;
/* 167 */     char[] arrayOfChar;
/* 167 */     int m = 0; int n = arrayOfChar.length; for (int i1 = 0; i1 < n; i1++) if ((((i2 = arrayOfChar[i1]) == ' ') || (i2 == 13) || (i2 == 10) || (i2 == 9) ? 1 : 0) == 0) arrayOfChar[(m++)] = arrayOfChar[i1];
/*     */ 
/* 169 */     if ((
/* 169 */       arrayOfChar = (arrayOfChar = paramString = paramString.toCharArray()) == null ? 
/* 167 */       0 : m) % 
/* 169 */       4 != 0)
/* 170 */       return null;
/*     */     int k;
/* 175 */     if ((
/* 175 */       k = arrayOfChar / 4) == 0)
/*     */     {
/* 176 */       return new byte[0];
/*     */     }
/*     */ 
/* 179 */     n = 0; i1 = 0; int i2 = 0; int i4 = 0;
/*     */ 
/* 181 */     int i6 = 0;
/*     */ 
/* 184 */     int i7 = 0;
/* 185 */     int i8 = 0;
/* 186 */     byte[] arrayOfByte = new byte[k * 3];
/*     */ 
/* 188 */     for (; i6 < k - 1; i6++)
/*     */     {
/* 190 */       if ((!c(n = paramString[(i8++)])) || (!c(i1 = paramString[(i8++)])) || (!c(i2 = paramString[(i8++)])) || (!c(i4 = paramString[(i8++)])))
/*     */       {
/* 194 */         return null;
/*     */       }
/*     */ 
/* 197 */       n = i[n];
/* 198 */       i1 = i[i1];
/* 199 */       i2 = i[i2];
/* 200 */       i4 = i[i4];
/*     */ 
/* 202 */       arrayOfByte[(i7++)] = ((byte)(n << 2 | i1 >> 4));
/* 203 */       arrayOfByte[(i7++)] = ((byte)((i1 & 0xF) << 4 | i2 >> 2 & 0xF));
/* 204 */       arrayOfByte[(i7++)] = ((byte)(i2 << 6 | i4));
/*     */     }
/*     */ 
/* 207 */     if ((!c(n = paramString[(i8++)])) || (!c(i1 = paramString[(i8++)])))
/*     */     {
/* 209 */       return null;
/*     */     }
/*     */ 
/* 212 */     n = i[n];
/* 213 */     i1 = i[i1];
/*     */ 
/* 215 */     i2 = paramString[(i8++)];
/* 216 */     i4 = paramString[i8];
/* 217 */     if ((!c(i2)) || (!c(i4))) {
/* 218 */       if ((b(i2)) && (b(i4))) {
/* 219 */         if ((i1 & 0xF) != 0)
/*     */         {
/* 221 */           return null;
/*     */         }
/* 223 */         paramString = new byte[i6 * 3 + 1];
/* 224 */         System.arraycopy(arrayOfByte, 0, paramString, 0, i6 * 3);
/* 225 */         paramString[i7] = ((byte)(n << 2 | i1 >> 4));
/* 226 */         return paramString;
/* 227 */       }if ((!b(i2)) && (b(i4)))
/*     */       {
/* 229 */         if (((
/* 229 */           i3 = i[i2]) & 
/* 229 */           0x3) != 0)
/*     */         {
/* 231 */           return null;
/*     */         }
/* 233 */         paramString = new byte[i6 * 3 + 2];
/* 234 */         System.arraycopy(arrayOfByte, 0, paramString, 0, i6 * 3);
/* 235 */         paramString[(i7++)] = ((byte)(n << 2 | i1 >> 4));
/* 236 */         paramString[i7] = ((byte)((i1 & 0xF) << 4 | i3 >> 2 & 0xF));
/* 237 */         return paramString;
/*     */       }
/* 239 */       return null;
/*     */     }
/*     */ 
/* 242 */     int i3 = i[i3];
/* 243 */     int i5 = i[i4];
/* 244 */     arrayOfByte[(i7++)] = ((byte)(n << 2 | i1 >> 4));
/* 245 */     arrayOfByte[(i7++)] = ((byte)((i1 & 0xF) << 4 | i3 >> 2 & 0xF));
/* 246 */     arrayOfByte[i7] = ((byte)(i3 << 6 | i5));
/*     */ 
/* 250 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   private static int a(char[] paramArrayOfChar)
/*     */   {
/* 261 */     if (paramArrayOfChar == null) {
/* 262 */       return 0;
/*     */     }
/*     */ 
/* 266 */     int k = 0;
/* 267 */     int m = paramArrayOfChar.length;
/* 268 */     for (int n = 0; n < m; n++)
/*     */     {
/*     */       int i1;
/* 269 */       if ((((i1 = paramArrayOfChar[n]) == ' ') || (i1 == 13) || (i1 == 10) || (i1 == 9) ? 1 : 0) == 0) {
/* 270 */         paramArrayOfChar[(k++)] = paramArrayOfChar[n];
/*     */       }
/*     */     }
/* 273 */     return k;
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  23 */     for (int k = 0; k < 128; k++) {
/*  24 */       i[k] = -1;
/*     */     }
/*  26 */     for (k = 90; k >= 65; k--) {
/*  27 */       i[k] = ((byte)(k - 65));
/*     */     }
/*  29 */     for (k = 122; k >= 97; k--) {
/*  30 */       i[k] = ((byte)(k - 97 + 26));
/*     */     }
/*     */ 
/*  33 */     for (k = 57; k >= 48; k--) {
/*  34 */       i[k] = ((byte)(k - 48 + 52));
/*     */     }
/*     */ 
/*  37 */     i[43] = 62;
/*  38 */     i[47] = 63;
/*     */ 
/*  40 */     for (k = 0; k <= 25; k++) {
/*  41 */       j[k] = ((char)(65 + k));
/*     */     }
/*     */ 
/*  44 */     k = 26; for (int m = 0; k <= 51; m++) {
/*  45 */       j[k] = ((char)(97 + m));
/*     */ 
/*  44 */       k++;
/*     */     }
/*     */ 
/*  48 */     k = 52; for (m = 0; k <= 61; m++) {
/*  49 */       j[k] = ((char)(48 + m));
/*     */ 
/*  48 */       k++;
/*     */     }
/*     */ 
/*  51 */     j[62] = '+';
/*  52 */     j[63] = '/';
/*     */   }
/*     */ }

/* Location:           /Users/xujh/Downloads/WS_MOBILE_PAY_SDK_BASE/移动支付接口SDK2.0标准版(20150121)/DEMO/客户端demo/支付宝移动支付SDK标准版(Android 2.2)/alipay-sdk-common/alipaysdk.jar
 * Qualified Name:     com.alipay.sdk.encrypt.Base64
 * JD-Core Version:    0.6.2
 */