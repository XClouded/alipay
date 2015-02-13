package com.alipay.sdk.encrypt;

public final class Base64
{
    private static final int a = 128;
    private static final int b = 64;
    private static final int c = 24;
    private static final int d = 8;
    private static final int e = 16;
    private static final int f = 4;
    private static final int g = -128;
    private static final char h = '=';
    private static final byte[] i = new byte[''];
    private static final char[] j = new char[64];

    private static boolean a(char paramChar) {
        return (paramChar == ' ') || (paramChar == '\r') || (paramChar == '\n') || (paramChar == '\t');
    }

    private static boolean b(char paramChar) {
        return paramChar == '=';
    }

    private static boolean c(char paramChar) {
        return (paramChar < '') && (i[paramChar] != -1);
    }

    public static String a(byte[] paramArrayOfByte) {
        if (paramArrayOfByte == null)
            return null;
        int k;
        if ((k = paramArrayOfByte.length * 8) == 0) {
            return "";
        }

        int m = k % 24;
        k /= 24;

        char[] arrayOfChar = new char[(m != 0 ? k + 1 : k) *4];

        int n = 0;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;

        for (int i7 = 0; i7 < k; i7++) {
            i2 = paramArrayOfByte[(i6++)];
            i3 = paramArrayOfByte[(i6++)];
            i4 = paramArrayOfByte[(i6++)];

            i1 = (byte)(i3 & 0xF);
            n = (byte)(i2 & 0x3);

            i2 = (i2 & 0xFFFFFF80) == 0 ? (byte)(i2 >> 2) : (byte)(i2 >> 2 ^ 0xC0);
            i3 = (i3 & 0xFFFFFF80) == 0 ? (byte)(i3 >> 4) : (byte)(i3 >> 4 ^ 0xF0);

            int i8 = (i4 & 0xFFFFFF80) == 0 ? (byte)(i4 >> 6) : (byte)(i4 >> 6 ^ 0xFC);

            arrayOfChar[(i5++)] = j[i2];
            arrayOfChar[(i5++)] = j[(i3 | n << 4)];
            arrayOfChar[(i5++)] = j[(i1 << 2 | i8)];
            arrayOfChar[(i5++)] = j[(i4 & 0x3F)];
        }

        if (m == 8) {
            n = (byte)((i2 = paramArrayOfByte[i6]) & 0x3);
            i7 = (i2 & 0xFFFFFF80) == 0 ? (byte)(i2 >> 2) : (byte)(i2 >> 2 ^ 0xC0);

            arrayOfChar[(i5++)] = j[i7];
            arrayOfChar[(i5++)] = j[(n << 4)];
            arrayOfChar[(i5++)] = '=';
            arrayOfChar[i5] = '=';
        } else if (m == 16) {
            i2 = paramArrayOfByte[i6];

            i1 = (byte)((i3 = paramArrayOfByte[(i6 + 1)]) & 0xF);
            n = (byte)(i2 & 0x3);

            i7 = (i2 & 0xFFFFFF80) == 0 ? (byte)(i2 >> 2) : (byte)(i2 >> 2 ^ 0xC0);
            i2 = (i3 & 0xFFFFFF80) == 0 ? (byte)(i3 >> 4) : (byte)(i3 >> 4 ^ 0xF0);

            arrayOfChar[(i5++)] = j[i7];
            arrayOfChar[(i5++)] = j[(i2 | n << 4)];
            arrayOfChar[(i5++)] = j[(i1 << 2)];
            arrayOfChar[i5] = '=';
        }

        return new String(arrayOfChar);
    }

