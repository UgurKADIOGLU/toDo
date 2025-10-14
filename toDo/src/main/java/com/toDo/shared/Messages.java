package com.toDo.shared;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
    public static String getMessagesForLocale(String messageKey, Locale locale){
        return ResourceBundle.getBundle("messages",locale).getString(messageKey);
    }
    public static String getMessagesForLocale(String messageKey, Locale locale,Object ... arguments){
        String message=getMessagesForLocale(messageKey,locale);
        return MessageFormat.format(message,arguments);

    }
}
