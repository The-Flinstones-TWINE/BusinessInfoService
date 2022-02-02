package com.twine.businessinfoservice.exceptions;

public class BusinessNotFoundException extends Exception{


        private static final long serialVersionUID = 1L;

    public BusinessNotFoundException(String message) {
            super(message);
        }
    }