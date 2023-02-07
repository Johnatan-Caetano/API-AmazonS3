package com.bucketS3.BucketS3;

import com.amazonaws.services.s3.model.Bucket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.nio.file.Paths;
import static com.bucketS3.BucketS3.ObjectsService.*;

import static com.bucketS3.BucketS3.BucketServices.*;

@SpringBootApplication
public class BucketS3Application {

	public static void main(String[] args) {

		//SpringApplication.run(BucketS3Application.class, args);

		//listOfBuckets();

		//String bucket_name = "secund-bucket";
		//Bucket b = getBucket(bucket_name);
		//System.out.println("Info about the bucket: "+b.toString());

		String bucket_name = "secund-bucket";
		Bucket b = createBucket(bucket_name);
		if (b != null) {
			System.out.println(b.toString());
			uploadObject(bucket_name,"Papel de parede Linkedin.jpg");
		}
	}
}
