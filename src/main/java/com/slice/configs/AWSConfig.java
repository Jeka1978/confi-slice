package com.slice.configs;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Evegeny on 23/10/2016.
 */
@Configuration
@ComponentScan(basePackages = "com.slice.dao")
public class AWSConfig {
    @Autowired
    private AWSCredentials awsCredentials;

    @Bean
    @Profile("default")
    public AWSCredentials awsCredentials(){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJE5FY5BSVYHOGEBA", "A3rFf5npeImEWzOPqZ72M2DvXgYdaQtwjiKwy0YZ");
        return credentials;
    }

    @Bean
    public AmazonDynamoDBClient amazonDynamoDBClient() {
        AmazonDynamoDBClient dbClient = new AmazonDynamoDBClient(awsCredentials);
        dbClient.setRegion(Region.getRegion(Regions.DEFAULT_REGION));
        dbClient.setEndpoint("dynamodb.us-west-2.amazonaws.com");
        return dbClient;
    }

    @Bean
    public DynamoDB dynamoDB(){
        return new DynamoDB(amazonDynamoDBClient());
    }

    @Bean
    public DynamoDBMapper dynamoDBMapper(){
        return new DynamoDBMapper(amazonDynamoDBClient());
    }
}
