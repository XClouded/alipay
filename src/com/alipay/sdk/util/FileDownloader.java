package com.alipay.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.WeakReference;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public final class FileDownloader
{

    private String b;
    private String c;
    private String d;
    private IDownloadProgress e;
    private FileFetch f;
    public boolean a;

    public FileDownloader() {
        this.a = false;
    }

    private FileDownloader(boolean paramBoolean) {
        this.a = paramBoolean;
    }

    public final void a(String paramString) {
        this.b = paramString;
    }

    private void a(boolean paramBoolean) {
        this.a = paramBoolean;
    }

    protected final boolean a() {
        return this.a;
    }

    public final void b(String paramString) {
        this.c = paramString;
        this.d = (paramString + ".tmp");
    }

    public final void a(IDownloadProgress paramIDownloadProgress) {
        if (paramIDownloadProgress != null)
            this.e = paramIDownloadProgress;
    }

    public final void b() {
        final ProgressOutput localProgressOutput = new ProgressOutput(Looper.getMainLooper(), this, (byte)0);

        new Thread(new Runnable() {
            public void run() {
                FileDownloader.a(FileDownloader.this, new FileFetch(FileDownloader.a(FileDownloader.this), FileDownloader.b(FileDownloader.this), FileDownloader.this));
                long l = -1L;
                if (FileDownloader.this.a) {
                    if ((l = FileDownloader.c(FileDownloader.this)) <= 0L) {
                        localProgressOutput.sendEmptyMessage(0);
                    }
                } else {
                    FileDownloader.d(FileDownloader.this);
                }
                if (FileDownloader.this.a) {
                    FileDownloader.e(FileDownloader.this);
                    if (FileDownloader.f(FileDownloader.this).b() != l) {
                        FileDownloader.d(FileDownloader.this);
                        FileDownloader.f(FileDownloader.this).a(0L);
                        FileDownloader.f(FileDownloader.this).b(l);
                    }
                }
                new Thread(FileDownloader.f(FileDownloader.this)).start();
                FileDownloader.ProgressOutput.a(localProgressOutput);
                while (!FileDownloader.f(FileDownloader.this).c()) {
                    try {
                        Thread.sleep(1500L);
                    } catch (InterruptedException localInterruptedException) {
                        localInterruptedException.printStackTrace();
                    }
                    localProgressOutput.sendEmptyMessage(0);
                }
                localProgressOutput.sendEmptyMessage(0);
            }
        }).start();
    }

    public final void c() {
        this.f.d();
    }

    private long e() {
        long l = -1L;
        try {
            l = c(this.b).getContentLength();
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return l;
    }

    private void f() {
        File localFile;
        if ((localFile = new File(this.c)).exists()) {
            localFile.delete();
        }

        if ((localFile = new File(this.d)).exists())
            localFile.delete();
    }

    protected final void d() {
        FileOutputStream localFileOutputStream = null;
        ObjectOutputStream localObjectOutputStream = null;
        try {
            localFileOutputStream = new FileOutputStream(this.d);
            (localObjectOutputStream = new ObjectOutputStream(localFileOutputStream)).writeLong(this.f.a());
            localObjectOutputStream.writeLong(this.f.b());
            localObjectOutputStream.flush();
            try {
                localFileOutputStream.close();
            } catch (Exception localException1) {
            }
            try {
                localObjectOutputStream.close();
            } catch (Exception localException2) {
            }
        } catch (Exception localException3) {
            try {
                localFileOutputStream.close();
            } catch (Exception localException4) {
            }
            try {
                localObjectOutputStream.close();
            } catch (Exception localException5) {
            }
        } finally {
            try {
                localFileOutputStream.close();
            } catch (Exception localException6) {
            }
            try {
                localObjectOutputStream.close();
            } catch (Exception localException7) {
            }
        }
    }

    private void g() {
        FileInputStream localFileInputStream = null;
        ObjectInputStream localObjectInputStream = null;
        try {
            localFileInputStream = new FileInputStream(this.d);
            localObjectInputStream = new ObjectInputStream(localFileInputStream);
            this.f.a(localObjectInputStream.readLong());
            this.f.b(localObjectInputStream.readLong());
            try {
                localFileInputStream.close();
            } catch (Exception localException1) {
            }
            try {
                localObjectInputStream.close();
            }   catch (Exception localException2) {
            }
        } catch (Exception localException3) {
            try {
                localFileInputStream.close();
            } catch (Exception localException4) {
            }
            try {
                localObjectInputStream.close();
            } catch (Exception localException5) {
            }
        } finally {
            try {
                localFileInputStream.close();
            } catch (Exception localException6) {
            }
            try {
                localObjectInputStream.close();
            } catch (Exception localException7) {
            }
        }
    }

    private static HttpEntity c(String paramString) throws Exception {
        try {
            paramString = new HttpGet(paramString);
            int i;
            if ((i = (paramString = new DefaultHttpClient().execute(paramString)).getStatusLine().getStatusCode()) == 200) {
                return paramString.getEntity();
            }
            throw new Exception("net work exception,ErrorCode :" + i);
        } catch (SSLException localSSLException) {
            localSSLException.printStackTrace();
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return null;
    }

    public static abstract interface IDownloadProgress {
        public abstract void b();
        public abstract void a();
        public abstract void c();
    }

    private static class ProgressOutput extends Handler {
        private boolean b;
        WeakReference a;

        private ProgressOutput(Looper paramLooper, FileDownloader paramFileDownloader) {
            super();
            this.b = false;
            this.a = new WeakReference(paramFileDownloader);
        }

        public void handleMessage(Message paramMessage) {
            if (FileDownloader.g((FileDownloader)this.a.get()) == null)
                return;
            try {
                paramMessage = 50.0F;
                if (((FileDownloader)this.a.get()).a) {
                    paramMessage = (float)(FileDownloader.f((FileDownloader)this.a.get()).a() * 100L / FileDownloader.f((FileDownloader)this.a.get()).b());
                } else if (FileDownloader.f((FileDownloader)this.a.get()).c()) {
                    paramMessage = 100.0F;
                }

                if (FileDownloader.f((FileDownloader)this.a.get()).c()) {
                    if ((paramMessage == 100.0F) && (!this.b)) {
                        FileDownloader.g((FileDownloader)this.a.get()).a();
                        this.b = true;
                        return;
                    }
                    if (paramMessage > 100.0F) {
                        FileDownloader.d((FileDownloader)this.a.get());
                        FileDownloader.g((FileDownloader)this.a.get()).c();
                        return;
                    }
                    if (!this.b)
                        FileDownloader.g((FileDownloader)this.a.get()).c();
                } else {
                    FileDownloader.g((FileDownloader)this.a.get()).b();
                }
                return;
            } catch (Exception localException) {
                FileDownloader.g((FileDownloader)this.a.get()).c();
            }
        }
    }
}
