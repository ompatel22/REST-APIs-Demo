package com.example.mongodb.controllers;

import com.example.mongodb.model.Journal;
import com.example.mongodb.services.JournalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/get/journal/{id}")
    public ResponseEntity<?> getJournalById(@PathVariable("id") String id) {
        return ResponseEntity.ok(journalService.getJournalById(id));
    }

    @DeleteMapping("/delete/journal/{id}")
    public ResponseEntity<?> deleteJournal(@PathVariable("id") String id) {
        return ResponseEntity.ok(journalService.deleteJournal(id));
    }

    @PutMapping("/update/journal/{id}")
    public ResponseEntity<?> updateJournal(@PathVariable("id") String id, @RequestBody Journal journal) {
        return ResponseEntity.ok(journalService.updateJournal(id, journal));
    }
}
