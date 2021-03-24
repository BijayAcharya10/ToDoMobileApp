//package com.example.finaltodoapp.model;
//
//import androidx.room.ColumnInfo;
//import androidx.room.Entity;
//import androidx.room.Ignore;
//import androidx.room.PrimaryKey;
//
//import java.util.Date;
//
//@Entity
//public class ETodo {
//    @Ignore
//    public ETodo() {
//    }
//
//    public ETodo(String title, String description, Integer priority, Date taskDate, Boolean isComplete) {
//        this.title = title;
//        this.description = description;
//        this.priority = priority;
//        this.taskDate = taskDate;
//        this.isComplete = isComplete;
//    }
//
//    @ColumnInfo(name="id")
//    @PrimaryKey(autoGenerate = true)
//    Integer id;
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//
//    @ColumnInfo(name = "title")
//    String title;
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    @ColumnInfo(name="description")
//    String description;
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//
//    @ColumnInfo(name="priority")
//    Integer priority;
//    public Integer getPriority() {
//        return priority;
//    }
//
//    public void setPriority(Integer priority) {
//        this.priority = priority;
//    }
//
//
//    @ColumnInfo(name = "taskDate")
//    Date taskDate;
//    public Date getTaskDate() {
//        return taskDate;
//    }
//
//    public void setTaskDate(Date taskDate) {
//        this.taskDate = taskDate;
//    }
//
//    @ColumnInfo(name="isComplete")
//    Boolean isComplete;
//    public Boolean getComplete() {
//        return isComplete;
//    }
//
//    public void setComplete(Boolean complete) {
//        isComplete = complete;
//    }
//
//
//
//
//
//
//
//
//
//
//
//}
