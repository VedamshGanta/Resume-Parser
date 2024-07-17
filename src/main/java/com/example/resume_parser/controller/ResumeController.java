package com.example.resume_parser.controller;

import com.example.resume_parser.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload")
    public ResponseEntity<Map<String, Integer>> uploadResume(@RequestParam("file") MultipartFile file) throws IOException {
        Map<String, Integer> wordCounts = resumeService.processResume(file);
        return ResponseEntity.ok(wordCounts);
    }
}
