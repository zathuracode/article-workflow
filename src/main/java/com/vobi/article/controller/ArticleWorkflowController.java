package com.vobi.article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vobi.article.domain.Approval;
import com.vobi.article.domain.Article;
import com.vobi.article.service.ArticleWorkflowService;

@RestController
public class ArticleWorkflowController {
	@Autowired
	private ArticleWorkflowService service;

	@PostMapping("/submit")
	public void submit(@RequestBody Article article) {
		service.startProcess(article);
	}

	@PostMapping("/review")
	public void review(@RequestBody Approval approval) {
		service.submitReview(approval);
	}

	@GetMapping("/tasks")
	public List<Article> getTasks(@RequestParam String assignee) {
		return service.getTasks(assignee);
	}

	@GetMapping("/tasks-list")
	public List<Article> getListTasks() {
		return service.getTasks();
	}

}