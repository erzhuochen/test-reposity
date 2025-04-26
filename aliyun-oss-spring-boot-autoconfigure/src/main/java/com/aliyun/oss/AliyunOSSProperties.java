package com.aliyun.oss;


import org.springframework.boot.context.properties.ConfigurationProperties;




@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {

    private String endpoint;
    private String bucketName;
    private String region;

    public String getEndpoint() {
        return endpoint;
    }

    public String getBucketName() {
        return bucketName;
    }

    public String getRegion() {
        return region;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "AliyunOSSProperties{" +
                "endpoint='" + endpoint + '\'' +
                ", bucketName='" + bucketName + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
