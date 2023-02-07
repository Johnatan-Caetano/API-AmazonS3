package com.bucketS3.BucketS3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.PutObjectResult;

import static com.bucketS3.BucketS3.AmazonConfig.*;

import java.io.File;
import java.nio.file.Paths;

public class ObjectsService {
    public static boolean uploadObject(String bucketName, String filepath){
        filepath = "/D/Downloads/"+filepath;
        String keyName = Paths.get(filepath).getFileName().toString();
        if(!fileverificationType(filepath)){
            System.err.println("The file is not an image!");
            return false;
        }
        AmazonS3 s3 = s3WithCredentials();
        try{
            PutObjectResult uploading =s3.putObject(bucketName,keyName, new File(filepath));
        }catch (AmazonS3Exception e){
            System.err.println("Message error: "+ e.getMessage());
            System.exit(1);
        }
        return true;
    }

    private static boolean fileverificationType(String filePath){
        String fileName = new File(filePath).getName();

        if (fileName.contains(".png") || fileName.contains(".jpeg")
        || fileName.contains("jpg")){
            System.out.println("The file is an image, the upload will continue.\n");
            return true;
        }
        int positionAfterDot = fileName.lastIndexOf(".");
        System.out.format("The file is not an image (%s). Select an image to continue.\n",
                fileName.substring(positionAfterDot +1));
        System.out.println("You can upload this types of files: png, jpg and jpeg.");
        return false;
    }
}
