package com.RestApiApp.journalApp.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "users")
@Data
@Builder
public class UserEntry {


    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;

    @DBRef
    @Builder.Default
    private List<JournalEntry> journalEntries = new ArrayList<>();
    // journalEntries stores the reference of entries that are stored in journal_entries

    private List<String> role;


}
