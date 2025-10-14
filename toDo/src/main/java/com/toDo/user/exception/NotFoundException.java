package com.toDo.user.exception;

import com.toDo.shared.Messages;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id) {
        super(Messages.getMessagesForLocale("hoxify.constraint.userNotFound", LocaleContextHolder.getLocale(),id));
    }
}
