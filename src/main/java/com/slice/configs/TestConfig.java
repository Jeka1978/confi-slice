package com.slice.configs;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Created by Evegeny on 23/10/2016.
 */
@Profile("DEFAULT")
public class TestConfig {
    @Bean
    public AWSCredentials awsCredentials(){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJE5FY5BSVYHOGEBA", "A3rFf5npeImEWzOPqZ72M2DvXgYdaQtwjiKwy0YZ");
        return credentials;
    }
}
