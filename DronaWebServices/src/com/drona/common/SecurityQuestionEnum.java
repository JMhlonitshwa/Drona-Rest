//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common;


public enum SecurityQuestionEnum {
    BirthPlace(1, "What is your birth place?"), 
    FavoriteGame(2, "What is your favorite game?"),
    FavoriteMovie(3, "What is your favorite movie?"), 
    FavoriteSubject(4,"What is your Favorite subject?");

    private long id;

    private String question;

    private SecurityQuestionEnum(long id, String question) {
        this.id = id;
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

}