    public static byte[] a(String paramString) {
        if (paramString == null)
            return null;
        char[] arrayOfChar;
        int m = 0;
        int n = arrayOfChar.length;
        for (int i1 = 0; i1 < n; i1++)
            if ((((i2 = arrayOfChar[i1]) == ' ') || (i2 == 13) || (i2 == 10) || (i2 == 9) ? 1 : 0) == 0)
                arrayOfChar[(m++)] = arrayOfChar[i1];
                if ((arrayOfChar = (arrayOfChar = paramString = paramString.toCharArray()) == null ? 0 : m) % 4 != 0)
                    return null;
                int k;
                if ((k = arrayOfChar / 4) == 0) {
                    return new byte[0];
                }

                n = 0;
                i1 = 0;
                int i2 = 0;
                int i4 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                byte[] arrayOfByte = new byte[k * 3];
                for (; i6 < k - 1; i6++) {
                    if ((!c(n = paramString[(i8++)])) || (!c(i1 = paramString[(i8++)])) || (!c(i2 = paramString[(i8++)])) || (!c(i4 = paramString[(i8++)]))) {
                        return null;
                    }

                    n = i[n];
                    i1 = i[i1];
                    i2 = i[i2];
                    i4 = i[i4];

                    arrayOfByte[(i7++)] = ((byte)(n << 2 | i1 >> 4));
                    arrayOfByte[(i7++)] = ((byte)((i1 & 0xF) << 4 | i2 >> 2 & 0xF));
                    arrayOfByte[(i7++)] = ((byte)(i2 << 6 | i4));
                }

                if ((!c(n = paramString[(i8++)])) || (!c(i1 = paramString[(i8++)]))) {
                    return null;
                }

                n = i[n];
                i1 = i[i1];
                i2 = paramString[(i8++)];
                i4 = paramString[i8];
                if ((!c(i2)) || (!c(i4))) {
                    if ((b(i2)) && (b(i4))) {
                        if ((i1 & 0xF) != 0) {
                            return null;
                        }
                        paramString = new byte[i6 * 3 + 1];
                        System.arraycopy(arrayOfByte, 0, paramString, 0, i6 * 3);
                        paramString[i7] = ((byte)(n << 2 | i1 >> 4));
                        return paramString;
                    }
                    if ((!b(i2)) && (b(i4))) {
                        if (((i3 = i[i2]) & 0x3) != 0) {
                            return null;
                        }
                        paramString = new byte[i6 * 3 + 2];
                        System.arraycopy(arrayOfByte, 0, paramString, 0, i6 * 3);
                        paramString[(i7++)] = ((byte)(n << 2 | i1 >> 4));
                        paramString[i7] = ((byte)((i1 & 0xF) << 4 | i3 >> 2 & 0xF));
                        return paramString;
                    }
                    return null;
                }

                int i3 = i[i3];
                int i5 = i[i4];
                arrayOfByte[(i7++)] = ((byte)(n << 2 | i1 >> 4));
                arrayOfByte[(i7++)] = ((byte)((i1 & 0xF) << 4 | i3 >> 2 & 0xF));
                arrayOfByte[i7] = ((byte)(i3 << 6 | i5));

                return arrayOfByte;
    }

    private static int a(char[] paramArrayOfChar) {
        if (paramArrayOfChar == null) {
            return 0;
        }

        int k = 0;
        int m = paramArrayOfChar.length;
        for (int n = 0; n < m; n++) {
            int i1;
            if ((((i1 = paramArrayOfChar[n]) == ' ') || (i1 == 13) || (i1 == 10) || (i1 == 9) ? 1 : 0) == 0) {
                paramArrayOfChar[(k++)] = paramArrayOfChar[n];
            }
        }
        return k;
    }

    static {
        for (int k = 0; k < 128; k++) {
            i[k] = -1;
        }
        for (k = 90; k >= 65; k--) {
            i[k] = ((byte)(k - 65));
        }
        for (k = 122; k >= 97; k--) {
            i[k] = ((byte)(k - 97 + 26));
        }

        for (k = 57; k >= 48; k--) {
            i[k] = ((byte)(k - 48 + 52));
        }

        i[43] = 62;
        i[47] = 63;

        for (k = 0; k <= 25; k++) {
            j[k] = ((char)(65 + k));
        }

        k = 26;
        for (int m = 0; k <= 51; m++) {
            j[k] = ((char)(97 + m));
            k++;
        }

        k = 52;
        for (m = 0; k <= 61; m++) {
            j[k] = ((char)(48 + m));
            k++;
        }

        j[62] = '+';
        j[63] = '/';
    }
}
