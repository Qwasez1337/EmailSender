package com.example.emailService.adapters.inbound;

import com.example.emailService.application.services.ProblemService;
import com.example.emailService.domain.ProblemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class ProblemController {
    private final ProblemService problemService;

    @PostMapping
    public void reportProblem(@RequestBody ProblemRequest problem) {
        problemService.reportProblem(problem);
    }
}
