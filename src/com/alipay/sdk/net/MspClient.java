package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alipay.sdk.data.InteractionData;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.sys.GlobalContext;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpParams;

public class MspClient
{
    private Context a;
    private String b;

    private MspClient(Context paramContext) {
        this(paramContext, null);
    }

    public MspClient(Context paramContext, String paramString) {
        this.a = paramContext;
        this.b = paramString;
    }

    public final void a(String paramString) {
        this.b = paramString;
    }

    public final String a() {
        return this.b;
    }

    private URL b() {
        URL localURL = null;
        try {
            localURL = new URL(this.b); } catch (Exception localException) {
        }
        return localURL;
    }

    private static ByteArrayEntity a(InteractionData paramInteractionData, String paramString) throws IOException {
        String str = null;
        if (paramInteractionData != null) {
            str = paramInteractionData.b();
            if (!TextUtils.isEmpty(paramInteractionData.c())) {
                paramString = paramInteractionData.c() + "=" + paramString;
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "application/octet-stream;binary/octet-stream";
        }
        paramInteractionData = paramString.getBytes("utf-8");
        (paramInteractionData = new ByteArrayEntity(paramInteractionData)).setContentType(str);
        return paramInteractionData;
    }

    public final HttpResponse b(String paramString) throws NetErrorException {
        return a(paramString, null);
    }

    public final HttpResponse a(String paramString, InteractionData paramInteractionData) throws NetErrorException {
        Object localObject1 = null;
        MspHttpClient localMspHttpClient;
        if ((localMspHttpClient = MspHttpClient.a()) == null) {
            return null;
        }
        try {
            localObject1 = localMspHttpClient.c();
            Object localObject2 = this;
            Object localObject3 = localObject2;
            localObject2 = null;
            Object localObject4;
            if ((localObject3 = ((MspClient)localObject3).b()) != null) {
                String str = ((URL)localObject3).getProtocol();
                "https".equalsIgnoreCase(str);
                localObject3 = System.getProperty("https.proxyHost");
                localObject4 = System.getProperty("https.proxyPort");
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                    localObject2 = new HttpHost((String)localObject3, Integer.parseInt((String)localObject4));
            }
            localObject3 = localObject2;
            localObject2 = null;
            if (((localObject4 = ((MspClient)localObject3).f()) != null) && (((NetworkInfo)localObject4).isAvailable()) && (((NetworkInfo)localObject4).getType() == 0)) {
                localObject3 = Proxy.getDefaultHost();
                int i = Proxy.getDefaultPort();
                if (localObject3 != null)
                    localObject2 = new HttpHost((String)localObject3, i);
            }
            if ((localObject2 = Build.VERSION.SDK_INT >= 11 ? localObject2 : ((localObject4 = ((MspClient)localObject3).g()) != null) && (!((String)localObject4).contains("wap")) ? null : localObject2) != null) {
                ((HttpParams)localObject1).setParameter("http.route.default-proxy", localObject2);
            }
            new StringBuilder("requestUrl : ").append(this.b).toString();

            if (TextUtils.isEmpty(paramString)) {
                localObject1 = new HttpGet(this.b);
            } else {
                localObject1 = new HttpPost(this.b);
                localObject3 = paramString;
                localObject2 = paramInteractionData;
                localObject4 = null;
                if (localObject2 != null) {
                    localObject4 = ((InteractionData)localObject2).b();
                    if (!TextUtils.isEmpty(((InteractionData)localObject2).c()))
                        localObject3 = ((InteractionData)localObject2).c() + "=" + (String)localObject3;
                }
                if (TextUtils.isEmpty((CharSequence)localObject4))
                    localObject4 = "application/octet-stream;binary/octet-stream"; localObject3 = ((String)localObject3).getBytes("utf-8");
                ByteArrayEntity localByteArrayEntity;
                (localByteArrayEntity = new ByteArrayEntity((byte[])localObject3)).setContentType((String)localObject4); paramString = localByteArrayEntity;
                ((HttpPost)localObject1).setEntity(paramString);
                ((HttpUriRequest)localObject1).addHeader("Accept-Charset", "UTF-8");
                ((HttpUriRequest)localObject1).addHeader("Accept-Encoding", "gzip");
                ((HttpUriRequest)localObject1).addHeader("Connection", "Keep-Alive");
                ((HttpUriRequest)localObject1).addHeader("Keep-Alive", "timeout=180, max=100");
            }

            if (paramInteractionData != null) {
                if ((paramString = paramInteractionData.a()) != null) {
                    for (paramString = paramString.iterator(); paramString.hasNext(); ) {
                        paramInteractionData = (Header)paramString.next();
                        ((HttpUriRequest)localObject1).addHeader(paramInteractionData);
                    }
                }
            }
            GlobalContext.a(); GlobalContext.d();

            if (((paramString = (localObject1 = localMspHttpClient.a((HttpUriRequest)localObject1)).getHeaders("X-Hostname")) != null) &&(paramString.length > 0) && (paramString[0] != null)) {
                localObject1.getHeaders("X-Hostname")[0].toString();
            }

            if (((paramString = ((HttpResponse)localObject1).getHeaders("X-ExecuteTime")) != null) && (paramString.length > 0) && (paramString[0] != null)) {
                localObject1.getHeaders("X-ExecuteTime")[0].toString();
            }
        } catch (NetErrorException localNetErrorException) {
            throw localNetErrorException;
        } catch (ConnectTimeoutException localConnectTimeoutException) {
            if (localMspHttpClient != null)
                localMspHttpClient.b();
            throw new NetErrorException();
        } catch (SocketException localSocketException) {
            throw new NetErrorException();
        } catch (SocketTimeoutException localSocketTimeoutException) {
            if (localMspHttpClient != null)
                localMspHttpClient.b();
            throw new NetErrorException();
        } catch (Exception localException) {
            throw new NetErrorException();
        }

        return localObject1;
    }

    private HttpHost c() {
        Object localObject2;
        if (Build.VERSION.SDK_INT >= 11) {
            localObject1 = this; localHttpHost = null;
            if (((localObject2 = ((MspClient)localObject1).g()) != null) && (!((String)localObject2).contains("wap")))
                return null;
            if ((localObject1 = ((MspClient)localObject1).b()) != null) {
                localObject2 = ((URL)localObject1).getProtocol();
                "https".equalsIgnoreCase((String)localObject2);
                localObject1 = System.getProperty("https.proxyHost");
                localObject2 = System.getProperty("https.proxyPort");
                if (!TextUtils.isEmpty((CharSequence)localObject1))
                    localHttpHost = new HttpHost((String)localObject1, Integer.parseInt((String)localObject2));
            }
            return localHttpHost;
        }
        Object localObject1 = this;
        HttpHost localHttpHost = null;
        if (((localObject2 = ((MspClient)localObject1).f()) != null) && (((NetworkInfo)localObject2).isAvailable()) && (((NetworkInfo)localObject2).getType() == 0)) {
            localObject1 = Proxy.getDefaultHost();
            int i = Proxy.getDefaultPort();
            if (localObject1 != null)
                localHttpHost = new HttpHost((String)localObject1, i);
        }
        return localHttpHost;
    }

    private HttpHost d() {
        HttpHost localHttpHost = null;
        Object localObject;
        if (((localObject = f()) != null) && (((NetworkInfo)localObject).isAvailable()) && (((NetworkInfo)localObject).getType() == 0)) {
            localObject = Proxy.getDefaultHost();
            int i = Proxy.getDefaultPort();
            if (localObject != null) {
                localHttpHost = new HttpHost((String)localObject, i);
            }
        }
        return localHttpHost;
    }

    private HttpHost e() {
        HttpHost localHttpHost = null;
        Object localObject;
        if (((localObject = g()) != null) && (!((String)localObject).contains("wap"))) {
            return null;
        }

        if ((localObject = b()) != null) {
            localObject = ((URL)localObject).getProtocol();
            "https".equalsIgnoreCase((String)localObject);
            localObject = System.getProperty("https.proxyHost");
            String str = System.getProperty("https.proxyPort");
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
                localHttpHost = new HttpHost((String)localObject, Integer.parseInt(str));
            }
        }

        return localHttpHost;
    }

    private NetworkInfo f() {
        NetworkInfo localNetworkInfo = null;
        try {
            localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception localException) {
        }
        return localNetworkInfo;
    }

    private String g() {
        try {
            NetworkInfo localNetworkInfo;
            if (((localNetworkInfo = f()) != null) && (localNetworkInfo.isAvailable())) {
                if (localNetworkInfo.getType() == 1) {
                    return "wifi";
                }
                return localNetworkInfo.getExtraInfo().toLowerCase();
            }

            return "none";
        } catch (Exception localException) {

        }
        return "none";
    }

}
