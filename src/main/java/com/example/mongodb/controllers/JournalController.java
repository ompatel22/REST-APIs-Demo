package com.example.mongodb.controllers;

import com.example.mongodb.model.Journal;
import com.example.mongodb.services.JournalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class JournalController {

    final private JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping("/add/journal")
    public ResponseEntity<?> addJournal(@RequestBody Journal journal) {
        return ResponseEntity.ok(journalService.addJournal(journal));
    }

    @GetMapping("/get/journals")
    public ResponseEntity<?> getAllJournals() {
        return ResponseEntity.ok(journalService.getAllJournals());
    }
}
