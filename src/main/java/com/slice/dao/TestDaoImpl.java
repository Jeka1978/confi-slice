package com.slice.dao;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by Evegeny on 23/10/2016.
 */
@Repository
public class TestDaoImpl implements TestDao {

    public static final String tableName="PERSONS";
    @Autowired
    private DynamoDB dynamoDB;

    @Autowired
    private DynamoDBMapper mapper;

    @Override
    @SneakyThrows
    public void createTable() {
        ArrayList<AttributeDefinition> attributeDefinitions= new ArrayList<>();
        attributeDefinitions.add(new AttributeDefinition().withAttributeName("Id").withAttributeType("S"));

        ArrayList<KeySchemaElement> keySchema = new ArrayList<>();
        keySchema.add(new KeySchemaElement().withAttributeName("Id").withKeyType(KeyType.HASH));

        CreateTableRequest request = new CreateTableRequest()
                .withTableName(tableName)
                .withKeySchema(keySchema)
                .withAttributeDefinitions(attributeDefinitions)
                .withProvisionedThroughput(new ProvisionedThroughput()
                        .withReadCapacityUnits(5L)
                        .withWriteCapacityUnits(6L));

        Table table = dynamoDB.createTable(request);


        table.waitForActive();
    }

    @Override
    public void savePerson(Person person) {
        mapper.save(person);
        System.out.println("person = " + person);
    }

    @Override
    @SneakyThrows
    public void deleteTable() {
        Table table = dynamoDB.getTable(tableName);
        table.delete();
        table.waitForDelete();
    }
}
