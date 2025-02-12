package com.example.mongodb.services;

import com.example.mongodb.model.Journal;
import com.example.mongodb.repositories.JournalRepository;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalService {

    final private JournalRepository journalRepository;

    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public Journal addJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

}
