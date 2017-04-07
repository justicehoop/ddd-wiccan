package com.woowahan.wiccan.management.ports.externals.service.impl;

import com.woowahan.wiccan.management.ports.externals.model.AdExportModel;
import com.woowahan.wiccan.management.ports.externals.service.AdImpressionSyncService;
import com.woowahan.wiccan.management.ports.externals.service.dto.AdSyncCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.util.Map;
import java.util.Set;

/**
 * Created by justicehoop on 2017. 4. 7..
 */
@Slf4j
@Service
public class AdImpressionSyncServiceImpl implements AdImpressionSyncService {

    private RestOperations restOperations = new MockRestTemplate();

    public void setRestOperations(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    @Override
    public void sync(AdExportModel ad) {
        log.info("export adInfo to impression service");
        restOperations.put("http://url",ad);
    }

    @Override
    public void syncStatus(AdSyncCommand command) {
        restOperations.put("http://adstatussyncurl", command);
    }

    private static class MockRestTemplate implements RestOperations {

        @Override
        public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType) throws RestClientException {
            return null;
        }

        @Override
        public HttpHeaders headForHeaders(String url, Object... uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public HttpHeaders headForHeaders(String url, Map<String, ?> uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public HttpHeaders headForHeaders(URI url) throws RestClientException {
            return null;
        }

        @Override
        public URI postForLocation(String url, Object request, Object... uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public URI postForLocation(String url, Object request, Map<String, ?> uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public URI postForLocation(URI url, Object request) throws RestClientException {
            return null;
        }

        @Override
        public <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> T postForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> postForEntity(URI url, Object request, Class<T> responseType) throws RestClientException {
            return null;
        }

        @Override
        public void put(String url, Object request, Object... uriVariables) throws RestClientException {

        }

        @Override
        public void put(String url, Object request, Map<String, ?> uriVariables) throws RestClientException {

        }

        @Override
        public void put(URI url, Object request) throws RestClientException {

        }

        @Override
        public void delete(String url, Object... uriVariables) throws RestClientException {

        }

        @Override
        public void delete(String url, Map<String, ?> uriVariables) throws RestClientException {

        }

        @Override
        public void delete(URI url) throws RestClientException {

        }

        @Override
        public Set<HttpMethod> optionsForAllow(String url, Object... uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public Set<HttpMethod> optionsForAllow(String url, Map<String, ?> uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public Set<HttpMethod> optionsForAllow(URI url) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Object... uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, Class<T> responseType) throws RestClientException {
            return null;
        }

        @Override
        public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) throws RestClientException {
            return null;
        }

        @Override
        public <T> T execute(String url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Object... uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> T execute(String url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Map<String, ?> uriVariables) throws RestClientException {
            return null;
        }

        @Override
        public <T> T execute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {
            return null;
        }
    }
}
