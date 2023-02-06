package com.bucketS3.BucketS3;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonConfig {
    private static final String ACESSS_KEY = "AKIAWOETQVNVSQFP4ZTX";
    private static final String SECRET_KEY = "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";

    @Bean
    public static AmazonS3 s3WithCredentials(){
        AWSCredentials credentials = new BasicAWSCredentials(ACESSS_KEY, SECRET_KEY);
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.DEFAULT_REGION)
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }
}
