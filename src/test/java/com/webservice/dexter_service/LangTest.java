package com.webservice.dexter_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.dexter_service.TestModel.RequestExecutor;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class LangTest {

    @Test
    public void get() {
        /*List<str> langs = null;
        try {
            RequestExecutor requestExecutor = new RequestExecutor();
            HttpUriRequest request = RequestBuilder.get()
                    .setUri("http://localhost:8080/api/admin/lang/getAll")
                    .build();

            Map.Entry<HttpEntity, StatusLine> entity = requestExecutor.executeRequest(request);

            String str = EntityUtils.toString(entity.getKey());
            System.out.println(str);
            ObjectMapper mapper = new ObjectMapper();
            langs = mapper.readValue(str, mapper.getTypeFactory().constructCollectionType(List.class, Lang.class));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        Assert.assertNotNull(langs);
        Assert.assertTrue(!langs.isEmpty());*/
    }

    @Test
    public void createAndUpdate() {
        /*List<Lang> langs = null;
        try {
            RequestExecutor requestExecutor = new RequestExecutor();
            HttpUriRequest request = RequestBuilder.get()
                    .setUri("http://localhost:8080/api/admin/lang/getAll")
                    .build();

            Map.Entry<HttpEntity, StatusLine> entity = requestExecutor.executeRequest(request);

            String str = EntityUtils.toString(entity.getKey());
            System.out.println(str);
            ObjectMapper mapper = new ObjectMapper();
            langs = mapper.readValue(str, mapper.getTypeFactory().constructCollectionType(List.class, Lang.class));
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        Assert.assertNotNull(langs);
        Assert.assertTrue(!langs.isEmpty());*/
    }
}
