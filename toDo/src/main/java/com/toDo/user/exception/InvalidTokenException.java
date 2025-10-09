package com.toDo.user.exception;

import com.toDo.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

public class InvalidTokenException extends RuntimeException{
    public InvalidTokenException() {
        super(Messages.getMessagesForLocale("hoxify.constraint.invalidtoken", LocaleContextHolder.getLocale()));
    }
}
