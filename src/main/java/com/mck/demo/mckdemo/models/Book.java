package com.mck.demo.mckdemo.models;

import lombok.*;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Book {
    @NonNull @Getter private final String author;
    @NonNull @Getter private final String title;
    @NonNull @Getter private final String ISBN;
}
