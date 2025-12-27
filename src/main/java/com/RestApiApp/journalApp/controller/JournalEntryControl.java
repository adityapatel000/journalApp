package com.RestApiApp.journalApp.controller;

import com.RestApiApp.journalApp.entity.JournalEntry;
import com.RestApiApp.journalApp.entity.UserEntry;
import com.RestApiApp.journalApp.service.JournalEntryService;
import com.RestApiApp.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryControl {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllGeneralEntriesOfUsers(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        UserEntry user  = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userName = authentication.getName();

            journalEntryService.saveEntry(myEntry, userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myID}")
    public ResponseEntity<JournalEntry> getJournalEntryByID(@PathVariable ObjectId myID){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserEntry byUserName = userService.findByUserName(userName);
        List<JournalEntry> collect = byUserName.getJournalEntries()
                .stream()
                .filter(x -> x.getId().equals(myID)).collect(Collectors.toList());
        if(!collect.isEmpty()){
            Optional<JournalEntry> journalEntry = journalEntryService.findById(myID);
            if(journalEntry.isPresent()){
                return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myID}")
    public ResponseEntity<?> deleteJournalEntryByID(@PathVariable ObjectId myID){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        boolean removed =  journalEntryService.deleteById(myID, userName);
        if(removed){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateJournalByID(@PathVariable ObjectId myId,@RequestBody JournalEntry newEntry){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserEntry byUserName = userService.findByUserName(userName);
        List<JournalEntry> collect = byUserName.getJournalEntries()
                                                .stream()
                                                .filter(x -> x.getId().equals(myId))
                                                .collect(Collectors.toList());

        if(!collect.isEmpty()){
            Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
            if(journalEntry.isPresent()){
                JournalEntry entryOLD = journalEntry.get();
                entryOLD.setTitle(
                        newEntry.getTitle() != null && !newEntry.getTitle().equals("")
                                ? newEntry.getTitle()
                                : entryOLD.getTitle()
                );

                entryOLD.setContent(
                        newEntry.getContent() != null && !newEntry.getContent().equals("")
                                ? newEntry.getContent()
                                : entryOLD.getContent()
                );

                journalEntryService.saveEntry(entryOLD);
                return new ResponseEntity<>(entryOLD, HttpStatus.OK);

            }

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
