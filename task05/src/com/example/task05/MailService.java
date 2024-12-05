package com.example.task05;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<IMail<T>> {

    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key)
        {
            return super.getOrDefault(key, Collections.emptyList());
        }
    };

    @Override
    public void accept(IMail<T> from)
    {
        mailBox.computeIfAbsent(from.getTo(), k -> new ArrayList<>()).add(from.getContent());
    }

    public Map<String, List<T>> getMailBox()
    {
        return this.mailBox;
    }
}
