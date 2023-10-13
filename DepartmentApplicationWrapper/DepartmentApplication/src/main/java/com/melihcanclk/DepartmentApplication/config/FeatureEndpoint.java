package com.melihcanclk.DepartmentApplication.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {
    private Map<String, Feature> featuresMap = new ConcurrentHashMap<>();

    public FeatureEndpoint() {
        featuresMap.put("department", new Feature(true));
        featuresMap.put("User", new Feature(false));
        featuresMap.put("Authentication", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> features() {
        return featuresMap;
    }

    @ReadOperation
    public Feature feature(@Selector String featureName) {
        return featuresMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }

}
