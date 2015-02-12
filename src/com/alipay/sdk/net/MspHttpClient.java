package com.alipay.sdk.net;

import android.os.Build.VERSION;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public final class MspHttpClient
{
    public static final String a = "msp";
    private static MspHttpClient b;
    private final DefaultHttpClient c;

    private static MspHttpClient d() {
        return b;
    }

    private static void e() {
        b = null;
    }

    private MspHttpClient(HttpParams paramHttpParams) {
        this.c = new DefaultHttpClient(paramHttpParams);
    }

    private MspHttpClient(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams) {
        this.c = new DefaultHttpClient(paramClientConnectionManager, paramHttpParams);
    }

    public static MspHttpClient a() {
        if (b == null) {
            BasicHttpParams localBasicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
            HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, true);
            localBasicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
            ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 50);
            Object localObject = new ConnPerRouteBean(30);
            ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, (ConnPerRoute)localObject);
            ConnManagerParams.setTimeout(localBasicHttpParams, 1000L);
            HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
            HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
            HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 16384);
            HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, false);
            HttpClientParams.setRedirecting(localBasicHttpParams, true);
            HttpClientParams.setAuthenticating(localBasicHttpParams, false);
            HttpProtocolParams.setUserAgent(localBasicHttpParams, "msp");
            try {
                (localObject = SSLSocketFactory.getSocketFactory()).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                localObject = new Scheme("https", (SocketFactory)localObject, 443);
                Scheme localScheme = new Scheme("http", PlainSocketFactory.getSocketFactory(), 80);
                SchemeRegistry localSchemeRegistry;
                (localSchemeRegistry = new SchemeRegistry()).register((Scheme)localObject);
                localSchemeRegistry.register(localScheme);

                localObject = new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry);

                b = new MspHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
            } catch (Exception localException) {
                b = new MspHttpClient(localBasicHttpParams);
            }

        }

        return b;
    }

    private void f() {
        ClientConnectionManager localClientConnectionManager;
        if ((localClientConnectionManager = this.c.getConnectionManager()) != null) {
            localClientConnectionManager.closeExpiredConnections();
            if (Build.VERSION.SDK_INT >= 9) {
                localClientConnectionManager.closeIdleConnections(30L, TimeUnit.MINUTES);
            }
        }
    }

    public final void b() {
        ClientConnectionManager localClientConnectionManager;
        if ((localClientConnectionManager = this.c.getConnectionManager()) != null) {
            localClientConnectionManager.shutdown();
            b = null;
        }
    }

    public final HttpParams c() {
        return this.c.getParams();
    }

    private ClientConnectionManager g() {
        return this.c.getConnectionManager();
    }

    public final HttpResponse a(HttpUriRequest paramHttpUriRequest) throws Exception {
        try {
            return this.c.execute(paramHttpUriRequest); } catch (Exception paramHttpUriRequest) {
        }
        throw new Exception(paramHttpUriRequest);
    }

    private HttpResponse a(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext) throws Exception {
        try {
        return this.c.execute(paramHttpUriRequest, paramHttpContext); } catch (Exception paramHttpUriRequest) {
        }
        throw new Exception(paramHttpUriRequest);
    }

    private HttpResponse a(HttpHost paramHttpHost, HttpRequest paramHttpRequest) throws Exception {
        try {
            paramHttpHost = null; return this.c.execute(paramHttpHost, paramHttpRequest);
        } catch (Exception paramHttpHost) {
        }
        throw new Exception(paramHttpHost);
    }

    private HttpResponse a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext) throws Exception {
        try {
            return this.c.execute(paramHttpHost, paramHttpRequest, paramHttpContext); }
        catch (Exception paramHttpHost) {
        }
        throw new Exception(paramHttpHost);
    }

    private Object a(HttpUriRequest paramHttpUriRequest, ResponseHandler paramResponseHandler) throws Exception {
        try {
            return this.c.execute(paramHttpUriRequest, paramResponseHandler); }
        catch (Exception paramHttpUriRequest) {
        }
        throw new Exception(paramHttpUriRequest);
    }

    private Object a(HttpUriRequest paramHttpUriRequest, ResponseHandler paramResponseHandler, HttpContext paramHttpContext) throws Exception {
        try {
            return this.c.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext); }
        catch (Exception paramHttpUriRequest) {
        }
        throw new Exception(paramHttpUriRequest);
    }

    private Object a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler paramResponseHandler) throws Exception {
        try
        {
            return this.c.execute(paramHttpHost, paramHttpRequest, paramResponseHandler); }
        catch (Exception paramHttpHost) {
        }
        throw new Exception(paramHttpHost);
    }

    private Object a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler paramResponseHandler, HttpContext paramHttpContext) throws Exception {
        try {
            return this.c.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext); }
        catch (Exception paramHttpHost) {
        }
        throw new Exception(paramHttpHost);
    }

}
