package com.todoapp.database;

public class Const {

    // Tables
    public static final String USERS_TABLE = "users";
    public static final String TASKS_TABLE = "tasks";

    // User Table Columns
    public static final String USERS_USERNAME = "username";
    public static final String USERS_PASSWORD = "password";
    public static final String USERS_LAST_NAME = "last_name";
    public static final String USERS_FIRST_NAME = "first_name";

    // Task Table Columns
    public static final String TASKS_USER_ID = "user_id";
    public static final String TASKS_CREATED_AT = "created_at";
    public static final String TASKS_DESCRIPTION = "description";
}
