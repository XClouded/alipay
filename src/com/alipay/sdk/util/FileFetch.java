package com.alipay.sdk.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

final class FileFetch implements Runnable
{
    private String a;
    private String b;
    private FileDownloader c;
    private boolean d = false;
    private long e;
    private long f;

    public FileFetch(String paramString1, String paramString2, FileDownloader paramFileDownloader) {
        this.a = paramString1;
        this.b = paramString2;
        this.c = paramFileDownloader;
    }

    public final void run() {
        if ((this.c.a()) && ((this.f <= 0L) || (this.e >= this.f))) {
            this.d = true;
            return;
        }

        FileAccess localFileAccess = new FileAccess();

        while (!this.d) {
            InputStream localInputStream = null;
            int j = 0;
            try {
                Object localObject3;
                try {
                    localHttpGet = new HttpGet(this.a);
                    localObject3 = new DefaultHttpClient();
                    Object localObject1;
                    if (this.c.a()) {
                        localObject1 = "bytes=" + this.e + "-" + this.f;
                        localHttpGet.addHeader("Range", (String)localObject1);
                    }

                    switch (j = (localObject1 = ((HttpClient)localObject3).execute(localHttpGet)).getStatusLine().getStatusCode()) {
                        case 200:
                        case 201:
                        case 202:
                        case 203:
                        case 204:
                        case 205:
                        case 206:
                        case 207:
                            localInputStream = ((HttpResponse)localObject1).getEntity().getContent();
                            break;
                        default:
                            this.d = true;
                    }

                    if (!this.d);
                } catch (IOException localIOException1) {
                    HttpGet localHttpGet = null;
                    localIOException1.printStackTrace();
                    this.d = true;
                }
                if (localInputStream == null) {
                    if (localInputStream != null)
                        try {
                        localInputStream.close();
                        }
                        catch (Exception localException2)
                        {
                        }
                } else {
                    localObject3 = new byte[1024];
                    int k;
                    int i;
                    do
                    {
                        if ((k = localInputStream.read((byte[])localObject3, 0, localObject3.length)) != -1) {
                            this.e += localFileAccess.a((byte[])localObject3, k);
                            this.c.d();
                        }
                        i = (this.c.a()) && (this.e >= this.f) ? 0 : 1;
                        i = (!this.d) && (i != 0) ? 1 : 0;
                    } while ((k >= 0) && (i != 0));
                    this.d = true;

                    if (localInputStream != null)
                        try {
                            localInputStream.close();
                        }
                        catch (Exception localException3)
                        {
                        }
                }
            } catch (SocketTimeoutException localSocketTimeoutException) {
                if (j == 0) {
                    this.d = true;
                }

                if (localInputStream != null)
                    try {
                        localInputStream.close();
                    } catch (Exception localException4) {
                    }
            } catch (IOException localIOException2) {
                this.d = true;
                if (localInputStream != null)
                    try {
                        localInputStream.close();
                    } catch (Exception localException5) {
                    }
            } catch (Exception localException6) {
                this.d = true;
                if (localInputStream != null)
                    try {
                        localInputStream.close();
                    } catch (Exception localException7) {
                    }
            } finally {
                if (localInputStream != null)
                    try {
                        localInputStream.close();
                    } catch (Exception localException8) {
                    }
            }
        }
        localFileAccess.a();
    }

    public final long a() {
        return this.e;
    }

    public final void a(long paramLong) {
        this.e = paramLong;
    }

    public final long b() {
        return this.f;
    }

    public final void b(long paramLong) {
        this.f = paramLong;
    }

    public final boolean c() {
        return this.d;
    }

    public final void d() {
        this.d = true;
    }

    final class FileAccess
    {
        private FileOutputStream b;

        public FileAccess() {
            try {
                this.b = new FileOutputStream(FileFetch.a(FileFetch.this), true);
                return;
            } catch (FileNotFoundException localFileNotFoundException) {
                localFileNotFoundException.printStackTrace();
            }
        }

        public final synchronized int a(byte[] paramArrayOfByte, int paramInt) throws IOException {
            this.b.write(paramArrayOfByte, 0, paramInt);
            return paramInt;
        }

        public final void a() {
            try {
                this.b.close();
                return;
            } catch (Exception localException) {
            }
        }
    }

}
