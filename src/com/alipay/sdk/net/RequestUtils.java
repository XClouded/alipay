package com.alipay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.data.InteractionData;
import com.alipay.sdk.exception.NetErrorException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

public class RequestUtils
{
    private static MspClient a;

    public static HttpResponse a(Context paramContext, String paramString1, String paramString2, InteractionData paramInteractionData) throws NetErrorException {
        if (a == null)
            a = new MspClient(paramContext, paramString1);
        else if (!TextUtils.equals(paramString1, a.a())) {
            a.a(paramString1);
        }

        if (paramInteractionData != null)
            paramContext = a.a(paramString2, paramInteractionData);
        else {
            paramContext = a.b(paramString2);
        }

        return paramContext;
    }

    public static String a(HttpResponse paramHttpResponse) throws NetErrorException {
        Object localObject1;
        int j = (localObject1 = paramHttpResponse.getStatusLine()).getStatusCode();

        paramHttpResponse = paramHttpResponse.getEntity();
        Object localObject2 = null;
        try {
            localObject2 = paramHttpResponse.getContent();
            if ((((StatusLine)localObject1).getStatusCode() != 200) || (localObject2 == null)) {
                throw new NetErrorException(j + " " + ((StatusLine)localObject1).getReasonPhrase());
            }

            if (((localObject1 = paramHttpResponse.getContentEncoding()) != null) && (((Header)localObject1).getValue().contains("gzip")))
                localObject2 = new GZIPInputStream((InputStream)localObject2);
            int i;
            if ((i = (int)paramHttpResponse.getContentLength()) < 0) {
                i = 4096;
            }

            if ((paramHttpResponse = EntityUtils.getContentCharSet(paramHttpResponse)) == null) {
                paramHttpResponse = "UTF-8";
            }
            paramHttpResponse = new InputStreamReader((InputStream)localObject2, paramHttpResponse);
            CharArrayBuffer localCharArrayBuffer = new CharArrayBuffer(i);
            char[] arrayOfChar = new char[1024];
            int k;
            while ((k = paramHttpResponse.read(arrayOfChar)) != -1) {
                localCharArrayBuffer.append(arrayOfChar, 0, k);
            }
            return localCharArrayBuffer.toString();
        } catch (Exception localException2) {
            throw new NetErrorException();
        } finally {
            try {
            ((InputStream)localObject2).close();
            } catch (Exception localException3) {
            }
        }
        throw paramHttpResponse;
    }

    public static void a() {
        a = null;
    }

}
