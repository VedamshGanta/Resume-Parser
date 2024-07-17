package com.example.resume_parser.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ResumeService {

    public Map<String, Integer> processResume(MultipartFile file) throws IOException {
        String text = extractTextFromPDF(file);
        return countWords(text);
    }

    private String extractTextFromPDF(MultipartFile file) throws IOException {
        try (PDDocument document = PDDocument.load(file.getInputStream())) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        }
    }

    private Map<String, Integer> countWords(String text) {
        String[] words = text.toLowerCase().split("\\W+"); // Split text by non-word characters and convert to lower case

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) { // Ignore empty strings
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        return wordCounts;
    }
}
