package com.example.mongodb.services;

import com.example.mongodb.model.Journal;
import com.example.mongodb.repositories.JournalRepository;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

//    public Optional<Journal> getJournalById(String id) {
//        return journalRepository.findById(id);
//    }

    public Journal getJournalById(String id) {
        return journalRepository.findById(id).orElse(null);
    }

    public boolean deleteJournal(String id) {
        boolean exists = journalRepository.existsById(id);
        if (exists) {
            journalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Journal updateJournal(String id, Journal newJournal) {
        Journal exJournal = getJournalById(id);
        if(exJournal != null) {
            if(newJournal.getTitle()!=null) {exJournal.setTitle(newJournal.getTitle());}
            if(newJournal.getAuthor()!=null) {exJournal.setAuthor(newJournal.getAuthor());}
        }
        return journalRepository.save(exJournal);
    }
}
