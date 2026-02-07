package com.blueworld.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blueworld.model.User;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

@Repository
public class UserRepository {

    @Autowired
    private DynamoDbClient dynamoDbClient;

    private static final String TABLE_NAME = "blueworld-users";

    public void saveUser(User user) {

        Map<String, AttributeValue> item = new HashMap<>();
        item.put("userId", AttributeValue.builder().s(user.getUserId()).build());
        item.put("password", AttributeValue.builder().s(user.getPassword()).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(TABLE_NAME)
                .item(item)
                .build();

        dynamoDbClient.putItem(request);
    }

    public boolean validateUser(String userId, String password) {

        GetItemRequest request = GetItemRequest.builder()
                .tableName(TABLE_NAME)
                .key(Map.of(
                        "userId", AttributeValue.builder().s(userId).build()
                ))
                .build();

        var response = dynamoDbClient.getItem(request);

        return response.hasItem()
                && response.item().get("password").s().equals(password);
    }
}