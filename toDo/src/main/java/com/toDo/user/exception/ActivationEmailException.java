package com.toDo.user.exception;

import com.toDo.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

public class ActivationEmailException extends RuntimeException{
    public ActivationEmailException() {
        super(Messages.getMessagesForLocale("hoxify.create.user.email.failure", LocaleContextHolder.getLocale()));
    }
}
